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
    public sealed class RouteSpecGrpcRouteMatch
    {
        /// <summary>
        /// Data to match from the gRPC request.
        /// </summary>
        public readonly ImmutableArray<Outputs.RouteSpecGrpcRouteMatchMetadata> Metadatas;
        /// <summary>
        /// Method name to match from the request. If you specify a name, you must also specify a `service_name`.
        /// </summary>
        public readonly string? MethodName;
        /// <summary>
        /// The port number to match from the request.
        /// </summary>
        public readonly int? Port;
        public readonly string? Prefix;
        /// <summary>
        /// Fully qualified domain name for the service to match from the request.
        /// </summary>
        public readonly string? ServiceName;

        [OutputConstructor]
        private RouteSpecGrpcRouteMatch(
            ImmutableArray<Outputs.RouteSpecGrpcRouteMatchMetadata> metadatas,

            string? methodName,

            int? port,

            string? prefix,

            string? serviceName)
        {
            Metadatas = metadatas;
            MethodName = methodName;
            Port = port;
            Prefix = prefix;
            ServiceName = serviceName;
        }
    }
}
