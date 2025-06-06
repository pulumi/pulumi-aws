// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Outputs
{

    [OutputType]
    public sealed class AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilter
    {
        public readonly ImmutableArray<string> ExclusionFilters;
        public readonly ImmutableArray<string> InclusionFilters;
        /// <summary>
        /// The supported object type or content type of the data source.
        /// </summary>
        public readonly string ObjectType;

        [OutputConstructor]
        private AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilter(
            ImmutableArray<string> exclusionFilters,

            ImmutableArray<string> inclusionFilters,

            string objectType)
        {
            ExclusionFilters = exclusionFilters;
            InclusionFilters = inclusionFilters;
            ObjectType = objectType;
        }
    }
}
