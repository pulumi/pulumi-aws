// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ConfigurationSetDeliveryOptions {
    /**
     * @return The maximum amount of time, in seconds, that Amazon SES API v2 will attempt delivery of email. If specified, the value must greater than or equal to 300 seconds (5 minutes) and less than or equal to 50400 seconds (840 minutes).
     * 
     */
    private @Nullable Integer maxDeliverySeconds;
    /**
     * @return The name of the dedicated IP pool to associate with the configuration set.
     * 
     */
    private @Nullable String sendingPoolName;
    /**
     * @return Specifies whether messages that use the configuration set are required to use Transport Layer Security (TLS). Valid values: `REQUIRE`, `OPTIONAL`.
     * 
     */
    private @Nullable String tlsPolicy;

    private ConfigurationSetDeliveryOptions() {}
    /**
     * @return The maximum amount of time, in seconds, that Amazon SES API v2 will attempt delivery of email. If specified, the value must greater than or equal to 300 seconds (5 minutes) and less than or equal to 50400 seconds (840 minutes).
     * 
     */
    public Optional<Integer> maxDeliverySeconds() {
        return Optional.ofNullable(this.maxDeliverySeconds);
    }
    /**
     * @return The name of the dedicated IP pool to associate with the configuration set.
     * 
     */
    public Optional<String> sendingPoolName() {
        return Optional.ofNullable(this.sendingPoolName);
    }
    /**
     * @return Specifies whether messages that use the configuration set are required to use Transport Layer Security (TLS). Valid values: `REQUIRE`, `OPTIONAL`.
     * 
     */
    public Optional<String> tlsPolicy() {
        return Optional.ofNullable(this.tlsPolicy);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ConfigurationSetDeliveryOptions defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer maxDeliverySeconds;
        private @Nullable String sendingPoolName;
        private @Nullable String tlsPolicy;
        public Builder() {}
        public Builder(ConfigurationSetDeliveryOptions defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.maxDeliverySeconds = defaults.maxDeliverySeconds;
    	      this.sendingPoolName = defaults.sendingPoolName;
    	      this.tlsPolicy = defaults.tlsPolicy;
        }

        @CustomType.Setter
        public Builder maxDeliverySeconds(@Nullable Integer maxDeliverySeconds) {

            this.maxDeliverySeconds = maxDeliverySeconds;
            return this;
        }
        @CustomType.Setter
        public Builder sendingPoolName(@Nullable String sendingPoolName) {

            this.sendingPoolName = sendingPoolName;
            return this;
        }
        @CustomType.Setter
        public Builder tlsPolicy(@Nullable String tlsPolicy) {

            this.tlsPolicy = tlsPolicy;
            return this;
        }
        public ConfigurationSetDeliveryOptions build() {
            final var _resultValue = new ConfigurationSetDeliveryOptions();
            _resultValue.maxDeliverySeconds = maxDeliverySeconds;
            _resultValue.sendingPoolName = sendingPoolName;
            _resultValue.tlsPolicy = tlsPolicy;
            return _resultValue;
        }
    }
}
