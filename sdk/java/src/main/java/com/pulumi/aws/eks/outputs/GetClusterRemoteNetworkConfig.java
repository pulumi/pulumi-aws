// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.outputs;

import com.pulumi.aws.eks.outputs.GetClusterRemoteNetworkConfigRemoteNodeNetwork;
import com.pulumi.aws.eks.outputs.GetClusterRemoteNetworkConfigRemotePodNetwork;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetClusterRemoteNetworkConfig {
    /**
     * @return The networks that can contain hybrid nodes.
     * 
     */
    private List<GetClusterRemoteNetworkConfigRemoteNodeNetwork> remoteNodeNetworks;
    /**
     * @return The networks that can contain pods that run Kubernetes webhooks on hybrid nodes.
     * 
     */
    private List<GetClusterRemoteNetworkConfigRemotePodNetwork> remotePodNetworks;

    private GetClusterRemoteNetworkConfig() {}
    /**
     * @return The networks that can contain hybrid nodes.
     * 
     */
    public List<GetClusterRemoteNetworkConfigRemoteNodeNetwork> remoteNodeNetworks() {
        return this.remoteNodeNetworks;
    }
    /**
     * @return The networks that can contain pods that run Kubernetes webhooks on hybrid nodes.
     * 
     */
    public List<GetClusterRemoteNetworkConfigRemotePodNetwork> remotePodNetworks() {
        return this.remotePodNetworks;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetClusterRemoteNetworkConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetClusterRemoteNetworkConfigRemoteNodeNetwork> remoteNodeNetworks;
        private List<GetClusterRemoteNetworkConfigRemotePodNetwork> remotePodNetworks;
        public Builder() {}
        public Builder(GetClusterRemoteNetworkConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.remoteNodeNetworks = defaults.remoteNodeNetworks;
    	      this.remotePodNetworks = defaults.remotePodNetworks;
        }

        @CustomType.Setter
        public Builder remoteNodeNetworks(List<GetClusterRemoteNetworkConfigRemoteNodeNetwork> remoteNodeNetworks) {
            if (remoteNodeNetworks == null) {
              throw new MissingRequiredPropertyException("GetClusterRemoteNetworkConfig", "remoteNodeNetworks");
            }
            this.remoteNodeNetworks = remoteNodeNetworks;
            return this;
        }
        public Builder remoteNodeNetworks(GetClusterRemoteNetworkConfigRemoteNodeNetwork... remoteNodeNetworks) {
            return remoteNodeNetworks(List.of(remoteNodeNetworks));
        }
        @CustomType.Setter
        public Builder remotePodNetworks(List<GetClusterRemoteNetworkConfigRemotePodNetwork> remotePodNetworks) {
            if (remotePodNetworks == null) {
              throw new MissingRequiredPropertyException("GetClusterRemoteNetworkConfig", "remotePodNetworks");
            }
            this.remotePodNetworks = remotePodNetworks;
            return this;
        }
        public Builder remotePodNetworks(GetClusterRemoteNetworkConfigRemotePodNetwork... remotePodNetworks) {
            return remotePodNetworks(List.of(remotePodNetworks));
        }
        public GetClusterRemoteNetworkConfig build() {
            final var _resultValue = new GetClusterRemoteNetworkConfig();
            _resultValue.remoteNodeNetworks = remoteNodeNetworks;
            _resultValue.remotePodNetworks = remotePodNetworks;
            return _resultValue;
        }
    }
}
