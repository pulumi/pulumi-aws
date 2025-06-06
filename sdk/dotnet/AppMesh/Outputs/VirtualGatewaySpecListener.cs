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
    public sealed class VirtualGatewaySpecListener
    {
        /// <summary>
        /// Connection pool information for the listener.
        /// </summary>
        public readonly Outputs.VirtualGatewaySpecListenerConnectionPool? ConnectionPool;
        /// <summary>
        /// Health check information for the listener.
        /// </summary>
        public readonly Outputs.VirtualGatewaySpecListenerHealthCheck? HealthCheck;
        /// <summary>
        /// Port mapping information for the listener.
        /// </summary>
        public readonly Outputs.VirtualGatewaySpecListenerPortMapping PortMapping;
        /// <summary>
        /// Transport Layer Security (TLS) properties for the listener
        /// </summary>
        public readonly Outputs.VirtualGatewaySpecListenerTls? Tls;

        [OutputConstructor]
        private VirtualGatewaySpecListener(
            Outputs.VirtualGatewaySpecListenerConnectionPool? connectionPool,

            Outputs.VirtualGatewaySpecListenerHealthCheck? healthCheck,

            Outputs.VirtualGatewaySpecListenerPortMapping portMapping,

            Outputs.VirtualGatewaySpecListenerTls? tls)
        {
            ConnectionPool = connectionPool;
            HealthCheck = healthCheck;
            PortMapping = portMapping;
            Tls = tls;
        }
    }
}
