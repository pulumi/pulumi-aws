// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedAccess.Inputs
{

    public sealed class EndpointLoadBalancerOptionsArgs : global::Pulumi.ResourceArgs
    {
        [Input("loadBalancerArn")]
        public Input<string>? LoadBalancerArn { get; set; }

        [Input("port")]
        public Input<int>? Port { get; set; }

        [Input("portRanges")]
        private InputList<Inputs.EndpointLoadBalancerOptionsPortRangeArgs>? _portRanges;
        public InputList<Inputs.EndpointLoadBalancerOptionsPortRangeArgs> PortRanges
        {
            get => _portRanges ?? (_portRanges = new InputList<Inputs.EndpointLoadBalancerOptionsPortRangeArgs>());
            set => _portRanges = value;
        }

        [Input("protocol")]
        public Input<string>? Protocol { get; set; }

        [Input("subnetIds")]
        private InputList<string>? _subnetIds;
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        public EndpointLoadBalancerOptionsArgs()
        {
        }
        public static new EndpointLoadBalancerOptionsArgs Empty => new EndpointLoadBalancerOptionsArgs();
    }
}
