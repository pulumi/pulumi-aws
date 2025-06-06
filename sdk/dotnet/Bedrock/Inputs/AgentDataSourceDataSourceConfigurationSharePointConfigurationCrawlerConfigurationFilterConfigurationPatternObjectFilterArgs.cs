// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs : global::Pulumi.ResourceArgs
    {
        [Input("filters")]
        private InputList<Inputs.AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs>? _filters;

        /// <summary>
        /// The configuration of specific filters applied to your data source content. Minimum of 1 filter and maximum of 25 filters.
        /// 
        /// Each filter object should contain the following configuration:
        /// </summary>
        public InputList<Inputs.AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs> Filters
        {
            get => _filters ?? (_filters = new InputList<Inputs.AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs>());
            set => _filters = value;
        }

        public AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs()
        {
        }
        public static new AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs Empty => new AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs();
    }
}
