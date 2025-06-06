// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MemoryDb.Inputs
{

    public sealed class ClusterShardGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the cluster. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("nodes")]
        private InputList<Inputs.ClusterShardNodeGetArgs>? _nodes;

        /// <summary>
        /// Set of nodes in this shard.
        /// </summary>
        public InputList<Inputs.ClusterShardNodeGetArgs> Nodes
        {
            get => _nodes ?? (_nodes = new InputList<Inputs.ClusterShardNodeGetArgs>());
            set => _nodes = value;
        }

        /// <summary>
        /// Number of individual nodes in this shard.
        /// </summary>
        [Input("numNodes")]
        public Input<int>? NumNodes { get; set; }

        /// <summary>
        /// Keyspace for this shard. Example: `0-16383`.
        /// </summary>
        [Input("slots")]
        public Input<string>? Slots { get; set; }

        public ClusterShardGetArgs()
        {
        }
        public static new ClusterShardGetArgs Empty => new ClusterShardGetArgs();
    }
}
