// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Dms.Outputs
{

    [OutputType]
    public sealed class GetEndpointElasticsearchSettingResult
    {
        public readonly string EndpointUri;
        public readonly int ErrorRetryDuration;
        public readonly int FullLoadErrorPercentage;
        public readonly string ServiceAccessRoleArn;

        [OutputConstructor]
        private GetEndpointElasticsearchSettingResult(
            string endpointUri,

            int errorRetryDuration,

            int fullLoadErrorPercentage,

            string serviceAccessRoleArn)
        {
            EndpointUri = endpointUri;
            ErrorRetryDuration = errorRetryDuration;
            FullLoadErrorPercentage = fullLoadErrorPercentage;
            ServiceAccessRoleArn = serviceAccessRoleArn;
        }
    }
}
