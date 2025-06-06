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
    public sealed class GetTagsFilterAndResult
    {
        /// <summary>
        /// Configuration block for the filter that's based on `CostCategory` values. See `cost_category` block below for details.
        /// </summary>
        public readonly Outputs.GetTagsFilterAndCostCategoryResult? CostCategory;
        /// <summary>
        /// Configuration block for the specific `Dimension` to use for `Expression`. See `dimension` block below for details.
        /// </summary>
        public readonly Outputs.GetTagsFilterAndDimensionResult? Dimension;
        /// <summary>
        /// Tags that match your request.
        /// </summary>
        public readonly Outputs.GetTagsFilterAndTagsResult? Tags;

        [OutputConstructor]
        private GetTagsFilterAndResult(
            Outputs.GetTagsFilterAndCostCategoryResult? costCategory,

            Outputs.GetTagsFilterAndDimensionResult? dimension,

            Outputs.GetTagsFilterAndTagsResult? tags)
        {
            CostCategory = costCategory;
            Dimension = dimension;
            Tags = tags;
        }
    }
}
