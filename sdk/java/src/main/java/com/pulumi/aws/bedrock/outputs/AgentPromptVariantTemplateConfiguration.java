// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.AgentPromptVariantTemplateConfigurationChat;
import com.pulumi.aws.bedrock.outputs.AgentPromptVariantTemplateConfigurationText;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class AgentPromptVariantTemplateConfiguration {
    /**
     * @return Contains configurations to use the prompt in a conversational format. See Chat Template Configuration for more information.
     * 
     */
    private @Nullable AgentPromptVariantTemplateConfigurationChat chat;
    /**
     * @return Contains configurations for the text in a message for a prompt. See Text Template Configuration
     * 
     */
    private @Nullable AgentPromptVariantTemplateConfigurationText text;

    private AgentPromptVariantTemplateConfiguration() {}
    /**
     * @return Contains configurations to use the prompt in a conversational format. See Chat Template Configuration for more information.
     * 
     */
    public Optional<AgentPromptVariantTemplateConfigurationChat> chat() {
        return Optional.ofNullable(this.chat);
    }
    /**
     * @return Contains configurations for the text in a message for a prompt. See Text Template Configuration
     * 
     */
    public Optional<AgentPromptVariantTemplateConfigurationText> text() {
        return Optional.ofNullable(this.text);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentPromptVariantTemplateConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable AgentPromptVariantTemplateConfigurationChat chat;
        private @Nullable AgentPromptVariantTemplateConfigurationText text;
        public Builder() {}
        public Builder(AgentPromptVariantTemplateConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.chat = defaults.chat;
    	      this.text = defaults.text;
        }

        @CustomType.Setter
        public Builder chat(@Nullable AgentPromptVariantTemplateConfigurationChat chat) {

            this.chat = chat;
            return this;
        }
        @CustomType.Setter
        public Builder text(@Nullable AgentPromptVariantTemplateConfigurationText text) {

            this.text = text;
            return this;
        }
        public AgentPromptVariantTemplateConfiguration build() {
            final var _resultValue = new AgentPromptVariantTemplateConfiguration();
            _resultValue.chat = chat;
            _resultValue.text = text;
            return _resultValue;
        }
    }
}
