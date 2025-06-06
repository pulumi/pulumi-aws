// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Outputs
{

    [OutputType]
    public sealed class GroupWarmPool
    {
        /// <summary>
        /// Whether instances in the Auto Scaling group can be returned to the warm pool on scale in. The default is to terminate instances in the Auto Scaling group when the group scales in.
        /// </summary>
        public readonly Outputs.GroupWarmPoolInstanceReusePolicy? InstanceReusePolicy;
        /// <summary>
        /// Total maximum number of instances that are allowed to be in the warm pool or in any state except Terminated for the Auto Scaling group.
        /// </summary>
        public readonly int? MaxGroupPreparedCapacity;
        /// <summary>
        /// Minimum number of instances to maintain in the warm pool. This helps you to ensure that there is always a certain number of warmed instances available to handle traffic spikes. Defaults to 0 if not specified.
        /// </summary>
        public readonly int? MinSize;
        /// <summary>
        /// Sets the instance state to transition to after the lifecycle hooks finish. Valid values are: Stopped (default), Running or Hibernated.
        /// </summary>
        public readonly string? PoolState;

        [OutputConstructor]
        private GroupWarmPool(
            Outputs.GroupWarmPoolInstanceReusePolicy? instanceReusePolicy,

            int? maxGroupPreparedCapacity,

            int? minSize,

            string? poolState)
        {
            InstanceReusePolicy = instanceReusePolicy;
            MaxGroupPreparedCapacity = maxGroupPreparedCapacity;
            MinSize = minSize;
            PoolState = poolState;
        }
    }
}
