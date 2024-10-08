// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs Empty = new V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs();

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

    private V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs() {}

    private V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs(V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs $) {
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs $;

        public Builder() {
            $ = new V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs();
        }

        public Builder(V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs defaults) {
            $ = new V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs(Objects.requireNonNull(defaults));
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

        public V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs build() {
            if ($.value == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationPlainTextMessageArgs", "value");
            }
            return $;
        }
    }

}
