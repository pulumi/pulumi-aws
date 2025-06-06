// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53.Outputs
{

    [OutputType]
    public sealed class ZoneVpc
    {
        /// <summary>
        /// ID of the VPC to associate.
        /// </summary>
        public readonly string VpcId;
        /// <summary>
        /// Region of the VPC to associate. Defaults to AWS provider region.
        /// </summary>
        public readonly string? VpcRegion;

        [OutputConstructor]
        private ZoneVpc(
            string vpcId,

            string? vpcRegion)
        {
            VpcId = vpcId;
            VpcRegion = vpcRegion;
        }
    }
}
