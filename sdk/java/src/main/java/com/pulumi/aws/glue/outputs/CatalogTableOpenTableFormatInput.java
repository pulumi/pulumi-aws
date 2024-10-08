// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.outputs;

import com.pulumi.aws.glue.outputs.CatalogTableOpenTableFormatInputIcebergInput;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.Objects;

@CustomType
public final class CatalogTableOpenTableFormatInput {
    /**
     * @return Configuration block for iceberg table config. See `iceberg_input` below.
     * 
     */
    private CatalogTableOpenTableFormatInputIcebergInput icebergInput;

    private CatalogTableOpenTableFormatInput() {}
    /**
     * @return Configuration block for iceberg table config. See `iceberg_input` below.
     * 
     */
    public CatalogTableOpenTableFormatInputIcebergInput icebergInput() {
        return this.icebergInput;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CatalogTableOpenTableFormatInput defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private CatalogTableOpenTableFormatInputIcebergInput icebergInput;
        public Builder() {}
        public Builder(CatalogTableOpenTableFormatInput defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.icebergInput = defaults.icebergInput;
        }

        @CustomType.Setter
        public Builder icebergInput(CatalogTableOpenTableFormatInputIcebergInput icebergInput) {
            if (icebergInput == null) {
              throw new MissingRequiredPropertyException("CatalogTableOpenTableFormatInput", "icebergInput");
            }
            this.icebergInput = icebergInput;
            return this;
        }
        public CatalogTableOpenTableFormatInput build() {
            final var _resultValue = new CatalogTableOpenTableFormatInput();
            _resultValue.icebergInput = icebergInput;
            return _resultValue;
        }
    }
}
