// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketReplicationConfigurationRuleDestinationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the overrides to use for object owners on replication. Must be used in conjunction with `account_id` owner override configuration.
        /// </summary>
        [Input("accessControlTranslation")]
        public Input<Inputs.BucketReplicationConfigurationRuleDestinationAccessControlTranslationGetArgs>? AccessControlTranslation { get; set; }

        /// <summary>
        /// The Account ID to use for overriding the object owner on replication. Must be used in conjunction with `access_control_translation` override configuration.
        /// </summary>
        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// The ARN of the S3 bucket where you want Amazon S3 to store replicas of the object identified by the rule.
        /// </summary>
        [Input("bucket", required: true)]
        public Input<string> Bucket { get; set; } = null!;

        /// <summary>
        /// Enables replication metrics (required for S3 RTC) (documented below).
        /// </summary>
        [Input("metrics")]
        public Input<Inputs.BucketReplicationConfigurationRuleDestinationMetricsGetArgs>? Metrics { get; set; }

        /// <summary>
        /// Destination KMS encryption key ARN for SSE-KMS replication. Must be used in conjunction with
        /// `sse_kms_encrypted_objects` source selection criteria.
        /// </summary>
        [Input("replicaKmsKeyId")]
        public Input<string>? ReplicaKmsKeyId { get; set; }

        /// <summary>
        /// Enables S3 Replication Time Control (S3 RTC) (documented below).
        /// </summary>
        [Input("replicationTime")]
        public Input<Inputs.BucketReplicationConfigurationRuleDestinationReplicationTimeGetArgs>? ReplicationTime { get; set; }

        /// <summary>
        /// The [storage class](https://docs.aws.amazon.com/AmazonS3/latest/API/API_Destination.html#AmazonS3-Type-Destination-StorageClass) used to store the object. By default, Amazon S3 uses the storage class of the source object to create the object replica.
        /// </summary>
        [Input("storageClass")]
        public Input<string>? StorageClass { get; set; }

        public BucketReplicationConfigurationRuleDestinationGetArgs()
        {
        }
        public static new BucketReplicationConfigurationRuleDestinationGetArgs Empty => new BucketReplicationConfigurationRuleDestinationGetArgs();
    }
}
