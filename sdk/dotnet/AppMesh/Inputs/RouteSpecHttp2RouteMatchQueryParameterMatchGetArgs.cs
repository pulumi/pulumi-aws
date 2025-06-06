// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class RouteSpecHttp2RouteMatchQueryParameterMatchGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The exact query parameter to match on.
        /// </summary>
        [Input("exact")]
        public Input<string>? Exact { get; set; }

        public RouteSpecHttp2RouteMatchQueryParameterMatchGetArgs()
        {
        }
        public static new RouteSpecHttp2RouteMatchQueryParameterMatchGetArgs Empty => new RouteSpecHttp2RouteMatchQueryParameterMatchGetArgs();
    }
}
