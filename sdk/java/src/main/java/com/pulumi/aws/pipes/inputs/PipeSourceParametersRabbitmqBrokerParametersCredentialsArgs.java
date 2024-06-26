// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pipes.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs extends com.pulumi.resources.ResourceArgs {

    public static final PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs Empty = new PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs();

    @Import(name="basicAuth", required=true)
    private Output<String> basicAuth;

    public Output<String> basicAuth() {
        return this.basicAuth;
    }

    private PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs() {}

    private PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs(PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs $) {
        this.basicAuth = $.basicAuth;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs $;

        public Builder() {
            $ = new PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs();
        }

        public Builder(PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs defaults) {
            $ = new PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs(Objects.requireNonNull(defaults));
        }

        public Builder basicAuth(Output<String> basicAuth) {
            $.basicAuth = basicAuth;
            return this;
        }

        public Builder basicAuth(String basicAuth) {
            return basicAuth(Output.of(basicAuth));
        }

        public PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs build() {
            if ($.basicAuth == null) {
                throw new MissingRequiredPropertyException("PipeSourceParametersRabbitmqBrokerParametersCredentialsArgs", "basicAuth");
            }
            return $;
        }
    }

}
