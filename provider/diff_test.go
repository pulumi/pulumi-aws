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
	"encoding/json"
	"fmt"
	"testing"

	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// Check that having manifest...retentionDays as "3650" in the state but 3650 (numeric value) in the program does not
// induce a diff as it is suppressed by the underlying provider.
//
// See also pulumi/pulumi-aws#3650.
func TestRegressLandingZoneDiff(t *testing.T) {
	t.Parallel()

	event := `
	[{
	  "method": "/pulumirpc.ResourceProvider/Diff",
	  "request": {
	    "id": "4UHHTLE0W30UX0TC",
	    "urn": "urn:pulumi:operations::aws-3650::aws:controltower/landingZone:LandingZone::lz_operations",
	    "olds": {
	      "__meta": "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":7200000000000,\"delete\":7200000000000,\"update\":7200000000000}}",
	      "arn": "arn:aws:controltower:ap-southeast-2:89XXXXXXXX25:landingzone/4UHHTLE0W30UX0TC",
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

	replaySequence(t, fmt.Sprintf(`
	[{
	  "method": "/pulumirpc.ResourceProvider/Diff",
	  "request": {
	    "id": "foo-bar-c7f12716",
	    "urn": "urn:pulumi:dev::repro::awsx:ecs:FargateService$awsx:ecs:FargateTaskDefinition$aws:ecs/taskDefinition:TaskDefinition::foo-bar",
	    "olds": {
	      "__meta": "{\"schema_version\":\"1\"}",
	      "arn": "arn:aws:ecs:us-east-1:616138583583:task-definition/foo-bar-c7f12716:1",
	      "arnWithoutRevision": "arn:aws:ecs:us-east-1:616138583583:task-definition/foo-bar-c7f12716",
	      "containerDefinitions": %s,
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
