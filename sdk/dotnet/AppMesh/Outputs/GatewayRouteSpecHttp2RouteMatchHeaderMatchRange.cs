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
    public sealed class GatewayRouteSpecHttp2RouteMatchHeaderMatchRange
    {
        /// <summary>
        /// End of the range.
        /// </summary>
        public readonly int End;
        /// <summary>
        /// Start of the range.
        /// </summary>
        public readonly int Start;

        [OutputConstructor]
        private GatewayRouteSpecHttp2RouteMatchHeaderMatchRange(
            int end,

            int start)
        {
            End = end;
            Start = start;
        }
    }
}
