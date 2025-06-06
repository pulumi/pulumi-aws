// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppStream.Inputs
{

    public sealed class FleetComputeCapacityArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Number of currently available instances that can be used to stream sessions.
        /// </summary>
        [Input("available")]
        public Input<int>? Available { get; set; }

        /// <summary>
        /// Desired number of streaming instances.
        /// </summary>
        [Input("desiredInstances")]
        public Input<int>? DesiredInstances { get; set; }

        /// <summary>
        /// Desired number of user sessions for a multi-session fleet. This is not allowed for single-session fleets.
        /// </summary>
        [Input("desiredSessions")]
        public Input<int>? DesiredSessions { get; set; }

        /// <summary>
        /// Number of instances in use for streaming.
        /// </summary>
        [Input("inUse")]
        public Input<int>? InUse { get; set; }

        /// <summary>
        /// Total number of simultaneous streaming instances that are running.
        /// </summary>
        [Input("running")]
        public Input<int>? Running { get; set; }

        public FleetComputeCapacityArgs()
        {
        }
        public static new FleetComputeCapacityArgs Empty => new FleetComputeCapacityArgs();
    }
}
