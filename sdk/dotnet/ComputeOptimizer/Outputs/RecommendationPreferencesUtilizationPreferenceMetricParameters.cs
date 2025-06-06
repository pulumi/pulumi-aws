// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ComputeOptimizer.Outputs
{

    [OutputType]
    public sealed class RecommendationPreferencesUtilizationPreferenceMetricParameters
    {
        /// <summary>
        /// The headroom value in percentage used for the specified metric parameter. Valid values: `PERCENT_30`, `PERCENT_20`, `PERCENT_10`, `PERCENT_0`.
        /// </summary>
        public readonly string Headroom;
        /// <summary>
        /// The threshold value used for the specified metric parameter. You can only specify the threshold value for CPU utilization. Valid values: `P90`, `P95`, `P99_5`.
        /// </summary>
        public readonly string? Threshold;

        [OutputConstructor]
        private RecommendationPreferencesUtilizationPreferenceMetricParameters(
            string headroom,

            string? threshold)
        {
            Headroom = headroom;
            Threshold = threshold;
        }
    }
}
