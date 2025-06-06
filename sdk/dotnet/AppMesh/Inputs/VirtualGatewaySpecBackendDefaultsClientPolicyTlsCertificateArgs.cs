// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class VirtualGatewaySpecBackendDefaultsClientPolicyTlsCertificateArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Local file certificate.
        /// </summary>
        [Input("file")]
        public Input<Inputs.VirtualGatewaySpecBackendDefaultsClientPolicyTlsCertificateFileArgs>? File { get; set; }

        /// <summary>
        /// A [Secret Discovery Service](https://www.envoyproxy.io/docs/envoy/latest/configuration/security/secret#secret-discovery-service-sds) certificate.
        /// </summary>
        [Input("sds")]
        public Input<Inputs.VirtualGatewaySpecBackendDefaultsClientPolicyTlsCertificateSdsArgs>? Sds { get; set; }

        public VirtualGatewaySpecBackendDefaultsClientPolicyTlsCertificateArgs()
        {
        }
        public static new VirtualGatewaySpecBackendDefaultsClientPolicyTlsCertificateArgs Empty => new VirtualGatewaySpecBackendDefaultsClientPolicyTlsCertificateArgs();
    }
}
