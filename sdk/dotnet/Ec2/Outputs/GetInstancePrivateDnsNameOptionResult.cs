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
    public sealed class GetInstancePrivateDnsNameOptionResult
    {
        /// <summary>
        /// Indicates whether to respond to DNS queries for instance hostnames with DNS A records.
        /// </summary>
        public readonly bool EnableResourceNameDnsARecord;
        /// <summary>
        /// Indicates whether to respond to DNS queries for instance hostnames with DNS AAAA records.
        /// </summary>
        public readonly bool EnableResourceNameDnsAaaaRecord;
        /// <summary>
        /// Type of hostname for EC2 instances.
        /// </summary>
        public readonly string HostnameType;

        [OutputConstructor]
        private GetInstancePrivateDnsNameOptionResult(
            bool enableResourceNameDnsARecord,

            bool enableResourceNameDnsAaaaRecord,

            string hostnameType)
        {
            EnableResourceNameDnsARecord = enableResourceNameDnsARecord;
            EnableResourceNameDnsAaaaRecord = enableResourceNameDnsAaaaRecord;
            HostnameType = hostnameType;
        }
    }
}
