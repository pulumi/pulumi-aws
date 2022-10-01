// Copyright 2016-2018, Pulumi Corporation.
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

package ecs

import (
	"encoding/json"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/service/ecs"
	awsShim "github.com/hashicorp/terraform-provider-aws/shim"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource/plugin"
	logs "go.opentelemetry.io/proto/otlp/logs/v1"

	"github.com/pulumi/pulumi-aws/provider/v5/telemetry/cloudwatchlogs"
)

func GetServiceResourceLogs(tf shim.Provider, id resource.ID, state resource.PropertyMap, options plugin.GetResourceLogsOptions) ([]*logs.LogRecord, string, error) {
	client := awsShim.GetAWSClient(tf.Meta())

	var tokens map[string]string
	if options.ContinuationToken != "" {
		if err := json.Unmarshal([]byte(options.ContinuationToken), &tokens); err != nil {
			return nil, "", err
		}
	} else {
		cluster := state["cluster"].StringValue()
		service := state["name"].StringValue()

		// Fetch the service's task definition in order to get at its
		conn := client.ECSConn
		services, err := conn.DescribeServices(&ecs.DescribeServicesInput{
			Cluster:  aws.String(cluster),
			Services: []*string{aws.String(service)},
		})
		if err != nil {
			return nil, "", err
		}

		// get task definition
		task, err := conn.DescribeTaskDefinition(&ecs.DescribeTaskDefinitionInput{
			TaskDefinition: services.Services[0].TaskDefinition,
		})
		if err != nil {
			return nil, "", err
		}

		tokens = map[string]string{}
		for _, def := range task.TaskDefinition.ContainerDefinitions {
			if aws.StringValue(def.LogConfiguration.LogDriver) == "awslogs" {
				tokens[aws.StringValue(def.LogConfiguration.Options["awslogs-group"])] = ""
			}
		}
	}

	var records []*logs.LogRecord
	var nextTokens map[string]string
	for logGroup, token := range tokens {
		logs, token, err := cloudwatchlogs.GetLogs(client.LogsConn, logGroup, options.StartTime, options.EndTime, options.Count, token)
		if err != nil {
			return nil, "", err
		}
		records = append(records, logs...)

		if token != "" {
			if nextTokens == nil {
				nextTokens = map[string]string{}
			}
			nextTokens[logGroup] = token
		}
	}

	var nextToken string
	if len(nextTokens) != 0 {
		t, err := json.Marshal(nextTokens)
		if err != nil {
			return nil, "", err
		}
		nextToken = string(t)
	}

	return records, nextToken, nil
}
