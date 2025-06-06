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
    public sealed class GetRouteSpecHttp2RouteMatchQueryParameterResult
    {
        public readonly ImmutableArray<Outputs.GetRouteSpecHttp2RouteMatchQueryParameterMatchResult> Matches;
        /// <summary>
        /// Name of the route.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private GetRouteSpecHttp2RouteMatchQueryParameterResult(
            ImmutableArray<Outputs.GetRouteSpecHttp2RouteMatchQueryParameterMatchResult> matches,

            string name)
        {
            Matches = matches;
            Name = name;
        }
    }
}
