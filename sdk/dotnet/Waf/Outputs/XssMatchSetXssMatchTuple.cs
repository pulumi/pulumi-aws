// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Waf.Outputs
{

    [OutputType]
    public sealed class XssMatchSetXssMatchTuple
    {
        /// <summary>
        /// Specifies where in a web request to look for cross-site scripting attacks.
        /// </summary>
        public readonly Outputs.XssMatchSetXssMatchTupleFieldToMatch FieldToMatch;
        /// <summary>
        /// Text transformations used to eliminate unusual formatting that attackers use in web requests in an effort to bypass AWS WAF.
        /// If you specify a transformation, AWS WAF performs the transformation on `target_string` before inspecting a request for a match.
        /// e.g., `CMD_LINE`, `HTML_ENTITY_DECODE` or `NONE`.
        /// See [docs](http://docs.aws.amazon.com/waf/latest/APIReference/API_XssMatchTuple.html#WAF-Type-XssMatchTuple-TextTransformation)
        /// for all supported values.
        /// </summary>
        public readonly string TextTransformation;

        [OutputConstructor]
        private XssMatchSetXssMatchTuple(
            Outputs.XssMatchSetXssMatchTupleFieldToMatch fieldToMatch,

            string textTransformation)
        {
            FieldToMatch = fieldToMatch;
            TextTransformation = textTransformation;
        }
    }
}
