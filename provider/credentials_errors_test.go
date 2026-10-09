package provider

import (
	"os"
	"path/filepath"
	"strings"
	"testing"

	awsbase "github.com/hashicorp/aws-sdk-go-base/v2"
	"github.com/stretchr/testify/require"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

const (
	escHint = "NEW: You can use Pulumi ESC to set up dynamic credentials with AWS OIDC to ensure the correct and " +
		"valid credentials are used.\nLearn more: https://www.pulumi.com/registry/packages/aws/" +
		"installation-configuration/#dynamically-generate-credentials-via-pulumi-esc"
	docsHint = "Please see https://www.pulumi.com/registry/packages/aws/installation-configuration/ for more " +
		"information about providing credentials."
	loginHint = "To sign in through your browser, run `aws login` (requires AWS CLI 2.32.0 or later) and try again."

	testLoginProfile = "[profile myproj]\nlogin_session = arn:aws:iam::123456789012:user/test\n"
	testSSOProfile   = "[profile corp]\nsso_session = corp\nsso_account_id = 123456789012\nsso_role_name = Dev\n" +
		"[sso-session corp]\nsso_start_url = https://example.awsapps.com/start\nsso_region = us-west-2\n"
)

// isolateAWSEnv points the AWS SDK at an empty home directory and clears the AWS environment, so that the test
// only sees the shared config and credentials it writes. It returns the paths of those two files.
func isolateAWSEnv(t *testing.T, config, credentials string) (configPath, credentialsPath string) {
	t.Helper()
	for _, kv := range os.Environ() {
		if name, _, _ := strings.Cut(kv, "="); strings.HasPrefix(name, "AWS_") {
			t.Setenv(name, "")
			require.NoError(t, os.Unsetenv(name))
		}
	}
	home := t.TempDir()
	t.Setenv("HOME", home)
	t.Setenv("AWS_LOGIN_CACHE_DIRECTORY", filepath.Join(home, "login"))
	t.Setenv("AWS_EC2_METADATA_DISABLED", "true")

	configPath = filepath.Join(home, "config")
	credentialsPath = filepath.Join(home, "credentials")
	require.NoError(t, os.WriteFile(configPath, []byte(config), 0o600))
	require.NoError(t, os.WriteFile(credentialsPath, []byte(credentials), 0o600))
	return configPath, credentialsPath
}

// TestValidateCredentialsErrorMessages exercises the failures that the AWS SDK reports without any network access.
func TestValidateCredentialsErrorMessages(t *testing.T) {
	tests := []struct {
		name        string
		config      string
		credentials string
		profile     string
		expected    string
	}{
		{
			name:     "no credentials",
			expected: "No valid credential sources found.\n" + loginHint + "\n" + docsHint + "\n" + escHint,
		},
		{
			name:        "profiles configured but none selected",
			config:      testLoginProfile + testSSOProfile,
			credentials: "[legacy]\naws_access_key_id = AKIAEXAMPLE\naws_secret_access_key = example\n",
			expected: "No valid credential sources found.\n" +
				"No AWS profile is selected, but these profiles are configured: myproj, corp, legacy.\n" +
				"To use one, run `pulumi config set aws:profile <name>` or set AWS_PROFILE.\n" +
				loginHint + "\n" + docsHint + "\n" + escHint,
		},
		{
			name:    "login session not signed in",
			config:  testLoginProfile,
			profile: "myproj",
			expected: "The AWS login session for profile \"myproj\" has expired or was not found.\n" +
				"Run `aws login --profile myproj` to sign in again, then retry.",
		},
		{
			name:   "default profile login session not signed in",
			config: "[default]\nlogin_session = arn:aws:iam::123456789012:user/test\n",
			expected: "The AWS login session for the default profile has expired or was not found.\n" +
				"Run `aws login` to sign in again, then retry.",
		},
		{
			name:    "SSO session not signed in",
			config:  testSSOProfile,
			profile: "corp",
			expected: "The AWS SSO session for profile \"corp\" has expired or was not found.\n" +
				"Run `aws sso login --profile corp` to sign in again, then retry.\n" + escHint,
		},
		{
			name: "legacy SSO profile not signed in",
			config: "[profile old]\nsso_start_url = https://example.awsapps.com/start\nsso_region = us-west-2\n" +
				"sso_account_id = 123456789012\nsso_role_name = Dev\n",
			profile: "old",
			expected: "The AWS SSO session for profile \"old\" has expired or was not found.\n" +
				"Run `aws sso login --profile old` to sign in again, then retry.\n" + escHint,
		},
		{
			name:    "profile not found",
			config:  testLoginProfile,
			profile: "nope",
			expected: "The AWS profile \"nope\" was not found.\n" +
				"Configured profiles: myproj.\n" +
				"Check the `aws:profile` configuration and the AWS_PROFILE environment variable.",
		},
		{
			name:   "credential_process fails",
			config: "[default]\ncredential_process = sh -c 'exit 1'\n",
			expected: "The credential_process configured for the default profile failed.\n" +
				"Details: failed to refresh cached credentials, process provider error: " +
				"error in credential_process: exit status 1",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			configPath, credentialsPath := isolateAWSEnv(t, tt.config, tt.credentials)
			vars := resource.PropertyMap{
				"region":                resource.NewProperty("us-west-2"),
				"sharedConfigFile":      resource.NewProperty(configPath),
				"sharedCredentialsFile": resource.NewProperty(credentialsPath),
			}
			if tt.profile != "" {
				vars["profile"] = resource.NewProperty(tt.profile)
			}

			err := validateCredentials(vars, nil)

			var failure tfbridge.CheckFailureError
			require.ErrorAs(t, err, &failure)
			require.Len(t, failure.Failures, 1)
			require.Equal(t, tt.expected, failure.Failures[0].Reason)
		})
	}
}

// TestCredentialsFailureReason covers the failures that only arise from a response of an AWS service.
func TestCredentialsFailureReason(t *testing.T) {
	const refresh = "No valid credential sources found. Error: failed to refresh cached credentials, "
	tests := []struct {
		name     string
		diag     string
		profile  string
		expected string
	}{
		{
			name: "login session expired",
			diag: refresh + "create oauth2 token: operation error Signin: CreateOAuth2Token, https response error " +
				"StatusCode: 400, ValidationException: The provided authorization grant is invalid, expired, " +
				"revoked, or malformed",
			profile: "myproj",
			expected: "The AWS login session for profile \"myproj\" has expired or was not found.\n" +
				"Run `aws login --profile myproj` to sign in again, then retry.",
		},
		{
			name: "SSO token expired",
			diag: refresh + "refresh cached SSO token failed, unable to refresh SSO token, operation error " +
				"SSO OIDC: CreateToken, https response error StatusCode: 400, InvalidGrantException: ",
			profile: "corp",
			expected: "The AWS SSO session for profile \"corp\" has expired or was not found.\n" +
				"Run `aws sso login --profile corp` to sign in again, then retry.\n" + escHint,
		},
		{
			name: "invalid credentials",
			diag: "validating provider credentials: retrieving caller identity from STS: operation error STS: " +
				"GetCallerIdentity, https response error StatusCode: 403, api error InvalidClientTokenId: " +
				"The security token included in the request is invalid.",
			expected: "The configured AWS credentials are invalid or have expired.\n" + docsHint + "\n" + escHint,
		},
		{
			name: "expired credentials",
			diag: "validating provider credentials: retrieving caller identity from STS: operation error STS: " +
				"GetCallerIdentity, https response error StatusCode: 403, api error ExpiredToken: " +
				"The security token included in the request is expired",
			expected: "The configured AWS credentials are invalid or have expired.\n" + docsHint + "\n" + escHint,
		},
		{
			name: "refresh failure that only mentions an SSO role",
			diag: refresh + "operation error STS: AssumeRole, AccessDenied: User: arn:aws:sts::123456789012:" +
				"assumed-role/AWSReservedSSO_Dev_0123456789abcdef/me is not authorized to perform: sts:AssumeRole",
			expected: "unable to validate AWS credentials.\n" +
				"Details: " + refresh + "operation error STS: AssumeRole, AccessDenied: User: " +
				"arn:aws:sts::123456789012:assumed-role/AWSReservedSSO_Dev_0123456789abcdef/me is not authorized " +
				"to perform: sts:AssumeRole\n",
		},
		{
			name: "unrecognized refresh failure",
			diag: refresh + "something new",
			expected: "unable to validate AWS credentials.\n" +
				"Details: " + refresh + "something new\n",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			actual := credentialsFailureReason(tt.diag, &awsbase.Config{Profile: tt.profile})
			require.Equal(t, tt.expected, actual)
		})
	}
}

func TestCredentialsErrorTemplatesExist(t *testing.T) {
	for _, e := range credentialsErrors {
		require.NotNilf(t, credentialsErrorTemplates.Lookup(e.template), "missing template %s", e.template)
	}
}

func TestProfileFlag(t *testing.T) {
	require.Equal(t, "", credentialsErrorData{}.ProfileFlag())
	require.Equal(t, " --profile dev", credentialsErrorData{Profile: "dev"}.ProfileFlag())
	require.Equal(t, ` --profile "my dev"`, credentialsErrorData{Profile: "my dev"}.ProfileFlag())
}

func TestFormatProfiles(t *testing.T) {
	profiles := []string{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"}
	require.Equal(t, "a, b", formatProfiles(profiles[:2]))
	require.Equal(t, "a, b, c, d, e, f, g, h, i, j and 2 more", formatProfiles(profiles))
}
