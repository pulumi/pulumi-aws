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
    public sealed class GetRouteSpecHttpRouteMatchPathResult
    {
        public readonly string Exact;
        public readonly string Regex;

        [OutputConstructor]
        private GetRouteSpecHttpRouteMatchPathResult(
            string exact,

            string regex)
        {
            Exact = exact;
            Regex = regex;
        }
    }
}
