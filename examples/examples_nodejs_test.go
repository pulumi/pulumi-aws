// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
// +build nodejs all

package examples

import (
	"os"
	"path/filepath"
	"testing"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/lambda"
	"github.com/pulumi/pulumi/pkg/v2/testing/integration"
	"github.com/stretchr/testify/assert"
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
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "express"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccBucketWithS3State(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "bucket"),
			RunUpdateTest: true,
			CloudURL:      "s3://ci-remote-state-bucket",
		})

	integration.ProgramTest(t, &test)
}

func TestAccCloudWatch(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "cloudwatch"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccLogGroup(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "logGroup"),
			RunUpdateTest: false,
		})

	integration.ProgramTest(t, &test)
}

func TestAccQueue(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "queue"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccStream(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "stream"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccTable(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "table"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccTopic(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "topic"),
			RunUpdateTest: true,
		})

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

	integration.ProgramTest(t, &test)
}

func TestAccLambdaLayer(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "lambda-layer-old"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccLambdaContainerImages(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			RunUpdateTest: false, // new feature!
			Dir:           filepath.Join(getCwd(t), "lambda-container-image"),
		})

	integration.ProgramTest(t, &test)
}

func TestAccLambdaLayerNewEnums(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "lambda-layer-new"),
			RunUpdateTest: false,
		})

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

func TestAccAlbLegacy(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "alb-legacy"),
			// RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccAlbNew(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "alb-new"),
			// RunUpdateTest: true,
			EditDirs: []integration.EditDir{
				{
					Dir:             "step2",
					Additive:        true,
					ExpectNoChanges: true,
				},
			},
		})

	integration.ProgramTest(t, &test)
}

func TestAccDeleteBeforeCreate(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "delete_before_create", "mount_target", "step1"),
			RunUpdateTest: true,
			EditDirs: []integration.EditDir{
				{
					Dir:      "step2",
					Additive: true,
				},
				{
					Dir:      "step3",
					Additive: true,
				},
			},
		})

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

func TestAccRenameSesConfiguration(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "rename-ses-configuration-set"),
			RunUpdateTest: true,
			EditDirs: []integration.EditDir{
				{
					Dir:             "step2",
					Additive:        true,
					ExpectNoChanges: true,
				},
			}})

	integration.ProgramTest(t, &test)
}

func TestAccServerlessFunctions(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "serverless_functions"),
			RunUpdateTest: true,
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				// Since we are relying on the AWS credentials file locally, we need to
				// force this to be used.
				os.Setenv("AWS_SDK_LOAD_CONFIG", "1")

				cfg := &aws.Config{
					Region: aws.String("us-west-2"),
				}
				sess, err := session.NewSession(cfg)
				if !assert.NoError(t, err) {
					return
				}
				lambdaSvc := lambda.New(sess)
				out, err := lambdaSvc.Invoke(&lambda.InvokeInput{
					FunctionName: aws.String(stack.Outputs["functionARN"].(string)),
				})
				if !assert.NoError(t, err) {
					return
				}

				if out.FunctionError != nil {
					assert.Nil(t, out.FunctionError, "Function error: %q\n", *out.FunctionError)
				}
			}})

	integration.ProgramTest(t, &test)
}

func TestAccWebserver(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "webserver"),
			EditDirs: []integration.EditDir{
				// First, look up the server just created using get.  No new resources.
				createEditDir(filepath.Join(getCwd(t), "webserver", "variants", "get")),
				// Next, patch the ingress rules by adding port 20: should be a quick update.
				createEditDir(filepath.Join(getCwd(t), "webserver", "variants", "ssh")),
				// Now do the reverse; this basically ensures that an update that deletes a property works.
				createEditDir(filepath.Join(getCwd(t), "webserver")),
				// Next patch the security group description, necessitating a full replacement of resources.
				createEditDir(filepath.Join(getCwd(t), "webserver", "variants", "ssh_description")),
			}})

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

func TestAccServerless(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "serverless"),
			RunUpdateTest: true,
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

func getJSBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	base := getBaseOptions()
	baseJS := base.With(integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region":    "INVALID_REGION",
			"aws:envRegion": envRegion,
		},
		Dependencies: []string{
			"@pulumi/aws",
		},
	})

	return baseJS
}
