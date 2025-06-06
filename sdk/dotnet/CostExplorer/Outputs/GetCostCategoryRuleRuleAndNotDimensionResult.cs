// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CostExplorer.Outputs
{

    [OutputType]
    public sealed class GetCostCategoryRuleRuleAndNotDimensionResult
    {
        /// <summary>
        /// Key for the tag.
        /// </summary>
        public readonly string Key;
        /// <summary>
        /// Match options that you can use to filter your results. MatchOptions is only applicable for actions related to cost category. The default values for MatchOptions is `EQUALS` and `CASE_SENSITIVE`. Valid values are: `EQUALS`,  `ABSENT`, `STARTS_WITH`, `ENDS_WITH`, `CONTAINS`, `CASE_SENSITIVE`, `CASE_INSENSITIVE`.
        /// </summary>
        public readonly ImmutableArray<string> MatchOptions;
        /// <summary>
        /// Parameter values.
        /// </summary>
        public readonly ImmutableArray<string> Values;

        [OutputConstructor]
        private GetCostCategoryRuleRuleAndNotDimensionResult(
            string key,

            ImmutableArray<string> matchOptions,

            ImmutableArray<string> values)
        {
            Key = key;
            MatchOptions = matchOptions;
            Values = values;
        }
    }
}
