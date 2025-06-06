// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot.Inputs
{

    public sealed class TopicRuleErrorActionSqsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The URL of the Amazon SQS queue.
        /// </summary>
        [Input("queueUrl", required: true)]
        public Input<string> QueueUrl { get; set; } = null!;

        /// <summary>
        /// The ARN of the IAM role that grants access.
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

        /// <summary>
        /// Specifies whether to use Base64 encoding.
        /// </summary>
        [Input("useBase64", required: true)]
        public Input<bool> UseBase64 { get; set; } = null!;

        public TopicRuleErrorActionSqsGetArgs()
        {
        }
        public static new TopicRuleErrorActionSqsGetArgs Empty => new TopicRuleErrorActionSqsGetArgs();
    }
}
