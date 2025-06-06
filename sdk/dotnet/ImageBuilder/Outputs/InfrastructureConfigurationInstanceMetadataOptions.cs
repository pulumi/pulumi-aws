// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Outputs
{

    [OutputType]
    public sealed class InfrastructureConfigurationInstanceMetadataOptions
    {
        /// <summary>
        /// The number of hops that an instance can traverse to reach its destonation.
        /// </summary>
        public readonly int? HttpPutResponseHopLimit;
        /// <summary>
        /// Whether a signed token is required for instance metadata retrieval requests. Valid values: `required`, `optional`.
        /// </summary>
        public readonly string? HttpTokens;

        [OutputConstructor]
        private InfrastructureConfigurationInstanceMetadataOptions(
            int? httpPutResponseHopLimit,

            string? httpTokens)
        {
            HttpPutResponseHopLimit = httpPutResponseHopLimit;
            HttpTokens = httpTokens;
        }
    }
}
