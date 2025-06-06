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
    public sealed class VirtualNodeSpecListenerConnectionPool
    {
        /// <summary>
        /// Connection pool information for gRPC listeners.
        /// </summary>
        public readonly Outputs.VirtualNodeSpecListenerConnectionPoolGrpc? Grpc;
        /// <summary>
        /// Connection pool information for HTTP2 listeners.
        /// </summary>
        public readonly ImmutableArray<Outputs.VirtualNodeSpecListenerConnectionPoolHttp2> Http2s;
        /// <summary>
        /// Connection pool information for HTTP listeners.
        /// </summary>
        public readonly ImmutableArray<Outputs.VirtualNodeSpecListenerConnectionPoolHttp> Https;
        /// <summary>
        /// Connection pool information for TCP listeners.
        /// </summary>
        public readonly ImmutableArray<Outputs.VirtualNodeSpecListenerConnectionPoolTcp> Tcps;

        [OutputConstructor]
        private VirtualNodeSpecListenerConnectionPool(
            Outputs.VirtualNodeSpecListenerConnectionPoolGrpc? grpc,

            ImmutableArray<Outputs.VirtualNodeSpecListenerConnectionPoolHttp2> http2s,

            ImmutableArray<Outputs.VirtualNodeSpecListenerConnectionPoolHttp> https,

            ImmutableArray<Outputs.VirtualNodeSpecListenerConnectionPoolTcp> tcps)
        {
            Grpc = grpc;
            Http2s = http2s;
            Https = https;
            Tcps = tcps;
        }
    }
}
