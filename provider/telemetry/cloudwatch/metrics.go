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

package cloudwatch

import (
	"time"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/service/cloudwatch"
	metrics "go.opentelemetry.io/proto/otlp/metrics/v1"
)

type MetricDataQuery = cloudwatch.MetricDataQuery
type MetricStat = cloudwatch.MetricStat
type Metric = cloudwatch.Metric
type Dimension = cloudwatch.Dimension

const StatisticSum = cloudwatch.StatisticSum
const StatisticAverage = cloudwatch.StatisticAverage

func GetMetrics(
	conn *cloudwatch.CloudWatch,
	queries []*MetricDataQuery,
	startTime time.Time,
	endTime time.Time,
	limit int,
	nextToken string) ([]*metrics.Metric, string, error) {

	if endTime.IsZero() {
		endTime = time.Now()
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
	resp, err := conn.GetMetricData(&cloudwatch.GetMetricDataInput{
		MetricDataQueries: queries,
		ScanBy:            aws.String(cloudwatch.ScanByTimestampAscending),
		StartTime:         aws.Time(startTime),
		EndTime:           aws.Time(endTime),
		NextToken:         token,
		MaxDatapoints:     limit64,
	})
	if err != nil {
		return nil, "", err
	}

	result := make([]*metrics.Metric, len(resp.MetricDataResults))
	for i, metric := range resp.MetricDataResults {
		datapoints := make([]*metrics.NumberDataPoint, len(metric.Timestamps))
		for j, t := range metric.Timestamps {
			value := metric.Values[j]
			datapoints[j] = &metrics.NumberDataPoint{
				TimeUnixNano: uint64(t.UnixNano()),
				Value:        &metrics.NumberDataPoint_AsDouble{AsDouble: aws.Float64Value(value)},
			}
		}
		result[i] = &metrics.Metric{
			Name: aws.StringValue(metric.Label),
			Data: &metrics.Metric_Gauge{
				Gauge: &metrics.Gauge{
					DataPoints: datapoints,
				},
			},
		}
	}
	return result, aws.StringValue(resp.NextToken), nil
}
