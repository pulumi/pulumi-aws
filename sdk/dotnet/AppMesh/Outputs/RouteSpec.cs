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
    public sealed class RouteSpec
    {
        /// <summary>
        /// GRPC routing information for the route.
        /// </summary>
        public readonly Outputs.RouteSpecGrpcRoute? GrpcRoute;
        /// <summary>
        /// HTTP/2 routing information for the route.
        /// </summary>
        public readonly Outputs.RouteSpecHttp2Route? Http2Route;
        /// <summary>
        /// HTTP routing information for the route.
        /// </summary>
        public readonly Outputs.RouteSpecHttpRoute? HttpRoute;
        /// <summary>
        /// Priority for the route, between `0` and `1000`.
        /// Routes are matched based on the specified value, where `0` is the highest priority.
        /// </summary>
        public readonly int? Priority;
        /// <summary>
        /// TCP routing information for the route.
        /// </summary>
        public readonly Outputs.RouteSpecTcpRoute? TcpRoute;

        [OutputConstructor]
        private RouteSpec(
            Outputs.RouteSpecGrpcRoute? grpcRoute,

            Outputs.RouteSpecHttp2Route? http2Route,

            Outputs.RouteSpecHttpRoute? httpRoute,

            int? priority,

            Outputs.RouteSpecTcpRoute? tcpRoute)
        {
            GrpcRoute = grpcRoute;
            Http2Route = http2Route;
            HttpRoute = httpRoute;
            Priority = priority;
            TcpRoute = tcpRoute;
        }
    }
}
