// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The vector configuration details on the Bedrock embeddings model.  See `bedrock_embedding_model_configuration` block for details.
        /// </summary>
        [Input("bedrockEmbeddingModelConfiguration")]
        public Input<Inputs.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationGetArgs>? BedrockEmbeddingModelConfiguration { get; set; }

        public AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationGetArgs()
        {
        }
        public static new AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationGetArgs Empty => new AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationGetArgs();
    }
}
