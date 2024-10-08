// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Outputs
{

    [OutputType]
    public sealed class PolicyTargetTrackingConfigurationCustomizedMetricSpecification
    {
        /// <summary>
        /// Dimensions of the metric.
        /// </summary>
        public readonly ImmutableArray<Outputs.PolicyTargetTrackingConfigurationCustomizedMetricSpecificationMetricDimension> MetricDimensions;
        /// <summary>
        /// Name of the metric.
        /// </summary>
        public readonly string? MetricName;
        /// <summary>
        /// Metrics to include, as a metric data query.
        /// </summary>
        public readonly ImmutableArray<Outputs.PolicyTargetTrackingConfigurationCustomizedMetricSpecificationMetric> Metrics;
        /// <summary>
        /// Namespace of the metric.
        /// </summary>
        public readonly string? Namespace;
        /// <summary>
        /// Statistic of the metric.
        /// </summary>
        public readonly string? Statistic;
        /// <summary>
        /// Unit of the metric.
        /// </summary>
        public readonly string? Unit;

        [OutputConstructor]
        private PolicyTargetTrackingConfigurationCustomizedMetricSpecification(
            ImmutableArray<Outputs.PolicyTargetTrackingConfigurationCustomizedMetricSpecificationMetricDimension> metricDimensions,

            string? metricName,

            ImmutableArray<Outputs.PolicyTargetTrackingConfigurationCustomizedMetricSpecificationMetric> metrics,

            string? @namespace,

            string? statistic,

            string? unit)
        {
            MetricDimensions = metricDimensions;
            MetricName = metricName;
            Metrics = metrics;
            Namespace = @namespace;
            Statistic = statistic;
            Unit = unit;
        }
    }
}
