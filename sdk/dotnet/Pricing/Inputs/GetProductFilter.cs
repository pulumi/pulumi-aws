// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pricing.Inputs
{

    public sealed class GetProductFilterArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Product attribute name that you want to filter on.
        /// </summary>
        [Input("field", required: true)]
        public string Field { get; set; } = null!;

        /// <summary>
        /// Product attribute value that you want to filter on.
        /// </summary>
        [Input("value", required: true)]
        public string Value { get; set; } = null!;

        public GetProductFilterArgs()
        {
        }
        public static new GetProductFilterArgs Empty => new GetProductFilterArgs();
    }
}
