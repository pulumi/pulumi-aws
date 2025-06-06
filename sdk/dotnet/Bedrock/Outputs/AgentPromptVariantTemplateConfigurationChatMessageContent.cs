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
    public sealed class AgentPromptVariantTemplateConfigurationChatMessageContent
    {
        public readonly Outputs.AgentPromptVariantTemplateConfigurationChatMessageContentCachePoint? CachePoint;
        public readonly string? Text;

        [OutputConstructor]
        private AgentPromptVariantTemplateConfigurationChatMessageContent(
            Outputs.AgentPromptVariantTemplateConfigurationChatMessageContentCachePoint? cachePoint,

            string? text)
        {
            CachePoint = cachePoint;
            Text = text;
        }
    }
}
