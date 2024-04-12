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

package provider

import (
	"testing"
)

// Check that having manifest...retentionDays as "3650" in the state but 3650 (numeric value) in the program does not
// induce a diff as it is suppressed by the underlying provider.
//
// See also pulumi/pulumi-aws#3650.
func TestRegressLandingZoneDiff(t *testing.T) {
	event := `
	[{
	  "method": "/pulumirpc.ResourceProvider/Diff",
	  "request": {
	    "id": "4UHHTLE0W30UX0TC",
	    "urn": "urn:pulumi:operations::aws-3650::aws:controltower/landingZone:LandingZone::lz_operations",
	    "olds": {
	      "__meta": "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":7200000000000,\"delete\":7200000000000,\"update\":7200000000000}}",
	      "arn": "arn:aws:controltower:ap-southeast-2:89XXXXXXXX25:landingzone/4UHHTLE0W30UX0TC",
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
	      "manifestJson": "{\"governedRegions\": [\"ap-southeast-2\"], \"organizationStructure\": {\"security\": {\"name\": \"Security\"}}, \"centralizedLogging\": {\"accountId\": \"89XXXXXXXX39\", \"configurations\": {\"accessLoggingBucket\": {\"retentionDays\": 3650}, \"kmsKeyArn\": \"arn:aws:kms:ap-southeast-2:89XXXXXXXX25:key/10e27ec4-55b0-42b7-b408-72b11a3f4550\", \"loggingBucket\": {\"retentionDays\": 365}}, \"enabled\": true}, \"securityRoles\": {\"accountId\": \"89XXXXXXXX42\"}, \"accessManagement\": {\"enabled\": true}}",
	      "version": "3.3"
	    },
	    "oldInputs": {
	      "__defaults": [],
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
