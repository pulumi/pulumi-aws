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
    public sealed class GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustResult
    {
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustAcmResult> Acms;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustFileResult> Files;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustSdResult> Sds;

        [OutputConstructor]
        private GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustResult(
            ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustAcmResult> acms,

            ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustFileResult> files,

            ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationTrustSdResult> sds)
        {
            Acms = acms;
            Files = files;
            Sds = sds;
        }
    }
}
