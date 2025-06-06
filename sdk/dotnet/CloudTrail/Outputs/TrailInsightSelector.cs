// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudTrail.Outputs
{

    [OutputType]
    public sealed class TrailInsightSelector
    {
        /// <summary>
        /// Type of insights to log on a trail. Valid values are: `ApiCallRateInsight` and `ApiErrorRateInsight`.
        /// </summary>
        public readonly string InsightType;

        [OutputConstructor]
        private TrailInsightSelector(string insightType)
        {
            InsightType = insightType;
        }
    }
}
