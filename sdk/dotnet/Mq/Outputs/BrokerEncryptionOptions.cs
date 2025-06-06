// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Mq.Outputs
{

    [OutputType]
    public sealed class BrokerEncryptionOptions
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of Key Management Service (KMS) Customer Master Key (CMK) to use for encryption at rest. Requires setting `use_aws_owned_key` to `false`. To perform drift detection when AWS-managed CMKs or customer-managed CMKs are in use, this value must be configured.
        /// </summary>
        public readonly string? KmsKeyId;
        /// <summary>
        /// Whether to enable an AWS-owned KMS CMK that is not in your account. Defaults to `true`. Setting to `false` without configuring `kms_key_id` will create an AWS-managed CMK aliased to `aws/mq` in your account.
        /// </summary>
        public readonly bool? UseAwsOwnedKey;

        [OutputConstructor]
        private BrokerEncryptionOptions(
            string? kmsKeyId,

            bool? useAwsOwnedKey)
        {
            KmsKeyId = kmsKeyId;
            UseAwsOwnedKey = useAwsOwnedKey;
        }
    }
}
