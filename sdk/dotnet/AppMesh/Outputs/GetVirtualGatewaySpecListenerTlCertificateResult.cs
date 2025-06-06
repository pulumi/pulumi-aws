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
    public sealed class GetVirtualGatewaySpecListenerTlCertificateResult
    {
        public readonly ImmutableArray<Outputs.GetVirtualGatewaySpecListenerTlCertificateAcmResult> Acms;
        public readonly ImmutableArray<Outputs.GetVirtualGatewaySpecListenerTlCertificateFileResult> Files;
        public readonly ImmutableArray<Outputs.GetVirtualGatewaySpecListenerTlCertificateSdResult> Sds;

        [OutputConstructor]
        private GetVirtualGatewaySpecListenerTlCertificateResult(
            ImmutableArray<Outputs.GetVirtualGatewaySpecListenerTlCertificateAcmResult> acms,

            ImmutableArray<Outputs.GetVirtualGatewaySpecListenerTlCertificateFileResult> files,

            ImmutableArray<Outputs.GetVirtualGatewaySpecListenerTlCertificateSdResult> sds)
        {
            Acms = acms;
            Files = files;
            Sds = sds;
        }
    }
}
