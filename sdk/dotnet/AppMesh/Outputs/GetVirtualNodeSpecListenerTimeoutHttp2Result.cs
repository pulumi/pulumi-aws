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
    public sealed class GetVirtualNodeSpecListenerTimeoutHttp2Result
    {
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerTimeoutHttp2IdleResult> Idles;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerTimeoutHttp2PerRequestResult> PerRequests;

        [OutputConstructor]
        private GetVirtualNodeSpecListenerTimeoutHttp2Result(
            ImmutableArray<Outputs.GetVirtualNodeSpecListenerTimeoutHttp2IdleResult> idles,

            ImmutableArray<Outputs.GetVirtualNodeSpecListenerTimeoutHttp2PerRequestResult> perRequests)
        {
            Idles = idles;
            PerRequests = perRequests;
        }
    }
}
