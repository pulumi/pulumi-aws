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
    public sealed class RouteSpecHttpRouteMatchHeaderMatch
    {
        /// <summary>
        /// Header value sent by the client must match the specified value exactly.
        /// </summary>
        public readonly string? Exact;
        /// <summary>
        /// Header value sent by the client must begin with the specified characters.
        /// </summary>
        public readonly string? Prefix;
        /// <summary>
        /// Object that specifies the range of numbers that the header value sent by the client must be included in.
        /// </summary>
        public readonly Outputs.RouteSpecHttpRouteMatchHeaderMatchRange? Range;
        /// <summary>
        /// Header value sent by the client must include the specified characters.
        /// </summary>
        public readonly string? Regex;
        /// <summary>
        /// Header value sent by the client must end with the specified characters.
        /// </summary>
        public readonly string? Suffix;

        [OutputConstructor]
        private RouteSpecHttpRouteMatchHeaderMatch(
            string? exact,

            string? prefix,

            Outputs.RouteSpecHttpRouteMatchHeaderMatchRange? range,

            string? regex,

            string? suffix)
        {
            Exact = exact;
            Prefix = prefix;
            Range = range;
            Regex = regex;
            Suffix = suffix;
        }
    }
}
