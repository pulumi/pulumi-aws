// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class EndpointDeploymentConfigBlueGreenUpdatePolicyTrafficRoutingConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Batch size for the first step to turn on traffic on the new endpoint fleet. Value must be less than or equal to 50% of the variant's total instance count. See Canary Size.
        /// </summary>
        [Input("canarySize")]
        public Input<Inputs.EndpointDeploymentConfigBlueGreenUpdatePolicyTrafficRoutingConfigurationCanarySizeGetArgs>? CanarySize { get; set; }

        /// <summary>
        /// Batch size for each step to turn on traffic on the new endpoint fleet. Value must be 10-50% of the variant's total instance count. See Linear Step Size.
        /// </summary>
        [Input("linearStepSize")]
        public Input<Inputs.EndpointDeploymentConfigBlueGreenUpdatePolicyTrafficRoutingConfigurationLinearStepSizeGetArgs>? LinearStepSize { get; set; }

        /// <summary>
        /// Traffic routing strategy type. Valid values are: `ALL_AT_ONCE`, `CANARY`, and `LINEAR`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        /// <summary>
        /// The waiting time (in seconds) between incremental steps to turn on traffic on the new endpoint fleet. Valid values are between `0` and `3600`.
        /// </summary>
        [Input("waitIntervalInSeconds", required: true)]
        public Input<int> WaitIntervalInSeconds { get; set; } = null!;

        public EndpointDeploymentConfigBlueGreenUpdatePolicyTrafficRoutingConfigurationGetArgs()
        {
        }
        public static new EndpointDeploymentConfigBlueGreenUpdatePolicyTrafficRoutingConfigurationGetArgs Empty => new EndpointDeploymentConfigBlueGreenUpdatePolicyTrafficRoutingConfigurationGetArgs();
    }
}
