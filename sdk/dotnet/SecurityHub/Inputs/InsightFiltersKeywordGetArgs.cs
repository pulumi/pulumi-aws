// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub.Inputs
{

    public sealed class InsightFiltersKeywordGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A value for the keyword.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public InsightFiltersKeywordGetArgs()
        {
        }
        public static new InsightFiltersKeywordGetArgs Empty => new InsightFiltersKeywordGetArgs();
    }
}
