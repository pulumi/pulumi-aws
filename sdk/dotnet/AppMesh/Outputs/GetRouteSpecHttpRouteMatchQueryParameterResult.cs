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
    public sealed class GetRouteSpecHttpRouteMatchQueryParameterResult
    {
        public readonly ImmutableArray<Outputs.GetRouteSpecHttpRouteMatchQueryParameterMatchResult> Matches;
        /// <summary>
        /// Name of the route.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private GetRouteSpecHttpRouteMatchQueryParameterResult(
            ImmutableArray<Outputs.GetRouteSpecHttpRouteMatchQueryParameterMatchResult> matches,

            string name)
        {
            Matches = matches;
            Name = name;
        }
    }
}
