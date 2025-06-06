// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LightSail.Inputs
{

    public sealed class ContainerServicePrivateRegistryAccessEcrImagePullerRoleGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A Boolean value that indicates whether to activate the role. The default is `false`.
        /// </summary>
        [Input("isActive")]
        public Input<bool>? IsActive { get; set; }

        /// <summary>
        /// The principal ARN of the container service. The principal ARN can be used to create a trust
        /// relationship between your standard AWS account and your Lightsail container service. This allows you to give your
        /// service permission to access resources in your standard AWS account.
        /// </summary>
        [Input("principalArn")]
        public Input<string>? PrincipalArn { get; set; }

        public ContainerServicePrivateRegistryAccessEcrImagePullerRoleGetArgs()
        {
        }
        public static new ContainerServicePrivateRegistryAccessEcrImagePullerRoleGetArgs Empty => new ContainerServicePrivateRegistryAccessEcrImagePullerRoleGetArgs();
    }
}
