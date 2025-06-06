// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.IvsChat.Outputs
{

    [OutputType]
    public sealed class LoggingConfigurationDestinationConfigurationCloudwatchLogs
    {
        /// <summary>
        /// Name of the Amazon Cloudwatch Logs destination where chat activity will be logged.
        /// </summary>
        public readonly string LogGroupName;

        [OutputConstructor]
        private LoggingConfigurationDestinationConfigurationCloudwatchLogs(string logGroupName)
        {
            LogGroupName = logGroupName;
        }
    }
}
