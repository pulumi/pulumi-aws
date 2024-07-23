// Copyright 2016-2024, Pulumi Corporation.  All rights reserved.

//go:build !go && !nodejs && !python && !dotnet
// +build !go,!nodejs,!python,!dotnet

package provider

import (
	"bytes"
	"context"
	"fmt"
	"math/rand"
	"os"
	"os/exec"
	"path/filepath"
	"runtime"
	"sort"
	"strings"
	"testing"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	appconfigsdk "github.com/aws/aws-sdk-go-v2/service/appconfig"
	tagsdk "github.com/aws/aws-sdk-go-v2/service/resourcegroupstaggingapi"
	s3sdk "github.com/aws/aws-sdk-go-v2/service/s3"
	"github.com/aws/aws-sdk-go-v2/service/s3/types"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/assertpreview"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/sdk/v3/go/auto"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optrefresh"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optup"
	"github.com/pulumi/pulumi/sdk/v3/go/common/apitype"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestBucketUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "bucket"), nil)
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
	// Baseline version is needed because of https://github.com/pulumi/providertest/issues/76
	testProviderUpgrade(t, filepath.Join("test-programs", "cloudfront-distribution"), &testProviderUpgradeOptions{
		baselineVersion: "6.10.0",
	})
}

func TestSecretVersionUpgrade(t *testing.T) {
	testProviderUpgrade(t, filepath.Join("test-programs", "secretversion"), nil)
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

			pt.SetConfig("randSuffix", fmt.Sprintf("%d-x", rand.Intn(1024*1024)))

			if tc.applyMethod1 != nil {
				pt.SetConfig("applyMethod", string(*tc.applyMethod1))
			}
			pt.SetConfig("value", tc.value1)

			pt.Up()

			assertpreview.HasNoChanges(t, pt.Preview())

			err = os.WriteFile(filepath.Join(workdir, "Pulumi.yaml"), []byte(tc.file2), 0o600)
			require.NoError(t, err)

			if tc.applyMethod2 != nil {
				if tc.file2 == noApplyYaml {
					t.Errorf("WRONG FILE!")
				}
				pt.SetConfig("applyMethod", string(*tc.applyMethod2))
			}
			pt.SetConfig("value", tc.value2)

			if tc.expectChanges {
				pr := pt.Preview()
				assert.Equal(t, 1, pr.ChangeSummary[apitype.OpUpdate])
			} else {
				assertpreview.HasNoChanges(t, pt.Preview())
			}

			upr := pt.Up()
			t.Logf("stdout: %s", upr.StdOut)
			t.Logf("stderr: %s", upr.StdErr)

			assertpreview.HasNoChanges(t, pt.Preview())
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
	ptest := pulumiTest(t, filepath.Join("test-programs", "non-idempotent-sns-topic"))

	ptest.InstallStack("test")
	// generate random name
	topic_name := randSeq(12)
	ptest.SetConfig("snsTopicName", topic_name)

	_, err := ptest.CurrentStack().Up(ptest.Context())
	require.ErrorContains(t, err, "already exists")
}

func TestOpenZfsFileSystemUpgrade(t *testing.T) {
	t.Parallel()
	if testing.Short() {
		t.Skipf("Skipping in testing.Short() mode, assuming this is a CI run without credentials")
	}
	const pulumiYaml = `
name: openzfs
runtime: yaml
resources:
  MyFileSystem:
    properties:
      deploymentType: SINGLE_AZ_1
      storageCapacity: 64
      %s
      throughputCapacity: 64
    type: aws:fsx:OpenZfsFileSystem
  MySubnet:
    properties:
      cidrBlock: "10.0.1.0/24"
      vpcId: ${MyVPC.id}
    type: aws:ec2:Subnet
  MyVPC:
    properties:
      cidrBlock: "10.0.0.0/16"
    type: aws:ec2:Vpc
`

	var (
		providerName    string = "aws"
		baselineVersion string = "6.41.0"
	)
	cwd, err := os.Getwd()
	assert.NoError(t, err)
	workdir := t.TempDir()

	firstProgram := []byte(fmt.Sprintf(pulumiYaml, "subnetIds: ${MySubnet.id}"))
	secondProgram := []byte(fmt.Sprintf(pulumiYaml, "subnetIds:\n        - ${MySubnet.id}"))
	// test that we can upgrade from the previous version which accepted a string for `subnetIds`
	// to the new version which accepts a list
	t.Run("upgrade", func(t *testing.T) {
		pulumiTest := testProviderCodeChanges(t, &testProviderCodeChangesOptions{
			firstProgram: firstProgram,
			firstProgramOptions: []opttest.Option{
				opttest.DownloadProviderVersion(providerName, baselineVersion),
			},
			secondProgram: secondProgram,
			secondProgramOptions: []opttest.Option{
				opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
			},
		})

		res := pulumiTest.Preview()
		fmt.Printf("stdout: %s \n", res.StdOut)
		fmt.Printf("stderr: %s \n", res.StdErr)
		assertpreview.HasNoChanges(t, res)

		upResult := pulumiTest.Up()
		fmt.Printf("stdout: %s \n", upResult.StdOut)
		fmt.Printf("stderr: %s \n", upResult.StdErr)
	})

	// test that we can deploy a new filesystem with a list of subnetIds
	// we use a test with a snapshot since this test is only useful the first time, once
	// we know it works it should continue to work.
	t.Run("new-version", func(t *testing.T) {
		t.Parallel()
		err = os.WriteFile(filepath.Join(workdir, "Pulumi.yaml"), secondProgram, 0o600)
		assert.NoError(t, err)
		pulumiTest := pulumitest.NewPulumiTest(t, workdir,
			opttest.SkipInstall(),
			opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
		)

		pulumiTest.SetConfig("aws:region", "us-east-2")

		pulumiUpWithSnapshot(t, pulumiTest)
	})
}

// Make sure that legacy Bucket supports deleting tags out of band and detecting drift.
func TestRegress3674(t *testing.T) {
	t.Parallel()
	ptest := pulumiTest(t, filepath.Join("test-programs", "regress-3674"), opttest.SkipInstall())
	upResult := ptest.Up()
	bucketName := upResult.Outputs["bucketName"].Value.(string)
	deleteBucketTagging(ptest.Context(), bucketName)
	result := ptest.Refresh()
	t.Logf("%s", result.StdOut)
	require.Equal(t, 1, (*result.Summary.ResourceChanges)["update"])
	state, err := ptest.ExportStack().Deployment.MarshalJSON()
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
			"-X", "github.com/pulumi/pulumi-aws/provider/v6/pkg/version.Version=6.0.0-alpha.0+dev",
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
		ptest.SetConfig("localProviderBuild", localProviderBuild)
		result := ptest.Up()
		t.Logf("stdout: %s", result.StdOut)
		t.Logf("stderr: %s", result.StdErr)
		t.Logf("commandOut: %v", result.Outputs["commandOut"].Value)
	})
}

// Assert that the provider does not regress on emitting an unexpected deprecation.
//
//	use the aws_s3_object resource instead
//
// See https://github.com/pulumi/pulumi-aws/issues/2796
func TestS3BucketObjectDeprecation(t *testing.T) {
	t.Parallel()
	ptest := pulumiTest(t, filepath.Join("test-programs", "regress-2796"), opttest.SkipInstall())
	result := ptest.Up()
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
func TestAccDefaultTags(t *testing.T) {
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
		// Pulumi maintains it's own version of aws:s3:Bucket in
		// `s3legacy/bucket_legacy.go`. Because we don't have any
		// terraform-provider-aws maintainers to ensure our tagging works the same
		// way as other resource's tagging, we give our own bucket special testing
		// to make sure that tags work.
		{
			name: "legacy", token: "aws:s3:Bucket", typ: "aws:s3/bucket:Bucket",
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
				bucketName := outputs["id"].Value.(string)
				tags := getBucketTagging(context.Background(), bucketName)
				assert.Equal(t, tags, []types.Tag{
					{
						Key:   pulumi.StringRef("LocalTag"),
						Value: pulumi.StringRef("foo"),
					},
					{
						Key:   pulumi.StringRef("GlobalTag"),
						Value: pulumi.StringRef("bar"),
					},
				})
			},
		},
		{
			name: "legacy_ignore_tags", token: "aws:s3:Bucket", typ: "aws:s3/bucket:Bucket",
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
		},

		// Both aws:cognito:UserPool and aws:s3:BucketV2 are full SDKv2 resources managed
		// by Terraform, but they have different requirements for successful tag
		// interactions. That is why we have tests for both resources.
		{
			name: "bucket", token: "aws:s3:BucketV2", typ: "aws:s3/bucketV2:BucketV2",
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
			name: "bucket_ignore_tags", token: "aws:s3:BucketV2", typ: "aws:s3/bucketV2:BucketV2",
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
				t.Skipf(reason)
			}
			testTagsPulumiLifecycle(t, step)
		})
	}
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
	ptest := pulumiTest(t, stepDir, opttest.TestInPlace())
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
	upRes, err = stack.Up(ctx, optup.Diff())
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
  actual: ${res.tags}
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
	require.NoError(t, os.WriteFile(testPath, []byte(body), 0600))
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

func getCwd(t *testing.T) string {
	cwd, err := os.Getwd()
	if err != nil {
		t.FailNow()
	}

	return cwd
}
