// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lakeformation.outputs;

import com.pulumi.aws.lakeformation.outputs.ResourceLfTagTableWithColumnsColumnWildcard;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ResourceLfTagTableWithColumns {
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    private @Nullable String catalogId;
    /**
     * @return Set of column names for the table.
     * 
     */
    private @Nullable List<String> columnNames;
    /**
     * @return Option to add column wildcard. See Column Wildcard for more details.
     * 
     */
    private @Nullable ResourceLfTagTableWithColumnsColumnWildcard columnWildcard;
    /**
     * @return Name of the database for the table with columns resource. Unique to the Data Catalog.
     * 
     */
    private String databaseName;
    /**
     * @return Name of the table resource.
     * 
     * The following arguments are optional:
     * 
     */
    private String name;

    private ResourceLfTagTableWithColumns() {}
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    public Optional<String> catalogId() {
        return Optional.ofNullable(this.catalogId);
    }
    /**
     * @return Set of column names for the table.
     * 
     */
    public List<String> columnNames() {
        return this.columnNames == null ? List.of() : this.columnNames;
    }
    /**
     * @return Option to add column wildcard. See Column Wildcard for more details.
     * 
     */
    public Optional<ResourceLfTagTableWithColumnsColumnWildcard> columnWildcard() {
        return Optional.ofNullable(this.columnWildcard);
    }
    /**
     * @return Name of the database for the table with columns resource. Unique to the Data Catalog.
     * 
     */
    public String databaseName() {
        return this.databaseName;
    }
    /**
     * @return Name of the table resource.
     * 
     * The following arguments are optional:
     * 
     */
    public String name() {
        return this.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ResourceLfTagTableWithColumns defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String catalogId;
        private @Nullable List<String> columnNames;
        private @Nullable ResourceLfTagTableWithColumnsColumnWildcard columnWildcard;
        private String databaseName;
        private String name;
        public Builder() {}
        public Builder(ResourceLfTagTableWithColumns defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.catalogId = defaults.catalogId;
    	      this.columnNames = defaults.columnNames;
    	      this.columnWildcard = defaults.columnWildcard;
    	      this.databaseName = defaults.databaseName;
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder catalogId(@Nullable String catalogId) {

            this.catalogId = catalogId;
            return this;
        }
        @CustomType.Setter
        public Builder columnNames(@Nullable List<String> columnNames) {

            this.columnNames = columnNames;
            return this;
        }
        public Builder columnNames(String... columnNames) {
            return columnNames(List.of(columnNames));
        }
        @CustomType.Setter
        public Builder columnWildcard(@Nullable ResourceLfTagTableWithColumnsColumnWildcard columnWildcard) {

            this.columnWildcard = columnWildcard;
            return this;
        }
        @CustomType.Setter
        public Builder databaseName(String databaseName) {
            if (databaseName == null) {
              throw new MissingRequiredPropertyException("ResourceLfTagTableWithColumns", "databaseName");
            }
            this.databaseName = databaseName;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("ResourceLfTagTableWithColumns", "name");
            }
            this.name = name;
            return this;
        }
        public ResourceLfTagTableWithColumns build() {
            final var _resultValue = new ResourceLfTagTableWithColumns();
            _resultValue.catalogId = catalogId;
            _resultValue.columnNames = columnNames;
            _resultValue.columnWildcard = columnWildcard;
            _resultValue.databaseName = databaseName;
            _resultValue.name = name;
            return _resultValue;
        }
    }
}
