// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MemoryDb.Outputs
{

    [OutputType]
    public sealed class ClusterShardNodeEndpoint
    {
        /// <summary>
        /// DNS hostname of the node.
        /// </summary>
        public readonly string? Address;
        /// <summary>
        /// The port number on which each of the nodes accepts connections. Defaults to `6379`.
        /// </summary>
        public readonly int? Port;

        [OutputConstructor]
        private ClusterShardNodeEndpoint(
            string? address,

            int? port)
        {
            Address = address;
            Port = port;
        }
    }
}
