// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.AgentPromptVariantTemplateConfigurationChatInputVariableArgs;
import com.pulumi.aws.bedrock.inputs.AgentPromptVariantTemplateConfigurationChatMessageArgs;
import com.pulumi.aws.bedrock.inputs.AgentPromptVariantTemplateConfigurationChatSystemArgs;
import com.pulumi.aws.bedrock.inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AgentPromptVariantTemplateConfigurationChatArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentPromptVariantTemplateConfigurationChatArgs Empty = new AgentPromptVariantTemplateConfigurationChatArgs();

    @Import(name="inputVariables")
    private @Nullable Output<List<AgentPromptVariantTemplateConfigurationChatInputVariableArgs>> inputVariables;

    public Optional<Output<List<AgentPromptVariantTemplateConfigurationChatInputVariableArgs>>> inputVariables() {
        return Optional.ofNullable(this.inputVariables);
    }

    /**
     * A list of messages in the chat for the prompt. See Message for more information.
     * 
     */
    @Import(name="messages")
    private @Nullable Output<List<AgentPromptVariantTemplateConfigurationChatMessageArgs>> messages;

    /**
     * @return A list of messages in the chat for the prompt. See Message for more information.
     * 
     */
    public Optional<Output<List<AgentPromptVariantTemplateConfigurationChatMessageArgs>>> messages() {
        return Optional.ofNullable(this.messages);
    }

    /**
     * A list of system prompts to provide context to the model or to describe how it should behave. See System for more information.
     * 
     */
    @Import(name="systems")
    private @Nullable Output<List<AgentPromptVariantTemplateConfigurationChatSystemArgs>> systems;

    /**
     * @return A list of system prompts to provide context to the model or to describe how it should behave. See System for more information.
     * 
     */
    public Optional<Output<List<AgentPromptVariantTemplateConfigurationChatSystemArgs>>> systems() {
        return Optional.ofNullable(this.systems);
    }

    /**
     * Configuration information for the tools that the model can use when generating a response. See Tool Configuration for more information.
     * 
     */
    @Import(name="toolConfiguration")
    private @Nullable Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationArgs> toolConfiguration;

    /**
     * @return Configuration information for the tools that the model can use when generating a response. See Tool Configuration for more information.
     * 
     */
    public Optional<Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationArgs>> toolConfiguration() {
        return Optional.ofNullable(this.toolConfiguration);
    }

    private AgentPromptVariantTemplateConfigurationChatArgs() {}

    private AgentPromptVariantTemplateConfigurationChatArgs(AgentPromptVariantTemplateConfigurationChatArgs $) {
        this.inputVariables = $.inputVariables;
        this.messages = $.messages;
        this.systems = $.systems;
        this.toolConfiguration = $.toolConfiguration;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentPromptVariantTemplateConfigurationChatArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentPromptVariantTemplateConfigurationChatArgs $;

        public Builder() {
            $ = new AgentPromptVariantTemplateConfigurationChatArgs();
        }

        public Builder(AgentPromptVariantTemplateConfigurationChatArgs defaults) {
            $ = new AgentPromptVariantTemplateConfigurationChatArgs(Objects.requireNonNull(defaults));
        }

        public Builder inputVariables(@Nullable Output<List<AgentPromptVariantTemplateConfigurationChatInputVariableArgs>> inputVariables) {
            $.inputVariables = inputVariables;
            return this;
        }

        public Builder inputVariables(List<AgentPromptVariantTemplateConfigurationChatInputVariableArgs> inputVariables) {
            return inputVariables(Output.of(inputVariables));
        }

        public Builder inputVariables(AgentPromptVariantTemplateConfigurationChatInputVariableArgs... inputVariables) {
            return inputVariables(List.of(inputVariables));
        }

        /**
         * @param messages A list of messages in the chat for the prompt. See Message for more information.
         * 
         * @return builder
         * 
         */
        public Builder messages(@Nullable Output<List<AgentPromptVariantTemplateConfigurationChatMessageArgs>> messages) {
            $.messages = messages;
            return this;
        }

        /**
         * @param messages A list of messages in the chat for the prompt. See Message for more information.
         * 
         * @return builder
         * 
         */
        public Builder messages(List<AgentPromptVariantTemplateConfigurationChatMessageArgs> messages) {
            return messages(Output.of(messages));
        }

        /**
         * @param messages A list of messages in the chat for the prompt. See Message for more information.
         * 
         * @return builder
         * 
         */
        public Builder messages(AgentPromptVariantTemplateConfigurationChatMessageArgs... messages) {
            return messages(List.of(messages));
        }

        /**
         * @param systems A list of system prompts to provide context to the model or to describe how it should behave. See System for more information.
         * 
         * @return builder
         * 
         */
        public Builder systems(@Nullable Output<List<AgentPromptVariantTemplateConfigurationChatSystemArgs>> systems) {
            $.systems = systems;
            return this;
        }

        /**
         * @param systems A list of system prompts to provide context to the model or to describe how it should behave. See System for more information.
         * 
         * @return builder
         * 
         */
        public Builder systems(List<AgentPromptVariantTemplateConfigurationChatSystemArgs> systems) {
            return systems(Output.of(systems));
        }

        /**
         * @param systems A list of system prompts to provide context to the model or to describe how it should behave. See System for more information.
         * 
         * @return builder
         * 
         */
        public Builder systems(AgentPromptVariantTemplateConfigurationChatSystemArgs... systems) {
            return systems(List.of(systems));
        }

        /**
         * @param toolConfiguration Configuration information for the tools that the model can use when generating a response. See Tool Configuration for more information.
         * 
         * @return builder
         * 
         */
        public Builder toolConfiguration(@Nullable Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationArgs> toolConfiguration) {
            $.toolConfiguration = toolConfiguration;
            return this;
        }

        /**
         * @param toolConfiguration Configuration information for the tools that the model can use when generating a response. See Tool Configuration for more information.
         * 
         * @return builder
         * 
         */
        public Builder toolConfiguration(AgentPromptVariantTemplateConfigurationChatToolConfigurationArgs toolConfiguration) {
            return toolConfiguration(Output.of(toolConfiguration));
        }

        public AgentPromptVariantTemplateConfigurationChatArgs build() {
            return $;
        }
    }

}
