// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appflow.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs extends com.pulumi.resources.ResourceArgs {

    public static final ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs Empty = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs();

    @Import(name="instanceUrl", required=true)
    private Output<String> instanceUrl;

    public Output<String> instanceUrl() {
        return this.instanceUrl;
    }

    private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs() {}

    private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs $) {
        this.instanceUrl = $.instanceUrl;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs $;

        public Builder() {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs();
        }

        public Builder(ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs defaults) {
            $ = new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs(Objects.requireNonNull(defaults));
        }

        public Builder instanceUrl(Output<String> instanceUrl) {
            $.instanceUrl = instanceUrl;
            return this;
        }

        public Builder instanceUrl(String instanceUrl) {
            return instanceUrl(Output.of(instanceUrl));
        }

        public ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs build() {
            if ($.instanceUrl == null) {
                throw new MissingRequiredPropertyException("ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesMarketoArgs", "instanceUrl");
            }
            return $;
        }
    }

}
