package provider

import (
	"context"
	"errors"
	"testing"

	awsbase "github.com/hashicorp/aws-sdk-go-base/v2"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

const (
	supportedAWSCLI = "aws-cli/2.38.2 Python/3.15.0 Darwin/24.6.0 source/arm64\n"
	// tooOldForLogin predates `aws login` but has `aws sso login`.
	tooOldForLogin = "aws-cli/2.31.0 Python/3.13.7 Linux/6.8.0 exe/x86_64\n"
)

// fakeAWSCLI is an AWS CLI whose `aws --version` prints version, or fails with err, on a machine whose environment
// is env.
func fakeAWSCLI(version string, err error, env ...string) awsCLI {
	vars := map[string]string{}
	for i := 0; i+1 < len(env); i += 2 {
		vars[env[i]] = env[i+1]
	}
	return awsCLI{
		version: func(context.Context) ([]byte, error) { return []byte(version), err },
		getenv:  func(key string) string { return vars[key] },
	}
}

// signInRemediation is the remediation that runs command.
func signInRemediation(command ...string) tfbridge.CommandRemediation {
	return tfbridge.CommandRemediation{
		Description: "Sign in to AWS",
		Command:     command,
		Env:         map[string]string{"AWS_CLI_AGENT_TOOLKIT_HINT_DISABLED": "true"},
		Interactive: true,
	}
}

func TestParseAWSCLIVersion(t *testing.T) {
	t.Parallel()

	tests := []struct {
		output  string
		version string // empty when the output cannot be parsed
	}{
		{"aws-cli/2.32.0 Python/3.13.9 Darwin/24.6.0 source/arm64\n", "2.32.0"},
		{"aws-cli/2.38.2 Python/3.15.0 Darwin/24.6.0 source/arm64", "2.38.2"},
		{"aws-cli/1.40.0 Python/3.12.0 Linux/6.8.0 botocore/1.38.0", "1.40.0"},
		{"command not found", ""},
		{"", ""},
	}
	for _, tt := range tests {
		v, ok := parseAWSCLIVersion([]byte(tt.output))
		assert.Equal(t, tt.version != "", ok, tt.output)
		if ok {
			assert.Equal(t, tt.version, v.String())
		}
	}
}

func TestSignInRemediation(t *testing.T) {
	t.Parallel()

	tests := []struct {
		name    string
		signIn  *awsSignInCommand
		config  awsbase.Config
		cli     awsCLI
		command []string // nil when no remediation is offered
	}{
		{
			name:    "nothing configured",
			signIn:  awsLogin,
			cli:     fakeAWSCLI(supportedAWSCLI, nil),
			command: []string{"aws", "login"},
		},
		{
			name:    "profile and region",
			signIn:  awsLogin,
			config:  awsbase.Config{Profile: "myproj", Region: "us-west-2"},
			cli:     fakeAWSCLI(supportedAWSCLI, nil),
			command: []string{"aws", "login", "--profile", "myproj", "--region", "us-west-2"},
		},
		{
			name:    "profile with a space is one argument",
			signIn:  awsLogin,
			config:  awsbase.Config{Profile: "my proj"},
			cli:     fakeAWSCLI(supportedAWSCLI, nil),
			command: []string{"aws", "login", "--profile", "my proj"},
		},
		{
			name:    "remote over SSH",
			signIn:  awsLogin,
			cli:     fakeAWSCLI(supportedAWSCLI, nil, "SSH_CONNECTION", "10.0.0.1 51234 10.0.0.2 22"),
			command: []string{"aws", "login", "--remote"},
		},
		{
			name:    "SSO takes the profile but not the region",
			signIn:  awsSSOLogin,
			config:  awsbase.Config{Profile: "corp", Region: "us-west-2"},
			cli:     fakeAWSCLI(supportedAWSCLI, nil),
			command: []string{"aws", "sso", "login", "--profile", "corp"},
		},
		{
			name:    "SSO without a browser over SSH",
			signIn:  awsSSOLogin,
			config:  awsbase.Config{Profile: "corp"},
			cli:     fakeAWSCLI(supportedAWSCLI, nil, "SSH_TTY", "/dev/ttys001"),
			command: []string{"aws", "sso", "login", "--profile", "corp", "--no-browser"},
		},
		{
			name:    "SSO with an AWS CLI that predates aws login",
			signIn:  awsSSOLogin,
			cli:     fakeAWSCLI(tooOldForLogin, nil),
			command: []string{"aws", "sso", "login"},
		},
		{
			name:   "AWS CLI too old for aws login",
			signIn: awsLogin,
			cli:    fakeAWSCLI(tooOldForLogin, nil),
		},
		{
			name:   "AWS CLI v1",
			signIn: awsSSOLogin,
			cli:    fakeAWSCLI("aws-cli/1.40.0 Python/3.12.0 Linux/6.8.0 botocore/1.38.0", nil),
		},
		{
			name:   "AWS CLI not installed",
			signIn: awsLogin,
			cli:    fakeAWSCLI("", errors.New(`exec: "aws": executable file not found in $PATH`)),
		},
		{
			name:   "unrecognized version output",
			signIn: awsLogin,
			cli:    fakeAWSCLI("something else 2.40.0", nil),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			t.Parallel()

			r, ok := tt.signIn.remediation(t.Context(), tt.cli, &tt.config)
			if tt.command == nil {
				assert.False(t, ok)
				return
			}
			require.True(t, ok)
			assert.Equal(t, signInRemediation(tt.command...), r)
		})
	}
}

// TestSignInRemediationSettings checks that the sign-in uses the profile and region that the provider resolves from
// its configuration and the environment.
func TestSignInRemediationSettings(t *testing.T) {
	tests := []struct {
		name    string
		vars    resource.PropertyMap
		env     map[string]string
		command []string
	}{
		{
			name:    "environment",
			env:     map[string]string{"AWS_PROFILE": "myproj", "AWS_DEFAULT_REGION": "eu-west-1"},
			command: []string{"aws", "login", "--profile", "myproj", "--region", "eu-west-1"},
		},
		{
			name:    "AWS_REGION takes precedence over AWS_DEFAULT_REGION",
			env:     map[string]string{"AWS_REGION": "eu-central-1", "AWS_DEFAULT_REGION": "eu-west-1"},
			command: []string{"aws", "login", "--region", "eu-central-1"},
		},
		{
			name: "configuration takes precedence over the environment",
			vars: resource.PropertyMap{
				"profile": resource.NewProperty("myproj"),
				"region":  resource.NewProperty("us-west-2"),
			},
			env:     map[string]string{"AWS_PROFILE": "other", "AWS_REGION": "eu-west-1"},
			command: []string{"aws", "login", "--profile", "myproj", "--region", "us-west-2"},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			configPath, credentialsPath := isolateAWSEnv(t, testLoginProfile, "")
			for k, v := range tt.env {
				t.Setenv(k, v)
			}
			vars := resource.PropertyMap{
				"sharedConfigFiles": resource.NewProperty([]resource.PropertyValue{
					resource.NewProperty(configPath),
				}),
				"sharedCredentialsFiles": resource.NewProperty([]resource.PropertyValue{
					resource.NewProperty(credentialsPath),
				}),
			}
			for k, v := range tt.vars {
				vars[k] = v
			}

			err := validateCredentialsWith(vars, fakeAWSCLI(supportedAWSCLI, nil))

			var failure tfbridge.CheckFailureError
			require.ErrorAs(t, err, &failure)
			require.Len(t, failure.Failures, 1)
			require.Equal(t, []tfbridge.CommandRemediation{signInRemediation(tt.command...)},
				failure.Failures[0].Remediations, failure.Failures[0].Reason)
		})
	}
}
