package provider

import (
	"context"
	"log"
	"os"
	"os/exec"
	"strings"
	"time"

	"github.com/blang/semver"
	awsbase "github.com/hashicorp/aws-sdk-go-base/v2"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
)

// awsSignInCommand is an AWS CLI command that signs in, which the credentials errors recommend for some failures.
type awsSignInCommand struct {
	// args are the AWS CLI arguments that sign in, before the flags added for the user's configuration.
	args []string
	// minVersion is the first AWS CLI release with the command.
	minVersion semver.Version
	// takesRegion is whether the command asks for a region unless it is given one.
	takesRegion bool
	// noBrowserFlag makes the command sign in on another device when there is no local browser.
	noBrowserFlag string
}

var (
	// awsLogin signs in through the browser with the user's AWS console credentials.
	awsLogin = &awsSignInCommand{
		args: []string{"login"}, minVersion: semver.MustParse("2.32.0"),
		takesRegion: true, noBrowserFlag: "--remote",
	}
	// awsSSOLogin refreshes the SSO session of a profile.
	awsSSOLogin = &awsSignInCommand{
		args: []string{"sso", "login"}, minVersion: semver.MustParse("2.0.0"),
		noBrowserFlag: "--no-browser",
	}
)

// awsCLIProgram is the program name of the AWS CLI, which is looked up on PATH.
const awsCLIProgram = "aws"

// awsCLIVersionTimeout bounds how long `aws --version` may take before no sign-in is offered.
const awsCLIVersionTimeout = 10 * time.Second

// awsCLI is the part of the machine that decides whether an AWS CLI sign-in can be offered.
type awsCLI struct {
	// version returns the output of `aws --version`, or an error if the AWS CLI cannot be run.
	version func(ctx context.Context) ([]byte, error)
	getenv  func(key string) string
}

// systemAWSCLI runs the AWS CLI found on PATH.
var systemAWSCLI = awsCLI{
	version: func(ctx context.Context) ([]byte, error) {
		ctx, cancel := context.WithTimeout(ctx, awsCLIVersionTimeout)
		defer cancel()
		// This fails when the AWS CLI is not on PATH.
		return exec.CommandContext(ctx, awsCLIProgram, "--version").Output()
	},
	getenv: os.Getenv,
}

// parseAWSCLIVersion parses the output of `aws --version`, such as
// "aws-cli/2.32.0 Python/3.13.9 Darwin/24.6.0 source/arm64".
func parseAWSCLIVersion(output []byte) (semver.Version, bool) {
	fields := strings.Fields(string(output))
	if len(fields) == 0 {
		return semver.Version{}, false
	}
	version, ok := strings.CutPrefix(fields[0], "aws-cli/")
	if !ok {
		return semver.Version{}, false
	}
	v, err := semver.ParseTolerant(version)
	return v, err == nil
}

// remediation returns the sign-in for the profile and region of config as a remediation that the engine can offer
// to run. It returns false when the AWS CLI on this machine cannot run the command.
func (c *awsSignInCommand) remediation(
	ctx context.Context, cli awsCLI, config *awsbase.Config,
) (tfbridge.CommandRemediation, bool) {
	out, err := cli.version(ctx)
	if version, ok := parseAWSCLIVersion(out); err != nil || !ok || version.LT(c.minVersion) {
		log.Printf("[DEBUG] pulumi-aws: not offering `aws %s`: AWS CLI version %q, error: %v",
			strings.Join(c.args, " "), strings.TrimSpace(string(out)), err)
		return tfbridge.CommandRemediation{}, false
	}

	command := append([]string{awsCLIProgram}, c.args...)
	if config.Profile != "" {
		command = append(command, "--profile", config.Profile)
	}
	if c.takesRegion && config.Region != "" {
		command = append(command, "--region", config.Region)
	}
	if cli.getenv("SSH_CONNECTION") != "" || cli.getenv("SSH_TTY") != "" {
		command = append(command, c.noBrowserFlag)
	}
	return tfbridge.CommandRemediation{
		Description: "Sign in to AWS",
		Command:     command,
		// `aws login` otherwise follows a successful sign-in with an offer to set up AI coding agents.
		Env: map[string]string{"AWS_CLI_AGENT_TOOLKIT_HINT_DISABLED": "true"},
	}, true
}
