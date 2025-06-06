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
    public sealed class AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfiguration
    {
        /// <summary>
        /// The configuration of filtering certain objects or content types of the data source. See `pattern_object_filter` block for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilter> PatternObjectFilters;
        /// <summary>
        /// The type of filtering that you want to apply to certain objects or content of the data source. For example, the PATTERN type is regular expression patterns you can apply to filter your content.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfiguration(
            ImmutableArray<Outputs.AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilter> patternObjectFilters,

            string type)
        {
            PatternObjectFilters = patternObjectFilters;
            Type = type;
        }
    }
}
