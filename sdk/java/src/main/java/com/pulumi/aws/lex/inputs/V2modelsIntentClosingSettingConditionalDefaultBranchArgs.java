// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsIntentClosingSettingConditionalDefaultBranchNextStepArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentClosingSettingConditionalDefaultBranchResponseArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentClosingSettingConditionalDefaultBranchArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentClosingSettingConditionalDefaultBranchArgs Empty = new V2modelsIntentClosingSettingConditionalDefaultBranchArgs();

    /**
     * Configuration block for the next step in the conversation. See `next_step`.
     * 
     */
    @Import(name="nextStep")
    private @Nullable Output<V2modelsIntentClosingSettingConditionalDefaultBranchNextStepArgs> nextStep;

    /**
     * @return Configuration block for the next step in the conversation. See `next_step`.
     * 
     */
    public Optional<Output<V2modelsIntentClosingSettingConditionalDefaultBranchNextStepArgs>> nextStep() {
        return Optional.ofNullable(this.nextStep);
    }

    /**
     * Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
     * 
     */
    @Import(name="response")
    private @Nullable Output<V2modelsIntentClosingSettingConditionalDefaultBranchResponseArgs> response;

    /**
     * @return Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
     * 
     */
    public Optional<Output<V2modelsIntentClosingSettingConditionalDefaultBranchResponseArgs>> response() {
        return Optional.ofNullable(this.response);
    }

    private V2modelsIntentClosingSettingConditionalDefaultBranchArgs() {}

    private V2modelsIntentClosingSettingConditionalDefaultBranchArgs(V2modelsIntentClosingSettingConditionalDefaultBranchArgs $) {
        this.nextStep = $.nextStep;
        this.response = $.response;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentClosingSettingConditionalDefaultBranchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentClosingSettingConditionalDefaultBranchArgs $;

        public Builder() {
            $ = new V2modelsIntentClosingSettingConditionalDefaultBranchArgs();
        }

        public Builder(V2modelsIntentClosingSettingConditionalDefaultBranchArgs defaults) {
            $ = new V2modelsIntentClosingSettingConditionalDefaultBranchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param nextStep Configuration block for the next step in the conversation. See `next_step`.
         * 
         * @return builder
         * 
         */
        public Builder nextStep(@Nullable Output<V2modelsIntentClosingSettingConditionalDefaultBranchNextStepArgs> nextStep) {
            $.nextStep = nextStep;
            return this;
        }

        /**
         * @param nextStep Configuration block for the next step in the conversation. See `next_step`.
         * 
         * @return builder
         * 
         */
        public Builder nextStep(V2modelsIntentClosingSettingConditionalDefaultBranchNextStepArgs nextStep) {
            return nextStep(Output.of(nextStep));
        }

        /**
         * @param response Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
         * 
         * @return builder
         * 
         */
        public Builder response(@Nullable Output<V2modelsIntentClosingSettingConditionalDefaultBranchResponseArgs> response) {
            $.response = response;
            return this;
        }

        /**
         * @param response Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
         * 
         * @return builder
         * 
         */
        public Builder response(V2modelsIntentClosingSettingConditionalDefaultBranchResponseArgs response) {
            return response(Output.of(response));
        }

        public V2modelsIntentClosingSettingConditionalDefaultBranchArgs build() {
            return $;
        }
    }

}
