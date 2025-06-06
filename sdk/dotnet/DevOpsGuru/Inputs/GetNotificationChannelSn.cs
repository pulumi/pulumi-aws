// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DevOpsGuru.Inputs
{

    public sealed class GetNotificationChannelSnArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of an Amazon Simple Notification Service topic.
        /// </summary>
        [Input("topicArn", required: true)]
        public string TopicArn { get; set; } = null!;

        public GetNotificationChannelSnArgs()
        {
        }
        public static new GetNotificationChannelSnArgs Empty => new GetNotificationChannelSnArgs();
    }
}
