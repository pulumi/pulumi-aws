// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class RegexPatternSetRegularExpressionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The string representing the regular expression, see the AWS WAF [documentation](https://docs.aws.amazon.com/waf/latest/developerguide/waf-regex-pattern-set-creating.html) for more information.
        /// </summary>
        [Input("regexString", required: true)]
        public Input<string> RegexString { get; set; } = null!;

        public RegexPatternSetRegularExpressionArgs()
        {
        }
        public static new RegexPatternSetRegularExpressionArgs Empty => new RegexPatternSetRegularExpressionArgs();
    }
}
