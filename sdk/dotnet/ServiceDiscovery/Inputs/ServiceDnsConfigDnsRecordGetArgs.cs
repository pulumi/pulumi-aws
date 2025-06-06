// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ServiceDiscovery.Inputs
{

    public sealed class ServiceDnsConfigDnsRecordGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The amount of time, in seconds, that you want DNS resolvers to cache the settings for this resource record set.
        /// </summary>
        [Input("ttl", required: true)]
        public Input<int> Ttl { get; set; } = null!;

        /// <summary>
        /// The type of the resource, which indicates the value that Amazon Route 53 returns in response to DNS queries. Valid Values: A, AAAA, SRV, CNAME
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public ServiceDnsConfigDnsRecordGetArgs()
        {
        }
        public static new ServiceDnsConfigDnsRecordGetArgs Empty => new ServiceDnsConfigDnsRecordGetArgs();
    }
}
