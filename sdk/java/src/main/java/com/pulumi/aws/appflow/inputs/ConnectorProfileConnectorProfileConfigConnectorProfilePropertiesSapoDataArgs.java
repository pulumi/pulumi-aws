// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appflow.inputs;

import com.pulumi.aws.appflow.inputs.ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs extends com.pulumi.resources.ResourceArgs {

    public static final ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs Empty = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs();

    /**
     * The location of the SAPOData resource.
     * 
     */
    @Import(name="applicationHostUrl", required=true)
    private Output<String> applicationHostUrl;

    /**
     * @return The location of the SAPOData resource.
     * 
     */
    public Output<String> applicationHostUrl() {
        return this.applicationHostUrl;
    }

    /**
     * The application path to catalog service.
     * 
     */
    @Import(name="applicationServicePath", required=true)
    private Output<String> applicationServicePath;

    /**
     * @return The application path to catalog service.
     * 
     */
    public Output<String> applicationServicePath() {
        return this.applicationServicePath;
    }

    /**
     * The client number for the client creating the connection.
     * 
     */
    @Import(name="clientNumber", required=true)
    private Output<String> clientNumber;

    /**
     * @return The client number for the client creating the connection.
     * 
     */
    public Output<String> clientNumber() {
        return this.clientNumber;
    }

    /**
     * The logon language of SAPOData instance.
     * 
     */
    @Import(name="logonLanguage")
    private @Nullable Output<String> logonLanguage;

    /**
     * @return The logon language of SAPOData instance.
     * 
     */
    public Optional<Output<String>> logonLanguage() {
        return Optional.ofNullable(this.logonLanguage);
    }

    /**
     * The SAPOData OAuth properties required for OAuth type authentication.
     * 
     */
    @Import(name="oauthProperties")
    private @Nullable Output<ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs> oauthProperties;

    /**
     * @return The SAPOData OAuth properties required for OAuth type authentication.
     * 
     */
    public Optional<Output<ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs>> oauthProperties() {
        return Optional.ofNullable(this.oauthProperties);
    }

    /**
     * The port number of the SAPOData instance.
     * 
     */
    @Import(name="portNumber", required=true)
    private Output<Integer> portNumber;

    /**
     * @return The port number of the SAPOData instance.
     * 
     */
    public Output<Integer> portNumber() {
        return this.portNumber;
    }

    @Import(name="privateLinkServiceName")
    private @Nullable Output<String> privateLinkServiceName;

    public Optional<Output<String>> privateLinkServiceName() {
        return Optional.ofNullable(this.privateLinkServiceName);
    }

    private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs() {}

    private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs $) {
        this.applicationHostUrl = $.applicationHostUrl;
        this.applicationServicePath = $.applicationServicePath;
        this.clientNumber = $.clientNumber;
        this.logonLanguage = $.logonLanguage;
        this.oauthProperties = $.oauthProperties;
        this.portNumber = $.portNumber;
        this.privateLinkServiceName = $.privateLinkServiceName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs $;

        public Builder() {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs();
        }

        public Builder(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs defaults) {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param applicationHostUrl The location of the SAPOData resource.
         * 
         * @return builder
         * 
         */
        public Builder applicationHostUrl(Output<String> applicationHostUrl) {
            $.applicationHostUrl = applicationHostUrl;
            return this;
        }

        /**
         * @param applicationHostUrl The location of the SAPOData resource.
         * 
         * @return builder
         * 
         */
        public Builder applicationHostUrl(String applicationHostUrl) {
            return applicationHostUrl(Output.of(applicationHostUrl));
        }

        /**
         * @param applicationServicePath The application path to catalog service.
         * 
         * @return builder
         * 
         */
        public Builder applicationServicePath(Output<String> applicationServicePath) {
            $.applicationServicePath = applicationServicePath;
            return this;
        }

        /**
         * @param applicationServicePath The application path to catalog service.
         * 
         * @return builder
         * 
         */
        public Builder applicationServicePath(String applicationServicePath) {
            return applicationServicePath(Output.of(applicationServicePath));
        }

        /**
         * @param clientNumber The client number for the client creating the connection.
         * 
         * @return builder
         * 
         */
        public Builder clientNumber(Output<String> clientNumber) {
            $.clientNumber = clientNumber;
            return this;
        }

        /**
         * @param clientNumber The client number for the client creating the connection.
         * 
         * @return builder
         * 
         */
        public Builder clientNumber(String clientNumber) {
            return clientNumber(Output.of(clientNumber));
        }

        /**
         * @param logonLanguage The logon language of SAPOData instance.
         * 
         * @return builder
         * 
         */
        public Builder logonLanguage(@Nullable Output<String> logonLanguage) {
            $.logonLanguage = logonLanguage;
            return this;
        }

        /**
         * @param logonLanguage The logon language of SAPOData instance.
         * 
         * @return builder
         * 
         */
        public Builder logonLanguage(String logonLanguage) {
            return logonLanguage(Output.of(logonLanguage));
        }

        /**
         * @param oauthProperties The SAPOData OAuth properties required for OAuth type authentication.
         * 
         * @return builder
         * 
         */
        public Builder oauthProperties(@Nullable Output<ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs> oauthProperties) {
            $.oauthProperties = oauthProperties;
            return this;
        }

        /**
         * @param oauthProperties The SAPOData OAuth properties required for OAuth type authentication.
         * 
         * @return builder
         * 
         */
        public Builder oauthProperties(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthPropertiesArgs oauthProperties) {
            return oauthProperties(Output.of(oauthProperties));
        }

        /**
         * @param portNumber The port number of the SAPOData instance.
         * 
         * @return builder
         * 
         */
        public Builder portNumber(Output<Integer> portNumber) {
            $.portNumber = portNumber;
            return this;
        }

        /**
         * @param portNumber The port number of the SAPOData instance.
         * 
         * @return builder
         * 
         */
        public Builder portNumber(Integer portNumber) {
            return portNumber(Output.of(portNumber));
        }

        public Builder privateLinkServiceName(@Nullable Output<String> privateLinkServiceName) {
            $.privateLinkServiceName = privateLinkServiceName;
            return this;
        }

        public Builder privateLinkServiceName(String privateLinkServiceName) {
            return privateLinkServiceName(Output.of(privateLinkServiceName));
        }

        public ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs build() {
            if ($.applicationHostUrl == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs", "applicationHostUrl");
            }
            if ($.applicationServicePath == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs", "applicationServicePath");
            }
            if ($.clientNumber == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs", "clientNumber");
            }
            if ($.portNumber == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataArgs", "portNumber");
            }
            return $;
        }
    }

}
