// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Outputs
{

    [OutputType]
    public sealed class FieldLevelEncryptionProfileEncryptionEntitiesItem
    {
        /// <summary>
        /// Object that contains an attribute `items` that contains the list of field patterns in a field-level encryption content type profile specify the fields that you want to be encrypted.
        /// </summary>
        public readonly Outputs.FieldLevelEncryptionProfileEncryptionEntitiesItemFieldPatterns FieldPatterns;
        /// <summary>
        /// The provider associated with the public key being used for encryption.
        /// </summary>
        public readonly string ProviderId;
        /// <summary>
        /// The public key associated with a set of field-level encryption patterns, to be used when encrypting the fields that match the patterns.
        /// </summary>
        public readonly string PublicKeyId;

        [OutputConstructor]
        private FieldLevelEncryptionProfileEncryptionEntitiesItem(
            Outputs.FieldLevelEncryptionProfileEncryptionEntitiesItemFieldPatterns fieldPatterns,

            string providerId,

            string publicKeyId)
        {
            FieldPatterns = fieldPatterns;
            ProviderId = providerId;
            PublicKeyId = publicKeyId;
        }
    }
}
