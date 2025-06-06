// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Outputs
{

    [OutputType]
    public sealed class VpcEndpointSubnetConfiguration
    {
        /// <summary>
        /// The IPv4 address to assign to the endpoint network interface in the subnet. You must provide an IPv4 address if the VPC endpoint supports IPv4.
        /// </summary>
        public readonly string? Ipv4;
        /// <summary>
        /// The IPv6 address to assign to the endpoint network interface in the subnet. You must provide an IPv6 address if the VPC endpoint supports IPv6.
        /// </summary>
        public readonly string? Ipv6;
        public readonly string? SubnetId;

        [OutputConstructor]
        private VpcEndpointSubnetConfiguration(
            string? ipv4,

            string? ipv6,

            string? subnetId)
        {
            Ipv4 = ipv4;
            Ipv6 = ipv6;
            SubnetId = subnetId;
        }
    }
}
