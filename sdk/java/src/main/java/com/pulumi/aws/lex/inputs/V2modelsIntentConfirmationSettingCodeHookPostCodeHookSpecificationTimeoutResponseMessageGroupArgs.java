// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupMessageArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupVariationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs Empty = new V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs();

    /**
     * Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
     * 
     */
    @Import(name="message", required=true)
    private Output<V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupMessageArgs> message;

    /**
     * @return Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
     * 
     */
    public Output<V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupMessageArgs> message() {
        return this.message;
    }

    /**
     * Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
     * 
     */
    @Import(name="variations")
    private @Nullable Output<List<V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupVariationArgs>> variations;

    /**
     * @return Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
     * 
     */
    public Optional<Output<List<V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupVariationArgs>>> variations() {
        return Optional.ofNullable(this.variations);
    }

    private V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs() {}

    private V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs(V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs $) {
        this.message = $.message;
        this.variations = $.variations;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs $;

        public Builder() {
            $ = new V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs();
        }

        public Builder(V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs defaults) {
            $ = new V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param message Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
         * 
         * @return builder
         * 
         */
        public Builder message(Output<V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupMessageArgs> message) {
            $.message = message;
            return this;
        }

        /**
         * @param message Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
         * 
         * @return builder
         * 
         */
        public Builder message(V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupMessageArgs message) {
            return message(Output.of(message));
        }

        /**
         * @param variations Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
         * 
         * @return builder
         * 
         */
        public Builder variations(@Nullable Output<List<V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupVariationArgs>> variations) {
            $.variations = variations;
            return this;
        }

        /**
         * @param variations Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
         * 
         * @return builder
         * 
         */
        public Builder variations(List<V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupVariationArgs> variations) {
            return variations(Output.of(variations));
        }

        /**
         * @param variations Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
         * 
         * @return builder
         * 
         */
        public Builder variations(V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupVariationArgs... variations) {
            return variations(List.of(variations));
        }

        public V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs build() {
            if ($.message == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutResponseMessageGroupArgs", "message");
            }
            return $;
        }
    }

}
