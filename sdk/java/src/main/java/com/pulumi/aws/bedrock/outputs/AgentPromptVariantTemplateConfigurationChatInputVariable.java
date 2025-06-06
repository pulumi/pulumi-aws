// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class AgentPromptVariantTemplateConfigurationChatInputVariable {
    /**
     * @return The name of the variable.
     * 
     */
    private String name;

    private AgentPromptVariantTemplateConfigurationChatInputVariable() {}
    /**
     * @return The name of the variable.
     * 
     */
    public String name() {
        return this.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentPromptVariantTemplateConfigurationChatInputVariable defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String name;
        public Builder() {}
        public Builder(AgentPromptVariantTemplateConfigurationChatInputVariable defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("AgentPromptVariantTemplateConfigurationChatInputVariable", "name");
            }
            this.name = name;
            return this;
        }
        public AgentPromptVariantTemplateConfigurationChatInputVariable build() {
            final var _resultValue = new AgentPromptVariantTemplateConfigurationChatInputVariable();
            _resultValue.name = name;
            return _resultValue;
        }
    }
}
