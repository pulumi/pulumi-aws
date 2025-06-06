// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks.Outputs
{

    [OutputType]
    public sealed class CustomLayerLoadBasedAutoScalingDownscaling
    {
        /// <summary>
        /// Custom Cloudwatch auto scaling alarms, to be used as thresholds. This parameter takes a list of up to five alarm names, which are case sensitive and must be in the same region as the stack.
        /// </summary>
        public readonly ImmutableArray<string> Alarms;
        /// <summary>
        /// The CPU utilization threshold, as a percent of the available CPU. A value of -1 disables the threshold.
        /// </summary>
        public readonly double? CpuThreshold;
        /// <summary>
        /// The amount of time (in minutes) after a scaling event occurs that AWS OpsWorks Stacks should ignore metrics and suppress additional scaling events.
        /// </summary>
        public readonly int? IgnoreMetricsTime;
        /// <summary>
        /// The number of instances to add or remove when the load exceeds a threshold.
        /// </summary>
        public readonly int? InstanceCount;
        /// <summary>
        /// The load threshold. A value of -1 disables the threshold.
        /// </summary>
        public readonly double? LoadThreshold;
        /// <summary>
        /// The memory utilization threshold, as a percent of the available memory. A value of -1 disables the threshold.
        /// </summary>
        public readonly double? MemoryThreshold;
        /// <summary>
        /// The amount of time, in minutes, that the load must exceed a threshold before more instances are added or removed.
        /// </summary>
        public readonly int? ThresholdsWaitTime;

        [OutputConstructor]
        private CustomLayerLoadBasedAutoScalingDownscaling(
            ImmutableArray<string> alarms,

            double? cpuThreshold,

            int? ignoreMetricsTime,

            int? instanceCount,

            double? loadThreshold,

            double? memoryThreshold,

            int? thresholdsWaitTime)
        {
            Alarms = alarms;
            CpuThreshold = cpuThreshold;
            IgnoreMetricsTime = ignoreMetricsTime;
            InstanceCount = instanceCount;
            LoadThreshold = loadThreshold;
            MemoryThreshold = memoryThreshold;
            ThresholdsWaitTime = thresholdsWaitTime;
        }
    }
}
