// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedpermissions.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfiguration {
    /**
     * @return The token claim that you want Verified Permissions to interpret as group membership. For example, `groups`.
     * 
     */
    private String groupClaim;
    /**
     * @return The name of the schema entity type that&#39;s mapped to the user pool group. Defaults to `AWS::CognitoGroup`.
     * 
     */
    private String groupEntityType;

    private IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfiguration() {}
    /**
     * @return The token claim that you want Verified Permissions to interpret as group membership. For example, `groups`.
     * 
     */
    public String groupClaim() {
        return this.groupClaim;
    }
    /**
     * @return The name of the schema entity type that&#39;s mapped to the user pool group. Defaults to `AWS::CognitoGroup`.
     * 
     */
    public String groupEntityType() {
        return this.groupEntityType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String groupClaim;
        private String groupEntityType;
        public Builder() {}
        public Builder(IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.groupClaim = defaults.groupClaim;
    	      this.groupEntityType = defaults.groupEntityType;
        }

        @CustomType.Setter
        public Builder groupClaim(String groupClaim) {
            if (groupClaim == null) {
              throw new MissingRequiredPropertyException("IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfiguration", "groupClaim");
            }
            this.groupClaim = groupClaim;
            return this;
        }
        @CustomType.Setter
        public Builder groupEntityType(String groupEntityType) {
            if (groupEntityType == null) {
              throw new MissingRequiredPropertyException("IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfiguration", "groupEntityType");
            }
            this.groupEntityType = groupEntityType;
            return this;
        }
        public IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfiguration build() {
            final var _resultValue = new IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfiguration();
            _resultValue.groupClaim = groupClaim;
            _resultValue.groupEntityType = groupEntityType;
            return _resultValue;
        }
    }
}
