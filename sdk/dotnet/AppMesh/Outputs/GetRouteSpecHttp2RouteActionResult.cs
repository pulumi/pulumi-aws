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
    public sealed class GetRouteSpecHttp2RouteActionResult
    {
        public readonly ImmutableArray<Outputs.GetRouteSpecHttp2RouteActionWeightedTargetResult> WeightedTargets;

        [OutputConstructor]
        private GetRouteSpecHttp2RouteActionResult(ImmutableArray<Outputs.GetRouteSpecHttp2RouteActionWeightedTargetResult> weightedTargets)
        {
            WeightedTargets = weightedTargets;
        }
    }
}
