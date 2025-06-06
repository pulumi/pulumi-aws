// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glue.Inputs
{

    public sealed class DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The encryption-at-rest mode for encrypting Data Catalog data. Valid values: `DISABLED`, `SSE-KMS`, `SSE-KMS-WITH-SERVICE-ROLE`.
        /// </summary>
        [Input("catalogEncryptionMode", required: true)]
        public Input<string> CatalogEncryptionMode { get; set; } = null!;

        /// <summary>
        /// The ARN of the AWS IAM role used for accessing encrypted Data Catalog data.
        /// </summary>
        [Input("catalogEncryptionServiceRole")]
        public Input<string>? CatalogEncryptionServiceRole { get; set; }

        /// <summary>
        /// The ARN of the AWS KMS key to use for encryption at rest.
        /// </summary>
        [Input("sseAwsKmsKeyId")]
        public Input<string>? SseAwsKmsKeyId { get; set; }

        public DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs()
        {
        }
        public static new DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs Empty => new DataCatalogEncryptionSettingsDataCatalogEncryptionSettingsEncryptionAtRestArgs();
    }
}
