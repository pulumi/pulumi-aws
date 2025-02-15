// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
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
        /// <summary>
        /// A list of one or more exclusion regular expression patterns to exclude certain object types that adhere to the pattern.
        /// </summary>
        public readonly ImmutableArray<string> ExclusionFilters;
        /// <summary>
        /// A list of one or more inclusion regular expression patterns to include certain object types that adhere to the pattern.
        /// </summary>
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
