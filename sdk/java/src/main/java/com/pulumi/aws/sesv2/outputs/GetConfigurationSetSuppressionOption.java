// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetConfigurationSetSuppressionOption {
    /**
     * @return A list that contains the reasons that email addresses are automatically added to the suppression list for your account.
     * 
     */
    private List<String> suppressedReasons;

    private GetConfigurationSetSuppressionOption() {}
    /**
     * @return A list that contains the reasons that email addresses are automatically added to the suppression list for your account.
     * 
     */
    public List<String> suppressedReasons() {
        return this.suppressedReasons;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetConfigurationSetSuppressionOption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> suppressedReasons;
        public Builder() {}
        public Builder(GetConfigurationSetSuppressionOption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.suppressedReasons = defaults.suppressedReasons;
        }

        @CustomType.Setter
        public Builder suppressedReasons(List<String> suppressedReasons) {
            if (suppressedReasons == null) {
              throw new MissingRequiredPropertyException("GetConfigurationSetSuppressionOption", "suppressedReasons");
            }
            this.suppressedReasons = suppressedReasons;
            return this;
        }
        public Builder suppressedReasons(String... suppressedReasons) {
            return suppressedReasons(List.of(suppressedReasons));
        }
        public GetConfigurationSetSuppressionOption build() {
            final var _resultValue = new GetConfigurationSetSuppressionOption();
            _resultValue.suppressedReasons = suppressedReasons;
            return _resultValue;
        }
    }
}
