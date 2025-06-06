// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAnyArgs;
import com.pulumi.aws.bedrock.inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAutoArgs;
import com.pulumi.aws.bedrock.inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs Empty = new AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs();

    /**
     * Defines tools, at least one of which must be requested by the model. No text is generated but the results of tool use are sent back to the model to help generate a response. This object has no fields.
     * 
     */
    @Import(name="any")
    private @Nullable Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAnyArgs> any;

    /**
     * @return Defines tools, at least one of which must be requested by the model. No text is generated but the results of tool use are sent back to the model to help generate a response. This object has no fields.
     * 
     */
    public Optional<Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAnyArgs>> any() {
        return Optional.ofNullable(this.any);
    }

    /**
     * Defines tools. The model automatically decides whether to call a tool or to generate text instead. This object has no fields.
     * 
     */
    @Import(name="auto")
    private @Nullable Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAutoArgs> auto;

    /**
     * @return Defines tools. The model automatically decides whether to call a tool or to generate text instead. This object has no fields.
     * 
     */
    public Optional<Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAutoArgs>> auto() {
        return Optional.ofNullable(this.auto);
    }

    /**
     * Defines a specific tool that the model must request. No text is generated but the results of tool use are sent back to the model to help generate a response. See Named Tool for more information.
     * 
     */
    @Import(name="tool")
    private @Nullable Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolArgs> tool;

    /**
     * @return Defines a specific tool that the model must request. No text is generated but the results of tool use are sent back to the model to help generate a response. See Named Tool for more information.
     * 
     */
    public Optional<Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolArgs>> tool() {
        return Optional.ofNullable(this.tool);
    }

    private AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs() {}

    private AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs(AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs $) {
        this.any = $.any;
        this.auto = $.auto;
        this.tool = $.tool;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs $;

        public Builder() {
            $ = new AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs();
        }

        public Builder(AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs defaults) {
            $ = new AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param any Defines tools, at least one of which must be requested by the model. No text is generated but the results of tool use are sent back to the model to help generate a response. This object has no fields.
         * 
         * @return builder
         * 
         */
        public Builder any(@Nullable Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAnyArgs> any) {
            $.any = any;
            return this;
        }

        /**
         * @param any Defines tools, at least one of which must be requested by the model. No text is generated but the results of tool use are sent back to the model to help generate a response. This object has no fields.
         * 
         * @return builder
         * 
         */
        public Builder any(AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAnyArgs any) {
            return any(Output.of(any));
        }

        /**
         * @param auto Defines tools. The model automatically decides whether to call a tool or to generate text instead. This object has no fields.
         * 
         * @return builder
         * 
         */
        public Builder auto(@Nullable Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAutoArgs> auto) {
            $.auto = auto;
            return this;
        }

        /**
         * @param auto Defines tools. The model automatically decides whether to call a tool or to generate text instead. This object has no fields.
         * 
         * @return builder
         * 
         */
        public Builder auto(AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceAutoArgs auto) {
            return auto(Output.of(auto));
        }

        /**
         * @param tool Defines a specific tool that the model must request. No text is generated but the results of tool use are sent back to the model to help generate a response. See Named Tool for more information.
         * 
         * @return builder
         * 
         */
        public Builder tool(@Nullable Output<AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolArgs> tool) {
            $.tool = tool;
            return this;
        }

        /**
         * @param tool Defines a specific tool that the model must request. No text is generated but the results of tool use are sent back to the model to help generate a response. See Named Tool for more information.
         * 
         * @return builder
         * 
         */
        public Builder tool(AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolArgs tool) {
            return tool(Output.of(tool));
        }

        public AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceArgs build() {
            return $;
        }
    }

}
