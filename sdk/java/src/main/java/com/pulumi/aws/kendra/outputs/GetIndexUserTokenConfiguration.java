// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.outputs;

import com.pulumi.aws.kendra.outputs.GetIndexUserTokenConfigurationJsonTokenTypeConfiguration;
import com.pulumi.aws.kendra.outputs.GetIndexUserTokenConfigurationJwtTokenTypeConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetIndexUserTokenConfiguration {
    /**
     * @return A block that specifies the information about the JSON token type configuration.
     * 
     */
    private List<GetIndexUserTokenConfigurationJsonTokenTypeConfiguration> jsonTokenTypeConfigurations;
    /**
     * @return A block that specifies the information about the JWT token type configuration.
     * 
     */
    private List<GetIndexUserTokenConfigurationJwtTokenTypeConfiguration> jwtTokenTypeConfigurations;

    private GetIndexUserTokenConfiguration() {}
    /**
     * @return A block that specifies the information about the JSON token type configuration.
     * 
     */
    public List<GetIndexUserTokenConfigurationJsonTokenTypeConfiguration> jsonTokenTypeConfigurations() {
        return this.jsonTokenTypeConfigurations;
    }
    /**
     * @return A block that specifies the information about the JWT token type configuration.
     * 
     */
    public List<GetIndexUserTokenConfigurationJwtTokenTypeConfiguration> jwtTokenTypeConfigurations() {
        return this.jwtTokenTypeConfigurations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetIndexUserTokenConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetIndexUserTokenConfigurationJsonTokenTypeConfiguration> jsonTokenTypeConfigurations;
        private List<GetIndexUserTokenConfigurationJwtTokenTypeConfiguration> jwtTokenTypeConfigurations;
        public Builder() {}
        public Builder(GetIndexUserTokenConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.jsonTokenTypeConfigurations = defaults.jsonTokenTypeConfigurations;
    	      this.jwtTokenTypeConfigurations = defaults.jwtTokenTypeConfigurations;
        }

        @CustomType.Setter
        public Builder jsonTokenTypeConfigurations(List<GetIndexUserTokenConfigurationJsonTokenTypeConfiguration> jsonTokenTypeConfigurations) {
            if (jsonTokenTypeConfigurations == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfiguration", "jsonTokenTypeConfigurations");
            }
            this.jsonTokenTypeConfigurations = jsonTokenTypeConfigurations;
            return this;
        }
        public Builder jsonTokenTypeConfigurations(GetIndexUserTokenConfigurationJsonTokenTypeConfiguration... jsonTokenTypeConfigurations) {
            return jsonTokenTypeConfigurations(List.of(jsonTokenTypeConfigurations));
        }
        @CustomType.Setter
        public Builder jwtTokenTypeConfigurations(List<GetIndexUserTokenConfigurationJwtTokenTypeConfiguration> jwtTokenTypeConfigurations) {
            if (jwtTokenTypeConfigurations == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfiguration", "jwtTokenTypeConfigurations");
            }
            this.jwtTokenTypeConfigurations = jwtTokenTypeConfigurations;
            return this;
        }
        public Builder jwtTokenTypeConfigurations(GetIndexUserTokenConfigurationJwtTokenTypeConfiguration... jwtTokenTypeConfigurations) {
            return jwtTokenTypeConfigurations(List.of(jwtTokenTypeConfigurations));
        }
        public GetIndexUserTokenConfiguration build() {
            final var _resultValue = new GetIndexUserTokenConfiguration();
            _resultValue.jsonTokenTypeConfigurations = jsonTokenTypeConfigurations;
            _resultValue.jwtTokenTypeConfigurations = jwtTokenTypeConfigurations;
            return _resultValue;
        }
    }
}
