// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafRegional.Inputs
{

    public sealed class SizeConstraintSetSizeConstraintGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The type of comparison you want to perform.
        /// e.g., `EQ`, `NE`, `LT`, `GT`.
        /// See [docs](https://docs.aws.amazon.com/waf/latest/APIReference/API_wafRegional_SizeConstraint.html) for all supported values.
        /// </summary>
        [Input("comparisonOperator", required: true)]
        public Input<string> ComparisonOperator { get; set; } = null!;

        /// <summary>
        /// Specifies where in a web request to look for the size constraint.
        /// </summary>
        [Input("fieldToMatch", required: true)]
        public Input<Inputs.SizeConstraintSetSizeConstraintFieldToMatchGetArgs> FieldToMatch { get; set; } = null!;

        /// <summary>
        /// The size in bytes that you want to compare against the size of the specified `field_to_match`.
        /// Valid values are between 0 - 21474836480 bytes (0 - 20 GB).
        /// </summary>
        [Input("size", required: true)]
        public Input<int> Size { get; set; } = null!;

        /// <summary>
        /// Text transformations used to eliminate unusual formatting that attackers use in web requests in an effort to bypass AWS WAF.
        /// If you specify a transformation, AWS WAF performs the transformation on `field_to_match` before inspecting a request for a match.
        /// e.g., `CMD_LINE`, `HTML_ENTITY_DECODE` or `NONE`.
        /// See [docs](http://docs.aws.amazon.com/waf/latest/APIReference/API_SizeConstraint.html#WAF-Type-SizeConstraint-TextTransformation)
        /// for all supported values.
        /// **Note:** if you choose `BODY` as `type`, you must choose `NONE` because CloudFront forwards only the first 8192 bytes for inspection.
        /// </summary>
        [Input("textTransformation", required: true)]
        public Input<string> TextTransformation { get; set; } = null!;

        public SizeConstraintSetSizeConstraintGetArgs()
        {
        }
        public static new SizeConstraintSetSizeConstraintGetArgs Empty => new SizeConstraintSetSizeConstraintGetArgs();
    }
}
