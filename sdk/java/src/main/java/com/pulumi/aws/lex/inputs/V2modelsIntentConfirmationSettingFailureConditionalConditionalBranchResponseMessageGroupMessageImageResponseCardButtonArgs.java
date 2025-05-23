// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs Empty = new V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs();

    /**
     * Text that appears on the button. Use this to tell the user what value is returned when they choose this button.
     * 
     */
    @Import(name="text", required=true)
    private Output<String> text;

    /**
     * @return Text that appears on the button. Use this to tell the user what value is returned when they choose this button.
     * 
     */
    public Output<String> text() {
        return this.text;
    }

    /**
     * Value returned to Amazon Lex when the user chooses this button. This must be one of the slot values configured for the slot.
     * 
     */
    @Import(name="value", required=true)
    private Output<String> value;

    /**
     * @return Value returned to Amazon Lex when the user chooses this button. This must be one of the slot values configured for the slot.
     * 
     */
    public Output<String> value() {
        return this.value;
    }

    private V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs() {}

    private V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs(V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs $) {
        this.text = $.text;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs $;

        public Builder() {
            $ = new V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs();
        }

        public Builder(V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs defaults) {
            $ = new V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param text Text that appears on the button. Use this to tell the user what value is returned when they choose this button.
         * 
         * @return builder
         * 
         */
        public Builder text(Output<String> text) {
            $.text = text;
            return this;
        }

        /**
         * @param text Text that appears on the button. Use this to tell the user what value is returned when they choose this button.
         * 
         * @return builder
         * 
         */
        public Builder text(String text) {
            return text(Output.of(text));
        }

        /**
         * @param value Value returned to Amazon Lex when the user chooses this button. This must be one of the slot values configured for the slot.
         * 
         * @return builder
         * 
         */
        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        /**
         * @param value Value returned to Amazon Lex when the user chooses this button. This must be one of the slot values configured for the slot.
         * 
         * @return builder
         * 
         */
        public Builder value(String value) {
            return value(Output.of(value));
        }

        public V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs build() {
            if ($.text == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs", "text");
            }
            if ($.value == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCardButtonArgs", "value");
            }
            return $;
        }
    }

}
