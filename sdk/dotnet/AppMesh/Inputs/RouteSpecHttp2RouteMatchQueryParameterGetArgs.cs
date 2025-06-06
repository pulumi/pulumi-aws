// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class RouteSpecHttp2RouteMatchQueryParameterGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The query parameter to match on.
        /// </summary>
        [Input("match")]
        public Input<Inputs.RouteSpecHttp2RouteMatchQueryParameterMatchGetArgs>? Match { get; set; }

        /// <summary>
        /// Name for the query parameter that will be matched on.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        public RouteSpecHttp2RouteMatchQueryParameterGetArgs()
        {
        }
        public static new RouteSpecHttp2RouteMatchQueryParameterGetArgs Empty => new RouteSpecHttp2RouteMatchQueryParameterGetArgs();
    }
}
