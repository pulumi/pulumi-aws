// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedAccess.Inputs
{

    public sealed class InstanceLoggingConfigurationAccessLogsCloudwatchLogsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates whether logging is enabled.
        /// </summary>
        [Input("enabled", required: true)]
        public Input<bool> Enabled { get; set; } = null!;

        /// <summary>
        /// The name of the CloudWatch Logs Log Group.
        /// </summary>
        [Input("logGroup")]
        public Input<string>? LogGroup { get; set; }

        public InstanceLoggingConfigurationAccessLogsCloudwatchLogsGetArgs()
        {
        }
        public static new InstanceLoggingConfigurationAccessLogsCloudwatchLogsGetArgs Empty => new InstanceLoggingConfigurationAccessLogsCloudwatchLogsGetArgs();
    }
}
