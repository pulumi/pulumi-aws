// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageCustomPayload;
import com.pulumi.aws.lex.outputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageImageResponseCard;
import com.pulumi.aws.lex.outputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessagePlainTextMessage;
import com.pulumi.aws.lex.outputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageSsmlMessage;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessage {
    private @Nullable List<V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageCustomPayload> customPayloads;
    private @Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageImageResponseCard imageResponseCard;
    private @Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessagePlainTextMessage plainTextMessage;
    private @Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageSsmlMessage ssmlMessage;

    private V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessage() {}
    public List<V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageCustomPayload> customPayloads() {
        return this.customPayloads == null ? List.of() : this.customPayloads;
    }
    public Optional<V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageImageResponseCard> imageResponseCard() {
        return Optional.ofNullable(this.imageResponseCard);
    }
    public Optional<V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessagePlainTextMessage> plainTextMessage() {
        return Optional.ofNullable(this.plainTextMessage);
    }
    public Optional<V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageSsmlMessage> ssmlMessage() {
        return Optional.ofNullable(this.ssmlMessage);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessage defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageCustomPayload> customPayloads;
        private @Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageImageResponseCard imageResponseCard;
        private @Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessagePlainTextMessage plainTextMessage;
        private @Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageSsmlMessage ssmlMessage;
        public Builder() {}
        public Builder(V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessage defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.customPayloads = defaults.customPayloads;
    	      this.imageResponseCard = defaults.imageResponseCard;
    	      this.plainTextMessage = defaults.plainTextMessage;
    	      this.ssmlMessage = defaults.ssmlMessage;
        }

        @CustomType.Setter
        public Builder customPayloads(@Nullable List<V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageCustomPayload> customPayloads) {

            this.customPayloads = customPayloads;
            return this;
        }
        public Builder customPayloads(V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageCustomPayload... customPayloads) {
            return customPayloads(List.of(customPayloads));
        }
        @CustomType.Setter
        public Builder imageResponseCard(@Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageImageResponseCard imageResponseCard) {

            this.imageResponseCard = imageResponseCard;
            return this;
        }
        @CustomType.Setter
        public Builder plainTextMessage(@Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessagePlainTextMessage plainTextMessage) {

            this.plainTextMessage = plainTextMessage;
            return this;
        }
        @CustomType.Setter
        public Builder ssmlMessage(@Nullable V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessageSsmlMessage ssmlMessage) {

            this.ssmlMessage = ssmlMessage;
            return this;
        }
        public V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessage build() {
            final var _resultValue = new V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupMessage();
            _resultValue.customPayloads = customPayloads;
            _resultValue.imageResponseCard = imageResponseCard;
            _resultValue.plainTextMessage = plainTextMessage;
            _resultValue.ssmlMessage = ssmlMessage;
            return _resultValue;
        }
    }
}
