// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Dax.Outputs
{

    [OutputType]
    public sealed class ClusterNode
    {
        public readonly string? Address;
        public readonly string? AvailabilityZone;
        public readonly string? Id;
        /// <summary>
        /// The port used by the configuration endpoint
        /// </summary>
        public readonly int? Port;

        [OutputConstructor]
        private ClusterNode(
            string? address,

            string? availabilityZone,

            string? id,

            int? port)
        {
            Address = address;
            AvailabilityZone = availabilityZone;
            Id = id;
            Port = port;
        }
    }
}
