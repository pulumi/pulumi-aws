// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Outputs
{

    [OutputType]
    public sealed class ServiceServiceConnectConfigurationServiceTls
    {
        /// <summary>
        /// Details of the certificate authority which will issue the certificate.
        /// </summary>
        public readonly Outputs.ServiceServiceConnectConfigurationServiceTlsIssuerCertAuthority IssuerCertAuthority;
        /// <summary>
        /// KMS key used to encrypt the private key in Secrets Manager.
        /// </summary>
        public readonly string? KmsKey;
        /// <summary>
        /// ARN of the IAM Role that's associated with the Service Connect TLS.
        /// </summary>
        public readonly string? RoleArn;

        [OutputConstructor]
        private ServiceServiceConnectConfigurationServiceTls(
            Outputs.ServiceServiceConnectConfigurationServiceTlsIssuerCertAuthority issuerCertAuthority,

            string? kmsKey,

            string? roleArn)
        {
            IssuerCertAuthority = issuerCertAuthority;
            KmsKey = kmsKey;
            RoleArn = roleArn;
        }
    }
}
