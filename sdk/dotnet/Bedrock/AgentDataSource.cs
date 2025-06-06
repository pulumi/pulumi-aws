// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock
{
    /// <summary>
    /// Resource for managing an AWS Agents for Amazon Bedrock Data Source.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Bedrock.AgentDataSource("example", new()
    ///     {
    ///         KnowledgeBaseId = "EMDPPAYPZI",
    ///         Name = "example",
    ///         DataSourceConfiguration = new Aws.Bedrock.Inputs.AgentDataSourceDataSourceConfigurationArgs
    ///         {
    ///             Type = "S3",
    ///             S3Configuration = new Aws.Bedrock.Inputs.AgentDataSourceDataSourceConfigurationS3ConfigurationArgs
    ///             {
    ///                 BucketArn = "arn:aws:s3:::example-bucket",
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Agents for Amazon Bedrock Data Source using the data source ID and the knowledge base ID. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:bedrock/agentDataSource:AgentDataSource example GWCMFMQF6T,EMDPPAYPZI
    /// ```
    /// </summary>
    [AwsResourceType("aws:bedrock/agentDataSource:AgentDataSource")]
    public partial class AgentDataSource : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Data deletion policy for a data source. Valid values: `RETAIN`, `DELETE`.
        /// </summary>
        [Output("dataDeletionPolicy")]
        public Output<string> DataDeletionPolicy { get; private set; } = null!;

        /// <summary>
        /// Details about how the data source is stored. See `data_source_configuration` block for details.
        /// </summary>
        [Output("dataSourceConfiguration")]
        public Output<Outputs.AgentDataSourceDataSourceConfiguration?> DataSourceConfiguration { get; private set; } = null!;

        /// <summary>
        /// Unique identifier of the data source.
        /// </summary>
        [Output("dataSourceId")]
        public Output<string> DataSourceId { get; private set; } = null!;

        /// <summary>
        /// Description of the data source.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Unique identifier of the knowledge base to which the data source belongs.
        /// </summary>
        [Output("knowledgeBaseId")]
        public Output<string> KnowledgeBaseId { get; private set; } = null!;

        /// <summary>
        /// Name of the data source.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Details about the configuration of the server-side encryption. See `server_side_encryption_configuration` block for details.
        /// </summary>
        [Output("serverSideEncryptionConfiguration")]
        public Output<Outputs.AgentDataSourceServerSideEncryptionConfiguration?> ServerSideEncryptionConfiguration { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.AgentDataSourceTimeouts?> Timeouts { get; private set; } = null!;

        /// <summary>
        /// Details about the configuration of the server-side encryption. See `vector_ingestion_configuration` block for details.
        /// </summary>
        [Output("vectorIngestionConfiguration")]
        public Output<Outputs.AgentDataSourceVectorIngestionConfiguration?> VectorIngestionConfiguration { get; private set; } = null!;


        /// <summary>
        /// Create a AgentDataSource resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public AgentDataSource(string name, AgentDataSourceArgs args, CustomResourceOptions? options = null)
            : base("aws:bedrock/agentDataSource:AgentDataSource", name, args ?? new AgentDataSourceArgs(), MakeResourceOptions(options, ""))
        {
        }

        private AgentDataSource(string name, Input<string> id, AgentDataSourceState? state = null, CustomResourceOptions? options = null)
            : base("aws:bedrock/agentDataSource:AgentDataSource", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing AgentDataSource resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static AgentDataSource Get(string name, Input<string> id, AgentDataSourceState? state = null, CustomResourceOptions? options = null)
        {
            return new AgentDataSource(name, id, state, options);
        }
    }

    public sealed class AgentDataSourceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Data deletion policy for a data source. Valid values: `RETAIN`, `DELETE`.
        /// </summary>
        [Input("dataDeletionPolicy")]
        public Input<string>? DataDeletionPolicy { get; set; }

        /// <summary>
        /// Details about how the data source is stored. See `data_source_configuration` block for details.
        /// </summary>
        [Input("dataSourceConfiguration")]
        public Input<Inputs.AgentDataSourceDataSourceConfigurationArgs>? DataSourceConfiguration { get; set; }

        /// <summary>
        /// Description of the data source.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Unique identifier of the knowledge base to which the data source belongs.
        /// </summary>
        [Input("knowledgeBaseId", required: true)]
        public Input<string> KnowledgeBaseId { get; set; } = null!;

        /// <summary>
        /// Name of the data source.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Details about the configuration of the server-side encryption. See `server_side_encryption_configuration` block for details.
        /// </summary>
        [Input("serverSideEncryptionConfiguration")]
        public Input<Inputs.AgentDataSourceServerSideEncryptionConfigurationArgs>? ServerSideEncryptionConfiguration { get; set; }

        [Input("timeouts")]
        public Input<Inputs.AgentDataSourceTimeoutsArgs>? Timeouts { get; set; }

        /// <summary>
        /// Details about the configuration of the server-side encryption. See `vector_ingestion_configuration` block for details.
        /// </summary>
        [Input("vectorIngestionConfiguration")]
        public Input<Inputs.AgentDataSourceVectorIngestionConfigurationArgs>? VectorIngestionConfiguration { get; set; }

        public AgentDataSourceArgs()
        {
        }
        public static new AgentDataSourceArgs Empty => new AgentDataSourceArgs();
    }

    public sealed class AgentDataSourceState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Data deletion policy for a data source. Valid values: `RETAIN`, `DELETE`.
        /// </summary>
        [Input("dataDeletionPolicy")]
        public Input<string>? DataDeletionPolicy { get; set; }

        /// <summary>
        /// Details about how the data source is stored. See `data_source_configuration` block for details.
        /// </summary>
        [Input("dataSourceConfiguration")]
        public Input<Inputs.AgentDataSourceDataSourceConfigurationGetArgs>? DataSourceConfiguration { get; set; }

        /// <summary>
        /// Unique identifier of the data source.
        /// </summary>
        [Input("dataSourceId")]
        public Input<string>? DataSourceId { get; set; }

        /// <summary>
        /// Description of the data source.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Unique identifier of the knowledge base to which the data source belongs.
        /// </summary>
        [Input("knowledgeBaseId")]
        public Input<string>? KnowledgeBaseId { get; set; }

        /// <summary>
        /// Name of the data source.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Details about the configuration of the server-side encryption. See `server_side_encryption_configuration` block for details.
        /// </summary>
        [Input("serverSideEncryptionConfiguration")]
        public Input<Inputs.AgentDataSourceServerSideEncryptionConfigurationGetArgs>? ServerSideEncryptionConfiguration { get; set; }

        [Input("timeouts")]
        public Input<Inputs.AgentDataSourceTimeoutsGetArgs>? Timeouts { get; set; }

        /// <summary>
        /// Details about the configuration of the server-side encryption. See `vector_ingestion_configuration` block for details.
        /// </summary>
        [Input("vectorIngestionConfiguration")]
        public Input<Inputs.AgentDataSourceVectorIngestionConfigurationGetArgs>? VectorIngestionConfiguration { get; set; }

        public AgentDataSourceState()
        {
        }
        public static new AgentDataSourceState Empty => new AgentDataSourceState();
    }
}
