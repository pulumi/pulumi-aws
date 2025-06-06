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
    public sealed class RecommendationPreferencesExternalMetricsPreference
    {
        /// <summary>
        /// The source options for external metrics preferences. Valid values: `Datadog`, `Dynatrace`, `NewRelic`, `Instana`.
        /// </summary>
        public readonly string Source;

        [OutputConstructor]
        private RecommendationPreferencesExternalMetricsPreference(string source)
        {
            Source = source;
        }
    }
}
