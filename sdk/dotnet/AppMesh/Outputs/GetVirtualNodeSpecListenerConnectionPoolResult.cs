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
    public sealed class GetVirtualNodeSpecListenerConnectionPoolResult
    {
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerConnectionPoolGrpcResult> Grpcs;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerConnectionPoolHttp2Result> Http2s;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerConnectionPoolHttpResult> Https;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerConnectionPoolTcpResult> Tcps;

        [OutputConstructor]
        private GetVirtualNodeSpecListenerConnectionPoolResult(
            ImmutableArray<Outputs.GetVirtualNodeSpecListenerConnectionPoolGrpcResult> grpcs,

            ImmutableArray<Outputs.GetVirtualNodeSpecListenerConnectionPoolHttp2Result> http2s,

            ImmutableArray<Outputs.GetVirtualNodeSpecListenerConnectionPoolHttpResult> https,

            ImmutableArray<Outputs.GetVirtualNodeSpecListenerConnectionPoolTcpResult> tcps)
        {
            Grpcs = grpcs;
            Http2s = http2s;
            Https = https;
            Tcps = tcps;
        }
    }
}
