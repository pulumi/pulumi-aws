// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Outputs
{

    [OutputType]
    public sealed class GatewayRouteSpecHttp2RouteMatch
    {
        /// <summary>
        /// Client request headers to match on.
        /// </summary>
        public readonly ImmutableArray<Outputs.GatewayRouteSpecHttp2RouteMatchHeader> Headers;
        /// <summary>
        /// Host name to match on.
        /// </summary>
        public readonly Outputs.GatewayRouteSpecHttp2RouteMatchHostname? Hostname;
        /// <summary>
        /// Client request path to match on.
        /// </summary>
        public readonly Outputs.GatewayRouteSpecHttp2RouteMatchPath? Path;
        /// <summary>
        /// The port number to match from the request.
        /// </summary>
        public readonly int? Port;
        /// <summary>
        /// Header value sent by the client must begin with the specified characters.
        /// </summary>
        public readonly string? Prefix;
        /// <summary>
        /// Client request query parameters to match on.
        /// </summary>
        public readonly ImmutableArray<Outputs.GatewayRouteSpecHttp2RouteMatchQueryParameter> QueryParameters;

        [OutputConstructor]
        private GatewayRouteSpecHttp2RouteMatch(
            ImmutableArray<Outputs.GatewayRouteSpecHttp2RouteMatchHeader> headers,

            Outputs.GatewayRouteSpecHttp2RouteMatchHostname? hostname,

            Outputs.GatewayRouteSpecHttp2RouteMatchPath? path,

            int? port,

            string? prefix,

            ImmutableArray<Outputs.GatewayRouteSpecHttp2RouteMatchQueryParameter> queryParameters)
        {
            Headers = headers;
            Hostname = hostname;
            Path = path;
            Port = port;
            Prefix = prefix;
            QueryParameters = queryParameters;
        }
    }
}
