// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.inputs;

import com.pulumi.aws.quicksight.inputs.DataSetLogicalTableMapDataTransformTagColumnOperationTagColumnDescriptionArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs Empty = new DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs();

    /**
     * A description for a column. See column_description.
     * 
     */
    @Import(name="columnDescription")
    private @Nullable Output<DataSetLogicalTableMapDataTransformTagColumnOperationTagColumnDescriptionArgs> columnDescription;

    /**
     * @return A description for a column. See column_description.
     * 
     */
    public Optional<Output<DataSetLogicalTableMapDataTransformTagColumnOperationTagColumnDescriptionArgs>> columnDescription() {
        return Optional.ofNullable(this.columnDescription);
    }

    /**
     * A geospatial role for a column. Valid values are `COUNTRY`, `STATE`, `COUNTY`, `CITY`, `POSTCODE`, `LONGITUDE`, and `LATITUDE`.
     * 
     */
    @Import(name="columnGeographicRole")
    private @Nullable Output<String> columnGeographicRole;

    /**
     * @return A geospatial role for a column. Valid values are `COUNTRY`, `STATE`, `COUNTY`, `CITY`, `POSTCODE`, `LONGITUDE`, and `LATITUDE`.
     * 
     */
    public Optional<Output<String>> columnGeographicRole() {
        return Optional.ofNullable(this.columnGeographicRole);
    }

    private DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs() {}

    private DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs(DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs $) {
        this.columnDescription = $.columnDescription;
        this.columnGeographicRole = $.columnGeographicRole;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs $;

        public Builder() {
            $ = new DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs();
        }

        public Builder(DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs defaults) {
            $ = new DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param columnDescription A description for a column. See column_description.
         * 
         * @return builder
         * 
         */
        public Builder columnDescription(@Nullable Output<DataSetLogicalTableMapDataTransformTagColumnOperationTagColumnDescriptionArgs> columnDescription) {
            $.columnDescription = columnDescription;
            return this;
        }

        /**
         * @param columnDescription A description for a column. See column_description.
         * 
         * @return builder
         * 
         */
        public Builder columnDescription(DataSetLogicalTableMapDataTransformTagColumnOperationTagColumnDescriptionArgs columnDescription) {
            return columnDescription(Output.of(columnDescription));
        }

        /**
         * @param columnGeographicRole A geospatial role for a column. Valid values are `COUNTRY`, `STATE`, `COUNTY`, `CITY`, `POSTCODE`, `LONGITUDE`, and `LATITUDE`.
         * 
         * @return builder
         * 
         */
        public Builder columnGeographicRole(@Nullable Output<String> columnGeographicRole) {
            $.columnGeographicRole = columnGeographicRole;
            return this;
        }

        /**
         * @param columnGeographicRole A geospatial role for a column. Valid values are `COUNTRY`, `STATE`, `COUNTY`, `CITY`, `POSTCODE`, `LONGITUDE`, and `LATITUDE`.
         * 
         * @return builder
         * 
         */
        public Builder columnGeographicRole(String columnGeographicRole) {
            return columnGeographicRole(Output.of(columnGeographicRole));
        }

        public DataSetLogicalTableMapDataTransformTagColumnOperationTagArgs build() {
            return $;
        }
    }

}
