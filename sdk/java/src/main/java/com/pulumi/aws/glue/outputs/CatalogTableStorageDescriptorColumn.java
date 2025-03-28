// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class CatalogTableStorageDescriptorColumn {
    /**
     * @return Free-form text comment.
     * 
     */
    private @Nullable String comment;
    /**
     * @return Name of the Column.
     * 
     */
    private String name;
    /**
     * @return Key-value pairs defining properties associated with the column.
     * 
     */
    private @Nullable Map<String,String> parameters;
    /**
     * @return Datatype of data in the Column.
     * 
     */
    private @Nullable String type;

    private CatalogTableStorageDescriptorColumn() {}
    /**
     * @return Free-form text comment.
     * 
     */
    public Optional<String> comment() {
        return Optional.ofNullable(this.comment);
    }
    /**
     * @return Name of the Column.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Key-value pairs defining properties associated with the column.
     * 
     */
    public Map<String,String> parameters() {
        return this.parameters == null ? Map.of() : this.parameters;
    }
    /**
     * @return Datatype of data in the Column.
     * 
     */
    public Optional<String> type() {
        return Optional.ofNullable(this.type);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CatalogTableStorageDescriptorColumn defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String comment;
        private String name;
        private @Nullable Map<String,String> parameters;
        private @Nullable String type;
        public Builder() {}
        public Builder(CatalogTableStorageDescriptorColumn defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.comment = defaults.comment;
    	      this.name = defaults.name;
    	      this.parameters = defaults.parameters;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder comment(@Nullable String comment) {

            this.comment = comment;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("CatalogTableStorageDescriptorColumn", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder parameters(@Nullable Map<String,String> parameters) {

            this.parameters = parameters;
            return this;
        }
        @CustomType.Setter
        public Builder type(@Nullable String type) {

            this.type = type;
            return this;
        }
        public CatalogTableStorageDescriptorColumn build() {
            final var _resultValue = new CatalogTableStorageDescriptorColumn();
            _resultValue.comment = comment;
            _resultValue.name = name;
            _resultValue.parameters = parameters;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
