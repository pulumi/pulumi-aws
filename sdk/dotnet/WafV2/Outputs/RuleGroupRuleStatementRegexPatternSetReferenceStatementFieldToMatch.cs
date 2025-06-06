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
    public sealed class RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatch
    {
        /// <summary>
        /// Inspect all query arguments.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchAllQueryArguments? AllQueryArguments;
        /// <summary>
        /// Inspect the request body, which immediately follows the request headers.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBody? Body;
        /// <summary>
        /// Inspect the cookies in the web request. See Cookies below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchCookies? Cookies;
        /// <summary>
        /// Inspect the request headers. See Header Order below for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchHeaderOrder> HeaderOrders;
        /// <summary>
        /// Inspect the request headers. See Headers below for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchHeader> Headers;
        /// <summary>
        /// Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchJa3Fingerprint? Ja3Fingerprint;
        /// <summary>
        /// Inspect the JA4 fingerprint. See `ja4_fingerprint` below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchJa4Fingerprint? Ja4Fingerprint;
        /// <summary>
        /// Inspect the request body as JSON. See JSON Body for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchJsonBody? JsonBody;
        /// <summary>
        /// Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchMethod? Method;
        /// <summary>
        /// Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchQueryString? QueryString;
        /// <summary>
        /// Inspect a single header. See Single Header below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchSingleHeader? SingleHeader;
        /// <summary>
        /// Inspect a single query argument. See Single Query Argument below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchSingleQueryArgument? SingleQueryArgument;
        /// <summary>
        /// Inspect the part of a URL that follows the "#" symbol, providing additional information about the resource. See URI Fragment below for details.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchUriFragment? UriFragment;
        /// <summary>
        /// Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
        /// </summary>
        public readonly Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchUriPath? UriPath;

        [OutputConstructor]
        private RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatch(
            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchAllQueryArguments? allQueryArguments,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchBody? body,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchCookies? cookies,

            ImmutableArray<Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchHeaderOrder> headerOrders,

            ImmutableArray<Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchHeader> headers,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchJa3Fingerprint? ja3Fingerprint,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchJa4Fingerprint? ja4Fingerprint,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchJsonBody? jsonBody,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchMethod? method,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchQueryString? queryString,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchSingleHeader? singleHeader,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchSingleQueryArgument? singleQueryArgument,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchUriFragment? uriFragment,

            Outputs.RuleGroupRuleStatementRegexPatternSetReferenceStatementFieldToMatchUriPath? uriPath)
        {
            AllQueryArguments = allQueryArguments;
            Body = body;
            Cookies = cookies;
            HeaderOrders = headerOrders;
            Headers = headers;
            Ja3Fingerprint = ja3Fingerprint;
            Ja4Fingerprint = ja4Fingerprint;
            JsonBody = jsonBody;
            Method = method;
            QueryString = queryString;
            SingleHeader = singleHeader;
            SingleQueryArgument = singleQueryArgument;
            UriFragment = uriFragment;
            UriPath = uriPath;
        }
    }
}
