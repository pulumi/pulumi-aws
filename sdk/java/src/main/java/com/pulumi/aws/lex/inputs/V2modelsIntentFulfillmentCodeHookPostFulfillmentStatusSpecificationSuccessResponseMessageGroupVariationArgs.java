// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationCustomPayloadArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationImageResponseCardArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationPlainTextMessageArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationSsmlMessageArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs Empty = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs();

    /**
     * Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
     * 
     */
    @Import(name="customPayload")
    private @Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationCustomPayloadArgs> customPayload;

    /**
     * @return Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
     * 
     */
    public Optional<Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationCustomPayloadArgs>> customPayload() {
        return Optional.ofNullable(this.customPayload);
    }

    /**
     * Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
     * 
     */
    @Import(name="imageResponseCard")
    private @Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationImageResponseCardArgs> imageResponseCard;

    /**
     * @return Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
     * 
     */
    public Optional<Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationImageResponseCardArgs>> imageResponseCard() {
        return Optional.ofNullable(this.imageResponseCard);
    }

    /**
     * Configuration block for a message in plain text format. See `plain_text_message`.
     * 
     */
    @Import(name="plainTextMessage")
    private @Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationPlainTextMessageArgs> plainTextMessage;

    /**
     * @return Configuration block for a message in plain text format. See `plain_text_message`.
     * 
     */
    public Optional<Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationPlainTextMessageArgs>> plainTextMessage() {
        return Optional.ofNullable(this.plainTextMessage);
    }

    /**
     * Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
     * 
     */
    @Import(name="ssmlMessage")
    private @Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationSsmlMessageArgs> ssmlMessage;

    /**
     * @return Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
     * 
     */
    public Optional<Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationSsmlMessageArgs>> ssmlMessage() {
        return Optional.ofNullable(this.ssmlMessage);
    }

    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs() {}

    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs $) {
        this.customPayload = $.customPayload;
        this.imageResponseCard = $.imageResponseCard;
        this.plainTextMessage = $.plainTextMessage;
        this.ssmlMessage = $.ssmlMessage;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs $;

        public Builder() {
            $ = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs();
        }

        public Builder(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs defaults) {
            $ = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param customPayload Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
         * 
         * @return builder
         * 
         */
        public Builder customPayload(@Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationCustomPayloadArgs> customPayload) {
            $.customPayload = customPayload;
            return this;
        }

        /**
         * @param customPayload Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
         * 
         * @return builder
         * 
         */
        public Builder customPayload(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationCustomPayloadArgs customPayload) {
            return customPayload(Output.of(customPayload));
        }

        /**
         * @param imageResponseCard Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
         * 
         * @return builder
         * 
         */
        public Builder imageResponseCard(@Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationImageResponseCardArgs> imageResponseCard) {
            $.imageResponseCard = imageResponseCard;
            return this;
        }

        /**
         * @param imageResponseCard Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
         * 
         * @return builder
         * 
         */
        public Builder imageResponseCard(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationImageResponseCardArgs imageResponseCard) {
            return imageResponseCard(Output.of(imageResponseCard));
        }

        /**
         * @param plainTextMessage Configuration block for a message in plain text format. See `plain_text_message`.
         * 
         * @return builder
         * 
         */
        public Builder plainTextMessage(@Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationPlainTextMessageArgs> plainTextMessage) {
            $.plainTextMessage = plainTextMessage;
            return this;
        }

        /**
         * @param plainTextMessage Configuration block for a message in plain text format. See `plain_text_message`.
         * 
         * @return builder
         * 
         */
        public Builder plainTextMessage(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationPlainTextMessageArgs plainTextMessage) {
            return plainTextMessage(Output.of(plainTextMessage));
        }

        /**
         * @param ssmlMessage Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
         * 
         * @return builder
         * 
         */
        public Builder ssmlMessage(@Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationSsmlMessageArgs> ssmlMessage) {
            $.ssmlMessage = ssmlMessage;
            return this;
        }

        /**
         * @param ssmlMessage Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
         * 
         * @return builder
         * 
         */
        public Builder ssmlMessage(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationSsmlMessageArgs ssmlMessage) {
            return ssmlMessage(Output.of(ssmlMessage));
        }

        public V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationSuccessResponseMessageGroupVariationArgs build() {
            return $;
        }
    }

}
