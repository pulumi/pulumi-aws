// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.core.annotations.CustomType;
import java.util.Objects;

@CustomType
public final class AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAny {
    private AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAny() {}

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAny defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        public Builder() {}
        public Builder(AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAny defaults) {
    	      Objects.requireNonNull(defaults);
        }

        public AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAny build() {
            final var _resultValue = new AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAny();
            return _resultValue;
        }
    }
}
