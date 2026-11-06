package provider

import (
	"embed"
	"fmt"
	"os"
	"slices"
	"strings"
	"text/template"

	awsbase "github.com/hashicorp/aws-sdk-go-base/v2"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
	pulumirpc "github.com/pulumi/pulumi/sdk/v3/proto/go"
)

//go:embed errors/*.txt
var credentialsErrorFiles embed.FS

// credentialsErrorTemplates holds one template per file in the errors directory, named after the file.
var credentialsErrorTemplates = template.Must(template.ParseFS(credentialsErrorFiles, "errors/*.txt"))

// credentialsErrors maps the failures that the AWS SDK reports to the message shown for them. The first entry
// with a marker that occurs in the diagnostics wins.
var credentialsErrors = []struct {
	markers  []string
	template string
	// hint is set when short-lived credentials may help with the failure, so that the Pulumi CLI can suggest them.
	hint pulumirpc.Hint
}{
	// Normally it'd query sts.REGION.amazonaws.com
	// but if we query sts..amazonaws.com, then we don't have a region.
	{markers: []string{"endpoint rule error, Invalid Configuration: Missing Region"}, template: "no_region.txt"},
	{
		markers:  []string{"no EC2 IMDS role found"},
		template: "no_credentials.txt",
		hint:     pulumirpc.Hint_HINT_DYNAMIC_CREDENTIALS,
	},
	// STS reports long-expired session tokens as invalid, so one message covers both.
	{
		markers: []string{
			"The security token included in the request is invalid",
			"The security token included in the request is expired",
		},
		template: "invalid_credentials.txt",
		hint:     pulumirpc.Hint_HINT_DYNAMIC_CREDENTIALS,
	},
	{markers: []string{"failed to get shared config profile"}, template: "profile_not_found.txt"},
	{markers: []string{"process provider error"}, template: "credential_process.txt"},
	{
		markers:  []string{"login token", "oauth2 token", "login session"},
		template: "expired_login.txt",
		hint:     pulumirpc.Hint_HINT_DYNAMIC_CREDENTIALS,
	},
	{
		markers:  []string{"SSO token", "SSO session"},
		template: "expired_sso.txt",
		hint:     pulumirpc.Hint_HINT_DYNAMIC_CREDENTIALS,
	},
}

const maxListedProfiles = 10

// credentialsErrorData is the data available to the templates in the errors directory.
type credentialsErrorData struct {
	// Profile is the selected profile, or "" when none is selected.
	Profile string
	// Profiles lists the other profiles found in the shared config and credentials files.
	Profiles string
	Cause    string
}

// ProfileLabel names the selected profile in prose.
func (d credentialsErrorData) ProfileLabel() string {
	if d.Profile == "" {
		return "the default profile"
	}
	return fmt.Sprintf("profile %q", d.Profile)
}

// ProfileFlag is the AWS CLI flag that selects the profile, with a leading space, or "" for the default profile.
func (d credentialsErrorData) ProfileFlag() string {
	switch {
	case d.Profile == "":
		return ""
	case strings.ContainsAny(d.Profile, " \t"):
		return fmt.Sprintf(" --profile %q", d.Profile)
	default:
		return " --profile " + d.Profile
	}
}

// credentialsFailure turns the diagnostics of a failed credentials validation into a check failure with an
// actionable message, and the product hint relevant to it, if any.
func credentialsFailure(formattedDiag string, config *awsbase.Config) tfbridge.CheckFailureErrorElement {
	for _, e := range credentialsErrors {
		if !slices.ContainsFunc(e.markers, func(m string) bool { return strings.Contains(formattedDiag, m) }) {
			continue
		}
		// The base library puts generic advice in front of the error it wraps.
		_, cause, ok := strings.Cut(formattedDiag, "Error: ")
		if !ok {
			cause = formattedDiag
		}
		var sb strings.Builder
		err := credentialsErrorTemplates.ExecuteTemplate(&sb, e.template, credentialsErrorData{
			Profile:  config.Profile,
			Profiles: formatProfiles(sharedProfiles(config)),
			Cause:    strings.TrimSpace(cause),
		})
		contract.AssertNoErrorf(err, "failed to render %s", e.template)
		return tfbridge.CheckFailureErrorElement{Reason: sb.String(), Hint: e.hint}
	}
	return tfbridge.CheckFailureErrorElement{
		Reason: fmt.Sprintf("unable to validate AWS credentials.\nDetails: %s\n", formattedDiag),
	}
}

// sharedProfiles returns the names of the profiles defined in the shared config and credentials files, other than
// the default profile.
func sharedProfiles(config *awsbase.Config) []string {
	var profiles []string
	add := func(paths []string, prefix string) {
		for _, path := range paths {
			for _, section := range iniSections(path) {
				profile, ok := strings.CutPrefix(section, prefix)
				profile = strings.TrimSpace(profile)
				if ok && profile != "" && profile != "default" && !slices.Contains(profiles, profile) {
					profiles = append(profiles, profile)
				}
			}
		}
	}
	// The config file prefixes its profile sections, which tells them apart from sections such as `sso-session`.
	add(config.SharedConfigFiles, "profile ")
	add(config.SharedCredentialsFiles, "")
	return profiles
}

// iniSections returns the section names of an INI file, or nil if it cannot be read.
func iniSections(path string) []string {
	content, err := os.ReadFile(path)
	if err != nil {
		return nil
	}
	var sections []string
	for line := range strings.Lines(string(content)) {
		line = strings.TrimSpace(line)
		if strings.HasPrefix(line, "[") && strings.HasSuffix(line, "]") {
			sections = append(sections, strings.TrimSpace(line[1:len(line)-1]))
		}
	}
	return sections
}

func formatProfiles(profiles []string) string {
	if len(profiles) > maxListedProfiles {
		return fmt.Sprintf("%s and %d more",
			strings.Join(profiles[:maxListedProfiles], ", "), len(profiles)-maxListedProfiles)
	}
	return strings.Join(profiles, ", ")
}
