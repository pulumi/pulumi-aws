// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationCustomPayloadArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationImageResponseCardArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessageArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationSsmlMessageArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs Empty = new V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs();

    /**
     * Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
     * 
     */
    @Import(name="customPayload")
    private @Nullable Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationCustomPayloadArgs> customPayload;

    /**
     * @return Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
     * 
     */
    public Optional<Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationCustomPayloadArgs>> customPayload() {
        return Optional.ofNullable(this.customPayload);
    }

    /**
     * Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
     * 
     */
    @Import(name="imageResponseCard")
    private @Nullable Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationImageResponseCardArgs> imageResponseCard;

    /**
     * @return Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
     * 
     */
    public Optional<Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationImageResponseCardArgs>> imageResponseCard() {
        return Optional.ofNullable(this.imageResponseCard);
    }

    /**
     * Configuration block for a message in plain text format. See `plain_text_message`.
     * 
     */
    @Import(name="plainTextMessage")
    private @Nullable Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessageArgs> plainTextMessage;

    /**
     * @return Configuration block for a message in plain text format. See `plain_text_message`.
     * 
     */
    public Optional<Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessageArgs>> plainTextMessage() {
        return Optional.ofNullable(this.plainTextMessage);
    }

    /**
     * Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
     * 
     */
    @Import(name="ssmlMessage")
    private @Nullable Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationSsmlMessageArgs> ssmlMessage;

    /**
     * @return Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
     * 
     */
    public Optional<Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationSsmlMessageArgs>> ssmlMessage() {
        return Optional.ofNullable(this.ssmlMessage);
    }

    private V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs() {}

    private V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs(V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs $) {
        this.customPayload = $.customPayload;
        this.imageResponseCard = $.imageResponseCard;
        this.plainTextMessage = $.plainTextMessage;
        this.ssmlMessage = $.ssmlMessage;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs $;

        public Builder() {
            $ = new V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs();
        }

        public Builder(V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs defaults) {
            $ = new V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param customPayload Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
         * 
         * @return builder
         * 
         */
        public Builder customPayload(@Nullable Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationCustomPayloadArgs> customPayload) {
            $.customPayload = customPayload;
            return this;
        }

        /**
         * @param customPayload Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
         * 
         * @return builder
         * 
         */
        public Builder customPayload(V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationCustomPayloadArgs customPayload) {
            return customPayload(Output.of(customPayload));
        }

        /**
         * @param imageResponseCard Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
         * 
         * @return builder
         * 
         */
        public Builder imageResponseCard(@Nullable Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationImageResponseCardArgs> imageResponseCard) {
            $.imageResponseCard = imageResponseCard;
            return this;
        }

        /**
         * @param imageResponseCard Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
         * 
         * @return builder
         * 
         */
        public Builder imageResponseCard(V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationImageResponseCardArgs imageResponseCard) {
            return imageResponseCard(Output.of(imageResponseCard));
        }

        /**
         * @param plainTextMessage Configuration block for a message in plain text format. See `plain_text_message`.
         * 
         * @return builder
         * 
         */
        public Builder plainTextMessage(@Nullable Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessageArgs> plainTextMessage) {
            $.plainTextMessage = plainTextMessage;
            return this;
        }

        /**
         * @param plainTextMessage Configuration block for a message in plain text format. See `plain_text_message`.
         * 
         * @return builder
         * 
         */
        public Builder plainTextMessage(V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationPlainTextMessageArgs plainTextMessage) {
            return plainTextMessage(Output.of(plainTextMessage));
        }

        /**
         * @param ssmlMessage Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
         * 
         * @return builder
         * 
         */
        public Builder ssmlMessage(@Nullable Output<V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationSsmlMessageArgs> ssmlMessage) {
            $.ssmlMessage = ssmlMessage;
            return this;
        }

        /**
         * @param ssmlMessage Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
         * 
         * @return builder
         * 
         */
        public Builder ssmlMessage(V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationSsmlMessageArgs ssmlMessage) {
            return ssmlMessage(Output.of(ssmlMessage));
        }

        public V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupVariationArgs build() {
            return $;
        }
    }

}
