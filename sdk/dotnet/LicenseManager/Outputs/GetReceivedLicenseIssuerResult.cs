// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LicenseManager.Outputs
{

    [OutputType]
    public sealed class GetReceivedLicenseIssuerResult
    {
        /// <summary>
        /// Issuer key fingerprint.
        /// </summary>
        public readonly string KeyFingerprint;
        /// <summary>
        /// The key name.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Asymmetric KMS key from AWS Key Management Service. The KMS key must have a key usage of sign and verify, and support the RSASSA-PSS SHA-256 signing algorithm.
        /// </summary>
        public readonly string SignKey;

        [OutputConstructor]
        private GetReceivedLicenseIssuerResult(
            string keyFingerprint,

            string name,

            string signKey)
        {
            KeyFingerprint = keyFingerprint;
            Name = name;
            SignKey = signKey;
        }
    }
}
