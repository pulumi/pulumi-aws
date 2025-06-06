// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Inputs
{

    public sealed class ServiceServiceConnectConfigurationServiceArgs : global::Pulumi.ResourceArgs
    {
        [Input("clientAlias")]
        private InputList<Inputs.ServiceServiceConnectConfigurationServiceClientAliasArgs>? _clientAlias;

        /// <summary>
        /// List of client aliases for this Service Connect service. You use these to assign names that can be used by client applications. The maximum number of client aliases that you can have in this list is 1. See below.
        /// </summary>
        public InputList<Inputs.ServiceServiceConnectConfigurationServiceClientAliasArgs> ClientAlias
        {
            get => _clientAlias ?? (_clientAlias = new InputList<Inputs.ServiceServiceConnectConfigurationServiceClientAliasArgs>());
            set => _clientAlias = value;
        }

        /// <summary>
        /// Name of the new AWS Cloud Map service that Amazon ECS creates for this Amazon ECS service.
        /// </summary>
        [Input("discoveryName")]
        public Input<string>? DiscoveryName { get; set; }

        /// <summary>
        /// Port number for the Service Connect proxy to listen on.
        /// </summary>
        [Input("ingressPortOverride")]
        public Input<int>? IngressPortOverride { get; set; }

        /// <summary>
        /// Name of one of the `portMappings` from all the containers in the task definition of this Amazon ECS service.
        /// </summary>
        [Input("portName", required: true)]
        public Input<string> PortName { get; set; } = null!;

        /// <summary>
        /// Configuration timeouts for Service Connect
        /// </summary>
        [Input("timeout")]
        public Input<Inputs.ServiceServiceConnectConfigurationServiceTimeoutArgs>? Timeout { get; set; }

        /// <summary>
        /// Configuration for enabling Transport Layer Security (TLS)
        /// </summary>
        [Input("tls")]
        public Input<Inputs.ServiceServiceConnectConfigurationServiceTlsArgs>? Tls { get; set; }

        public ServiceServiceConnectConfigurationServiceArgs()
        {
        }
        public static new ServiceServiceConnectConfigurationServiceArgs Empty => new ServiceServiceConnectConfigurationServiceArgs();
    }
}
