// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class FeatureGroupOfflineStoreConfigS3StorageConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The AWS Key Management Service (KMS) key ID of the key used to encrypt any objects written into the OfflineStore S3 location.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// The S3 path where offline records are written.
        /// </summary>
        [Input("resolvedOutputS3Uri")]
        public Input<string>? ResolvedOutputS3Uri { get; set; }

        /// <summary>
        /// The S3 URI, or location in Amazon S3, of OfflineStore.
        /// </summary>
        [Input("s3Uri", required: true)]
        public Input<string> S3Uri { get; set; } = null!;

        public FeatureGroupOfflineStoreConfigS3StorageConfigGetArgs()
        {
        }
        public static new FeatureGroupOfflineStoreConfigS3StorageConfigGetArgs Empty => new FeatureGroupOfflineStoreConfigS3StorageConfigGetArgs();
    }
}
