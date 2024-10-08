// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedpermissions.inputs;

import com.pulumi.aws.verifiedpermissions.inputs.IdentitySourceConfigurationCognitoUserPoolConfigurationArgs;
import com.pulumi.aws.verifiedpermissions.inputs.IdentitySourceConfigurationOpenIdConnectConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class IdentitySourceConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final IdentitySourceConfigurationArgs Empty = new IdentitySourceConfigurationArgs();

    /**
     * Specifies the configuration details of an Amazon Cognito user pool that Verified Permissions can use as a source of authenticated identities as entities. See Cognito User Pool Configuration below.
     * 
     */
    @Import(name="cognitoUserPoolConfiguration")
    private @Nullable Output<IdentitySourceConfigurationCognitoUserPoolConfigurationArgs> cognitoUserPoolConfiguration;

    /**
     * @return Specifies the configuration details of an Amazon Cognito user pool that Verified Permissions can use as a source of authenticated identities as entities. See Cognito User Pool Configuration below.
     * 
     */
    public Optional<Output<IdentitySourceConfigurationCognitoUserPoolConfigurationArgs>> cognitoUserPoolConfiguration() {
        return Optional.ofNullable(this.cognitoUserPoolConfiguration);
    }

    /**
     * Specifies the configuration details of an OpenID Connect (OIDC) identity provider, or identity source, that Verified Permissions can use to generate entities from authenticated identities. See Open ID Connect Configuration below.
     * 
     */
    @Import(name="openIdConnectConfiguration")
    private @Nullable Output<IdentitySourceConfigurationOpenIdConnectConfigurationArgs> openIdConnectConfiguration;

    /**
     * @return Specifies the configuration details of an OpenID Connect (OIDC) identity provider, or identity source, that Verified Permissions can use to generate entities from authenticated identities. See Open ID Connect Configuration below.
     * 
     */
    public Optional<Output<IdentitySourceConfigurationOpenIdConnectConfigurationArgs>> openIdConnectConfiguration() {
        return Optional.ofNullable(this.openIdConnectConfiguration);
    }

    private IdentitySourceConfigurationArgs() {}

    private IdentitySourceConfigurationArgs(IdentitySourceConfigurationArgs $) {
        this.cognitoUserPoolConfiguration = $.cognitoUserPoolConfiguration;
        this.openIdConnectConfiguration = $.openIdConnectConfiguration;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(IdentitySourceConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private IdentitySourceConfigurationArgs $;

        public Builder() {
            $ = new IdentitySourceConfigurationArgs();
        }

        public Builder(IdentitySourceConfigurationArgs defaults) {
            $ = new IdentitySourceConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cognitoUserPoolConfiguration Specifies the configuration details of an Amazon Cognito user pool that Verified Permissions can use as a source of authenticated identities as entities. See Cognito User Pool Configuration below.
         * 
         * @return builder
         * 
         */
        public Builder cognitoUserPoolConfiguration(@Nullable Output<IdentitySourceConfigurationCognitoUserPoolConfigurationArgs> cognitoUserPoolConfiguration) {
            $.cognitoUserPoolConfiguration = cognitoUserPoolConfiguration;
            return this;
        }

        /**
         * @param cognitoUserPoolConfiguration Specifies the configuration details of an Amazon Cognito user pool that Verified Permissions can use as a source of authenticated identities as entities. See Cognito User Pool Configuration below.
         * 
         * @return builder
         * 
         */
        public Builder cognitoUserPoolConfiguration(IdentitySourceConfigurationCognitoUserPoolConfigurationArgs cognitoUserPoolConfiguration) {
            return cognitoUserPoolConfiguration(Output.of(cognitoUserPoolConfiguration));
        }

        /**
         * @param openIdConnectConfiguration Specifies the configuration details of an OpenID Connect (OIDC) identity provider, or identity source, that Verified Permissions can use to generate entities from authenticated identities. See Open ID Connect Configuration below.
         * 
         * @return builder
         * 
         */
        public Builder openIdConnectConfiguration(@Nullable Output<IdentitySourceConfigurationOpenIdConnectConfigurationArgs> openIdConnectConfiguration) {
            $.openIdConnectConfiguration = openIdConnectConfiguration;
            return this;
        }

        /**
         * @param openIdConnectConfiguration Specifies the configuration details of an OpenID Connect (OIDC) identity provider, or identity source, that Verified Permissions can use to generate entities from authenticated identities. See Open ID Connect Configuration below.
         * 
         * @return builder
         * 
         */
        public Builder openIdConnectConfiguration(IdentitySourceConfigurationOpenIdConnectConfigurationArgs openIdConnectConfiguration) {
            return openIdConnectConfiguration(Output.of(openIdConnectConfiguration));
        }

        public IdentitySourceConfigurationArgs build() {
            return $;
        }
    }

}
