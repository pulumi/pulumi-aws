// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationTool;
import com.pulumi.aws.bedrock.outputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoice;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class AgentPromptVariantTemplateConfigurationChatToolConfiguration {
    /**
     * @return Defines which tools the model should request when invoked. See Tool Choice for more information.
     * 
     */
    private @Nullable AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoice toolChoice;
    /**
     * @return A list of tools to pass to a model. See Tool for more information.
     * 
     */
    private @Nullable List<AgentPromptVariantTemplateConfigurationChatToolConfigurationTool> tools;

    private AgentPromptVariantTemplateConfigurationChatToolConfiguration() {}
    /**
     * @return Defines which tools the model should request when invoked. See Tool Choice for more information.
     * 
     */
    public Optional<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoice> toolChoice() {
        return Optional.ofNullable(this.toolChoice);
    }
    /**
     * @return A list of tools to pass to a model. See Tool for more information.
     * 
     */
    public List<AgentPromptVariantTemplateConfigurationChatToolConfigurationTool> tools() {
        return this.tools == null ? List.of() : this.tools;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentPromptVariantTemplateConfigurationChatToolConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoice toolChoice;
        private @Nullable List<AgentPromptVariantTemplateConfigurationChatToolConfigurationTool> tools;
        public Builder() {}
        public Builder(AgentPromptVariantTemplateConfigurationChatToolConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.toolChoice = defaults.toolChoice;
    	      this.tools = defaults.tools;
        }

        @CustomType.Setter
        public Builder toolChoice(@Nullable AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoice toolChoice) {

            this.toolChoice = toolChoice;
            return this;
        }
        @CustomType.Setter
        public Builder tools(@Nullable List<AgentPromptVariantTemplateConfigurationChatToolConfigurationTool> tools) {

            this.tools = tools;
            return this;
        }
        public Builder tools(AgentPromptVariantTemplateConfigurationChatToolConfigurationTool... tools) {
            return tools(List.of(tools));
        }
        public AgentPromptVariantTemplateConfigurationChatToolConfiguration build() {
            final var _resultValue = new AgentPromptVariantTemplateConfigurationChatToolConfiguration();
            _resultValue.toolChoice = toolChoice;
            _resultValue.tools = tools;
            return _resultValue;
        }
    }
}
