package rds

import (
	"github.com/aws/aws-sdk-go/aws"
	"github.com/pulumi/pulumi-aws/provider/v5/telemetry/cloudwatch"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource/plugin"
	metrics "go.opentelemetry.io/proto/otlp/metrics/v1"

	awsShim "github.com/hashicorp/terraform-provider-aws/shim"
)

func GetClusterInstanceResourceMetrics(tf shim.Provider, id resource.ID, state resource.PropertyMap, options plugin.GetResourceMetricsOptions) ([]*metrics.Metric, string, error) {
	client := awsShim.GetAWSClient(tf.Meta())

	queries := []*cloudwatch.MetricDataQuery{
		{
			Id:    aws.String("cpuUtilization"),
			Label: aws.String("CPU Utilization"),
			MetricStat: &cloudwatch.MetricStat{
				Metric: &cloudwatch.Metric{
					Namespace:  aws.String("AWS/RDS"),
					MetricName: aws.String("CPUUtilization"),
					Dimensions: []*cloudwatch.Dimension{{
						Name:  aws.String("DBInstanceIdentifier"),
						Value: aws.String(string(id)),
					}},
				},
				Period: aws.Int64(300), // 5 minutes (TODO: make this configurable)
				Stat:   aws.String(cloudwatch.StatisticAverage),
			},
		},
		{
			Id:    aws.String("databaseConnections"),
			Label: aws.String("Database Connections"),
			MetricStat: &cloudwatch.MetricStat{
				Metric: &cloudwatch.Metric{
					Namespace:  aws.String("AWS/RDS"),
					MetricName: aws.String("DatabaseConnections"),
					Dimensions: []*cloudwatch.Dimension{{
						Name:  aws.String("DBInstanceIdentifier"),
						Value: aws.String(string(id)),
					}},
				},
				Period: aws.Int64(300), // 5 minutes (TODO: make this configurable)
				Stat:   aws.String(cloudwatch.StatisticAverage),
			},
		},
		{
			Id:    aws.String("networkReceiveThroughput"),
			Label: aws.String("Network Receive Throughput"),
			MetricStat: &cloudwatch.MetricStat{
				Metric: &cloudwatch.Metric{
					Namespace:  aws.String("AWS/RDS"),
					MetricName: aws.String("NetworkReceiveThroughput"),
					Dimensions: []*cloudwatch.Dimension{{
						Name:  aws.String("DBInstanceIdentifier"),
						Value: aws.String(string(id)),
					}},
				},
				Period: aws.Int64(300), // 5 minutes (TODO: make this configurable)
				Stat:   aws.String(cloudwatch.StatisticAverage),
			},
		},
		{
			Id:    aws.String("networkTransmitThroughput"),
			Label: aws.String("Network Transmit Throughput"),
			MetricStat: &cloudwatch.MetricStat{
				Metric: &cloudwatch.Metric{
					Namespace:  aws.String("AWS/RDS"),
					MetricName: aws.String("NetworkTransmitThroughput"),
					Dimensions: []*cloudwatch.Dimension{{
						Name:  aws.String("DBInstanceIdentifier"),
						Value: aws.String(string(id)),
					}},
				},
				Period: aws.Int64(300), // 5 minutes (TODO: make this configurable)
				Stat:   aws.String(cloudwatch.StatisticAverage),
			},
		},
	}

	return cloudwatch.GetMetrics(client.CloudWatchConn, queries, options.StartTime, options.EndTime, options.Count, options.ContinuationToken)
}
