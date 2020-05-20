// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package examples

import (
	"io/ioutil"
	"net/http"
	"os"
	"path"
	"path/filepath"
	"testing"
	"time"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/lambda"
	"github.com/stretchr/testify/assert"

	"github.com/pulumi/pulumi/pkg/v2/testing/integration"
)

func TestAccMinimal(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: path.Join(getCwd(t), "minimal"),
		})

	integration.ProgramTest(t, &test)
}

func TestAccExpress(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "express"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccBucket(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "bucket"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccBucketWithS3State(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "bucket"),
			RunUpdateTest: true,
			CloudURL:      "s3://ci-remote-state-bucket",
		})

	integration.ProgramTest(t, &test)
}

func TestAccCloudWatch(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "cloudwatch"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccLogGroup(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "logGroup"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccQueue(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "queue"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccStream(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "stream"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccTable(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "table"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccTopic(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "topic"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccSsmParameter(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "ssmparameter"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccSsmParameterWithS3State(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "ssmparameter"),
			RunUpdateTest: true,
			CloudURL:      "s3://ci-remote-state-bucket",
		})

	integration.ProgramTest(t, &test)
}

func TestAccRoute53(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "route53"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccLambdaLayer(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "lambda-layer"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccEcr(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "ecr"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccAlbLegacy(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: path.Join(getCwd(t), "alb-legacy"),
			// RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccAlbNew(t *testing.T) {
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: path.Join(getCwd(t), "alb-new"),
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
			Dir:           path.Join(getCwd(t), "delete_before_create", "mount_target", "step1"),
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
			Dir:           path.Join(getCwd(t), "ignoreChanges"),
			RunUpdateTest: true,
			EditDirs: []integration.EditDir{
				{
					Dir:      path.Join(getCwd(t), "ignoreChanges", "step1"),
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
			Dir:           path.Join(getCwd(t), "rename-ses-configuration-set"),
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
			Dir:           path.Join(getCwd(t), "serverless_functions"),
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
			Dir: path.Join(getCwd(t), "webserver"),
			EditDirs: []integration.EditDir{
				// First, look up the server just created using get.  No new resources.
				createEditDir(path.Join(getCwd(t), "webserver", "variants", "get")),
				// Next, patch the ingress rules by adding port 20: should be a quick update.
				createEditDir(path.Join(getCwd(t), "webserver", "variants", "ssh")),
				// Now do the reverse; this basically ensures that an update that deletes a property works.
				createEditDir(path.Join(getCwd(t), "webserver")),
				// Next patch the security group description, necessitating a full replacement of resources.
				createEditDir(path.Join(getCwd(t), "webserver", "variants", "ssh_description")),
			}})

	integration.ProgramTest(t, &test)
}

func TestAccWebserverVariants(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "webserver", "variants", "zones"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccWebserverComp(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "webserver-comp"),
			RunUpdateTest: true,
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
			Dir:           path.Join(getCwd(t), "serverless-raw"),
			RunUpdateTest: true,
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
			Dir:           path.Join(getCwd(t), "serverless"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccMultipleRegions(t *testing.T) {
	skipIfShort(t)
	test := getJSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: path.Join(getCwd(t), "multiple-regions"),
			// RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccWebserverGo(t *testing.T) {
	t.Skip("Chicken and egg wile creating this new major version")
	skipIfShort(t)
	test := integration.ProgramTestOptions{
		Dir: path.Join(getCwd(t), "webserver-go"),
		Dependencies: []string{
			"github.com/pulumi/pulumi-aws/sdk/v2",
		},
		Config: map[string]string{"aws:region": getEnvRegion(t)},
	}

	integration.ProgramTest(t, &test)
}

func TestAccBucketPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "bucket-py"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccWebserverPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "webserver-py"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccAlbLegacyPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "alb-legacy-py"),
			RunUpdateTest: true,
		})

	integration.ProgramTest(t, &test)
}

func TestAccAlbNewPy(t *testing.T) {
	test := getPythonBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           path.Join(getCwd(t), "alb-new-py"),
			RunUpdateTest: true,
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

func TestAccWebserverCs(t *testing.T) {
	test := getCSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: path.Join(getCwd(t), "webserver-cs"),
		})

	integration.ProgramTest(t, &test)
}

func createEditDir(dir string) integration.EditDir {
	return integration.EditDir{Dir: dir, ExtraRuntimeValidation: nil}
}

func skipIfShort(t *testing.T) {
	if testing.Short() {
		t.Skip("skipping long-running test in short mode")
	}
}

func getEnvRegion(t *testing.T) string {
	envRegion := os.Getenv("AWS_REGION")
	if envRegion == "" {
		t.Skipf("Skipping test due to missing AWS_REGION environment variable")
	}

	return envRegion
}

func getCwd(t *testing.T) string {
	cwd, err := os.Getwd()
	if err != nil {
		t.FailNow()
	}

	return cwd
}

func getBaseOptions() integration.ProgramTestOptions {
	return integration.ProgramTestOptions{
		ExpectRefreshChanges: true,
		SkipRefresh:          true,
		Quick:                true,
	}
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

func getPythonBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	base := getBaseOptions()
	pythonBase := base.With(integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region": envRegion,
		},
		Dependencies: []string{
			filepath.Join("..", "sdk", "python", "bin"),
		},
	})

	return pythonBase
}

func getCSBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	base := getBaseOptions()
	csharpBase := base.With(integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region": envRegion,
		},
		Dependencies: []string{
			"Pulumi.Aws",
		},
	})

	return csharpBase
}

func validateAPITest(isValid func(body string)) func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
	return func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
		var resp *http.Response
		var err error
		url := stack.Outputs["url"].(string)
		// Retry a couple times on 5xx
		for i := 0; i < 5; i++ {
			resp, err = http.Get(url)
			if !assert.NoError(t, err) {
				return
			}
			if resp.StatusCode < 500 {
				break
			}
			time.Sleep(10 * time.Second)
		}
		defer resp.Body.Close()
		body, err := ioutil.ReadAll(resp.Body)
		assert.NoError(t, err)
		isValid(string(body))
	}
}
