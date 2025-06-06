// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppConfig.Outputs
{

    [OutputType]
    public sealed class GetEnvironmentMonitorResult
    {
        /// <summary>
        /// ARN of the Amazon CloudWatch alarm.
        /// </summary>
        public readonly string AlarmArn;
        /// <summary>
        /// ARN of an IAM role for AWS AppConfig to monitor.
        /// </summary>
        public readonly string AlarmRoleArn;

        [OutputConstructor]
        private GetEnvironmentMonitorResult(
            string alarmArn,

            string alarmRoleArn)
        {
            AlarmArn = alarmArn;
            AlarmRoleArn = alarmRoleArn;
        }
    }
}
