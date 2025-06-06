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
    public sealed class CostCategoryRuleRuleAnd
    {
        /// <summary>
        /// Return results that match both `Dimension` objects.
        /// </summary>
        public readonly ImmutableArray<Outputs.CostCategoryRuleRuleAndAnd> Ands;
        /// <summary>
        /// Configuration block for the filter that's based on `CostCategory` values. See below.
        /// </summary>
        public readonly Outputs.CostCategoryRuleRuleAndCostCategory? CostCategory;
        /// <summary>
        /// Configuration block for the specific `Dimension` to use for `Expression`. See below.
        /// </summary>
        public readonly Outputs.CostCategoryRuleRuleAndDimension? Dimension;
        /// <summary>
        /// Return results that match both `Dimension` object.
        /// </summary>
        public readonly Outputs.CostCategoryRuleRuleAndNot? Not;
        /// <summary>
        /// Return results that match both `Dimension` object.
        /// </summary>
        public readonly ImmutableArray<Outputs.CostCategoryRuleRuleAndOr> Ors;
        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public readonly Outputs.CostCategoryRuleRuleAndTags? Tags;

        [OutputConstructor]
        private CostCategoryRuleRuleAnd(
            ImmutableArray<Outputs.CostCategoryRuleRuleAndAnd> ands,

            Outputs.CostCategoryRuleRuleAndCostCategory? costCategory,

            Outputs.CostCategoryRuleRuleAndDimension? dimension,

            Outputs.CostCategoryRuleRuleAndNot? not,

            ImmutableArray<Outputs.CostCategoryRuleRuleAndOr> ors,

            Outputs.CostCategoryRuleRuleAndTags? tags)
        {
            Ands = ands;
            CostCategory = costCategory;
            Dimension = dimension;
            Not = not;
            Ors = ors;
            Tags = tags;
        }
    }
}
