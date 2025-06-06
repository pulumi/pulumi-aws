// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB.Inputs
{

    public sealed class LoadBalancerSubnetMappingGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Allocation ID of the Elastic IP address for an internet-facing load balancer.
        /// </summary>
        [Input("allocationId")]
        public Input<string>? AllocationId { get; set; }

        /// <summary>
        /// IPv6 address. You associate IPv6 CIDR blocks with your VPC and choose the subnets where you launch both internet-facing and internal Application Load Balancers or Network Load Balancers.
        /// </summary>
        [Input("ipv6Address")]
        public Input<string>? Ipv6Address { get; set; }

        [Input("outpostId")]
        public Input<string>? OutpostId { get; set; }

        /// <summary>
        /// Private IPv4 address for an internal load balancer.
        /// </summary>
        [Input("privateIpv4Address")]
        public Input<string>? PrivateIpv4Address { get; set; }

        /// <summary>
        /// ID of the subnet of which to attach to the load balancer. You can specify only one subnet per Availability Zone.
        /// </summary>
        [Input("subnetId", required: true)]
        public Input<string> SubnetId { get; set; } = null!;

        public LoadBalancerSubnetMappingGetArgs()
        {
        }
        public static new LoadBalancerSubnetMappingGetArgs Empty => new LoadBalancerSubnetMappingGetArgs();
    }
}
