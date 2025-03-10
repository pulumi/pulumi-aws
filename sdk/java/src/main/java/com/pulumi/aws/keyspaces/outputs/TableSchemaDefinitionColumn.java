// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.keyspaces.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class TableSchemaDefinitionColumn {
    /**
     * @return The name of the column.
     * 
     */
    private String name;
    /**
     * @return The data type of the column. See the [Developer Guide](https://docs.aws.amazon.com/keyspaces/latest/devguide/cql.elements.html#cql.data-types) for a list of available data types.
     * 
     */
    private String type;

    private TableSchemaDefinitionColumn() {}
    /**
     * @return The name of the column.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return The data type of the column. See the [Developer Guide](https://docs.aws.amazon.com/keyspaces/latest/devguide/cql.elements.html#cql.data-types) for a list of available data types.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TableSchemaDefinitionColumn defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String name;
        private String type;
        public Builder() {}
        public Builder(TableSchemaDefinitionColumn defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.name = defaults.name;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("TableSchemaDefinitionColumn", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("TableSchemaDefinitionColumn", "type");
            }
            this.type = type;
            return this;
        }
        public TableSchemaDefinitionColumn build() {
            final var _resultValue = new TableSchemaDefinitionColumn();
            _resultValue.name = name;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
