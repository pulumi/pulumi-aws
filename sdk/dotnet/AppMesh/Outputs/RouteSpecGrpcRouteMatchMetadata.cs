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
    public sealed class RouteSpecGrpcRouteMatchMetadata
    {
        /// <summary>
        /// If `true`, the match is on the opposite of the `match` criteria. Default is `false`.
        /// </summary>
        public readonly bool? Invert;
        /// <summary>
        /// Data to match from the request.
        /// </summary>
        public readonly Outputs.RouteSpecGrpcRouteMatchMetadataMatch? Match;
        /// <summary>
        /// Name of the route. Must be between 1 and 50 characters in length.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private RouteSpecGrpcRouteMatchMetadata(
            bool? invert,

            Outputs.RouteSpecGrpcRouteMatchMetadataMatch? match,

            string name)
        {
            Invert = invert;
            Match = match;
            Name = name;
        }
    }
}
