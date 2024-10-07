// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
//go:build nodejs || all
// +build nodejs all

package examples

import (
	"bytes"
	"encoding/json"
	"io"
	"os"
	"path/filepath"
	"regexp"
	"testing"
	"time"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/lambda"
	"github.com/aws/aws-sdk-go/service/s3"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
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
		})
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccCloudWatchOidcManual(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "cloudwatchOidcManual"),

			// TODO[pulumi/pulumi-aws#3193] multiple issues with refreshing and updating cleanly.
			SkipRefresh:              true,
			AllowEmptyPreviewChanges: true,
			AllowEmptyUpdateChanges:  true,
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
			RunUpdateTest: false, // new feature!
			Dir:           filepath.Join(getCwd(t), "lambda-container-image"),
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
			RequireService: true,
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

			// TODO[pulumi/pulumi-aws#3303] does not refresh cleanly
			SkipRefresh: true,
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

	test.SetConfig("listenerPort", "80")
	test.Up()
	test.SetConfig("listenerPort", "81")
	test.Up()
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

	test.SetConfig("runtime", "nodejs18.x")
	res := test.Up()
	lambdaName := res.Outputs["lambda_name"]
	lambdaRole := res.Outputs["lambda_role"]

	secondStack := test.InstallStack("new_stack")

	// Check that we can reimport the lambda.
	secondStack.SetConfig("lambda_name", lambdaName.Value.(string))
	secondStack.SetConfig("runtime", "nodejs18.x")
	secondStack.SetConfig("lambda_role", lambdaRole.Value.(string))
	secondStack.Up()

	// Check that we can change a property on the lambda
	secondStack.SetConfig("runtime", "nodejs16.x")
	secondStack.Up()
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
	require.Equal(t, engineVersion.Value, "15.2")
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
