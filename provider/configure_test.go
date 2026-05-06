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
	"net/http"
	"net/http/httptest"
	"os"
	"strings"
	"testing"
	"time"

	"github.com/stretchr/testify/require"

	testutils "github.com/pulumi/providertest/replay"
	pfbridge "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/pf/tfbridge"
	pulumirpc "github.com/pulumi/pulumi/sdk/v3/proto/go"
	"google.golang.org/protobuf/types/known/structpb"

	version "github.com/pulumi/pulumi-aws/provider/v7/pkg/version"
)

func TestCheckConfigWithUnknownKeys(t *testing.T) {
	t.Parallel()

	// Double checking that this is a failure, but no longer over-fitting the test on the exact
	// error message. See pulumi/pulumi-terraform-bridge codebase instead for controlling the
	// generated error message.
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
            "failures": [{"reason": "*"}]
	  }
	}]`, "'''", "`"))
}

func TestCheckConfigRunsUpstreamValidators(t *testing.T) {
	t.Parallel()

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
	      "accessKey": "*",
	      "endpoints": "[{\"accessanalyzer\":\"http://localhost:4566\"},{\"account\":\"http://localhost:4566\"},{\"acm\":\"http://localhost:4566\"},{\"acmpca\":\"http://localhost:4566\"},{\"amg\":\"http://localhost:4566\"},{\"amp\":\"http://localhost:4566\"},{\"amplify\":\"http://localhost:4566\"},{\"apigateway\":\"http://localhost:4566\"},{\"apigatewayv2\":\"http://localhost:4566\"},{\"appautoscaling\":\"http://localhost:4566\"},{\"appconfig\":\"http://localhost:4566\"},{\"appflow\":\"http://localhost:4566\"}]",
	      "region": "us-east-1",
	      "s3UsePathStyle": "true",
	      "secretKey": "*",
	      "skipCredentialsValidation": "true",
	      "skipRegionValidation": "true",
	      "skipRequestingAccountId": "true",
	      "version": "6.5.0"
	    }
	  }
	}]`)
	cutoff := 5 * time.Second
	require.Truef(t, time0.Add(cutoff).After(time.Now()), "CheckConfig with custom endpoints is taking more than %v", cutoff)
}

func unsetAWSEnv() {
	os.Unsetenv("AWS_SECRET_ACCESS_KEY")
	os.Unsetenv("AWS_SESSION_TOKEN")
	os.Unsetenv("AWS_DEFAULT_REGION")
	os.Unsetenv("AWS_PROFILE")
	os.Unsetenv("AWS_ACCESS_KEY_ID")
	os.Unsetenv("AWS_SECRET_ACCESS_KEY")
	os.Unsetenv("AWS_REGION")
	os.Setenv("AWS_CONFIG_FILE", "non-existent/config.json")
	os.Setenv("AWS_SHARED_CREDENTIALS_FILE", "non-existent/credentials")
}

func skipIfNotShort(t *testing.T) {
	if !testing.Short() {
		t.Skipf("Skipping test in non-short mode")
	}
}

func TestMissingCredentialsErrorMessage(t *testing.T) {
	skipIfNotShort(t)
	unsetAWSEnv()
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
			"inputs": "*",
			"failures": [
				{
					"reason": "No valid credential sources found.\nPlease see https://www.pulumi.com/registry/packages/aws/installation-configuration/ for more information about providing credentials.\nNEW: You can use Pulumi ESC to set up dynamic credentials with AWS OIDC to ensure the correct and valid credentials are used.\nLearn more: https://www.pulumi.com/registry/packages/aws/installation-configuration/#dynamically-generate-credentials-via-pulumi-esc"
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
	skipIfNotShort(t)
	unsetAWSEnv()
	os.Setenv("AWS_ACCESS_KEY_ID", "VALID")
	os.Setenv("AWS_SECRET_ACCESS_KEY", "VALID")
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
			"inputs": "*",
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
	skipIfNotShort(t)
	unsetAWSEnv()
	os.Setenv("AWS_ACCESS_KEY_ID", "INVALID")
	os.Setenv("AWS_SECRET_ACCESS_KEY", "INVALID")
	os.Setenv("AWS_REGION", "us-west-2")
	os.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "false")

	requestCount := 0
	sts := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		requestCount++
		w.WriteHeader(http.StatusForbidden)
		_, _ = w.Write([]byte(`<ErrorResponse xmlns="https://sts.amazonaws.com/doc/2011-06-15/">
  <Error>
    <Type>Sender</Type>
    <Code>InvalidClientTokenId</Code>
    <Message>The security token included in the request is invalid</Message>
  </Error>
  <RequestId>01234567-89ab-cdef-0123-456789abcdef</RequestId>
</ErrorResponse>`))
	}))
	t.Cleanup(sts.Close)
	os.Setenv("AWS_ENDPOINT_URL", sts.URL)

	provider, err := testProviderServer()
	require.NoError(t, err)
	resp, err := provider.CheckConfig(context.Background(), &pulumirpc.CheckRequest{
		Urn:  "urn:pulumi:dev::aws_no_creds::pulumi:providers:aws::default_6_18_2",
		Olds: mustStruct(t, map[string]any{}),
		News: mustStruct(t, map[string]any{
			"version": "6.18.2",
		}),
	})
	require.Greater(t, requestCount, 0)
	require.NoError(t, err)
	require.Len(t, resp.Failures, 1)

	reason := resp.Failures[0].Reason
	require.Contains(t, reason, "Invalid credentials configured.")
	assertMessage := "Please see https://www.pulumi.com/registry/packages/aws/installation-configuration/ " +
		"for more information about providing credentials."
	require.Equal(t, 1, strings.Count(reason, assertMessage))
	require.Contains(t, reason, "NEW: You can use Pulumi ESC to set up dynamic credentials with AWS OIDC")
}

func TestCheckConfigRejectsLegacyAssumeRoleConfigKey(t *testing.T) {
	skipIfNotShort(t)
	unsetAWSEnv()
	os.Setenv("AWS_ACCESS_KEY_ID", "test")
	os.Setenv("AWS_SECRET_ACCESS_KEY", "test")
	os.Setenv("AWS_REGION", "us-west-2")
	os.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "false")

	provider, err := testProviderServer()
	require.NoError(t, err)
	_, err = provider.CheckConfig(context.Background(), &pulumirpc.CheckRequest{
		Urn:  "urn:pulumi:dev::aws_assume_role::pulumi:providers:aws::default_7_0_0",
		Olds: mustStruct(t, map[string]any{}),
		News: mustStruct(t, map[string]any{
			"accessKey": "test",
			"assumeRole": map[string]any{
				"roleArn": "arn:aws:iam::123456789012:role/example",
			},
			"region":    "us-west-2",
			"secretKey": "test",
			"version":   "7.0.0",
		}),
	})
	require.EqualError(t, err, "invalid config key 'aws:assumeRole', should be 'aws:assumeRoles'")
}

func TestCheckConfigValidatesAssumeRoles(t *testing.T) {
	skipIfNotShort(t)
	unsetAWSEnv()
	os.Setenv("AWS_CONFIG_FILE", "non-existent/config.json")
	os.Setenv("AWS_SHARED_CREDENTIALS_FILE", "non-existent/credentials")

	requestCount := 0
	sts := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		requestCount++
		w.WriteHeader(http.StatusForbidden)
		_, _ = w.Write([]byte(`<ErrorResponse xmlns="https://sts.amazonaws.com/doc/2011-06-15/">
  <Error>
    <Type>Sender</Type>
    <Code>AccessDenied</Code>
    <Message>not authorized to perform: sts:AssumeRole</Message>
  </Error>
  <RequestId>01234567-89ab-cdef-0123-456789abcdef</RequestId>
</ErrorResponse>`))
	}))
	t.Cleanup(sts.Close)
	os.Setenv("AWS_ENDPOINT_URL", sts.URL)

	provider, err := testProviderServer()
	require.NoError(t, err)
	resp, err := provider.CheckConfig(context.Background(), &pulumirpc.CheckRequest{
		Urn:  "urn:pulumi:dev::aws_assume_roles::pulumi:providers:aws::default_7_0_0",
		Olds: mustStruct(t, map[string]any{}),
		News: mustStruct(t, map[string]any{
			"accessKey": "test",
			"assumeRoles": []any{
				map[string]any{
					"roleArn": "arn:aws:iam::123456789012:role/example",
				},
			},
			"endpoints": `[{ "sts": "` + sts.URL + `" }]`,
			"region":    "us-west-2",
			"secretKey": "test",
			"version":   "7.0.0",
		}),
	})
	require.Greater(t, requestCount, 0)
	require.NoError(t, err)
	require.Len(t, resp.Failures, 1)
	require.Contains(t, resp.Failures[0].Reason, "unable to validate AWS credentials.")
	require.Contains(t, resp.Failures[0].Reason, "Cannot assume IAM Role.")
}

func TestOtherFailureErrorMessage(t *testing.T) {
	skipIfNotShort(t)
	unsetAWSEnv()
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
			"inputs": "*",
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

func mustStruct(t *testing.T, values map[string]any) *structpb.Struct {
	t.Helper()
	st, err := structpb.NewStruct(values)
	require.NoError(t, err)
	return st
}

func init() {
	version.Version = "7.0.0"
}
