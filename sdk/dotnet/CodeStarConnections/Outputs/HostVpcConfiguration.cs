// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeStarConnections.Outputs
{

    [OutputType]
    public sealed class HostVpcConfiguration
    {
        /// <summary>
        /// ID of the security group or security groups associated with the Amazon VPC connected to the infrastructure where your provider type is installed.
        /// </summary>
        public readonly ImmutableArray<string> SecurityGroupIds;
        /// <summary>
        /// The ID of the subnet or subnets associated with the Amazon VPC connected to the infrastructure where your provider type is installed.
        /// </summary>
        public readonly ImmutableArray<string> SubnetIds;
        /// <summary>
        /// The value of the Transport Layer Security (TLS) certificate associated with the infrastructure where your provider type is installed.
        /// </summary>
        public readonly string? TlsCertificate;
        /// <summary>
        /// The ID of the Amazon VPC connected to the infrastructure where your provider type is installed.
        /// </summary>
        public readonly string VpcId;

        [OutputConstructor]
        private HostVpcConfiguration(
            ImmutableArray<string> securityGroupIds,

            ImmutableArray<string> subnetIds,

            string? tlsCertificate,

            string vpcId)
        {
            SecurityGroupIds = securityGroupIds;
            SubnetIds = subnetIds;
            TlsCertificate = tlsCertificate;
            VpcId = vpcId;
        }
    }
}
