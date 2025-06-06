// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CostExplorer.Inputs
{

    public sealed class AnomalySubscriptionThresholdExpressionOrGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for the filter that's based on  values. See Cost Category below.
        /// </summary>
        [Input("costCategory")]
        public Input<Inputs.AnomalySubscriptionThresholdExpressionOrCostCategoryGetArgs>? CostCategory { get; set; }

        /// <summary>
        /// Configuration block for the specific Dimension to use for.
        /// </summary>
        [Input("dimension")]
        public Input<Inputs.AnomalySubscriptionThresholdExpressionOrDimensionGetArgs>? Dimension { get; set; }

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Input("tags")]
        public Input<Inputs.AnomalySubscriptionThresholdExpressionOrTagsGetArgs>? Tags { get; set; }

        public AnomalySubscriptionThresholdExpressionOrGetArgs()
        {
        }
        public static new AnomalySubscriptionThresholdExpressionOrGetArgs Empty => new AnomalySubscriptionThresholdExpressionOrGetArgs();
    }
}
