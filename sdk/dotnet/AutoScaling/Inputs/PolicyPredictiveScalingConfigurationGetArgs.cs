// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Inputs
{

    public sealed class PolicyPredictiveScalingConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Defines the behavior that should be applied if the forecast capacity approaches or exceeds the maximum capacity of the Auto Scaling group. Valid values are `HonorMaxCapacity` or `IncreaseMaxCapacity`. Default is `HonorMaxCapacity`.
        /// </summary>
        [Input("maxCapacityBreachBehavior")]
        public Input<string>? MaxCapacityBreachBehavior { get; set; }

        /// <summary>
        /// Size of the capacity buffer to use when the forecast capacity is close to or exceeds the maximum capacity. Valid range is `0` to `100`. If set to `0`, Amazon EC2 Auto Scaling may scale capacity higher than the maximum capacity to equal but not exceed forecast capacity.
        /// </summary>
        [Input("maxCapacityBuffer")]
        public Input<string>? MaxCapacityBuffer { get; set; }

        /// <summary>
        /// This structure includes the metrics and target utilization to use for predictive scaling.
        /// </summary>
        [Input("metricSpecification", required: true)]
        public Input<Inputs.PolicyPredictiveScalingConfigurationMetricSpecificationGetArgs> MetricSpecification { get; set; } = null!;

        /// <summary>
        /// Predictive scaling mode. Valid values are `ForecastAndScale` and `ForecastOnly`. Default is `ForecastOnly`.
        /// </summary>
        [Input("mode")]
        public Input<string>? Mode { get; set; }

        /// <summary>
        /// Amount of time, in seconds, by which the instance launch time can be advanced. Minimum is `0`.
        /// </summary>
        [Input("schedulingBufferTime")]
        public Input<string>? SchedulingBufferTime { get; set; }

        public PolicyPredictiveScalingConfigurationGetArgs()
        {
        }
        public static new PolicyPredictiveScalingConfigurationGetArgs Empty => new PolicyPredictiveScalingConfigurationGetArgs();
    }
}
