// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lakeformation;

import com.pulumi.aws.lakeformation.inputs.DataCellsFilterTableDataArgs;
import com.pulumi.aws.lakeformation.inputs.DataCellsFilterTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataCellsFilterArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataCellsFilterArgs Empty = new DataCellsFilterArgs();

    /**
     * Information about the data cells filter. See Table Data below for details.
     * 
     */
    @Import(name="tableData")
    private @Nullable Output<DataCellsFilterTableDataArgs> tableData;

    /**
     * @return Information about the data cells filter. See Table Data below for details.
     * 
     */
    public Optional<Output<DataCellsFilterTableDataArgs>> tableData() {
        return Optional.ofNullable(this.tableData);
    }

    @Import(name="timeouts")
    private @Nullable Output<DataCellsFilterTimeoutsArgs> timeouts;

    public Optional<Output<DataCellsFilterTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private DataCellsFilterArgs() {}

    private DataCellsFilterArgs(DataCellsFilterArgs $) {
        this.tableData = $.tableData;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataCellsFilterArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataCellsFilterArgs $;

        public Builder() {
            $ = new DataCellsFilterArgs();
        }

        public Builder(DataCellsFilterArgs defaults) {
            $ = new DataCellsFilterArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param tableData Information about the data cells filter. See Table Data below for details.
         * 
         * @return builder
         * 
         */
        public Builder tableData(@Nullable Output<DataCellsFilterTableDataArgs> tableData) {
            $.tableData = tableData;
            return this;
        }

        /**
         * @param tableData Information about the data cells filter. See Table Data below for details.
         * 
         * @return builder
         * 
         */
        public Builder tableData(DataCellsFilterTableDataArgs tableData) {
            return tableData(Output.of(tableData));
        }

        public Builder timeouts(@Nullable Output<DataCellsFilterTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(DataCellsFilterTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public DataCellsFilterArgs build() {
            return $;
        }
    }

}
