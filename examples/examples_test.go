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

	"github.com/stretchr/testify/assert"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/lambda"
	"github.com/pulumi/pulumi/pkg/testing/integration"
)

func TestExamples(t *testing.T) {
	envRegion := os.Getenv("AWS_REGION")
	if envRegion == "" {
		t.Skipf("Skipping test due to missing AWS_REGION environment variable")
	}

	cwd, err := os.Getwd()
	if !assert.NoError(t, err, "expected a valid working directory: %v", err) {
		return
	}

	// base options shared amongst all tests. Explicitly set region to an invalid value to ensure
	// that we're only using the region given by an explicit provider in code.
	base := integration.ProgramTestOptions{
		ExpectRefreshChanges: true,
		SkipRefresh:          true,
		Quick:                true,
	}

	baseJS := base.With(integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region":    "INVALID_REGION",
			"aws:envRegion": envRegion,
		},
		Dependencies: []string{
			"@pulumi/aws",
		},
	})

	basePython := base.With(integration.ProgramTestOptions{
		Config: map[string]string{"aws:region": envRegion},
		Dependencies: []string{
			filepath.Join("..", "sdk", "python", "bin"),
		},
	})

	shortTests := []integration.ProgramTestOptions{
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "minimal")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "express")}),
		// TODO[pulumi/pulumi#1900]: This should be the default value, every test we have causes some sort of
		// change during a `pulumi refresh` for reasons outside our control.
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "alb-legacy")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "alb-new")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "bucket")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "cloudwatch")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "logGroup")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "queue")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "stream")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "table")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "topic")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "ssmparameter")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "route53")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "lambda-layer")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "ecr")}),
		baseJS.With(integration.ProgramTestOptions{
			Dir: path.Join(cwd, "delete_before_create", "mount_target", "step1"),
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
		}),
		baseJS.With(integration.ProgramTestOptions{
			Dir: path.Join(cwd, "ignoreChanges"),
			EditDirs: []integration.EditDir{
				{
					Dir:      path.Join(cwd, "ignoreChanges", "step1"),
					Additive: true,
					ExtraRuntimeValidation: func(t *testing.T, info integration.RuntimeValidationStackInfo) {
						// Verify that the change to `"bar"` was succesfully ignored.
						assert.Equal(t, "foo", info.Deployment.Resources[2].Inputs["bucketPrefix"])
						assert.Equal(t, "foo", info.Deployment.Resources[2].Outputs["bucketPrefix"])
					},
				},
			},
		}),
		baseJS.With(integration.ProgramTestOptions{
			Dir: path.Join(cwd, "serverless_functions"),
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
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
			},
		}),
		// Python tests:
		basePython.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "webserver-py")}),
		basePython.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "alb-legacy-py")}),
		basePython.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "alb-new-py")}),
	}

	longTests := []integration.ProgramTestOptions{
		// JavaScript tests:
		baseJS.With(integration.ProgramTestOptions{
			Dir: path.Join(cwd, "webserver"),
			EditDirs: []integration.EditDir{
				// First, look up the server just created using get.  No new resources.
				createEditDir(path.Join(cwd, "webserver", "variants", "get")),
				// Next, patch the ingress rules by adding port 20: should be a quick update.
				createEditDir(path.Join(cwd, "webserver", "variants", "ssh")),
				// Now do the reverse; this basically ensures that an update that deletes a property works.
				createEditDir(path.Join(cwd, "webserver")),
				// Next patch the security group description, necessitating a full replacement of resources.
				createEditDir(path.Join(cwd, "webserver", "variants", "ssh_description")),
			},
		}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "webserver", "variants", "zones")}),
		baseJS.With(integration.ProgramTestOptions{
			Dir: path.Join(cwd, "webserver-comp"),
			// Verify that credentials can be passed via explicit configuration
			Secrets: map[string]string{
				"aws:accessKey": os.Getenv("AWS_ACCESS_KEY_ID"),
				"aws:secretKey": os.Getenv("AWS_SECRET_ACCESS_KEY"),
			},
		}),
		baseJS.With(integration.ProgramTestOptions{
			Dir: path.Join(cwd, "serverless-raw"),
			// Two changes are known to occur during refresh of the resources in this example:
			// * `~  aws:apigateway:Method myrestapi-method updated changes: + authorizationScopes,...`
			// * `~  aws:lambda:Function mylambda-logcollector updated changes: ~ lastModified`
			ExpectRefreshChanges: true,
		}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "serverless")}),
		baseJS.With(integration.ProgramTestOptions{Dir: path.Join(cwd, "multiple-regions")}),
		// Go tests:
		integration.ProgramTestOptions{
			Dir:    path.Join(cwd, "webserver-go"),
			Config: map[string]string{"aws:region": envRegion},
		},
	}

	tests := shortTests
	if !testing.Short() {
		tests = append(tests, longTests...)
	}

	for _, ex := range tests {
		example := ex
		t.Run(example.Dir, func(t *testing.T) {
			integration.ProgramTest(t, &example)
		})
	}
}

func createEditDir(dir string) integration.EditDir {
	return integration.EditDir{Dir: dir, ExtraRuntimeValidation: nil}
}

func validateAPITest(isValid func(body string)) func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
	return func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
		var resp *http.Response
		var err error
		url := stack.Outputs["url"].(string)
		// Retry a couple times on 5xx
		for i := 0; i < 2; i++ {
			resp, err = http.Get(url + "/b")
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
