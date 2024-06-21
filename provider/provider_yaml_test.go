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
	"strings"
	"testing"

	"github.com/aws/aws-sdk-go-v2/config"
	s3sdk "github.com/aws/aws-sdk-go-v2/service/s3"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/assertpreview"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/sdk/v3/go/common/apitype"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
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
	ptest := pulumiTest(t, filepath.Join("test-programs", "non-idempotent-sns-topic"))

	ptest.InstallStack("test")
	// generate random name
	topic_name := randSeq(12)
	ptest.SetConfig("snsTopicName", topic_name)

	_, err := ptest.CurrentStack().Up(ptest.Context())
	require.ErrorContains(t, err, "already exists")
}

func TestOpenZfsFileSystemUpgrade(t *testing.T) {
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
		err = os.WriteFile(filepath.Join(workdir, "Pulumi.yaml"), secondProgram, 0o600)
		assert.NoError(t, err)
		pulumiTest := pulumitest.NewPulumiTest(t, workdir,
			opttest.SkipInstall(),
			opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
		)

		pulumiUpWithSnapshot(t, pulumiTest)
	})
}

// Make sure that legacy Bucket supports deleting tags out of band and detecting drift.
func TestRegress3674(t *testing.T) {
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
	ptest := pulumiTest(t, filepath.Join("test-programs", "regress-2796"), opttest.SkipInstall())
	result := ptest.Up()
	t.Logf("STDOUT: %v", result.StdOut)
	t.Logf("STDERR: %v", result.StdErr)
	require.NotContains(t, result.StdOut+result.StdErr, "aws_s3_object")
}

func configureS3() *s3sdk.Client {
	loadOpts := []func(*config.LoadOptions) error{}
	if p, ok := os.LookupEnv("AWS_PROFILE"); ok {
		loadOpts = append(loadOpts, config.WithSharedConfigProfile(p))
	}
	if r, ok := os.LookupEnv("AWS_REGION"); ok {
		loadOpts = append(loadOpts, config.WithRegion(r))
	}
	cfg, err := config.LoadDefaultConfig(context.TODO(), loadOpts...)
	contract.AssertNoErrorf(err, "failed to load AWS config")
	return s3sdk.NewFromConfig(cfg)
}

func deleteBucketTagging(ctx context.Context, awsBucket string) {
	s3 := configureS3()
	_, err := s3.DeleteBucketTagging(ctx, &s3sdk.DeleteBucketTaggingInput{
		Bucket: &awsBucket,
	})
	contract.AssertNoErrorf(err, "failed to delete bucket tagging")
}
