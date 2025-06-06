// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketReplicationConfigRuleDestinationEncryptionConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ID (Key ARN or Alias ARN) of the customer managed AWS KMS key stored in AWS Key Management Service (KMS) for the destination bucket.
        /// </summary>
        [Input("replicaKmsKeyId", required: true)]
        public Input<string> ReplicaKmsKeyId { get; set; } = null!;

        public BucketReplicationConfigRuleDestinationEncryptionConfigurationArgs()
        {
        }
        public static new BucketReplicationConfigRuleDestinationEncryptionConfigurationArgs Empty => new BucketReplicationConfigRuleDestinationEncryptionConfigurationArgs();
    }
}
