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

package lambda

import (
	"github.com/aws/aws-sdk-go/aws"
	awsShim "github.com/hashicorp/terraform-provider-aws/shim"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource/plugin"
	logs "go.opentelemetry.io/proto/otlp/logs/v1"
	metrics "go.opentelemetry.io/proto/otlp/metrics/v1"

	"github.com/pulumi/pulumi-aws/provider/v5/telemetry/cloudwatch"
	"github.com/pulumi/pulumi-aws/provider/v5/telemetry/cloudwatchlogs"
)

func GetFunctionResourceLogs(tf shim.Provider, id resource.ID, state resource.PropertyMap, options plugin.GetResourceLogsOptions) ([]*logs.LogRecord, string, error) {
	client := awsShim.GetAWSClient(tf.Meta())
	name := state["name"].StringValue()
	logGroup := "/aws/lambda/" + name
	return cloudwatchlogs.GetLogs(client.LogsConn, logGroup, options.StartTime, options.EndTime, options.Count, options.ContinuationToken)
}

func GetFunctionResourceMetrics(tf shim.Provider, id resource.ID, state resource.PropertyMap, options plugin.GetResourceMetricsOptions) ([]*metrics.Metric, string, error) {
	client := awsShim.GetAWSClient(tf.Meta())
	name := state["name"].StringValue()

	queries := []*cloudwatch.MetricDataQuery{
		{
			Id:    aws.String("invocations"),
			Label: aws.String("Invocations"),
			MetricStat: &cloudwatch.MetricStat{
				Metric: &cloudwatch.Metric{
					Namespace:  aws.String("AWS/Lambda"),
					MetricName: aws.String("Invocations"),
					Dimensions: []*cloudwatch.Dimension{{
						Name:  aws.String("FunctionName"),
						Value: aws.String(name),
					}},
				},
				Period: aws.Int64(300), // 5 minutes (TODO: make this configurable)
				Stat:   aws.String(cloudwatch.StatisticSum),
			},
		},
		{
			Id:    aws.String("duration"),
			Label: aws.String("Avg. Duration"),
			MetricStat: &cloudwatch.MetricStat{
				Metric: &cloudwatch.Metric{
					Namespace:  aws.String("AWS/Lambda"),
					MetricName: aws.String("Duration"),
					Dimensions: []*cloudwatch.Dimension{{
						Name:  aws.String("FunctionName"),
						Value: aws.String(name),
					}},
				},
				Period: aws.Int64(300), // 5 minutes (TODO: make this configurable)
				Stat:   aws.String(cloudwatch.StatisticAverage),
			},
		},
	}

	return cloudwatch.GetMetrics(client.CloudWatchConn, queries, options.StartTime, options.EndTime, options.Count, options.ContinuationToken)
}
