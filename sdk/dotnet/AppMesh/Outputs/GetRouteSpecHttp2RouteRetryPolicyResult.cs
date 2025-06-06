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
    public sealed class GetRouteSpecHttp2RouteRetryPolicyResult
    {
        public readonly ImmutableArray<string> HttpRetryEvents;
        public readonly int MaxRetries;
        public readonly ImmutableArray<Outputs.GetRouteSpecHttp2RouteRetryPolicyPerRetryTimeoutResult> PerRetryTimeouts;
        public readonly ImmutableArray<string> TcpRetryEvents;

        [OutputConstructor]
        private GetRouteSpecHttp2RouteRetryPolicyResult(
            ImmutableArray<string> httpRetryEvents,

            int maxRetries,

            ImmutableArray<Outputs.GetRouteSpecHttp2RouteRetryPolicyPerRetryTimeoutResult> perRetryTimeouts,

            ImmutableArray<string> tcpRetryEvents)
        {
            HttpRetryEvents = httpRetryEvents;
            MaxRetries = maxRetries;
            PerRetryTimeouts = perRetryTimeouts;
            TcpRetryEvents = tcpRetryEvents;
        }
    }
}
