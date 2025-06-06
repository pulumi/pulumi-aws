// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.RedShift.Inputs
{

    public sealed class ScheduledActionTargetActionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// An action that runs a `PauseCluster` API operation. Documented below.
        /// </summary>
        [Input("pauseCluster")]
        public Input<Inputs.ScheduledActionTargetActionPauseClusterArgs>? PauseCluster { get; set; }

        /// <summary>
        /// An action that runs a `ResizeCluster` API operation. Documented below.
        /// </summary>
        [Input("resizeCluster")]
        public Input<Inputs.ScheduledActionTargetActionResizeClusterArgs>? ResizeCluster { get; set; }

        /// <summary>
        /// An action that runs a `ResumeCluster` API operation. Documented below.
        /// </summary>
        [Input("resumeCluster")]
        public Input<Inputs.ScheduledActionTargetActionResumeClusterArgs>? ResumeCluster { get; set; }

        public ScheduledActionTargetActionArgs()
        {
        }
        public static new ScheduledActionTargetActionArgs Empty => new ScheduledActionTargetActionArgs();
    }
}
