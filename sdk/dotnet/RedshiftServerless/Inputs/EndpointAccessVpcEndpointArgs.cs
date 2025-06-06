// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.RedshiftServerless.Inputs
{

    public sealed class EndpointAccessVpcEndpointArgs : global::Pulumi.ResourceArgs
    {
        [Input("networkInterfaces")]
        private InputList<Inputs.EndpointAccessVpcEndpointNetworkInterfaceArgs>? _networkInterfaces;

        /// <summary>
        /// The network interfaces of the endpoint.. See `Network Interface` below.
        /// </summary>
        public InputList<Inputs.EndpointAccessVpcEndpointNetworkInterfaceArgs> NetworkInterfaces
        {
            get => _networkInterfaces ?? (_networkInterfaces = new InputList<Inputs.EndpointAccessVpcEndpointNetworkInterfaceArgs>());
            set => _networkInterfaces = value;
        }

        /// <summary>
        /// The DNS address of the VPC endpoint.
        /// </summary>
        [Input("vpcEndpointId")]
        public Input<string>? VpcEndpointId { get; set; }

        /// <summary>
        /// The port that Amazon Redshift Serverless listens on.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public EndpointAccessVpcEndpointArgs()
        {
        }
        public static new EndpointAccessVpcEndpointArgs Empty => new EndpointAccessVpcEndpointArgs();
    }
}
