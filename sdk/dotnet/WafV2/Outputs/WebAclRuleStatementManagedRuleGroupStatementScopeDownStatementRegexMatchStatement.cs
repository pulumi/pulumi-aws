// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Outputs
{

    [OutputType]
    public sealed class WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatement
    {
        /// <summary>
        /// The part of a web request that you want AWS WAF to inspect. See `field_to_match` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatch? FieldToMatch;
        /// <summary>
        /// String representing the regular expression. Minimum of `1` and maximum of `512` characters.
        /// </summary>
        public readonly string RegexString;
        /// <summary>
        /// Text transformations eliminate some of the unusual formatting that attackers use in web requests in an effort to bypass detection. At least one transformation is required. See `text_transformation` below for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementTextTransformation> TextTransformations;

        [OutputConstructor]
        private WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatement(
            Outputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatch? fieldToMatch,

            string regexString,

            ImmutableArray<Outputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementTextTransformation> textTransformations)
        {
            FieldToMatch = fieldToMatch;
            RegexString = regexString;
            TextTransformations = textTransformations;
        }
    }
}
