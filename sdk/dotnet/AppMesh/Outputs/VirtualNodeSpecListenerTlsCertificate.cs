// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Outputs
{

    [OutputType]
    public sealed class VirtualNodeSpecListenerTlsCertificate
    {
        /// <summary>
        /// An AWS Certificate Manager (ACM) certificate.
        /// </summary>
        public readonly Outputs.VirtualNodeSpecListenerTlsCertificateAcm? Acm;
        /// <summary>
        /// Local file certificate.
        /// </summary>
        public readonly Outputs.VirtualNodeSpecListenerTlsCertificateFile? File;
        /// <summary>
        /// A [Secret Discovery Service](https://www.envoyproxy.io/docs/envoy/latest/configuration/security/secret#secret-discovery-service-sds) certificate.
        /// </summary>
        public readonly Outputs.VirtualNodeSpecListenerTlsCertificateSds? Sds;

        [OutputConstructor]
        private VirtualNodeSpecListenerTlsCertificate(
            Outputs.VirtualNodeSpecListenerTlsCertificateAcm? acm,

            Outputs.VirtualNodeSpecListenerTlsCertificateFile? file,

            Outputs.VirtualNodeSpecListenerTlsCertificateSds? sds)
        {
            Acm = acm;
            File = file;
            Sds = sds;
        }
    }
}
