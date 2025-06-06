// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CostExplorer.Inputs
{

    public sealed class GetTagsSortByArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// key that's used to sort the data. Valid values are: `BlendedCost`,  `UnblendedCost`, `AmortizedCost`, `NetAmortizedCost`, `NetUnblendedCost`, `UsageQuantity`, `NormalizedUsageAmount`.
        /// </summary>
        [Input("key")]
        public string? Key { get; set; }

        /// <summary>
        /// order that's used to sort the data. Valid values are: `ASCENDING`,  `DESCENDING`.
        /// </summary>
        [Input("sortOrder")]
        public string? SortOrder { get; set; }

        public GetTagsSortByArgs()
        {
        }
        public static new GetTagsSortByArgs Empty => new GetTagsSortByArgs();
    }
}
