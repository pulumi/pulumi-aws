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
    public sealed class VirtualGatewaySpecListenerTls
    {
        /// <summary>
        /// Listener's TLS certificate.
        /// </summary>
        public readonly Outputs.VirtualGatewaySpecListenerTlsCertificate Certificate;
        /// <summary>
        /// Listener's TLS mode. Valid values: `DISABLED`, `PERMISSIVE`, `STRICT`.
        /// </summary>
        public readonly string Mode;
        /// <summary>
        /// Listener's Transport Layer Security (TLS) validation context.
        /// </summary>
        public readonly Outputs.VirtualGatewaySpecListenerTlsValidation? Validation;

        [OutputConstructor]
        private VirtualGatewaySpecListenerTls(
            Outputs.VirtualGatewaySpecListenerTlsCertificate certificate,

            string mode,

            Outputs.VirtualGatewaySpecListenerTlsValidation? validation)
        {
            Certificate = certificate;
            Mode = mode;
            Validation = validation;
        }
    }
}
