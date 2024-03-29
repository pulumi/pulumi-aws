// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class WorkforceOidcConfig {
    /**
     * @return The OIDC IdP authorization endpoint used to configure your private workforce.
     * 
     */
    private String authorizationEndpoint;
    /**
     * @return The OIDC IdP client ID used to configure your private workforce.
     * 
     */
    private String clientId;
    /**
     * @return The OIDC IdP client secret used to configure your private workforce.
     * 
     */
    private String clientSecret;
    /**
     * @return The OIDC IdP issuer used to configure your private workforce.
     * 
     */
    private String issuer;
    /**
     * @return The OIDC IdP JSON Web Key Set (Jwks) URI used to configure your private workforce.
     * 
     */
    private String jwksUri;
    /**
     * @return The OIDC IdP logout endpoint used to configure your private workforce.
     * 
     */
    private String logoutEndpoint;
    /**
     * @return The OIDC IdP token endpoint used to configure your private workforce.
     * 
     */
    private String tokenEndpoint;
    /**
     * @return The OIDC IdP user information endpoint used to configure your private workforce.
     * 
     */
    private String userInfoEndpoint;

    private WorkforceOidcConfig() {}
    /**
     * @return The OIDC IdP authorization endpoint used to configure your private workforce.
     * 
     */
    public String authorizationEndpoint() {
        return this.authorizationEndpoint;
    }
    /**
     * @return The OIDC IdP client ID used to configure your private workforce.
     * 
     */
    public String clientId() {
        return this.clientId;
    }
    /**
     * @return The OIDC IdP client secret used to configure your private workforce.
     * 
     */
    public String clientSecret() {
        return this.clientSecret;
    }
    /**
     * @return The OIDC IdP issuer used to configure your private workforce.
     * 
     */
    public String issuer() {
        return this.issuer;
    }
    /**
     * @return The OIDC IdP JSON Web Key Set (Jwks) URI used to configure your private workforce.
     * 
     */
    public String jwksUri() {
        return this.jwksUri;
    }
    /**
     * @return The OIDC IdP logout endpoint used to configure your private workforce.
     * 
     */
    public String logoutEndpoint() {
        return this.logoutEndpoint;
    }
    /**
     * @return The OIDC IdP token endpoint used to configure your private workforce.
     * 
     */
    public String tokenEndpoint() {
        return this.tokenEndpoint;
    }
    /**
     * @return The OIDC IdP user information endpoint used to configure your private workforce.
     * 
     */
    public String userInfoEndpoint() {
        return this.userInfoEndpoint;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WorkforceOidcConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String authorizationEndpoint;
        private String clientId;
        private String clientSecret;
        private String issuer;
        private String jwksUri;
        private String logoutEndpoint;
        private String tokenEndpoint;
        private String userInfoEndpoint;
        public Builder() {}
        public Builder(WorkforceOidcConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.authorizationEndpoint = defaults.authorizationEndpoint;
    	      this.clientId = defaults.clientId;
    	      this.clientSecret = defaults.clientSecret;
    	      this.issuer = defaults.issuer;
    	      this.jwksUri = defaults.jwksUri;
    	      this.logoutEndpoint = defaults.logoutEndpoint;
    	      this.tokenEndpoint = defaults.tokenEndpoint;
    	      this.userInfoEndpoint = defaults.userInfoEndpoint;
        }

        @CustomType.Setter
        public Builder authorizationEndpoint(String authorizationEndpoint) {
            if (authorizationEndpoint == null) {
              throw new MissingRequiredPropertyException("WorkforceOidcConfig", "authorizationEndpoint");
            }
            this.authorizationEndpoint = authorizationEndpoint;
            return this;
        }
        @CustomType.Setter
        public Builder clientId(String clientId) {
            if (clientId == null) {
              throw new MissingRequiredPropertyException("WorkforceOidcConfig", "clientId");
            }
            this.clientId = clientId;
            return this;
        }
        @CustomType.Setter
        public Builder clientSecret(String clientSecret) {
            if (clientSecret == null) {
              throw new MissingRequiredPropertyException("WorkforceOidcConfig", "clientSecret");
            }
            this.clientSecret = clientSecret;
            return this;
        }
        @CustomType.Setter
        public Builder issuer(String issuer) {
            if (issuer == null) {
              throw new MissingRequiredPropertyException("WorkforceOidcConfig", "issuer");
            }
            this.issuer = issuer;
            return this;
        }
        @CustomType.Setter
        public Builder jwksUri(String jwksUri) {
            if (jwksUri == null) {
              throw new MissingRequiredPropertyException("WorkforceOidcConfig", "jwksUri");
            }
            this.jwksUri = jwksUri;
            return this;
        }
        @CustomType.Setter
        public Builder logoutEndpoint(String logoutEndpoint) {
            if (logoutEndpoint == null) {
              throw new MissingRequiredPropertyException("WorkforceOidcConfig", "logoutEndpoint");
            }
            this.logoutEndpoint = logoutEndpoint;
            return this;
        }
        @CustomType.Setter
        public Builder tokenEndpoint(String tokenEndpoint) {
            if (tokenEndpoint == null) {
              throw new MissingRequiredPropertyException("WorkforceOidcConfig", "tokenEndpoint");
            }
            this.tokenEndpoint = tokenEndpoint;
            return this;
        }
        @CustomType.Setter
        public Builder userInfoEndpoint(String userInfoEndpoint) {
            if (userInfoEndpoint == null) {
              throw new MissingRequiredPropertyException("WorkforceOidcConfig", "userInfoEndpoint");
            }
            this.userInfoEndpoint = userInfoEndpoint;
            return this;
        }
        public WorkforceOidcConfig build() {
            final var _resultValue = new WorkforceOidcConfig();
            _resultValue.authorizationEndpoint = authorizationEndpoint;
            _resultValue.clientId = clientId;
            _resultValue.clientSecret = clientSecret;
            _resultValue.issuer = issuer;
            _resultValue.jwksUri = jwksUri;
            _resultValue.logoutEndpoint = logoutEndpoint;
            _resultValue.tokenEndpoint = tokenEndpoint;
            _resultValue.userInfoEndpoint = userInfoEndpoint;
            return _resultValue;
        }
    }
}
