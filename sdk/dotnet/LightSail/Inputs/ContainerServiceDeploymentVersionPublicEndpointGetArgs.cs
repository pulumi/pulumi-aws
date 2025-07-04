// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LightSail.Inputs
{

    public sealed class ContainerServiceDeploymentVersionPublicEndpointGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the container for the endpoint.
        /// </summary>
        [Input("containerName", required: true)]
        public Input<string> ContainerName { get; set; } = null!;

        /// <summary>
        /// Port of the container to which traffic is forwarded to.
        /// </summary>
        [Input("containerPort", required: true)]
        public Input<int> ContainerPort { get; set; } = null!;

        /// <summary>
        /// Configuration block that describes the health check configuration of the container. See below.
        /// </summary>
        [Input("healthCheck", required: true)]
        public Input<Inputs.ContainerServiceDeploymentVersionPublicEndpointHealthCheckGetArgs> HealthCheck { get; set; } = null!;

        public ContainerServiceDeploymentVersionPublicEndpointGetArgs()
        {
        }
        public static new ContainerServiceDeploymentVersionPublicEndpointGetArgs Empty => new ContainerServiceDeploymentVersionPublicEndpointGetArgs();
    }
}
