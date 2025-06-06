// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Outputs
{

    [OutputType]
    public sealed class VpcEndpointServicePrivateDnsNameConfiguration
    {
        /// <summary>
        /// Name of the record subdomain the service provider needs to create.
        /// </summary>
        public readonly string? Name;
        /// <summary>
        /// Verification state of the VPC endpoint service. Consumers of the endpoint service can use the private name only when the state is `verified`.
        /// </summary>
        public readonly string? State;
        /// <summary>
        /// Endpoint service verification type, for example `TXT`.
        /// </summary>
        public readonly string? Type;
        /// <summary>
        /// Value the service provider adds to the private DNS name domain record before verification.
        /// </summary>
        public readonly string? Value;

        [OutputConstructor]
        private VpcEndpointServicePrivateDnsNameConfiguration(
            string? name,

            string? state,

            string? type,

            string? value)
        {
            Name = name;
            State = state;
            Type = type;
            Value = value;
        }
    }
}
