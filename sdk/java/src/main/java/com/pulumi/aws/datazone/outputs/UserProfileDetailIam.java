// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.datazone.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class UserProfileDetailIam {
    private String arn;

    private UserProfileDetailIam() {}
    public String arn() {
        return this.arn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(UserProfileDetailIam defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        public Builder() {}
        public Builder(UserProfileDetailIam defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("UserProfileDetailIam", "arn");
            }
            this.arn = arn;
            return this;
        }
        public UserProfileDetailIam build() {
            final var _resultValue = new UserProfileDetailIam();
            _resultValue.arn = arn;
            return _resultValue;
        }
    }
}
