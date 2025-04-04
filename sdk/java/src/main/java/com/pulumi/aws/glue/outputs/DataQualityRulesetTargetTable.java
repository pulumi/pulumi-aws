// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DataQualityRulesetTargetTable {
    /**
     * @return The catalog id where the AWS Glue table exists.
     * 
     */
    private @Nullable String catalogId;
    /**
     * @return Name of the database where the AWS Glue table exists.
     * 
     */
    private String databaseName;
    /**
     * @return Name of the AWS Glue table.
     * 
     */
    private String tableName;

    private DataQualityRulesetTargetTable() {}
    /**
     * @return The catalog id where the AWS Glue table exists.
     * 
     */
    public Optional<String> catalogId() {
        return Optional.ofNullable(this.catalogId);
    }
    /**
     * @return Name of the database where the AWS Glue table exists.
     * 
     */
    public String databaseName() {
        return this.databaseName;
    }
    /**
     * @return Name of the AWS Glue table.
     * 
     */
    public String tableName() {
        return this.tableName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DataQualityRulesetTargetTable defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String catalogId;
        private String databaseName;
        private String tableName;
        public Builder() {}
        public Builder(DataQualityRulesetTargetTable defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.catalogId = defaults.catalogId;
    	      this.databaseName = defaults.databaseName;
    	      this.tableName = defaults.tableName;
        }

        @CustomType.Setter
        public Builder catalogId(@Nullable String catalogId) {

            this.catalogId = catalogId;
            return this;
        }
        @CustomType.Setter
        public Builder databaseName(String databaseName) {
            if (databaseName == null) {
              throw new MissingRequiredPropertyException("DataQualityRulesetTargetTable", "databaseName");
            }
            this.databaseName = databaseName;
            return this;
        }
        @CustomType.Setter
        public Builder tableName(String tableName) {
            if (tableName == null) {
              throw new MissingRequiredPropertyException("DataQualityRulesetTargetTable", "tableName");
            }
            this.tableName = tableName;
            return this;
        }
        public DataQualityRulesetTargetTable build() {
            final var _resultValue = new DataQualityRulesetTargetTable();
            _resultValue.catalogId = catalogId;
            _resultValue.databaseName = databaseName;
            _resultValue.tableName = tableName;
            return _resultValue;
        }
    }
}
