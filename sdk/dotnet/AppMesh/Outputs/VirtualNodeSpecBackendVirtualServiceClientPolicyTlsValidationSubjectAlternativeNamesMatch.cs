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
    public sealed class VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationSubjectAlternativeNamesMatch
    {
        /// <summary>
        /// Values sent must match the specified values exactly.
        /// </summary>
        public readonly ImmutableArray<string> Exacts;

        [OutputConstructor]
        private VirtualNodeSpecBackendVirtualServiceClientPolicyTlsValidationSubjectAlternativeNamesMatch(ImmutableArray<string> exacts)
        {
            Exacts = exacts;
        }
    }
}
