// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketV2ReplicationConfigurationRuleDestinationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("accessControlTranslations")]
        private InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationAccessControlTranslationGetArgs>? _accessControlTranslations;

        /// <summary>
        /// Specifies the overrides to use for object owners on replication (documented below). Must be used in conjunction with `account_id` owner override configuration.
        /// </summary>
        public InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationAccessControlTranslationGetArgs> AccessControlTranslations
        {
            get => _accessControlTranslations ?? (_accessControlTranslations = new InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationAccessControlTranslationGetArgs>());
            set => _accessControlTranslations = value;
        }

        /// <summary>
        /// Account ID to use for overriding the object owner on replication. Must be used in conjunction with `access_control_translation` override configuration.
        /// </summary>
        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// ARN of the S3 bucket where you want Amazon S3 to store replicas of the object identified by the rule.
        /// </summary>
        [Input("bucket", required: true)]
        public Input<string> Bucket { get; set; } = null!;

        [Input("metrics")]
        private InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationMetricGetArgs>? _metrics;

        /// <summary>
        /// Enables replication metrics (required for S3 RTC) (documented below).
        /// </summary>
        public InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationMetricGetArgs> Metrics
        {
            get => _metrics ?? (_metrics = new InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationMetricGetArgs>());
            set => _metrics = value;
        }

        /// <summary>
        /// Destination KMS encryption key ARN for SSE-KMS replication. Must be used in conjunction with
        /// `sse_kms_encrypted_objects` source selection criteria.
        /// </summary>
        [Input("replicaKmsKeyId")]
        public Input<string>? ReplicaKmsKeyId { get; set; }

        [Input("replicationTimes")]
        private InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationReplicationTimeGetArgs>? _replicationTimes;

        /// <summary>
        /// Enables S3 Replication Time Control (S3 RTC) (documented below).
        /// </summary>
        public InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationReplicationTimeGetArgs> ReplicationTimes
        {
            get => _replicationTimes ?? (_replicationTimes = new InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationReplicationTimeGetArgs>());
            set => _replicationTimes = value;
        }

        /// <summary>
        /// The [storage class](https://docs.aws.amazon.com/AmazonS3/latest/API/API_Destination.html#AmazonS3-Type-Destination-StorageClass) used to store the object. By default, Amazon S3 uses the storage class of the source object to create the object replica.
        /// </summary>
        [Input("storageClass")]
        public Input<string>? StorageClass { get; set; }

        public BucketV2ReplicationConfigurationRuleDestinationGetArgs()
        {
        }
        public static new BucketV2ReplicationConfigurationRuleDestinationGetArgs Empty => new BucketV2ReplicationConfigurationRuleDestinationGetArgs();
    }
}
