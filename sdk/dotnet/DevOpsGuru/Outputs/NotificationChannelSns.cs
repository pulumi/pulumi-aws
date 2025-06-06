// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DevOpsGuru.Outputs
{

    [OutputType]
    public sealed class NotificationChannelSns
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of an Amazon Simple Notification Service topic.
        /// </summary>
        public readonly string TopicArn;

        [OutputConstructor]
        private NotificationChannelSns(string topicArn)
        {
            TopicArn = topicArn;
        }
    }
}
