// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupMessage;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupVariation;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroup {
    /**
     * @return Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
     * 
     */
    private V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupMessage message;
    /**
     * @return Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
     * 
     */
    private @Nullable List<V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupVariation> variations;

    private V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroup() {}
    /**
     * @return Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
     * 
     */
    public V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupMessage message() {
        return this.message;
    }
    /**
     * @return Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
     * 
     */
    public List<V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupVariation> variations() {
        return this.variations == null ? List.of() : this.variations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroup defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupMessage message;
        private @Nullable List<V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupVariation> variations;
        public Builder() {}
        public Builder(V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroup defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.message = defaults.message;
    	      this.variations = defaults.variations;
        }

        @CustomType.Setter
        public Builder message(V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupMessage message) {
            if (message == null) {
              throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroup", "message");
            }
            this.message = message;
            return this;
        }
        @CustomType.Setter
        public Builder variations(@Nullable List<V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupVariation> variations) {

            this.variations = variations;
            return this;
        }
        public Builder variations(V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupVariation... variations) {
            return variations(List.of(variations));
        }
        public V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroup build() {
            final var _resultValue = new V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroup();
            _resultValue.message = message;
            _resultValue.variations = variations;
            return _resultValue;
        }
    }
}
