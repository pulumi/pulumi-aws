// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class VirtualGatewaySpecBackendDefaultsClientPolicyTlsValidationSubjectAlternativeNamesGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Criteria for determining a SAN's match.
        /// </summary>
        [Input("match", required: true)]
        public Input<Inputs.VirtualGatewaySpecBackendDefaultsClientPolicyTlsValidationSubjectAlternativeNamesMatchGetArgs> Match { get; set; } = null!;

        public VirtualGatewaySpecBackendDefaultsClientPolicyTlsValidationSubjectAlternativeNamesGetArgs()
        {
        }
        public static new VirtualGatewaySpecBackendDefaultsClientPolicyTlsValidationSubjectAlternativeNamesGetArgs Empty => new VirtualGatewaySpecBackendDefaultsClientPolicyTlsValidationSubjectAlternativeNamesGetArgs();
    }
}
