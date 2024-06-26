// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetProxyAuth {
    private String authScheme;
    private String clientPasswordAuthType;
    private String description;
    private String iamAuth;
    private String secretArn;
    private String username;

    private GetProxyAuth() {}
    public String authScheme() {
        return this.authScheme;
    }
    public String clientPasswordAuthType() {
        return this.clientPasswordAuthType;
    }
    public String description() {
        return this.description;
    }
    public String iamAuth() {
        return this.iamAuth;
    }
    public String secretArn() {
        return this.secretArn;
    }
    public String username() {
        return this.username;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetProxyAuth defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String authScheme;
        private String clientPasswordAuthType;
        private String description;
        private String iamAuth;
        private String secretArn;
        private String username;
        public Builder() {}
        public Builder(GetProxyAuth defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.authScheme = defaults.authScheme;
    	      this.clientPasswordAuthType = defaults.clientPasswordAuthType;
    	      this.description = defaults.description;
    	      this.iamAuth = defaults.iamAuth;
    	      this.secretArn = defaults.secretArn;
    	      this.username = defaults.username;
        }

        @CustomType.Setter
        public Builder authScheme(String authScheme) {
            if (authScheme == null) {
              throw new MissingRequiredPropertyException("GetProxyAuth", "authScheme");
            }
            this.authScheme = authScheme;
            return this;
        }
        @CustomType.Setter
        public Builder clientPasswordAuthType(String clientPasswordAuthType) {
            if (clientPasswordAuthType == null) {
              throw new MissingRequiredPropertyException("GetProxyAuth", "clientPasswordAuthType");
            }
            this.clientPasswordAuthType = clientPasswordAuthType;
            return this;
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetProxyAuth", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder iamAuth(String iamAuth) {
            if (iamAuth == null) {
              throw new MissingRequiredPropertyException("GetProxyAuth", "iamAuth");
            }
            this.iamAuth = iamAuth;
            return this;
        }
        @CustomType.Setter
        public Builder secretArn(String secretArn) {
            if (secretArn == null) {
              throw new MissingRequiredPropertyException("GetProxyAuth", "secretArn");
            }
            this.secretArn = secretArn;
            return this;
        }
        @CustomType.Setter
        public Builder username(String username) {
            if (username == null) {
              throw new MissingRequiredPropertyException("GetProxyAuth", "username");
            }
            this.username = username;
            return this;
        }
        public GetProxyAuth build() {
            final var _resultValue = new GetProxyAuth();
            _resultValue.authScheme = authScheme;
            _resultValue.clientPasswordAuthType = clientPasswordAuthType;
            _resultValue.description = description;
            _resultValue.iamAuth = iamAuth;
            _resultValue.secretArn = secretArn;
            _resultValue.username = username;
            return _resultValue;
        }
    }
}
