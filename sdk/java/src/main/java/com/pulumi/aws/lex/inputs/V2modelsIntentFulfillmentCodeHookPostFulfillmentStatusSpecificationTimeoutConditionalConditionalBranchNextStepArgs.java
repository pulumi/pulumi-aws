// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepDialogActionArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepIntentArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs Empty = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs();

    /**
     * Configuration block for action that the bot executes at runtime when the conversation reaches this step. See `dialog_action`.
     * 
     */
    @Import(name="dialogAction")
    private @Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepDialogActionArgs> dialogAction;

    /**
     * @return Configuration block for action that the bot executes at runtime when the conversation reaches this step. See `dialog_action`.
     * 
     */
    public Optional<Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepDialogActionArgs>> dialogAction() {
        return Optional.ofNullable(this.dialogAction);
    }

    /**
     * Configuration block for override settings to configure the intent state. See `intent`.
     * 
     */
    @Import(name="intent")
    private @Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepIntentArgs> intent;

    /**
     * @return Configuration block for override settings to configure the intent state. See `intent`.
     * 
     */
    public Optional<Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepIntentArgs>> intent() {
        return Optional.ofNullable(this.intent);
    }

    /**
     * Map of key/value pairs representing session-specific context information. It contains application information passed between Amazon Lex and a client application.
     * 
     */
    @Import(name="sessionAttributes")
    private @Nullable Output<Map<String,String>> sessionAttributes;

    /**
     * @return Map of key/value pairs representing session-specific context information. It contains application information passed between Amazon Lex and a client application.
     * 
     */
    public Optional<Output<Map<String,String>>> sessionAttributes() {
        return Optional.ofNullable(this.sessionAttributes);
    }

    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs() {}

    private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs $) {
        this.dialogAction = $.dialogAction;
        this.intent = $.intent;
        this.sessionAttributes = $.sessionAttributes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs $;

        public Builder() {
            $ = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs();
        }

        public Builder(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs defaults) {
            $ = new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dialogAction Configuration block for action that the bot executes at runtime when the conversation reaches this step. See `dialog_action`.
         * 
         * @return builder
         * 
         */
        public Builder dialogAction(@Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepDialogActionArgs> dialogAction) {
            $.dialogAction = dialogAction;
            return this;
        }

        /**
         * @param dialogAction Configuration block for action that the bot executes at runtime when the conversation reaches this step. See `dialog_action`.
         * 
         * @return builder
         * 
         */
        public Builder dialogAction(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepDialogActionArgs dialogAction) {
            return dialogAction(Output.of(dialogAction));
        }

        /**
         * @param intent Configuration block for override settings to configure the intent state. See `intent`.
         * 
         * @return builder
         * 
         */
        public Builder intent(@Nullable Output<V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepIntentArgs> intent) {
            $.intent = intent;
            return this;
        }

        /**
         * @param intent Configuration block for override settings to configure the intent state. See `intent`.
         * 
         * @return builder
         * 
         */
        public Builder intent(V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepIntentArgs intent) {
            return intent(Output.of(intent));
        }

        /**
         * @param sessionAttributes Map of key/value pairs representing session-specific context information. It contains application information passed between Amazon Lex and a client application.
         * 
         * @return builder
         * 
         */
        public Builder sessionAttributes(@Nullable Output<Map<String,String>> sessionAttributes) {
            $.sessionAttributes = sessionAttributes;
            return this;
        }

        /**
         * @param sessionAttributes Map of key/value pairs representing session-specific context information. It contains application information passed between Amazon Lex and a client application.
         * 
         * @return builder
         * 
         */
        public Builder sessionAttributes(Map<String,String> sessionAttributes) {
            return sessionAttributes(Output.of(sessionAttributes));
        }

        public V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchNextStepArgs build() {
            return $;
        }
    }

}
