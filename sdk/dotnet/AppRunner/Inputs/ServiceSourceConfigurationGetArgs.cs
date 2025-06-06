// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppRunner.Inputs
{

    public sealed class ServiceSourceConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Describes resources needed to authenticate access to some source repositories. See Authentication Configuration below for more details.
        /// </summary>
        [Input("authenticationConfiguration")]
        public Input<Inputs.ServiceSourceConfigurationAuthenticationConfigurationGetArgs>? AuthenticationConfiguration { get; set; }

        /// <summary>
        /// Whether continuous integration from the source repository is enabled for the App Runner service. If set to `true`, each repository change (source code commit or new image version) starts a deployment. Defaults to `true`.
        /// </summary>
        [Input("autoDeploymentsEnabled")]
        public Input<bool>? AutoDeploymentsEnabled { get; set; }

        /// <summary>
        /// Description of a source code repository. See Code Repository below for more details.
        /// </summary>
        [Input("codeRepository")]
        public Input<Inputs.ServiceSourceConfigurationCodeRepositoryGetArgs>? CodeRepository { get; set; }

        /// <summary>
        /// Description of a source image repository. See Image Repository below for more details.
        /// </summary>
        [Input("imageRepository")]
        public Input<Inputs.ServiceSourceConfigurationImageRepositoryGetArgs>? ImageRepository { get; set; }

        public ServiceSourceConfigurationGetArgs()
        {
        }
        public static new ServiceSourceConfigurationGetArgs Empty => new ServiceSourceConfigurationGetArgs();
    }
}
