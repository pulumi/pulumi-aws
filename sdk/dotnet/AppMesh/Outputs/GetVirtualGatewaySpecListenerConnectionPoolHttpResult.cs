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
    public sealed class GetVirtualGatewaySpecListenerConnectionPoolHttpResult
    {
        public readonly int MaxConnections;
        public readonly int MaxPendingRequests;

        [OutputConstructor]
        private GetVirtualGatewaySpecListenerConnectionPoolHttpResult(
            int maxConnections,

            int maxPendingRequests)
        {
            MaxConnections = maxConnections;
            MaxPendingRequests = maxPendingRequests;
        }
    }
}
