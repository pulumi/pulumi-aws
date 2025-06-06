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
    public sealed class GatewayRouteSpecHttp2RouteActionTargetVirtualService
    {
        /// <summary>
        /// Name of the virtual service that traffic is routed to. Must be between 1 and 255 characters in length.
        /// </summary>
        public readonly string VirtualServiceName;

        [OutputConstructor]
        private GatewayRouteSpecHttp2RouteActionTargetVirtualService(string virtualServiceName)
        {
            VirtualServiceName = virtualServiceName;
        }
    }
}
