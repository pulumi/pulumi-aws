// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElasticSearch.Outputs
{

    [OutputType]
    public sealed class GetDomainLogPublishingOptionResult
    {
        /// <summary>
        /// The CloudWatch Log Group where the logs are published.
        /// </summary>
        public readonly string CloudwatchLogGroupArn;
        /// <summary>
        /// Whether node to node encryption is enabled.
        /// </summary>
        public readonly bool Enabled;
        /// <summary>
        /// The type of Elasticsearch log being published.
        /// </summary>
        public readonly string LogType;

        [OutputConstructor]
        private GetDomainLogPublishingOptionResult(
            string cloudwatchLogGroupArn,

            bool enabled,

            string logType)
        {
            CloudwatchLogGroupArn = cloudwatchLogGroupArn;
            Enabled = enabled;
            LogType = logType;
        }
    }
}
