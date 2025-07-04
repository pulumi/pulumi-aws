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
    public sealed class RuleGroupRuleStatement
    {
        /// <summary>
        /// A logical rule statement used to combine other rule statements with AND logic. See AND Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementAndStatement? AndStatement;
        /// <summary>
        /// Rule statement that inspects web traffic based on the Autonomous System Number (ASN) associated with the request's IP address. See `asn_match_statement` below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementAsnMatchStatement? AsnMatchStatement;
        /// <summary>
        /// A rule statement that defines a string match search for AWS WAF to apply to web requests. See Byte Match Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementByteMatchStatement? ByteMatchStatement;
        /// <summary>
        /// A rule statement used to identify web requests based on country of origin. See GEO Match Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementGeoMatchStatement? GeoMatchStatement;
        /// <summary>
        /// A rule statement used to detect web requests coming from particular IP addresses or address ranges. See IP Set Reference Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementIpSetReferenceStatement? IpSetReferenceStatement;
        /// <summary>
        /// A rule statement that defines a string match search against labels that have been added to the web request by rules that have already run in the web ACL. See Label Match Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementLabelMatchStatement? LabelMatchStatement;
        /// <summary>
        /// A logical rule statement used to negate the results of another rule statement. See NOT Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementNotStatement? NotStatement;
        /// <summary>
        /// A logical rule statement used to combine other rule statements with OR logic. See OR Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementOrStatement? OrStatement;
        /// <summary>
        /// A rate-based rule tracks the rate of requests for each originating `IP address`, and triggers the rule action when the rate exceeds a limit that you specify on the number of requests in any `5-minute` time span. This statement can not be nested. See Rate Based Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRateBasedStatement? RateBasedStatement;
        /// <summary>
        /// A rule statement used to search web request components for a match against a single regular expression. See Regex Match Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexMatchStatement? RegexMatchStatement;
        /// <summary>
        /// A rule statement used to search web request components for matches with regular expressions. See Regex Pattern Set Reference Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatement? RegexPatternSetReferenceStatement;
        /// <summary>
        /// A rule statement that compares a number of bytes against the size of a request component, using a comparison operator, such as greater than (&gt;) or less than (&lt;). See Size Constraint Statement below for more details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementSizeConstraintStatement? SizeConstraintStatement;
        /// <summary>
        /// An SQL injection match condition identifies the part of web requests, such as the URI or the query string, that you want AWS WAF to inspect. See SQL Injection Match Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementSqliMatchStatement? SqliMatchStatement;
        /// <summary>
        /// A rule statement that defines a cross-site scripting (XSS) match search for AWS WAF to apply to web requests. See XSS Match Statement below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementXssMatchStatement? XssMatchStatement;

        [OutputConstructor]
        private RuleGroupRuleStatement(
            Outputs.RuleGroupRuleStatementAndStatement? andStatement,

            Outputs.RuleGroupRuleStatementAsnMatchStatement? asnMatchStatement,

            Outputs.RuleGroupRuleStatementByteMatchStatement? byteMatchStatement,

            Outputs.RuleGroupRuleStatementGeoMatchStatement? geoMatchStatement,

            Outputs.RuleGroupRuleStatementIpSetReferenceStatement? ipSetReferenceStatement,

            Outputs.RuleGroupRuleStatementLabelMatchStatement? labelMatchStatement,

            Outputs.RuleGroupRuleStatementNotStatement? notStatement,

            Outputs.RuleGroupRuleStatementOrStatement? orStatement,

            Outputs.RuleGroupRuleStatementRateBasedStatement? rateBasedStatement,

            Outputs.RuleGroupRuleStatementRegexMatchStatement? regexMatchStatement,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatement? regexPatternSetReferenceStatement,

            Outputs.RuleGroupRuleStatementSizeConstraintStatement? sizeConstraintStatement,

            Outputs.RuleGroupRuleStatementSqliMatchStatement? sqliMatchStatement,

            Outputs.RuleGroupRuleStatementXssMatchStatement? xssMatchStatement)
        {
            AndStatement = andStatement;
            AsnMatchStatement = asnMatchStatement;
            ByteMatchStatement = byteMatchStatement;
            GeoMatchStatement = geoMatchStatement;
            IpSetReferenceStatement = ipSetReferenceStatement;
            LabelMatchStatement = labelMatchStatement;
            NotStatement = notStatement;
            OrStatement = orStatement;
            RateBasedStatement = rateBasedStatement;
            RegexMatchStatement = regexMatchStatement;
            RegexPatternSetReferenceStatement = regexPatternSetReferenceStatement;
            SizeConstraintStatement = sizeConstraintStatement;
            SqliMatchStatement = sqliMatchStatement;
            XssMatchStatement = xssMatchStatement;
        }
    }
}
