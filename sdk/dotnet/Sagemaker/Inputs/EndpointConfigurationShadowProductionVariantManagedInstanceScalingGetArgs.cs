// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class EndpointConfigurationShadowProductionVariantManagedInstanceScalingGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The maximum number of instances that the endpoint can provision when it scales up to accommodate an increase in traffic.
        /// </summary>
        [Input("maxInstanceCount")]
        public Input<int>? MaxInstanceCount { get; set; }

        /// <summary>
        /// The minimum number of instances that the endpoint must retain when it scales down to accommodate a decrease in traffic.
        /// </summary>
        [Input("minInstanceCount")]
        public Input<int>? MinInstanceCount { get; set; }

        /// <summary>
        /// Indicates whether managed instance scaling is enabled. Valid values are `ENABLED` and `DISABLED`.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        public EndpointConfigurationShadowProductionVariantManagedInstanceScalingGetArgs()
        {
        }
        public static new EndpointConfigurationShadowProductionVariantManagedInstanceScalingGetArgs Empty => new EndpointConfigurationShadowProductionVariantManagedInstanceScalingGetArgs();
    }
}
