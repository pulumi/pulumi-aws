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
	"fmt"
	"math/rand"
	"os"
	"os/exec"
	"path/filepath"
	"runtime"
	"sort"
	"strconv"
	"strings"
	"testing"

	"github.com/pulumi/providertest/optproviderupgrade"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/assertpreview"
	"github.com/pulumi/providertest/pulumitest/optnewstack"
	"github.com/pulumi/providertest/pulumitest/opttest"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/auto/optpreview"
	"github.com/pulumi/pulumi/sdk/v3/go/common/apitype"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

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
	test, _ := testProviderUpgrade(t, "bucket-to-bucket/yaml", &testProviderUpgradeOptions{
		skipDefaultPreviewTest: true,
		runProgram:             true,
		skipCache:              true,
	},
		optproviderupgrade.NewSourcePath(filepath.Join("bucket-to-bucket", "yaml", "step1")),
	)
	res := test.Preview(t, optpreview.Refresh(), optpreview.Diff())
	assert.Equal(t, map[apitype.OpType]int{
		apitype.OpUpdate: 1, // the provider gets updated because of the version update
		apitype.OpSame:   9,
	}, res.ChangeSummary)

}

func TestS3BucketV2ToBucketUpgrade(t *testing.T) {
	test, _ := testProviderUpgrade(t, "bucketv2-to-bucket", &testProviderUpgradeOptions{
		skipDefaultPreviewTest: true,
		skipCache:              true,
		runProgram:             true,
	},
		optproviderupgrade.NewSourcePath(filepath.Join("bucketv2-to-bucket", "step1")),
	)
	res := test.Preview(t, optpreview.Refresh(), optpreview.Diff())
	assert.Equal(t, map[apitype.OpType]int{
		apitype.OpUpdate: 1, // the provider gets updated because of the version update
		apitype.OpSame:   9,
	}, res.ChangeSummary)
}

func TestS3BucketV2Compat(t *testing.T) {
	t.Parallel()
	skipIfShort(t)
	cwd, err := os.Getwd()
	require.NoError(t, err)
	test := pulumitest.NewPulumiTest(t, "bucketv2-to-bucket",
		opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
		opttest.SkipInstall(),
	)

	test.Up(t)
}

func TestS3BucketV2ToBucketSidecarUpgrade(t *testing.T) {
	test, _ := testProviderUpgrade(t, "bucket-sidecar-renames", &testProviderUpgradeOptions{
		skipDefaultPreviewTest: true,
		skipCache:              true,
		runProgram:             true,
	},
		optproviderupgrade.NewSourcePath(filepath.Join("bucket-sidecar-renames", "step1")),
	)
	res := test.Preview(t, optpreview.Refresh(), optpreview.Diff())
	assert.Equal(t, map[apitype.OpType]int{
		apitype.OpUpdate: 1, // the provider gets updated because of the version update
		apitype.OpSame:   11,
	}, res.ChangeSummary)
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

func TestImportEC2KeyPairPublicKeyChecksCleanly(t *testing.T) {
	skipIfShort(t)
	t.Parallel()

	cwd := getCwd(t)
	options := []opttest.Option{
		opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
		opttest.SkipInstall(),
	}

	keyName := fmt.Sprintf("pulumi-key-pair-import-%s", randSeq(8))
	publicKey := "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQD3F6tyPEFEzV0LX3X8BsXdMsQz1x2cEikKDEY0aIj41qgxMCP/iteneqXSIFZBp5vizPvaoIR3Um9xK7PGoW8giupGn+EPuxIA4cDM4vzOqOkiMPhz5XK0whEjkVzTo4+S0puvDZuwIsdiW9mxhJc7tgBNL0cYlWSYVkz4G/fslNfRPW5mYAM49f4fhtxPb5ok4Q2Lg9dPKVHO/Bgeu5woMc7RY0p1ej6D4CKFE6lymSDJpW0YHX/wqE9+cfEauh7xZcG0q9t2ta6F6fmX0agvpFyZo8aFbXeUBr7osSCJNgvavWbM/06niWrOvYX2xwWdhXmXSrbX8ZbabVohBK41 email@example.com"

	createDir := t.TempDir()
	createProgram := `name: ec2-keypair-import-create
runtime: yaml
description: EC2 key pair import regression setup
config:
  keyName:
    type: string
  publicKey:
    type: string
resources:
  keyPair:
    type: aws:ec2:KeyPair
    properties:
      keyName: ${keyName}
      publicKey: ${publicKey}
outputs:
  keyName: ${keyPair.keyName}
  publicKey: ${keyPair.publicKey}
`
	require.NoError(t, os.WriteFile(filepath.Join(createDir, "Pulumi.yaml"), []byte(createProgram), 0o600))
	createTest := pulumitest.NewPulumiTest(t, createDir, options...)
	createTest.SetConfig(t, "aws:region", "us-west-2")
	createTest.SetConfig(t, "keyName", keyName)
	createTest.SetConfig(t, "publicKey", publicKey)

	createTest.Up(t)

	importOptions := append([]opttest.Option{}, options...)
	importOptions = append(importOptions, opttest.NewStackOptions(optnewstack.DisableAutoDestroy()))
	importDir := t.TempDir()
	importProgram := fmt.Sprintf(`name: ec2-keypair-import-import
runtime: yaml
description: EC2 key pair import regression
config:
  keyName:
    type: string
  publicKey:
    type: string
resources:
  keyPair:
    type: aws:ec2:KeyPair
    properties:
      keyName: ${keyName}
      publicKey: ${publicKey}
    options:
      import: %s
outputs:
  keyName: ${keyPair.keyName}
  publicKey: ${keyPair.publicKey}
`, keyName)
	require.NoError(t, os.WriteFile(filepath.Join(importDir, "Pulumi.yaml"), []byte(importProgram), 0o600))
	importTest := pulumitest.NewPulumiTest(t, importDir, importOptions...)
	importTest.SetConfig(t, "aws:region", "us-west-2")
	importTest.SetConfig(t, "keyName", keyName)
	importTest.SetConfig(t, "publicKey", publicKey)

	importResult := importTest.Up(t)
	assert.Equal(t, 1, (*importResult.Summary.ResourceChanges)["import"])
	assertpreview.HasNoChanges(t, importTest.Preview(t))
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

func TestAssumeRoleSessionTags(t *testing.T) {
	t.Parallel()
	ptest := pulumiTest(t, filepath.Join("test-programs", "assume-role-session-tags"), opttest.SkipInstall())
	result := ptest.Up(t)
	t.Logf("STDOUT: %v", result.StdOut)
	t.Logf("STDERR: %v", result.StdErr)

	require.Contains(t, result.Outputs, "bucketArn")
	assert.NotEmpty(t, result.Outputs["bucketArn"].Value.(string))
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

func TestSecurityGroupPreviewWarning(t *testing.T) {
	cwd := getCwd(t)
	firstProgram, err := os.ReadFile(filepath.Join(cwd, "test-programs", "security-group", "security-group-1", "Pulumi.yaml"))
	require.NoError(t, err)
	secondProgram, err := os.ReadFile(filepath.Join(cwd, "test-programs", "security-group", "Pulumi.yaml"))
	require.NoError(t, err)

	providerOpt := opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin"))
	pt := testProviderCodeChanges(t, &testProviderCodeChangesOptions{
		firstProgram:         firstProgram,
		secondProgram:        secondProgram,
		firstProgramOptions:  []opttest.Option{providerOpt},
		secondProgramOptions: []opttest.Option{providerOpt},
	})
	prev := pt.Preview(t, optpreview.Diff())

	assert.NotContains(t, prev.StdOut, "warning: Failed to calculate preview for element")
	assert.NotContains(t, prev.StdErr, "warning: Failed to calculate preview for element")
}
