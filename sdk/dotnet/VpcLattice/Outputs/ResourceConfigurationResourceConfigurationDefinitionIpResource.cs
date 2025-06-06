// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Outputs
{

    [OutputType]
    public sealed class ResourceConfigurationResourceConfigurationDefinitionIpResource
    {
        /// <summary>
        /// The IP Address of the Resource for this configuration.
        /// </summary>
        public readonly string IpAddress;

        [OutputConstructor]
        private ResourceConfigurationResourceConfigurationDefinitionIpResource(string ipAddress)
        {
            IpAddress = ipAddress;
        }
    }
}
