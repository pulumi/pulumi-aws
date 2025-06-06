// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall.Outputs
{

    [OutputType]
    public sealed class TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfiguration
    {
        /// <summary>
        /// ARN of the imported certificate authority (CA) certificate within Certificate Manager (ACM) to use for outbound SSL/TLS inspection. See [Using SSL/TLS certificates with TLS inspection configurations](https://docs.aws.amazon.com/network-firewall/latest/developerguide/tls-inspection-certificate-requirements.html) for limitations on CA certificates.
        /// </summary>
        public readonly string? CertificateAuthorityArn;
        /// <summary>
        /// Check Certificate Revocation Status block. Detailed below.
        /// </summary>
        public readonly Outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationCheckCertificateRevocationStatus? CheckCertificateRevocationStatus;
        /// <summary>
        /// Scope block. Detailed below.
        /// </summary>
        public readonly ImmutableArray<Outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope> Scopes;
        /// <summary>
        /// Server certificates to use for inbound SSL/TLS inspection. See [Using SSL/TLS certificates with TLS inspection configurations](https://docs.aws.amazon.com/network-firewall/latest/developerguide/tls-inspection-certificate-requirements.html).
        /// </summary>
        public readonly ImmutableArray<Outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationServerCertificate> ServerCertificates;

        [OutputConstructor]
        private TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfiguration(
            string? certificateAuthorityArn,

            Outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationCheckCertificateRevocationStatus? checkCertificateRevocationStatus,

            ImmutableArray<Outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope> scopes,

            ImmutableArray<Outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationServerCertificate> serverCertificates)
        {
            CertificateAuthorityArn = certificateAuthorityArn;
            CheckCertificateRevocationStatus = checkCertificateRevocationStatus;
            Scopes = scopes;
            ServerCertificates = serverCertificates;
        }
    }
}
