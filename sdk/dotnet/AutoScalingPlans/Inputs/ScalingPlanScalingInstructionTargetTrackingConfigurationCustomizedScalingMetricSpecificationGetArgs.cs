// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScalingPlans.Inputs
{

    public sealed class ScalingPlanScalingInstructionTargetTrackingConfigurationCustomizedScalingMetricSpecificationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("dimensions")]
        private InputMap<string>? _dimensions;

        /// <summary>
        /// Dimensions of the metric.
        /// </summary>
        public InputMap<string> Dimensions
        {
            get => _dimensions ?? (_dimensions = new InputMap<string>());
            set => _dimensions = value;
        }

        /// <summary>
        /// Name of the metric.
        /// </summary>
        [Input("metricName", required: true)]
        public Input<string> MetricName { get; set; } = null!;

        /// <summary>
        /// Namespace of the metric.
        /// </summary>
        [Input("namespace", required: true)]
        public Input<string> Namespace { get; set; } = null!;

        /// <summary>
        /// Statistic of the metric. Valid values: `Average`, `Maximum`, `Minimum`, `SampleCount`, `Sum`.
        /// </summary>
        [Input("statistic", required: true)]
        public Input<string> Statistic { get; set; } = null!;

        /// <summary>
        /// Unit of the metric.
        /// </summary>
        [Input("unit")]
        public Input<string>? Unit { get; set; }

        public ScalingPlanScalingInstructionTargetTrackingConfigurationCustomizedScalingMetricSpecificationGetArgs()
        {
        }
        public static new ScalingPlanScalingInstructionTargetTrackingConfigurationCustomizedScalingMetricSpecificationGetArgs Empty => new ScalingPlanScalingInstructionTargetTrackingConfigurationCustomizedScalingMetricSpecificationGetArgs();
    }
}
