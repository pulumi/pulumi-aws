// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DocDB
{
    /// <summary>
    /// Manages an AWS DocDB (DocumentDB) Elastic Cluster.
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
    ///     var example = new Aws.DocDB.ElasticCluster("example", new()
    ///     {
    ///         Name = "my-docdb-cluster",
    ///         AdminUserName = "foo",
    ///         AdminUserPassword = "mustbeeightchars",
    ///         AuthType = "PLAIN_TEXT",
    ///         ShardCapacity = 2,
    ///         ShardCount = 1,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import DocDB (DocumentDB) Elastic Cluster using the `arn` argument. For example,
    /// 
    /// ```sh
    /// $ pulumi import aws:docdb/elasticCluster:ElasticCluster example arn:aws:docdb-elastic:us-east-1:000011112222:cluster/12345678-7abc-def0-1234-56789abcdef
    /// ```
    /// </summary>
    [AwsResourceType("aws:docdb/elasticCluster:ElasticCluster")]
    public partial class ElasticCluster : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Name of the Elastic DocumentDB cluster administrator
        /// </summary>
        [Output("adminUserName")]
        public Output<string> AdminUserName { get; private set; } = null!;

        /// <summary>
        /// Password for the Elastic DocumentDB cluster administrator. Can contain any printable ASCII characters. Must be at least 8 characters
        /// </summary>
        [Output("adminUserPassword")]
        public Output<string> AdminUserPassword { get; private set; } = null!;

        /// <summary>
        /// ARN of the DocumentDB Elastic Cluster
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Authentication type for the Elastic DocumentDB cluster. Valid values are `PLAIN_TEXT` and `SECRET_ARN`
        /// </summary>
        [Output("authType")]
        public Output<string> AuthType { get; private set; } = null!;

        /// <summary>
        /// The number of days for which automatic snapshots are retained. It should be in between 1 and 35. If not specified, the default value of 1 is set.
        /// </summary>
        [Output("backupRetentionPeriod")]
        public Output<int> BackupRetentionPeriod { get; private set; } = null!;

        /// <summary>
        /// The DNS address of the DocDB instance
        /// </summary>
        [Output("endpoint")]
        public Output<string> Endpoint { get; private set; } = null!;

        /// <summary>
        /// ARN of a KMS key that is used to encrypt the Elastic DocumentDB cluster. If not specified, the default encryption key that KMS creates for your account is used.
        /// </summary>
        [Output("kmsKeyId")]
        public Output<string> KmsKeyId { get; private set; } = null!;

        /// <summary>
        /// Name of the Elastic DocumentDB cluster
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The daily time range during which automated backups are created if automated backups are enabled, as determined by the `backup_retention_period`.
        /// </summary>
        [Output("preferredBackupWindow")]
        public Output<string> PreferredBackupWindow { get; private set; } = null!;

        /// <summary>
        /// Weekly time range during which system maintenance can occur in UTC. Format: `ddd:hh24:mi-ddd:hh24:mi`. If not specified, AWS will choose a random 30-minute window on a random day of the week.
        /// </summary>
        [Output("preferredMaintenanceWindow")]
        public Output<string> PreferredMaintenanceWindow { get; private set; } = null!;

        /// <summary>
        /// Number of vCPUs assigned to each elastic cluster shard. Maximum is 64. Allowed values are 2, 4, 8, 16, 32, 64
        /// </summary>
        [Output("shardCapacity")]
        public Output<int> ShardCapacity { get; private set; } = null!;

        /// <summary>
        /// Number of shards assigned to the elastic cluster. Maximum is 32
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("shardCount")]
        public Output<int> ShardCount { get; private set; } = null!;

        /// <summary>
        /// IDs of subnets in which the Elastic DocumentDB Cluster operates.
        /// </summary>
        [Output("subnetIds")]
        public Output<ImmutableArray<string>> SubnetIds { get; private set; } = null!;

        /// <summary>
        /// A map of tags to assign to the collection. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.ElasticClusterTimeouts?> Timeouts { get; private set; } = null!;

        /// <summary>
        /// List of VPC security groups to associate with the Elastic DocumentDB Cluster
        /// 
        /// For more detailed documentation about each argument, refer to
        /// the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/docdb-elastic/create-cluster.html).
        /// </summary>
        [Output("vpcSecurityGroupIds")]
        public Output<ImmutableArray<string>> VpcSecurityGroupIds { get; private set; } = null!;


        /// <summary>
        /// Create a ElasticCluster resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ElasticCluster(string name, ElasticClusterArgs args, CustomResourceOptions? options = null)
            : base("aws:docdb/elasticCluster:ElasticCluster", name, args ?? new ElasticClusterArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ElasticCluster(string name, Input<string> id, ElasticClusterState? state = null, CustomResourceOptions? options = null)
            : base("aws:docdb/elasticCluster:ElasticCluster", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "adminUserPassword",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing ElasticCluster resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ElasticCluster Get(string name, Input<string> id, ElasticClusterState? state = null, CustomResourceOptions? options = null)
        {
            return new ElasticCluster(name, id, state, options);
        }
    }

    public sealed class ElasticClusterArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the Elastic DocumentDB cluster administrator
        /// </summary>
        [Input("adminUserName", required: true)]
        public Input<string> AdminUserName { get; set; } = null!;

        [Input("adminUserPassword", required: true)]
        private Input<string>? _adminUserPassword;

        /// <summary>
        /// Password for the Elastic DocumentDB cluster administrator. Can contain any printable ASCII characters. Must be at least 8 characters
        /// </summary>
        public Input<string>? AdminUserPassword
        {
            get => _adminUserPassword;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _adminUserPassword = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// Authentication type for the Elastic DocumentDB cluster. Valid values are `PLAIN_TEXT` and `SECRET_ARN`
        /// </summary>
        [Input("authType", required: true)]
        public Input<string> AuthType { get; set; } = null!;

        /// <summary>
        /// The number of days for which automatic snapshots are retained. It should be in between 1 and 35. If not specified, the default value of 1 is set.
        /// </summary>
        [Input("backupRetentionPeriod")]
        public Input<int>? BackupRetentionPeriod { get; set; }

        /// <summary>
        /// ARN of a KMS key that is used to encrypt the Elastic DocumentDB cluster. If not specified, the default encryption key that KMS creates for your account is used.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// Name of the Elastic DocumentDB cluster
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The daily time range during which automated backups are created if automated backups are enabled, as determined by the `backup_retention_period`.
        /// </summary>
        [Input("preferredBackupWindow")]
        public Input<string>? PreferredBackupWindow { get; set; }

        /// <summary>
        /// Weekly time range during which system maintenance can occur in UTC. Format: `ddd:hh24:mi-ddd:hh24:mi`. If not specified, AWS will choose a random 30-minute window on a random day of the week.
        /// </summary>
        [Input("preferredMaintenanceWindow")]
        public Input<string>? PreferredMaintenanceWindow { get; set; }

        /// <summary>
        /// Number of vCPUs assigned to each elastic cluster shard. Maximum is 64. Allowed values are 2, 4, 8, 16, 32, 64
        /// </summary>
        [Input("shardCapacity", required: true)]
        public Input<int> ShardCapacity { get; set; } = null!;

        /// <summary>
        /// Number of shards assigned to the elastic cluster. Maximum is 32
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("shardCount", required: true)]
        public Input<int> ShardCount { get; set; } = null!;

        [Input("subnetIds")]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// IDs of subnets in which the Elastic DocumentDB Cluster operates.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the collection. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("timeouts")]
        public Input<Inputs.ElasticClusterTimeoutsArgs>? Timeouts { get; set; }

        [Input("vpcSecurityGroupIds")]
        private InputList<string>? _vpcSecurityGroupIds;

        /// <summary>
        /// List of VPC security groups to associate with the Elastic DocumentDB Cluster
        /// 
        /// For more detailed documentation about each argument, refer to
        /// the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/docdb-elastic/create-cluster.html).
        /// </summary>
        public InputList<string> VpcSecurityGroupIds
        {
            get => _vpcSecurityGroupIds ?? (_vpcSecurityGroupIds = new InputList<string>());
            set => _vpcSecurityGroupIds = value;
        }

        public ElasticClusterArgs()
        {
        }
        public static new ElasticClusterArgs Empty => new ElasticClusterArgs();
    }

    public sealed class ElasticClusterState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the Elastic DocumentDB cluster administrator
        /// </summary>
        [Input("adminUserName")]
        public Input<string>? AdminUserName { get; set; }

        [Input("adminUserPassword")]
        private Input<string>? _adminUserPassword;

        /// <summary>
        /// Password for the Elastic DocumentDB cluster administrator. Can contain any printable ASCII characters. Must be at least 8 characters
        /// </summary>
        public Input<string>? AdminUserPassword
        {
            get => _adminUserPassword;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _adminUserPassword = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// ARN of the DocumentDB Elastic Cluster
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Authentication type for the Elastic DocumentDB cluster. Valid values are `PLAIN_TEXT` and `SECRET_ARN`
        /// </summary>
        [Input("authType")]
        public Input<string>? AuthType { get; set; }

        /// <summary>
        /// The number of days for which automatic snapshots are retained. It should be in between 1 and 35. If not specified, the default value of 1 is set.
        /// </summary>
        [Input("backupRetentionPeriod")]
        public Input<int>? BackupRetentionPeriod { get; set; }

        /// <summary>
        /// The DNS address of the DocDB instance
        /// </summary>
        [Input("endpoint")]
        public Input<string>? Endpoint { get; set; }

        /// <summary>
        /// ARN of a KMS key that is used to encrypt the Elastic DocumentDB cluster. If not specified, the default encryption key that KMS creates for your account is used.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// Name of the Elastic DocumentDB cluster
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The daily time range during which automated backups are created if automated backups are enabled, as determined by the `backup_retention_period`.
        /// </summary>
        [Input("preferredBackupWindow")]
        public Input<string>? PreferredBackupWindow { get; set; }

        /// <summary>
        /// Weekly time range during which system maintenance can occur in UTC. Format: `ddd:hh24:mi-ddd:hh24:mi`. If not specified, AWS will choose a random 30-minute window on a random day of the week.
        /// </summary>
        [Input("preferredMaintenanceWindow")]
        public Input<string>? PreferredMaintenanceWindow { get; set; }

        /// <summary>
        /// Number of vCPUs assigned to each elastic cluster shard. Maximum is 64. Allowed values are 2, 4, 8, 16, 32, 64
        /// </summary>
        [Input("shardCapacity")]
        public Input<int>? ShardCapacity { get; set; }

        /// <summary>
        /// Number of shards assigned to the elastic cluster. Maximum is 32
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("shardCount")]
        public Input<int>? ShardCount { get; set; }

        [Input("subnetIds")]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// IDs of subnets in which the Elastic DocumentDB Cluster operates.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the collection. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        [Input("timeouts")]
        public Input<Inputs.ElasticClusterTimeoutsGetArgs>? Timeouts { get; set; }

        [Input("vpcSecurityGroupIds")]
        private InputList<string>? _vpcSecurityGroupIds;

        /// <summary>
        /// List of VPC security groups to associate with the Elastic DocumentDB Cluster
        /// 
        /// For more detailed documentation about each argument, refer to
        /// the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/docdb-elastic/create-cluster.html).
        /// </summary>
        public InputList<string> VpcSecurityGroupIds
        {
            get => _vpcSecurityGroupIds ?? (_vpcSecurityGroupIds = new InputList<string>());
            set => _vpcSecurityGroupIds = value;
        }

        public ElasticClusterState()
        {
        }
        public static new ElasticClusterState Empty => new ElasticClusterState();
    }
}
