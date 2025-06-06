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
    public sealed class VirtualRouterSpecListenerPortMapping
    {
        /// <summary>
        /// Port used for the port mapping.
        /// </summary>
        public readonly int Port;
        /// <summary>
        /// Protocol used for the port mapping. Valid values are `http`,`http2`, `tcp` and `grpc`.
        /// </summary>
        public readonly string Protocol;

        [OutputConstructor]
        private VirtualRouterSpecListenerPortMapping(
            int port,

            string protocol)
        {
            Port = port;
            Protocol = protocol;
        }
    }
}
