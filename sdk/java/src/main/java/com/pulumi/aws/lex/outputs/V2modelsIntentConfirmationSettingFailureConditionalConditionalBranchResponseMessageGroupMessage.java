// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageCustomPayload;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCard;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessagePlainTextMessage;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageSsmlMessage;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessage {
    /**
     * @return Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
     * 
     */
    private @Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageCustomPayload customPayload;
    /**
     * @return Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
     * 
     */
    private @Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCard imageResponseCard;
    /**
     * @return Configuration block for a message in plain text format. See `plain_text_message`.
     * 
     */
    private @Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessagePlainTextMessage plainTextMessage;
    /**
     * @return Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
     * 
     */
    private @Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageSsmlMessage ssmlMessage;

    private V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessage() {}
    /**
     * @return Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
     * 
     */
    public Optional<V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageCustomPayload> customPayload() {
        return Optional.ofNullable(this.customPayload);
    }
    /**
     * @return Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
     * 
     */
    public Optional<V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCard> imageResponseCard() {
        return Optional.ofNullable(this.imageResponseCard);
    }
    /**
     * @return Configuration block for a message in plain text format. See `plain_text_message`.
     * 
     */
    public Optional<V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessagePlainTextMessage> plainTextMessage() {
        return Optional.ofNullable(this.plainTextMessage);
    }
    /**
     * @return Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
     * 
     */
    public Optional<V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageSsmlMessage> ssmlMessage() {
        return Optional.ofNullable(this.ssmlMessage);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessage defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageCustomPayload customPayload;
        private @Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCard imageResponseCard;
        private @Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessagePlainTextMessage plainTextMessage;
        private @Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageSsmlMessage ssmlMessage;
        public Builder() {}
        public Builder(V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessage defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.customPayload = defaults.customPayload;
    	      this.imageResponseCard = defaults.imageResponseCard;
    	      this.plainTextMessage = defaults.plainTextMessage;
    	      this.ssmlMessage = defaults.ssmlMessage;
        }

        @CustomType.Setter
        public Builder customPayload(@Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageCustomPayload customPayload) {

            this.customPayload = customPayload;
            return this;
        }
        @CustomType.Setter
        public Builder imageResponseCard(@Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageImageResponseCard imageResponseCard) {

            this.imageResponseCard = imageResponseCard;
            return this;
        }
        @CustomType.Setter
        public Builder plainTextMessage(@Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessagePlainTextMessage plainTextMessage) {

            this.plainTextMessage = plainTextMessage;
            return this;
        }
        @CustomType.Setter
        public Builder ssmlMessage(@Nullable V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessageSsmlMessage ssmlMessage) {

            this.ssmlMessage = ssmlMessage;
            return this;
        }
        public V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessage build() {
            final var _resultValue = new V2modelsIntentConfirmationSettingFailureConditionalConditionalBranchResponseMessageGroupMessage();
            _resultValue.customPayload = customPayload;
            _resultValue.imageResponseCard = imageResponseCard;
            _resultValue.plainTextMessage = plainTextMessage;
            _resultValue.ssmlMessage = ssmlMessage;
            return _resultValue;
        }
    }
}
