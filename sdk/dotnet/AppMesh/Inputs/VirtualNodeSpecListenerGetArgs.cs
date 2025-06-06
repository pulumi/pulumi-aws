// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class VirtualNodeSpecListenerGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Connection pool information for the listener.
        /// </summary>
        [Input("connectionPool")]
        public Input<Inputs.VirtualNodeSpecListenerConnectionPoolGetArgs>? ConnectionPool { get; set; }

        /// <summary>
        /// Health check information for the listener.
        /// </summary>
        [Input("healthCheck")]
        public Input<Inputs.VirtualNodeSpecListenerHealthCheckGetArgs>? HealthCheck { get; set; }

        /// <summary>
        /// Outlier detection information for the listener.
        /// </summary>
        [Input("outlierDetection")]
        public Input<Inputs.VirtualNodeSpecListenerOutlierDetectionGetArgs>? OutlierDetection { get; set; }

        /// <summary>
        /// Port mapping information for the listener.
        /// </summary>
        [Input("portMapping", required: true)]
        public Input<Inputs.VirtualNodeSpecListenerPortMappingGetArgs> PortMapping { get; set; } = null!;

        /// <summary>
        /// Timeouts for different protocols.
        /// </summary>
        [Input("timeout")]
        public Input<Inputs.VirtualNodeSpecListenerTimeoutGetArgs>? Timeout { get; set; }

        /// <summary>
        /// Transport Layer Security (TLS) properties for the listener
        /// </summary>
        [Input("tls")]
        public Input<Inputs.VirtualNodeSpecListenerTlsGetArgs>? Tls { get; set; }

        public VirtualNodeSpecListenerGetArgs()
        {
        }
        public static new VirtualNodeSpecListenerGetArgs Empty => new VirtualNodeSpecListenerGetArgs();
    }
}
