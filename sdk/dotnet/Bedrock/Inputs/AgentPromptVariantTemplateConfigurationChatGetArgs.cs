// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentPromptVariantTemplateConfigurationChatGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("inputVariables")]
        private InputList<Inputs.AgentPromptVariantTemplateConfigurationChatInputVariableGetArgs>? _inputVariables;
        public InputList<Inputs.AgentPromptVariantTemplateConfigurationChatInputVariableGetArgs> InputVariables
        {
            get => _inputVariables ?? (_inputVariables = new InputList<Inputs.AgentPromptVariantTemplateConfigurationChatInputVariableGetArgs>());
            set => _inputVariables = value;
        }

        [Input("messages")]
        private InputList<Inputs.AgentPromptVariantTemplateConfigurationChatMessageGetArgs>? _messages;

        /// <summary>
        /// A list of messages in the chat for the prompt. See Message for more information.
        /// </summary>
        public InputList<Inputs.AgentPromptVariantTemplateConfigurationChatMessageGetArgs> Messages
        {
            get => _messages ?? (_messages = new InputList<Inputs.AgentPromptVariantTemplateConfigurationChatMessageGetArgs>());
            set => _messages = value;
        }

        [Input("systems")]
        private InputList<Inputs.AgentPromptVariantTemplateConfigurationChatSystemGetArgs>? _systems;

        /// <summary>
        /// A list of system prompts to provide context to the model or to describe how it should behave. See System for more information.
        /// </summary>
        public InputList<Inputs.AgentPromptVariantTemplateConfigurationChatSystemGetArgs> Systems
        {
            get => _systems ?? (_systems = new InputList<Inputs.AgentPromptVariantTemplateConfigurationChatSystemGetArgs>());
            set => _systems = value;
        }

        /// <summary>
        /// Configuration information for the tools that the model can use when generating a response. See Tool Configuration for more information.
        /// </summary>
        [Input("toolConfiguration")]
        public Input<Inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationGetArgs>? ToolConfiguration { get; set; }

        public AgentPromptVariantTemplateConfigurationChatGetArgs()
        {
        }
        public static new AgentPromptVariantTemplateConfigurationChatGetArgs Empty => new AgentPromptVariantTemplateConfigurationChatGetArgs();
    }
}
