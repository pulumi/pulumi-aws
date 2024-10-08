// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedpermissions.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class IdentitySourceConfigurationOpenIdConnectConfigurationTokenSelectionIdentityTokenOnly {
    /**
     * @return The ID token audience, or client ID, claim values that you want to accept in your policy store from an OIDC identity provider.
     * 
     */
    private @Nullable List<String> clientIds;
    /**
     * @return The claim that determines the principal in OIDC access tokens.
     * 
     */
    private @Nullable String principalIdClaim;

    private IdentitySourceConfigurationOpenIdConnectConfigurationTokenSelectionIdentityTokenOnly() {}
    /**
     * @return The ID token audience, or client ID, claim values that you want to accept in your policy store from an OIDC identity provider.
     * 
     */
    public List<String> clientIds() {
        return this.clientIds == null ? List.of() : this.clientIds;
    }
    /**
     * @return The claim that determines the principal in OIDC access tokens.
     * 
     */
    public Optional<String> principalIdClaim() {
        return Optional.ofNullable(this.principalIdClaim);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(IdentitySourceConfigurationOpenIdConnectConfigurationTokenSelectionIdentityTokenOnly defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<String> clientIds;
        private @Nullable String principalIdClaim;
        public Builder() {}
        public Builder(IdentitySourceConfigurationOpenIdConnectConfigurationTokenSelectionIdentityTokenOnly defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.clientIds = defaults.clientIds;
    	      this.principalIdClaim = defaults.principalIdClaim;
        }

        @CustomType.Setter
        public Builder clientIds(@Nullable List<String> clientIds) {

            this.clientIds = clientIds;
            return this;
        }
        public Builder clientIds(String... clientIds) {
            return clientIds(List.of(clientIds));
        }
        @CustomType.Setter
        public Builder principalIdClaim(@Nullable String principalIdClaim) {

            this.principalIdClaim = principalIdClaim;
            return this;
        }
        public IdentitySourceConfigurationOpenIdConnectConfigurationTokenSelectionIdentityTokenOnly build() {
            final var _resultValue = new IdentitySourceConfigurationOpenIdConnectConfigurationTokenSelectionIdentityTokenOnly();
            _resultValue.clientIds = clientIds;
            _resultValue.principalIdClaim = principalIdClaim;
            return _resultValue;
        }
    }
}
