// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamWrite.Outputs
{

    [OutputType]
    public sealed class GetTableMagneticStoreWritePropertyMagneticStoreRejectedDataLocationS3ConfigurationResult
    {
        /// <summary>
        /// Name of S3 bucket.
        /// </summary>
        public readonly string BucketName;
        public readonly string EncryptionOption;
        /// <summary>
        /// AWS KMS key ID for S3 location with AWS maanged key.
        /// </summary>
        public readonly string KmsKeyId;
        /// <summary>
        /// Object key preview for S3 location.
        /// </summary>
        public readonly string ObjectKeyPrefix;

        [OutputConstructor]
        private GetTableMagneticStoreWritePropertyMagneticStoreRejectedDataLocationS3ConfigurationResult(
            string bucketName,

            string encryptionOption,

            string kmsKeyId,

            string objectKeyPrefix)
        {
            BucketName = bucketName;
            EncryptionOption = encryptionOption;
            KmsKeyId = kmsKeyId;
            ObjectKeyPrefix = objectKeyPrefix;
        }
    }
}
