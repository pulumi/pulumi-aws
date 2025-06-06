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
    public sealed class AgentPromptVariantTemplateConfigurationChatMessage
    {
        /// <summary>
        /// Contains the content for the message you pass to, or receive from a model. See [Message Content] for more information.
        /// </summary>
        public readonly Outputs.AgentPromptVariantTemplateConfigurationChatMessageContent? Content;
        /// <summary>
        /// The role that the message belongs to.
        /// </summary>
        public readonly string Role;

        [OutputConstructor]
        private AgentPromptVariantTemplateConfigurationChatMessage(
            Outputs.AgentPromptVariantTemplateConfigurationChatMessageContent? content,

            string role)
        {
            Content = content;
            Role = role;
        }
    }
}
