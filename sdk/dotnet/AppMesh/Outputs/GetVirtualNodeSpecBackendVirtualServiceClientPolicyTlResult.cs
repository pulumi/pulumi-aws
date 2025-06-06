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
    public sealed class GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlResult
    {
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateResult> Certificates;
        public readonly bool Enforce;
        public readonly ImmutableArray<int> Ports;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlValidationResult> Validations;

        [OutputConstructor]
        private GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlResult(
            ImmutableArray<Outputs.GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlCertificateResult> certificates,

            bool enforce,

            ImmutableArray<int> ports,

            ImmutableArray<Outputs.GetVirtualNodeSpecBackendVirtualServiceClientPolicyTlValidationResult> validations)
        {
            Certificates = certificates;
            Enforce = enforce;
            Ports = ports;
            Validations = validations;
        }
    }
}
