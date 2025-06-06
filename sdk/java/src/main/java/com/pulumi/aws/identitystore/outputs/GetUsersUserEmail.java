// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.identitystore.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetUsersUserEmail {
    /**
     * @return When `true`, this is the primary phone number associated with the user.
     * 
     */
    private Boolean primary;
    /**
     * @return Type of phone number.
     * 
     */
    private String type;
    /**
     * @return User&#39;s phone number.
     * 
     */
    private String value;

    private GetUsersUserEmail() {}
    /**
     * @return When `true`, this is the primary phone number associated with the user.
     * 
     */
    public Boolean primary() {
        return this.primary;
    }
    /**
     * @return Type of phone number.
     * 
     */
    public String type() {
        return this.type;
    }
    /**
     * @return User&#39;s phone number.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetUsersUserEmail defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean primary;
        private String type;
        private String value;
        public Builder() {}
        public Builder(GetUsersUserEmail defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.primary = defaults.primary;
    	      this.type = defaults.type;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder primary(Boolean primary) {
            if (primary == null) {
              throw new MissingRequiredPropertyException("GetUsersUserEmail", "primary");
            }
            this.primary = primary;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("GetUsersUserEmail", "type");
            }
            this.type = type;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("GetUsersUserEmail", "value");
            }
            this.value = value;
            return this;
        }
        public GetUsersUserEmail build() {
            final var _resultValue = new GetUsersUserEmail();
            _resultValue.primary = primary;
            _resultValue.type = type;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
