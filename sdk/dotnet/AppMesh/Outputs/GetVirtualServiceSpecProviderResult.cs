// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Outputs
{

    [OutputType]
    public sealed class GetVirtualServiceSpecProviderResult
    {
        public readonly ImmutableArray<Outputs.GetVirtualServiceSpecProviderVirtualNodeResult> VirtualNodes;
        public readonly ImmutableArray<Outputs.GetVirtualServiceSpecProviderVirtualRouterResult> VirtualRouters;

        [OutputConstructor]
        private GetVirtualServiceSpecProviderResult(
            ImmutableArray<Outputs.GetVirtualServiceSpecProviderVirtualNodeResult> virtualNodes,

            ImmutableArray<Outputs.GetVirtualServiceSpecProviderVirtualRouterResult> virtualRouters)
        {
            VirtualNodes = virtualNodes;
            VirtualRouters = virtualRouters;
        }
    }
}
