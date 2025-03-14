// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appflow.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs extends com.pulumi.resources.ResourceArgs {

    public static final ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs Empty = new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs();

    @Import(name="apiKey", required=true)
    private Output<String> apiKey;

    public Output<String> apiKey() {
        return this.apiKey;
    }

    /**
     * The Secret Access Key portion of the credentials.
     * 
     */
    @Import(name="secretKey", required=true)
    private Output<String> secretKey;

    /**
     * @return The Secret Access Key portion of the credentials.
     * 
     */
    public Output<String> secretKey() {
        return this.secretKey;
    }

    private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs() {}

    private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs(ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs $) {
        this.apiKey = $.apiKey;
        this.secretKey = $.secretKey;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs $;

        public Builder() {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs();
        }

        public Builder(ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs defaults) {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs(Objects.requireNonNull(defaults));
        }

        public Builder apiKey(Output<String> apiKey) {
            $.apiKey = apiKey;
            return this;
        }

        public Builder apiKey(String apiKey) {
            return apiKey(Output.of(apiKey));
        }

        /**
         * @param secretKey The Secret Access Key portion of the credentials.
         * 
         * @return builder
         * 
         */
        public Builder secretKey(Output<String> secretKey) {
            $.secretKey = secretKey;
            return this;
        }

        /**
         * @param secretKey The Secret Access Key portion of the credentials.
         * 
         * @return builder
         * 
         */
        public Builder secretKey(String secretKey) {
            return secretKey(Output.of(secretKey));
        }

        public ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs build() {
            if ($.apiKey == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs", "apiKey");
            }
            if ($.secretKey == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs", "secretKey");
            }
            return $;
        }
    }

}
