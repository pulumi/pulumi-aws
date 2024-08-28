// Copyright 2016-2023, Pulumi Corporation.
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

//go:build nodejs || all
// +build nodejs all

package examples

// NOTE about build tags: CI does not understand yaml-specific tags yet, but splits builds per language to run on
// separate runners. This file piggy-backs on the nodejs tag so yaml tests will run on the same runner as node tests.

import (
	"fmt"
	"os"
	"path/filepath"
	"sort"
	"strconv"
	"strings"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
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
	t.Skip("TODO[pulumi/pulumi-terraform-bridge#2372]")
	types := []tagsType{
		// Pulumi maintains it's own version of aws:s3:Bucket in
		// `s3legacy/bucket_legacy.go`. Because we don't have any
		// terraform-provider-aws maintainers to ensure our tagging works the same
		// way as other resource's tagging, we give our own bucket special testing
		// to make sure that tags work.
		{
			name: "legacy", token: "aws:s3:Bucket",
		},

		// Both aws:cognito:UserPool and aws:s3:BucketV2 are full SDKv2 resources managed
		// by Terraform, but they have different requirements for successful tag
		// interactions. That is why we have tests for both resources.
		{
			name: "bucket", token: "aws:s3:BucketV2",
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
    type: aws:appconfig:Application
    properties:
      name: pf-tags-test-app`,
			properties: map[string]interface{}{
				"applicationId": "${app.id}",
				"name":          "pf-tags-test",
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
				t.Skipf(reason)
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
						"Unexpected stack output for step %d: %s", step, step.purpose)
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
  actual: ${res.tags}`

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
				require.NoError(t, os.MkdirAll(path, 0700))
				require.NoError(t, os.WriteFile(fpath, []byte(body), 0600))
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

// This replicates the diff when running `pulumi preview` on a aws.rds.Instance with
// pulumi-aws v6.0.0 and state from pulumi-aws 5.42.0.
//
// The first test ensures we don't regress on https://github.com/pulumi/pulumi-aws/issues/2682
//
// The second test is when upgrading from pulumi-aws version <5.0.0 to v6.x.x, and
// prevents regressions on https://github.com/pulumi/pulumi-aws/issues/2823.
//
// Updated in https://github.com/pulumi/pulumi-aws/pull/3881 to accept CHANGES_SOME so long as they are not
// replacements.
func TestMigrateRdsInstance(t *testing.T) {
	case1 := `[{
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
	    "changes": "*",
	    "hasDetailedDiff": true
	  }
	}]`

	case2 := `[{
	    "method": "/pulumirpc.ResourceProvider/Diff",
	    "request": {
	      "id": "rds2f5ed54",
	      "urn": "urn:pulumi:exp2::secret-random-yaml::aws:rds/instance:Instance::rds",
	      "olds": {
		"__meta": "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":2400000000000,\"delete\":3600000000000,\"update\":4800000000000},\"schema_version\":\"1\"}",
		"address": "rds2f5ed54.c1xxca33i6kr.us-east-2.rds.amazonaws.com",
		"allocatedStorage": 16,
		"applyImmediately": false,
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
	      "changes": "*",
	      "hasDetailedDiff": true
	    }
	  }
	]`

	// Like case2 but permits detailedDiff.
	case2a := `[{
	    "method": "/pulumirpc.ResourceProvider/Diff",
	    "request": {
	      "id": "rds2f5ed54",
	      "urn": "urn:pulumi:exp2::secret-random-yaml::aws:rds/instance:Instance::rds",
	      "olds": {
		"__meta": "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":2400000000000,\"delete\":3600000000000,\"update\":4800000000000},\"schema_version\":\"1\"}",
		"address": "rds2f5ed54.c1xxca33i6kr.us-east-2.rds.amazonaws.com",
		"allocatedStorage": 16,
		"applyImmediately": false,
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
              "diffs": "*",
	      "stables": "*",
	      "changes": "*",
	      "hasDetailedDiff": true,
              "detailedDiff": "*"
	    }
	  }
	]`

	t.Run("case1", func(t *testing.T) { replay(t, case1) })
	t.Run("case2", func(t *testing.T) { replay(t, case2) })
	t.Setenv("PULUMI_ENABLE_PLAN_RESOURCE_CHANGE", "true")
	t.Run("case1-plan-resource-change", func(t *testing.T) { replay(t, case1) })
	t.Run("case2-plan-resource-change", func(t *testing.T) { replay(t, case2a) })
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
      "method": "/pulumirpc.ResourceProvider/Diff",
      "request": {
          "id": "f8af893f-869e-4861-a403-1a4fe3509754",
          "urn": "urn:pulumi:dev::aws_esm_py::aws:lambda/eventSourceMapping:EventSourceMapping::example",
          "olds": {
              "amazonManagedKafkaEventSourceConfig": null,
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
              "uuid": "f8af893f-869e-4861-a403-1a4fe3509754"
          },
          "news": {
              "__defaults": [
                  "enabled"
              ],
              "enabled": true,
              "eventSourceArn": "arn:aws:sqs:us-east-1:616138583583:queue-7798098",
              "functionName": "arn:aws:lambda:us-east-1:616138583583:function:testLambda-74dac89"
          },
          "oldInputs": {
              "__defaults": [
                  "enabled"
              ],
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
