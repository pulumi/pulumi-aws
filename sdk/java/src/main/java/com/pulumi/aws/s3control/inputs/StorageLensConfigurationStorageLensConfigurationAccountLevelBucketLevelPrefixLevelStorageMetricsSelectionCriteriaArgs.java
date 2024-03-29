// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3control.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs extends com.pulumi.resources.ResourceArgs {

    public static final StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs Empty = new StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs();

    /**
     * The delimiter of the selection criteria being used.
     * 
     */
    @Import(name="delimiter")
    private @Nullable Output<String> delimiter;

    /**
     * @return The delimiter of the selection criteria being used.
     * 
     */
    public Optional<Output<String>> delimiter() {
        return Optional.ofNullable(this.delimiter);
    }

    /**
     * The max depth of the selection criteria.
     * 
     */
    @Import(name="maxDepth")
    private @Nullable Output<Integer> maxDepth;

    /**
     * @return The max depth of the selection criteria.
     * 
     */
    public Optional<Output<Integer>> maxDepth() {
        return Optional.ofNullable(this.maxDepth);
    }

    /**
     * The minimum number of storage bytes percentage whose metrics will be selected.
     * 
     */
    @Import(name="minStorageBytesPercentage")
    private @Nullable Output<Double> minStorageBytesPercentage;

    /**
     * @return The minimum number of storage bytes percentage whose metrics will be selected.
     * 
     */
    public Optional<Output<Double>> minStorageBytesPercentage() {
        return Optional.ofNullable(this.minStorageBytesPercentage);
    }

    private StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs() {}

    private StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs(StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs $) {
        this.delimiter = $.delimiter;
        this.maxDepth = $.maxDepth;
        this.minStorageBytesPercentage = $.minStorageBytesPercentage;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs $;

        public Builder() {
            $ = new StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs();
        }

        public Builder(StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs defaults) {
            $ = new StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param delimiter The delimiter of the selection criteria being used.
         * 
         * @return builder
         * 
         */
        public Builder delimiter(@Nullable Output<String> delimiter) {
            $.delimiter = delimiter;
            return this;
        }

        /**
         * @param delimiter The delimiter of the selection criteria being used.
         * 
         * @return builder
         * 
         */
        public Builder delimiter(String delimiter) {
            return delimiter(Output.of(delimiter));
        }

        /**
         * @param maxDepth The max depth of the selection criteria.
         * 
         * @return builder
         * 
         */
        public Builder maxDepth(@Nullable Output<Integer> maxDepth) {
            $.maxDepth = maxDepth;
            return this;
        }

        /**
         * @param maxDepth The max depth of the selection criteria.
         * 
         * @return builder
         * 
         */
        public Builder maxDepth(Integer maxDepth) {
            return maxDepth(Output.of(maxDepth));
        }

        /**
         * @param minStorageBytesPercentage The minimum number of storage bytes percentage whose metrics will be selected.
         * 
         * @return builder
         * 
         */
        public Builder minStorageBytesPercentage(@Nullable Output<Double> minStorageBytesPercentage) {
            $.minStorageBytesPercentage = minStorageBytesPercentage;
            return this;
        }

        /**
         * @param minStorageBytesPercentage The minimum number of storage bytes percentage whose metrics will be selected.
         * 
         * @return builder
         * 
         */
        public Builder minStorageBytesPercentage(Double minStorageBytesPercentage) {
            return minStorageBytesPercentage(Output.of(minStorageBytesPercentage));
        }

        public StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelPrefixLevelStorageMetricsSelectionCriteriaArgs build() {
            return $;
        }
    }

}
