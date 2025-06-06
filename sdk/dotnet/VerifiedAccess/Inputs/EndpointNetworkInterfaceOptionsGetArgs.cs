// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedAccess.Inputs
{

    public sealed class EndpointNetworkInterfaceOptionsGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("networkInterfaceId")]
        public Input<string>? NetworkInterfaceId { get; set; }

        [Input("port")]
        public Input<int>? Port { get; set; }

        [Input("portRanges")]
        private InputList<Inputs.EndpointNetworkInterfaceOptionsPortRangeGetArgs>? _portRanges;
        public InputList<Inputs.EndpointNetworkInterfaceOptionsPortRangeGetArgs> PortRanges
        {
            get => _portRanges ?? (_portRanges = new InputList<Inputs.EndpointNetworkInterfaceOptionsPortRangeGetArgs>());
            set => _portRanges = value;
        }

        [Input("protocol")]
        public Input<string>? Protocol { get; set; }

        public EndpointNetworkInterfaceOptionsGetArgs()
        {
        }
        public static new EndpointNetworkInterfaceOptionsGetArgs Empty => new EndpointNetworkInterfaceOptionsGetArgs();
    }
}
