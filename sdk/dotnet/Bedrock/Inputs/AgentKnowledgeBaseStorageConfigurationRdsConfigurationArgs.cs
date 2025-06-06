// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentKnowledgeBaseStorageConfigurationRdsConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the secret that you created in AWS Secrets Manager that is linked to your Amazon RDS database.
        /// </summary>
        [Input("credentialsSecretArn", required: true)]
        public Input<string> CredentialsSecretArn { get; set; } = null!;

        /// <summary>
        /// Name of your Amazon RDS database.
        /// </summary>
        [Input("databaseName", required: true)]
        public Input<string> DatabaseName { get; set; } = null!;

        /// <summary>
        /// Names of the fields to which to map information about the vector store. This block supports the following arguments:
        /// </summary>
        [Input("fieldMapping")]
        public Input<Inputs.AgentKnowledgeBaseStorageConfigurationRdsConfigurationFieldMappingArgs>? FieldMapping { get; set; }

        /// <summary>
        /// ARN of the vector store.
        /// </summary>
        [Input("resourceArn", required: true)]
        public Input<string> ResourceArn { get; set; } = null!;

        /// <summary>
        /// Name of the table in the database.
        /// </summary>
        [Input("tableName", required: true)]
        public Input<string> TableName { get; set; } = null!;

        public AgentKnowledgeBaseStorageConfigurationRdsConfigurationArgs()
        {
        }
        public static new AgentKnowledgeBaseStorageConfigurationRdsConfigurationArgs Empty => new AgentKnowledgeBaseStorageConfigurationRdsConfigurationArgs();
    }
}
