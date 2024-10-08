// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs Empty = new V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs();

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

    private V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs() {}

    private V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs(V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs $) {
        this.text = $.text;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs $;

        public Builder() {
            $ = new V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs();
        }

        public Builder(V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs defaults) {
            $ = new V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs(Objects.requireNonNull(defaults));
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

        public V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs build() {
            if ($.text == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs", "text");
            }
            if ($.value == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageImageResponseCardButtonArgs", "value");
            }
            return $;
        }
    }

}
