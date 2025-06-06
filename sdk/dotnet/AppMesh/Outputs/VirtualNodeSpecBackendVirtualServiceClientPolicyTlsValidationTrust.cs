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
    public sealed class VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationTrust
    {
        /// <summary>
        /// TLS validation context trust for an AWS Certificate Manager (ACM) certificate.
        /// </summary>
        public readonly Outputs.VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationTrustAcm? Acm;
        /// <summary>
        /// TLS validation context trust for a local file certificate.
        /// </summary>
        public readonly Outputs.VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationTrustFile? File;
        /// <summary>
        /// TLS validation context trust for a [Secret Discovery Service](https://www.envoyproxy.io/docs/envoy/latest/configuration/security/secret#secret-discovery-service-sds) certificate.
        /// </summary>
        public readonly Outputs.VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationTrustSds? Sds;

        [OutputConstructor]
        private VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationTrust(
            Outputs.VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationTrustAcm? acm,

            Outputs.VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationTrustFile? file,

            Outputs.VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationTrustSds? sds)
        {
            Acm = acm;
            File = file;
            Sds = sds;
        }
    }
}
