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
    public sealed class TopicRuleErrorActionDynamodbv2
    {
        /// <summary>
        /// Configuration block with DynamoDB Table to which the message will be written. Nested arguments below.
        /// </summary>
        public readonly Outputs.TopicRuleErrorActionDynamodbv2PutItem? PutItem;
        /// <summary>
        /// The ARN of the IAM role that grants access to the DynamoDB table.
        /// </summary>
        public readonly string RoleArn;

        [OutputConstructor]
        private TopicRuleErrorActionDynamodbv2(
            Outputs.TopicRuleErrorActionDynamodbv2PutItem? putItem,

            string roleArn)
        {
            PutItem = putItem;
            RoleArn = roleArn;
        }
    }
}
