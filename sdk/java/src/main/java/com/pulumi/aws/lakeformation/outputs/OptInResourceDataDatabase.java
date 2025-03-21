// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lakeformation.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class OptInResourceDataDatabase {
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    private @Nullable String catalogId;
    /**
     * @return Name of the table.
     * 
     */
    private String name;

    private OptInResourceDataDatabase() {}
    /**
     * @return Identifier for the Data Catalog. By default, it is the account ID of the caller.
     * 
     */
    public Optional<String> catalogId() {
        return Optional.ofNullable(this.catalogId);
    }
    /**
     * @return Name of the table.
     * 
     */
    public String name() {
        return this.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(OptInResourceDataDatabase defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String catalogId;
        private String name;
        public Builder() {}
        public Builder(OptInResourceDataDatabase defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.catalogId = defaults.catalogId;
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder catalogId(@Nullable String catalogId) {

            this.catalogId = catalogId;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("OptInResourceDataDatabase", "name");
            }
            this.name = name;
            return this;
        }
        public OptInResourceDataDatabase build() {
            final var _resultValue = new OptInResourceDataDatabase();
            _resultValue.catalogId = catalogId;
            _resultValue.name = name;
            return _resultValue;
        }
    }
}
