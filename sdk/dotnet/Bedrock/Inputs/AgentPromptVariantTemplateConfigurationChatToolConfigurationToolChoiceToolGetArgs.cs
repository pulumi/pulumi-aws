// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the prompt.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        public AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolGetArgs()
        {
        }
        public static new AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolGetArgs Empty => new AgentPromptVariantTemplateConfigurationChatToolConfigurationToolChoiceToolGetArgs();
    }
}
