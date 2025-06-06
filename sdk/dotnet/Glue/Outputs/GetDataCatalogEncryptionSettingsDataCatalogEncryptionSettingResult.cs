// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glue.Outputs
{

    [OutputType]
    public sealed class GetDataCatalogEncryptionSettingsDataCatalogEncryptionSettingResult
    {
        /// <summary>
        /// When connection password protection is enabled, the Data Catalog uses a customer-provided key to encrypt the password as part of CreateConnection or UpdateConnection and store it in the ENCRYPTED_PASSWORD field in the connection properties. You can enable catalog encryption or only password encryption. see Connection Password Encryption.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetDataCatalogEncryptionSettingsDataCatalogEncryptionSettingConnectionPasswordEncryptionResult> ConnectionPasswordEncryptions;
        /// <summary>
        /// Encryption-at-rest configuration for the Data Catalog. see Encryption At Rest.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetDataCatalogEncryptionSettingsDataCatalogEncryptionSettingEncryptionAtRestResult> EncryptionAtRests;

        [OutputConstructor]
        private GetDataCatalogEncryptionSettingsDataCatalogEncryptionSettingResult(
            ImmutableArray<Outputs.GetDataCatalogEncryptionSettingsDataCatalogEncryptionSettingConnectionPasswordEncryptionResult> connectionPasswordEncryptions,

            ImmutableArray<Outputs.GetDataCatalogEncryptionSettingsDataCatalogEncryptionSettingEncryptionAtRestResult> encryptionAtRests)
        {
            ConnectionPasswordEncryptions = connectionPasswordEncryptions;
            EncryptionAtRests = encryptionAtRests;
        }
    }
}
