// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.FinSpace.Inputs
{

    public sealed class KxClusterScalingGroupConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The number of vCPUs that you want to reserve for each node of this kdb cluster on the scaling group host.
        /// </summary>
        [Input("cpu")]
        public Input<double>? Cpu { get; set; }

        /// <summary>
        /// An optional hard limit on the amount of memory a kdb cluster can use.
        /// </summary>
        [Input("memoryLimit")]
        public Input<int>? MemoryLimit { get; set; }

        /// <summary>
        /// A reservation of the minimum amount of memory that should be available on the scaling group for a kdb cluster to be successfully placed in a scaling group.
        /// </summary>
        [Input("memoryReservation", required: true)]
        public Input<int> MemoryReservation { get; set; } = null!;

        /// <summary>
        /// The number of kdb cluster nodes.
        /// </summary>
        [Input("nodeCount", required: true)]
        public Input<int> NodeCount { get; set; } = null!;

        /// <summary>
        /// A unique identifier for the kdb scaling group.
        /// </summary>
        [Input("scalingGroupName", required: true)]
        public Input<string> ScalingGroupName { get; set; } = null!;

        public KxClusterScalingGroupConfigurationArgs()
        {
        }
        public static new KxClusterScalingGroupConfigurationArgs Empty => new KxClusterScalingGroupConfigurationArgs();
    }
}
