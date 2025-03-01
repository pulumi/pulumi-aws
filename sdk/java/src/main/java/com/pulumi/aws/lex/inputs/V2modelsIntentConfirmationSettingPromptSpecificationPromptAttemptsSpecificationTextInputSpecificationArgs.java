// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;


public final class V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs Empty = new V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs();

    /**
     * Time for which a bot waits before re-prompting a customer for text input.
     * 
     */
    @Import(name="startTimeoutMs", required=true)
    private Output<Integer> startTimeoutMs;

    /**
     * @return Time for which a bot waits before re-prompting a customer for text input.
     * 
     */
    public Output<Integer> startTimeoutMs() {
        return this.startTimeoutMs;
    }

    private V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs() {}

    private V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs(V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs $) {
        this.startTimeoutMs = $.startTimeoutMs;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs $;

        public Builder() {
            $ = new V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs();
        }

        public Builder(V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs defaults) {
            $ = new V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param startTimeoutMs Time for which a bot waits before re-prompting a customer for text input.
         * 
         * @return builder
         * 
         */
        public Builder startTimeoutMs(Output<Integer> startTimeoutMs) {
            $.startTimeoutMs = startTimeoutMs;
            return this;
        }

        /**
         * @param startTimeoutMs Time for which a bot waits before re-prompting a customer for text input.
         * 
         * @return builder
         * 
         */
        public Builder startTimeoutMs(Integer startTimeoutMs) {
            return startTimeoutMs(Output.of(startTimeoutMs));
        }

        public V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs build() {
            if ($.startTimeoutMs == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs", "startTimeoutMs");
            }
            return $;
        }
    }

}
