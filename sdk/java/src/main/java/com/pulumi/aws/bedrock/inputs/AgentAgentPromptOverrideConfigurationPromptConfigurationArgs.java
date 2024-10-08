// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.AgentAgentPromptOverrideConfigurationPromptConfigurationInferenceConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class AgentAgentPromptOverrideConfigurationPromptConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentAgentPromptOverrideConfigurationPromptConfigurationArgs Empty = new AgentAgentPromptOverrideConfigurationPromptConfigurationArgs();

    /**
     * prompt template with which to replace the default prompt template. You can use placeholder variables in the base prompt template to customize the prompt. For more information, see [Prompt template placeholder variables](https://docs.aws.amazon.com/bedrock/latest/userguide/prompt-placeholders.html).
     * 
     */
    @Import(name="basePromptTemplate", required=true)
    private Output<String> basePromptTemplate;

    /**
     * @return prompt template with which to replace the default prompt template. You can use placeholder variables in the base prompt template to customize the prompt. For more information, see [Prompt template placeholder variables](https://docs.aws.amazon.com/bedrock/latest/userguide/prompt-placeholders.html).
     * 
     */
    public Output<String> basePromptTemplate() {
        return this.basePromptTemplate;
    }

    /**
     * Inference parameters to use when the agent invokes a foundation model in the part of the agent sequence defined by the `prompt_type`. For more information, see [Inference parameters for foundation models](https://docs.aws.amazon.com/bedrock/latest/userguide/model-parameters.html). See `inference_configuration` Block for details.
     * 
     */
    @Import(name="inferenceConfigurations", required=true)
    private Output<List<AgentAgentPromptOverrideConfigurationPromptConfigurationInferenceConfigurationArgs>> inferenceConfigurations;

    /**
     * @return Inference parameters to use when the agent invokes a foundation model in the part of the agent sequence defined by the `prompt_type`. For more information, see [Inference parameters for foundation models](https://docs.aws.amazon.com/bedrock/latest/userguide/model-parameters.html). See `inference_configuration` Block for details.
     * 
     */
    public Output<List<AgentAgentPromptOverrideConfigurationPromptConfigurationInferenceConfigurationArgs>> inferenceConfigurations() {
        return this.inferenceConfigurations;
    }

    /**
     * Whether to override the default parser Lambda function when parsing the raw foundation model output in the part of the agent sequence defined by the `prompt_type`. If you set the argument as `OVERRIDDEN`, the `override_lambda` argument in the `prompt_override_configuration` block must be specified with the ARN of a Lambda function. Valid values: `DEFAULT`, `OVERRIDDEN`.
     * 
     */
    @Import(name="parserMode", required=true)
    private Output<String> parserMode;

    /**
     * @return Whether to override the default parser Lambda function when parsing the raw foundation model output in the part of the agent sequence defined by the `prompt_type`. If you set the argument as `OVERRIDDEN`, the `override_lambda` argument in the `prompt_override_configuration` block must be specified with the ARN of a Lambda function. Valid values: `DEFAULT`, `OVERRIDDEN`.
     * 
     */
    public Output<String> parserMode() {
        return this.parserMode;
    }

    /**
     * Whether to override the default prompt template for this `prompt_type`. Set this argument to `OVERRIDDEN` to use the prompt that you provide in the `base_prompt_template`. If you leave it as `DEFAULT`, the agent uses a default prompt template. Valid values: `DEFAULT`, `OVERRIDDEN`.
     * 
     */
    @Import(name="promptCreationMode", required=true)
    private Output<String> promptCreationMode;

    /**
     * @return Whether to override the default prompt template for this `prompt_type`. Set this argument to `OVERRIDDEN` to use the prompt that you provide in the `base_prompt_template`. If you leave it as `DEFAULT`, the agent uses a default prompt template. Valid values: `DEFAULT`, `OVERRIDDEN`.
     * 
     */
    public Output<String> promptCreationMode() {
        return this.promptCreationMode;
    }

    /**
     * Whether to allow the agent to carry out the step specified in the `prompt_type`. If you set this argument to `DISABLED`, the agent skips that step. Valid Values: `ENABLED`, `DISABLED`.
     * 
     */
    @Import(name="promptState", required=true)
    private Output<String> promptState;

    /**
     * @return Whether to allow the agent to carry out the step specified in the `prompt_type`. If you set this argument to `DISABLED`, the agent skips that step. Valid Values: `ENABLED`, `DISABLED`.
     * 
     */
    public Output<String> promptState() {
        return this.promptState;
    }

    /**
     * Step in the agent sequence that this prompt configuration applies to. Valid values: `PRE_PROCESSING`, `ORCHESTRATION`, `POST_PROCESSING`, `KNOWLEDGE_BASE_RESPONSE_GENERATION`.
     * 
     */
    @Import(name="promptType", required=true)
    private Output<String> promptType;

    /**
     * @return Step in the agent sequence that this prompt configuration applies to. Valid values: `PRE_PROCESSING`, `ORCHESTRATION`, `POST_PROCESSING`, `KNOWLEDGE_BASE_RESPONSE_GENERATION`.
     * 
     */
    public Output<String> promptType() {
        return this.promptType;
    }

    private AgentAgentPromptOverrideConfigurationPromptConfigurationArgs() {}

    private AgentAgentPromptOverrideConfigurationPromptConfigurationArgs(AgentAgentPromptOverrideConfigurationPromptConfigurationArgs $) {
        this.basePromptTemplate = $.basePromptTemplate;
        this.inferenceConfigurations = $.inferenceConfigurations;
        this.parserMode = $.parserMode;
        this.promptCreationMode = $.promptCreationMode;
        this.promptState = $.promptState;
        this.promptType = $.promptType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentAgentPromptOverrideConfigurationPromptConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentAgentPromptOverrideConfigurationPromptConfigurationArgs $;

        public Builder() {
            $ = new AgentAgentPromptOverrideConfigurationPromptConfigurationArgs();
        }

        public Builder(AgentAgentPromptOverrideConfigurationPromptConfigurationArgs defaults) {
            $ = new AgentAgentPromptOverrideConfigurationPromptConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param basePromptTemplate prompt template with which to replace the default prompt template. You can use placeholder variables in the base prompt template to customize the prompt. For more information, see [Prompt template placeholder variables](https://docs.aws.amazon.com/bedrock/latest/userguide/prompt-placeholders.html).
         * 
         * @return builder
         * 
         */
        public Builder basePromptTemplate(Output<String> basePromptTemplate) {
            $.basePromptTemplate = basePromptTemplate;
            return this;
        }

        /**
         * @param basePromptTemplate prompt template with which to replace the default prompt template. You can use placeholder variables in the base prompt template to customize the prompt. For more information, see [Prompt template placeholder variables](https://docs.aws.amazon.com/bedrock/latest/userguide/prompt-placeholders.html).
         * 
         * @return builder
         * 
         */
        public Builder basePromptTemplate(String basePromptTemplate) {
            return basePromptTemplate(Output.of(basePromptTemplate));
        }

        /**
         * @param inferenceConfigurations Inference parameters to use when the agent invokes a foundation model in the part of the agent sequence defined by the `prompt_type`. For more information, see [Inference parameters for foundation models](https://docs.aws.amazon.com/bedrock/latest/userguide/model-parameters.html). See `inference_configuration` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder inferenceConfigurations(Output<List<AgentAgentPromptOverrideConfigurationPromptConfigurationInferenceConfigurationArgs>> inferenceConfigurations) {
            $.inferenceConfigurations = inferenceConfigurations;
            return this;
        }

        /**
         * @param inferenceConfigurations Inference parameters to use when the agent invokes a foundation model in the part of the agent sequence defined by the `prompt_type`. For more information, see [Inference parameters for foundation models](https://docs.aws.amazon.com/bedrock/latest/userguide/model-parameters.html). See `inference_configuration` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder inferenceConfigurations(List<AgentAgentPromptOverrideConfigurationPromptConfigurationInferenceConfigurationArgs> inferenceConfigurations) {
            return inferenceConfigurations(Output.of(inferenceConfigurations));
        }

        /**
         * @param inferenceConfigurations Inference parameters to use when the agent invokes a foundation model in the part of the agent sequence defined by the `prompt_type`. For more information, see [Inference parameters for foundation models](https://docs.aws.amazon.com/bedrock/latest/userguide/model-parameters.html). See `inference_configuration` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder inferenceConfigurations(AgentAgentPromptOverrideConfigurationPromptConfigurationInferenceConfigurationArgs... inferenceConfigurations) {
            return inferenceConfigurations(List.of(inferenceConfigurations));
        }

        /**
         * @param parserMode Whether to override the default parser Lambda function when parsing the raw foundation model output in the part of the agent sequence defined by the `prompt_type`. If you set the argument as `OVERRIDDEN`, the `override_lambda` argument in the `prompt_override_configuration` block must be specified with the ARN of a Lambda function. Valid values: `DEFAULT`, `OVERRIDDEN`.
         * 
         * @return builder
         * 
         */
        public Builder parserMode(Output<String> parserMode) {
            $.parserMode = parserMode;
            return this;
        }

        /**
         * @param parserMode Whether to override the default parser Lambda function when parsing the raw foundation model output in the part of the agent sequence defined by the `prompt_type`. If you set the argument as `OVERRIDDEN`, the `override_lambda` argument in the `prompt_override_configuration` block must be specified with the ARN of a Lambda function. Valid values: `DEFAULT`, `OVERRIDDEN`.
         * 
         * @return builder
         * 
         */
        public Builder parserMode(String parserMode) {
            return parserMode(Output.of(parserMode));
        }

        /**
         * @param promptCreationMode Whether to override the default prompt template for this `prompt_type`. Set this argument to `OVERRIDDEN` to use the prompt that you provide in the `base_prompt_template`. If you leave it as `DEFAULT`, the agent uses a default prompt template. Valid values: `DEFAULT`, `OVERRIDDEN`.
         * 
         * @return builder
         * 
         */
        public Builder promptCreationMode(Output<String> promptCreationMode) {
            $.promptCreationMode = promptCreationMode;
            return this;
        }

        /**
         * @param promptCreationMode Whether to override the default prompt template for this `prompt_type`. Set this argument to `OVERRIDDEN` to use the prompt that you provide in the `base_prompt_template`. If you leave it as `DEFAULT`, the agent uses a default prompt template. Valid values: `DEFAULT`, `OVERRIDDEN`.
         * 
         * @return builder
         * 
         */
        public Builder promptCreationMode(String promptCreationMode) {
            return promptCreationMode(Output.of(promptCreationMode));
        }

        /**
         * @param promptState Whether to allow the agent to carry out the step specified in the `prompt_type`. If you set this argument to `DISABLED`, the agent skips that step. Valid Values: `ENABLED`, `DISABLED`.
         * 
         * @return builder
         * 
         */
        public Builder promptState(Output<String> promptState) {
            $.promptState = promptState;
            return this;
        }

        /**
         * @param promptState Whether to allow the agent to carry out the step specified in the `prompt_type`. If you set this argument to `DISABLED`, the agent skips that step. Valid Values: `ENABLED`, `DISABLED`.
         * 
         * @return builder
         * 
         */
        public Builder promptState(String promptState) {
            return promptState(Output.of(promptState));
        }

        /**
         * @param promptType Step in the agent sequence that this prompt configuration applies to. Valid values: `PRE_PROCESSING`, `ORCHESTRATION`, `POST_PROCESSING`, `KNOWLEDGE_BASE_RESPONSE_GENERATION`.
         * 
         * @return builder
         * 
         */
        public Builder promptType(Output<String> promptType) {
            $.promptType = promptType;
            return this;
        }

        /**
         * @param promptType Step in the agent sequence that this prompt configuration applies to. Valid values: `PRE_PROCESSING`, `ORCHESTRATION`, `POST_PROCESSING`, `KNOWLEDGE_BASE_RESPONSE_GENERATION`.
         * 
         * @return builder
         * 
         */
        public Builder promptType(String promptType) {
            return promptType(Output.of(promptType));
        }

        public AgentAgentPromptOverrideConfigurationPromptConfigurationArgs build() {
            if ($.basePromptTemplate == null) {
                throw new MissingRequiredPropertyException("AgentAgentPromptOverrideConfigurationPromptConfigurationArgs", "basePromptTemplate");
            }
            if ($.inferenceConfigurations == null) {
                throw new MissingRequiredPropertyException("AgentAgentPromptOverrideConfigurationPromptConfigurationArgs", "inferenceConfigurations");
            }
            if ($.parserMode == null) {
                throw new MissingRequiredPropertyException("AgentAgentPromptOverrideConfigurationPromptConfigurationArgs", "parserMode");
            }
            if ($.promptCreationMode == null) {
                throw new MissingRequiredPropertyException("AgentAgentPromptOverrideConfigurationPromptConfigurationArgs", "promptCreationMode");
            }
            if ($.promptState == null) {
                throw new MissingRequiredPropertyException("AgentAgentPromptOverrideConfigurationPromptConfigurationArgs", "promptState");
            }
            if ($.promptType == null) {
                throw new MissingRequiredPropertyException("AgentAgentPromptOverrideConfigurationPromptConfigurationArgs", "promptType");
            }
            return $;
        }
    }

}
