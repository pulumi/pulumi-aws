// Copyright 2016-2024, Pulumi Corporation.  All rights reserved.
//go:build nodejs || all
// +build nodejs all

package examples

import (
	"archive/zip"
	"bytes"
	"context"
	"crypto/rand"
	"encoding/json"
	"io"
	"os"
	"path/filepath"
	"regexp"
	"testing"
	"time"

	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/credentials/stscreds"
	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/lambda"
	"github.com/aws/aws-sdk-go/service/s3"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/elb"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

/* see https://github.com/pulumi/pulumi-aws/issues/1264
func TestAccDedicatedHosts(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "dedicated-hosts"),
			RunUpdateTest: false,
		})

	integration.ProgramTest(t, &test)
}
*/

func TestAccMinimal(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "minimal"),
		})

	integration.ProgramTest(t, &test)
}

func TestAccExpress(t *testing.T) {
	// This example is reused to further validate that provisioned CallbackFunctions in Node are working at runtime
	// as expected, in particular their default runtime is not deprecated and they can utilize new APIs like the
	// fetch() API that is new in the Node 18 runtime.
	validate := func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
		lambdaRuntime := stack.Outputs["lambdaRuntime"].(string)
		t.Logf("Picked the following runtime by default: %v", lambdaRuntime)

		lambdaARN := stack.Outputs["lambdaARN"].(string)

		// Invoke a given Lambda function using Go SDK v2
		sess := getAwsSession(t)
		lambdaClient := lambda.New(sess)
		result, err := lambdaClient.Invoke(&lambda.InvokeInput{
			FunctionName: aws.String(lambdaARN),
			Payload:      []byte("{}"),
		})
		require.NoError(t, err)

		t.Logf("Raw payload returned by the Lambda: %s", result.Payload)

		type data struct {
			StatusCode int    `json:"statusCode"`
			Body       string `json:"body"`
		}
		var payload data
		err = json.Unmarshal(result.Payload, &payload)
		require.NoError(t, err)

		require.Equal(t, 200, payload.StatusCode)

		type inner struct {
			Message     string `json:"message"`
			FetchStatus int    `json:"fetchStatus"`
		}

		var response inner
		err = json.Unmarshal([]byte(payload.Body), &response)
		require.NoError(t, err)

		assert.Contains(t, response.Message, "Hello, world!")
		assert.Equal(t, 200, response.FetchStatus)
	}
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:                    filepath.Join(getCwd(t), "express"),
			ExtraRuntimeValidation: validate,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccBucket(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "bucket"),
			ExtraRuntimeValidation: func(t *testing.T, info integration.RuntimeValidationStackInfo) {
				bucketName, ok := info.Outputs["bucketName"].(string)
				assert.True(t, ok)

				sess := getAwsSession(t)
				s3client := s3.New(sess)
				_, err := s3client.PutObject(&s3.PutObjectInput{
					Bucket: aws.String(bucketName),
					Key:    aws.String("foo.txt"),
					Body:   bytes.NewReader([]byte("Hello, world!")),
				})
				assert.NoError(t, err)

				// Wait for the new object to be written
				time.Sleep(5 * time.Second)

				getOut, err := s3client.GetObject(&s3.GetObjectInput{
					Bucket: aws.String(bucketName),
					Key:    aws.String("lastPutFile.json"),
				})
				assert.NoError(t, err)
				body, err := io.ReadAll(getOut.Body)
				assert.NoError(t, err)

				var data map[string]interface{}
				err = json.Unmarshal(body, &data)
				assert.NoError(t, err)

				assert.Equal(t, "foo.txt", data["key"].(string))
			},
		})

	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccCloudWatch(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "cloudwatch"),
			RunUpdateTest: true,
			// Inherit ambient credentials.
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccCloudWatchWithOIDC(t *testing.T) {
	ctx := context.Background()

	// Generate credentials for OIDC_ROLE_ARN.
	cfg, err := config.LoadDefaultConfig(ctx,
		config.WithRegion(os.Getenv("AWS_REGION")),
		config.WithAssumeRoleCredentialOptions(func(opts *stscreds.AssumeRoleOptions) {
			opts.Duration = 3600 * time.Second
			opts.RoleSessionName = "aws@githubActions"
			opts.RoleARN = os.Getenv("OIDC_ROLE_ARN")
		}))
	require.NoError(t, err)

	creds, err := cfg.Credentials.Retrieve(ctx)
	require.NoError(t, err)

	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "cloudwatch"),
			RunUpdateTest: true,
			// Override ambient credentials to use our OIDC role.
			Env: []string{
				"AWS_ACCESS_KEY_ID=" + creds.AccessKeyID,
				"AWS_SECRET_ACCESS_KEY=" + creds.SecretAccessKey,
				"AWS_SESSION_TOKEN=" + creds.SessionToken,
				"AWS_REGION=" + os.Getenv("AWS_REGION"),
			},
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccCloudWatchOIDCAmbient(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "cloudwatchOidcManual"),

			// TODO[pulumi/pulumi-aws#3193] multiple issues with refreshing and updating cleanly.
			SkipRefresh:              true,
			AllowEmptyPreviewChanges: true,
			AllowEmptyUpdateChanges:  true,
			// Inherit ambient credentials.
		})

	integration.ProgramTest(t, &test)
}

func TestAccCloudWatchOIDCManual(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "cloudwatchOidcManual"),

			// TODO[pulumi/pulumi-aws#3193] multiple issues with refreshing and updating cleanly.
			SkipRefresh:              true,
			AllowEmptyPreviewChanges: true,
			AllowEmptyUpdateChanges:  true,
			// Unset any ambient credentials.
			Env: []string{
				`AWS_ACCESS_KEY_ID=`,
				`AWS_SECRET_ACCESS_KEY=`,
				`AWS_SESSION_TOKEN=`,
				`AWS_REGION=` + os.Getenv("AWS_REGION"),
			},
		})

	integration.ProgramTest(t, &test)
}

func TestAccLogGroup(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "logGroup"),
			RunUpdateTest: false,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccQueue(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "queue"),
			RunUpdateTest: true,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccEventBus(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "eventbus"),
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccStream(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "stream"),
			RunUpdateTest: true,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccTable(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "table"),
			RunUpdateTest: true,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccTopic(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "topic"),
			RunUpdateTest: true,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccSecretCapture(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "secretcapture"),
			RunUpdateTest: true,
			ExtraRuntimeValidation: func(t *testing.T, info integration.RuntimeValidationStackInfo) {
				byts, err := json.Marshal(info.Deployment)
				assert.NoError(t, err)
				assert.NotContains(t, "s3cr3t", string(byts))
			},
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccCallbackFunction(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "callbackfunction"),
			ExtraRuntimeValidation: func(t *testing.T, info integration.RuntimeValidationStackInfo) {
				sess := getAwsSession(t)
				lambdaClient := lambda.New(sess)
				arns := info.Outputs["arns"].([]interface{})
				results := make(chan bool, len(arns))
				for i := range arns {
					functionArn := arns[i].(string)
					go func() {
						defer func() { results <- true }()
						res, err := lambdaClient.Invoke(&lambda.InvokeInput{
							FunctionName: aws.String(functionArn),
							Payload:      []byte("{}"),
						})
						assert.NoError(t, err)
						assert.Nil(t, res.FunctionError)
						var payload struct {
							Success bool `json:"success"`
						}
						err = json.Unmarshal(res.Payload, &payload)
						assert.NoError(t, err)
						assert.True(t, payload.Success)
					}()
				}
				for range arns {
					<-results
				}
			},
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccSsmParameter(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "ssmparameter"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccSsmParameterWithS3State(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "ssmparameter"),
			RunUpdateTest: true,
			CloudURL:      "s3://ci-remote-state-bucket",
		})

	integration.ProgramTest(t, &test)
}

func TestAccRoute53(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "route53"),
			RunUpdateTest: true,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccLambdaLayer(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "lambda-layer-old"),
			RunUpdateTest: true,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccLambdaContainerImages(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "lambda-container-image"),
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccLambdaLayerNewEnums(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "lambda-layer-new"),
			RunUpdateTest: false,
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccEcr(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "ecr"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccDeleteBeforeCreate(t *testing.T) {
	basePath := filepath.Join(getCwd(t), "delete_before_create", "mount_target")
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(basePath, "step1"),
			RunUpdateTest: true,
			EditDirs: []integration.EditDir{
				{
					Dir:      filepath.Join(basePath, "step2"),
					Additive: true,
				},
				{
					Dir:      filepath.Join(basePath, "step3"),
					Additive: true,
				},
			},
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccIgnoreChanges(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "ignoreChanges"),
			RunUpdateTest: true,
			EditDirs: []integration.EditDir{
				{
					Dir:      filepath.Join(getCwd(t), "ignoreChanges", "step1"),
					Additive: true,
					ExtraRuntimeValidation: func(t *testing.T, info integration.RuntimeValidationStackInfo) {
						// Verify that the change to `"bar"` was succesfully ignored.
						assert.Equal(t, "foo", info.Deployment.Resources[2].Inputs["bucketPrefix"])
						assert.Equal(t, "foo", info.Deployment.Resources[2].Outputs["bucketPrefix"])
					},
				},
			},
		})

	integration.ProgramTest(t, &test)
}

func TestAccWebserver(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "webserver"),
			//
			// TODO[pulumi/pulumi#12859] temporarily disable EditDirs to workaround ProgramTest bug
			//
			// EditDirs: []integration.EditDir{
			// 	// First, look up the server just created using get.  No new resources.
			// 	createEditDir(filepath.Join(getCwd(t), "webserver", "variants", "get")),
			// 	// Next, patch the ingress rules by adding port 20: should be a quick update.
			// 	createEditDir(filepath.Join(getCwd(t), "webserver", "variants", "ssh")),
			// 	// Now do the reverse; this basically ensures that an update that deletes a property works.
			// 	createEditDir(filepath.Join(getCwd(t), "webserver")),
			// 	// Next patch the security group description, necessitating a full replacement of resources.
			// 	createEditDir(filepath.Join(getCwd(t), "webserver", "variants", "ssh_description")),
			// },
		})

	integration.ProgramTest(t, &test)
}

func TestAccWebserverVariants(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "webserver", "variants", "zones"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccWebserverComp(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "webserver-comp"),
			Secrets: map[string]string{
				"aws:accessKey": os.Getenv("AWS_ACCESS_KEY_ID"),
				"aws:secretKey": os.Getenv("AWS_SECRET_ACCESS_KEY"),
			},
		})

	integration.ProgramTest(t, &test)
}

func TestAccServerlessRaw(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "serverless-raw"),
			RunUpdateTest: false,
			// Two changes are known to occur during refresh of the resources in this example:
			// * `~  aws:apigateway:Method myrestapi-method updated changes: + authorizationScopes,...`
			// * `~  aws:lambda:Function mylambda-logcollector updated changes: ~ lastModified`
			ExpectRefreshChanges: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccMultipleRegions(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "multiple-regions"),
			// RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccFifoSqsQueueTs(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "sqs-fifo-queue", "ts"),
			RunUpdateTest: false,
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				assert.Contains(t, stack.Outputs["name"].(string), ".fifo")
			},
		})

	integration.ProgramTest(t, &test)
}

func TestAccKmsAliasTs(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "kms-alias"),
			RunUpdateTest: false,
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				assert.Contains(t, stack.Outputs["autonamedAlias"].(string), "alias/")
			},
		})

	integration.ProgramTest(t, &test)
}

func TestAccWafV2(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "wafv2"),
		})
	skipRefresh(&test)

	integration.ProgramTest(t, &test)
}

func TestRegress1423Ts(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "regress-1423"),
		})
	// TODO[pulumi/pulumi-aws#3361] similarly to upstream this currently has a non-empty refresh
	test.SkipRefresh = true
	test.Quick = false
	integration.ProgramTest(t, &test)
}

// Regress passing unknowns into an explicit provider configuration, see pulumi/pulumi-aws#2818
func TestRegress2818(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "regress-2818"),
		})
	// These settings run pulumi preview, as the example is incomplete for running pulumi up.
	test.Quick = false
	test.SkipRefresh = true
	test.SkipUpdate = true
	test.SkipExportImport = true
	test.SkipEmptyPreviewUpdate = true
	// Disable envRegion mangling
	test.Config = nil
	integration.ProgramTest(t, &test)
}

// Checks aws.cognito.UserPool that had constant Diff issues.
//
// See https://github.com/pulumi/pulumi-aws/issues/2868
func TestRegress2868(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "regress-2868"),
		})
	// Disable envRegion mangling
	test.Config = nil
	integration.ProgramTest(t, &test)
}

// Checks aws.ssm.Document that had constant Diff issues.
//
// See https://github.com/pulumi/pulumi-aws/issues/2555
func TestRegress2555(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: "regress-2555",

			// TODO does not refresh cleanly, actually following upstream: both in TF
			// pure and in Pulumi refreshing replaces nil with empty map for tags and
			// permissions properties.
			SkipRefresh: true,

			// Sometimes pulumi destroy fails with this:
			//
			//     InvalidDocument: No matching value was found for Name.
			//
			// It happens if the document was created but creation has not yet propagated through AWS.
			RetryFailedSteps: true,

			EditDirs: []integration.EditDir{{
				Dir:      filepath.Join("regress-2555", "step1"),
				Additive: true,
			}},
		})
	// Disable envRegion mangling
	test.Config = nil
	integration.ProgramTest(t, &test)
}

func TestRegress3421(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:         "regress-3421",
			SkipRefresh: true,
		},
		)
	// Disable envRegion mangling
	test.Config = nil
	integration.ProgramTest(t, &test)
}

func TestRegress3421Update(t *testing.T) {
	test := pulumitest.NewPulumiTest(t, "regress-3421",
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
	)

	test.SetConfig(t, "listenerPort", "80")
	test.Up(t)
	test.SetConfig(t, "listenerPort", "81")
	test.Up(t)
}

func getJSBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	baseJS := integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region":    "INVALID_REGION",
			"aws:envRegion": envRegion,
		},
		Dependencies: []string{
			"@pulumi/aws",
		},
	}

	return baseJS
}

func getAwsSession(t *testing.T) *session.Session {
	region := getEnvRegion(t)
	sess, err := session.NewSessionWithOptions(session.Options{
		SharedConfigState: session.SharedConfigEnable,
		Config: aws.Config{
			Region:                        aws.String(region),
			CredentialsChainVerboseErrors: aws.Bool(true),
		},
	})
	require.NoError(t, err)
	return sess
}

func TestUpdateImportedLambda(t *testing.T) {
	test := pulumitest.NewPulumiTest(t, "lambda-import-ts",
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
	)

	test.SetConfig(t, "runtime", "nodejs18.x")
	res := test.Up(t)
	lambdaName := res.Outputs["lambda_name"]
	lambdaRole := res.Outputs["lambda_role"]

	secondStack := test.InstallStack(t, "new_stack")

	// Check that we can reimport the lambda.
	secondStack.SetConfig(t, "lambda_name", lambdaName.Value.(string))
	secondStack.SetConfig(t, "runtime", "nodejs18.x")
	secondStack.SetConfig(t, "lambda_role", lambdaRole.Value.(string))
	secondStack.Up(t)

	// Check that we can change a property on the lambda
	secondStack.SetConfig(t, "runtime", "nodejs16.x")
	secondStack.Up(t)
}

func TestNoCodeLambda(t *testing.T) {
	test := pulumitest.NewPulumiTest(t, "no-code-lambda",
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
	)
	_, err := test.CurrentStack().Up(test.Context())
	require.Error(t, err)
	require.Contains(t, err.Error(), "ValidationException")
}

type InlinePolicy struct {
	Name   string `json:"name"`
	Policy string `json:"policy"`
}

func TestRoleInlinePolicyAutoName(t *testing.T) {
	test := pulumitest.NewPulumiTest(t, "role-inline-policy-auto-name",
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
	)
	res, err := test.CurrentStack().Up(test.Context())
	require.NoError(t, err)

	policy := res.Outputs["inlinePolicy"]
	value, err := json.Marshal(policy.Value)
	require.NoError(t, err)

	var inlinePolicy InlinePolicy
	err = json.Unmarshal(value, &inlinePolicy)
	require.NoError(t, err)

	policyEmpty := res.Outputs["inlinePolicyEmpty"]

	// Check that the delete marker is present
	require.Len(t, policyEmpty.Value, 1)
	deleteMarker := policyEmpty.Value.([]interface{})[0]
	require.Empty(t, deleteMarker.(map[string]interface{})["policy"])

	require.Regexp(t, regexp.MustCompile("testrole-*"), inlinePolicy.Name)
	require.JSONEq(t, `{"Version": "2012-10-17", "Statement": [{"Effect": "Allow", "Action": "s3:GetObject", "Resource": "*" }]}`, inlinePolicy.Policy)
}

func TestRdsGetEngineVersion(t *testing.T) {
	test := pulumitest.NewPulumiTest(t, "rds-getengineversion",
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
	)
	res, err := test.CurrentStack().Up(test.Context())
	require.NoError(t, err)

	engineVersion := res.Outputs["vs"]
	require.Equal(t, engineVersion.Value, "15.8")
}

// Checks static get function for ssm.parameter that was broken for versioned IDs.
//
// See https://github.com/pulumi/pulumi-aws/issues/4011
func TestRegress4011(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "regress-4011"),
			EditDirs: []integration.EditDir{{
				Dir:      filepath.Join(getCwd(t), "regress-4011", "step1"),
				Additive: true,
			}},
		})

	// Disable envRegion mangling
	test.Config = map[string]string{
		"parameterName": "regress-4011-" + randomString(10),
	}
	integration.ProgramTest(t, &test)
}

func TestServerlessAppRepositoryApplication(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "serverless-app-repository-application"),
		})

	integration.ProgramTest(t, &test)
}

func TestAccEcrImage(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "ecr-image"),
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				repoDigest, ok := stack.Outputs["digest"].(string)
				assert.True(t, ok, "expected digest output to be set")
				assert.NotEmpty(t, repoDigest)
			},
		})

	integration.ProgramTest(t, &test)
}

func TestLambdaLayerNewUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("lambda-layer-new"), nodeProviderUpgradeOpts())
}

func TestCloudWatchUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("cloudwatch"), nodeProviderUpgradeOpts())
}

func TestLogGroupUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("logGroup"), nodeProviderUpgradeOpts())
}

func TestQueueUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("queue"), nodeProviderUpgradeOpts())
}

func TestRoute53Upgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("route53"), nodeProviderUpgradeOpts())
}

func TestJobQueueUpgrade(t *testing.T) {
	opts := nodeProviderUpgradeOpts()
	opts.setEnvRegion = false
	opts.region = "us-west-2" // has to match the snapshot-recorded region
	opts.extraOpts = []opttest.Option{
		opttest.Env("PULUMI_ENABLE_PLAN_RESOURCE_CHANGE", "true"),
	}
	testProviderUpgrade(t, filepath.Join("test-programs", "job-queue"), opts)
}

func nodeProviderUpgradeOpts() *testProviderUpgradeOptions {
	return &testProviderUpgradeOptions{
		linkNodeSDK:  true,
		installDeps:  true,
		setEnvRegion: true,
	}
}

func TestRegress3094(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "regress-3094")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	upResult := test.Up(t)
	t.Logf("#%v", upResult.Summary)
}

func TestRegress3835(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "regress-3835")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	result := test.Preview(t)
	t.Logf("#%v", result.ChangeSummary)
}

func TestChangingRegion(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "changing-region")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}

	t.Run("default provider", func(t *testing.T) {
		test := pulumitest.NewPulumiTest(t, dir, options...)
		for _, region := range []string{"us-east-1", "us-west-1"} {
			test.SetConfig(t, "aws:region", region)
			res := test.Up(t)
			require.Equal(t, region, res.Outputs["actualRegion"].Value)
		}
	})

	t.Run("explicit provider", func(t *testing.T) {
		test := pulumitest.NewPulumiTest(t, dir, options...)
		for _, region := range []string{"us-east-1", "us-west-1"} {
			test.SetConfig(t, "desired-region", region)
			res := test.Up(t)
			require.Equal(t, region, res.Outputs["actualRegion"].Value)
		}
	})
}

func TestRegressAttributeMustBeWholeNumber(t *testing.T) {
	// pulumi/pulumi-terraform-bridge#1940
	skipIfShort(t)
	dir := filepath.Join("test-programs", "ec2-string-for-int")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	result := test.Preview(t)
	t.Logf("#%v", result.ChangeSummary)
}

func TestRegress4079(t *testing.T) {
	skipIfShort(t)
	ctx := context.Background()
	dir := filepath.Join("test-programs", "regress-4079")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)

	test.SetConfig(t, "targetGroupCount", "2")
	r1 := test.Up(t)
	t.Logf("Stdout: %v", r1.StdOut)
	t.Logf("Stderr: %v", r1.StdErr)

	listenerARN := r1.Outputs["listenerARN"].Value.(string)
	err = elb.ModifyListenerDefaultActions(ctx, listenerARN, func(as []elb.Action) []elb.Action {
		r := []elb.Action{}
		for _, a := range as {
			b := a
			t.Logf("BEFORE: len(ForwardConfig.TargetGroups)=%d", len(b.ForwardConfig.TargetGroups))
			b.ForwardConfig.TargetGroups = []elb.TargetGroupTuple{
				b.ForwardConfig.TargetGroups[0],
			}
			t.Logf("AFTER: len(ForwardConfig.TargetGroups)=%d", len(b.ForwardConfig.TargetGroups))
			r = append(r, b)
		}
		return r
	})
	require.NoError(t, err)

	rr := test.Refresh(t)
	t.Logf("Stdout: %v", rr.StdOut)
	t.Logf("Stderr: %v", rr.StdErr)

	refreshedState := test.ExportStack(t)

	type resource struct {
		Type    string         `json:"type"`
		Outputs map[string]any `json:"outputs"`
	}
	type deployment struct {
		Resources []resource `json:"resources"`
	}
	var data deployment
	err = json.Unmarshal(refreshedState.Deployment, &data)
	require.NoError(t, err)

	for _, r := range data.Resources {
		if r.Type != "aws:lb/listener:Listener" {
			continue
		}
		defaultAction1 := r.Outputs["defaultActions"].([]any)[0].(map[string]any)
		t.Logf("defaultActions includes: %#v", defaultAction1)
		require.NotNil(t, defaultAction1["forward"], "forward should be set in defaultActions")
		require.Emptyf(t, defaultAction1["targetGroupArn"], "targetGroupArn should be empty in defaultActions")
	}
}

func TestParallelLambdaCreation(t *testing.T) {
	// This test is flaky and needs to be fixed. It occasionally fails to find the lambda zip archive
	t.Skipf("TODO[pulumi/pulumi-aws#4731]")
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
		return
	}

	tempFile, err := createLambdaArchive(25 * 1024 * 1024)
	require.NoError(t, err)
	defer os.Remove(tempFile)

	maxDuration(5*time.Minute, t, func(t *testing.T) {
		test := getJSBaseOptions(t).
			With(integration.ProgramTestOptions{
				Dir: filepath.Join("test-programs", "parallel-lambdas"),
				Config: map[string]string{
					"lambda:archivePath": tempFile,
				},
				// Lambdas have diffs on every update (source code hash)
				AllowEmptyPreviewChanges: true,
				SkipRefresh:              true,
			})

		integration.ProgramTest(t, &test)
	})
}

func TestRegress4128(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
		return
	}

	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:         filepath.Join("test-programs", "regress-4128"),
			SkipRefresh: true,
		},
		)
	// Disable envRegion mangling
	test.Config = nil
	integration.ProgramTest(t, &test)
}

func TestGameLift(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
		return
	}

	ptest := pulumiTest(t, filepath.Join("test-programs", "gamelift-typescript"))
	ptest.SetConfig(t, "customData", "A")
	result1 := ptest.Up(t)
	require.Equal(t, "A", result1.Outputs["CustomEventData"].Value)
	ptest.SetConfig(t, "customData", "B")
	result2 := ptest.Up(t)
	require.Equal(t, "B", result2.Outputs["CustomEventData"].Value)
}

func TestRegress4446(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "regress-4446")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	upResult := test.Up(t)
	t.Logf("#%v", upResult.Summary)
	result := test.Preview(t, optpreview.ExpectNoChanges())
	t.Logf("#%v", result.ChangeSummary)
}

func TestRegress4568(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "regress-4568")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	upResult := test.Up(t)
	t.Logf("#%v", upResult.Summary)

	// The singular lifecyclePolicy should contain the first value
	assert.Equal(t, map[string]interface{}{
		"transitionToIa":                  "AFTER_30_DAYS",
		"transitionToArchive":             "",
		"transitionToPrimaryStorageClass": "",
	}, upResult.Outputs["lifecyclePolicy"].Value, "lifecyclePolicy should be set")

	// The plural lifecyclePolicies should contain both values
	lifecyclePolicies := upResult.Outputs["lifecyclePolicies"].Value.([]interface{})
	assert.Len(t, lifecyclePolicies, 2, "lifecyclePolicies should have two elements")

	assert.Contains(t, lifecyclePolicies, map[string]interface{}{
		"transitionToIa":                  "AFTER_30_DAYS",
		"transitionToArchive":             "",
		"transitionToPrimaryStorageClass": "",
	})
	assert.Contains(t, lifecyclePolicies, map[string]interface{}{
		"transitionToPrimaryStorageClass": "AFTER_1_ACCESS",
		"transitionToIa":                  "",
		"transitionToArchive":             "",
	})
}

func TestRegress5219(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "regress-5219")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	t1 := time.Now()
	ef := &expectFailure{T: t}
	upResult := test.Up(ef)
	t.Logf("%#v", upResult.Summary.ResourceChanges)
	t2 := time.Now()
	assert.Truef(t, ef.failed, "Expected pulumi up to fail")
	assert.Truef(t, t2.Sub(t1) < 10*time.Minute, "Expected pulumi up to fail within 10 minutes")
}

type expectFailure struct {
	*testing.T
	failed bool
}

func (ef *expectFailure) FailNow() {
	ef.T.Log("Ignoring FailNow()")
	ef.failed = true
}

// Tests that there are no diagnostics by default on simple programs.
func TestNoExtranousLogOutput(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "bucket-obj")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)
	result := test.Preview(t)
	assert.NotContainsf(t, result.StdOut, "Diagnostics:",
		"No diagnostics should be emitted to stdout for simple programs")
	assert.NotContainsf(t, result.StdErr, "Diagnostics:",
		"No diagnostics should be emitted to stderr for simple programs")
}

// Since AWS is doing something non-standard with logging, double-check that `log.Printf` messages do get propagated
// when TF_LOG=DEBUG is set. One such message is set by aws.s3.Bucketv2 when refresh finds that the bucket no longer
// exists. Emulate this situation and assert that the message has propagated.
func TestUpstreamWarningsPropagated(t *testing.T) {
	skipIfShort(t)
	dir := filepath.Join("test-programs", "disappearing-bucket-object")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	providerName := "aws"
	options := []opttest.Option{
		opttest.LocalProviderPath(providerName, filepath.Join(cwd, "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
		opttest.Env("TF_LOG", "DEBUG"),
	}
	test := pulumitest.NewPulumiTest(t, dir, options...)

	t.Logf("Creating the bucket object")
	test.Up(t)

	state := test.ExportStack(t)

	t.Logf("Deleting the bucket object")
	test.SetConfig(t, "bucket-object", "exclude")
	test.Up(t)

	t.Logf("Resetting the state back")
	test.ImportStack(t, state)

	t.Logf("Refreshing the stack and expecting bucket to be deleted from the state")
	rr := test.Refresh(t)
	t.Logf("%v%v", rr.StdOut, rr.StdErr)

	// Upstream code has this line:
	//
	//     log.Printf("[WARN] S3 Object (%s) not found, removing from state", d.Id())
	//
	assert.Containsf(t,
		rr.StdErr+rr.StdOut,
		"warning: S3 Object (index.ts) not found, removing from state",
		"Expected upstream log.Printf to propagate under TF_LOG=DEBUG")
}

func createLambdaArchive(size int64) (string, error) {
	// Create a temporary file to save the zip archive
	tempFile, err := os.CreateTemp("", "archive-*.zip")
	if err != nil {
		return "", err
	}
	defer tempFile.Close()

	// Create a new zip archive
	zipWriter := zip.NewWriter(tempFile)
	defer func() {
		err := zipWriter.Close()
		contract.AssertNoErrorf(err, "Failed closing zip archive")
		err = tempFile.Close()
		contract.AssertNoErrorf(err, "Failed closing temporary file")
	}()

	randomDataReader := io.LimitReader(rand.Reader, size)

	// Create the index.js file for the lambda
	indexWriter, err := zipWriter.Create("index.js")
	if err != nil {
		return "", err
	}
	_, err = indexWriter.Write([]byte("const { version } = require(\"@aws-sdk/client-s3/package.json\");\n\nexports.handler = async () => ({ version });\n"))
	if err != nil {
		return "", err
	}

	randomDataWriter, err := zipWriter.Create("random.txt")
	if err != nil {
		return "", err
	}
	_, err = io.Copy(randomDataWriter, randomDataReader)
	if err != nil {
		return "", err
	}

	// Get the path of the temporary file
	archivePath, err := filepath.Abs(tempFile.Name())
	if err != nil {
		return "", err
	}

	return archivePath, nil
}
