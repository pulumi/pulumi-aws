// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.msk.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterPolicyState extends com.pulumi.resources.ResourceArgs {

    public static final ClusterPolicyState Empty = new ClusterPolicyState();

    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the cluster.
     * 
     */
    @Import(name="clusterArn")
    private @Nullable Output<String> clusterArn;

    /**
     * @return The Amazon Resource Name (ARN) that uniquely identifies the cluster.
     * 
     */
    public Optional<Output<String>> clusterArn() {
        return Optional.ofNullable(this.clusterArn);
    }

    @Import(name="currentVersion")
    private @Nullable Output<String> currentVersion;

    public Optional<Output<String>> currentVersion() {
        return Optional.ofNullable(this.currentVersion);
    }

    /**
     * Resource policy for cluster.
     * 
     */
    @Import(name="policy")
    private @Nullable Output<String> policy;

    /**
     * @return Resource policy for cluster.
     * 
     */
    public Optional<Output<String>> policy() {
        return Optional.ofNullable(this.policy);
    }

    private ClusterPolicyState() {}

    private ClusterPolicyState(ClusterPolicyState $) {
        this.clusterArn = $.clusterArn;
        this.currentVersion = $.currentVersion;
        this.policy = $.policy;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterPolicyState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterPolicyState $;

        public Builder() {
            $ = new ClusterPolicyState();
        }

        public Builder(ClusterPolicyState defaults) {
            $ = new ClusterPolicyState(Objects.requireNonNull(defaults));
        }

        /**
         * @param clusterArn The Amazon Resource Name (ARN) that uniquely identifies the cluster.
         * 
         * @return builder
         * 
         */
        public Builder clusterArn(@Nullable Output<String> clusterArn) {
            $.clusterArn = clusterArn;
            return this;
        }

        /**
         * @param clusterArn The Amazon Resource Name (ARN) that uniquely identifies the cluster.
         * 
         * @return builder
         * 
         */
        public Builder clusterArn(String clusterArn) {
            return clusterArn(Output.of(clusterArn));
        }

        public Builder currentVersion(@Nullable Output<String> currentVersion) {
            $.currentVersion = currentVersion;
            return this;
        }

        public Builder currentVersion(String currentVersion) {
            return currentVersion(Output.of(currentVersion));
        }

        /**
         * @param policy Resource policy for cluster.
         * 
         * @return builder
         * 
         */
        public Builder policy(@Nullable Output<String> policy) {
            $.policy = policy;
            return this;
        }

        /**
         * @param policy Resource policy for cluster.
         * 
         * @return builder
         * 
         */
        public Builder policy(String policy) {
            return policy(Output.of(policy));
        }

        public ClusterPolicyState build() {
            return $;
        }
    }

}
