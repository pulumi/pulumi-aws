// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.emr.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterPlacementGroupConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClusterPlacementGroupConfigArgs Empty = new ClusterPlacementGroupConfigArgs();

    /**
     * Role of the instance in the cluster. Valid Values: `MASTER`, `CORE`, `TASK`.
     * 
     */
    @Import(name="instanceRole", required=true)
    private Output<String> instanceRole;

    /**
     * @return Role of the instance in the cluster. Valid Values: `MASTER`, `CORE`, `TASK`.
     * 
     */
    public Output<String> instanceRole() {
        return this.instanceRole;
    }

    /**
     * EC2 Placement Group strategy associated with instance role. Valid Values: `SPREAD`, `PARTITION`, `CLUSTER`, `NONE`.
     * 
     */
    @Import(name="placementStrategy")
    private @Nullable Output<String> placementStrategy;

    /**
     * @return EC2 Placement Group strategy associated with instance role. Valid Values: `SPREAD`, `PARTITION`, `CLUSTER`, `NONE`.
     * 
     */
    public Optional<Output<String>> placementStrategy() {
        return Optional.ofNullable(this.placementStrategy);
    }

    private ClusterPlacementGroupConfigArgs() {}

    private ClusterPlacementGroupConfigArgs(ClusterPlacementGroupConfigArgs $) {
        this.instanceRole = $.instanceRole;
        this.placementStrategy = $.placementStrategy;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterPlacementGroupConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterPlacementGroupConfigArgs $;

        public Builder() {
            $ = new ClusterPlacementGroupConfigArgs();
        }

        public Builder(ClusterPlacementGroupConfigArgs defaults) {
            $ = new ClusterPlacementGroupConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param instanceRole Role of the instance in the cluster. Valid Values: `MASTER`, `CORE`, `TASK`.
         * 
         * @return builder
         * 
         */
        public Builder instanceRole(Output<String> instanceRole) {
            $.instanceRole = instanceRole;
            return this;
        }

        /**
         * @param instanceRole Role of the instance in the cluster. Valid Values: `MASTER`, `CORE`, `TASK`.
         * 
         * @return builder
         * 
         */
        public Builder instanceRole(String instanceRole) {
            return instanceRole(Output.of(instanceRole));
        }

        /**
         * @param placementStrategy EC2 Placement Group strategy associated with instance role. Valid Values: `SPREAD`, `PARTITION`, `CLUSTER`, `NONE`.
         * 
         * @return builder
         * 
         */
        public Builder placementStrategy(@Nullable Output<String> placementStrategy) {
            $.placementStrategy = placementStrategy;
            return this;
        }

        /**
         * @param placementStrategy EC2 Placement Group strategy associated with instance role. Valid Values: `SPREAD`, `PARTITION`, `CLUSTER`, `NONE`.
         * 
         * @return builder
         * 
         */
        public Builder placementStrategy(String placementStrategy) {
            return placementStrategy(Output.of(placementStrategy));
        }

        public ClusterPlacementGroupConfigArgs build() {
            $.instanceRole = Objects.requireNonNull($.instanceRole, "expected parameter 'instanceRole' to be non-null");
            return $;
        }
    }

}