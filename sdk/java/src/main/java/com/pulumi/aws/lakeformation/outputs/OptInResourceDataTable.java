// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lakeformation.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class OptInResourceDataTable {
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    private @Nullable String catalogId;
    /**
     * @return The name of the database for the table. Unique to a Data Catalog. A database is a set of associated table definitions organized into a logical group. You can Grant and Revoke database privileges to a principal.
     * 
     */
    private String databaseName;
    /**
     * @return Name of the table.
     * 
     */
    private @Nullable String name;
    /**
     * @return Boolean value that indicates whether to use a wildcard representing every table under the specified database. When set to true, this represents all tables within the specified database. At least one of TableResource$Name or TableResource$Wildcard is required.
     * 
     */
    private @Nullable Boolean wildcard;

    private OptInResourceDataTable() {}
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    public Optional<String> catalogId() {
        return Optional.ofNullable(this.catalogId);
    }
    /**
     * @return The name of the database for the table. Unique to a Data Catalog. A database is a set of associated table definitions organized into a logical group. You can Grant and Revoke database privileges to a principal.
     * 
     */
    public String databaseName() {
        return this.databaseName;
    }
    /**
     * @return Name of the table.
     * 
     */
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }
    /**
     * @return Boolean value that indicates whether to use a wildcard representing every table under the specified database. When set to true, this represents all tables within the specified database. At least one of TableResource$Name or TableResource$Wildcard is required.
     * 
     */
    public Optional<Boolean> wildcard() {
        return Optional.ofNullable(this.wildcard);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(OptInResourceDataTable defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String catalogId;
        private String databaseName;
        private @Nullable String name;
        private @Nullable Boolean wildcard;
        public Builder() {}
        public Builder(OptInResourceDataTable defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.catalogId = defaults.catalogId;
    	      this.databaseName = defaults.databaseName;
    	      this.name = defaults.name;
    	      this.wildcard = defaults.wildcard;
        }

        @CustomType.Setter
        public Builder catalogId(@Nullable String catalogId) {

            this.catalogId = catalogId;
            return this;
        }
        @CustomType.Setter
        public Builder databaseName(String databaseName) {
            if (databaseName == null) {
              throw new MissingRequiredPropertyException("OptInResourceDataTable", "databaseName");
            }
            this.databaseName = databaseName;
            return this;
        }
        @CustomType.Setter
        public Builder name(@Nullable String name) {

            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder wildcard(@Nullable Boolean wildcard) {

            this.wildcard = wildcard;
            return this;
        }
        public OptInResourceDataTable build() {
            final var _resultValue = new OptInResourceDataTable();
            _resultValue.catalogId = catalogId;
            _resultValue.databaseName = databaseName;
            _resultValue.name = name;
            _resultValue.wildcard = wildcard;
            return _resultValue;
        }
    }
}
