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
    public sealed class DomainLogPublishingOption
    {
        /// <summary>
        /// ARN of the Cloudwatch log group to which log needs to be published.
        /// </summary>
        public readonly string CloudwatchLogGroupArn;
        /// <summary>
        /// Whether given log publishing option is enabled or not.
        /// </summary>
        public readonly bool? Enabled;
        /// <summary>
        /// Type of OpenSearch log. Valid values: `INDEX_SLOW_LOGS`, `SEARCH_SLOW_LOGS`, `ES_APPLICATION_LOGS`, `AUDIT_LOGS`.
        /// </summary>
        public readonly string LogType;

        [OutputConstructor]
        private DomainLogPublishingOption(
            string cloudwatchLogGroupArn,

            bool? enabled,

            string logType)
        {
            CloudwatchLogGroupArn = cloudwatchLogGroupArn;
            Enabled = enabled;
            LogType = logType;
        }
    }
}
