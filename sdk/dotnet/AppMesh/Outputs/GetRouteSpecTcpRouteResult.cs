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
    public sealed class GetRouteSpecTcpRouteResult
    {
        public readonly ImmutableArray<Outputs.GetRouteSpecTcpRouteActionResult> Actions;
        public readonly ImmutableArray<Outputs.GetRouteSpecTcpRouteMatchResult> Matches;
        public readonly ImmutableArray<Outputs.GetRouteSpecTcpRouteTimeoutResult> Timeouts;

        [OutputConstructor]
        private GetRouteSpecTcpRouteResult(
            ImmutableArray<Outputs.GetRouteSpecTcpRouteActionResult> actions,

            ImmutableArray<Outputs.GetRouteSpecTcpRouteMatchResult> matches,

            ImmutableArray<Outputs.GetRouteSpecTcpRouteTimeoutResult> timeouts)
        {
            Actions = actions;
            Matches = matches;
            Timeouts = timeouts;
        }
    }
}
