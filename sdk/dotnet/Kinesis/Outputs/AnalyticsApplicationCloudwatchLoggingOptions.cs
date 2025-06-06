// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Outputs
{

    [OutputType]
    public sealed class AnalyticsApplicationCloudwatchLoggingOptions
    {
        /// <summary>
        /// The ARN of the Kinesis Analytics Application.
        /// </summary>
        public readonly string? Id;
        /// <summary>
        /// The ARN of the CloudWatch Log Stream.
        /// </summary>
        public readonly string LogStreamArn;
        /// <summary>
        /// The ARN of the IAM Role used to send application messages.
        /// </summary>
        public readonly string RoleArn;

        [OutputConstructor]
        private AnalyticsApplicationCloudwatchLoggingOptions(
            string? id,

            string logStreamArn,

            string roleArn)
        {
            Id = id;
            LogStreamArn = logStreamArn;
            RoleArn = roleArn;
        }
    }
}
