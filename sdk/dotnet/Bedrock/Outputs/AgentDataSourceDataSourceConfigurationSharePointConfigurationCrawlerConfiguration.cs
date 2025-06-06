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
    public sealed class AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfiguration
    {
        /// <summary>
        /// The Salesforce standard object configuration. See `filter_configuration` block for details.
        /// </summary>
        public readonly Outputs.AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfiguration? FilterConfiguration;

        [OutputConstructor]
        private AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfiguration(Outputs.AgentDataSourceDataSourceConfigurationSharePointConfigurationCrawlerConfigurationFilterConfiguration? filterConfiguration)
        {
            FilterConfiguration = filterConfiguration;
        }
    }
}
