// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetIndexUserTokenConfigurationJwtTokenTypeConfiguration {
    /**
     * @return Regular expression that identifies the claim.
     * 
     */
    private String claimRegex;
    /**
     * @return The group attribute field.
     * 
     */
    private String groupAttributeField;
    /**
     * @return Issuer of the token.
     * 
     */
    private String issuer;
    /**
     * @return Location of the key. Valid values are `URL` or `SECRET_MANAGER`
     * 
     */
    private String keyLocation;
    /**
     * @return ARN of the secret.
     * 
     */
    private String secretsManagerArn;
    /**
     * @return Signing key URL.
     * 
     */
    private String url;
    /**
     * @return The user name attribute field.
     * 
     */
    private String userNameAttributeField;

    private GetIndexUserTokenConfigurationJwtTokenTypeConfiguration() {}
    /**
     * @return Regular expression that identifies the claim.
     * 
     */
    public String claimRegex() {
        return this.claimRegex;
    }
    /**
     * @return The group attribute field.
     * 
     */
    public String groupAttributeField() {
        return this.groupAttributeField;
    }
    /**
     * @return Issuer of the token.
     * 
     */
    public String issuer() {
        return this.issuer;
    }
    /**
     * @return Location of the key. Valid values are `URL` or `SECRET_MANAGER`
     * 
     */
    public String keyLocation() {
        return this.keyLocation;
    }
    /**
     * @return ARN of the secret.
     * 
     */
    public String secretsManagerArn() {
        return this.secretsManagerArn;
    }
    /**
     * @return Signing key URL.
     * 
     */
    public String url() {
        return this.url;
    }
    /**
     * @return The user name attribute field.
     * 
     */
    public String userNameAttributeField() {
        return this.userNameAttributeField;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetIndexUserTokenConfigurationJwtTokenTypeConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String claimRegex;
        private String groupAttributeField;
        private String issuer;
        private String keyLocation;
        private String secretsManagerArn;
        private String url;
        private String userNameAttributeField;
        public Builder() {}
        public Builder(GetIndexUserTokenConfigurationJwtTokenTypeConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.claimRegex = defaults.claimRegex;
    	      this.groupAttributeField = defaults.groupAttributeField;
    	      this.issuer = defaults.issuer;
    	      this.keyLocation = defaults.keyLocation;
    	      this.secretsManagerArn = defaults.secretsManagerArn;
    	      this.url = defaults.url;
    	      this.userNameAttributeField = defaults.userNameAttributeField;
        }

        @CustomType.Setter
        public Builder claimRegex(String claimRegex) {
            if (claimRegex == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfigurationJwtTokenTypeConfiguration", "claimRegex");
            }
            this.claimRegex = claimRegex;
            return this;
        }
        @CustomType.Setter
        public Builder groupAttributeField(String groupAttributeField) {
            if (groupAttributeField == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfigurationJwtTokenTypeConfiguration", "groupAttributeField");
            }
            this.groupAttributeField = groupAttributeField;
            return this;
        }
        @CustomType.Setter
        public Builder issuer(String issuer) {
            if (issuer == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfigurationJwtTokenTypeConfiguration", "issuer");
            }
            this.issuer = issuer;
            return this;
        }
        @CustomType.Setter
        public Builder keyLocation(String keyLocation) {
            if (keyLocation == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfigurationJwtTokenTypeConfiguration", "keyLocation");
            }
            this.keyLocation = keyLocation;
            return this;
        }
        @CustomType.Setter
        public Builder secretsManagerArn(String secretsManagerArn) {
            if (secretsManagerArn == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfigurationJwtTokenTypeConfiguration", "secretsManagerArn");
            }
            this.secretsManagerArn = secretsManagerArn;
            return this;
        }
        @CustomType.Setter
        public Builder url(String url) {
            if (url == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfigurationJwtTokenTypeConfiguration", "url");
            }
            this.url = url;
            return this;
        }
        @CustomType.Setter
        public Builder userNameAttributeField(String userNameAttributeField) {
            if (userNameAttributeField == null) {
              throw new MissingRequiredPropertyException("GetIndexUserTokenConfigurationJwtTokenTypeConfiguration", "userNameAttributeField");
            }
            this.userNameAttributeField = userNameAttributeField;
            return this;
        }
        public GetIndexUserTokenConfigurationJwtTokenTypeConfiguration build() {
            final var _resultValue = new GetIndexUserTokenConfigurationJwtTokenTypeConfiguration();
            _resultValue.claimRegex = claimRegex;
            _resultValue.groupAttributeField = groupAttributeField;
            _resultValue.issuer = issuer;
            _resultValue.keyLocation = keyLocation;
            _resultValue.secretsManagerArn = secretsManagerArn;
            _resultValue.url = url;
            _resultValue.userNameAttributeField = userNameAttributeField;
            return _resultValue;
        }
    }
}
