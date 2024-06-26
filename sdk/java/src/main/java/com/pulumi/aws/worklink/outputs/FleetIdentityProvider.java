// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.worklink.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class FleetIdentityProvider {
    /**
     * @return The SAML metadata document provided by the customer’s identity provider.
     * 
     */
    private String samlMetadata;
    /**
     * @return The type of identity provider.
     * 
     */
    private String type;

    private FleetIdentityProvider() {}
    /**
     * @return The SAML metadata document provided by the customer’s identity provider.
     * 
     */
    public String samlMetadata() {
        return this.samlMetadata;
    }
    /**
     * @return The type of identity provider.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FleetIdentityProvider defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String samlMetadata;
        private String type;
        public Builder() {}
        public Builder(FleetIdentityProvider defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.samlMetadata = defaults.samlMetadata;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder samlMetadata(String samlMetadata) {
            if (samlMetadata == null) {
              throw new MissingRequiredPropertyException("FleetIdentityProvider", "samlMetadata");
            }
            this.samlMetadata = samlMetadata;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("FleetIdentityProvider", "type");
            }
            this.type = type;
            return this;
        }
        public FleetIdentityProvider build() {
            final var _resultValue = new FleetIdentityProvider();
            _resultValue.samlMetadata = samlMetadata;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
