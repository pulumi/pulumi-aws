// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot.Outputs
{

    [OutputType]
    public sealed class TopicRuleFirehose
    {
        /// <summary>
        /// The payload that contains a JSON array of records will be sent to Kinesis Firehose via a batch call.
        /// </summary>
        public readonly bool? BatchMode;
        /// <summary>
        /// The delivery stream name.
        /// </summary>
        public readonly string DeliveryStreamName;
        /// <summary>
        /// The IAM role ARN that grants access to the Amazon Kinesis Firehose stream.
        /// </summary>
        public readonly string RoleArn;
        /// <summary>
        /// A character separator that is used to separate records written to the Firehose stream. Valid values are: '\n' (newline), '\t' (tab), '\r\n' (Windows newline), ',' (comma).
        /// </summary>
        public readonly string? Separator;

        [OutputConstructor]
        private TopicRuleFirehose(
            bool? batchMode,

            string deliveryStreamName,

            string roleArn,

            string? separator)
        {
            BatchMode = batchMode;
            DeliveryStreamName = deliveryStreamName;
            RoleArn = roleArn;
            Separator = separator;
        }
    }
}
