// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs Empty = new V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs();

    /**
     * Message to send to the user.
     * 
     */
    @Import(name="value", required=true)
    private Output<String> value;

    /**
     * @return Message to send to the user.
     * 
     */
    public Output<String> value() {
        return this.value;
    }

    private V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs() {}

    private V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs(V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs $) {
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs $;

        public Builder() {
            $ = new V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs();
        }

        public Builder(V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs defaults) {
            $ = new V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param value Message to send to the user.
         * 
         * @return builder
         * 
         */
        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        /**
         * @param value Message to send to the user.
         * 
         * @return builder
         * 
         */
        public Builder value(String value) {
            return value(Output.of(value));
        }

        public V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs build() {
            if ($.value == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs", "value");
            }
            return $;
        }
    }

}
