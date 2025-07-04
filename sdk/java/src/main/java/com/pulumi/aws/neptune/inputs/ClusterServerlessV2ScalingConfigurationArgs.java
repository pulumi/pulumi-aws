// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.neptune.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Double;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterServerlessV2ScalingConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClusterServerlessV2ScalingConfigurationArgs Empty = new ClusterServerlessV2ScalingConfigurationArgs();

    /**
     * Maximum Neptune Capacity Units (NCUs) for this cluster. Must be lower or equal than **128**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
     * 
     */
    @Import(name="maxCapacity")
    private @Nullable Output<Double> maxCapacity;

    /**
     * @return Maximum Neptune Capacity Units (NCUs) for this cluster. Must be lower or equal than **128**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
     * 
     */
    public Optional<Output<Double>> maxCapacity() {
        return Optional.ofNullable(this.maxCapacity);
    }

    /**
     * Minimum Neptune Capacity Units (NCUs) for this cluster. Must be greater or equal than **1**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
     * 
     */
    @Import(name="minCapacity")
    private @Nullable Output<Double> minCapacity;

    /**
     * @return Minimum Neptune Capacity Units (NCUs) for this cluster. Must be greater or equal than **1**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
     * 
     */
    public Optional<Output<Double>> minCapacity() {
        return Optional.ofNullable(this.minCapacity);
    }

    private ClusterServerlessV2ScalingConfigurationArgs() {}

    private ClusterServerlessV2ScalingConfigurationArgs(ClusterServerlessV2ScalingConfigurationArgs $) {
        this.maxCapacity = $.maxCapacity;
        this.minCapacity = $.minCapacity;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterServerlessV2ScalingConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterServerlessV2ScalingConfigurationArgs $;

        public Builder() {
            $ = new ClusterServerlessV2ScalingConfigurationArgs();
        }

        public Builder(ClusterServerlessV2ScalingConfigurationArgs defaults) {
            $ = new ClusterServerlessV2ScalingConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param maxCapacity Maximum Neptune Capacity Units (NCUs) for this cluster. Must be lower or equal than **128**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
         * 
         * @return builder
         * 
         */
        public Builder maxCapacity(@Nullable Output<Double> maxCapacity) {
            $.maxCapacity = maxCapacity;
            return this;
        }

        /**
         * @param maxCapacity Maximum Neptune Capacity Units (NCUs) for this cluster. Must be lower or equal than **128**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
         * 
         * @return builder
         * 
         */
        public Builder maxCapacity(Double maxCapacity) {
            return maxCapacity(Output.of(maxCapacity));
        }

        /**
         * @param minCapacity Minimum Neptune Capacity Units (NCUs) for this cluster. Must be greater or equal than **1**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
         * 
         * @return builder
         * 
         */
        public Builder minCapacity(@Nullable Output<Double> minCapacity) {
            $.minCapacity = minCapacity;
            return this;
        }

        /**
         * @param minCapacity Minimum Neptune Capacity Units (NCUs) for this cluster. Must be greater or equal than **1**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
         * 
         * @return builder
         * 
         */
        public Builder minCapacity(Double minCapacity) {
            return minCapacity(Output.of(minCapacity));
        }

        public ClusterServerlessV2ScalingConfigurationArgs build() {
            return $;
        }
    }

}
