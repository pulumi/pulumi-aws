// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub.Outputs
{

    [OutputType]
    public sealed class InsightFiltersNetworkSourceIpv6
    {
        /// <summary>
        /// A finding's CIDR value.
        /// </summary>
        public readonly string Cidr;

        [OutputConstructor]
        private InsightFiltersNetworkSourceIpv6(string cidr)
        {
            Cidr = cidr;
        }
    }
}
