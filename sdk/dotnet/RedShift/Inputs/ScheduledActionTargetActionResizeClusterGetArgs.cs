// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.RedShift.Inputs
{

    public sealed class ScheduledActionTargetActionResizeClusterGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A boolean value indicating whether the resize operation is using the classic resize process. Default: `false`.
        /// </summary>
        [Input("classic")]
        public Input<bool>? Classic { get; set; }

        /// <summary>
        /// The unique identifier for the cluster to resize.
        /// </summary>
        [Input("clusterIdentifier", required: true)]
        public Input<string> ClusterIdentifier { get; set; } = null!;

        /// <summary>
        /// The new cluster type for the specified cluster.
        /// </summary>
        [Input("clusterType")]
        public Input<string>? ClusterType { get; set; }

        /// <summary>
        /// The new node type for the nodes you are adding.
        /// </summary>
        [Input("nodeType")]
        public Input<string>? NodeType { get; set; }

        /// <summary>
        /// The new number of nodes for the cluster.
        /// </summary>
        [Input("numberOfNodes")]
        public Input<int>? NumberOfNodes { get; set; }

        public ScheduledActionTargetActionResizeClusterGetArgs()
        {
        }
        public static new ScheduledActionTargetActionResizeClusterGetArgs Empty => new ScheduledActionTargetActionResizeClusterGetArgs();
    }
}
