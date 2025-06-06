// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeBuild.Outputs
{

    [OutputType]
    public sealed class GetFleetScalingConfigurationTargetTrackingScalingConfigResult
    {
        /// <summary>
        /// The metric type to determine auto-scaling.
        /// </summary>
        public readonly string MetricType;
        /// <summary>
        /// The value of metric_type when to start scaling.
        /// </summary>
        public readonly double TargetValue;

        [OutputConstructor]
        private GetFleetScalingConfigurationTargetTrackingScalingConfigResult(
            string metricType,

            double targetValue)
        {
            MetricType = metricType;
            TargetValue = targetValue;
        }
    }
}
