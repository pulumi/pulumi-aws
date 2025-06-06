// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch.Outputs
{

    [OutputType]
    public sealed class GetDomainOffPeakWindowOptionsOffPeakWindowResult
    {
        /// <summary>
        /// 10h window for updates
        /// </summary>
        public readonly ImmutableArray<Outputs.GetDomainOffPeakWindowOptionsOffPeakWindowWindowStartTimeResult> WindowStartTimes;

        [OutputConstructor]
        private GetDomainOffPeakWindowOptionsOffPeakWindowResult(ImmutableArray<Outputs.GetDomainOffPeakWindowOptionsOffPeakWindowWindowStartTimeResult> windowStartTimes)
        {
            WindowStartTimes = windowStartTimes;
        }
    }
}
