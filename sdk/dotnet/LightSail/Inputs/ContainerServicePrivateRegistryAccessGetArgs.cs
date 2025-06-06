// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LightSail.Inputs
{

    public sealed class ContainerServicePrivateRegistryAccessGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Describes a request to configure an Amazon Lightsail container service to access private container image repositories, such as Amazon Elastic Container Registry (Amazon ECR) private repositories. See ECR Image Puller Role below for more details.
        /// </summary>
        [Input("ecrImagePullerRole")]
        public Input<Inputs.ContainerServicePrivateRegistryAccessEcrImagePullerRoleGetArgs>? EcrImagePullerRole { get; set; }

        public ContainerServicePrivateRegistryAccessGetArgs()
        {
        }
        public static new ContainerServicePrivateRegistryAccessGetArgs Empty => new ContainerServicePrivateRegistryAccessGetArgs();
    }
}
