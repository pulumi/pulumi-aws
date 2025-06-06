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
    public sealed class GetVirtualNodeSpecBackendDefaultClientPolicyTlResult
    {
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlCertificateResult> Certificates;
        public readonly bool Enforce;
        public readonly ImmutableArray<int> Ports;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationResult> Validations;

        [OutputConstructor]
        private GetVirtualNodeSpecBackendDefaultClientPolicyTlResult(
            ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlCertificateResult> certificates,

            bool enforce,

            ImmutableArray<int> ports,

            ImmutableArray<Outputs.GetVirtualNodeSpecBackendDefaultClientPolicyTlValidationResult> validations)
        {
            Certificates = certificates;
            Enforce = enforce;
            Ports = ports;
            Validations = validations;
        }
    }
}
