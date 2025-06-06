// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentPromptVariantMetadataGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Key of a metadata tag for a prompt variant.
        /// </summary>
        [Input("key", required: true)]
        public Input<string> Key { get; set; } = null!;

        /// <summary>
        /// Value of a metadata tag for a prompt variant.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public AgentPromptVariantMetadataGetArgs()
        {
        }
        public static new AgentPromptVariantMetadataGetArgs Empty => new AgentPromptVariantMetadataGetArgs();
    }
}
