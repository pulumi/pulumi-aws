// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchAllQueryArgumentsArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchBodyArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchCookiesArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchHeaderArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchHeaderOrderArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchJa3FingerprintArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchJa4FingerprintArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchJsonBodyArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchMethodArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchQueryStringArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchSingleHeaderArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchSingleQueryArgumentArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchUriFragmentArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementXssMatchStatementFieldToMatchUriPathArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WebAclRuleStatementXssMatchStatementFieldToMatchArgs extends com.pulumi.resources.ResourceArgs {

    public static final WebAclRuleStatementXssMatchStatementFieldToMatchArgs Empty = new WebAclRuleStatementXssMatchStatementFieldToMatchArgs();

    /**
     * Inspect all query arguments.
     * 
     */
    @Import(name="allQueryArguments")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchAllQueryArgumentsArgs> allQueryArguments;

    /**
     * @return Inspect all query arguments.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchAllQueryArgumentsArgs>> allQueryArguments() {
        return Optional.ofNullable(this.allQueryArguments);
    }

    /**
     * Inspect the request body, which immediately follows the request headers. See `body` below for details.
     * 
     */
    @Import(name="body")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchBodyArgs> body;

    /**
     * @return Inspect the request body, which immediately follows the request headers. See `body` below for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchBodyArgs>> body() {
        return Optional.ofNullable(this.body);
    }

    /**
     * Inspect the cookies in the web request. See `cookies` below for details.
     * 
     */
    @Import(name="cookies")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchCookiesArgs> cookies;

    /**
     * @return Inspect the cookies in the web request. See `cookies` below for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchCookiesArgs>> cookies() {
        return Optional.ofNullable(this.cookies);
    }

    /**
     * Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
     * 
     */
    @Import(name="headerOrders")
    private @Nullable Output<List<WebAclRuleStatementXssMatchStatementFieldToMatchHeaderOrderArgs>> headerOrders;

    /**
     * @return Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
     * 
     */
    public Optional<Output<List<WebAclRuleStatementXssMatchStatementFieldToMatchHeaderOrderArgs>>> headerOrders() {
        return Optional.ofNullable(this.headerOrders);
    }

    /**
     * Inspect the request headers. See `headers` below for details.
     * 
     */
    @Import(name="headers")
    private @Nullable Output<List<WebAclRuleStatementXssMatchStatementFieldToMatchHeaderArgs>> headers;

    /**
     * @return Inspect the request headers. See `headers` below for details.
     * 
     */
    public Optional<Output<List<WebAclRuleStatementXssMatchStatementFieldToMatchHeaderArgs>>> headers() {
        return Optional.ofNullable(this.headers);
    }

    /**
     * Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
     * 
     */
    @Import(name="ja3Fingerprint")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchJa3FingerprintArgs> ja3Fingerprint;

    /**
     * @return Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchJa3FingerprintArgs>> ja3Fingerprint() {
        return Optional.ofNullable(this.ja3Fingerprint);
    }

    /**
     * Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
     * 
     */
    @Import(name="ja4Fingerprint")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchJa4FingerprintArgs> ja4Fingerprint;

    /**
     * @return Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchJa4FingerprintArgs>> ja4Fingerprint() {
        return Optional.ofNullable(this.ja4Fingerprint);
    }

    /**
     * Inspect the request body as JSON. See `json_body` for details.
     * 
     */
    @Import(name="jsonBody")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchJsonBodyArgs> jsonBody;

    /**
     * @return Inspect the request body as JSON. See `json_body` for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchJsonBodyArgs>> jsonBody() {
        return Optional.ofNullable(this.jsonBody);
    }

    /**
     * Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
     * 
     */
    @Import(name="method")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchMethodArgs> method;

    /**
     * @return Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchMethodArgs>> method() {
        return Optional.ofNullable(this.method);
    }

    /**
     * Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
     * 
     */
    @Import(name="queryString")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchQueryStringArgs> queryString;

    /**
     * @return Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchQueryStringArgs>> queryString() {
        return Optional.ofNullable(this.queryString);
    }

    /**
     * Inspect a single header. See `single_header` below for details.
     * 
     */
    @Import(name="singleHeader")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchSingleHeaderArgs> singleHeader;

    /**
     * @return Inspect a single header. See `single_header` below for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchSingleHeaderArgs>> singleHeader() {
        return Optional.ofNullable(this.singleHeader);
    }

    /**
     * Inspect a single query argument. See `single_query_argument` below for details.
     * 
     */
    @Import(name="singleQueryArgument")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchSingleQueryArgumentArgs> singleQueryArgument;

    /**
     * @return Inspect a single query argument. See `single_query_argument` below for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchSingleQueryArgumentArgs>> singleQueryArgument() {
        return Optional.ofNullable(this.singleQueryArgument);
    }

    /**
     * Inspect the part of a URL that follows the &#34;#&#34; symbol, providing additional information about the resource. See `uri_fragment` below for details.
     * 
     */
    @Import(name="uriFragment")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchUriFragmentArgs> uriFragment;

    /**
     * @return Inspect the part of a URL that follows the &#34;#&#34; symbol, providing additional information about the resource. See `uri_fragment` below for details.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchUriFragmentArgs>> uriFragment() {
        return Optional.ofNullable(this.uriFragment);
    }

    /**
     * Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
     * 
     */
    @Import(name="uriPath")
    private @Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchUriPathArgs> uriPath;

    /**
     * @return Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
     * 
     */
    public Optional<Output<WebAclRuleStatementXssMatchStatementFieldToMatchUriPathArgs>> uriPath() {
        return Optional.ofNullable(this.uriPath);
    }

    private WebAclRuleStatementXssMatchStatementFieldToMatchArgs() {}

    private WebAclRuleStatementXssMatchStatementFieldToMatchArgs(WebAclRuleStatementXssMatchStatementFieldToMatchArgs $) {
        this.allQueryArguments = $.allQueryArguments;
        this.body = $.body;
        this.cookies = $.cookies;
        this.headerOrders = $.headerOrders;
        this.headers = $.headers;
        this.ja3Fingerprint = $.ja3Fingerprint;
        this.ja4Fingerprint = $.ja4Fingerprint;
        this.jsonBody = $.jsonBody;
        this.method = $.method;
        this.queryString = $.queryString;
        this.singleHeader = $.singleHeader;
        this.singleQueryArgument = $.singleQueryArgument;
        this.uriFragment = $.uriFragment;
        this.uriPath = $.uriPath;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WebAclRuleStatementXssMatchStatementFieldToMatchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WebAclRuleStatementXssMatchStatementFieldToMatchArgs $;

        public Builder() {
            $ = new WebAclRuleStatementXssMatchStatementFieldToMatchArgs();
        }

        public Builder(WebAclRuleStatementXssMatchStatementFieldToMatchArgs defaults) {
            $ = new WebAclRuleStatementXssMatchStatementFieldToMatchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param allQueryArguments Inspect all query arguments.
         * 
         * @return builder
         * 
         */
        public Builder allQueryArguments(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchAllQueryArgumentsArgs> allQueryArguments) {
            $.allQueryArguments = allQueryArguments;
            return this;
        }

        /**
         * @param allQueryArguments Inspect all query arguments.
         * 
         * @return builder
         * 
         */
        public Builder allQueryArguments(WebAclRuleStatementXssMatchStatementFieldToMatchAllQueryArgumentsArgs allQueryArguments) {
            return allQueryArguments(Output.of(allQueryArguments));
        }

        /**
         * @param body Inspect the request body, which immediately follows the request headers. See `body` below for details.
         * 
         * @return builder
         * 
         */
        public Builder body(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchBodyArgs> body) {
            $.body = body;
            return this;
        }

        /**
         * @param body Inspect the request body, which immediately follows the request headers. See `body` below for details.
         * 
         * @return builder
         * 
         */
        public Builder body(WebAclRuleStatementXssMatchStatementFieldToMatchBodyArgs body) {
            return body(Output.of(body));
        }

        /**
         * @param cookies Inspect the cookies in the web request. See `cookies` below for details.
         * 
         * @return builder
         * 
         */
        public Builder cookies(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchCookiesArgs> cookies) {
            $.cookies = cookies;
            return this;
        }

        /**
         * @param cookies Inspect the cookies in the web request. See `cookies` below for details.
         * 
         * @return builder
         * 
         */
        public Builder cookies(WebAclRuleStatementXssMatchStatementFieldToMatchCookiesArgs cookies) {
            return cookies(Output.of(cookies));
        }

        /**
         * @param headerOrders Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
         * 
         * @return builder
         * 
         */
        public Builder headerOrders(@Nullable Output<List<WebAclRuleStatementXssMatchStatementFieldToMatchHeaderOrderArgs>> headerOrders) {
            $.headerOrders = headerOrders;
            return this;
        }

        /**
         * @param headerOrders Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
         * 
         * @return builder
         * 
         */
        public Builder headerOrders(List<WebAclRuleStatementXssMatchStatementFieldToMatchHeaderOrderArgs> headerOrders) {
            return headerOrders(Output.of(headerOrders));
        }

        /**
         * @param headerOrders Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
         * 
         * @return builder
         * 
         */
        public Builder headerOrders(WebAclRuleStatementXssMatchStatementFieldToMatchHeaderOrderArgs... headerOrders) {
            return headerOrders(List.of(headerOrders));
        }

        /**
         * @param headers Inspect the request headers. See `headers` below for details.
         * 
         * @return builder
         * 
         */
        public Builder headers(@Nullable Output<List<WebAclRuleStatementXssMatchStatementFieldToMatchHeaderArgs>> headers) {
            $.headers = headers;
            return this;
        }

        /**
         * @param headers Inspect the request headers. See `headers` below for details.
         * 
         * @return builder
         * 
         */
        public Builder headers(List<WebAclRuleStatementXssMatchStatementFieldToMatchHeaderArgs> headers) {
            return headers(Output.of(headers));
        }

        /**
         * @param headers Inspect the request headers. See `headers` below for details.
         * 
         * @return builder
         * 
         */
        public Builder headers(WebAclRuleStatementXssMatchStatementFieldToMatchHeaderArgs... headers) {
            return headers(List.of(headers));
        }

        /**
         * @param ja3Fingerprint Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
         * 
         * @return builder
         * 
         */
        public Builder ja3Fingerprint(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchJa3FingerprintArgs> ja3Fingerprint) {
            $.ja3Fingerprint = ja3Fingerprint;
            return this;
        }

        /**
         * @param ja3Fingerprint Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
         * 
         * @return builder
         * 
         */
        public Builder ja3Fingerprint(WebAclRuleStatementXssMatchStatementFieldToMatchJa3FingerprintArgs ja3Fingerprint) {
            return ja3Fingerprint(Output.of(ja3Fingerprint));
        }

        /**
         * @param ja4Fingerprint Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
         * 
         * @return builder
         * 
         */
        public Builder ja4Fingerprint(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchJa4FingerprintArgs> ja4Fingerprint) {
            $.ja4Fingerprint = ja4Fingerprint;
            return this;
        }

        /**
         * @param ja4Fingerprint Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
         * 
         * @return builder
         * 
         */
        public Builder ja4Fingerprint(WebAclRuleStatementXssMatchStatementFieldToMatchJa4FingerprintArgs ja4Fingerprint) {
            return ja4Fingerprint(Output.of(ja4Fingerprint));
        }

        /**
         * @param jsonBody Inspect the request body as JSON. See `json_body` for details.
         * 
         * @return builder
         * 
         */
        public Builder jsonBody(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchJsonBodyArgs> jsonBody) {
            $.jsonBody = jsonBody;
            return this;
        }

        /**
         * @param jsonBody Inspect the request body as JSON. See `json_body` for details.
         * 
         * @return builder
         * 
         */
        public Builder jsonBody(WebAclRuleStatementXssMatchStatementFieldToMatchJsonBodyArgs jsonBody) {
            return jsonBody(Output.of(jsonBody));
        }

        /**
         * @param method Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
         * 
         * @return builder
         * 
         */
        public Builder method(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchMethodArgs> method) {
            $.method = method;
            return this;
        }

        /**
         * @param method Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
         * 
         * @return builder
         * 
         */
        public Builder method(WebAclRuleStatementXssMatchStatementFieldToMatchMethodArgs method) {
            return method(Output.of(method));
        }

        /**
         * @param queryString Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
         * 
         * @return builder
         * 
         */
        public Builder queryString(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchQueryStringArgs> queryString) {
            $.queryString = queryString;
            return this;
        }

        /**
         * @param queryString Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
         * 
         * @return builder
         * 
         */
        public Builder queryString(WebAclRuleStatementXssMatchStatementFieldToMatchQueryStringArgs queryString) {
            return queryString(Output.of(queryString));
        }

        /**
         * @param singleHeader Inspect a single header. See `single_header` below for details.
         * 
         * @return builder
         * 
         */
        public Builder singleHeader(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchSingleHeaderArgs> singleHeader) {
            $.singleHeader = singleHeader;
            return this;
        }

        /**
         * @param singleHeader Inspect a single header. See `single_header` below for details.
         * 
         * @return builder
         * 
         */
        public Builder singleHeader(WebAclRuleStatementXssMatchStatementFieldToMatchSingleHeaderArgs singleHeader) {
            return singleHeader(Output.of(singleHeader));
        }

        /**
         * @param singleQueryArgument Inspect a single query argument. See `single_query_argument` below for details.
         * 
         * @return builder
         * 
         */
        public Builder singleQueryArgument(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchSingleQueryArgumentArgs> singleQueryArgument) {
            $.singleQueryArgument = singleQueryArgument;
            return this;
        }

        /**
         * @param singleQueryArgument Inspect a single query argument. See `single_query_argument` below for details.
         * 
         * @return builder
         * 
         */
        public Builder singleQueryArgument(WebAclRuleStatementXssMatchStatementFieldToMatchSingleQueryArgumentArgs singleQueryArgument) {
            return singleQueryArgument(Output.of(singleQueryArgument));
        }

        /**
         * @param uriFragment Inspect the part of a URL that follows the &#34;#&#34; symbol, providing additional information about the resource. See `uri_fragment` below for details.
         * 
         * @return builder
         * 
         */
        public Builder uriFragment(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchUriFragmentArgs> uriFragment) {
            $.uriFragment = uriFragment;
            return this;
        }

        /**
         * @param uriFragment Inspect the part of a URL that follows the &#34;#&#34; symbol, providing additional information about the resource. See `uri_fragment` below for details.
         * 
         * @return builder
         * 
         */
        public Builder uriFragment(WebAclRuleStatementXssMatchStatementFieldToMatchUriFragmentArgs uriFragment) {
            return uriFragment(Output.of(uriFragment));
        }

        /**
         * @param uriPath Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
         * 
         * @return builder
         * 
         */
        public Builder uriPath(@Nullable Output<WebAclRuleStatementXssMatchStatementFieldToMatchUriPathArgs> uriPath) {
            $.uriPath = uriPath;
            return this;
        }

        /**
         * @param uriPath Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
         * 
         * @return builder
         * 
         */
        public Builder uriPath(WebAclRuleStatementXssMatchStatementFieldToMatchUriPathArgs uriPath) {
            return uriPath(Output.of(uriPath));
        }

        public WebAclRuleStatementXssMatchStatementFieldToMatchArgs build() {
            return $;
        }
    }

}
