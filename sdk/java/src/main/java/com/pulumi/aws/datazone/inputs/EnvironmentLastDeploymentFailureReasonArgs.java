// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.datazone.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class EnvironmentLastDeploymentFailureReasonArgs extends com.pulumi.resources.ResourceArgs {

    public static final EnvironmentLastDeploymentFailureReasonArgs Empty = new EnvironmentLastDeploymentFailureReasonArgs();

    @Import(name="code", required=true)
    private Output<String> code;

    public Output<String> code() {
        return this.code;
    }

    @Import(name="message", required=true)
    private Output<String> message;

    public Output<String> message() {
        return this.message;
    }

    private EnvironmentLastDeploymentFailureReasonArgs() {}

    private EnvironmentLastDeploymentFailureReasonArgs(EnvironmentLastDeploymentFailureReasonArgs $) {
        this.code = $.code;
        this.message = $.message;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EnvironmentLastDeploymentFailureReasonArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EnvironmentLastDeploymentFailureReasonArgs $;

        public Builder() {
            $ = new EnvironmentLastDeploymentFailureReasonArgs();
        }

        public Builder(EnvironmentLastDeploymentFailureReasonArgs defaults) {
            $ = new EnvironmentLastDeploymentFailureReasonArgs(Objects.requireNonNull(defaults));
        }

        public Builder code(Output<String> code) {
            $.code = code;
            return this;
        }

        public Builder code(String code) {
            return code(Output.of(code));
        }

        public Builder message(Output<String> message) {
            $.message = message;
            return this;
        }

        public Builder message(String message) {
            return message(Output.of(message));
        }

        public EnvironmentLastDeploymentFailureReasonArgs build() {
            if ($.code == null) {
                throw new MissingRequiredPropertyException("EnvironmentLastDeploymentFailureReasonArgs", "code");
            }
            if ($.message == null) {
                throw new MissingRequiredPropertyException("EnvironmentLastDeploymentFailureReasonArgs", "message");
            }
            return $;
        }
    }

}
