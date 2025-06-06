// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentPromptVariantTemplateConfigurationChatToolConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Defines which tools the model should request when invoked. See Tool Choice for more information.
        /// </summary>
        [Input("toolChoice")]
        public Input<Inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceGetArgs>? ToolChoice { get; set; }

        [Input("tools")]
        private InputList<Inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolGetArgs>? _tools;

        /// <summary>
        /// A list of tools to pass to a model. See Tool for more information.
        /// </summary>
        public InputList<Inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolGetArgs> Tools
        {
            get => _tools ?? (_tools = new InputList<Inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolGetArgs>());
            set => _tools = value;
        }

        public AgentPromptVariantTemplateConfigurationChatToolConfigurationGetArgs()
        {
        }
        public static new AgentPromptVariantTemplateConfigurationChatToolConfigurationGetArgs Empty => new AgentPromptVariantTemplateConfigurationChatToolConfigurationGetArgs();
    }
}
