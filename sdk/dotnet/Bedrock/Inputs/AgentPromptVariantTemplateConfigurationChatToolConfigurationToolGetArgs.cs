// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentPromptVariantTemplateConfigurationChatToolConfigurationToolGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Creates a cache checkpoint within a tool designation. See Cache Point for more information.
        /// </summary>
        [Input("cachePoint")]
        public Input<Inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolCachePointGetArgs>? CachePoint { get; set; }

        /// <summary>
        /// The specification for the tool. See Tool Specification for more information.
        /// </summary>
        [Input("toolSpec")]
        public Input<Inputs.AgentPromptVariantTemplateConfigurationChatToolConfigurationToolToolSpecGetArgs>? ToolSpec { get; set; }

        public AgentPromptVariantTemplateConfigurationChatToolConfigurationToolGetArgs()
        {
        }
        public static new AgentPromptVariantTemplateConfigurationChatToolConfigurationToolGetArgs Empty => new AgentPromptVariantTemplateConfigurationChatToolConfigurationToolGetArgs();
    }
}
