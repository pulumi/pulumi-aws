// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class SpotFleetRequestLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCountArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Maximum.
        /// </summary>
        [Input("max")]
        public Input<int>? Max { get; set; }

        /// <summary>
        /// Minimum.
        /// </summary>
        [Input("min")]
        public Input<int>? Min { get; set; }

        public SpotFleetRequestLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCountArgs()
        {
        }
        public static new SpotFleetRequestLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCountArgs Empty => new SpotFleetRequestLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCountArgs();
    }
}
