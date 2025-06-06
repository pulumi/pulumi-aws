// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Eks.Inputs
{

    public sealed class NodeGroupUpdateConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Desired max number of unavailable worker nodes during node group update.
        /// </summary>
        [Input("maxUnavailable")]
        public Input<int>? MaxUnavailable { get; set; }

        /// <summary>
        /// Desired max percentage of unavailable worker nodes during node group update.
        /// </summary>
        [Input("maxUnavailablePercentage")]
        public Input<int>? MaxUnavailablePercentage { get; set; }

        public NodeGroupUpdateConfigArgs()
        {
        }
        public static new NodeGroupUpdateConfigArgs Empty => new NodeGroupUpdateConfigArgs();
    }
}
