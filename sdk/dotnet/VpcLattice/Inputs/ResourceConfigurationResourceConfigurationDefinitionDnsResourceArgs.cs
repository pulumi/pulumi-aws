// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ResourceConfigurationResourceConfigurationDefinitionDnsResourceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The hostname of the Resource for this configuration.
        /// </summary>
        [Input("domainName", required: true)]
        public Input<string> DomainName { get; set; } = null!;

        /// <summary>
        /// The IP Address type either `IPV4` or `IPV6`
        /// </summary>
        [Input("ipAddressType", required: true)]
        public Input<string> IpAddressType { get; set; } = null!;

        public ResourceConfigurationResourceConfigurationDefinitionDnsResourceArgs()
        {
        }
        public static new ResourceConfigurationResourceConfigurationDefinitionDnsResourceArgs Empty => new ResourceConfigurationResourceConfigurationDefinitionDnsResourceArgs();
    }
}
