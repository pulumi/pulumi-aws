// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationCustomPayload;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationImageResponseCard;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessage;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationSsmlMessage;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariation {
    /**
     * @return Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
     * 
     */
    private @Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationCustomPayload customPayload;
    /**
     * @return Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
     * 
     */
    private @Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationImageResponseCard imageResponseCard;
    /**
     * @return Configuration block for a message in plain text format. See `plain_text_message`.
     * 
     */
    private @Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessage plainTextMessage;
    /**
     * @return Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
     * 
     */
    private @Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationSsmlMessage ssmlMessage;

    private V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariation() {}
    /**
     * @return Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
     * 
     */
    public Optional<V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationCustomPayload> customPayload() {
        return Optional.ofNullable(this.customPayload);
    }
    /**
     * @return Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
     * 
     */
    public Optional<V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationImageResponseCard> imageResponseCard() {
        return Optional.ofNullable(this.imageResponseCard);
    }
    /**
     * @return Configuration block for a message in plain text format. See `plain_text_message`.
     * 
     */
    public Optional<V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessage> plainTextMessage() {
        return Optional.ofNullable(this.plainTextMessage);
    }
    /**
     * @return Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
     * 
     */
    public Optional<V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationSsmlMessage> ssmlMessage() {
        return Optional.ofNullable(this.ssmlMessage);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationCustomPayload customPayload;
        private @Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationImageResponseCard imageResponseCard;
        private @Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessage plainTextMessage;
        private @Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationSsmlMessage ssmlMessage;
        public Builder() {}
        public Builder(V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.customPayload = defaults.customPayload;
    	      this.imageResponseCard = defaults.imageResponseCard;
    	      this.plainTextMessage = defaults.plainTextMessage;
    	      this.ssmlMessage = defaults.ssmlMessage;
        }

        @CustomType.Setter
        public Builder customPayload(@Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationCustomPayload customPayload) {

            this.customPayload = customPayload;
            return this;
        }
        @CustomType.Setter
        public Builder imageResponseCard(@Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationImageResponseCard imageResponseCard) {

            this.imageResponseCard = imageResponseCard;
            return this;
        }
        @CustomType.Setter
        public Builder plainTextMessage(@Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessage plainTextMessage) {

            this.plainTextMessage = plainTextMessage;
            return this;
        }
        @CustomType.Setter
        public Builder ssmlMessage(@Nullable V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariationSsmlMessage ssmlMessage) {

            this.ssmlMessage = ssmlMessage;
            return this;
        }
        public V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariation build() {
            final var _resultValue = new V2modelsIntentConfirmationSettingDeclinationConditionalConditionalBranchResponseMessageGroupVariation();
            _resultValue.customPayload = customPayload;
            _resultValue.imageResponseCard = imageResponseCard;
            _resultValue.plainTextMessage = plainTextMessage;
            _resultValue.ssmlMessage = ssmlMessage;
            return _resultValue;
        }
    }
}
