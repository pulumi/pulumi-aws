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
    public sealed class AgentDataSourceDataSourceConfigurationWebConfigurationCrawlerConfiguration
    {
        /// <summary>
        /// Configuration of crawl limits for the web URLs. See `crawler_limits` block for details.
        /// </summary>
        public readonly Outputs.AgentDataSourceDataSourceConfigurationWebConfigurationCrawlerConfigurationCrawlerLimits? CrawlerLimits;
        /// <summary>
        /// List of one or more exclusion regular expression patterns to exclude certain object types that adhere to the pattern.
        /// </summary>
        public readonly ImmutableArray<string> ExclusionFilters;
        /// <summary>
        /// List of one or more inclusion regular expression patterns to include certain object types that adhere to the pattern.
        /// </summary>
        public readonly ImmutableArray<string> InclusionFilters;
        /// <summary>
        /// Scope of what is crawled for your URLs.
        /// </summary>
        public readonly string? Scope;
        /// <summary>
        /// String used for identifying the crawler or a bot when it accesses a web server. Default value is `bedrockbot_UUID`.
        /// </summary>
        public readonly string? UserAgent;

        [OutputConstructor]
        private AgentDataSourceDataSourceConfigurationWebConfigurationCrawlerConfiguration(
            Outputs.AgentDataSourceDataSourceConfigurationWebConfigurationCrawlerConfigurationCrawlerLimits? crawlerLimits,

            ImmutableArray<string> exclusionFilters,

            ImmutableArray<string> inclusionFilters,

            string? scope,

            string? userAgent)
        {
            CrawlerLimits = crawlerLimits;
            ExclusionFilters = exclusionFilters;
            InclusionFilters = inclusionFilters;
            Scope = scope;
            UserAgent = userAgent;
        }
    }
}
