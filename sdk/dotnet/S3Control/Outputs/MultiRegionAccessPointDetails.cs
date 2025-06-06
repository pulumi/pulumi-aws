// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3Control.Outputs
{

    [OutputType]
    public sealed class MultiRegionAccessPointDetails
    {
        public readonly string Name;
        public readonly Outputs.MultiRegionAccessPointDetailsPublicAccessBlock? PublicAccessBlock;
        public readonly ImmutableArray<Outputs.MultiRegionAccessPointDetailsRegion> Regions;

        [OutputConstructor]
        private MultiRegionAccessPointDetails(
            string name,

            Outputs.MultiRegionAccessPointDetailsPublicAccessBlock? publicAccessBlock,

            ImmutableArray<Outputs.MultiRegionAccessPointDetailsRegion> regions)
        {
            Name = name;
            PublicAccessBlock = publicAccessBlock;
            Regions = regions;
        }
    }
}
