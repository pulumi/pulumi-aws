// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterRemoteNetworkConfigRemoteNodeNetworksArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClusterRemoteNetworkConfigRemoteNodeNetworksArgs Empty = new ClusterRemoteNetworkConfigRemoteNodeNetworksArgs();

    /**
     * List of network CIDRs that can contain hybrid nodes.
     * 
     */
    @Import(name="cidrs")
    private @Nullable Output<List<String>> cidrs;

    /**
     * @return List of network CIDRs that can contain hybrid nodes.
     * 
     */
    public Optional<Output<List<String>>> cidrs() {
        return Optional.ofNullable(this.cidrs);
    }

    private ClusterRemoteNetworkConfigRemoteNodeNetworksArgs() {}

    private ClusterRemoteNetworkConfigRemoteNodeNetworksArgs(ClusterRemoteNetworkConfigRemoteNodeNetworksArgs $) {
        this.cidrs = $.cidrs;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterRemoteNetworkConfigRemoteNodeNetworksArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterRemoteNetworkConfigRemoteNodeNetworksArgs $;

        public Builder() {
            $ = new ClusterRemoteNetworkConfigRemoteNodeNetworksArgs();
        }

        public Builder(ClusterRemoteNetworkConfigRemoteNodeNetworksArgs defaults) {
            $ = new ClusterRemoteNetworkConfigRemoteNodeNetworksArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cidrs List of network CIDRs that can contain hybrid nodes.
         * 
         * @return builder
         * 
         */
        public Builder cidrs(@Nullable Output<List<String>> cidrs) {
            $.cidrs = cidrs;
            return this;
        }

        /**
         * @param cidrs List of network CIDRs that can contain hybrid nodes.
         * 
         * @return builder
         * 
         */
        public Builder cidrs(List<String> cidrs) {
            return cidrs(Output.of(cidrs));
        }

        /**
         * @param cidrs List of network CIDRs that can contain hybrid nodes.
         * 
         * @return builder
         * 
         */
        public Builder cidrs(String... cidrs) {
            return cidrs(List.of(cidrs));
        }

        public ClusterRemoteNetworkConfigRemoteNodeNetworksArgs build() {
            return $;
        }
    }

}
