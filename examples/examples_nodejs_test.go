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
	"fmt"
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
	"github.com/pulumi/providertest/optproviderupgrade"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/assertup"
	"github.com/pulumi/providertest/pulumitest/optnewstack"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optup"
	"github.com/pulumi/pulumi/sdk/v3/go/common/apitype"
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

func TestAccExpress(t *testing.T) {
	// This example is reused to further validate that provisioned CallbackFunctions in Node are working at runtime
	// as expected, in particular their default runtime is not deprecated and they can utilize modern APIs like
	// fetch().
	validate := func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
		lambdaRuntime := stack.Outputs["lambdaRuntime"].(string)
		t.Logf("Picked the following runtime by default: %v", lambdaRuntime)
		assert.Equal(t, "nodejs22.x", lambdaRuntime)

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
	t.Skip("temporarily disabled, see https://github.com/pulumi/pulumi-aws/issues/6272")
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

func TestAccLambdaContainerImages(t *testing.T) {
	// TODO[pulumi/pulumi-awsx#1612]
	t.Skipf("Skipping test until awsx is update to use getAuthorizationToken %s", t.Name())
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "lambda-container-image"),
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

func TestGlobalResourcesUseSeparateRegionArgument(t *testing.T) {
	skipIfShort(t)
	t.Parallel()
	test := pulumitest.NewPulumiTest(t, "test-programs/global-region-res",
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	)

	// only preview is needed to verify this
	test.Preview(t)
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
	skipIfShort(t)
	t.Parallel()
	test := pulumitest.NewPulumiTest(t, "lambda-import-ts",
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	)

	test.SetConfig(t, "runtime", "nodejs18.x")
	test.SetConfig(t, "aws:region", "us-west-2")
	res := test.Up(t)
	lambdaName := res.Outputs["lambda_name"]
	lambdaRole := res.Outputs["lambda_role"]
	runtime := "nodejs18.x"

	secondStack := test.InstallStack(t, "new_stack")

	// Check that we can reimport the lambda.
	secondStack.SetConfig(t, "lambda_name", lambdaName.Value.(string))
	secondStack.SetConfig(t, "runtime", runtime)
	secondStack.SetConfig(t, "aws:region", "us-west-2")
	secondStack.SetConfig(t, "lambda_role", lambdaRole.Value.(string))
	up2Res := secondStack.Up(t)
	assert.Equal(t, map[string]int{
		"create": 2, // the stack and the provider
		"import": 2, // the role and the lambda
	}, *up2Res.Summary.ResourceChanges)

	// Check that we can change a property on the lambda
	runtime = "nodejs20.x"
	secondStack.SetConfig(t, "runtime", runtime)
	secondStack.Up(t)

	thirdStack := test.InstallStack(t, "region_stack")

	// Check that we can reimport the lambda in a different region
	thirdStack.SetConfig(t, "lambda_name", fmt.Sprintf("%s@us-west-2", lambdaName.Value.(string)))
	thirdStack.SetConfig(t, "runtime", runtime)
	thirdStack.SetConfig(t, "lambda_role", lambdaRole.Value.(string))
	thirdStack.SetConfig(t, "aws:region", "us-east-1")
	thirdStack.SetConfig(t, "lambda_region", "us-west-2")
	up3Res := thirdStack.Up(t)
	assert.Equal(t, map[string]int{
		"create": 2, // the stack and the provider
		"import": 2, // the role and the lambda
	}, *up3Res.Summary.ResourceChanges)
}

func TestImportResourceNew(t *testing.T) {
	skipIfShort(t)
	t.Parallel()
	test := pulumitest.NewPulumiTest(t, filepath.Join(getCwd(t), "test-programs", "resource-import-ts"),
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	)

	test.SetConfig(t, "aws:region", "us-west-2")
	res := test.Up(t)
	queueArn := res.Outputs["queue_arn"]
	reportGroupArn := res.Outputs["report_group_arn"]
	vpcId := res.Outputs["vpc_id"]
	subnetId := res.Outputs["subnet_id"]
	computeEnvArn := res.Outputs["compute_env_arn"]
	securityGroupId := res.Outputs["security_group_id"]
	roleName := res.Outputs["role_name"]
	policyAttachmentArn := res.Outputs["policy_attachment_arn"]

	secondStack := test.InstallStack(t, "new_stack", optnewstack.DisableAutoDestroy())

	// Check that we can reimport the resources in the same region.
	secondStack.SetConfig(t, "queue_arn", queueArn.Value.(string))
	secondStack.SetConfig(t, "aws:region", "us-west-2")
	secondStack.SetConfig(t, "report_group_arn", reportGroupArn.Value.(string))
	secondStack.SetConfig(t, "vpc_id", vpcId.Value.(string))
	secondStack.SetConfig(t, "subnet_id", subnetId.Value.(string))
	secondStack.SetConfig(t, "compute_env_arn", computeEnvArn.Value.(string))
	secondStack.SetConfig(t, "security_group_id", securityGroupId.Value.(string))
	secondStack.SetConfig(t, "role_name", roleName.Value.(string))
	secondStack.SetConfig(t, "policy_attachment_arn", policyAttachmentArn.Value.(string))
	up2Res := secondStack.Up(t)
	assert.Equal(t, map[string]int{
		"create": 2, // the stack and the provider
		"import": 8,
	}, *up2Res.Summary.ResourceChanges)

	thirdStack := test.InstallStack(t, "region_stack", optnewstack.DisableAutoDestroy())

	// Check that we can reimport the resources in a different region
	thirdStack.SetConfig(t, "queue_arn", queueArn.Value.(string))
	thirdStack.SetConfig(t, "report_group_arn", reportGroupArn.Value.(string))
	thirdStack.SetConfig(t, "vpc_id", vpcId.Value.(string))
	thirdStack.SetConfig(t, "subnet_id", subnetId.Value.(string))
	thirdStack.SetConfig(t, "compute_env_arn", computeEnvArn.Value.(string))
	thirdStack.SetConfig(t, "security_group_id", securityGroupId.Value.(string))
	thirdStack.SetConfig(t, "role_name", roleName.Value.(string))
	thirdStack.SetConfig(t, "policy_attachment_arn", policyAttachmentArn.Value.(string))
	thirdStack.SetConfig(t, "aws:region", "us-east-1")
	thirdStack.SetConfig(t, "import_region", "us-west-2")
	up3Res := thirdStack.Up(t)
	assert.Equal(t, map[string]int{
		"create": 2, // the stack and the provider
		"import": 8,
	}, *up3Res.Summary.ResourceChanges)
}

func TestNoCodeLambda(t *testing.T) {
	skipIfShort(t)
	t.Parallel()
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
	skipIfShort(t)
	t.Parallel()
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

func TestPolicyDocumentUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("iam-policy-document", "ts"), &testProviderUpgradeOptions{
		linkNodeSDK: false,
		installDeps: true,
	})
}

func TestLifecyclePolicyDocumentUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("ecr"), nodeProviderUpgradeOpts())
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

func TestSsmParameterUpgrade(t *testing.T) {
	testProviderUpgrade(t, "ssmparameter", nodeProviderUpgradeOpts())
}

func TestRoute53Upgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("route53"), nodeProviderUpgradeOpts())
}

// This test requires `--refresh` to perform the state migrations
// `--refresh` means we have to disable the cache to run the initial deployment
func TestJobQueueUpgrade(t *testing.T) {
	opts := nodeProviderUpgradeOpts()
	opts.setEnvRegion = false
	opts.skipCache = true
	opts.skipDefaultPreviewTest = true
	test, _ := testProviderUpgrade(t, filepath.Join("test-programs", "job-queue"), opts,
		optproviderupgrade.NewSourcePath(filepath.Join("test-programs", "job-queue", "step1")))

	test.Preview(t, optpreview.Refresh(), optpreview.Diff(), optpreview.ExpectNoChanges())
}

// This test requires `--refresh` to perform the state migrations
// `--refresh` means we have to disable the cache to run the initial deployment
func TestBucketToBucketUpgradeTs(t *testing.T) {
	opts := nodeProviderUpgradeOpts()
	opts.setEnvRegion = false
	opts.skipCache = true
	opts.skipDefaultPreviewTest = true
	opts.runProgram = true
	test, _ := testProviderUpgrade(t, filepath.Join("bucket-to-bucket", "ts"), opts,
		optproviderupgrade.NewSourcePath(filepath.Join("bucket-to-bucket", "ts", "step1")))

	res := test.Preview(t, optpreview.Refresh(), optpreview.Diff(), optpreview.ProgressStreams(os.Stdout), optpreview.ErrorProgressStreams(os.Stderr))
	assert.Equal(t, map[apitype.OpType]int{
		apitype.OpUpdate: 1, // the provider gets updated because of the version update
		apitype.OpSame:   9,
	}, res.ChangeSummary)
}

// This test requires `--refresh` to perform the state migrations
// `--refresh` means we have to disable the cache to run the initial deployment
func TestBucketV2ToBucketV2UpgradeTs(t *testing.T) {
	opts := nodeProviderUpgradeOpts()
	opts.setEnvRegion = false
	testProviderUpgrade(t, "bucketv2-to-bucketv2", opts)
}

func TestMultipleRegionsUpgrade(t *testing.T) {
	skipIfShort(t)
	t.Parallel()
	test := pulumitest.NewPulumiTest(t, filepath.Join(getCwd(t), "multiple-regions"),
		opttest.LocalProviderPath("aws", filepath.Join(getCwd(t), "..", "bin")),
		opttest.YarnLink("@pulumi/aws"),
	)

	test.Up(t)

	exported := test.ExportStack(t)

	upgradeStack := test.CopyToTempDir(t, opttest.NewStackOptions(optnewstack.DisableAutoDestroy()))
	upgradeStack.UpdateSource(t, filepath.Join(getCwd(t), "multiple-regions-v7"))
	upgradeStack.ImportStack(t, exported)

	res := upgradeStack.Preview(t, optpreview.Diff(), optpreview.Refresh())

	assert.Equal(t, map[apitype.OpType]int{
		apitype.OpDelete: 1, // One of the providers is removed
		apitype.OpSame:   10,
	}, res.ChangeSummary)
}

func nodeProviderUpgradeOpts() *testProviderUpgradeOptions {
	return &testProviderUpgradeOptions{
		linkNodeSDK:  true,
		installDeps:  true,
		setEnvRegion: true,
	}
}

func TestChangingRegion(t *testing.T) {
	skipIfShort(t)
	t.Parallel()
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
		for i, region := range []string{"us-east-1", "us-west-1"} {
			test.SetConfig(t, "aws:region", region)
			res := test.Up(t, optup.Diff())
			t.Log(res.Summary.ResourceChanges)
			if i == 1 {
				assert.Equal(t, *res.Summary.ResourceChanges, map[string]int{
					"replace": 1,
					"same":    1,
				})
			}

			require.Equal(t, region, res.Outputs["actualRegion"].Value)
		}
	})

	t.Run("explicit provider", func(t *testing.T) {
		test := pulumitest.NewPulumiTest(t, dir, options...)
		for i, region := range []string{"us-east-1", "us-west-1"} {
			test.SetConfig(t, "desired-region", region)
			res := test.Up(t, optup.Diff())
			t.Log(res.Summary.ResourceChanges)
			if i == 1 {
				assert.Equal(t, *res.Summary.ResourceChanges, map[string]int{
					"replace": 1,
					"same":    1,
					"update":  1,
				})
			}
			require.Equal(t, region, res.Outputs["actualRegion"].Value)
		}
	})
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

func TestRegress5219(t *testing.T) {
	skipIfShort(t)
	t.Parallel()
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

// Regress aws_route update failing with "route target attribute not
// specified" when only customTimeouts changes, see pulumi/pulumi-aws#6549
func TestRegress6549(t *testing.T) {
	opts := nodeProviderUpgradeOpts()
	opts.skipDefaultPreviewTest = true
	opts.setEnvRegion = false
	dir := filepath.Join("test-programs", "regress-6549")
	test, _ := testProviderUpgrade(t, dir, opts,
		optproviderupgrade.NewSourcePath(filepath.Join(dir, "step1")))

	res := test.Up(t, optup.Diff())

	// The v6->v7 provider upgrade itself introduces incidental diffs on
	// unrelated resources (e.g. new computed attributes), so assert only on
	// what this regression test cares about: the update succeeds and the
	// Route is not replaced.
	assertup.HasNoReplacements(t, res)
	assert.NotZero(t, (*res.Summary.ResourceChanges)["update"])
}

// Regress an upstream aws_rds_cluster bug where changing storage_type on a
// non-Aurora Multi-AZ cluster incorrectly forced a replacement, even though
// the AWS ModifyDBCluster API supports the change in place. See
// hashicorp/terraform-provider-aws#48545.
func TestRegressRDSClusterStorageTypeUpdateNonAurora(t *testing.T) {
	skipIfShort(t)
	t.Parallel()
	dir := filepath.Join("test-programs", "regress-rds-storage-type")
	cwd, err := os.Getwd()
	require.NoError(t, err)
	test := pulumitest.NewPulumiTest(t, dir,
		opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
	)
	test.SetConfig(t, "aws:region", getEnvRegion(t))
	test.SetConfig(t, "storageType", "io1")
	test.Up(t)

	test.SetConfig(t, "storageType", "gp3")
	res := test.Up(t, optup.Diff())

	assertup.HasNoReplacements(t, res)
	assert.NotZero(t, (*res.Summary.ResourceChanges)["update"])
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
	t.Parallel()
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
	t.Parallel()
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
	outputs, err := test.CurrentStack().Outputs(test.Context())
	require.NoError(t, err)
	bucketName, ok := outputs["bucketName"].Value.(string)
	require.True(t, ok)
	assert.Containsf(t,
		rr.StdErr+rr.StdOut,
		fmt.Sprintf("warning: S3 Object (%s/index.ts) not found, removing from state", bucketName),
		"Expected upstream log.Printf to propagate under TF_LOG=DEBUG")
}

func TestAccProviderRoleChaining(t *testing.T) {
	skipIfShort(t)
	region := getEnvRegion(t)
	test := integration.ProgramTestOptions{
		Dir: filepath.Join(getCwd(t), "provider-role-chaining"),
		Dependencies: []string{
			"@pulumi/aws",
		},
		Config: map[string]string{
			"aws-native:region": region,
			"aws:region":        region,
		},
	}
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

func TestAccConfigureClusterAddons(t *testing.T) {
	skipIfShort(t)
	region := getEnvRegion(t)
	test := integration.ProgramTestOptions{
		Dir: filepath.Join(getCwd(t), "eks-remove-addons"),
		Dependencies: []string{
			"@pulumi/aws",
		},
		Config: map[string]string{
			"aws:region": region,
		},
	}
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
}

// also test the release verification test so it will also fail in CI
func TestReleaseVerification(t *testing.T) {
	region := getEnvRegion(t)
	test := integration.ProgramTestOptions{
		Dir: filepath.Join(getCwd(t), "release-verification"),
		Dependencies: []string{
			"@pulumi/aws",
		},
		Config: map[string]string{
			"aws:region": region,
		},
	}
	skipRefresh(&test)
	integration.ProgramTest(t, &test)
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

func TestResourceRefsMigrateCleanlyToStringRefs(t *testing.T) {
	// See pulumi/pulumi-aws#5540
	t.Skip("Skipping for now since we are not removing resource references")
	skipIfShort(t)
	t.Parallel()
	resourceRefMigrateDir := "migrate-resource-refs"
	dirs := []string{
		filepath.Join(resourceRefMigrateDir, "autoscalinggroup"),
		filepath.Join(resourceRefMigrateDir, "elasticbeanstalk"),
		filepath.Join(resourceRefMigrateDir, "cloudwatch-with-topic"),
		filepath.Join(resourceRefMigrateDir, "bucketobject"),
		filepath.Join(resourceRefMigrateDir, "iamresources"),
		filepath.Join(resourceRefMigrateDir, "apigatewaystage"),
		filepath.Join(resourceRefMigrateDir, "iotpolicy"),
		filepath.Join(resourceRefMigrateDir, "lambdapermission"),
		filepath.Join(resourceRefMigrateDir, "managedpolicy"),
	}
	cwd, err := os.Getwd()
	require.NoError(t, err)

	for _, dir := range dirs {
		t.Run(dir, func(t *testing.T) {
			t.Parallel()
			options := []opttest.Option{
				opttest.AttachDownloadedPlugin("aws", "6.80.0"),
			}
			test := pulumitest.NewPulumiTest(t, dir, options...)
			result := test.Up(t)
			t.Logf("Deployment result: %v", result.Summary)
			state := test.ExportStack(t)

			v7Options := []opttest.Option{
				opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
				opttest.YarnLink("@pulumi/aws"),
			}
			v7Test := pulumitest.NewPulumiTest(t, dir, v7Options...)
			v7Test.ImportStack(t, state)
			// TODO[pulumi/pulumi-aws#5521] `region` and tagsAll cause permanent diff without refresh
			v7Test.Refresh(t)

			v7Test.UpdateSource(t, filepath.Join(dir, "v7"))
			updatePreviewResult := v7Test.Preview(t, optpreview.ExpectNoChanges())
			t.Logf("Updated preview result: %v", updatePreviewResult.ChangeSummary)
		})
	}
}
