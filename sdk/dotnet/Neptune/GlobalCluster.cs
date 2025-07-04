// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Neptune
{
    /// <summary>
    /// Manages a Neptune Global Cluster. A global cluster consists of one primary region and up to five read-only secondary regions. You issue write operations directly to the primary cluster in the primary region and Amazon Neptune automatically replicates the data to the secondary regions using dedicated infrastructure.
    /// 
    /// More information about Neptune Global Clusters can be found in the [Neptune User Guide](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-global-database.html).
    /// 
    /// ## Example Usage
    /// 
    /// ### New Neptune Global Cluster
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Neptune.GlobalCluster("example", new()
    ///     {
    ///         GlobalClusterIdentifier = "global-test",
    ///         Engine = "neptune",
    ///         EngineVersion = "1.2.0.0",
    ///     });
    /// 
    ///     var primary = new Aws.Neptune.Cluster("primary", new()
    ///     {
    ///         Engine = example.Engine,
    ///         EngineVersion = example.EngineVersion,
    ///         ClusterIdentifier = "test-primary-cluster",
    ///         GlobalClusterIdentifier = example.Id,
    ///         NeptuneSubnetGroupName = "default",
    ///     });
    /// 
    ///     var primaryClusterInstance = new Aws.Neptune.ClusterInstance("primary", new()
    ///     {
    ///         Engine = example.Engine,
    ///         EngineVersion = example.EngineVersion,
    ///         Identifier = "test-primary-cluster-instance",
    ///         ClusterIdentifier = primary.Id,
    ///         InstanceClass = "db.r5.large",
    ///         NeptuneSubnetGroupName = "default",
    ///     });
    /// 
    ///     var secondary = new Aws.Neptune.Cluster("secondary", new()
    ///     {
    ///         Engine = example.Engine,
    ///         EngineVersion = example.EngineVersion,
    ///         ClusterIdentifier = "test-secondary-cluster",
    ///         GlobalClusterIdentifier = example.Id,
    ///         NeptuneSubnetGroupName = "default",
    ///     });
    /// 
    ///     var secondaryClusterInstance = new Aws.Neptune.ClusterInstance("secondary", new()
    ///     {
    ///         Engine = example.Engine,
    ///         EngineVersion = example.EngineVersion,
    ///         Identifier = "test-secondary-cluster-instance",
    ///         ClusterIdentifier = secondary.Id,
    ///         InstanceClass = "db.r5.large",
    ///         NeptuneSubnetGroupName = "default",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             primaryClusterInstance,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### New Global Cluster From Existing DB Cluster
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Neptune.Cluster("example");
    /// 
    ///     var exampleGlobalCluster = new Aws.Neptune.GlobalCluster("example", new()
    ///     {
    ///         GlobalClusterIdentifier = "example",
    ///         SourceDbClusterIdentifier = example.Arn,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_neptune_global_cluster` using the Global Cluster identifier. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:neptune/globalCluster:GlobalCluster example example
    /// ```
    /// Certain resource arguments, like `source_db_cluster_identifier`, do not have an API method for reading the information after creation. If the argument is set in the Pulumi program on an imported resource, Pulumi will always show a difference. To workaround this behavior, either omit the argument from the Pulumi program or use `ignore_changes` to hide the difference. For example:
    /// </summary>
    [AwsResourceType("aws:neptune/globalCluster:GlobalCluster")]
    public partial class GlobalCluster : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Global Cluster ARN
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// If the Global Cluster should have deletion protection enabled. The database can't be deleted when this value is set to `true`. The default is `false`.
        /// </summary>
        [Output("deletionProtection")]
        public Output<bool?> DeletionProtection { get; private set; } = null!;

        /// <summary>
        /// Name of the database engine to be used for this DB cluster. The provider will only perform drift detection if a configuration value is provided. Current Valid values: `neptune`. Conflicts with `source_db_cluster_identifier`.
        /// </summary>
        [Output("engine")]
        public Output<string> Engine { get; private set; } = null!;

        /// <summary>
        /// Engine version of the global database. Upgrading the engine version will result in all cluster members being immediately updated and will.
        /// </summary>
        [Output("engineVersion")]
        public Output<string> EngineVersion { get; private set; } = null!;

        /// <summary>
        /// Global cluster identifier.
        /// </summary>
        [Output("globalClusterIdentifier")]
        public Output<string> GlobalClusterIdentifier { get; private set; } = null!;

        /// <summary>
        /// Set of objects containing Global Cluster members.
        /// </summary>
        [Output("globalClusterMembers")]
        public Output<ImmutableArray<Outputs.GlobalClusterGlobalClusterMember>> GlobalClusterMembers { get; private set; } = null!;

        /// <summary>
        /// AWS Region-unique, immutable identifier for the global database cluster. This identifier is found in AWS CloudTrail log entries whenever the AWS KMS key for the DB cluster is accessed.
        /// </summary>
        [Output("globalClusterResourceId")]
        public Output<string> GlobalClusterResourceId { get; private set; } = null!;

        /// <summary>
        /// ARN to use as the primary DB Cluster of the Global Cluster on creation. Pulumi cannot perform drift detection of this value.
        /// </summary>
        [Output("sourceDbClusterIdentifier")]
        public Output<string> SourceDbClusterIdentifier { get; private set; } = null!;

        [Output("status")]
        public Output<string> Status { get; private set; } = null!;

        /// <summary>
        /// Whether the DB cluster is encrypted. The default is `false` unless `source_db_cluster_identifier` is specified and encrypted. Pulumi will only perform drift detection if a configuration value is provided.
        /// </summary>
        [Output("storageEncrypted")]
        public Output<bool> StorageEncrypted { get; private set; } = null!;


        /// <summary>
        /// Create a GlobalCluster resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public GlobalCluster(string name, GlobalClusterArgs args, CustomResourceOptions? options = null)
            : base("aws:neptune/globalCluster:GlobalCluster", name, args ?? new GlobalClusterArgs(), MakeResourceOptions(options, ""))
        {
        }

        private GlobalCluster(string name, Input<string> id, GlobalClusterState? state = null, CustomResourceOptions? options = null)
            : base("aws:neptune/globalCluster:GlobalCluster", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing GlobalCluster resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static GlobalCluster Get(string name, Input<string> id, GlobalClusterState? state = null, CustomResourceOptions? options = null)
        {
            return new GlobalCluster(name, id, state, options);
        }
    }

    public sealed class GlobalClusterArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// If the Global Cluster should have deletion protection enabled. The database can't be deleted when this value is set to `true`. The default is `false`.
        /// </summary>
        [Input("deletionProtection")]
        public Input<bool>? DeletionProtection { get; set; }

        /// <summary>
        /// Name of the database engine to be used for this DB cluster. The provider will only perform drift detection if a configuration value is provided. Current Valid values: `neptune`. Conflicts with `source_db_cluster_identifier`.
        /// </summary>
        [Input("engine")]
        public Input<string>? Engine { get; set; }

        /// <summary>
        /// Engine version of the global database. Upgrading the engine version will result in all cluster members being immediately updated and will.
        /// </summary>
        [Input("engineVersion")]
        public Input<string>? EngineVersion { get; set; }

        /// <summary>
        /// Global cluster identifier.
        /// </summary>
        [Input("globalClusterIdentifier", required: true)]
        public Input<string> GlobalClusterIdentifier { get; set; } = null!;

        /// <summary>
        /// ARN to use as the primary DB Cluster of the Global Cluster on creation. Pulumi cannot perform drift detection of this value.
        /// </summary>
        [Input("sourceDbClusterIdentifier")]
        public Input<string>? SourceDbClusterIdentifier { get; set; }

        /// <summary>
        /// Whether the DB cluster is encrypted. The default is `false` unless `source_db_cluster_identifier` is specified and encrypted. Pulumi will only perform drift detection if a configuration value is provided.
        /// </summary>
        [Input("storageEncrypted")]
        public Input<bool>? StorageEncrypted { get; set; }

        public GlobalClusterArgs()
        {
        }
        public static new GlobalClusterArgs Empty => new GlobalClusterArgs();
    }

    public sealed class GlobalClusterState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Global Cluster ARN
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// If the Global Cluster should have deletion protection enabled. The database can't be deleted when this value is set to `true`. The default is `false`.
        /// </summary>
        [Input("deletionProtection")]
        public Input<bool>? DeletionProtection { get; set; }

        /// <summary>
        /// Name of the database engine to be used for this DB cluster. The provider will only perform drift detection if a configuration value is provided. Current Valid values: `neptune`. Conflicts with `source_db_cluster_identifier`.
        /// </summary>
        [Input("engine")]
        public Input<string>? Engine { get; set; }

        /// <summary>
        /// Engine version of the global database. Upgrading the engine version will result in all cluster members being immediately updated and will.
        /// </summary>
        [Input("engineVersion")]
        public Input<string>? EngineVersion { get; set; }

        /// <summary>
        /// Global cluster identifier.
        /// </summary>
        [Input("globalClusterIdentifier")]
        public Input<string>? GlobalClusterIdentifier { get; set; }

        [Input("globalClusterMembers")]
        private InputList<Inputs.GlobalClusterGlobalClusterMemberGetArgs>? _globalClusterMembers;

        /// <summary>
        /// Set of objects containing Global Cluster members.
        /// </summary>
        public InputList<Inputs.GlobalClusterGlobalClusterMemberGetArgs> GlobalClusterMembers
        {
            get => _globalClusterMembers ?? (_globalClusterMembers = new InputList<Inputs.GlobalClusterGlobalClusterMemberGetArgs>());
            set => _globalClusterMembers = value;
        }

        /// <summary>
        /// AWS Region-unique, immutable identifier for the global database cluster. This identifier is found in AWS CloudTrail log entries whenever the AWS KMS key for the DB cluster is accessed.
        /// </summary>
        [Input("globalClusterResourceId")]
        public Input<string>? GlobalClusterResourceId { get; set; }

        /// <summary>
        /// ARN to use as the primary DB Cluster of the Global Cluster on creation. Pulumi cannot perform drift detection of this value.
        /// </summary>
        [Input("sourceDbClusterIdentifier")]
        public Input<string>? SourceDbClusterIdentifier { get; set; }

        [Input("status")]
        public Input<string>? Status { get; set; }

        /// <summary>
        /// Whether the DB cluster is encrypted. The default is `false` unless `source_db_cluster_identifier` is specified and encrypted. Pulumi will only perform drift detection if a configuration value is provided.
        /// </summary>
        [Input("storageEncrypted")]
        public Input<bool>? StorageEncrypted { get; set; }

        public GlobalClusterState()
        {
        }
        public static new GlobalClusterState Empty => new GlobalClusterState();
    }
}
