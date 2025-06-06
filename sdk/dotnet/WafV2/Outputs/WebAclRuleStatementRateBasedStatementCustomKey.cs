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
    public sealed class WebAclRuleStatementRateBasedStatementCustomKey
    {
        /// <summary>
        /// Use the value of a cookie in the request as an aggregate key. See RateLimit `cookie` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyCookie? Cookie;
        /// <summary>
        /// Use the first IP address in an HTTP header as an aggregate key. See `forwarded_ip` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyForwardedIp? ForwardedIp;
        /// <summary>
        /// Use the value of a header in the request as an aggregate key. See RateLimit `header` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyHeader? Header;
        /// <summary>
        /// Use the request's HTTP method as an aggregate key. See RateLimit `http_method` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyHttpMethod? HttpMethod;
        /// <summary>
        /// Use the request's originating IP address as an aggregate key. See `RateLimit ip` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyIp? Ip;
        /// <summary>
        /// Use the JA3 fingerprint in the request as an aggregate key. See `RateLimit ip` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyJa3Fingerprint? Ja3Fingerprint;
        /// <summary>
        /// Use the JA3 fingerprint in the request as an aggregate key. See `RateLimit ip` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyJa4Fingerprint? Ja4Fingerprint;
        /// <summary>
        /// Use the specified label namespace as an aggregate key. See RateLimit `label_namespace` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace? LabelNamespace;
        /// <summary>
        /// Use the specified query argument as an aggregate key. See RateLimit `query_argument` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyQueryArgument? QueryArgument;
        /// <summary>
        /// Use the request's query string as an aggregate key. See RateLimit `query_string` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyQueryString? QueryString;
        /// <summary>
        /// Use the request's URI path as an aggregate key. See RateLimit `uri_path` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementRateBasedStatementCustomKeyUriPath? UriPath;

        [OutputConstructor]
        private WebAclRuleStatementRateBasedStatementCustomKey(
            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyCookie? cookie,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyForwardedIp? forwardedIp,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyHeader? header,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyHttpMethod? httpMethod,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyIp? ip,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyJa3Fingerprint? ja3Fingerprint,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyJa4Fingerprint? ja4Fingerprint,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyLabelNamespace? labelNamespace,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyQueryArgument? queryArgument,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyQueryString? queryString,

            Outputs.WebAclRuleStatementRateBasedStatementCustomKeyUriPath? uriPath)
        {
            Cookie = cookie;
            ForwardedIp = forwardedIp;
            Header = header;
            HttpMethod = httpMethod;
            Ip = ip;
            Ja3Fingerprint = ja3Fingerprint;
            Ja4Fingerprint = ja4Fingerprint;
            LabelNamespace = labelNamespace;
            QueryArgument = queryArgument;
            QueryString = queryString;
            UriPath = uriPath;
        }
    }
}
