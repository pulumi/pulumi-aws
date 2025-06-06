// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppAutoScaling.Inputs
{

    public sealed class PolicyStepScalingPolicyConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether the adjustment is an absolute number or a percentage of the current capacity. Valid values are `ChangeInCapacity`, `ExactCapacity`, and `PercentChangeInCapacity`.
        /// </summary>
        [Input("adjustmentType")]
        public Input<string>? AdjustmentType { get; set; }

        /// <summary>
        /// Amount of time, in seconds, after a scaling activity completes and before the next scaling activity can start.
        /// </summary>
        [Input("cooldown")]
        public Input<int>? Cooldown { get; set; }

        /// <summary>
        /// Aggregation type for the policy's metrics. Valid values are "Minimum", "Maximum", and "Average". Without a value, AWS will treat the aggregation type as "Average".
        /// </summary>
        [Input("metricAggregationType")]
        public Input<string>? MetricAggregationType { get; set; }

        /// <summary>
        /// Minimum number to adjust your scalable dimension as a result of a scaling activity. If the adjustment type is PercentChangeInCapacity, the scaling policy changes the scalable dimension of the scalable target by this amount.
        /// </summary>
        [Input("minAdjustmentMagnitude")]
        public Input<int>? MinAdjustmentMagnitude { get; set; }

        [Input("stepAdjustments")]
        private InputList<Inputs.PolicyStepScalingPolicyConfigurationStepAdjustmentArgs>? _stepAdjustments;

        /// <summary>
        /// Set of adjustments that manage scaling. These have the following structure:
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var ecsPolicy = new Aws.AppAutoScaling.Policy("ecs_policy", new()
        ///     {
        ///         StepScalingPolicyConfiguration = new Aws.AppAutoScaling.Inputs.PolicyStepScalingPolicyConfigurationArgs
        ///         {
        ///             StepAdjustments = new[]
        ///             {
        ///                 new Aws.AppAutoScaling.Inputs.PolicyStepScalingPolicyConfigurationStepAdjustmentArgs
        ///                 {
        ///                     MetricIntervalLowerBound = "1",
        ///                     MetricIntervalUpperBound = "2",
        ///                     ScalingAdjustment = -1,
        ///                 },
        ///                 new Aws.AppAutoScaling.Inputs.PolicyStepScalingPolicyConfigurationStepAdjustmentArgs
        ///                 {
        ///                     MetricIntervalLowerBound = "2",
        ///                     MetricIntervalUpperBound = "3",
        ///                     ScalingAdjustment = 1,
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public InputList<Inputs.PolicyStepScalingPolicyConfigurationStepAdjustmentArgs> StepAdjustments
        {
            get => _stepAdjustments ?? (_stepAdjustments = new InputList<Inputs.PolicyStepScalingPolicyConfigurationStepAdjustmentArgs>());
            set => _stepAdjustments = value;
        }

        public PolicyStepScalingPolicyConfigurationArgs()
        {
        }
        public static new PolicyStepScalingPolicyConfigurationArgs Empty => new PolicyStepScalingPolicyConfigurationArgs();
    }
}
