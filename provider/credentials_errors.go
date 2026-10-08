package provider

import (
	"bufio"
	_ "embed"
	"fmt"
	"os"
	"slices"
	"strings"
	"text/template"

	awsbase "github.com/hashicorp/aws-sdk-go-base/v2"

	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

//go:embed errors/no_credentials.txt
var noCredentialsError string

//go:embed errors/invalid_credentials.txt
var invalidCredentialsError string

//go:embed errors/no_region.txt
var noRegionError string

//go:embed errors/expired_sso.txt
var expiredSSOError string

//go:embed errors/expired_login.txt
var expiredLoginError string

//go:embed errors/expired_credentials.txt
var expiredCredentialsError string

//go:embed errors/credential_process.txt
var credentialProcessError string

//go:embed errors/profile_not_found.txt
var profileNotFoundError string

// maxListedProfiles bounds how many profile names an error message lists.
const maxListedProfiles = 10

// credentialsErrorData is the data available to the error message templates in the errors directory.
type credentialsErrorData struct {
	// Profile is the selected profile, or "" when none is selected.
	Profile string
	// ProfileLabel names the selected profile in prose.
	ProfileLabel string
	// ProfileFlag is the AWS CLI flag selecting the profile, with a leading space, or "".
	ProfileFlag string
	// Profiles lists the profiles found in the shared config and credentials files.
	Profiles string
	// Details is the underlying error.
	Details string
}

// credentialsFailureReason turns the diagnostics of a failed credentials validation into an actionable message.
func credentialsFailureReason(formattedDiag string, config *awsbase.Config) string {
	data := credentialsErrorData{
		Profile:      config.Profile,
		ProfileLabel: "the default profile",
		Details:      formattedDiag,
	}
	if config.Profile != "" {
		data.ProfileLabel = fmt.Sprintf("profile %q", config.Profile)
		data.ProfileFlag = " --profile " + config.Profile
	}
	contains := func(substrs ...string) bool {
		return slices.ContainsFunc(substrs, func(s string) bool { return strings.Contains(formattedDiag, s) })
	}

	switch {
	// Normally it'd query sts.REGION.amazonaws.com
	// but if we query sts..amazonaws.com, then we don't have a region.
	case contains("endpoint rule error, Invalid Configuration: Missing Region"):
		return noRegionError
	case contains("no EC2 IMDS role found"):
		if config.Profile == "" {
			data.Profiles = formatProfiles(sharedProfiles(config))
		}
		return renderCredentialsError(noCredentialsError, data)
	case contains("The security token included in the request is invalid"):
		return invalidCredentialsError
	case contains("The security token included in the request is expired"):
		return expiredCredentialsError
	case contains("failed to get shared config profile"):
		data.Profiles = formatProfiles(sharedProfiles(config))
		return renderCredentialsError(profileNotFoundError, data)
	// The remaining cases tell apart the credential sources that can fail to refresh.
	case !contains("failed to refresh cached credentials"):
	case contains("process provider error"):
		// Drop the generic advice that precedes the error of the process.
		if _, details, ok := strings.Cut(formattedDiag, "Error: "); ok {
			data.Details = strings.TrimSpace(details)
		}
		return renderCredentialsError(credentialProcessError, data)
	case contains("login token", "oauth2 token", "login session"):
		return renderCredentialsError(expiredLoginError, data)
	case contains("SSO"):
		return renderCredentialsError(expiredSSOError, data)
	}
	return fmt.Sprintf("unable to validate AWS credentials.\nDetails: %s\n", formattedDiag)
}

func renderCredentialsError(text string, data credentialsErrorData) string {
	var sb strings.Builder
	err := template.Must(template.New("error").Parse(text)).Execute(&sb, data)
	contract.AssertNoErrorf(err, "failed to render credentials error")
	return sb.String()
}

// sharedProfiles returns the names of the profiles defined in the shared config and credentials files, other than
// the default profile.
func sharedProfiles(config *awsbase.Config) []string {
	var profiles []string
	add := func(path string, name func(section string) (string, bool)) {
		f, err := os.Open(path)
		if err != nil {
			return
		}
		defer contract.IgnoreClose(f)
		for scanner := bufio.NewScanner(f); scanner.Scan(); {
			line := strings.TrimSpace(scanner.Text())
			if !strings.HasPrefix(line, "[") || !strings.HasSuffix(line, "]") {
				continue
			}
			profile, ok := name(strings.TrimSpace(line[1 : len(line)-1]))
			if ok && profile != "default" && !slices.Contains(profiles, profile) {
				profiles = append(profiles, profile)
			}
		}
	}
	for _, path := range config.SharedConfigFiles {
		// Other sections, such as `sso-session`, are not profiles.
		add(path, func(section string) (string, bool) {
			profile, ok := strings.CutPrefix(section, "profile ")
			return strings.TrimSpace(profile), ok
		})
	}
	for _, path := range config.SharedCredentialsFiles {
		add(path, func(section string) (string, bool) { return section, section != "" })
	}
	return profiles
}

func formatProfiles(profiles []string) string {
	if len(profiles) > maxListedProfiles {
		return fmt.Sprintf("%s and %d more",
			strings.Join(profiles[:maxListedProfiles], ", "), len(profiles)-maxListedProfiles)
	}
	return strings.Join(profiles, ", ")
}
