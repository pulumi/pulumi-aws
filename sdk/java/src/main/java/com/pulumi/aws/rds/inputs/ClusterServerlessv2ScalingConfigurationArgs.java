// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Double;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterServerlessv2ScalingConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClusterServerlessv2ScalingConfigurationArgs Empty = new ClusterServerlessv2ScalingConfigurationArgs();

    /**
     * Maximum capacity for an Aurora DB cluster in `provisioned` DB engine mode. The maximum capacity must be greater than or equal to the minimum capacity. Valid capacity values are in a range of `0` up to `256` in steps of `0.5`.
     * 
     */
    @Import(name="maxCapacity", required=true)
    private Output<Double> maxCapacity;

    /**
     * @return Maximum capacity for an Aurora DB cluster in `provisioned` DB engine mode. The maximum capacity must be greater than or equal to the minimum capacity. Valid capacity values are in a range of `0` up to `256` in steps of `0.5`.
     * 
     */
    public Output<Double> maxCapacity() {
        return this.maxCapacity;
    }

    /**
     * Minimum capacity for an Aurora DB cluster in `provisioned` DB engine mode. The minimum capacity must be lesser than or equal to the maximum capacity. Valid capacity values are in a range of `0` up to `256` in steps of `0.5`.
     * 
     */
    @Import(name="minCapacity", required=true)
    private Output<Double> minCapacity;

    /**
     * @return Minimum capacity for an Aurora DB cluster in `provisioned` DB engine mode. The minimum capacity must be lesser than or equal to the maximum capacity. Valid capacity values are in a range of `0` up to `256` in steps of `0.5`.
     * 
     */
    public Output<Double> minCapacity() {
        return this.minCapacity;
    }

    /**
     * Time, in seconds, before an Aurora DB cluster in `provisioned` DB engine mode is paused. Valid values are `300` through `86400`.
     * 
     */
    @Import(name="secondsUntilAutoPause")
    private @Nullable Output<Integer> secondsUntilAutoPause;

    /**
     * @return Time, in seconds, before an Aurora DB cluster in `provisioned` DB engine mode is paused. Valid values are `300` through `86400`.
     * 
     */
    public Optional<Output<Integer>> secondsUntilAutoPause() {
        return Optional.ofNullable(this.secondsUntilAutoPause);
    }

    private ClusterServerlessv2ScalingConfigurationArgs() {}

    private ClusterServerlessv2ScalingConfigurationArgs(ClusterServerlessv2ScalingConfigurationArgs $) {
        this.maxCapacity = $.maxCapacity;
        this.minCapacity = $.minCapacity;
        this.secondsUntilAutoPause = $.secondsUntilAutoPause;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterServerlessv2ScalingConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterServerlessv2ScalingConfigurationArgs $;

        public Builder() {
            $ = new ClusterServerlessv2ScalingConfigurationArgs();
        }

        public Builder(ClusterServerlessv2ScalingConfigurationArgs defaults) {
            $ = new ClusterServerlessv2ScalingConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param maxCapacity Maximum capacity for an Aurora DB cluster in `provisioned` DB engine mode. The maximum capacity must be greater than or equal to the minimum capacity. Valid capacity values are in a range of `0` up to `256` in steps of `0.5`.
         * 
         * @return builder
         * 
         */
        public Builder maxCapacity(Output<Double> maxCapacity) {
            $.maxCapacity = maxCapacity;
            return this;
        }

        /**
         * @param maxCapacity Maximum capacity for an Aurora DB cluster in `provisioned` DB engine mode. The maximum capacity must be greater than or equal to the minimum capacity. Valid capacity values are in a range of `0` up to `256` in steps of `0.5`.
         * 
         * @return builder
         * 
         */
        public Builder maxCapacity(Double maxCapacity) {
            return maxCapacity(Output.of(maxCapacity));
        }

        /**
         * @param minCapacity Minimum capacity for an Aurora DB cluster in `provisioned` DB engine mode. The minimum capacity must be lesser than or equal to the maximum capacity. Valid capacity values are in a range of `0` up to `256` in steps of `0.5`.
         * 
         * @return builder
         * 
         */
        public Builder minCapacity(Output<Double> minCapacity) {
            $.minCapacity = minCapacity;
            return this;
        }

        /**
         * @param minCapacity Minimum capacity for an Aurora DB cluster in `provisioned` DB engine mode. The minimum capacity must be lesser than or equal to the maximum capacity. Valid capacity values are in a range of `0` up to `256` in steps of `0.5`.
         * 
         * @return builder
         * 
         */
        public Builder minCapacity(Double minCapacity) {
            return minCapacity(Output.of(minCapacity));
        }

        /**
         * @param secondsUntilAutoPause Time, in seconds, before an Aurora DB cluster in `provisioned` DB engine mode is paused. Valid values are `300` through `86400`.
         * 
         * @return builder
         * 
         */
        public Builder secondsUntilAutoPause(@Nullable Output<Integer> secondsUntilAutoPause) {
            $.secondsUntilAutoPause = secondsUntilAutoPause;
            return this;
        }

        /**
         * @param secondsUntilAutoPause Time, in seconds, before an Aurora DB cluster in `provisioned` DB engine mode is paused. Valid values are `300` through `86400`.
         * 
         * @return builder
         * 
         */
        public Builder secondsUntilAutoPause(Integer secondsUntilAutoPause) {
            return secondsUntilAutoPause(Output.of(secondsUntilAutoPause));
        }

        public ClusterServerlessv2ScalingConfigurationArgs build() {
            if ($.maxCapacity == null) {
                throw new MissingRequiredPropertyException("ClusterServerlessv2ScalingConfigurationArgs", "maxCapacity");
            }
            if ($.minCapacity == null) {
                throw new MissingRequiredPropertyException("ClusterServerlessv2ScalingConfigurationArgs", "minCapacity");
            }
            return $;
        }
    }

}
