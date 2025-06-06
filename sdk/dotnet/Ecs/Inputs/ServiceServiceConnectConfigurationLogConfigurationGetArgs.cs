// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Inputs
{

    public sealed class ServiceServiceConnectConfigurationLogConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Log driver to use for the container.
        /// </summary>
        [Input("logDriver", required: true)]
        public Input<string> LogDriver { get; set; } = null!;

        [Input("options")]
        private InputMap<string>? _options;

        /// <summary>
        /// Configuration options to send to the log driver.
        /// </summary>
        public InputMap<string> Options
        {
            get => _options ?? (_options = new InputMap<string>());
            set => _options = value;
        }

        [Input("secretOptions")]
        private InputList<Inputs.ServiceServiceConnectConfigurationLogConfigurationSecretOptionGetArgs>? _secretOptions;

        /// <summary>
        /// Secrets to pass to the log configuration. See below.
        /// </summary>
        public InputList<Inputs.ServiceServiceConnectConfigurationLogConfigurationSecretOptionGetArgs> SecretOptions
        {
            get => _secretOptions ?? (_secretOptions = new InputList<Inputs.ServiceServiceConnectConfigurationLogConfigurationSecretOptionGetArgs>());
            set => _secretOptions = value;
        }

        public ServiceServiceConnectConfigurationLogConfigurationGetArgs()
        {
        }
        public static new ServiceServiceConnectConfigurationLogConfigurationGetArgs Empty => new ServiceServiceConnectConfigurationLogConfigurationGetArgs();
    }
}
