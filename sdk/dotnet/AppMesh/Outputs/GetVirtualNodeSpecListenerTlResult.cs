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
    public sealed class GetVirtualNodeSpecListenerTlResult
    {
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerTlCertificateResult> Certificates;
        public readonly string Mode;
        public readonly ImmutableArray<Outputs.GetVirtualNodeSpecListenerTlValidationResult> Validations;

        [OutputConstructor]
        private GetVirtualNodeSpecListenerTlResult(
            ImmutableArray<Outputs.GetVirtualNodeSpecListenerTlCertificateResult> certificates,

            string mode,

            ImmutableArray<Outputs.GetVirtualNodeSpecListenerTlValidationResult> validations)
        {
            Certificates = certificates;
            Mode = mode;
            Validations = validations;
        }
    }
}
