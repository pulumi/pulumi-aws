// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentPromptVariantGenAiResourceAgentArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the agent with which to use the prompt.
        /// </summary>
        [Input("agentIdentifier", required: true)]
        public Input<string> AgentIdentifier { get; set; } = null!;

        public AgentPromptVariantGenAiResourceAgentArgs()
        {
        }
        public static new AgentPromptVariantGenAiResourceAgentArgs Empty => new AgentPromptVariantGenAiResourceAgentArgs();
    }
}
