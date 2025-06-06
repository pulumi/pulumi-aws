// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Dms
{
    /// <summary>
    /// Provides a DMS Serverless replication config resource.
    /// 
    /// &gt; **NOTE:** Changing most arguments will stop the replication if it is running. You can set `start_replication` to resume the replication afterwards.
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
    ///     var name = new Aws.Dms.ReplicationConfig("name", new()
    ///     {
    ///         ReplicationConfigIdentifier = "test-dms-serverless-replication-tf",
    ///         ResourceIdentifier = "test-dms-serverless-replication-tf",
    ///         ReplicationType = "cdc",
    ///         SourceEndpointArn = source.EndpointArn,
    ///         TargetEndpointArn = target.EndpointArn,
    ///         TableMappings = @"  {
    ///     ""rules"":[{""rule-type"":""selection"",""rule-id"":""1"",""rule-name"":""1"",""rule-action"":""include"",""object-locator"":{""schema-name"":""%%"",""table-name"":""%%""}}]
    ///   }
    /// ",
    ///         StartReplication = true,
    ///         ComputeConfig = new Aws.Dms.Inputs.ReplicationConfigComputeConfigArgs
    ///         {
    ///             ReplicationSubnetGroupId = @default.ReplicationSubnetGroupId,
    ///             MaxCapacityUnits = 64,
    ///             MinCapacityUnits = 2,
    ///             PreferredMaintenanceWindow = "sun:23:45-mon:00:30",
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import a replication config using the `arn`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:dms/replicationConfig:ReplicationConfig example arn:aws:dms:us-east-1:123456789012:replication-config:UX6OL6MHMMJKFFOXE3H7LLJCMEKBDUG4ZV7DRSI
    /// ```
    /// </summary>
    [AwsResourceType("aws:dms/replicationConfig:ReplicationConfig")]
    public partial class ReplicationConfig : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) for the serverless replication config.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Configuration block for provisioning an DMS Serverless replication.
        /// </summary>
        [Output("computeConfig")]
        public Output<Outputs.ReplicationConfigComputeConfig> ComputeConfig { get; private set; } = null!;

        /// <summary>
        /// Unique identifier that you want to use to create the config.
        /// </summary>
        [Output("replicationConfigIdentifier")]
        public Output<string> ReplicationConfigIdentifier { get; private set; } = null!;

        /// <summary>
        /// An escaped JSON string that are used to provision this replication configuration. For example, [Change processing tuning settings](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.CustomizingTasks.TaskSettings.ChangeProcessingTuning.html)
        /// </summary>
        [Output("replicationSettings")]
        public Output<string> ReplicationSettings { get; private set; } = null!;

        /// <summary>
        /// The migration type. Can be one of `full-load | cdc | full-load-and-cdc`.
        /// </summary>
        [Output("replicationType")]
        public Output<string> ReplicationType { get; private set; } = null!;

        /// <summary>
        /// Unique value or name that you set for a given resource that can be used to construct an Amazon Resource Name (ARN) for that resource. For more information, see [Fine-grained access control using resource names and tags](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Security.html#CHAP_Security.FineGrainedAccess)
        /// </summary>
        [Output("resourceIdentifier")]
        public Output<string> ResourceIdentifier { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) string that uniquely identifies the source endpoint.
        /// </summary>
        [Output("sourceEndpointArn")]
        public Output<string> SourceEndpointArn { get; private set; } = null!;

        /// <summary>
        /// Whether to run or stop the serverless replication, default is false.
        /// </summary>
        [Output("startReplication")]
        public Output<bool?> StartReplication { get; private set; } = null!;

        /// <summary>
        /// JSON settings for specifying supplemental data. For more information see [Specifying supplemental data for task settings](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.TaskData.html)
        /// </summary>
        [Output("supplementalSettings")]
        public Output<string?> SupplementalSettings { get; private set; } = null!;

        /// <summary>
        /// An escaped JSON string that contains the table mappings. For information on table mapping see [Using Table Mapping with an AWS Database Migration Service Task to Select and Filter Data](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.CustomizingTasks.TableMapping.html)
        /// </summary>
        [Output("tableMappings")]
        public Output<string> TableMappings { get; private set; } = null!;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) string that uniquely identifies the target endpoint.
        /// </summary>
        [Output("targetEndpointArn")]
        public Output<string> TargetEndpointArn { get; private set; } = null!;


        /// <summary>
        /// Create a ReplicationConfig resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ReplicationConfig(string name, ReplicationConfigArgs args, CustomResourceOptions? options = null)
            : base("aws:dms/replicationConfig:ReplicationConfig", name, args ?? new ReplicationConfigArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ReplicationConfig(string name, Input<string> id, ReplicationConfigState? state = null, CustomResourceOptions? options = null)
            : base("aws:dms/replicationConfig:ReplicationConfig", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ReplicationConfig resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ReplicationConfig Get(string name, Input<string> id, ReplicationConfigState? state = null, CustomResourceOptions? options = null)
        {
            return new ReplicationConfig(name, id, state, options);
        }
    }

    public sealed class ReplicationConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for provisioning an DMS Serverless replication.
        /// </summary>
        [Input("computeConfig", required: true)]
        public Input<Inputs.ReplicationConfigComputeConfigArgs> ComputeConfig { get; set; } = null!;

        /// <summary>
        /// Unique identifier that you want to use to create the config.
        /// </summary>
        [Input("replicationConfigIdentifier", required: true)]
        public Input<string> ReplicationConfigIdentifier { get; set; } = null!;

        /// <summary>
        /// An escaped JSON string that are used to provision this replication configuration. For example, [Change processing tuning settings](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.CustomizingTasks.TaskSettings.ChangeProcessingTuning.html)
        /// </summary>
        [Input("replicationSettings")]
        public Input<string>? ReplicationSettings { get; set; }

        /// <summary>
        /// The migration type. Can be one of `full-load | cdc | full-load-and-cdc`.
        /// </summary>
        [Input("replicationType", required: true)]
        public Input<string> ReplicationType { get; set; } = null!;

        /// <summary>
        /// Unique value or name that you set for a given resource that can be used to construct an Amazon Resource Name (ARN) for that resource. For more information, see [Fine-grained access control using resource names and tags](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Security.html#CHAP_Security.FineGrainedAccess)
        /// </summary>
        [Input("resourceIdentifier")]
        public Input<string>? ResourceIdentifier { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) string that uniquely identifies the source endpoint.
        /// </summary>
        [Input("sourceEndpointArn", required: true)]
        public Input<string> SourceEndpointArn { get; set; } = null!;

        /// <summary>
        /// Whether to run or stop the serverless replication, default is false.
        /// </summary>
        [Input("startReplication")]
        public Input<bool>? StartReplication { get; set; }

        /// <summary>
        /// JSON settings for specifying supplemental data. For more information see [Specifying supplemental data for task settings](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.TaskData.html)
        /// </summary>
        [Input("supplementalSettings")]
        public Input<string>? SupplementalSettings { get; set; }

        /// <summary>
        /// An escaped JSON string that contains the table mappings. For information on table mapping see [Using Table Mapping with an AWS Database Migration Service Task to Select and Filter Data](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.CustomizingTasks.TableMapping.html)
        /// </summary>
        [Input("tableMappings", required: true)]
        public Input<string> TableMappings { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The Amazon Resource Name (ARN) string that uniquely identifies the target endpoint.
        /// </summary>
        [Input("targetEndpointArn", required: true)]
        public Input<string> TargetEndpointArn { get; set; } = null!;

        public ReplicationConfigArgs()
        {
        }
        public static new ReplicationConfigArgs Empty => new ReplicationConfigArgs();
    }

    public sealed class ReplicationConfigState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) for the serverless replication config.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Configuration block for provisioning an DMS Serverless replication.
        /// </summary>
        [Input("computeConfig")]
        public Input<Inputs.ReplicationConfigComputeConfigGetArgs>? ComputeConfig { get; set; }

        /// <summary>
        /// Unique identifier that you want to use to create the config.
        /// </summary>
        [Input("replicationConfigIdentifier")]
        public Input<string>? ReplicationConfigIdentifier { get; set; }

        /// <summary>
        /// An escaped JSON string that are used to provision this replication configuration. For example, [Change processing tuning settings](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.CustomizingTasks.TaskSettings.ChangeProcessingTuning.html)
        /// </summary>
        [Input("replicationSettings")]
        public Input<string>? ReplicationSettings { get; set; }

        /// <summary>
        /// The migration type. Can be one of `full-load | cdc | full-load-and-cdc`.
        /// </summary>
        [Input("replicationType")]
        public Input<string>? ReplicationType { get; set; }

        /// <summary>
        /// Unique value or name that you set for a given resource that can be used to construct an Amazon Resource Name (ARN) for that resource. For more information, see [Fine-grained access control using resource names and tags](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Security.html#CHAP_Security.FineGrainedAccess)
        /// </summary>
        [Input("resourceIdentifier")]
        public Input<string>? ResourceIdentifier { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) string that uniquely identifies the source endpoint.
        /// </summary>
        [Input("sourceEndpointArn")]
        public Input<string>? SourceEndpointArn { get; set; }

        /// <summary>
        /// Whether to run or stop the serverless replication, default is false.
        /// </summary>
        [Input("startReplication")]
        public Input<bool>? StartReplication { get; set; }

        /// <summary>
        /// JSON settings for specifying supplemental data. For more information see [Specifying supplemental data for task settings](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.TaskData.html)
        /// </summary>
        [Input("supplementalSettings")]
        public Input<string>? SupplementalSettings { get; set; }

        /// <summary>
        /// An escaped JSON string that contains the table mappings. For information on table mapping see [Using Table Mapping with an AWS Database Migration Service Task to Select and Filter Data](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Tasks.CustomizingTasks.TableMapping.html)
        /// </summary>
        [Input("tableMappings")]
        public Input<string>? TableMappings { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        /// <summary>
        /// The Amazon Resource Name (ARN) string that uniquely identifies the target endpoint.
        /// </summary>
        [Input("targetEndpointArn")]
        public Input<string>? TargetEndpointArn { get; set; }

        public ReplicationConfigState()
        {
        }
        public static new ReplicationConfigState Empty => new ReplicationConfigState();
    }
}
