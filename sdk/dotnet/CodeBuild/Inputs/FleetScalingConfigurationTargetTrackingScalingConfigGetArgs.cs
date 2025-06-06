// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeBuild.Inputs
{

    public sealed class FleetScalingConfigurationTargetTrackingScalingConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Metric type to determine auto-scaling. Valid value: `FLEET_UTILIZATION_RATE`.
        /// </summary>
        [Input("metricType")]
        public Input<string>? MetricType { get; set; }

        /// <summary>
        /// Value of metricType when to start scaling.
        /// </summary>
        [Input("targetValue")]
        public Input<double>? TargetValue { get; set; }

        public FleetScalingConfigurationTargetTrackingScalingConfigGetArgs()
        {
        }
        public static new FleetScalingConfigurationTargetTrackingScalingConfigGetArgs Empty => new FleetScalingConfigurationTargetTrackingScalingConfigGetArgs();
    }
}
