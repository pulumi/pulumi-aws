// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedAccess.Outputs
{

    [OutputType]
    public sealed class InstanceLoggingConfigurationAccessLogsCloudwatchLogs
    {
        /// <summary>
        /// Indicates whether logging is enabled.
        /// </summary>
        public readonly bool Enabled;
        /// <summary>
        /// The name of the CloudWatch Logs Log Group.
        /// </summary>
        public readonly string? LogGroup;

        [OutputConstructor]
        private InstanceLoggingConfigurationAccessLogsCloudwatchLogs(
            bool enabled,

            string? logGroup)
        {
            Enabled = enabled;
            LogGroup = logGroup;
        }
    }
}
