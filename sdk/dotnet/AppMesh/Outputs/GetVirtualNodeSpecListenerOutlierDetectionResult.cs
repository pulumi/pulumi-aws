// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Outputs
{

    [OutputType]
    public sealed class GetVirtualNodeSpecListenerOutlierDetectionResult
    {
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerOutlierDetectionBaseEjectionDurationResult> BaseEjectionDurations;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerOutlierDetectionIntervalResult> Intervals;
        public readonly int MaxEjectionPercent;
        public readonly int MaxServerErrors;

        [OutputConstructor]
        private GetVirtualNodeSpecListenerOutlierDetectionResult(
            ImmutableArray<Outputs.GetVirtualNodeSpecListenerOutlierDetectionBaseEjectionDurationResult> baseEjectionDurations,

            ImmutableArray<Outputs.GetVirtualNodeSpecListenerOutlierDetectionIntervalResult> intervals,

            int maxEjectionPercent,

            int maxServerErrors)
        {
            BaseEjectionDurations = baseEjectionDurations;
            Intervals = intervals;
            MaxEjectionPercent = maxEjectionPercent;
            MaxServerErrors = maxServerErrors;
        }
    }
}
