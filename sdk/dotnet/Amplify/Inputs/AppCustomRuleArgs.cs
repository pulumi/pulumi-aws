// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Amplify.Inputs
{

    public sealed class AppCustomRuleArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Condition for a URL rewrite or redirect rule, such as a country code.
        /// </summary>
        [Input("condition")]
        public Input<string>? Condition { get; set; }

        /// <summary>
        /// Source pattern for a URL rewrite or redirect rule.
        /// </summary>
        [Input("source", required: true)]
        public Input<string> Source { get; set; } = null!;

        /// <summary>
        /// Status code for a URL rewrite or redirect rule. Valid values: `200`, `301`, `302`, `404`, `404-200`.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        /// <summary>
        /// Target pattern for a URL rewrite or redirect rule.
        /// </summary>
        [Input("target", required: true)]
        public Input<string> Target { get; set; } = null!;

        public AppCustomRuleArgs()
        {
        }
        public static new AppCustomRuleArgs Empty => new AppCustomRuleArgs();
    }
}
