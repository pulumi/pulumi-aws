// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB.Outputs
{

    [OutputType]
    public sealed class TargetGroupTargetGroupHealth
    {
        /// <summary>
        /// Block to configure DNS Failover requirements. See DNS Failover below for details on attributes.
        /// </summary>
        public readonly Outputs.TargetGroupTargetGroupHealthDnsFailover? DnsFailover;
        /// <summary>
        /// Block to configure Unhealthy State Routing requirements. See Unhealthy State Routing below for details on attributes.
        /// </summary>
        public readonly Outputs.TargetGroupTargetGroupHealthUnhealthyStateRouting? UnhealthyStateRouting;

        [OutputConstructor]
        private TargetGroupTargetGroupHealth(
            Outputs.TargetGroupTargetGroupHealthDnsFailover? dnsFailover,

            Outputs.TargetGroupTargetGroupHealthUnhealthyStateRouting? unhealthyStateRouting)
        {
            DnsFailover = dnsFailover;
            UnhealthyStateRouting = unhealthyStateRouting;
        }
    }
}
