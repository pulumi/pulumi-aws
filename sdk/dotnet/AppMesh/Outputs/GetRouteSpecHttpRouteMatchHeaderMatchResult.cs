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
    public sealed class GetRouteSpecHttpRouteMatchHeaderMatchResult
    {
        public readonly string Exact;
        public readonly string Prefix;
        public readonly ImmutableArray<Outputs.GetRouteSpecHttpRouteMatchHeaderMatchRangeResult> Ranges;
        public readonly string Regex;
        public readonly string Suffix;

        [OutputConstructor]
        private GetRouteSpecHttpRouteMatchHeaderMatchResult(
            string exact,

            string prefix,

            ImmutableArray<Outputs.GetRouteSpecHttpRouteMatchHeaderMatchRangeResult> ranges,

            string regex,

            string suffix)
        {
            Exact = exact;
            Prefix = prefix;
            Ranges = ranges;
            Regex = regex;
            Suffix = suffix;
        }
    }
}
