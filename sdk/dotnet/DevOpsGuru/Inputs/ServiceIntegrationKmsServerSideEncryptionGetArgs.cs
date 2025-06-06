// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DevOpsGuru.Inputs
{

    public sealed class ServiceIntegrationKmsServerSideEncryptionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// KMS key ID. This value can be a key ID, key ARN, alias name, or alias ARN.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// Specifies whether KMS integration is enabled. Valid values are `DISABLED` and `ENABLED`.
        /// </summary>
        [Input("optInStatus")]
        public Input<string>? OptInStatus { get; set; }

        /// <summary>
        /// Type of KMS key used. Valid values are `CUSTOMER_MANAGED_KEY` and `AWS_OWNED_KMS_KEY`.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public ServiceIntegrationKmsServerSideEncryptionGetArgs()
        {
        }
        public static new ServiceIntegrationKmsServerSideEncryptionGetArgs Empty => new ServiceIntegrationKmsServerSideEncryptionGetArgs();
    }
}
