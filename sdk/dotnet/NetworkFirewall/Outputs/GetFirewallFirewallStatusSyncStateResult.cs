// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall.Outputs
{

    [OutputType]
    public sealed class GetFirewallFirewallStatusSyncStateResult
    {
        /// <summary>
        /// Nested list describing the attachment status of the firewall's association with a single VPC subnet.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetFirewallFirewallStatusSyncStateAttachmentResult> Attachments;
        /// <summary>
        /// The Availability Zone where the subnet is configured.
        /// </summary>
        public readonly string AvailabilityZone;

        [OutputConstructor]
        private GetFirewallFirewallStatusSyncStateResult(
            ImmutableArray<Outputs.GetFirewallFirewallStatusSyncStateAttachmentResult> attachments,

            string availabilityZone)
        {
            Attachments = attachments;
            AvailabilityZone = availabilityZone;
        }
    }
}
