// Copyright 2016-2023, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package provider

import (
	"context"
	"os"
	"strings"
	"testing"
	"time"

	testutils "github.com/pulumi/providertest/replay"
	pfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	"github.com/stretchr/testify/require"

	version "github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

func TestCheckConfigWithUnknownKeys(t *testing.T) {
	replaySequence(t, strings.ReplaceAll(`
	[{
	  "method": "/pulumirpc.ResourceProvider/CheckConfig",
	  "request": {
	    "urn": "urn:pulumi:dev::aws-2880::pulumi:providers:aws::default_6_5_0",
	    "olds": {},
	    "news": {
              "unknownKey": "injected",
	      "accessKey": "test",
	      "region": "us-east-1",
	      "s3UsePathStyle": "true",
	      "secretKey": "test",
	      "skipCredentialsValidation": "true",
	      "skipRequestingAccountId": "true",
	      "version": "6.5.0"
	    }
	  },
	  "response": {
            "inputs": "*",
            "failures": [{"reason": "could not validate provider configuration: Invalid or unknown key. Check '''pulumi config get aws:unknownKey'''."}]
	  }
	}]`, "'''", "`"))
}

func TestCheckConfigRunsUpstreamValidators(t *testing.T) {
	replaySequence(t, strings.ReplaceAll(`
	[{
	  "method": "/pulumirpc.ResourceProvider/CheckConfig",
	  "request": {
	    "urn": "urn:pulumi:dev::aws-2880::pulumi:providers:aws::default_6_5_0",
	    "olds": {},
	    "news": {
              "assumeRoleWithWebIdentity": {"roleArn": "INVALID-ARN", "webIdentityToken": "TOKEN"},
	      "accessKey": "test",
	      "region": "us-east-1",
	      "s3UsePathStyle": "true",
	      "secretKey": "test",
	      "skipCredentialsValidation": "true",
	      "skipRequestingAccountId": "true",
	      "version": "6.5.0"
	    }
	  },
	  "response": {
            "inputs": "*",
            "failures": [
              {"reason": "could not validate provider configuration: \"assume_role_with_web_identity.0.role_arn\" (INVALID-ARN) is an invalid ARN: arn: invalid prefix. Check '''pulumi config get --path aws:assumeRoleWithWebIdentity.roleArn'''."}
            ]
	  }
	}]`, "'''", "`"))
}

func TestCheckConfigFastWithCustomEndpoints(t *testing.T) {
	time0 := time.Now()
	replaySequence(t, `
	[{
	  "method": "/pulumirpc.ResourceProvider/CheckConfig",
	  "request": {
	    "urn": "urn:pulumi:dev::aws-2880::pulumi:providers:aws::default_6_5_0",
	    "olds": {},
	    "news": {
	      "accessKey": "test",
	      "endpoints": "[{\"accessanalyzer\":\"http://localhost:4566\"},{\"account\":\"http://localhost:4566\"},{\"acm\":\"http://localhost:4566\"},{\"acmpca\":\"http://localhost:4566\"},{\"amg\":\"http://localhost:4566\"},{\"amp\":\"http://localhost:4566\"},{\"amplify\":\"http://localhost:4566\"},{\"apigateway\":\"http://localhost:4566\"},{\"apigatewayv2\":\"http://localhost:4566\"},{\"appautoscaling\":\"http://localhost:4566\"},{\"appconfig\":\"http://localhost:4566\"},{\"appflow\":\"http://localhost:4566\"}]",
	      "region": "us-east-1",
	      "s3UsePathStyle": "true",
	      "secretKey": "test",
	      "skipCredentialsValidation": "true",
	      "skipRequestingAccountId": "true",
	      "version": "6.5.0"
	    }
	  },
	  "response": {
	    "inputs": {
	      "accessKey": "test",
	      "endpoints": "[{\"accessanalyzer\":\"http://localhost:4566\"},{\"account\":\"http://localhost:4566\"},{\"acm\":\"http://localhost:4566\"},{\"acmpca\":\"http://localhost:4566\"},{\"amg\":\"http://localhost:4566\"},{\"amp\":\"http://localhost:4566\"},{\"amplify\":\"http://localhost:4566\"},{\"apigateway\":\"http://localhost:4566\"},{\"apigatewayv2\":\"http://localhost:4566\"},{\"appautoscaling\":\"http://localhost:4566\"},{\"appconfig\":\"http://localhost:4566\"},{\"appflow\":\"http://localhost:4566\"}]",
	      "region": "us-east-1",
	      "s3UsePathStyle": "true",
	      "secretKey": "test",
	      "skipCredentialsValidation": "true",
	      "skipMetadataApiCheck": "true",
	      "skipRegionValidation": "true",
	      "skipRequestingAccountId": "true",
	      "version": "6.5.0"
	    }
	  }
	}]`)
	cutoff := 5 * time.Second
	require.Truef(t, time0.Add(cutoff).After(time.Now()), "CheckConfig with custom endpoints is taking more than %v", cutoff)
}

func TestMissingCredentialsErrorMessage(t *testing.T) {
	skipIfShort(t)
	os.Unsetenv("AWS_ACCESS_KEY_ID")
	os.Unsetenv("AWS_SECRET_ACCESS_KEY")
	os.Unsetenv("AWS_REGION")
	os.Unsetenv("AWS_PROFILE")
	os.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "false")

	replaySequence(t, `
	[{
		"method": "/pulumirpc.ResourceProvider/CheckConfig",
		"request": {
			"urn": "urn:pulumi:dev::aws_no_creds::pulumi:providers:aws::default_6_18_2",
			"olds": {},
			"news": {
				"version": "6.18.2"
			}
		},
		"response": {
			"inputs": {
				"skipCredentialsValidation": "false",
				"skipMetadataApiCheck": "true",
				"skipRegionValidation": "true",
				"version": "6.18.2"
			},
			"failures": [
				{
					"reason": "No valid credential sources found.\nPlease see https://www.pulumi.com/registry/packages/aws/installation-configuration/ for more information about providing credentials.\nNEW: You can use Pulumi ESC to set up dynamic credentials with AWS OIDC to ensure the correct and valid credentials are used.\nLearn more: https://www.pulumi.com/registry/packages/aws/installation-configuration/#dynamically-generate-credentials"
				}
			]
		},
		"metadata": {
			"kind": "resource",
			"mode": "client",
			"name": "aws"
		}
	}]`)
}

func TestMissingRegionErrorMessage(t *testing.T) {
	skipIfShort(t)
	os.Setenv("AWS_ACCESS_KEY_ID", "VALID")
	os.Setenv("AWS_SECRET_ACCESS_KEY", "VALID")
	os.Unsetenv("AWS_REGION")
	os.Unsetenv("AWS_PROFILE")
	os.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "false")

	replaySequence(t, strings.ReplaceAll(`
	[{
		"method": "/pulumirpc.ResourceProvider/CheckConfig",
		"request": {
			"urn": "urn:pulumi:dev::aws_no_creds::pulumi:providers:aws::default_6_18_2",
			"olds": {},
			"news": {
				"version": "6.18.2"
			}
		},
		"response": {
			"inputs": {
				"skipCredentialsValidation": "false",
				"skipMetadataApiCheck": "true",
				"skipRegionValidation": "true",
				"version": "6.18.2"
			},
			"failures": [
				{
					"reason": "Missing region information\nMake sure you have set your AWS region, e.g. '''pulumi config set aws:region us-west-2'''."
				}
			]
		},
		"metadata": {
			"kind": "resource",
			"mode": "client",
			"name": "aws"
		}
	}]`, "'''", "`"))
}

func TestInvalidCredentialsErrorMessage(t *testing.T) {
	skipIfShort(t)
	os.Setenv("AWS_ACCESS_KEY_ID", "INVALID")
	os.Setenv("AWS_SECRET_ACCESS_KEY", "INVALID")
	os.Setenv("AWS_REGION", "us-west-2")
	os.Unsetenv("AWS_PROFILE")
	os.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "false")

	replaySequence(t, `
	[{
		"method": "/pulumirpc.ResourceProvider/CheckConfig",
		"request": {
			"urn": "urn:pulumi:dev::aws_no_creds::pulumi:providers:aws::default_6_18_2",
			"olds": {},
			"news": {
				"version": "6.18.2"
			}
		},
		"response": {
			"inputs": {
				"region": "us-west-2",
				"skipCredentialsValidation": "false",
				"skipMetadataApiCheck": "true",
				"skipRegionValidation": "true",
				"version": "6.18.2"
			},
			"failures": [
				{
					"reason": "Invalid credentials configured.\nPlease see https://www.pulumi.com/registry/packages/aws/installation-configuration/ for more information about providing credentials.\nNEW: You can use Pulumi ESC to set up dynamic credentials with AWS OIDC to ensure the correct and valid credentials are used.\nLearn more: https://www.pulumi.com/registry/packages/aws/installation-configuration/#dynamically-generate-credentials"
				}
			]
		},
		"metadata": {
			"kind": "resource",
			"mode": "client",
			"name": "aws"
		}
	}]`)
}

func TestOtherFailureErrorMessage(t *testing.T) {
	skipIfShort(t)
	os.Setenv("AWS_ACCESS_KEY_ID", "INVALID")
	os.Setenv("AWS_SECRET_ACCESS_KEY", "INVALID")
	os.Setenv("AWS_REGION", "us-west-2")
	os.Setenv("AWS_PROFILE", "non-existent-profile")
	os.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "false")

	replaySequence(t, `
	[{
		"method": "/pulumirpc.ResourceProvider/CheckConfig",
		"request": {
			"urn": "urn:pulumi:dev::aws_no_creds::pulumi:providers:aws::default_6_18_2",
			"olds": {},
			"news": {
				"version": "6.18.2"
			}
		},
		"response": {
			"inputs": {
				"region": "us-west-2",
				"skipCredentialsValidation": "false",
				"skipMetadataApiCheck": "true",
				"skipRegionValidation": "true",
				"version": "6.18.2"
			},
			"failures": [
				{
					"reason": "unable to validate AWS credentials.\nDetails: loading configuration: failed to get shared config profile, non-existent-profile\n"
				}
			]
		},
		"metadata": {
			"kind": "resource",
			"mode": "client",
			"name": "aws"
		}
	}]`)
}

func replaySequence(t *testing.T, sequence string) {
	info := *Provider()
	ctx := context.Background()
	p, err := pfbridge.MakeMuxedServer(ctx, info.Name, info,
		/*
		 * We leave the schema blank. This will result in incorrect calls to
		 * GetSchema, but otherwise does not effect the provider. It reduces the
		 * time to test start by minutes.
		 */
		[]byte("{}"),
	)(nil)
	require.NoError(t, err)
	testutils.ReplaySequence(t, p, sequence)
}

func init() {
	version.Version = "6.0.0"
}
