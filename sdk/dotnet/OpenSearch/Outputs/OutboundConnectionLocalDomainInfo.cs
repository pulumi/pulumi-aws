// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch.Outputs
{

    [OutputType]
    public sealed class OutboundConnectionLocalDomainInfo
    {
        /// <summary>
        /// The name of the local domain.
        /// </summary>
        public readonly string DomainName;
        /// <summary>
        /// The Account ID of the owner of the local domain.
        /// </summary>
        public readonly string OwnerId;
        /// <summary>
        /// The region of the local domain.
        /// </summary>
        public readonly string Region;

        [OutputConstructor]
        private OutboundConnectionLocalDomainInfo(
            string domainName,

            string ownerId,

            string region)
        {
            DomainName = domainName;
            OwnerId = ownerId;
            Region = region;
        }
    }
}
