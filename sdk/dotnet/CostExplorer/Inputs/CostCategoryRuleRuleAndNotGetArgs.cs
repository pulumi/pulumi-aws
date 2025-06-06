// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CostExplorer.Inputs
{

    public sealed class CostCategoryRuleRuleAndNotGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for the filter that's based on `CostCategory` values. See below.
        /// </summary>
        [Input("costCategory")]
        public Input<Inputs.CostCategoryRuleRuleAndNotCostCategoryGetArgs>? CostCategory { get; set; }

        /// <summary>
        /// Configuration block for the specific `Dimension` to use for `Expression`. See below.
        /// </summary>
        [Input("dimension")]
        public Input<Inputs.CostCategoryRuleRuleAndNotDimensionGetArgs>? Dimension { get; set; }

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Input("tags")]
        public Input<Inputs.CostCategoryRuleRuleAndNotTagsGetArgs>? Tags { get; set; }

        public CostCategoryRuleRuleAndNotGetArgs()
        {
        }
        public static new CostCategoryRuleRuleAndNotGetArgs Empty => new CostCategoryRuleRuleAndNotGetArgs();
    }
}
