// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class RouteSpecHttp2RouteMatchGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("headers")]
        private InputList<Inputs.RouteSpecHttp2RouteMatchHeaderGetArgs>? _headers;

        /// <summary>
        /// Client request headers to match on.
        /// </summary>
        public InputList<Inputs.RouteSpecHttp2RouteMatchHeaderGetArgs> Headers
        {
            get => _headers ?? (_headers = new InputList<Inputs.RouteSpecHttp2RouteMatchHeaderGetArgs>());
            set => _headers = value;
        }

        /// <summary>
        /// Client request header method to match on. Valid values: `GET`, `HEAD`, `POST`, `PUT`, `DELETE`, `CONNECT`, `OPTIONS`, `TRACE`, `PATCH`.
        /// </summary>
        [Input("method")]
        public Input<string>? Method { get; set; }

        /// <summary>
        /// Client request path to match on.
        /// </summary>
        [Input("path")]
        public Input<Inputs.RouteSpecHttp2RouteMatchPathGetArgs>? Path { get; set; }

        /// <summary>
        /// The port number to match from the request.
        /// </summary>
        [Input("port")]
        public Input<int>? Port { get; set; }

        /// <summary>
        /// Path with which to match requests.
        /// This parameter must always start with /, which by itself matches all requests to the virtual router service name.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        [Input("queryParameters")]
        private InputList<Inputs.RouteSpecHttp2RouteMatchQueryParameterGetArgs>? _queryParameters;

        /// <summary>
        /// Client request query parameters to match on.
        /// </summary>
        public InputList<Inputs.RouteSpecHttp2RouteMatchQueryParameterGetArgs> QueryParameters
        {
            get => _queryParameters ?? (_queryParameters = new InputList<Inputs.RouteSpecHttp2RouteMatchQueryParameterGetArgs>());
            set => _queryParameters = value;
        }

        /// <summary>
        /// Client request header scheme to match on. Valid values: `http`, `https`.
        /// </summary>
        [Input("scheme")]
        public Input<string>? Scheme { get; set; }

        public RouteSpecHttp2RouteMatchGetArgs()
        {
        }
        public static new RouteSpecHttp2RouteMatchGetArgs Empty => new RouteSpecHttp2RouteMatchGetArgs();
    }
}
