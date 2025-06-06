// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class VirtualNodeSpecListenerTlsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Listener's TLS certificate.
        /// </summary>
        [Input("certificate", required: true)]
        public Input<Inputs.VirtualNodeSpecListenerTlsCertificateGetArgs> Certificate { get; set; } = null!;

        /// <summary>
        /// Listener's TLS mode. Valid values: `DISABLED`, `PERMISSIVE`, `STRICT`.
        /// </summary>
        [Input("mode", required: true)]
        public Input<string> Mode { get; set; } = null!;

        /// <summary>
        /// Listener's Transport Layer Security (TLS) validation context.
        /// </summary>
        [Input("validation")]
        public Input<Inputs.VirtualNodeSpecListenerTlsValidationGetArgs>? Validation { get; set; }

        public VirtualNodeSpecListenerTlsGetArgs()
        {
        }
        public static new VirtualNodeSpecListenerTlsGetArgs Empty => new VirtualNodeSpecListenerTlsGetArgs();
    }
}
