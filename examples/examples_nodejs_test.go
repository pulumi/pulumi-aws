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
	"testing"
	"time"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/lambda"
	"github.com/aws/aws-sdk-go/service/s3"
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

// This is a specific test to ensure that we are testing for a missing region and erroring
func TestAccCredentialsConfigTest(t *testing.T) {
	t.Skip("STACK72: Temp skip until we investigate the cause of https://github.com/pulumi/pulumi-aws/issues/1995")
	baseJS := integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region": "INVALID_REGION",
		},
		Dependencies: []string{
			"@pulumi/aws",
		},
		Dir:           filepath.Join(getCwd(t), "credentialsConfigTest"),
		ExpectFailure: true,
	}

	integration.ProgramTest(t, &baseJS)
}

func TestAccMinimal(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "minimal"),
		})

	integration.ProgramTest(t, &test)
}

func TestAccExpress(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "express"),
			RunUpdateTest: true,
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
			}})

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

	// TODO[pulumi/pulumi-aws#3190] there is a bug with non-empty diff after pulumi up.
	test.AllowEmptyPreviewChanges = true
	test.AllowEmptyUpdateChanges = true

	integration.ProgramTest(t, &test)
}

func TestRegress1423Ts(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "regress-1423"),
			RunUpdateTest: false,
		})
	test.ExpectRefreshChanges = false
	test.Quick = false
	test.SkipRefresh = false
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
