// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentKnowledgeBaseKnowledgeBaseConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Type of data that the data source is converted into for the knowledge base. Valid Values: `VECTOR`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        /// <summary>
        /// Details about the embeddings model that'sused to convert the data source. See `vector_knowledge_base_configuration` block for details.
        /// </summary>
        [Input("vectorKnowledgeBaseConfiguration")]
        public Input<Inputs.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationArgs>? VectorKnowledgeBaseConfiguration { get; set; }

        public AgentKnowledgeBaseKnowledgeBaseConfigurationArgs()
        {
        }
        public static new AgentKnowledgeBaseKnowledgeBaseConfigurationArgs Empty => new AgentKnowledgeBaseKnowledgeBaseConfigurationArgs();
    }
}
