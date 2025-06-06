// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationArgs : global::Pulumi.ResourceArgs
    {
        [Input("patternObjectFilters")]
        private InputList<Inputs.AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs>? _patternObjectFilters;

        /// <summary>
        /// The configuration of filtering certain objects or content types of the data source. See `pattern_object_filter` block for details.
        /// </summary>
        public InputList<Inputs.AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs> PatternObjectFilters
        {
            get => _patternObjectFilters ?? (_patternObjectFilters = new InputList<Inputs.AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs>());
            set => _patternObjectFilters = value;
        }

        /// <summary>
        /// The type of filtering that you want to apply to certain objects or content of the data source. For example, the PATTERN type is regular expression patterns you can apply to filter your content.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationArgs()
        {
        }
        public static new AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationArgs Empty => new AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationArgs();
    }
}
