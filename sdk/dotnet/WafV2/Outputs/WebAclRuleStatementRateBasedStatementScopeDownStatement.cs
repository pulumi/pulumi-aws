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
    public sealed class WebAclRuleStatementRateBasedStatementScopeDownStatement
    {
        /// <summary>
        /// Logical rule statement used to combine other rule statements with AND logic. See `and_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementAndStatement? AndStatement;
        /// <summary>
        /// Rule statement that inspects web traffic based on the Autonomous System Number (ASN) associated with the request's IP address. See `asn_match_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementAsnMatchStatement? AsnMatchStatement;
        /// <summary>
        /// Rule statement that defines a string match search for AWS WAF to apply to web requests. See `byte_match_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementByteMatchStatement? ByteMatchStatement;
        /// <summary>
        /// Rule statement used to identify web requests based on country of origin. See `geo_match_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementGeoMatchStatement? GeoMatchStatement;
        /// <summary>
        /// Rule statement used to detect web requests coming from particular IP addresses or address ranges. See `ip_set_reference_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementIpSetReferenceStatement? IpSetReferenceStatement;
        /// <summary>
        /// Rule statement that defines a string match search against labels that have been added to the web request by rules that have already run in the web ACL. See `label_match_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementLabelMatchStatement? LabelMatchStatement;
        /// <summary>
        /// Logical rule statement used to negate the results of another rule statement. See `not_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementNotStatement? NotStatement;
        /// <summary>
        /// Logical rule statement used to combine other rule statements with OR logic. See `or_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementOrStatement? OrStatement;
        /// <summary>
        /// Rule statement used to search web request components for a match against a single regular expression. See `regex_match_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementRegexMatchStatement? RegexMatchStatement;
        /// <summary>
        /// Rule statement used to search web request components for matches with regular expressions. See `regex_pattern_set_reference_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementRegexPatternSetReferenceStatement? RegexPatternSetReferenceStatement;
        /// <summary>
        /// Rule statement that compares a number of bytes against the size of a request component, using a comparison operator, such as greater than (&gt;) or less than (&lt;). See `size_constraint_statement` below for more details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatement? SizeConstraintStatement;
        /// <summary>
        /// An SQL injection match condition identifies the part of web requests, such as the URI or the query string, that you want AWS WAF to inspect. See `sqli_match_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatement? SqliMatchStatement;
        /// <summary>
        /// Rule statement that defines a cross-site scripting (XSS) match search for AWS WAF to apply to web requests. See `xss_match_statement` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementXssMatchStatement? XssMatchStatement;

        [OutputConstructor]
        private WebAclRuleStatementRateBasedStatementScopeDownStatement(
            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementAndStatement? andStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementAsnMatchStatement? asnMatchStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementByteMatchStatement? byteMatchStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementGeoMatchStatement? geoMatchStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementIpSetReferenceStatement? ipSetReferenceStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementLabelMatchStatement? labelMatchStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementNotStatement? notStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementOrStatement? orStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementRegexMatchStatement? regexMatchStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementRegexPatternSetReferenceStatement? regexPatternSetReferenceStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatement? sizeConstraintStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatement? sqliMatchStatement,

            Outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementXssMatchStatement? xssMatchStatement)
        {
            AndStatement = andStatement;
            AsnMatchStatement = asnMatchStatement;
            ByteMatchStatement = byteMatchStatement;
            GeoMatchStatement = geoMatchStatement;
            IpSetReferenceStatement = ipSetReferenceStatement;
            LabelMatchStatement = labelMatchStatement;
            NotStatement = notStatement;
            OrStatement = orStatement;
            RegexMatchStatement = regexMatchStatement;
            RegexPatternSetReferenceStatement = regexPatternSetReferenceStatement;
            SizeConstraintStatement = sizeConstraintStatement;
            SqliMatchStatement = sqliMatchStatement;
            XssMatchStatement = xssMatchStatement;
        }
    }
}
