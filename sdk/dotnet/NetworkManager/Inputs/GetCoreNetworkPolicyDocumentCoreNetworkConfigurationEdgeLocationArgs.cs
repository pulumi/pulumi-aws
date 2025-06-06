// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkManager.Inputs
{

    public sealed class GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ASN of the Core Network Edge in an AWS Region. By default, the ASN will be a single integer automatically assigned from `asn_ranges`
        /// </summary>
        [Input("asn")]
        public Input<string>? Asn { get; set; }

        [Input("insideCidrBlocks")]
        private InputList<string>? _insideCidrBlocks;

        /// <summary>
        /// The local CIDR blocks for this Core Network Edge for AWS Transit Gateway Connect attachments. By default, this CIDR block will be one or more optional IPv4 and IPv6 CIDR prefixes auto-assigned from `inside_cidr_blocks`.
        /// </summary>
        public InputList<string> InsideCidrBlocks
        {
            get => _insideCidrBlocks ?? (_insideCidrBlocks = new InputList<string>());
            set => _insideCidrBlocks = value;
        }

        [Input("location", required: true)]
        public Input<string> Location { get; set; } = null!;

        public GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs()
        {
        }
        public static new GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs Empty => new GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs();
    }
}
