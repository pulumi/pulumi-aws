// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs Empty = new V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs();

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

    private V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs() {}

    private V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs(V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs $) {
        this.text = $.text;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs $;

        public Builder() {
            $ = new V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs();
        }

        public Builder(V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs defaults) {
            $ = new V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs(Objects.requireNonNull(defaults));
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

        public V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs build() {
            if ($.text == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs", "text");
            }
            if ($.value == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationFailureResponseMessageGroupMessageImageResponseCardButtonArgs", "value");
            }
            return $;
        }
    }

}
