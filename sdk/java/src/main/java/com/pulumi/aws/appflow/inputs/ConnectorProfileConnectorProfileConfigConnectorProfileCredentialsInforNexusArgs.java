// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appflow.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs extends com.pulumi.resources.ResourceArgs {

    public static final ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs Empty = new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs();

    @Import(name="accessKeyId", required=true)
    private Output<String> accessKeyId;

    public Output<String> accessKeyId() {
        return this.accessKeyId;
    }

    @Import(name="datakey", required=true)
    private Output<String> datakey;

    public Output<String> datakey() {
        return this.datakey;
    }

    @Import(name="secretAccessKey", required=true)
    private Output<String> secretAccessKey;

    public Output<String> secretAccessKey() {
        return this.secretAccessKey;
    }

    @Import(name="userId", required=true)
    private Output<String> userId;

    public Output<String> userId() {
        return this.userId;
    }

    private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs() {}

    private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs(ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs $) {
        this.accessKeyId = $.accessKeyId;
        this.datakey = $.datakey;
        this.secretAccessKey = $.secretAccessKey;
        this.userId = $.userId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs $;

        public Builder() {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs();
        }

        public Builder(ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs defaults) {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs(Objects.requireNonNull(defaults));
        }

        public Builder accessKeyId(Output<String> accessKeyId) {
            $.accessKeyId = accessKeyId;
            return this;
        }

        public Builder accessKeyId(String accessKeyId) {
            return accessKeyId(Output.of(accessKeyId));
        }

        public Builder datakey(Output<String> datakey) {
            $.datakey = datakey;
            return this;
        }

        public Builder datakey(String datakey) {
            return datakey(Output.of(datakey));
        }

        public Builder secretAccessKey(Output<String> secretAccessKey) {
            $.secretAccessKey = secretAccessKey;
            return this;
        }

        public Builder secretAccessKey(String secretAccessKey) {
            return secretAccessKey(Output.of(secretAccessKey));
        }

        public Builder userId(Output<String> userId) {
            $.userId = userId;
            return this;
        }

        public Builder userId(String userId) {
            return userId(Output.of(userId));
        }

        public ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs build() {
            if ($.accessKeyId == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs", "accessKeyId");
            }
            if ($.datakey == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs", "datakey");
            }
            if ($.secretAccessKey == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs", "secretAccessKey");
            }
            if ($.userId == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsInforNexusArgs", "userId");
            }
            return $;
        }
    }

}
