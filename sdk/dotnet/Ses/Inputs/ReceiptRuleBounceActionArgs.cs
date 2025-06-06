// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ses.Inputs
{

    public sealed class ReceiptRuleBounceActionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The message to send
        /// </summary>
        [Input("message", required: true)]
        public Input<string> Message { get; set; } = null!;

        /// <summary>
        /// The position of the action in the receipt rule
        /// </summary>
        [Input("position", required: true)]
        public Input<int> Position { get; set; } = null!;

        /// <summary>
        /// The email address of the sender
        /// </summary>
        [Input("sender", required: true)]
        public Input<string> Sender { get; set; } = null!;

        /// <summary>
        /// The RFC 5321 SMTP reply code
        /// </summary>
        [Input("smtpReplyCode", required: true)]
        public Input<string> SmtpReplyCode { get; set; } = null!;

        /// <summary>
        /// The RFC 3463 SMTP enhanced status code
        /// </summary>
        [Input("statusCode")]
        public Input<string>? StatusCode { get; set; }

        /// <summary>
        /// The ARN of an SNS topic to notify
        /// </summary>
        [Input("topicArn")]
        public Input<string>? TopicArn { get; set; }

        public ReceiptRuleBounceActionArgs()
        {
        }
        public static new ReceiptRuleBounceActionArgs Empty => new ReceiptRuleBounceActionArgs();
    }
}
