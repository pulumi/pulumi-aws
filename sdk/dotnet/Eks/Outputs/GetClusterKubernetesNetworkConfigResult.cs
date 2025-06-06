// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Eks.Outputs
{

    [OutputType]
    public sealed class GetClusterKubernetesNetworkConfigResult
    {
        /// <summary>
        /// Contains Elastic Load Balancing configuration for EKS Auto Mode enabled cluster.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetClusterKubernetesNetworkConfigElasticLoadBalancingResult> ElasticLoadBalancings;
        /// <summary>
        /// `ipv4` or `ipv6`.
        /// </summary>
        public readonly string IpFamily;
        /// <summary>
        /// The CIDR block to assign Kubernetes pod and service IP addresses from if `ipv4` was specified when the cluster was created.
        /// </summary>
        public readonly string ServiceIpv4Cidr;
        /// <summary>
        /// The CIDR block to assign Kubernetes pod and service IP addresses from if `ipv6` was specified when the cluster was created. Kubernetes assigns service addresses from the unique local address range (fc00::/7) because you can't specify a custom IPv6 CIDR block when you create the cluster.
        /// </summary>
        public readonly string ServiceIpv6Cidr;

        [OutputConstructor]
        private GetClusterKubernetesNetworkConfigResult(
            ImmutableArray<Outputs.GetClusterKubernetesNetworkConfigElasticLoadBalancingResult> elasticLoadBalancings,

            string ipFamily,

            string serviceIpv4Cidr,

            string serviceIpv6Cidr)
        {
            ElasticLoadBalancings = elasticLoadBalancings;
            IpFamily = ipFamily;
            ServiceIpv4Cidr = serviceIpv4Cidr;
            ServiceIpv6Cidr = serviceIpv6Cidr;
        }
    }
}
