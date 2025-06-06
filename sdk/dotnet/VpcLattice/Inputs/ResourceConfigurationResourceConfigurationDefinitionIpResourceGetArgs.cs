// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ResourceConfigurationResourceConfigurationDefinitionIpResourceGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The IP Address of the Resource for this configuration.
        /// </summary>
        [Input("ipAddress", required: true)]
        public Input<string> IpAddress { get; set; } = null!;

        public ResourceConfigurationResourceConfigurationDefinitionIpResourceGetArgs()
        {
        }
        public static new ResourceConfigurationResourceConfigurationDefinitionIpResourceGetArgs Empty => new ResourceConfigurationResourceConfigurationDefinitionIpResourceGetArgs();
    }
}
