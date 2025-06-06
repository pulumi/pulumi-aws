// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53.Outputs
{

    [OutputType]
    public sealed class GetRecordsResourceRecordSetCidrRoutingConfigResult
    {
        /// <summary>
        /// The CIDR collection ID.
        /// </summary>
        public readonly string CollectionId;
        /// <summary>
        /// The CIDR collection location name.
        /// </summary>
        public readonly string LocationName;

        [OutputConstructor]
        private GetRecordsResourceRecordSetCidrRoutingConfigResult(
            string collectionId,

            string locationName)
        {
            CollectionId = collectionId;
            LocationName = locationName;
        }
    }
}
