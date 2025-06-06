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
    public sealed class RouteSpecHttpRouteMatchQueryParameterMatch
    {
        /// <summary>
        /// The exact query parameter to match on.
        /// </summary>
        public readonly string? Exact;

        [OutputConstructor]
        private RouteSpecHttpRouteMatchQueryParameterMatch(string? exact)
        {
            Exact = exact;
        }
    }
}
