// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package examples

import (
	"bytes"
	"context"
	"io"
	"io/ioutil"
	"net/http"
	"os"
	"testing"
	"time"

	pfbridge "github.com/pulumi/pulumi-terraform-bridge/pf/tfbridge"
	testutils "github.com/pulumi/pulumi-terraform-bridge/testing/x"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	aws "github.com/pulumi/pulumi-aws/provider/v6"
	version "github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

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

func init() {
	// This is necessary for gRPC testing. It doesn't effect integration tests, since
	// they use their own binary.
	version.Version = "6.0.0"
}

func replay(t *testing.T, sequence string) {
	info := *aws.Provider()
	ctx := context.Background()
	p, err := pfbridge.MakeMuxedServer(ctx, info.Name, info,
		/*
		 * We leave the schema blank. This will result in incorrect calls to
		 * GetSchema, but otherwise does not effect the provider. It reduces the
		 * time to test start by minutes.
		 */
		[]byte("{}"),
	)(nil)
	require.NoError(t, err)
	testutils.ReplaySequence(t, p, sequence)
}

// This replicates the diff when running `pulumi preview` on a aws.rds.Instance with
// pulumi-aws v6.0.0 and state from pulumi-aws 5.42.0.
//
// The first test ensures we don't regress on https://github.com/pulumi/pulumi-aws/issues/2682
//
// The second test is when upgrading from pulumi-aws version <5.0.0 to v6.x.x, and
// prevents regressions on https://github.com/pulumi/pulumi-aws/issues/2823.
func TestMigrateRdsInstance(t *testing.T) {
	replay(t, `[
  {
    "method": "/pulumirpc.ResourceProvider/Diff",
    "request": {
      "id": "postgresdb8a8a6f1",
      "urn": "urn:pulumi:dev::ts::aws:rds/instance:Instance::postgresdb",
      "olds": {
        "__meta": "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":2400000000000,\"delete\":3600000000000,\"update\":4800000000000},\"schema_version\":\"1\"}",
        "address": "postgresdb8a8a6f1.chuqccm8uxqx.us-west-2.rds.amazonaws.com",
        "allocatedStorage": 30,
        "applyImmediately": false,
        "arn": "arn:aws:rds:us-west-2:616138583583:db:postgresdb8a8a6f1",
        "autoMinorVersionUpgrade": true,
        "availabilityZone": "us-west-2d",
        "backupRetentionPeriod": 0,
        "backupWindow": "06:15-06:45",
        "caCertIdentifier": "rds-ca-2019",
        "characterSetName": "",
        "copyTagsToSnapshot": false,
        "customIamInstanceProfile": "",
        "customerOwnedIpEnabled": false,
        "dbName": "airflow",
        "dbSubnetGroupName": "default",
        "deleteAutomatedBackups": true,
        "deletionProtection": false,
        "domain": "",
        "domainIamRoleName": "",
        "enabledCloudwatchLogsExports": [],
        "endpoint": "postgresdb8a8a6f1.chuqccm8uxqx.us-west-2.rds.amazonaws.com:5432",
        "engine": "postgres",
        "engineVersion": "15.3",
        "engineVersionActual": "15.3",
        "hostedZoneId": "Z1PVIF0B656C1W",
        "iamDatabaseAuthenticationEnabled": false,
        "id": "postgresdb8a8a6f1",
        "identifier": "postgresdb8a8a6f1",
        "identifierPrefix": "",
        "instanceClass": "db.t4g.micro",
        "iops": 0,
        "kmsKeyId": "",
        "latestRestorableTime": "",
        "licenseModel": "postgresql-license",
        "listenerEndpoints": [],
        "maintenanceWindow": "sun:07:16-sun:07:46",
        "masterUserSecrets": [],
        "maxAllocatedStorage": 0,
        "monitoringInterval": 0,
        "monitoringRoleArn": "",
        "multiAz": false,
        "name": "airflow",
        "ncharCharacterSetName": "",
        "networkType": "IPV4",
        "optionGroupName": "default:postgres-15",
        "parameterGroupName": "default.postgres15",
        "password": "tuFp574p9Arw58gu",
        "performanceInsightsEnabled": false,
        "performanceInsightsKmsKeyId": "",
        "performanceInsightsRetentionPeriod": 0,
        "port": 5432,
        "publiclyAccessible": false,
        "replicaMode": "",
        "replicas": [],
        "replicateSourceDb": "",
        "resourceId": "db-DUPUZANEFBXYECMTI2B5RZPTOE",
        "securityGroupNames": [],
        "skipFinalSnapshot": true,
        "status": "available",
        "storageEncrypted": false,
        "storageThroughput": 0,
        "storageType": "gp2",
        "tags": {},
        "tagsAll": {},
        "timezone": "",
        "username": "airflow",
        "vpcSecurityGroupIds": [
          "sg-4d436f12"
        ]
      },
      "news": {
        "__defaults": [
          "applyImmediately",
          "autoMinorVersionUpgrade",
          "copyTagsToSnapshot",
          "deleteAutomatedBackups",
          "identifier",
          "monitoringInterval",
          "performanceInsightsEnabled",
          "publiclyAccessible"
        ],
        "allocatedStorage": 30,
        "applyImmediately": false,
        "autoMinorVersionUpgrade": true,
        "copyTagsToSnapshot": false,
        "deleteAutomatedBackups": true,
        "engine": "postgres",
        "identifier": "postgresdb8a8a6f1",
        "instanceClass": "db.t4g.micro",
        "monitoringInterval": 0,
        "dbName": "airflow",
        "password": "tuFp574p9Arw58gu",
        "performanceInsightsEnabled": false,
        "publiclyAccessible": false,
        "skipFinalSnapshot": true,
        "username": "airflow"
      },
      "oldInputs": {
        "__defaults": [
          "applyImmediately",
          "autoMinorVersionUpgrade",
          "copyTagsToSnapshot",
          "deleteAutomatedBackups",
          "identifier",
          "monitoringInterval",
          "performanceInsightsEnabled",
          "publiclyAccessible"
        ],
        "allocatedStorage": 30,
        "applyImmediately": false,
        "autoMinorVersionUpgrade": true,
        "copyTagsToSnapshot": false,
        "deleteAutomatedBackups": true,
        "engine": "postgres",
        "identifier": "postgresdb8a8a6f1",
        "instanceClass": "db.t4g.micro",
        "monitoringInterval": 0,
        "name": "airflow",
        "password": "tuFp574p9Arw58gu",
        "performanceInsightsEnabled": false,
        "publiclyAccessible": false,
        "skipFinalSnapshot": true,
        "username": "airflow"
      }
    },
    "response": {
      "stables": "*",
      "changes": "DIFF_NONE",
      "hasDetailedDiff": true
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
      "id": "rds2f5ed54",
      "urn": "urn:pulumi:exp2::secret-random-yaml::aws:rds/instance:Instance::rds",
      "olds": {
        "__meta": "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":2400000000000,\"delete\":3600000000000,\"update\":4800000000000},\"schema_version\":\"1\"}",
        "address": "rds2f5ed54.c1xxca33i6kr.us-east-2.rds.amazonaws.com",
        "allocatedStorage": 16,
        "arn": "arn:aws:rds:us-east-2:616138583583:db:rds2f5ed54",
        "autoMinorVersionUpgrade": true,
        "availabilityZone": "us-east-2c",
        "backupRetentionPeriod": 0,
        "backupWindow": "07:34-08:04",
        "caCertIdentifier": "rds-ca-2019",
        "copyTagsToSnapshot": false,
        "dbSubnetGroupName": "default",
        "deleteAutomatedBackups": true,
        "deletionProtection": false,
        "domain": "",
        "domainIamRoleName": "",
        "enabledCloudwatchLogsExports": [],
        "endpoint": "rds2f5ed54.c1xxca33i6kr.us-east-2.rds.amazonaws.com:3306",
        "engine": "mysql",
        "engineVersion": "8.0.33",
        "hostedZoneId": "Z2XHWR1WZ565X2",
        "iamDatabaseAuthenticationEnabled": false,
        "id": "rds2f5ed54",
        "identifier": "rds2f5ed54",
        "instanceClass": "db.t3.micro",
        "iops": 0,
        "kmsKeyId": "",
        "latestRestorableTime": "0001-01-01T00:00:00Z",
        "licenseModel": "general-public-license",
        "maintenanceWindow": "sun:03:59-sun:04:29",
        "maxAllocatedStorage": 0,
        "monitoringInterval": 0,
        "monitoringRoleArn": "",
        "multiAz": false,
        "name": "name",
        "optionGroupName": "default:mysql-8-0",
        "parameterGroupName": "default.mysql8.0",
        "password": "FOO-BAR-FIZZ1!2",
        "performanceInsightsEnabled": false,
        "performanceInsightsKmsKeyId": "",
        "performanceInsightsRetentionPeriod": 0,
        "port": 3306,
        "publiclyAccessible": false,
        "replicas": [],
        "replicateSourceDb": "",
        "resourceId": "db-N57SF65OZ5KO3TPK73R7DQMLZA",
        "securityGroupNames": [],
        "skipFinalSnapshot": true,
        "status": "available",
        "storageEncrypted": false,
        "storageType": "gp2",
        "tags": {
          "some": "change"
        },
        "timezone": "",
        "username": "root",
        "vpcSecurityGroupIds": [
          "sg-1928d262"
        ]
      },
      "news": {
        "__defaults": [
          "applyImmediately",
          "autoMinorVersionUpgrade",
          "copyTagsToSnapshot",
          "deleteAutomatedBackups",
          "identifier",
          "monitoringInterval",
          "performanceInsightsEnabled",
          "publiclyAccessible"
        ],
        "allocatedStorage": 16,
        "applyImmediately": false,
        "autoMinorVersionUpgrade": true,
        "copyTagsToSnapshot": false,
        "dbName": "name",
        "deleteAutomatedBackups": true,
        "engine": "mysql",
        "identifier": "rds2f5ed54",
        "instanceClass": "db.t3.micro",
        "monitoringInterval": 0,
        "password": "FOO-BAR-FIZZ1!2",
        "performanceInsightsEnabled": false,
        "publiclyAccessible": false,
        "skipFinalSnapshot": true,
        "tags": {
          "__defaults": [],
          "some": "change"
        },
        "username": "root"
      },
      "oldInputs": {
        "__defaults": [
          "applyImmediately",
          "autoMinorVersionUpgrade",
          "copyTagsToSnapshot",
          "deleteAutomatedBackups",
          "identifier",
          "monitoringInterval",
          "performanceInsightsEnabled",
          "publiclyAccessible"
        ],
        "allocatedStorage": 16,
        "applyImmediately": false,
        "autoMinorVersionUpgrade": true,
        "copyTagsToSnapshot": false,
        "deleteAutomatedBackups": true,
        "engine": "mysql",
        "identifier": "rds2f5ed54",
        "instanceClass": "db.t3.micro",
        "monitoringInterval": 0,
        "name": "name",
        "password": "FOO-BAR-FIZZ1!2",
        "performanceInsightsEnabled": false,
        "publiclyAccessible": false,
        "skipFinalSnapshot": true,
        "tags": {
          "__defaults": [],
          "some": "change"
        },
        "username": "root"
      }
    },
    "response": {
      "stables": "*",
      "changes": "DIFF_NONE",
      "hasDetailedDiff": true
    },
    "metadata": {
      "kind": "resource",
      "mode": "client",
      "name": "aws"
    }
  }
]`)
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
		"__defaults": [
		  "name"
		],
		"description": "Managed by Pulumi",
		"name": "example-ng-tags-ng2-nodeSecurityGroup-8012419",
		"revokeRulesOnDelete": true,
		"vpcId": "vpc-4b82e033",
		"tags": "04da6b54-80e4-46f7-96ec-b56ff0331ba9",
                "tagsAll": {
                    "4dabf18193072939515e22adb298388d": "1b47061264138c4ac30d75fd1eb44270",
                    "value": "04da6b54-80e4-46f7-96ec-b56ff0331ba9"
                }
              }
            }
          }
        ]
	`
	replay(t, repro)
}

// Assert that we don't regress on https://github.com/pulumi/pulumi-aws/issues/2796
func TestS3BucketObjectDeprecation(t *testing.T) {
	repro := `[
  {
    "metadata": {
      "kind": "resource",
      "mode": "client",
      "name": "aws"
    },
    "method": "/pulumirpc.ResourceProvider/Check",
    "request": {
      "news": {
        "bucket": "04da6b54-80e4-46f7-96ec-b56ff0331ba9",
        "content": "CONTENT"
      },
      "olds": {},
      "randomSeed": "BoD5xyY00fW+jTMLexVckztJvRX8NUs3a6SIkldxdlQ=",
      "urn": "urn:pulumi:dev::secret-random-yaml::aws:s3/bucketObject:BucketObject::o1"
    },
    "response": {
      "inputs": {
        "__defaults": [
          "acl",
          "forceDestroy",
          "key"
        ],
        "acl": "private",
        "bucket": "04da6b54-80e4-46f7-96ec-b56ff0331ba9",
        "content": "CONTENT",
        "forceDestroy": false,
        "key": "o1"
      }
    }
  },
  {
    "metadata": {
      "kind": "resource",
      "mode": "client",
      "name": "aws"
    },
    "method": "/pulumirpc.ResourceProvider/Create",
    "request": {
      "preview": true,
      "properties": {
        "__defaults": [
          "acl",
          "forceDestroy",
          "key"
        ],
        "acl": "private",
        "bucket": "04da6b54-80e4-46f7-96ec-b56ff0331ba9",
        "content": "CONTENT",
        "forceDestroy": false,
        "key": "o1"
      },
      "urn": "urn:pulumi:dev::secret-random-yaml::aws:s3/bucketObject:BucketObject::o1"
    },
    "response": {
      "properties": {
        "acl": "private",
        "content": "CONTENT",
        "forceDestroy": false,
        "id": "",
        "key": "o1"
      }
    }
  }
]`
	old := os.Stdout // keep backup of the real stdout
	defer func() { os.Stdout = old }()
	r, w, _ := os.Pipe()
	os.Stdout = w

	replay(t, repro)

	outC := make(chan string)
	go func() {
		var buf bytes.Buffer
		io.Copy(&buf, r)
		outC <- buf.String()
	}()

	w.Close()
	out := <-outC
	assert.NotContains(t, out, "aws_s3_object")
}
