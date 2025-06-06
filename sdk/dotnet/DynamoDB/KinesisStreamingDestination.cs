// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DynamoDB
{
    /// <summary>
    /// Enables a [Kinesis streaming destination](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/kds.html) for data replication of a DynamoDB table.
    /// 
    /// ## Example Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.DynamoDB.Table("example", new()
    ///     {
    ///         Name = "orders",
    ///         HashKey = "id",
    ///         Attributes = new[]
    ///         {
    ///             new Aws.DynamoDB.Inputs.TableAttributeArgs
    ///             {
    ///                 Name = "id",
    ///                 Type = "S",
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleStream = new Aws.Kinesis.Stream("example", new()
    ///     {
    ///         Name = "order_item_changes",
    ///         ShardCount = 1,
    ///     });
    /// 
    ///     var exampleKinesisStreamingDestination = new Aws.DynamoDB.KinesisStreamingDestination("example", new()
    ///     {
    ///         StreamArn = exampleStream.Arn,
    ///         TableName = example.Name,
    ///         ApproximateCreationDateTimePrecision = "MICROSECOND",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import DynamoDB Kinesis Streaming Destinations using the `table_name` and `stream_arn` separated by `,`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:dynamodb/kinesisStreamingDestination:KinesisStreamingDestination example example,arn:aws:kinesis:us-east-1:111122223333:exampleStreamName
    /// ```
    /// </summary>
    [AwsResourceType("aws:dynamodb/kinesisStreamingDestination:KinesisStreamingDestination")]
    public partial class KinesisStreamingDestination : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Toggle for the precision of Kinesis data stream timestamp. Valid values: `MILLISECOND` and `MICROSECOND`.
        /// </summary>
        [Output("approximateCreationDateTimePrecision")]
        public Output<string> ApproximateCreationDateTimePrecision { get; private set; } = null!;

        /// <summary>
        /// The ARN for a Kinesis data stream. This must exist in the same account and region as the DynamoDB table.
        /// </summary>
        [Output("streamArn")]
        public Output<string> StreamArn { get; private set; } = null!;

        /// <summary>
        /// The name of the DynamoDB table. There can only be one Kinesis streaming destination for a given DynamoDB table.
        /// </summary>
        [Output("tableName")]
        public Output<string> TableName { get; private set; } = null!;


        /// <summary>
        /// Create a KinesisStreamingDestination resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public KinesisStreamingDestination(string name, KinesisStreamingDestinationArgs args, CustomResourceOptions? options = null)
            : base("aws:dynamodb/kinesisStreamingDestination:KinesisStreamingDestination", name, args ?? new KinesisStreamingDestinationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private KinesisStreamingDestination(string name, Input<string> id, KinesisStreamingDestinationState? state = null, CustomResourceOptions? options = null)
            : base("aws:dynamodb/kinesisStreamingDestination:KinesisStreamingDestination", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing KinesisStreamingDestination resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static KinesisStreamingDestination Get(string name, Input<string> id, KinesisStreamingDestinationState? state = null, CustomResourceOptions? options = null)
        {
            return new KinesisStreamingDestination(name, id, state, options);
        }
    }

    public sealed class KinesisStreamingDestinationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Toggle for the precision of Kinesis data stream timestamp. Valid values: `MILLISECOND` and `MICROSECOND`.
        /// </summary>
        [Input("approximateCreationDateTimePrecision")]
        public Input<string>? ApproximateCreationDateTimePrecision { get; set; }

        /// <summary>
        /// The ARN for a Kinesis data stream. This must exist in the same account and region as the DynamoDB table.
        /// </summary>
        [Input("streamArn", required: true)]
        public Input<string> StreamArn { get; set; } = null!;

        /// <summary>
        /// The name of the DynamoDB table. There can only be one Kinesis streaming destination for a given DynamoDB table.
        /// </summary>
        [Input("tableName", required: true)]
        public Input<string> TableName { get; set; } = null!;

        public KinesisStreamingDestinationArgs()
        {
        }
        public static new KinesisStreamingDestinationArgs Empty => new KinesisStreamingDestinationArgs();
    }

    public sealed class KinesisStreamingDestinationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Toggle for the precision of Kinesis data stream timestamp. Valid values: `MILLISECOND` and `MICROSECOND`.
        /// </summary>
        [Input("approximateCreationDateTimePrecision")]
        public Input<string>? ApproximateCreationDateTimePrecision { get; set; }

        /// <summary>
        /// The ARN for a Kinesis data stream. This must exist in the same account and region as the DynamoDB table.
        /// </summary>
        [Input("streamArn")]
        public Input<string>? StreamArn { get; set; }

        /// <summary>
        /// The name of the DynamoDB table. There can only be one Kinesis streaming destination for a given DynamoDB table.
        /// </summary>
        [Input("tableName")]
        public Input<string>? TableName { get; set; }

        public KinesisStreamingDestinationState()
        {
        }
        public static new KinesisStreamingDestinationState Empty => new KinesisStreamingDestinationState();
    }
}
