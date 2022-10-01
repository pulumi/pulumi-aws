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

package cloudwatchlogs

import (
	"sort"
	"time"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/service/cloudwatchlogs"
	awsShim "github.com/hashicorp/terraform-provider-aws/shim"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource/plugin"
	common "go.opentelemetry.io/proto/otlp/common/v1"
	logs "go.opentelemetry.io/proto/otlp/logs/v1"
)

func GetLogGroupResourceLogs(tf shim.Provider, id resource.ID, state resource.PropertyMap, options plugin.GetResourceLogsOptions) ([]*logs.LogRecord, string, error) {
	client := awsShim.GetAWSClient(tf.Meta())
	name := state["name"].StringValue()
	return GetLogs(client.LogsConn, name, options.StartTime, options.EndTime, options.Count, options.ContinuationToken)
}

func GetLogs(
	conn *cloudwatchlogs.CloudWatchLogs,
	logGroup string,
	startTime time.Time,
	endTime time.Time,
	limit int,
	nextToken string) ([]*logs.LogRecord, string, error) {

	var startMilli *int64
	if !startTime.IsZero() {
		startMilli = aws.Int64(aws.TimeUnixMilli(startTime))
	}
	var endMilli *int64
	if !endTime.IsZero() {
		endMilli = aws.Int64(aws.TimeUnixMilli(endTime))
	}
	var token *string
	if nextToken != "" {
		token = aws.String(nextToken)
	}
	var limit64 *int64
	if limit != 0 {
		limit64 = aws.Int64(int64(limit))
	}

	// Run FilterLogEvents for each log group in parallel
	var result []*logs.LogRecord
	resp, err := conn.FilterLogEvents(&cloudwatchlogs.FilterLogEventsInput{
		LogGroupName: aws.String(logGroup),
		StartTime:    startMilli,
		EndTime:      endMilli,
		NextToken:    token,
		Limit:        limit64,
	})
	if err != nil {
		return nil, "", err
	}

	// If the request's continuation token is the same as the input token, we're done.
	if aws.StringValue(resp.NextToken) == nextToken {
		return nil, "", nil
	}

	for _, event := range resp.Events {
		result = append(result, &logs.LogRecord{
			TimeUnixNano: uint64(aws.Int64Value(event.Timestamp) * 1000000),
			Body:         &common.AnyValue{Value: &common.AnyValue_StringValue{StringValue: aws.StringValue(event.Message)}},
		})
	}
	sort.SliceStable(result, func(i, j int) bool { return result[i].TimeUnixNano < result[j].TimeUnixNano })
	return result, aws.StringValue(resp.NextToken), nil
}
