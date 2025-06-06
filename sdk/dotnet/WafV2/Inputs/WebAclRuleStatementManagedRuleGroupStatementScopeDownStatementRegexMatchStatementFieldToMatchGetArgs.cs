// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Inspect all query arguments.
        /// </summary>
        [Input("allQueryArguments")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchAllQueryArgumentsGetArgs>? AllQueryArguments { get; set; }

        /// <summary>
        /// Inspect the request body, which immediately follows the request headers. See `body` below for details.
        /// </summary>
        [Input("body")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyGetArgs>? Body { get; set; }

        /// <summary>
        /// Inspect the cookies in the web request. See `cookies` below for details.
        /// </summary>
        [Input("cookies")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchCookiesGetArgs>? Cookies { get; set; }

        [Input("headerOrders")]
        private InputList<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchHeaderOrderGetArgs>? _headerOrders;

        /// <summary>
        /// Inspect a string containing the list of the request's header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
        /// </summary>
        public InputList<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchHeaderOrderGetArgs> HeaderOrders
        {
            get => _headerOrders ?? (_headerOrders = new InputList<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchHeaderOrderGetArgs>());
            set => _headerOrders = value;
        }

        [Input("headers")]
        private InputList<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchHeaderGetArgs>? _headers;

        /// <summary>
        /// Inspect the request headers. See `headers` below for details.
        /// </summary>
        public InputList<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchHeaderGetArgs> Headers
        {
            get => _headers ?? (_headers = new InputList<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchHeaderGetArgs>());
            set => _headers = value;
        }

        /// <summary>
        /// Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
        /// </summary>
        [Input("ja3Fingerprint")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchJa3FingerprintGetArgs>? Ja3Fingerprint { get; set; }

        /// <summary>
        /// Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
        /// </summary>
        [Input("ja4Fingerprint")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchJa4FingerprintGetArgs>? Ja4Fingerprint { get; set; }

        /// <summary>
        /// Inspect the request body as JSON. See `json_body` for details.
        /// </summary>
        [Input("jsonBody")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchJsonBodyGetArgs>? JsonBody { get; set; }

        /// <summary>
        /// Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
        /// </summary>
        [Input("method")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchMethodGetArgs>? Method { get; set; }

        /// <summary>
        /// Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
        /// </summary>
        [Input("queryString")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchQueryStringGetArgs>? QueryString { get; set; }

        /// <summary>
        /// Inspect a single header. See `single_header` below for details.
        /// </summary>
        [Input("singleHeader")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchSingleHeaderGetArgs>? SingleHeader { get; set; }

        /// <summary>
        /// Inspect a single query argument. See `single_query_argument` below for details.
        /// </summary>
        [Input("singleQueryArgument")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchSingleQueryArgumentGetArgs>? SingleQueryArgument { get; set; }

        /// <summary>
        /// Inspect the part of a URL that follows the "#" symbol, providing additional information about the resource. See `uri_fragment` below for details.
        /// </summary>
        [Input("uriFragment")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchUriFragmentGetArgs>? UriFragment { get; set; }

        /// <summary>
        /// Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
        /// </summary>
        [Input("uriPath")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchUriPathGetArgs>? UriPath { get; set; }

        public WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchGetArgs()
        {
        }
        public static new WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchGetArgs Empty => new WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchGetArgs();
    }
}
