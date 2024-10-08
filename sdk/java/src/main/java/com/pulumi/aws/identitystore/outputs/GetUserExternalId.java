// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.identitystore.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetUserExternalId {
    /**
     * @return The identifier issued to this resource by an external identity provider.
     * 
     */
    private String id;
    /**
     * @return The issuer for an external identifier.
     * 
     */
    private String issuer;

    private GetUserExternalId() {}
    /**
     * @return The identifier issued to this resource by an external identity provider.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return The issuer for an external identifier.
     * 
     */
    public String issuer() {
        return this.issuer;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetUserExternalId defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String id;
        private String issuer;
        public Builder() {}
        public Builder(GetUserExternalId defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.id = defaults.id;
    	      this.issuer = defaults.issuer;
        }

        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetUserExternalId", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder issuer(String issuer) {
            if (issuer == null) {
              throw new MissingRequiredPropertyException("GetUserExternalId", "issuer");
            }
            this.issuer = issuer;
            return this;
        }
        public GetUserExternalId build() {
            final var _resultValue = new GetUserExternalId();
            _resultValue.id = id;
            _resultValue.issuer = issuer;
            return _resultValue;
        }
    }
}
