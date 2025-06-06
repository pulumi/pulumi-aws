// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Outputs
{

    [OutputType]
    public sealed class AgentAgentPromptOverrideConfiguration
    {
        /// <summary>
        /// ARN of the Lambda function to use when parsing the raw foundation model output in parts of the agent sequence. If you specify this field, at least one of the `prompt_configurations` block must contain a `parser_mode` value that is set to `OVERRIDDEN`.
        /// </summary>
        public readonly string OverrideLambda;
        /// <summary>
        /// Configurations to override a prompt template in one part of an agent sequence. See `prompt_configurations` Block for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.AgentAgentPromptOverrideConfigurationPromptConfiguration> PromptConfigurations;

        [OutputConstructor]
        private AgentAgentPromptOverrideConfiguration(
            string overrideLambda,

            ImmutableArray<Outputs.AgentAgentPromptOverrideConfigurationPromptConfiguration> promptConfigurations)
        {
            OverrideLambda = overrideLambda;
            PromptConfigurations = promptConfigurations;
        }
    }
}
