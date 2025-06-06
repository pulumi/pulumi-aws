// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Eks.Outputs
{

    [OutputType]
    public sealed class GetClusterRemoteNetworkConfigResult
    {
        /// <summary>
        /// The networks that can contain hybrid nodes.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetClusterRemoteNetworkConfigRemoteNodeNetworkResult> RemoteNodeNetworks;
        /// <summary>
        /// The networks that can contain pods that run Kubernetes webhooks on hybrid nodes.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetClusterRemoteNetworkConfigRemotePodNetworkResult> RemotePodNetworks;

        [OutputConstructor]
        private GetClusterRemoteNetworkConfigResult(
            ImmutableArray<Outputs.GetClusterRemoteNetworkConfigRemoteNodeNetworkResult> remoteNodeNetworks,

            ImmutableArray<Outputs.GetClusterRemoteNetworkConfigRemotePodNetworkResult> remotePodNetworks)
        {
            RemoteNodeNetworks = remoteNodeNetworks;
            RemotePodNetworks = remotePodNetworks;
        }
    }
}
