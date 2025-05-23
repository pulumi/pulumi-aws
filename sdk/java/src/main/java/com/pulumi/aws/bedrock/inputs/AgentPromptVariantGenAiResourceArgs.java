// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.AgentPromptVariantGenAiResourceAgentArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AgentPromptVariantGenAiResourceArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentPromptVariantGenAiResourceArgs Empty = new AgentPromptVariantGenAiResourceArgs();

    /**
     * Specifies an Amazon Bedrock agent with which to use the prompt. See Agent Configuration for more information.
     * 
     */
    @Import(name="agent")
    private @Nullable Output<AgentPromptVariantGenAiResourceAgentArgs> agent;

    /**
     * @return Specifies an Amazon Bedrock agent with which to use the prompt. See Agent Configuration for more information.
     * 
     */
    public Optional<Output<AgentPromptVariantGenAiResourceAgentArgs>> agent() {
        return Optional.ofNullable(this.agent);
    }

    private AgentPromptVariantGenAiResourceArgs() {}

    private AgentPromptVariantGenAiResourceArgs(AgentPromptVariantGenAiResourceArgs $) {
        this.agent = $.agent;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentPromptVariantGenAiResourceArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentPromptVariantGenAiResourceArgs $;

        public Builder() {
            $ = new AgentPromptVariantGenAiResourceArgs();
        }

        public Builder(AgentPromptVariantGenAiResourceArgs defaults) {
            $ = new AgentPromptVariantGenAiResourceArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param agent Specifies an Amazon Bedrock agent with which to use the prompt. See Agent Configuration for more information.
         * 
         * @return builder
         * 
         */
        public Builder agent(@Nullable Output<AgentPromptVariantGenAiResourceAgentArgs> agent) {
            $.agent = agent;
            return this;
        }

        /**
         * @param agent Specifies an Amazon Bedrock agent with which to use the prompt. See Agent Configuration for more information.
         * 
         * @return builder
         * 
         */
        public Builder agent(AgentPromptVariantGenAiResourceAgentArgs agent) {
            return agent(Output.of(agent));
        }

        public AgentPromptVariantGenAiResourceArgs build() {
            return $;
        }
    }

}
