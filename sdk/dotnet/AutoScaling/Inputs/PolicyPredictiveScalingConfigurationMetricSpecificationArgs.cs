// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Inputs
{

    public sealed class PolicyPredictiveScalingConfigurationMetricSpecificationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Customized capacity metric specification. The field is only valid when you use `customized_load_metric_specification`
        /// </summary>
        [Input("customizedCapacityMetricSpecification")]
        public Input<Inputs.PolicyPredictiveScalingConfigurationMetricSpecificationCustomizedCapacityMetricSpecificationArgs>? CustomizedCapacityMetricSpecification { get; set; }

        /// <summary>
        /// Customized load metric specification.
        /// </summary>
        [Input("customizedLoadMetricSpecification")]
        public Input<Inputs.PolicyPredictiveScalingConfigurationMetricSpecificationCustomizedLoadMetricSpecificationArgs>? CustomizedLoadMetricSpecification { get; set; }

        /// <summary>
        /// Customized scaling metric specification.
        /// </summary>
        [Input("customizedScalingMetricSpecification")]
        public Input<Inputs.PolicyPredictiveScalingConfigurationMetricSpecificationCustomizedScalingMetricSpecificationArgs>? CustomizedScalingMetricSpecification { get; set; }

        /// <summary>
        /// Predefined load metric specification.
        /// </summary>
        [Input("predefinedLoadMetricSpecification")]
        public Input<Inputs.PolicyPredictiveScalingConfigurationMetricSpecificationPredefinedLoadMetricSpecificationArgs>? PredefinedLoadMetricSpecification { get; set; }

        /// <summary>
        /// Metric pair specification from which Amazon EC2 Auto Scaling determines the appropriate scaling metric and load metric to use.
        /// </summary>
        [Input("predefinedMetricPairSpecification")]
        public Input<Inputs.PolicyPredictiveScalingConfigurationMetricSpecificationPredefinedMetricPairSpecificationArgs>? PredefinedMetricPairSpecification { get; set; }

        /// <summary>
        /// Predefined scaling metric specification.
        /// </summary>
        [Input("predefinedScalingMetricSpecification")]
        public Input<Inputs.PolicyPredictiveScalingConfigurationMetricSpecificationPredefinedScalingMetricSpecificationArgs>? PredefinedScalingMetricSpecification { get; set; }

        /// <summary>
        /// Target value for the metric.
        /// </summary>
        [Input("targetValue", required: true)]
        public Input<double> TargetValue { get; set; } = null!;

        public PolicyPredictiveScalingConfigurationMetricSpecificationArgs()
        {
        }
        public static new PolicyPredictiveScalingConfigurationMetricSpecificationArgs Empty => new PolicyPredictiveScalingConfigurationMetricSpecificationArgs();
    }
}
