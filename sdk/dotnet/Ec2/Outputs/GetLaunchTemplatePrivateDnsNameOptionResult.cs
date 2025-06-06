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
    public sealed class GetLaunchTemplatePrivateDnsNameOptionResult
    {
        public readonly bool EnableResourceNameDnsARecord;
        public readonly bool EnableResourceNameDnsAaaaRecord;
        public readonly string HostnameType;

        [OutputConstructor]
        private GetLaunchTemplatePrivateDnsNameOptionResult(
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
