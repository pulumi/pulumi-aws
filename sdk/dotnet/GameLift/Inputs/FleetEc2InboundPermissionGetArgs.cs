// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GameLift.Inputs
{

    public sealed class FleetEc2InboundPermissionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Starting value for a range of allowed port numbers.
        /// </summary>
        [Input("fromPort", required: true)]
        public Input<int> FromPort { get; set; } = null!;

        /// <summary>
        /// Range of allowed IP addresses expressed in CIDR notationE.g., `000.000.000.000/[subnet mask]` or `0.0.0.0/[subnet mask]`.
        /// </summary>
        [Input("ipRange", required: true)]
        public Input<string> IpRange { get; set; } = null!;

        /// <summary>
        /// Network communication protocol used by the fleetE.g., `TCP` or `UDP`
        /// </summary>
        [Input("protocol", required: true)]
        public Input<string> Protocol { get; set; } = null!;

        /// <summary>
        /// Ending value for a range of allowed port numbers. Port numbers are end-inclusive. This value must be higher than `from_port`.
        /// </summary>
        [Input("toPort", required: true)]
        public Input<int> ToPort { get; set; } = null!;

        public FleetEc2InboundPermissionGetArgs()
        {
        }
        public static new FleetEc2InboundPermissionGetArgs Empty => new FleetEc2InboundPermissionGetArgs();
    }
}
