// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElastiCache
{
    public static class GetReplicationGroup
    {
        /// <summary>
        /// Use this data source to get information about an ElastiCache Replication Group.
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
        ///     var bar = Aws.ElastiCache.GetReplicationGroup.Invoke(new()
        ///     {
        ///         ReplicationGroupId = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetReplicationGroupResult> InvokeAsync(GetReplicationGroupArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetReplicationGroupResult>("aws:elasticache/getReplicationGroup:getReplicationGroup", args ?? new GetReplicationGroupArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get information about an ElastiCache Replication Group.
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
        ///     var bar = Aws.ElastiCache.GetReplicationGroup.Invoke(new()
        ///     {
        ///         ReplicationGroupId = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetReplicationGroupResult> Invoke(GetReplicationGroupInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetReplicationGroupResult>("aws:elasticache/getReplicationGroup:getReplicationGroup", args ?? new GetReplicationGroupInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get information about an ElastiCache Replication Group.
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
        ///     var bar = Aws.ElastiCache.GetReplicationGroup.Invoke(new()
        ///     {
        ///         ReplicationGroupId = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetReplicationGroupResult> Invoke(GetReplicationGroupInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetReplicationGroupResult>("aws:elasticache/getReplicationGroup:getReplicationGroup", args ?? new GetReplicationGroupInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetReplicationGroupArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Identifier for the replication group.
        /// </summary>
        [Input("replicationGroupId", required: true)]
        public string ReplicationGroupId { get; set; } = null!;

        public GetReplicationGroupArgs()
        {
        }
        public static new GetReplicationGroupArgs Empty => new GetReplicationGroupArgs();
    }

    public sealed class GetReplicationGroupInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Identifier for the replication group.
        /// </summary>
        [Input("replicationGroupId", required: true)]
        public Input<string> ReplicationGroupId { get; set; } = null!;

        public GetReplicationGroupInvokeArgs()
        {
        }
        public static new GetReplicationGroupInvokeArgs Empty => new GetReplicationGroupInvokeArgs();
    }


    [OutputType]
    public sealed class GetReplicationGroupResult
    {
        /// <summary>
        /// ARN of the created ElastiCache Replication Group.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Whether an AuthToken (password) is enabled.
        /// </summary>
        public readonly bool AuthTokenEnabled;
        /// <summary>
        /// A flag whether a read-only replica will be automatically promoted to read/write primary if the existing primary fails.
        /// </summary>
        public readonly bool AutomaticFailoverEnabled;
        /// <summary>
        /// Whether cluster mode is enabled or disabled.
        /// </summary>
        public readonly string ClusterMode;
        /// <summary>
        /// The configuration endpoint address to allow host discovery.
        /// </summary>
        public readonly string ConfigurationEndpointAddress;
        /// <summary>
        /// Description of the replication group.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Redis [SLOWLOG](https://redis.io/commands/slowlog) or Redis [Engine Log](https://docs.aws.amazon.com/AmazonElastiCache/latest/red-ug/Log_Delivery.html#Log_contents-engine-log) delivery settings.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetReplicationGroupLogDeliveryConfigurationResult> LogDeliveryConfigurations;
        /// <summary>
        /// Identifiers of all the nodes that are part of this replication group.
        /// </summary>
        public readonly ImmutableArray<string> MemberClusters;
        /// <summary>
        /// Whether Multi-AZ Support is enabled for the replication group.
        /// </summary>
        public readonly bool MultiAzEnabled;
        /// <summary>
        /// The cluster node type.
        /// </summary>
        public readonly string NodeType;
        /// <summary>
        /// The number of cache clusters that the replication group has.
        /// </summary>
        public readonly int NumCacheClusters;
        /// <summary>
        /// Number of node groups (shards) for the replication group.
        /// </summary>
        public readonly int NumNodeGroups;
        /// <summary>
        /// The port number on which the configuration endpoint will accept connections.
        /// </summary>
        public readonly int Port;
        /// <summary>
        /// The endpoint of the primary node in this node group (shard).
        /// </summary>
        public readonly string PrimaryEndpointAddress;
        /// <summary>
        /// The endpoint of the reader node in this node group (shard).
        /// </summary>
        public readonly string ReaderEndpointAddress;
        /// <summary>
        /// Number of replica nodes in each node group.
        /// </summary>
        public readonly int ReplicasPerNodeGroup;
        public readonly string ReplicationGroupId;
        /// <summary>
        /// The number of days for which ElastiCache retains automatic cache cluster snapshots before deleting them.
        /// </summary>
        public readonly int SnapshotRetentionLimit;
        /// <summary>
        /// Daily time range (in UTC) during which ElastiCache begins taking a daily snapshot of your node group (shard).
        /// </summary>
        public readonly string SnapshotWindow;

        [OutputConstructor]
        private GetReplicationGroupResult(
            string arn,

            bool authTokenEnabled,

            bool automaticFailoverEnabled,

            string clusterMode,

            string configurationEndpointAddress,

            string description,

            string id,

            ImmutableArray<Outputs.GetReplicationGroupLogDeliveryConfigurationResult> logDeliveryConfigurations,

            ImmutableArray<string> memberClusters,

            bool multiAzEnabled,

            string nodeType,

            int numCacheClusters,

            int numNodeGroups,

            int port,

            string primaryEndpointAddress,

            string readerEndpointAddress,

            int replicasPerNodeGroup,

            string replicationGroupId,

            int snapshotRetentionLimit,

            string snapshotWindow)
        {
            Arn = arn;
            AuthTokenEnabled = authTokenEnabled;
            AutomaticFailoverEnabled = automaticFailoverEnabled;
            ClusterMode = clusterMode;
            ConfigurationEndpointAddress = configurationEndpointAddress;
            Description = description;
            Id = id;
            LogDeliveryConfigurations = logDeliveryConfigurations;
            MemberClusters = memberClusters;
            MultiAzEnabled = multiAzEnabled;
            NodeType = nodeType;
            NumCacheClusters = numCacheClusters;
            NumNodeGroups = numNodeGroups;
            Port = port;
            PrimaryEndpointAddress = primaryEndpointAddress;
            ReaderEndpointAddress = readerEndpointAddress;
            ReplicasPerNodeGroup = replicasPerNodeGroup;
            ReplicationGroupId = replicationGroupId;
            SnapshotRetentionLimit = snapshotRetentionLimit;
            SnapshotWindow = snapshotWindow;
        }
    }
}
