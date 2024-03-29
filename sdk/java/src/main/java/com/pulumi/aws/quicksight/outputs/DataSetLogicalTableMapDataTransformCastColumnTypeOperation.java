// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DataSetLogicalTableMapDataTransformCastColumnTypeOperation {
    /**
     * @return Column name.
     * 
     */
    private String columnName;
    /**
     * @return When casting a column from string to datetime type, you can supply a string in a format supported by Amazon QuickSight to denote the source data format.
     * 
     */
    private @Nullable String format;
    /**
     * @return New column data type. Valid values are `STRING`, `INTEGER`, `DECIMAL`, `DATETIME`.
     * 
     */
    private String newColumnType;

    private DataSetLogicalTableMapDataTransformCastColumnTypeOperation() {}
    /**
     * @return Column name.
     * 
     */
    public String columnName() {
        return this.columnName;
    }
    /**
     * @return When casting a column from string to datetime type, you can supply a string in a format supported by Amazon QuickSight to denote the source data format.
     * 
     */
    public Optional<String> format() {
        return Optional.ofNullable(this.format);
    }
    /**
     * @return New column data type. Valid values are `STRING`, `INTEGER`, `DECIMAL`, `DATETIME`.
     * 
     */
    public String newColumnType() {
        return this.newColumnType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DataSetLogicalTableMapDataTransformCastColumnTypeOperation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String columnName;
        private @Nullable String format;
        private String newColumnType;
        public Builder() {}
        public Builder(DataSetLogicalTableMapDataTransformCastColumnTypeOperation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.columnName = defaults.columnName;
    	      this.format = defaults.format;
    	      this.newColumnType = defaults.newColumnType;
        }

        @CustomType.Setter
        public Builder columnName(String columnName) {
            if (columnName == null) {
              throw new MissingRequiredPropertyException("DataSetLogicalTableMapDataTransformCastColumnTypeOperation", "columnName");
            }
            this.columnName = columnName;
            return this;
        }
        @CustomType.Setter
        public Builder format(@Nullable String format) {

            this.format = format;
            return this;
        }
        @CustomType.Setter
        public Builder newColumnType(String newColumnType) {
            if (newColumnType == null) {
              throw new MissingRequiredPropertyException("DataSetLogicalTableMapDataTransformCastColumnTypeOperation", "newColumnType");
            }
            this.newColumnType = newColumnType;
            return this;
        }
        public DataSetLogicalTableMapDataTransformCastColumnTypeOperation build() {
            final var _resultValue = new DataSetLogicalTableMapDataTransformCastColumnTypeOperation();
            _resultValue.columnName = columnName;
            _resultValue.format = format;
            _resultValue.newColumnType = newColumnType;
            return _resultValue;
        }
    }
}
