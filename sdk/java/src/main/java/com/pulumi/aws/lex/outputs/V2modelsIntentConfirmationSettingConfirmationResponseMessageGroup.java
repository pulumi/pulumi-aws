// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupMessage;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupVariation;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsIntentConfirmationSettingConfirmationResponseMessageGroup {
    /**
     * @return Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
     * 
     */
    private V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupMessage message;
    /**
     * @return Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
     * 
     */
    private @Nullable List<V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupVariation> variations;

    private V2modelsIntentConfirmationSettingConfirmationResponseMessageGroup() {}
    /**
     * @return Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
     * 
     */
    public V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupMessage message() {
        return this.message;
    }
    /**
     * @return Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
     * 
     */
    public List<V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupVariation> variations() {
        return this.variations == null ? List.of() : this.variations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsIntentConfirmationSettingConfirmationResponseMessageGroup defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupMessage message;
        private @Nullable List<V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupVariation> variations;
        public Builder() {}
        public Builder(V2modelsIntentConfirmationSettingConfirmationResponseMessageGroup defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.message = defaults.message;
    	      this.variations = defaults.variations;
        }

        @CustomType.Setter
        public Builder message(V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupMessage message) {
            if (message == null) {
              throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingConfirmationResponseMessageGroup", "message");
            }
            this.message = message;
            return this;
        }
        @CustomType.Setter
        public Builder variations(@Nullable List<V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupVariation> variations) {

            this.variations = variations;
            return this;
        }
        public Builder variations(V2modelsIntentConfirmationSettingConfirmationResponseMessageGroupVariation... variations) {
            return variations(List.of(variations));
        }
        public V2modelsIntentConfirmationSettingConfirmationResponseMessageGroup build() {
            final var _resultValue = new V2modelsIntentConfirmationSettingConfirmationResponseMessageGroup();
            _resultValue.message = message;
            _resultValue.variations = variations;
            return _resultValue;
        }
    }
}
