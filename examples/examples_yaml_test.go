// Copyright 2016-2024, Pulumi Corporation.
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

//go:build java || all
// +build java all

package examples

// NOTE about build tags: CI does not understand yaml-specific tags yet, but splits builds per language to run on
// separate runners. This file piggy-backs on the java tag so yaml tests will run on the same runner as java tests.

import (
	"bytes"
	"context"
	"encoding/json"
	"fmt"
	"io"
	"math/rand"
	"os"
	"os/exec"
	"path/filepath"
	"runtime"
	"sort"
	"strconv"
	"strings"
	"testing"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	appconfigsdk "github.com/aws/aws-sdk-go-v2/service/appconfig"
	tagsdk "github.com/aws/aws-sdk-go-v2/service/resourcegroupstaggingapi"
	s3sdk "github.com/aws/aws-sdk-go-v2/service/s3"
	"github.com/aws/aws-sdk-go-v2/service/s3/types"
	"github.com/pulumi/providertest/optproviderupgrade"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/assertpreview"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/auto"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optrefresh"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optup"
	"github.com/pulumi/pulumi/sdk/v3/go/common/apitype"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

// This test is not a proper examlpe but a test of the new capability to deploy Plugin Framework and SDKv2 based
// resources alongside each other in the same provider.
func TestAccPluginFramework(t *testing.T) {
	test := getYamlBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir: filepath.Join(getCwd(t), "plugin-framework"),
		})

	integration.ProgramTest(t, &test)
}

func TestEKSClusterUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "eks-cluster"), nil)
}

func TestRdsInstanceUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "rds-instance"), nil)
}

func TestRoute53ResolverEndpointUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "route53-resolver-endpoint"), nil)
}

func TestSnsTopicUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "sns-topic"), nil)
}

func TestApiGatewayIntegrationResponseUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "apigateway-integrationresponse"), nil)
}

func TestApiGatewayMethodResponseUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "apigateway-methodreponse"), nil)
}

func TestApiGatewayResourceUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "apigateway-resource"), nil)
}

func TestApiGatewayResourceResponseUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "apigateway-resource-response"), nil)
}

func TestCloudwatchEventRuleUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "cloudwatch-eventrule"), nil)
}

func TestCloudwatchLogGroupUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "cloudwatch-loggroup"), nil)
}

func TestDynamoTableUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "dynamodb-table"), nil)
}

func TestEcrLifecyclePolicyUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "ecr-lifecyclepolicy"), nil)
}

func TestEcrRepositoryUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "ecr-repository"), nil)
}

func TestIamInstanceProfileUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "iam-instanceprofile"), nil)
}

func TestIamOpenIDConnectProviderUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "iam-openidconnectprovider"), nil)
}

func TestKmsKeyUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "kms-key"), nil)
}

func TestSecretsManagerSecretUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "secretsmanager-secret"), nil)
}

func TestEC2NetworkingUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "ec2-networking"), nil)
}

func TestECSServiceUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "ecs-service"), nil)
}

func TestIAMUserUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "iam-user"), nil)
}

func TestLBUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "lb"), nil)
}

func TestACMUpgrade(t *testing.T) {
	t.Skip("Blocked by https://github.com/pulumi/pulumi-aws/issues/3617")
	testProviderUpgrade(t, filepath.Join("test-programs", "acm"), nil)
}

func TestBucketObjUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "bucket-obj"), nil)
}

func TestSubnetGroupUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "subnet-group"), nil)
}

func TestEC2InstanceUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "ec2-instance"), nil)
}

func TestCloudfrontDistributionUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "cloudfront-distribution"), nil)
}

func TestSecretVersionUpgrade(t *testing.T) {
	// NOTE: to regenerate this test you need to unsanitize the secret values in state
	// The secretbinary value is an empty string, but get sanitized to a non-empty string
	testProviderUpgrade(t, filepath.Join("test-programs", "secretversion"), nil)
}

func TestElasticacheReplicationGroupUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "elasticache-replication-group"), nil)
}

func TestS3BucketToBucketUpgrade(t *testing.T) {
	/*previewRes := */ testProviderUpgrade(t, "bucket-to-bucket", nil,
		optproviderupgrade.NewSourcePath(filepath.Join("bucket-to-bucket", "step1")),
	)
	// TODO: [pulumi-aws#5514] fix bucket v7 upgrade
	// assertpreview.HasNoChanges(t, previewRes)
}

func TestS3BucketV2ToBucketUpgrade(t *testing.T) {
	/*previewRes := */ testProviderUpgrade(t, "bucketv2-to-bucket", nil,
		optproviderupgrade.NewSourcePath(filepath.Join("bucketv2-to-bucket", "step1")),
	)
	// TODO: [pulumi-aws#1111] fix bucket v7 upgrade
	// assertpreview.HasNoChanges(t, previewRes)
}

func TestS3BucketV2ToBucketSidecarUpgrade(t *testing.T) {
	test, _ := testProviderUpgrade(t, "bucket-sidecar-renames", &testProviderUpgradeOptions{
		skipDefaultPreviewTest: true,
	},
		optproviderupgrade.NewSourcePath(filepath.Join("bucket-sidecar-renames", "step1")),
	)
	diff := runPreviewWithPlanDiff(t, test)
	assert.Equal(t, map[string]interface{}{}, diff)
}

func TestRdsParameterGroupUnclearDiff(t *testing.T) {
	t.Parallel()
	if testing.Short() {
		t.Skipf("Skipping in testing.Short() mode, assuming this is a CI run without credentials")
	}

	type yamlProgram string

	const yaml yamlProgram = `
name: project
runtime: yaml
config:
  applyMethod:
    type: string
  value:
    type: string
  randSuffix:
    type: string
resources:
  default:
    type: aws:rds/parameterGroup:ParameterGroup
    properties:
      name: securitygroup${randSuffix}
      family: postgres14
      parameters:
        - name: track_io_timing
          value: ${value}
          applyMethod: ${applyMethod}
        - name: "log_checkpoints"
          applyMethod: "pending-reboot"
          value: "1"
`

	const noApplyYaml yamlProgram = `
name: project
runtime: yaml
config:
  value:
    type: string
  randSuffix:
    type: string
resources:
  default:
    type: aws:rds/parameterGroup:ParameterGroup
    properties:
      name: securitygroup${randSuffix}
      family: postgres14
      parameters:
        - name: track_io_timing
          value: ${value}
        - name: "log_checkpoints"
          applyMethod: "pending-reboot"
          value: "1"
`

	type applyMethod string

	var immediate applyMethod = "immediate"
	var pendingReboot applyMethod = "pending-reboot"

	type testCase struct {
		name          string
		applyMethod1  *applyMethod
		value1        string
		file1         yamlProgram
		applyMethod2  *applyMethod
		value2        string
		file2         yamlProgram
		expectChanges bool
	}

	testCases := []testCase{
		{"non-nil apply method, apply method change", &immediate, "1", yaml, &pendingReboot, "1", yaml, false},
		{"non-nil apply method, value change", &immediate, "1", yaml, &immediate, "0", yaml, true},
		{"non-nil apply method, both change", &immediate, "1", yaml, &pendingReboot, "0", yaml, true},
		{"non-nil to nil apply method, apply method change", &pendingReboot, "1", yaml, nil, "1", noApplyYaml, false},
		{"non-nil to nil apply method, value change", &immediate, "1", yaml, nil, "0", noApplyYaml, true},
		{"non-nil to nil apply method, both change", &immediate, "1", yaml, nil, "0", noApplyYaml, true},
		{"nil to non-nil apply method, apply method change", nil, "1", noApplyYaml, &pendingReboot, "1", yaml, false},
		{"nil to non-nil apply method, value change", nil, "1", noApplyYaml, &immediate, "0", yaml, true},
		{"nil to non-nil apply method, both change", nil, "1", noApplyYaml, &immediate, "0", yaml, true},
		{"nil apply method, value change", nil, "1", noApplyYaml, nil, "0", noApplyYaml, true},
	}

	cwd, err := os.Getwd()
	require.NoError(t, err)

	for _, tc := range testCases {
		tc := tc

		t.Run(tc.name, func(t *testing.T) {
			t.Parallel()
			workdir := t.TempDir()

			err := os.WriteFile(filepath.Join(workdir, "Pulumi.yaml"), []byte(tc.file1), 0o600)
			require.NoError(t, err)

			pt := pulumitest.NewPulumiTest(t, workdir,
				opttest.SkipInstall(),
				opttest.TestInPlace(),
				opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
			)

			pt.SetConfig(t, "randSuffix", fmt.Sprintf("%d-x", rand.Intn(1024*1024)))

			if tc.applyMethod1 != nil {
				pt.SetConfig(t, "applyMethod", string(*tc.applyMethod1))
			}
			pt.SetConfig(t, "value", tc.value1)

			pt.Up(t)

			assertpreview.HasNoChanges(t, pt.Preview(t))

			err = os.WriteFile(filepath.Join(workdir, "Pulumi.yaml"), []byte(tc.file2), 0o600)
			require.NoError(t, err)

			if tc.applyMethod2 != nil {
				if tc.file2 == noApplyYaml {
					t.Errorf("WRONG FILE!")
				}
				pt.SetConfig(t, "applyMethod", string(*tc.applyMethod2))
			}
			pt.SetConfig(t, "value", tc.value2)

			if tc.expectChanges {
				pr := pt.Preview(t)
				assert.Equal(t, 1, pr.ChangeSummary[apitype.OpUpdate])
			} else {
				assertpreview.HasNoChanges(t, pt.Preview(t))
			}

			upr := pt.Up(t)
			t.Logf("stdout: %s", upr.StdOut)
			t.Logf("stderr: %s", upr.StdErr)

			assertpreview.HasNoChanges(t, pt.Preview(t))
		})
	}
}

var letters = []rune("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

func randSeq(n int) string {
	b := make([]rune, n)
	for i := range b {
		b[i] = letters[rand.Intn(len(letters))]
	}
	return string(b)
}

func TestNonIdempotentSnsTopic(t *testing.T) {
	t.Parallel()
	ptest := pulumiTest(t, filepath.Join("test-programs", "non-idempotent-sns-topic"), opttest.SkipInstall())

	ptest.InstallStack(t, "test")
	// generate random name
	topic_name := randSeq(12)
	ptest.SetConfig(t, "snsTopicName", topic_name)

	_, err := ptest.CurrentStack().Up(ptest.Context())
	require.ErrorContains(t, err, "already exists")
}

// Make sure that legacy Bucket supports deleting tags out of band and detecting drift.
func TestRegress3674(t *testing.T) {
	t.Parallel()
	ptest := pulumiTest(t, filepath.Join("test-programs", "regress-3674"), opttest.SkipInstall())
	upResult := ptest.Up(t)
	bucketName := upResult.Outputs["bucketName"].Value.(string)
	deleteBucketTagging(ptest.Context(), bucketName)
	result := ptest.Refresh(t)
	t.Logf("%s", result.StdOut)
	require.Equal(t, 1, (*result.Summary.ResourceChanges)["update"])
	state, err := ptest.ExportStack(t).Deployment.MarshalJSON()
	require.NoError(t, err)
	require.NotContainsf(t, string(state), "MyTestTag", "Expected MyTestTag to be removed")
}

// Ensure that pulumi-aws can authenticate using IMDS API when Pulumi is running in a context where that is made
// available such as an EC2 instance.
func TestIMDSAuth(t *testing.T) {
	t.Parallel()
	var localProviderBuild string
	actual := fmt.Sprintf("%s/%s", runtime.GOOS, runtime.GOARCH)
	expected := "linux/amd64"
	cwd, err := os.Getwd()
	require.NoError(t, err)
	if actual == expected {
		currentBinary, err := filepath.Abs(filepath.Join(cwd, "..", "bin", "pulumi-resource-aws"))
		require.NoError(t, err)
		t.Logf("Reusing prebuilt binary from %s to test %q", currentBinary, expected)
		localProviderBuild = currentBinary
	} else {
		t.Logf("Cross-compiling provider-resource-aws under test to %q", expected)
		localProviderBuild = filepath.Join(os.TempDir(), "pulumi-resource-aws")
		ldFlags := []string{
			"-X", "github.com/pulumi/pulumi-aws/provider/v7/pkg/version.Version=6.0.0-alpha.0+dev",
			"-X", "github.com/hashicorp/terraform-provider-aws/version.ProviderVersion=6.0.0-alpha.0+dev",
		}
		args := []string{
			"build", "-o", localProviderBuild,
			"-ldflags", strings.Join(ldFlags, " "),
		}
		cmd := exec.Command("go", args...)
		cmd.Dir = filepath.Join(cwd, "cmd", "pulumi-resource-aws")
		cmd.Env = os.Environ()
		cmd.Env = append(cmd.Env,
			fmt.Sprintf("GOOS=linux"),
			fmt.Sprintf("GOARCH=amd64"),
		)
		var stderr, stdout bytes.Buffer
		cmd.Stderr = &stderr
		cmd.Stdout = &stdout
		if err := cmd.Run(); err != nil {
			t.Logf("go %s failed\nStdout:\n%s\nStderr:\n%s\n", strings.Join(args, " "),
				stdout.String(), stderr.String())
			require.NoError(t, err)
		}
	}
	t.Run("IDMSv2", func(t *testing.T) {
		t.Parallel()
		ptest := pulumiTest(t, filepath.Join("test-programs", "imds-auth", "imds-v2"), opttest.SkipInstall())
		dir := ptest.WorkingDir()
		localLocation := filepath.Join(dir, "pulumi-resource-aws")
		// need to copy the provider to the local directory for BucketObjectV2 to pick it up
		// otherwise you get an error `Argument must be a constant or contained in the project dir`
		err := copyFile(localProviderBuild, localLocation)
		assert.NoError(t, err)
		ptest.SetConfig(t, "localProviderBuild", localLocation)
		result := ptest.Up(t)
		t.Logf("stdout: %s", result.StdOut)
		t.Logf("stderr: %s", result.StdErr)
		t.Logf("commandOut: %v", result.Outputs["commandOut"].Value)
	})
}

func copyFile(src, dst string) error {
	srcFile, err := os.Open(src)
	if err != nil {
		return err
	}
	defer srcFile.Close()

	dstFile, err := os.Create(dst)
	if err != nil {
		return err
	}
	defer dstFile.Close()

	_, err = io.Copy(dstFile, srcFile)
	if err != nil {
		return err
	}

	err = dstFile.Sync()
	return err
}

// Assert that the provider does not regress on emitting an unexpected deprecation.
//
//	use the aws_s3_object resource instead
//
// See https://github.com/pulumi/pulumi-aws/issues/2796
func TestS3BucketObjectDeprecation(t *testing.T) {
	t.Parallel()
	ptest := pulumiTest(t, filepath.Join("test-programs", "regress-2796"), opttest.SkipInstall())
	result := ptest.Up(t)
	t.Logf("STDOUT: %v", result.StdOut)
	t.Logf("STDERR: %v", result.StdErr)
	require.NotContains(t, result.StdOut+result.StdErr, "aws_s3_object")
}

type tagsTestStep struct {
	// The name of the Pulumi program
	name string

	// The type token of the resource, i.e. aws:s3:Bucket
	token string

	// The pulumi type of the resource, i.e. aws:s3/bucket:Bucket
	typ string

	// Constant properties for the primary resource under test.
	//
	// This cannot include the tags property, which will be adjusted by the test.
	properties map[string]interface{}

	// List of tags to add to the resource
	tags map[string]interface{}

	// List of default tags to add to the provider
	defaultTags map[string]interface{}

	// List of tag keys to add to the provider `ignoreTags.Keys` property
	ignoreTagKeys []string

	// Function to run prior to _any_ import step
	preImportHook func(t *testing.T, outputs auto.OutputMap)

	// Function to run after running the first up. This can be used to
	// run extra validation
	postUpHook func(t *testing.T, outputs auto.OutputMap)

	// Other is a string that is inserted into the test program. It is intended to be
	// used to provision supporting resources in tests.
	other string

	// If skip is non-empty, the test will be skipped with `skip` as the given reason.
	skip string
}

// TestAccDefaultTags tries to test all the scenarios that might affect provider defaultTags / resource tags
// i.e. up, refresh, preview, import, etc
func TestAccDefaultTagsWithImport(t *testing.T) {
	t.Parallel()
	if testing.Short() {
		t.Skipf("Skipping in testing.Short() mode, assuming this is a CI run without credentials")
	}

	isNil := func(val interface{}) bool {
		if val == nil {
			return true
		}
		v, ok := val.(map[string]interface{})
		return ok && len(v) == 0
	}
	validateOutputTags := func(outputs auto.OutputMap, expectedTags map[string]interface{}) {
		stackOutputTags := outputs["actual"]
		if !isNil(expectedTags) || !isNil(stackOutputTags) {
			assert.Equal(t, expectedTags, stackOutputTags.Value)
		}
	}

	steps := []tagsTestStep{
		// Both aws:cognito:UserPool and aws:s3:Bucket are full SDKv2 resources managed
		// by Terraform, but they have different requirements for successful tag
		// interactions. That is why we have tests for both resources.
		{
			name: "bucket", token: "aws:s3:Bucket", typ: "aws:s3/bucket:Bucket",
			tags: map[string]interface{}{
				"LocalTag": "foo",
			},
			postUpHook: func(t *testing.T, outputs auto.OutputMap) {
				validateOutputTags(outputs, map[string]interface{}{
					"LocalTag":  "foo",
					"GlobalTag": "bar",
				})
			},
			defaultTags: map[string]interface{}{
				"GlobalTag": "bar",
			},
		},
		{
			name: "bucket_ignore_tags", token: "aws:s3:Bucket", typ: "aws:s3/bucket:Bucket",
			tags: map[string]interface{}{
				"LocalTag": "foo",
			},
			postUpHook: func(t *testing.T, outputs auto.OutputMap) {
				validateOutputTags(outputs, map[string]interface{}{
					"LocalTag":  "foo",
					"GlobalTag": "bar",
				})
			},
			defaultTags: map[string]interface{}{
				"GlobalTag": "bar",
			},
			ignoreTagKeys: []string{"IgnoreKey"},
			preImportHook: func(t *testing.T, outputs auto.OutputMap) {
				t.Helper()
				resArn := outputs["resArn"].Value.(string)
				addResourceTags(context.Background(), resArn, map[string]string{
					"IgnoreKey": "foo",
				})
			},
		},
		{
			name: "sdkv2", token: "aws:cognito:UserPool", typ: "aws:cognito/userPool:UserPool",
			tags: map[string]interface{}{
				"LocalTag": "foo",
			},
			defaultTags: map[string]interface{}{
				"GlobalTag": "bar",
			},
			postUpHook: func(t *testing.T, outputs auto.OutputMap) {
				validateOutputTags(outputs, map[string]interface{}{
					"LocalTag":  "foo",
					"GlobalTag": "bar",
				})
			},
			properties: map[string]interface{}{
				// aliasAttributes is necessary because otherwise we don't
				// see a clean initial refresh
				"aliasAttributes": []interface{}{"email"},
			},
		},

		// A PF resource (appconfig:Environment)
		// PF resources deal with tags differently
		{
			name: "pf", token: "aws:appconfig:Environment", typ: "aws:appconfig/environment:Environment",
			tags: map[string]interface{}{
				"LocalTag": "foo",
			},
			defaultTags: map[string]interface{}{
				"GlobalTag": "bar",
			},
			postUpHook: func(t *testing.T, outputs auto.OutputMap) {
				validateOutputTags(outputs, map[string]interface{}{
					"LocalTag":  "foo",
					"GlobalTag": "bar",
				})
			},
			other: `
  app:
    type: aws:appconfig:Application`,
			properties: map[string]interface{}{
				"applicationId": "${app.id}",
			},
		},
		{
			name: "pf_ignore_tags", token: "aws:appconfig:Environment", typ: "aws:appconfig/environment:Environment",
			tags: map[string]interface{}{
				"LocalTag": "foo",
			},
			ignoreTagKeys: []string{"IgnoreKey"},
			preImportHook: func(t *testing.T, outputs auto.OutputMap) {
				t.Helper()
				resArn := outputs["resArn"].Value.(string)
				addResourceTags(context.Background(), resArn, map[string]string{
					"IgnoreKey": "foo",
				})
			},
			defaultTags: map[string]interface{}{
				"GlobalTag": "bar",
			},
			postUpHook: func(t *testing.T, outputs auto.OutputMap) {
				validateOutputTags(outputs, map[string]interface{}{
					"LocalTag":  "foo",
					"GlobalTag": "bar",
				})
			},
			other: `
  app:
    type: aws:appconfig:Application`,
			properties: map[string]interface{}{
				"applicationId": "${app.id}",
			},
		},
	}

	for _, step := range steps {
		step := step
		t.Run(step.name, func(t *testing.T) {
			t.Parallel()
			if reason := step.skip; reason != "" {
				t.Skip(reason)
			}
			testTagsPulumiLifecycle(t, step)
		})
	}
}

func TestAssumeRoleSessionTags(t *testing.T) {
	t.Parallel()
	ptest := pulumiTest(t, filepath.Join("test-programs", "assume-role-session-tags"), opttest.SkipInstall())
	result := ptest.Up(t)
	t.Logf("STDOUT: %v", result.StdOut)
	t.Logf("STDERR: %v", result.StdErr)

	require.Contains(t, result.Outputs, "bucketArn")
	assert.NotEmpty(t, result.Outputs["bucketArn"].Value.(string))
}

// testTagsPulumiLifecycle tests the complete lifecycle of a pulumi program
// Scenarios that this tests:
//  1. `Up` with both provider `defaultTags`/`ignoreTags` and resource level `tags`
//     1a. Run validations on result
//  2. `Refresh` with no changes
//  3. `Import` using the resource option. Ensures resource can be successfully imported
//     3a. Allows for a hook to be run prior to import being run. e.g. Add tags remotely
//  4. `Import` using the CLI. Ensures resources can be successfully imported
//     4a. Allows for a hook to be run prior to import being run. e.g. Add tags remotely
//  5. `Refresh` with no changes
func testTagsPulumiLifecycle(t *testing.T, step tagsTestStep) {
	t.Helper()
	ctx := context.Background()

	stepDir, err := os.MkdirTemp(os.TempDir(), step.name)
	assert.NoError(t, err)
	fpath := filepath.Join(stepDir, "Pulumi.yaml")

	generateTagsTest(t, step, fpath, "")
	ptest := pulumiTest(t, stepDir, opttest.TestInPlace(), opttest.SkipInstall())
	stack := ptest.CurrentStack()

	t.Log("Initial deployment...")
	upRes, err := stack.Up(ctx)
	assert.NoError(t, err)
	outputs := upRes.Outputs
	urn := outputs["urn"].Value.(string)
	id := outputs["id"].Value.(string)
	providerUrn := outputs["providerUrn"].Value.(string)
	if step.postUpHook != nil {
		step.postUpHook(t, outputs)
	}

	t.Log("refresh...")
	_, err = stack.Refresh(ctx, optrefresh.ExpectNoChanges())
	assert.NoError(t, err)

	t.Log("delete state...")
	execPulumi(t, ptest, stepDir, "state", "delete", urn)

	// import using the import resource option
	t.Log("up with import...")
	if step.preImportHook != nil {
		step.preImportHook(t, outputs)
	}
	generateTagsTest(t, step, fpath, id)
	upRes, err = stack.Up(ctx, optup.Diff(), optup.ProgressStreams(os.Stdout), optup.ErrorProgressStreams(os.Stderr))
	assert.NoError(t, err)
	changes := *upRes.Summary.ResourceChanges
	assert.Equal(t, 1, changes["import"])

	t.Log("delete state...")
	execPulumi(t, ptest, stepDir, "state", "delete", urn)

	t.Log("import from cli...")
	if step.preImportHook != nil {
		step.preImportHook(t, outputs)
	}
	generateTagsTest(t, step, fpath, "")
	execPulumi(t, ptest, stepDir, "import", step.typ, "res", id, "--provider", fmt.Sprintf("aws-provider=%s", providerUrn), "--yes")
	execPulumi(t, ptest, stepDir, "state", "unprotect", urn, "--yes")

	// need to run an up to fix the state. It should be a no-op
	// re https://github.com/pulumi/pulumi-aws/issues/4204
	upRes, err = stack.Up(ctx)
	assert.NoError(t, err)
	for k := range *upRes.Summary.ResourceChanges {
		if k != "same" {
			t.Fatal("expected no changes")
		}
	}

	t.Log("preview with refresh...")
	_, err = stack.Preview(ctx, optpreview.Refresh(), optpreview.ExpectNoChanges())
	assert.NoError(t, err)
}

// generateTagsTest generates a pulumi program for the given test step
// and writes it to the test directory
func generateTagsTest(t *testing.T, step tagsTestStep, testPath string, importId string) {
	template := `name: test-aws-%s
runtime: yaml
resources:
  aws-provider:
    type: pulumi:providers:aws%s%s
  res:
    type: %s%s%s
outputs:
  actual: ${res.tagsAll}
  urn: ${res.urn}
  id: ${res.id}
  resArn: ${res.arn}
  providerUrn: ${aws-provider.urn}`

	options := map[string]interface{}{
		"provider": "${aws-provider}",
	}

	if importId != "" {
		options["import"] = importId
	}

	var expandMap func(level int, v interface{}) string
	expandMap = func(level int, v interface{}) string {
		indent := "\n" + strings.Repeat("  ", level)

		var body string
		switch v := v.(type) {
		case nil:
			return ""
		case string:
			body = v
		case []string:
			for _, v := range v {
				body += indent + "- " + strings.TrimSpace(expandMap(level+1, v))
			}
		case []interface{}:
			for _, v := range v {
				body += indent + "- " + strings.TrimSpace(expandMap(level+1, v))
			}
		case map[string]interface{}:
			sortedKeys := make([]string, len(v))
			for k := range v {
				sortedKeys = append(sortedKeys, k)
			}
			sort.Strings(sortedKeys)
			for _, k := range sortedKeys {
				v := v[k]

				val := expandMap(level+1, v)
				if val == "" {
					continue
				}
				body += indent + k + ": " + val
			}
		default:
			t.Logf("Unknown value type %T", v)
			t.FailNow()
		}

		return body
	}

	expandProps := func(key string, props ...map[string]interface{}) string {
		a := map[string]interface{}{}
		for _, arg := range props {
			for k, v := range arg {
				a[k] = v
			}
		}

		return expandMap(2, map[string]interface{}{
			key: a,
		})
	}

	providerProps := map[string]interface{}{
		"defaultTags": map[string]interface{}{
			"tags": step.defaultTags,
		},
	}
	if step.ignoreTagKeys != nil {
		providerProps["ignoreTags"] = map[string]interface{}{
			"keys": step.ignoreTagKeys,
		}
	}

	body := fmt.Sprintf(template, step.name,
		expandProps("properties", providerProps), step.other, step.token,
		expandProps("options", options),
		expandProps("properties", map[string]interface{}{
			"tags": step.tags,
		}, step.properties))

	t.Logf("template for %s: \n%s", step.name, body)
	require.NoError(t, os.WriteFile(testPath, []byte(body), 0o600))
}

func loadAwsDefaultConfig() aws.Config {
	loadOpts := []func(*config.LoadOptions) error{}
	if p, ok := os.LookupEnv("AWS_PROFILE"); ok {
		loadOpts = append(loadOpts, config.WithSharedConfigProfile(p))
	}
	if r, ok := os.LookupEnv("AWS_REGION"); ok {
		loadOpts = append(loadOpts, config.WithRegion(r))
	}
	cfg, err := config.LoadDefaultConfig(context.TODO(), loadOpts...)
	contract.AssertNoErrorf(err, "failed to load AWS config")

	return cfg
}

func configureS3() *s3sdk.Client {
	cfg := loadAwsDefaultConfig()
	return s3sdk.NewFromConfig(cfg)
}

func configureAppconfig() *appconfigsdk.Client {
	cfg := loadAwsDefaultConfig()
	return appconfigsdk.NewFromConfig(cfg)
}

func configureTagSdk() *tagsdk.Client {
	cfg := loadAwsDefaultConfig()
	return tagsdk.NewFromConfig(cfg)
}

func addResourceTags(ctx context.Context, arn string, tags map[string]string) {
	tag := configureTagSdk()
	_, err := tag.TagResources(ctx, &tagsdk.TagResourcesInput{
		ResourceARNList: []string{arn},
		Tags:            tags,
	})
	contract.AssertNoErrorf(err, "error tagging resource")
}

func addAppconfigEnvironmentTags(ctx context.Context, envArn string, tags map[string]string) {
	appconfig := configureAppconfig()
	existingTags, err := appconfig.ListTagsForResource(ctx, &appconfigsdk.ListTagsForResourceInput{
		ResourceArn: &envArn,
	})
	contract.AssertNoErrorf(err, "failed to list tags for appconfig env")

	for k, v := range existingTags.Tags {
		if _, exists := tags[k]; !exists {
			tags[k] = v
		}
	}

	_, err = appconfig.TagResource(ctx, &appconfigsdk.TagResourceInput{
		ResourceArn: &envArn,
		Tags:        tags,
	})
	contract.AssertNoErrorf(err, "error tagging appconfig env")
}

func getBucketTagging(ctx context.Context, awsBucket string) []types.Tag {
	s3 := configureS3()
	tagging, err := s3.GetBucketTagging(ctx, &s3sdk.GetBucketTaggingInput{
		Bucket: &awsBucket,
	})
	contract.AssertNoErrorf(err, "failed to get bucket tagging")
	return tagging.TagSet
}

func addBucketTags(ctx context.Context, bucketName string, tags map[string]string) {
	s3 := configureS3()
	existingTags := getBucketTagging(ctx, bucketName)

	newTags := []types.Tag{}

	for k, v := range tags {
		newTags = append(newTags, types.Tag{
			Key:   &k,
			Value: &v,
		})
	}

	for _, v := range existingTags {
		if _, exists := tags[*v.Key]; !exists {
			newTags = append(newTags, v)
		}
	}

	_, err := s3.PutBucketTagging(ctx, &s3sdk.PutBucketTaggingInput{
		Bucket: &bucketName,
		Tagging: &types.Tagging{
			TagSet: newTags,
		},
	})
	contract.AssertNoErrorf(err, "error putting bucket tags")
}

func deleteBucketTagging(ctx context.Context, awsBucket string) {
	s3 := configureS3()
	_, err := s3.DeleteBucketTagging(ctx, &s3sdk.DeleteBucketTaggingInput{
		Bucket: &awsBucket,
	})
	contract.AssertNoErrorf(err, "failed to delete bucket tagging")
}

func getYamlBaseOptions(t *testing.T) integration.ProgramTestOptions {
	config := map[string]string{}
	_, usingProfiles := os.LookupEnv("AWS_PROFILE")
	if !usingProfiles {
		envRegion := getEnvRegion(t)
		config = map[string]string{
			"aws:region": envRegion,
		}
	}
	// Do not use baseOptions here for now as those disable refresh checking. Be extra conservative.
	return integration.ProgramTestOptions{
		Config: config,
	}
}

type tagsType struct {
	name, token string

	// Constant properties for the primary resource under test.
	//
	// This cannot include the tags property, which will be adjusted by the test.
	properties map[string]interface{}

	// Other is a string that is inserted into the test program. It is intended to be
	// used to provision supporting resources in tests.
	other string

	// If skip is non-empty, the test will be skipped with `skip` as the given reason.
	skip string
}

type tagsStep struct {
	purpose     string
	defaultTags map[string]interface{}
	tags        map[string]interface{}
	expected    map[string]interface{}
}

func TestAccDefaultTags(t *testing.T) {
	types := []tagsType{
		// Both aws:cognito:UserPool and aws:s3:BucketV2 are full SDKv2 resources managed
		// by Terraform, but they have different requirements for successful tag
		// interactions. That is why we have tests for both resources.
		{
			name: "bucket", token: "aws:s3:Bucket",
		},
		{
			skip: "This doesn't work correctly in TF. Tracked in " +
				"https://github.com/pulumi/pulumi-aws/issues/2666.",
			name: "sdkv2", token: "aws:cognito:UserPool",
			properties: map[string]interface{}{
				// aliasAttributes is necessary because otherwise we don't
				// see a clean initial refresh
				"aliasAttributes": []interface{}{"email"},
			},
		},

		// A PF resource
		{
			name: "pf", token: "aws:appconfig:Environment",
			other: `
  app:
    type: aws:appconfig:Application`,
			properties: map[string]interface{}{
				"applicationId": "${app.id}",
			},
		},
	}

	sameAsDefault := map[string]interface{}{"__sameAsDefault": ""}
	steps := []tagsStep{
		{
			purpose: "Initial deployment without tags",
		},
		{
			purpose: "Add first default tag: `foo: bar``",
			defaultTags: map[string]interface{}{
				"foo": "bar",
			},
			expected: sameAsDefault,
		},
		{
			purpose: "Change tag `foo` value to `quux`",
			defaultTags: map[string]interface{}{
				"foo": "quux",
			},
			expected: sameAsDefault,
		},
		{
			purpose: "Add a resource specific tag: `foo: buzz`",
			defaultTags: map[string]interface{}{
				"foo": "quux",
			},
			tags: map[string]interface{}{
				"fizz": "buzz",
			},
			expected: map[string]interface{}{
				"foo":  "quux",
				"fizz": "buzz",
			},
		},
		{
			purpose: "Shadow the default tag with a resource specific tag",
			defaultTags: map[string]interface{}{
				"foo": "quux",
			},
			tags: map[string]interface{}{
				"fizz": "buzz",
				"foo":  "bar",
			},
			expected: map[string]interface{}{
				"foo":  "bar",
				"fizz": "buzz",
			},
		},
		{
			purpose: "Drop resource specific tags",
			defaultTags: map[string]interface{}{
				"foo": "quux",
			},
			expected: sameAsDefault,
		},
		{
			purpose: "Add new tag: `thwomp: pow`",
			defaultTags: map[string]interface{}{
				"foo":    "quux",
				"thwomp": "pow",
			},
			expected: sameAsDefault,
		},
		{
			purpose: "Remove foo tag (foo and thwomp)",
			defaultTags: map[string]interface{}{
				"thwomp": "pow",
			},
			expected: sameAsDefault,
		},
		// This case is handled by the special PreCheckCallback function we added
		{
			purpose:     "Don't specify any default tags (should be empty)",
			defaultTags: map[string]interface{}{},
			expected:    sameAsDefault,
		},
	}

	// Apply sameAsDefault
	for i, v := range steps {
		if v.expected == nil {
			continue
		}
		_, ok := v.expected["__sameAsDefault"]
		if !ok {
			continue
		}
		v.expected = v.defaultTags
		steps[i] = v
	}

	t.Run("generate", func(t *testing.T) {
		generateTagsTests(t, types, steps)
	})
	if t.Failed() {
		return
	}

	for _, typ := range types {
		typ := typ
		t.Run(typ.name, func(t *testing.T) {
			if reason := typ.skip; reason != "" {
				t.Skip(reason)
			}
			dir := filepath.Join(getCwd(t), typ.name+"-default-tags-yaml")
			testTags(t, dir, steps)
		})
	}

	return
}

func testTags(t *testing.T, dir string, steps []tagsStep) {
	isNil := func(val interface{}) bool {
		if val == nil {
			return true
		}
		v, ok := val.(map[string]interface{})
		return ok && len(v) == 0
	}
	editDirs := make([]integration.EditDir, 0, len(steps))
	for i, step := range steps {
		step := step
		editDirs = append(editDirs,
			integration.EditDir{
				Dir:      filepath.Join(dir, "step"+strconv.Itoa(i)),
				Additive: true,
				ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
					stackOutputBucketTags := stackInfo.Outputs["actual"]
					// legacy returns nil initially, but sdkv2 returns
					// an empty map initially.
					if isNil(step.expected) && isNil(stackOutputBucketTags) {
						return
					}
					assert.Equal(t, step.expected, stackOutputBucketTags,
						"Unexpected stack output for step %d: %s", i, step.purpose)
				},
			})
	}

	integration.ProgramTest(t, &integration.ProgramTestOptions{
		Dir:                    dir,
		ExtraRuntimeValidation: editDirs[0].ExtraRuntimeValidation,
		EditDirs:               editDirs[1:],
		// see https://github.com/pulumi/pulumi-aws/issues/4080
		ExpectRefreshChanges: true,
		Config:               map[string]string{"aws:region": getEnvRegion(t)},
		Quick:                true,
		DestroyOnCleanup:     true,
	})
}

func generateTagsTests(t *testing.T, types []tagsType, steps []tagsStep) {
	template := `name: test-aws-1655-%s
runtime: yaml
description: |
  %s
resources:
  aws-provider:
    type: pulumi:providers:aws%s%s
  res:
    type: %s%s
    options:
      provider: ${aws-provider}
outputs:
  actual: ${res.tagsAll}`

	var expandMap func(level int, v interface{}) string
	expandMap = func(level int, v interface{}) string {
		indent := "\n" + strings.Repeat("  ", level)

		var body string
		switch v := v.(type) {
		case nil:
			return ""
		case string:
			body = v
		case []interface{}:
			for _, v := range v {
				body += indent + "- " + strings.TrimSpace(expandMap(level+1, v))
			}
		case map[string]interface{}:
			sortedKeys := make([]string, len(v))
			for k := range v {
				sortedKeys = append(sortedKeys, k)
			}
			sort.Strings(sortedKeys)
			for _, k := range sortedKeys {
				v := v[k]

				val := expandMap(level+1, v)
				if val == "" {
					continue
				}
				body += indent + k + ": " + val
			}
		default:
			t.Logf("Unknown value type %T", v)
			t.FailNow()

		}

		return body
	}

	expandProps := func(props ...map[string]interface{}) string {
		a := map[string]interface{}{}
		for _, arg := range props {
			for k, v := range arg {
				a[k] = v
			}
		}

		return expandMap(2, map[string]interface{}{
			"properties": a,
		})
	}

	for _, typ := range types {
		dir := filepath.Join(getCwd(t), typ.name+"-default-tags-yaml")
		for i, p := range steps {
			path := filepath.Join(dir, fmt.Sprintf("step%d", i))
			if i == 0 {
				path = dir
			}
			body := fmt.Sprintf(template, typ.name, p.purpose,
				expandProps(map[string]interface{}{
					"defaultTags": map[string]interface{}{
						"tags": p.defaultTags,
					},
				}), typ.other, typ.token,
				expandProps(map[string]interface{}{
					"tags": p.tags,
				}, typ.properties))

			fpath := filepath.Join(path, "Pulumi.yaml")
			if os.Getenv("PULUMI_ACCEPT") == "true" {
				require.NoError(t, os.MkdirAll(path, 0o700))
				require.NoError(t, os.WriteFile(fpath, []byte(body), 0o600))
			} else {
				existing, err := os.ReadFile(fpath)
				if assert.NoError(t, err) {
					assert.Equal(t,
						body, string(existing))
				}
			}
		}
	}
}

func TestRegressUnknownTags(t *testing.T) {
	repro := `
	[
	  {
	    "method": "/pulumirpc.ResourceProvider/Check",
	    "request": {
	      "urn": "urn:pulumi:p1::example-tags::eks:index:NodeGroupV2$aws:ec2/securityGroup:SecurityGroup::example-ng-tags-ng2-nodeSecurityGroup",
	      "olds": {},
	      "news": {
		"description": "Managed by Pulumi",
		"revokeRulesOnDelete": true,
		"tags": "04da6b54-80e4-46f7-96ec-b56ff0331ba9",
		"vpcId": "vpc-4b82e033"
	      },
	      "randomSeed": "pm3N78209q8Aq/BJU17gDsIRv2BvC/geMb0WK/pMRQg="
	    },
	    "response": {
	      "inputs": {
					"tagsAll": {},
		"__defaults": [
		  "name"
		],
		"description": "Managed by Pulumi",
		"name": "example-ng-tags-ng2-nodeSecurityGroup-8012419",
		"revokeRulesOnDelete": true,
		"vpcId": "vpc-4b82e033",
		"tags": "04da6b54-80e4-46f7-96ec-b56ff0331ba9",
                "tagsAll": "04da6b54-80e4-46f7-96ec-b56ff0331ba9"
              }
            }
          }
        ]
	`
	replay(t, repro)
}

func TestWrongStateMaxItemOneDiffProduced(t *testing.T) {
	repro := `
	[
		{
			"method": "/pulumirpc.ResourceProvider/Configure",
			"request": {
				"variables": {
					"aws:config:region": "us-east-1",
					"aws:config:skipCredentialsValidation": "true",
					"aws:config:skipRegionValidation": "true"
				},
				"args": {
					"region": "us-east-1",
					"skipCredentialsValidation": "true",
					"skipRegionValidation": "true",
					"version": "7.0.0-alpha.0+dev"
				},
				"acceptSecrets": true,
				"acceptResources": true,
				"sendsOldInputs": true,
				"sendsOldInputsToDelete": true,
				"id": "8043d035-cb0a-40bb-9479-34f237a486d2",
				"urn": "urn:pulumi:dev::aws_esm_py::pulumi:providers:aws::default_7_0_0_alpha_0_dev",
				"name": "default_7_0_0_alpha_0_dev",
				"type": "pulumi:providers:aws"
			},
			"response": {
				"supportsPreview": true,
				"supportsAutonamingConfiguration": true
			},
			"metadata": {
				"kind": "resource",
				"mode": "client",
				"name": "aws"
			}
		},
    {
      "method": "/pulumirpc.ResourceProvider/Diff",
      "request": {
          "id": "f8af893f-869e-4861-a403-1a4fe3509754",
          "urn": "urn:pulumi:dev::aws_esm_py::aws:lambda/eventSourceMapping:EventSourceMapping::example",
          "olds": {
              "amazonManagedKafkaEventSourceConfig": null,
							"region": "us-east-1",
              "batchSize": 10,
              "bisectBatchOnFunctionError": false,
              "destinationConfig": null,
              "documentDbEventSourceConfig": null,
              "enabled": true,
              "eventSourceArn": "arn:aws:sqs:us-east-1:616138583583:queue-7798098",
              "filterCriteria": null,
              "functionArn": "arn:aws:lambda:us-east-1:616138583583:function:testLambda-74dac89",
              "functionName": "arn:aws:lambda:us-east-1:616138583583:function:testLambda-74dac89",
              "functionResponseTypes": [],
              "id": "f8af893f-869e-4861-a403-1a4fe3509754",
              "lastModified": "2023-12-08T16:02:48Z",
              "lastProcessingResult": "",
              "maximumBatchingWindowInSeconds": 0,
              "maximumRecordAgeInSeconds": 0,
              "maximumRetryAttempts": 0,
              "parallelizationFactor": 0,
              "queues": [],
              "scalingConfig": null,
              "selfManagedEventSource": null,
              "selfManagedKafkaEventSourceConfig": null,
              "sourceAccessConfigurations": [],
              "startingPosition": "",
              "startingPositionTimestamp": "",
              "state": "Enabled",
              "stateTransitionReason": "USER_INITIATED",
              "topics": [],
              "tumblingWindowInSeconds": 0,
							"tagsAll": {},
              "uuid": "f8af893f-869e-4861-a403-1a4fe3509754"
          },
          "news": {
              "__defaults": [
                  "enabled"
              ],
							"region": "us-east-1",
              "enabled": true,
              "eventSourceArn": "arn:aws:sqs:us-east-1:616138583583:queue-7798098",
							"tagsAll": {},
              "functionName": "arn:aws:lambda:us-east-1:616138583583:function:testLambda-74dac89"
          },
          "oldInputs": {
              "__defaults": [
                  "enabled"
              ],
							"region": "us-east-1",
              "enabled": true,
              "eventSourceArn": "arn:aws:sqs:us-east-1:616138583583:queue-7798098",
              "functionName": "arn:aws:lambda:us-east-1:616138583583:function:testLambda-74dac89"
          }
      },
      "response": {
          "stables": "*",
          "changes": "DIFF_SOME",
          "hasDetailedDiff": true
      },
      "metadata": {
          "kind": "resource",
          "mode": "client",
          "name": "aws"
      }
  }
  ]
	`
	replay(t, repro)
}

func TestSourceCodeHashImportedLambdaChecksCleanly(t *testing.T) {
	replay(t, `
  [{
    "method": "/pulumirpc.ResourceProvider/Check",
    "request": {
        "urn": "urn:pulumi:imported::repro_lambda::aws:lambda/function:Function::mylambda",
        "olds": {
            "__defaults": [],
            "architectures": [
                "x86_64"
            ],
            "environment": {
                "__defaults": [],
                "variables": {
                    "__defaults": [],
                    "foo": "bar"
                }
            },
            "ephemeralStorage": {
                "__defaults": [],
                "size": 512
            },
            "handler": "index.test",
            "loggingConfig": {
                "__defaults": [],
                "logFormat": "Text",
                "logGroup": "/aws/lambda/testLambda-83906f2"
            },
            "name": "testLambda-83906f2",
            "packageType": "Zip",
            "role": "arn:aws:iam::616138583583:role/iamForLambda-d5757fe",
            "runtime": "nodejs18.x",
            "sourceCodeHash": "WUsPYQdwiMj+sDZzl3tNaSzS42vqVfng2CZtgcy+TRs=",
						"tagsAll": {},
            "tracingConfig": {
                "__defaults": [],
                "mode": "PassThrough"
            }
        },
        "news": {
            "__defaults": [],
            "architectures": [
                "x86_64"
            ],
            "environment": {
                "__defaults": [],
                "variables": {
                    "__defaults": [],
                    "foo": "bar"
                }
            },
            "ephemeralStorage": {
                "__defaults": [],
                "size": 512
            },
            "handler": "index.test",
            "loggingConfig": {
                "__defaults": [],
                "logFormat": "Text",
                "logGroup": "/aws/lambda/testLambda-83906f2"
            },
            "name": "testLambda-83906f2",
            "packageType": "Zip",
            "role": "arn:aws:iam::616138583583:role/iamForLambda-d5757fe",
            "runtime": "nodejs18.x",
            "sourceCodeHash": "WUsPYQdwiMj+sDZzl3tNaSzS42vqVfng2CZtgcy+TRs=",
						"tagsAll": {},
            "tracingConfig": {
                "__defaults": [],
                "mode": "PassThrough"
            }
        },
        "randomSeed": "MpcMRlpQV7R8mD8Nmx9KpLPPIyFTHsB8HA4kxXdWTfo="
    },
    "response": {
        "inputs": {
            "__defaults": [
                "memorySize",
                "publish",
                "reservedConcurrentExecutions",
                "skipDestroy",
                "timeout"
            ],
            "architectures": [
                "x86_64"
            ],
            "environment": {
                "__defaults": [],
                "variables": {
                    "__defaults": [],
                    "foo": "bar"
                }
            },
            "ephemeralStorage": {
                "__defaults": [],
                "size": 512
            },
            "handler": "index.test",
            "loggingConfig": {
                "__defaults": [
                    "applicationLogLevel",
                    "systemLogLevel"
                ],
                "applicationLogLevel": "",
                "logFormat": "Text",
                "logGroup": "/aws/lambda/testLambda-83906f2",
                "systemLogLevel": ""
            },
            "memorySize": 128,
            "name": "testLambda-83906f2",
            "packageType": "Zip",
            "publish": false,
            "reservedConcurrentExecutions": -1,
            "role": "arn:aws:iam::616138583583:role/iamForLambda-d5757fe",
            "runtime": "nodejs18.x",
            "skipDestroy": false,
            "sourceCodeHash": "WUsPYQdwiMj+sDZzl3tNaSzS42vqVfng2CZtgcy+TRs=",
            "timeout": 3,
						"tagsAll": {},
            "tracingConfig": {
                "__defaults": [],
                "mode": "PassThrough"
            }
        }
    },
    "metadata": {
        "kind": "resource",
        "mode": "client",
        "name": "aws"
    }
}]`)
}

// Check that having manifest...retentionDays as "3650" in the state but 3650 (numeric value) in the program does not
// induce a diff as it is suppressed by the underlying provider.
//
// See also pulumi/pulumi-aws#3650.
func TestRegressLandingZoneDiff(t *testing.T) {
	t.Parallel()

	event := `
	[
		{
			"method": "/pulumirpc.ResourceProvider/Configure",
			"request": {
				"variables": {
					"aws:config:region": "us-east-1",
					"aws:config:skipCredentialsValidation": "true",
					"aws:config:skipRegionValidation": "true"
				},
				"args": {
					"region": "us-east-1",
					"skipCredentialsValidation": "true",
					"skipRegionValidation": "true",
					"version": "7.0.0-alpha.0+dev"
				},
				"acceptSecrets": true,
				"acceptResources": true,
				"sendsOldInputs": true,
				"sendsOldInputsToDelete": true,
				"id": "8043d035-cb0a-40bb-9479-34f237a486d2",
				"urn": "urn:pulumi:operations::aws-3650::pulumi:providers:aws::default_7_0_0_alpha_0_dev",
				"name": "default_7_0_0_alpha_0_dev",
				"type": "pulumi:providers:aws"
			},
			"response": {
				"supportsPreview": true,
				"supportsAutonamingConfiguration": true
			},
			"metadata": {
				"kind": "resource",
				"mode": "client",
				"name": "aws"
			}
		},
	{
	  "method": "/pulumirpc.ResourceProvider/Diff",
	  "request": {
	    "id": "4UHHTLE0W30UX0TC",
	    "urn": "urn:pulumi:operations::aws-3650::aws:controltower/landingZone:LandingZone::lz_operations",
	    "olds": {
	      "__meta": "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":7200000000000,\"delete\":7200000000000,\"update\":7200000000000}}",
	      "arn": "arn:aws:controltower:ap-southeast-2:89XXXXXXXX25:landingzone/4UHHTLE0W30UX0TC",
				"region": "us-east-2",
				"tagsAll": {},
	      "driftStatuses": [
		{
		  "status": "IN_SYNC"
		}
	      ],
	      "id": "4UHHTLE0W30UX0TC",
	      "latestAvailableVersion": "3.3",
	      "manifestJson": "{\"accessManagement\":{\"enabled\":true},\"centralizedLogging\":{\"accountId\":\"89XXXXXXXX39\",\"configurations\":{\"accessLoggingBucket\":{\"retentionDays\":\"3650\"},\"kmsKeyArn\":\"arn:aws:kms:ap-southeast-2:89XXXXXXXX25:key/10e27ec4-55b0-42b7-b408-72b11a3f4550\",\"loggingBucket\":{\"retentionDays\":365}},\"enabled\":true},\"governedRegions\":[\"ap-southeast-2\"],\"organizationStructure\":{\"security\":{\"name\":\"Security\"}},\"securityRoles\":{\"accountId\":\"89XXXXXXXX42\"}}",
	      "version": "3.3"
	    },
	    "news": {
	      "__defaults": [],
				"tagsAll": {},
				"region": "us-east-2",
	      "manifestJson": "{\"governedRegions\": [\"ap-southeast-2\"], \"organizationStructure\": {\"security\": {\"name\": \"Security\"}}, \"centralizedLogging\": {\"accountId\": \"89XXXXXXXX39\", \"configurations\": {\"accessLoggingBucket\": {\"retentionDays\": 3650}, \"kmsKeyArn\": \"arn:aws:kms:ap-southeast-2:89XXXXXXXX25:key/10e27ec4-55b0-42b7-b408-72b11a3f4550\", \"loggingBucket\": {\"retentionDays\": 365}}, \"enabled\": true}, \"securityRoles\": {\"accountId\": \"89XXXXXXXX42\"}, \"accessManagement\": {\"enabled\": true}}",
	      "version": "3.3"
	    },
	    "oldInputs": {
	      "__defaults": [],
				"tagsAll": {},
	      "manifestJson": "{\"governedRegions\": [\"ap-southeast-2\"], \"organizationStructure\": {\"security\": {\"name\": \"Security\"}}, \"centralizedLogging\": {\"accountId\": \"89XXXXXXXX39\", \"configurations\": {\"accessLoggingBucket\": {\"retentionDays\": \"3650\"}, \"kmsKeyArn\": \"arn:aws:kms:ap-southeast-2:89XXXXXXXX25:key/10e27ec4-55b0-42b7-b408-72b11a3f4550\", \"loggingBucket\": {\"retentionDays\": 365}}, \"enabled\": true}, \"securityRoles\": {\"accountId\": \"89XXXXXXXX42\"}, \"accessManagement\": {\"enabled\": true}}",
	      "version": "3.3"
	    }
	  },
	  "response": {
	    "changes": "DIFF_NONE",
	    "hasDetailedDiff": true
	  }
	}]`
	replay(t, event)
}

func TestRegress1738(t *testing.T) {
	t.Parallel()

	containerDefinitionsOld := `
	[
	  {
	    "cpu": 512,
	    "environment": [],
	    "essential": true,
	    "healthCheck": {
	      "command": [
		"CMD-SHELL",
		"curl -f http://localhost:8080/health || exit 1"
	      ],
	      "interval": 5,
	      "retries": 10,
	      "timeout": 5
	    },
	    "image": "nginx",
	    "logConfiguration": {
	      "logDriver": "awslogs",
	      "options": {
		"awslogs-group": "foo-bar-e196c99",
		"awslogs-region": "us-east-1",
		"awslogs-stream-prefix": "nginx"
	      }
	    },
	    "memory": 2048,
	    "mountPoints": [],
	    "name": "nginx",
	    "portMappings": [],
	    "startTimeout": 10,
	    "systemControls": [],
	    "volumesFrom": []
	  }
	]`

	containerDefinitionsNew := `
	[
	  {
	    "cpu": 512,
	    "environment": [],
	    "healthCheck": {
	      "command": [
		"CMD-SHELL",
		"curl -f http://localhost:8080/health || exit 1"
	      ],
	      "interval": 5,
	      "retries": 10
	    },
	    "image": "nginx",
	    "memory": 2048,
	    "name": "nginx",
	    "startTimeout": 10,
	    "logConfiguration": {
	      "logDriver": "awslogs",
	      "options": {
		"awslogs-group": "foo-bar-e196c99",
		"awslogs-region": "us-east-1",
		"awslogs-stream-prefix": "nginx"
	      }
	    }
	  }
	]`

	j := func(x any) string {
		bytes, err := json.Marshal(x)
		contract.AssertNoErrorf(err, "json.Marshal failure")
		return string(bytes)
	}

	replay(t, fmt.Sprintf(`
	[
		{
			"method": "/pulumirpc.ResourceProvider/Configure",
			"request": {
				"variables": {
					"aws:config:region": "us-east-1",
					"aws:config:skipCredentialsValidation": "true",
					"aws:config:skipRegionValidation": "true"
				},
				"args": {
					"region": "us-east-1",
					"skipCredentialsValidation": "true",
					"skipRegionValidation": "true",
					"version": "7.0.0-alpha.0+dev"
				},
				"acceptSecrets": true,
				"acceptResources": true,
				"sendsOldInputs": true,
				"sendsOldInputsToDelete": true,
				"id": "8043d035-cb0a-40bb-9479-34f237a486d2",
				"urn": "urn:pulumi:dev::repro::pulumi:providers:aws::default_7_0_0_alpha_0_dev",
				"name": "default_7_0_0_alpha_0_dev",
				"type": "pulumi:providers:aws"
			},
			"response": {
				"supportsPreview": true,
				"supportsAutonamingConfiguration": true
			},
			"metadata": {
				"kind": "resource",
				"mode": "client",
				"name": "aws"
			}
		},
	{
	  "method": "/pulumirpc.ResourceProvider/Diff",
	  "request": {
	    "id": "foo-bar-c7f12716",
	    "urn": "urn:pulumi:dev::repro::awsx:ecs:FargateService$awsx:ecs:FargateTaskDefinition$aws:ecs/taskDefinition:TaskDefinition::foo-bar",
	    "olds": {
	      "__meta": "{\"schema_version\":\"1\"}",
	      "arn": "arn:aws:ecs:us-east-1:616138583583:task-definition/foo-bar-c7f12716:1",
	      "arnWithoutRevision": "arn:aws:ecs:us-east-1:616138583583:task-definition/foo-bar-c7f12716",
	      "containerDefinitions": %s,
				"region": "us-east-2",
	      "cpu": "512",
	      "ephemeralStorage": null,
	      "executionRoleArn": "arn:aws:iam::616138583583:role/foo-bar-execution-694a131",
	      "family": "foo-bar-c7f12716",
	      "id": "foo-bar-c7f12716",
	      "inferenceAccelerators": [],
	      "ipcMode": "",
	      "memory": "2048",
	      "networkMode": "awsvpc",
	      "pidMode": "",
	      "placementConstraints": [],
	      "proxyConfiguration": null,
	      "requiresCompatibilities": [
		"FARGATE"
	      ],
	      "revision": 1,
	      "runtimePlatform": null,
	      "skipDestroy": false,
	      "tags": {},
	      "tagsAll": {},
	      "taskRoleArn": "arn:aws:iam::616138583583:role/foo-bar-task-77ab295",
	      "trackLatest": false,
	      "volumes": []
	    },
	    "news": {
	      "__defaults": [
		"skipDestroy",
		"trackLatest"
	      ],
	      "containerDefinitions": %s,
	      "cpu": "512",
	      "executionRoleArn": "arn:aws:iam::616138583583:role/foo-bar-execution-694a131",
	      "family": "foo-bar-c7f12716",
	      "memory": "2048",
	      "networkMode": "awsvpc",
	      "requiresCompatibilities": [
		"FARGATE"
	      ],
	      "skipDestroy": false,
	      "taskRoleArn": "arn:aws:iam::616138583583:role/foo-bar-task-77ab295",
	      "trackLatest": false
	    },
	    "oldInputs": {
	      "__defaults": [
		"skipDestroy",
		"trackLatest"
	      ],
	      "containerDefinitions": %s,
	      "cpu": "512",
				"region": "us-east-2",
	      "executionRoleArn": "arn:aws:iam::616138583583:role/foo-bar-execution-694a131",
	      "family": "foo-bar-c7f12716",
	      "memory": "2048",
	      "networkMode": "awsvpc",
	      "requiresCompatibilities": [
		"FARGATE"
	      ],
	      "skipDestroy": false,
	      "taskRoleArn": "arn:aws:iam::616138583583:role/foo-bar-task-77ab295",
	      "trackLatest": false
	    }
	  },
	  "response": {
	    "changes": "DIFF_NONE",
            "stables": "*",
	    "hasDetailedDiff": true
	  }
	}]`, j(containerDefinitionsOld), j(containerDefinitionsNew), j(containerDefinitionsNew)))
}

func TestElasticacheReplicationGroup(t *testing.T) {
	t.Parallel()

	ptest := pulumiTest(t, filepath.Join("test-programs", "elasticache-replication-group"), opttest.SkipInstall())
	upResult := ptest.Up(t)
	replicationGroupArn := upResult.Outputs["replicationGroupArn"].Value.(string)
	assert.NotEmpty(t, replicationGroupArn)
}

func TestSecurityGroupPreviewWarning(t *testing.T) {
	t.Parallel()
	pt := pulumiTest(t, filepath.Join("test-programs", "security-group", "security-group-1"))
	pt.Up(t)

	st := pt.ExportStack(t)

	pt2 := pulumiTest(t, filepath.Join("test-programs", "security-group"))
	pt2.ImportStack(t, st)
	prev := pt2.Preview(t, optpreview.Diff())

	assert.NotContains(t, prev.StdOut, "warning: Failed to calculate preview for element")
	assert.NotContains(t, prev.StdErr, "warning: Failed to calculate preview for element")
}
