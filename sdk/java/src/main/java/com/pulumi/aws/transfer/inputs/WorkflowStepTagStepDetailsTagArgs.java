// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.transfer.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class WorkflowStepTagStepDetailsTagArgs extends com.pulumi.resources.ResourceArgs {

    public static final WorkflowStepTagStepDetailsTagArgs Empty = new WorkflowStepTagStepDetailsTagArgs();

    @Import(name="key", required=true)
    private Output<String> key;

    public Output<String> key() {
        return this.key;
    }

    /**
     * The value that corresponds to the key.
     * 
     */
    @Import(name="value", required=true)
    private Output<String> value;

    /**
     * @return The value that corresponds to the key.
     * 
     */
    public Output<String> value() {
        return this.value;
    }

    private WorkflowStepTagStepDetailsTagArgs() {}

    private WorkflowStepTagStepDetailsTagArgs(WorkflowStepTagStepDetailsTagArgs $) {
        this.key = $.key;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WorkflowStepTagStepDetailsTagArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WorkflowStepTagStepDetailsTagArgs $;

        public Builder() {
            $ = new WorkflowStepTagStepDetailsTagArgs();
        }

        public Builder(WorkflowStepTagStepDetailsTagArgs defaults) {
            $ = new WorkflowStepTagStepDetailsTagArgs(Objects.requireNonNull(defaults));
        }

        public Builder key(Output<String> key) {
            $.key = key;
            return this;
        }

        public Builder key(String key) {
            return key(Output.of(key));
        }

        /**
         * @param value The value that corresponds to the key.
         * 
         * @return builder
         * 
         */
        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        /**
         * @param value The value that corresponds to the key.
         * 
         * @return builder
         * 
         */
        public Builder value(String value) {
            return value(Output.of(value));
        }

        public WorkflowStepTagStepDetailsTagArgs build() {
            if ($.key == null) {
                throw new MissingRequiredPropertyException("WorkflowStepTagStepDetailsTagArgs", "key");
            }
            if ($.value == null) {
                throw new MissingRequiredPropertyException("WorkflowStepTagStepDetailsTagArgs", "value");
            }
            return $;
        }
    }

}
