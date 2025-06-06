// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch.Outputs
{

    [OutputType]
    public sealed class GetDomainVpcOptionResult
    {
        /// <summary>
        /// Availability zones used by the domain.
        /// </summary>
        public readonly ImmutableArray<string> AvailabilityZones;
        /// <summary>
        /// Security groups used by the domain.
        /// </summary>
        public readonly ImmutableArray<string> SecurityGroupIds;
        /// <summary>
        /// Subnets used by the domain.
        /// </summary>
        public readonly ImmutableArray<string> SubnetIds;
        /// <summary>
        /// VPC used by the domain.
        /// </summary>
        public readonly string VpcId;

        [OutputConstructor]
        private GetDomainVpcOptionResult(
            ImmutableArray<string> availabilityZones,

            ImmutableArray<string> securityGroupIds,

            ImmutableArray<string> subnetIds,

            string vpcId)
        {
            AvailabilityZones = availabilityZones;
            SecurityGroupIds = securityGroupIds;
            SubnetIds = subnetIds;
            VpcId = vpcId;
        }
    }
}
