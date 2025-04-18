// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dynamodb.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TableOnDemandThroughputArgs extends com.pulumi.resources.ResourceArgs {

    public static final TableOnDemandThroughputArgs Empty = new TableOnDemandThroughputArgs();

    /**
     * Maximum number of read request units for the specified table. To specify set the value greater than or equal to 1. To remove set the value to -1.
     * 
     */
    @Import(name="maxReadRequestUnits")
    private @Nullable Output<Integer> maxReadRequestUnits;

    /**
     * @return Maximum number of read request units for the specified table. To specify set the value greater than or equal to 1. To remove set the value to -1.
     * 
     */
    public Optional<Output<Integer>> maxReadRequestUnits() {
        return Optional.ofNullable(this.maxReadRequestUnits);
    }

    /**
     * Maximum number of write request units for the specified table. To specify set the value greater than or equal to 1. To remove set the value to -1.
     * 
     */
    @Import(name="maxWriteRequestUnits")
    private @Nullable Output<Integer> maxWriteRequestUnits;

    /**
     * @return Maximum number of write request units for the specified table. To specify set the value greater than or equal to 1. To remove set the value to -1.
     * 
     */
    public Optional<Output<Integer>> maxWriteRequestUnits() {
        return Optional.ofNullable(this.maxWriteRequestUnits);
    }

    private TableOnDemandThroughputArgs() {}

    private TableOnDemandThroughputArgs(TableOnDemandThroughputArgs $) {
        this.maxReadRequestUnits = $.maxReadRequestUnits;
        this.maxWriteRequestUnits = $.maxWriteRequestUnits;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TableOnDemandThroughputArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TableOnDemandThroughputArgs $;

        public Builder() {
            $ = new TableOnDemandThroughputArgs();
        }

        public Builder(TableOnDemandThroughputArgs defaults) {
            $ = new TableOnDemandThroughputArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param maxReadRequestUnits Maximum number of read request units for the specified table. To specify set the value greater than or equal to 1. To remove set the value to -1.
         * 
         * @return builder
         * 
         */
        public Builder maxReadRequestUnits(@Nullable Output<Integer> maxReadRequestUnits) {
            $.maxReadRequestUnits = maxReadRequestUnits;
            return this;
        }

        /**
         * @param maxReadRequestUnits Maximum number of read request units for the specified table. To specify set the value greater than or equal to 1. To remove set the value to -1.
         * 
         * @return builder
         * 
         */
        public Builder maxReadRequestUnits(Integer maxReadRequestUnits) {
            return maxReadRequestUnits(Output.of(maxReadRequestUnits));
        }

        /**
         * @param maxWriteRequestUnits Maximum number of write request units for the specified table. To specify set the value greater than or equal to 1. To remove set the value to -1.
         * 
         * @return builder
         * 
         */
        public Builder maxWriteRequestUnits(@Nullable Output<Integer> maxWriteRequestUnits) {
            $.maxWriteRequestUnits = maxWriteRequestUnits;
            return this;
        }

        /**
         * @param maxWriteRequestUnits Maximum number of write request units for the specified table. To specify set the value greater than or equal to 1. To remove set the value to -1.
         * 
         * @return builder
         * 
         */
        public Builder maxWriteRequestUnits(Integer maxWriteRequestUnits) {
            return maxWriteRequestUnits(Output.of(maxWriteRequestUnits));
        }

        public TableOnDemandThroughputArgs build() {
            return $;
        }
    }

}
