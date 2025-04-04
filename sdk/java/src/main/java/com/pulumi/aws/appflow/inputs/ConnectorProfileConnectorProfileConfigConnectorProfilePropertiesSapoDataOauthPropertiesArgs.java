// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appflow.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs extends com.pulumi.resources.ResourceArgs {

    public static final ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs Empty = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs();

    /**
     * The authorization code url required to redirect to SAP Login Page to fetch authorization code for OAuth type authentication.
     * 
     */
    @Import(name="authCodeUrl", required=true)
    private Output<String> authCodeUrl;

    /**
     * @return The authorization code url required to redirect to SAP Login Page to fetch authorization code for OAuth type authentication.
     * 
     */
    public Output<String> authCodeUrl() {
        return this.authCodeUrl;
    }

    /**
     * The OAuth scopes required for OAuth type authentication.
     * 
     */
    @Import(name="oauthScopes", required=true)
    private Output<List<String>> oauthScopes;

    /**
     * @return The OAuth scopes required for OAuth type authentication.
     * 
     */
    public Output<List<String>> oauthScopes() {
        return this.oauthScopes;
    }

    @Import(name="tokenUrl", required=true)
    private Output<String> tokenUrl;

    public Output<String> tokenUrl() {
        return this.tokenUrl;
    }

    private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs() {}

    private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs $) {
        this.authCodeUrl = $.authCodeUrl;
        this.oauthScopes = $.oauthScopes;
        this.tokenUrl = $.tokenUrl;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs $;

        public Builder() {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs();
        }

        public Builder(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs defaults) {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param authCodeUrl The authorization code url required to redirect to SAP Login Page to fetch authorization code for OAuth type authentication.
         * 
         * @return builder
         * 
         */
        public Builder authCodeUrl(Output<String> authCodeUrl) {
            $.authCodeUrl = authCodeUrl;
            return this;
        }

        /**
         * @param authCodeUrl The authorization code url required to redirect to SAP Login Page to fetch authorization code for OAuth type authentication.
         * 
         * @return builder
         * 
         */
        public Builder authCodeUrl(String authCodeUrl) {
            return authCodeUrl(Output.of(authCodeUrl));
        }

        /**
         * @param oauthScopes The OAuth scopes required for OAuth type authentication.
         * 
         * @return builder
         * 
         */
        public Builder oauthScopes(Output<List<String>> oauthScopes) {
            $.oauthScopes = oauthScopes;
            return this;
        }

        /**
         * @param oauthScopes The OAuth scopes required for OAuth type authentication.
         * 
         * @return builder
         * 
         */
        public Builder oauthScopes(List<String> oauthScopes) {
            return oauthScopes(Output.of(oauthScopes));
        }

        /**
         * @param oauthScopes The OAuth scopes required for OAuth type authentication.
         * 
         * @return builder
         * 
         */
        public Builder oauthScopes(String... oauthScopes) {
            return oauthScopes(List.of(oauthScopes));
        }

        public Builder tokenUrl(Output<String> tokenUrl) {
            $.tokenUrl = tokenUrl;
            return this;
        }

        public Builder tokenUrl(String tokenUrl) {
            return tokenUrl(Output.of(tokenUrl));
        }

        public ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs build() {
            if ($.authCodeUrl == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs", "authCodeUrl");
            }
            if ($.oauthScopes == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs", "oauthScopes");
            }
            if ($.tokenUrl == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs", "tokenUrl");
            }
            return $;
        }
    }

}
