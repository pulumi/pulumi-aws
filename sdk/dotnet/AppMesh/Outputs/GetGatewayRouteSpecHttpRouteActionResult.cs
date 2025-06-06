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
    public sealed class GetGatewayRouteSpecHttpRouteActionResult
    {
        public readonly ImmutableArray<Outputs.GetGatewayRouteSpecHttpRouteActionRewriteResult> Rewrites;
        public readonly ImmutableArray<Outputs.GetGatewayRouteSpecHttpRouteActionTargetResult> Targets;

        [OutputConstructor]
        private GetGatewayRouteSpecHttpRouteActionResult(
            ImmutableArray<Outputs.GetGatewayRouteSpecHttpRouteActionRewriteResult> rewrites,

            ImmutableArray<Outputs.GetGatewayRouteSpecHttpRouteActionTargetResult> targets)
        {
            Rewrites = rewrites;
            Targets = targets;
        }
    }
}
