// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetDataSetPhysicalTableMapCustomSqlColumn {
    private String name;
    private String type;

    private GetDataSetPhysicalTableMapCustomSqlColumn() {}
    public String name() {
        return this.name;
    }
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDataSetPhysicalTableMapCustomSqlColumn defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String name;
        private String type;
        public Builder() {}
        public Builder(GetDataSetPhysicalTableMapCustomSqlColumn defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.name = defaults.name;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetDataSetPhysicalTableMapCustomSqlColumn", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("GetDataSetPhysicalTableMapCustomSqlColumn", "type");
            }
            this.type = type;
            return this;
        }
        public GetDataSetPhysicalTableMapCustomSqlColumn build() {
            final var _resultValue = new GetDataSetPhysicalTableMapCustomSqlColumn();
            _resultValue.name = name;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
