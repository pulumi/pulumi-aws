// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupVariationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs Empty = new V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs();

    /**
     * Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
     * 
     */
    @Import(name="message", required=true)
    private Output<V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageArgs> message;

    /**
     * @return Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
     * 
     */
    public Output<V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageArgs> message() {
        return this.message;
    }

    /**
     * Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
     * 
     */
    @Import(name="variations")
    private @Nullable Output<List<V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupVariationArgs>> variations;

    /**
     * @return Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
     * 
     */
    public Optional<Output<List<V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupVariationArgs>>> variations() {
        return Optional.ofNullable(this.variations);
    }

    private V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs() {}

    private V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs(V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs $) {
        this.message = $.message;
        this.variations = $.variations;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs $;

        public Builder() {
            $ = new V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs();
        }

        public Builder(V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs defaults) {
            $ = new V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param message Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
         * 
         * @return builder
         * 
         */
        public Builder message(Output<V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageArgs> message) {
            $.message = message;
            return this;
        }

        /**
         * @param message Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
         * 
         * @return builder
         * 
         */
        public Builder message(V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessageArgs message) {
            return message(Output.of(message));
        }

        /**
         * @param variations Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
         * 
         * @return builder
         * 
         */
        public Builder variations(@Nullable Output<List<V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupVariationArgs>> variations) {
            $.variations = variations;
            return this;
        }

        /**
         * @param variations Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
         * 
         * @return builder
         * 
         */
        public Builder variations(List<V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupVariationArgs> variations) {
            return variations(Output.of(variations));
        }

        /**
         * @param variations Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
         * 
         * @return builder
         * 
         */
        public Builder variations(V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupVariationArgs... variations) {
            return variations(List.of(variations));
        }

        public V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs build() {
            if ($.message == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupArgs", "message");
            }
            return $;
        }
    }

}
