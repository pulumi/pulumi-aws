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
    public sealed class CostCategoryRuleRuleNotAnd
    {
        /// <summary>
        /// Configuration block for the filter that's based on `CostCategory` values. See below.
        /// </summary>
        public readonly Outputs.CostCategoryRuleRuleNotAndCostCategory? CostCategory;
        /// <summary>
        /// Configuration block for the specific `Dimension` to use for `Expression`. See below.
        /// </summary>
        public readonly Outputs.CostCategoryRuleRuleNotAndDimension? Dimension;
        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public readonly Outputs.CostCategoryRuleRuleNotAndTags? Tags;

        [OutputConstructor]
        private CostCategoryRuleRuleNotAnd(
            Outputs.CostCategoryRuleRuleNotAndCostCategory? costCategory,

            Outputs.CostCategoryRuleRuleNotAndDimension? dimension,

            Outputs.CostCategoryRuleRuleNotAndTags? tags)
        {
            CostCategory = costCategory;
            Dimension = dimension;
            Tags = tags;
        }
    }
}
