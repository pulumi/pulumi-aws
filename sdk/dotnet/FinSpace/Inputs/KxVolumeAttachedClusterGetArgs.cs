// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.FinSpace.Inputs
{

    public sealed class KxVolumeAttachedClusterGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("clusterName", required: true)]
        public Input<string> ClusterName { get; set; } = null!;

        [Input("clusterStatus", required: true)]
        public Input<string> ClusterStatus { get; set; } = null!;

        [Input("clusterType", required: true)]
        public Input<string> ClusterType { get; set; } = null!;

        public KxVolumeAttachedClusterGetArgs()
        {
        }
        public static new KxVolumeAttachedClusterGetArgs Empty => new KxVolumeAttachedClusterGetArgs();
    }
}
