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
    public sealed class GetCostCategoryRuleRuleNotOrResult
    {
        /// <summary>
        /// Configuration block for the filter that's based on `CostCategory` values. See below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetCostCategoryRuleRuleNotOrCostCategoryResult> CostCategories;
        /// <summary>
        /// Configuration block for the specific `Dimension` to use for `Expression`. See below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetCostCategoryRuleRuleNotOrDimensionResult> Dimensions;
        /// <summary>
        /// Configuration block for the specific `Tag` to use for `Expression`. See below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetCostCategoryRuleRuleNotOrTagResult> Tags;

        [OutputConstructor]
        private GetCostCategoryRuleRuleNotOrResult(
            ImmutableArray<Outputs.GetCostCategoryRuleRuleNotOrCostCategoryResult> costCategories,

            ImmutableArray<Outputs.GetCostCategoryRuleRuleNotOrDimensionResult> dimensions,

            ImmutableArray<Outputs.GetCostCategoryRuleRuleNotOrTagResult> tags)
        {
            CostCategories = costCategories;
            Dimensions = dimensions;
            Tags = tags;
        }
    }
}
