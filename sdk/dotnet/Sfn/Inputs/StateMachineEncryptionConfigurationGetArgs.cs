// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sfn.Inputs
{

    public sealed class StateMachineEncryptionConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Maximum duration for which Step Functions will reuse data keys. When the period expires, Step Functions will call GenerateDataKey. This setting only applies to customer managed KMS key and does not apply when `type` is `AWS_OWNED_KEY`.
        /// </summary>
        [Input("kmsDataKeyReusePeriodSeconds")]
        public Input<int>? KmsDataKeyReusePeriodSeconds { get; set; }

        /// <summary>
        /// The alias, alias ARN, key ID, or key ARN of the symmetric encryption KMS key that encrypts the data key. To specify a KMS key in a different AWS account, the customer must use the key ARN or alias ARN. For more information regarding kms_key_id, see [KeyId](https://docs.aws.amazon.com/kms/latest/APIReference/API_DescribeKey.html#API_DescribeKey_RequestParameters) in the KMS documentation.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// The encryption option specified for the state machine. Valid values: `AWS_OWNED_KEY`, `CUSTOMER_MANAGED_KMS_KEY`
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public StateMachineEncryptionConfigurationGetArgs()
        {
        }
        public static new StateMachineEncryptionConfigurationGetArgs Empty => new StateMachineEncryptionConfigurationGetArgs();
    }
}
