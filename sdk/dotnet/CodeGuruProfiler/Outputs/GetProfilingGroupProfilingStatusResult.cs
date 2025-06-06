// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeGuruProfiler.Outputs
{

    [OutputType]
    public sealed class GetProfilingGroupProfilingStatusResult
    {
        public readonly string LatestAgentOrchestratedAt;
        public readonly string LatestAgentProfileReportedAt;
        public readonly ImmutableArray<Outputs.GetProfilingGroupProfilingStatusLatestAggregatedProfileResult> LatestAggregatedProfiles;

        [OutputConstructor]
        private GetProfilingGroupProfilingStatusResult(
            string latestAgentOrchestratedAt,

            string latestAgentProfileReportedAt,

            ImmutableArray<Outputs.GetProfilingGroupProfilingStatusLatestAggregatedProfileResult> latestAggregatedProfiles)
        {
            LatestAgentOrchestratedAt = latestAgentOrchestratedAt;
            LatestAgentProfileReportedAt = latestAgentProfileReportedAt;
            LatestAggregatedProfiles = latestAggregatedProfiles;
        }
    }
}
