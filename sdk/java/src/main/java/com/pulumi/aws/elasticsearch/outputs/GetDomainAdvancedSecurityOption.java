// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.elasticsearch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.util.Objects;

@CustomType
public final class GetDomainAdvancedSecurityOption {
    /**
     * @return Whether node to node encryption is enabled.
     * 
     */
    private Boolean enabled;
    /**
     * @return Whether the internal user database is enabled.
     * 
     */
    private Boolean internalUserDatabaseEnabled;

    private GetDomainAdvancedSecurityOption() {}
    /**
     * @return Whether node to node encryption is enabled.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }
    /**
     * @return Whether the internal user database is enabled.
     * 
     */
    public Boolean internalUserDatabaseEnabled() {
        return this.internalUserDatabaseEnabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDomainAdvancedSecurityOption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean enabled;
        private Boolean internalUserDatabaseEnabled;
        public Builder() {}
        public Builder(GetDomainAdvancedSecurityOption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
    	      this.internalUserDatabaseEnabled = defaults.internalUserDatabaseEnabled;
        }

        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("GetDomainAdvancedSecurityOption", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder internalUserDatabaseEnabled(Boolean internalUserDatabaseEnabled) {
            if (internalUserDatabaseEnabled == null) {
              throw new MissingRequiredPropertyException("GetDomainAdvancedSecurityOption", "internalUserDatabaseEnabled");
            }
            this.internalUserDatabaseEnabled = internalUserDatabaseEnabled;
            return this;
        }
        public GetDomainAdvancedSecurityOption build() {
            final var _resultValue = new GetDomainAdvancedSecurityOption();
            _resultValue.enabled = enabled;
            _resultValue.internalUserDatabaseEnabled = internalUserDatabaseEnabled;
            return _resultValue;
        }
    }
}
