// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ResourceConfigurationResourceConfigurationDefinitionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Resource DNS Configuration. See `arn_resource` Block for details.
        /// </summary>
        [Input("arnResource")]
        public Input<Inputs.ResourceConfigurationResourceConfigurationDefinitionArnResourceArgs>? ArnResource { get; set; }

        /// <summary>
        /// Resource DNS Configuration. See `dns_resource` Block for details.
        /// </summary>
        [Input("dnsResource")]
        public Input<Inputs.ResourceConfigurationResourceConfigurationDefinitionDnsResourceArgs>? DnsResource { get; set; }

        /// <summary>
        /// Resource DNS Configuration. See `ip_resource` Block for details.
        /// </summary>
        [Input("ipResource")]
        public Input<Inputs.ResourceConfigurationResourceConfigurationDefinitionIpResourceArgs>? IpResource { get; set; }

        public ResourceConfigurationResourceConfigurationDefinitionArgs()
        {
        }
        public static new ResourceConfigurationResourceConfigurationDefinitionArgs Empty => new ResourceConfigurationResourceConfigurationDefinitionArgs();
    }
}
