// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Evidently.Outputs
{

    [OutputType]
    public sealed class LaunchScheduledSplitsConfigStepSegmentOverride
    {
        /// <summary>
        /// Specifies a number indicating the order to use to evaluate segment overrides, if there are more than one. Segment overrides with lower numbers are evaluated first.
        /// </summary>
        public readonly int EvaluationOrder;
        /// <summary>
        /// The name or ARN of the segment to use.
        /// </summary>
        public readonly string Segment;
        /// <summary>
        /// The traffic allocation percentages among the feature variations to assign to this segment. This is a set of key-value pairs. The keys are variation names. The values represent the amount of traffic to allocate to that variation for this segment. This is expressed in thousandths of a percent, so a weight of 50000 represents 50% of traffic.
        /// </summary>
        public readonly ImmutableDictionary<string, int> Weights;

        [OutputConstructor]
        private LaunchScheduledSplitsConfigStepSegmentOverride(
            int evaluationOrder,

            string segment,

            ImmutableDictionary<string, int> weights)
        {
            EvaluationOrder = evaluationOrder;
            Segment = segment;
            Weights = weights;
        }
    }
}
