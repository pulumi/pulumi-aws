// Copyright 2016-2023, Pulumi Corporation.  All rights reserved.

//go:build !go && !nodejs && !python && !dotnet
// +build !go,!nodejs,!python,!dotnet

package provider

import (
	"context"
	"fmt"
	"math/rand"
	"os"
	"path/filepath"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	"github.com/pulumi/pulumi/sdk/v3/go/common/apitype"

	"github.com/pulumi/providertest"
	"github.com/pulumi/providertest/pulumitest"
	"github.com/pulumi/providertest/pulumitest/assertpreview"
	"github.com/pulumi/providertest/pulumitest/opttest"
)

func TestBucket(t *testing.T) {
	test(t, filepath.Join("test-programs", "bucket"), "")
}

func TestEKSCluster(t *testing.T) {
	test(t, filepath.Join("test-programs", "eks-cluster"), "")
}

func TestRdsInstance(t *testing.T) {
	test(t, filepath.Join("test-programs", "rds-instance"), "")
}

func TestRoute53ResolverEndpoint(t *testing.T) {
	test(t, filepath.Join("test-programs", "route53-resolver-endpoint"), "")
}

func TestSnsTopic(t *testing.T) {
	test(t, filepath.Join("test-programs", "sns-topic"), "")
}

func TestApiGatewayIntegrationResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-integrationresponse"), "")
}

func TestApiGatewayMethodResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-methodreponse"), "")
}

func TestApiGatewayResource(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-resource"), "")
}

func TestApiGatewayResourceResponse(t *testing.T) {
	test(t, filepath.Join("test-programs", "apigateway-resource-response"), "")
}

func TestCloudwatchEventRule(t *testing.T) {
	test(t, filepath.Join("test-programs", "cloudwatch-eventrule"), "")
}

func TestCloudwatchLogGroup(t *testing.T) {
	test(t, filepath.Join("test-programs", "cloudwatch-loggroup"), "")
}

func TestDynamoTable(t *testing.T) {
	test(t, filepath.Join("test-programs", "dynamodb-table"), "",
		providertest.WithDiffValidation(providertest.NoReplacements()))
}

func TestEcrLifecyclePolicy(t *testing.T) {
	test(t, filepath.Join("test-programs", "ecr-lifecyclepolicy"), "")
}

func TestEcrRepository(t *testing.T) {
	test(t, filepath.Join("test-programs", "ecr-repository"), "")
}

func TestIamInstanceProfile(t *testing.T) {
	test(t, filepath.Join("test-programs", "iam-instanceprofile"), "")
}

func TestIamOpenIDConnectProvider(t *testing.T) {
	test(t, filepath.Join("test-programs", "iam-openidconnectprovider"), "")
}

func TestKmsKey(t *testing.T) {
	test(t, filepath.Join("test-programs", "kms-key"), "")
}

func TestSecretsManagerSecret(t *testing.T) {
	test(t, filepath.Join("test-programs", "secretsmanager-secret"), "")
}

func TestEC2Networking(t *testing.T) {
	test(t, filepath.Join("test-programs", "ec2-networking"), "")
}

func TestECSService(t *testing.T) {
	test(t, filepath.Join("test-programs", "ecs-service"), "")
}

func TestIAMUser(t *testing.T) {
	test(t, filepath.Join("test-programs", "iam-user"), "")
}

func TestLB(t *testing.T) {
	test(t, filepath.Join("test-programs", "lb"), "")
}

func TestACM(t *testing.T) {
	t.Skip("Blocked by https://github.com/pulumi/pulumi-aws/issues/3617")
	test(t, filepath.Join("test-programs", "acm"), "")
}

func TestBucketObj(t *testing.T) {
	test(t, filepath.Join("test-programs", "bucket-obj"), "")
}

func TestSubnetGroup(t *testing.T) {
	test(t, filepath.Join("test-programs", "subnet-group"), "")
}

func TestEC2Instance(t *testing.T) {
	test(t, filepath.Join("test-programs", "ec2-instance"), "")
}

func TestCloudfrontDistribution(t *testing.T) {
	// Baseline version is needed because of https://github.com/pulumi/providertest/issues/76
	test(t, filepath.Join("test-programs", "cloudfront-distribution"), "6.10.0")
}

func TestSecretVersion(t *testing.T) {
	test(t, filepath.Join("test-programs", "secretversion"), "")
}

func TestRdsParameterGroupUnclearDiff(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping in testing.Short() mode, assuming this is a CI run without credentials")
	}

	type testCase struct {
		name          string
		applyMethod1  string
		value1        string
		applyMethod2  string
		value2        string
		expectChanges bool
	}

	testCases := []testCase{
		{"changing only applyMethod", "immediate", "1", "pending-reboot", "1", false},
		{"changing only value", "immediate", "1", "immediate", "0", true},
		{"changing both applyMethod and value", "immediate", "1", "pending-reboot", "0", true},
	}

	cwd, err := os.Getwd()
	require.NoError(t, err)

	yaml := `
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

	for _, tc := range testCases {
		tc := tc

		t.Run(tc.name, func(t *testing.T) {
			workdir := t.TempDir()

			err := os.WriteFile(filepath.Join(workdir, "Pulumi.yaml"), []byte(yaml), 0600)
			require.NoError(t, err)

			pt := pulumitest.NewPulumiTest(t, workdir,
				opttest.SkipInstall(),
				opttest.TestInPlace(),
				opttest.LocalProviderPath("aws", filepath.Join(cwd, "..", "bin")),
			)

			pt.SetConfig("randSuffix", fmt.Sprintf("%d", rand.Intn(1024*1024)))

			pt.SetConfig("applyMethod", tc.applyMethod1)
			pt.SetConfig("value", tc.value1)

			pt.Up()

			assertpreview.HasNoChanges(t, pt.Preview())

			pt.SetConfig("applyMethod", tc.applyMethod2)
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
