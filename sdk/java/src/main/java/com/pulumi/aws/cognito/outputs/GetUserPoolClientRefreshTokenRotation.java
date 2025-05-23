// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetUserPoolClientRefreshTokenRotation {
    /**
     * @return (Required) The state of refresh token rotation for the current app client. Valid values are `ENABLED` or `DISABLED`.
     * 
     */
    private String feature;
    /**
     * @return (Optional) A period of time in seconds that the user has to use the old refresh token before it is invalidated. Valid values are between `0` and `60`.
     * 
     */
    private Integer retryGracePeriodSeconds;

    private GetUserPoolClientRefreshTokenRotation() {}
    /**
     * @return (Required) The state of refresh token rotation for the current app client. Valid values are `ENABLED` or `DISABLED`.
     * 
     */
    public String feature() {
        return this.feature;
    }
    /**
     * @return (Optional) A period of time in seconds that the user has to use the old refresh token before it is invalidated. Valid values are between `0` and `60`.
     * 
     */
    public Integer retryGracePeriodSeconds() {
        return this.retryGracePeriodSeconds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetUserPoolClientRefreshTokenRotation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String feature;
        private Integer retryGracePeriodSeconds;
        public Builder() {}
        public Builder(GetUserPoolClientRefreshTokenRotation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.feature = defaults.feature;
    	      this.retryGracePeriodSeconds = defaults.retryGracePeriodSeconds;
        }

        @CustomType.Setter
        public Builder feature(String feature) {
            if (feature == null) {
              throw new MissingRequiredPropertyException("GetUserPoolClientRefreshTokenRotation", "feature");
            }
            this.feature = feature;
            return this;
        }
        @CustomType.Setter
        public Builder retryGracePeriodSeconds(Integer retryGracePeriodSeconds) {
            if (retryGracePeriodSeconds == null) {
              throw new MissingRequiredPropertyException("GetUserPoolClientRefreshTokenRotation", "retryGracePeriodSeconds");
            }
            this.retryGracePeriodSeconds = retryGracePeriodSeconds;
            return this;
        }
        public GetUserPoolClientRefreshTokenRotation build() {
            final var _resultValue = new GetUserPoolClientRefreshTokenRotation();
            _resultValue.feature = feature;
            _resultValue.retryGracePeriodSeconds = retryGracePeriodSeconds;
            return _resultValue;
        }
    }
}
