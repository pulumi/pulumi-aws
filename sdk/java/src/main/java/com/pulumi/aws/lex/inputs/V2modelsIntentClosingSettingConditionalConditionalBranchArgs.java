// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.V2modelsIntentClosingSettingConditionalConditionalBranchConditionArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentClosingSettingConditionalConditionalBranchNextStepArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentClosingSettingConditionalConditionalBranchResponseArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentClosingSettingConditionalConditionalBranchArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentClosingSettingConditionalConditionalBranchArgs Empty = new V2modelsIntentClosingSettingConditionalConditionalBranchArgs();

    /**
     * Configuration block for the expression to evaluate. If the condition is true, the branch&#39;s actions are taken. See `condition`.
     * 
     */
    @Import(name="condition", required=true)
    private Output<V2modelsIntentClosingSettingConditionalConditionalBranchConditionArgs> condition;

    /**
     * @return Configuration block for the expression to evaluate. If the condition is true, the branch&#39;s actions are taken. See `condition`.
     * 
     */
    public Output<V2modelsIntentClosingSettingConditionalConditionalBranchConditionArgs> condition() {
        return this.condition;
    }

    /**
     * Name of the branch.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return Name of the branch.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * Configuration block for the next step in the conversation. See `next_step`.
     * 
     */
    @Import(name="nextStep", required=true)
    private Output<V2modelsIntentClosingSettingConditionalConditionalBranchNextStepArgs> nextStep;

    /**
     * @return Configuration block for the next step in the conversation. See `next_step`.
     * 
     */
    public Output<V2modelsIntentClosingSettingConditionalConditionalBranchNextStepArgs> nextStep() {
        return this.nextStep;
    }

    /**
     * Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
     * 
     */
    @Import(name="response")
    private @Nullable Output<V2modelsIntentClosingSettingConditionalConditionalBranchResponseArgs> response;

    /**
     * @return Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
     * 
     */
    public Optional<Output<V2modelsIntentClosingSettingConditionalConditionalBranchResponseArgs>> response() {
        return Optional.ofNullable(this.response);
    }

    private V2modelsIntentClosingSettingConditionalConditionalBranchArgs() {}

    private V2modelsIntentClosingSettingConditionalConditionalBranchArgs(V2modelsIntentClosingSettingConditionalConditionalBranchArgs $) {
        this.condition = $.condition;
        this.name = $.name;
        this.nextStep = $.nextStep;
        this.response = $.response;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentClosingSettingConditionalConditionalBranchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentClosingSettingConditionalConditionalBranchArgs $;

        public Builder() {
            $ = new V2modelsIntentClosingSettingConditionalConditionalBranchArgs();
        }

        public Builder(V2modelsIntentClosingSettingConditionalConditionalBranchArgs defaults) {
            $ = new V2modelsIntentClosingSettingConditionalConditionalBranchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param condition Configuration block for the expression to evaluate. If the condition is true, the branch&#39;s actions are taken. See `condition`.
         * 
         * @return builder
         * 
         */
        public Builder condition(Output<V2modelsIntentClosingSettingConditionalConditionalBranchConditionArgs> condition) {
            $.condition = condition;
            return this;
        }

        /**
         * @param condition Configuration block for the expression to evaluate. If the condition is true, the branch&#39;s actions are taken. See `condition`.
         * 
         * @return builder
         * 
         */
        public Builder condition(V2modelsIntentClosingSettingConditionalConditionalBranchConditionArgs condition) {
            return condition(Output.of(condition));
        }

        /**
         * @param name Name of the branch.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the branch.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param nextStep Configuration block for the next step in the conversation. See `next_step`.
         * 
         * @return builder
         * 
         */
        public Builder nextStep(Output<V2modelsIntentClosingSettingConditionalConditionalBranchNextStepArgs> nextStep) {
            $.nextStep = nextStep;
            return this;
        }

        /**
         * @param nextStep Configuration block for the next step in the conversation. See `next_step`.
         * 
         * @return builder
         * 
         */
        public Builder nextStep(V2modelsIntentClosingSettingConditionalConditionalBranchNextStepArgs nextStep) {
            return nextStep(Output.of(nextStep));
        }

        /**
         * @param response Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
         * 
         * @return builder
         * 
         */
        public Builder response(@Nullable Output<V2modelsIntentClosingSettingConditionalConditionalBranchResponseArgs> response) {
            $.response = response;
            return this;
        }

        /**
         * @param response Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
         * 
         * @return builder
         * 
         */
        public Builder response(V2modelsIntentClosingSettingConditionalConditionalBranchResponseArgs response) {
            return response(Output.of(response));
        }

        public V2modelsIntentClosingSettingConditionalConditionalBranchArgs build() {
            if ($.condition == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentClosingSettingConditionalConditionalBranchArgs", "condition");
            }
            if ($.name == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentClosingSettingConditionalConditionalBranchArgs", "name");
            }
            if ($.nextStep == null) {
                throw new MissingRequiredPropertyException("V2modelsIntentClosingSettingConditionalConditionalBranchArgs", "nextStep");
            }
            return $;
        }
    }

}
