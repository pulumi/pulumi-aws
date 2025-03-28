// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.outputs;

import com.pulumi.aws.timestreamquery.outputs.ScheduledQueryTargetConfigurationTimestreamConfigurationDimensionMapping;
import com.pulumi.aws.timestreamquery.outputs.ScheduledQueryTargetConfigurationTimestreamConfigurationMixedMeasureMapping;
import com.pulumi.aws.timestreamquery.outputs.ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ScheduledQueryTargetConfigurationTimestreamConfiguration {
    /**
     * @return Name of Timestream database to which the query result will be written.
     * 
     */
    private String databaseName;
    /**
     * @return Configuration block for mapping of column(s) from the query result to the dimension in the destination table. See below.
     * 
     */
    private @Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationDimensionMapping> dimensionMappings;
    /**
     * @return Name of the measure column.
     * 
     */
    private @Nullable String measureNameColumn;
    /**
     * @return Configuration block for how to map measures to multi-measure records. See below.
     * 
     */
    private @Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationMixedMeasureMapping> mixedMeasureMappings;
    /**
     * @return Configuration block for multi-measure mappings. Only one of `mixed_measure_mappings` or `multi_measure_mappings` can be provided. `multi_measure_mappings` can be used to ingest data as multi measures in the derived table. See below.
     * 
     */
    private @Nullable ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings multiMeasureMappings;
    /**
     * @return Name of Timestream table that the query result will be written to. The table should be within the same database that is provided in Timestream configuration.
     * 
     */
    private String tableName;
    /**
     * @return Column from query result that should be used as the time column in destination table. Column type for this should be TIMESTAMP.
     * 
     */
    private String timeColumn;

    private ScheduledQueryTargetConfigurationTimestreamConfiguration() {}
    /**
     * @return Name of Timestream database to which the query result will be written.
     * 
     */
    public String databaseName() {
        return this.databaseName;
    }
    /**
     * @return Configuration block for mapping of column(s) from the query result to the dimension in the destination table. See below.
     * 
     */
    public List<ScheduledQueryTargetConfigurationTimestreamConfigurationDimensionMapping> dimensionMappings() {
        return this.dimensionMappings == null ? List.of() : this.dimensionMappings;
    }
    /**
     * @return Name of the measure column.
     * 
     */
    public Optional<String> measureNameColumn() {
        return Optional.ofNullable(this.measureNameColumn);
    }
    /**
     * @return Configuration block for how to map measures to multi-measure records. See below.
     * 
     */
    public List<ScheduledQueryTargetConfigurationTimestreamConfigurationMixedMeasureMapping> mixedMeasureMappings() {
        return this.mixedMeasureMappings == null ? List.of() : this.mixedMeasureMappings;
    }
    /**
     * @return Configuration block for multi-measure mappings. Only one of `mixed_measure_mappings` or `multi_measure_mappings` can be provided. `multi_measure_mappings` can be used to ingest data as multi measures in the derived table. See below.
     * 
     */
    public Optional<ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings> multiMeasureMappings() {
        return Optional.ofNullable(this.multiMeasureMappings);
    }
    /**
     * @return Name of Timestream table that the query result will be written to. The table should be within the same database that is provided in Timestream configuration.
     * 
     */
    public String tableName() {
        return this.tableName;
    }
    /**
     * @return Column from query result that should be used as the time column in destination table. Column type for this should be TIMESTAMP.
     * 
     */
    public String timeColumn() {
        return this.timeColumn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ScheduledQueryTargetConfigurationTimestreamConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String databaseName;
        private @Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationDimensionMapping> dimensionMappings;
        private @Nullable String measureNameColumn;
        private @Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationMixedMeasureMapping> mixedMeasureMappings;
        private @Nullable ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings multiMeasureMappings;
        private String tableName;
        private String timeColumn;
        public Builder() {}
        public Builder(ScheduledQueryTargetConfigurationTimestreamConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.databaseName = defaults.databaseName;
    	      this.dimensionMappings = defaults.dimensionMappings;
    	      this.measureNameColumn = defaults.measureNameColumn;
    	      this.mixedMeasureMappings = defaults.mixedMeasureMappings;
    	      this.multiMeasureMappings = defaults.multiMeasureMappings;
    	      this.tableName = defaults.tableName;
    	      this.timeColumn = defaults.timeColumn;
        }

        @CustomType.Setter
        public Builder databaseName(String databaseName) {
            if (databaseName == null) {
              throw new MissingRequiredPropertyException("ScheduledQueryTargetConfigurationTimestreamConfiguration", "databaseName");
            }
            this.databaseName = databaseName;
            return this;
        }
        @CustomType.Setter
        public Builder dimensionMappings(@Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationDimensionMapping> dimensionMappings) {

            this.dimensionMappings = dimensionMappings;
            return this;
        }
        public Builder dimensionMappings(ScheduledQueryTargetConfigurationTimestreamConfigurationDimensionMapping... dimensionMappings) {
            return dimensionMappings(List.of(dimensionMappings));
        }
        @CustomType.Setter
        public Builder measureNameColumn(@Nullable String measureNameColumn) {

            this.measureNameColumn = measureNameColumn;
            return this;
        }
        @CustomType.Setter
        public Builder mixedMeasureMappings(@Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationMixedMeasureMapping> mixedMeasureMappings) {

            this.mixedMeasureMappings = mixedMeasureMappings;
            return this;
        }
        public Builder mixedMeasureMappings(ScheduledQueryTargetConfigurationTimestreamConfigurationMixedMeasureMapping... mixedMeasureMappings) {
            return mixedMeasureMappings(List.of(mixedMeasureMappings));
        }
        @CustomType.Setter
        public Builder multiMeasureMappings(@Nullable ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings multiMeasureMappings) {

            this.multiMeasureMappings = multiMeasureMappings;
            return this;
        }
        @CustomType.Setter
        public Builder tableName(String tableName) {
            if (tableName == null) {
              throw new MissingRequiredPropertyException("ScheduledQueryTargetConfigurationTimestreamConfiguration", "tableName");
            }
            this.tableName = tableName;
            return this;
        }
        @CustomType.Setter
        public Builder timeColumn(String timeColumn) {
            if (timeColumn == null) {
              throw new MissingRequiredPropertyException("ScheduledQueryTargetConfigurationTimestreamConfiguration", "timeColumn");
            }
            this.timeColumn = timeColumn;
            return this;
        }
        public ScheduledQueryTargetConfigurationTimestreamConfiguration build() {
            final var _resultValue = new ScheduledQueryTargetConfigurationTimestreamConfiguration();
            _resultValue.databaseName = databaseName;
            _resultValue.dimensionMappings = dimensionMappings;
            _resultValue.measureNameColumn = measureNameColumn;
            _resultValue.mixedMeasureMappings = mixedMeasureMappings;
            _resultValue.multiMeasureMappings = multiMeasureMappings;
            _resultValue.tableName = tableName;
            _resultValue.timeColumn = timeColumn;
            return _resultValue;
        }
    }
}
