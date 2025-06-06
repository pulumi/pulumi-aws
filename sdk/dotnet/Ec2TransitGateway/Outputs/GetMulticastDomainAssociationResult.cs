// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2TransitGateway.Outputs
{

    [OutputType]
    public sealed class GetMulticastDomainAssociationResult
    {
        /// <summary>
        /// The ID of the subnet associated with the transit gateway multicast domain.
        /// </summary>
        public readonly string SubnetId;
        /// <summary>
        /// The ID of the transit gateway attachment.
        /// </summary>
        public readonly string TransitGatewayAttachmentId;

        [OutputConstructor]
        private GetMulticastDomainAssociationResult(
            string subnetId,

            string transitGatewayAttachmentId)
        {
            SubnetId = subnetId;
            TransitGatewayAttachmentId = transitGatewayAttachmentId;
        }
    }
}
