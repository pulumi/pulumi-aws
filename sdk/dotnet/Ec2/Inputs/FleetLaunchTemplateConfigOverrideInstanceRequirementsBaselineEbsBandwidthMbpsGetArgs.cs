// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class FleetLaunchTemplateConfigOverrideInstanceRequirementsBaselineEbsBandwidthMbpsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The maximum baseline bandwidth, in Mbps. To specify no maximum limit, omit this parameter..
        /// </summary>
        [Input("max")]
        public Input<int>? Max { get; set; }

        /// <summary>
        /// The minimum baseline bandwidth, in Mbps. To specify no minimum limit, omit this parameter..
        /// </summary>
        [Input("min")]
        public Input<int>? Min { get; set; }

        public FleetLaunchTemplateConfigOverrideInstanceRequirementsBaselineEbsBandwidthMbpsGetArgs()
        {
        }
        public static new FleetLaunchTemplateConfigOverrideInstanceRequirementsBaselineEbsBandwidthMbpsGetArgs Empty => new FleetLaunchTemplateConfigOverrideInstanceRequirementsBaselineEbsBandwidthMbpsGetArgs();
    }
}
