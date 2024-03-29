// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PartitionStorageDescriptorSkewedInfoArgs extends com.pulumi.resources.ResourceArgs {

    public static final PartitionStorageDescriptorSkewedInfoArgs Empty = new PartitionStorageDescriptorSkewedInfoArgs();

    /**
     * A list of names of columns that contain skewed values.
     * 
     */
    @Import(name="skewedColumnNames")
    private @Nullable Output<List<String>> skewedColumnNames;

    /**
     * @return A list of names of columns that contain skewed values.
     * 
     */
    public Optional<Output<List<String>>> skewedColumnNames() {
        return Optional.ofNullable(this.skewedColumnNames);
    }

    /**
     * A list of values that appear so frequently as to be considered skewed.
     * 
     */
    @Import(name="skewedColumnValueLocationMaps")
    private @Nullable Output<Map<String,String>> skewedColumnValueLocationMaps;

    /**
     * @return A list of values that appear so frequently as to be considered skewed.
     * 
     */
    public Optional<Output<Map<String,String>>> skewedColumnValueLocationMaps() {
        return Optional.ofNullable(this.skewedColumnValueLocationMaps);
    }

    /**
     * A map of skewed values to the columns that contain them.
     * 
     */
    @Import(name="skewedColumnValues")
    private @Nullable Output<List<String>> skewedColumnValues;

    /**
     * @return A map of skewed values to the columns that contain them.
     * 
     */
    public Optional<Output<List<String>>> skewedColumnValues() {
        return Optional.ofNullable(this.skewedColumnValues);
    }

    private PartitionStorageDescriptorSkewedInfoArgs() {}

    private PartitionStorageDescriptorSkewedInfoArgs(PartitionStorageDescriptorSkewedInfoArgs $) {
        this.skewedColumnNames = $.skewedColumnNames;
        this.skewedColumnValueLocationMaps = $.skewedColumnValueLocationMaps;
        this.skewedColumnValues = $.skewedColumnValues;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PartitionStorageDescriptorSkewedInfoArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PartitionStorageDescriptorSkewedInfoArgs $;

        public Builder() {
            $ = new PartitionStorageDescriptorSkewedInfoArgs();
        }

        public Builder(PartitionStorageDescriptorSkewedInfoArgs defaults) {
            $ = new PartitionStorageDescriptorSkewedInfoArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param skewedColumnNames A list of names of columns that contain skewed values.
         * 
         * @return builder
         * 
         */
        public Builder skewedColumnNames(@Nullable Output<List<String>> skewedColumnNames) {
            $.skewedColumnNames = skewedColumnNames;
            return this;
        }

        /**
         * @param skewedColumnNames A list of names of columns that contain skewed values.
         * 
         * @return builder
         * 
         */
        public Builder skewedColumnNames(List<String> skewedColumnNames) {
            return skewedColumnNames(Output.of(skewedColumnNames));
        }

        /**
         * @param skewedColumnNames A list of names of columns that contain skewed values.
         * 
         * @return builder
         * 
         */
        public Builder skewedColumnNames(String... skewedColumnNames) {
            return skewedColumnNames(List.of(skewedColumnNames));
        }

        /**
         * @param skewedColumnValueLocationMaps A list of values that appear so frequently as to be considered skewed.
         * 
         * @return builder
         * 
         */
        public Builder skewedColumnValueLocationMaps(@Nullable Output<Map<String,String>> skewedColumnValueLocationMaps) {
            $.skewedColumnValueLocationMaps = skewedColumnValueLocationMaps;
            return this;
        }

        /**
         * @param skewedColumnValueLocationMaps A list of values that appear so frequently as to be considered skewed.
         * 
         * @return builder
         * 
         */
        public Builder skewedColumnValueLocationMaps(Map<String,String> skewedColumnValueLocationMaps) {
            return skewedColumnValueLocationMaps(Output.of(skewedColumnValueLocationMaps));
        }

        /**
         * @param skewedColumnValues A map of skewed values to the columns that contain them.
         * 
         * @return builder
         * 
         */
        public Builder skewedColumnValues(@Nullable Output<List<String>> skewedColumnValues) {
            $.skewedColumnValues = skewedColumnValues;
            return this;
        }

        /**
         * @param skewedColumnValues A map of skewed values to the columns that contain them.
         * 
         * @return builder
         * 
         */
        public Builder skewedColumnValues(List<String> skewedColumnValues) {
            return skewedColumnValues(Output.of(skewedColumnValues));
        }

        /**
         * @param skewedColumnValues A map of skewed values to the columns that contain them.
         * 
         * @return builder
         * 
         */
        public Builder skewedColumnValues(String... skewedColumnValues) {
            return skewedColumnValues(List.of(skewedColumnValues));
        }

        public PartitionStorageDescriptorSkewedInfoArgs build() {
            return $;
        }
    }

}
