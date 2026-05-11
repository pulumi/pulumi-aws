// Copyright 2016-2024, Pulumi Corporation.  All rights reserved.

package provider

import (
	"encoding/base64"
	"fmt"
	"os"
	"testing"

	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/stretchr/testify/require"
)

func setReplayAWSEnv(t *testing.T) {
	t.Helper()
	os.Setenv("AWS_ACCESS_KEY_ID", "test")
	os.Setenv("AWS_SECRET_ACCESS_KEY", "test")
	os.Setenv("AWS_SESSION_TOKEN", "test")
	os.Setenv("AWS_REGION", "us-east-1")
	os.Setenv("AWS_DEFAULT_REGION", "us-east-1")
	os.Setenv("AWS_PROFILE", "")
	os.Setenv("AWS_CONFIG_FILE", "non-existent/config.json")
	os.Setenv("AWS_SHARED_CREDENTIALS_FILE", "non-existent/credentials")
	os.Setenv("AWS_SKIP_CREDENTIALS_VALIDATION", "true")
	os.Setenv("AWS_SKIP_METADATA_API_CHECK", "true")
}

func TestRegressUnknownTags(t *testing.T) {
	setReplayAWSEnv(t)

	seedB64 := "pm3N78209q8Aq/BJU17gDsIRv2BvC/geMb0WK/pMRQg="
	seed, err := base64.StdEncoding.DecodeString(seedB64)
	require.NoError(t, err)

	// Avoid hardcoding deterministic suffixes; transitive RNG dependency updates can
	// change NewUniqueName output without changing provider behavior.
	expectedName, err := resource.NewUniqueName(seed, "example-ng-tags-ng2-nodeSecurityGroup-", 7, 255, nil)
	require.NoError(t, err)

	repro := fmt.Sprintf(`
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
	      "randomSeed": %q
	    },
	    "response": {
	      "inputs": {
					"tagsAll": {},
		"__defaults": [
		  "name"
		],
		"description": "Managed by Pulumi",
		"name": %q,
		"revokeRulesOnDelete": true,
		"vpcId": "vpc-4b82e033",
		"tags": "04da6b54-80e4-46f7-96ec-b56ff0331ba9",
                "tagsAll": "04da6b54-80e4-46f7-96ec-b56ff0331ba9"
              }
            }
          }
        ]
	`, seedB64, expectedName)
	replaySequence(t, repro)
}

func TestSourceCodeHashImportedLambdaChecksCleanly(t *testing.T) {
	setReplayAWSEnv(t)

	replaySequence(t, `
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
                "reservedConcurrentExecutions",
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
                "__defaults": [],
                "logFormat": "Text",
                "logGroup": "/aws/lambda/testLambda-83906f2"
            },
            "memorySize": 128,
            "name": "testLambda-83906f2",
            "packageType": "Zip",
            "reservedConcurrentExecutions": -1,
            "role": "arn:aws:iam::616138583583:role/iamForLambda-d5757fe",
            "runtime": "nodejs18.x",
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
	setReplayAWSEnv(t)

	event := `
	[
		{
			"method": "/pulumirpc.ResourceProvider/Configure",
			"request": {
				"variables": {
					"aws:config:region": "us-east-1",
					"aws:config:skipCredentialsValidation": "true",
					"aws:config:skipRegionValidation": "true",
					"aws:config:skipRequestingAccountId": "true"
				},
				"args": {
					"region": "us-east-1",
					"skipCredentialsValidation": "true",
					"skipRegionValidation": "true",
					"skipRequestingAccountId": "true",
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
	replaySequence(t, event)
}
