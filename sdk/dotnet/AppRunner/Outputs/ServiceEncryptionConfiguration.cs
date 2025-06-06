// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppRunner.Outputs
{

    [OutputType]
    public sealed class ServiceEncryptionConfiguration
    {
        /// <summary>
        /// ARN of the KMS key used for encryption.
        /// </summary>
        public readonly string KmsKey;

        [OutputConstructor]
        private ServiceEncryptionConfiguration(string kmsKey)
        {
            KmsKey = kmsKey;
        }
    }
}
