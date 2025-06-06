// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.FinSpace.Outputs
{

    [OutputType]
    public sealed class KxClusterAutoScalingConfiguration
    {
        /// <summary>
        /// Metric your cluster will track in order to scale in and out. For example, CPU_UTILIZATION_PERCENTAGE is the average CPU usage across all nodes in a cluster.
        /// </summary>
        public readonly string AutoScalingMetric;
        /// <summary>
        /// Highest number of nodes to scale. Cannot be greater than 5
        /// </summary>
        public readonly int MaxNodeCount;
        /// <summary>
        /// Desired value of chosen `auto_scaling_metric`. When metric drops below this value, cluster will scale in. When metric goes above this value, cluster will scale out. Can be set between 0 and 100 percent.
        /// </summary>
        public readonly double MetricTarget;
        /// <summary>
        /// Lowest number of nodes to scale. Must be at least 1 and less than the `max_node_count`. If nodes in cluster belong to multiple availability zones, then `min_node_count` must be at least 3.
        /// </summary>
        public readonly int MinNodeCount;
        /// <summary>
        /// Duration in seconds that FinSpace will wait after a scale in event before initiating another scaling event.
        /// </summary>
        public readonly double ScaleInCooldownSeconds;
        /// <summary>
        /// Duration in seconds that FinSpace will wait after a scale out event before initiating another scaling event.
        /// </summary>
        public readonly double ScaleOutCooldownSeconds;

        [OutputConstructor]
        private KxClusterAutoScalingConfiguration(
            string autoScalingMetric,

            int maxNodeCount,

            double metricTarget,

            int minNodeCount,

            double scaleInCooldownSeconds,

            double scaleOutCooldownSeconds)
        {
            AutoScalingMetric = autoScalingMetric;
            MaxNodeCount = maxNodeCount;
            MetricTarget = metricTarget;
            MinNodeCount = minNodeCount;
            ScaleInCooldownSeconds = scaleInCooldownSeconds;
            ScaleOutCooldownSeconds = scaleOutCooldownSeconds;
        }
    }
}
