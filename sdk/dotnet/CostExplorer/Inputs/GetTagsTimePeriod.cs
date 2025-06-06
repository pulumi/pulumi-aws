// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CostExplorer.Inputs
{

    public sealed class GetTagsTimePeriodArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Beginning of the time period.
        /// </summary>
        [Input("end", required: true)]
        public string End { get; set; } = null!;

        /// <summary>
        /// End of the time period.
        /// </summary>
        [Input("start", required: true)]
        public string Start { get; set; } = null!;

        public GetTagsTimePeriodArgs()
        {
        }
        public static new GetTagsTimePeriodArgs Empty => new GetTagsTimePeriodArgs();
    }
}
