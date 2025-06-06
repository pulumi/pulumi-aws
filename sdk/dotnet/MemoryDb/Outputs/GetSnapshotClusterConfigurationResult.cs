// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MemoryDb.Outputs
{

    [OutputType]
    public sealed class GetSnapshotClusterConfigurationResult
    {
        /// <summary>
        /// Description for the cluster.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// The engine that will run on cluster nodes.
        /// </summary>
        public readonly string Engine;
        /// <summary>
        /// Version number of the engine used by the cluster.
        /// </summary>
        public readonly string EngineVersion;
        /// <summary>
        /// The weekly time range during which maintenance on the cluster is performed.
        /// </summary>
        public readonly string MaintenanceWindow;
        /// <summary>
        /// Name of the snapshot.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Compute and memory capacity of the nodes in the cluster.
        /// </summary>
        public readonly string NodeType;
        /// <summary>
        /// Number of shards in the cluster.
        /// </summary>
        public readonly int NumShards;
        /// <summary>
        /// Name of the parameter group associated with the cluster.
        /// </summary>
        public readonly string ParameterGroupName;
        /// <summary>
        /// Port number on which the cluster accepts connections.
        /// </summary>
        public readonly int Port;
        /// <summary>
        /// Number of days for which MemoryDB retains automatic snapshots before deleting them.
        /// </summary>
        public readonly int SnapshotRetentionLimit;
        /// <summary>
        /// The daily time range (in UTC) during which MemoryDB begins taking a daily snapshot of the shard.
        /// </summary>
        public readonly string SnapshotWindow;
        /// <summary>
        /// Name of the subnet group used by the cluster.
        /// </summary>
        public readonly string SubnetGroupName;
        /// <summary>
        /// ARN of the SNS topic to which cluster notifications are sent.
        /// </summary>
        public readonly string TopicArn;
        /// <summary>
        /// The VPC in which the cluster exists.
        /// </summary>
        public readonly string VpcId;

        [OutputConstructor]
        private GetSnapshotClusterConfigurationResult(
            string description,

            string engine,

            string engineVersion,

            string maintenanceWindow,

            string name,

            string nodeType,

            int numShards,

            string parameterGroupName,

            int port,

            int snapshotRetentionLimit,

            string snapshotWindow,

            string subnetGroupName,

            string topicArn,

            string vpcId)
        {
            Description = description;
            Engine = engine;
            EngineVersion = engineVersion;
            MaintenanceWindow = maintenanceWindow;
            Name = name;
            NodeType = nodeType;
            NumShards = numShards;
            ParameterGroupName = parameterGroupName;
            Port = port;
            SnapshotRetentionLimit = snapshotRetentionLimit;
            SnapshotWindow = snapshotWindow;
            SubnetGroupName = subnetGroupName;
            TopicArn = topicArn;
            VpcId = vpcId;
        }
    }
}
