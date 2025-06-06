// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Outputs
{

    [OutputType]
    public sealed class DeviceFleetOutputConfig
    {
        /// <summary>
        /// The AWS Key Management Service (AWS KMS) key that Amazon SageMaker AI uses to encrypt data on the storage volume after compilation job. If you don't provide a KMS key ID, Amazon SageMaker AI uses the default KMS key for Amazon S3 for your role's account.
        /// </summary>
        public readonly string? KmsKeyId;
        /// <summary>
        /// The Amazon Simple Storage (S3) bucker URI.
        /// </summary>
        public readonly string S3OutputLocation;

        [OutputConstructor]
        private DeviceFleetOutputConfig(
            string? kmsKeyId,

            string s3OutputLocation)
        {
            KmsKeyId = kmsKeyId;
            S3OutputLocation = s3OutputLocation;
        }
    }
}
