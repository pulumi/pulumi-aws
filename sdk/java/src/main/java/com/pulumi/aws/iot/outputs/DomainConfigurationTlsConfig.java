// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DomainConfigurationTlsConfig {
    /**
     * @return The security policy for a domain configuration.
     * 
     */
    private @Nullable String securityPolicy;

    private DomainConfigurationTlsConfig() {}
    /**
     * @return The security policy for a domain configuration.
     * 
     */
    public Optional<String> securityPolicy() {
        return Optional.ofNullable(this.securityPolicy);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DomainConfigurationTlsConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String securityPolicy;
        public Builder() {}
        public Builder(DomainConfigurationTlsConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.securityPolicy = defaults.securityPolicy;
        }

        @CustomType.Setter
        public Builder securityPolicy(@Nullable String securityPolicy) {

            this.securityPolicy = securityPolicy;
            return this;
        }
        public DomainConfigurationTlsConfig build() {
            final var _resultValue = new DomainConfigurationTlsConfig();
            _resultValue.securityPolicy = securityPolicy;
            return _resultValue;
        }
    }
}
