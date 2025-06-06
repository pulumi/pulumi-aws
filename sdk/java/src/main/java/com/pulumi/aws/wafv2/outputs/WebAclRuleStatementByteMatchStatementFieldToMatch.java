// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.outputs;

import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchAllQueryArguments;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchBody;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchCookies;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchHeader;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchHeaderOrder;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchJa3Fingerprint;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchJa4Fingerprint;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchJsonBody;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchMethod;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchQueryString;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchSingleHeader;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchSingleQueryArgument;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchUriFragment;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementByteMatchStatementFieldToMatchUriPath;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class WebAclRuleStatementByteMatchStatementFieldToMatch {
    /**
     * @return Inspect all query arguments.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchAllQueryArguments allQueryArguments;
    /**
     * @return Inspect the request body, which immediately follows the request headers. See `body` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchBody body;
    /**
     * @return Inspect the cookies in the web request. See `cookies` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchCookies cookies;
    /**
     * @return Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
     * 
     */
    private @Nullable List<WebAclRuleStatementByteMatchStatementFieldToMatchHeaderOrder> headerOrders;
    /**
     * @return Inspect the request headers. See `headers` below for details.
     * 
     */
    private @Nullable List<WebAclRuleStatementByteMatchStatementFieldToMatchHeader> headers;
    /**
     * @return Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJa3Fingerprint ja3Fingerprint;
    /**
     * @return Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJa4Fingerprint ja4Fingerprint;
    /**
     * @return Inspect the request body as JSON. See `json_body` for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJsonBody jsonBody;
    /**
     * @return Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchMethod method;
    /**
     * @return Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchQueryString queryString;
    /**
     * @return Inspect a single header. See `single_header` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchSingleHeader singleHeader;
    /**
     * @return Inspect a single query argument. See `single_query_argument` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchSingleQueryArgument singleQueryArgument;
    /**
     * @return Inspect the part of a URL that follows the &#34;#&#34; symbol, providing additional information about the resource. See `uri_fragment` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchUriFragment uriFragment;
    /**
     * @return Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
     * 
     */
    private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchUriPath uriPath;

    private WebAclRuleStatementByteMatchStatementFieldToMatch() {}
    /**
     * @return Inspect all query arguments.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchAllQueryArguments> allQueryArguments() {
        return Optional.ofNullable(this.allQueryArguments);
    }
    /**
     * @return Inspect the request body, which immediately follows the request headers. See `body` below for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchBody> body() {
        return Optional.ofNullable(this.body);
    }
    /**
     * @return Inspect the cookies in the web request. See `cookies` below for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchCookies> cookies() {
        return Optional.ofNullable(this.cookies);
    }
    /**
     * @return Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
     * 
     */
    public List<WebAclRuleStatementByteMatchStatementFieldToMatchHeaderOrder> headerOrders() {
        return this.headerOrders == null ? List.of() : this.headerOrders;
    }
    /**
     * @return Inspect the request headers. See `headers` below for details.
     * 
     */
    public List<WebAclRuleStatementByteMatchStatementFieldToMatchHeader> headers() {
        return this.headers == null ? List.of() : this.headers;
    }
    /**
     * @return Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchJa3Fingerprint> ja3Fingerprint() {
        return Optional.ofNullable(this.ja3Fingerprint);
    }
    /**
     * @return Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchJa4Fingerprint> ja4Fingerprint() {
        return Optional.ofNullable(this.ja4Fingerprint);
    }
    /**
     * @return Inspect the request body as JSON. See `json_body` for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchJsonBody> jsonBody() {
        return Optional.ofNullable(this.jsonBody);
    }
    /**
     * @return Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchMethod> method() {
        return Optional.ofNullable(this.method);
    }
    /**
     * @return Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchQueryString> queryString() {
        return Optional.ofNullable(this.queryString);
    }
    /**
     * @return Inspect a single header. See `single_header` below for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchSingleHeader> singleHeader() {
        return Optional.ofNullable(this.singleHeader);
    }
    /**
     * @return Inspect a single query argument. See `single_query_argument` below for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchSingleQueryArgument> singleQueryArgument() {
        return Optional.ofNullable(this.singleQueryArgument);
    }
    /**
     * @return Inspect the part of a URL that follows the &#34;#&#34; symbol, providing additional information about the resource. See `uri_fragment` below for details.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchUriFragment> uriFragment() {
        return Optional.ofNullable(this.uriFragment);
    }
    /**
     * @return Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
     * 
     */
    public Optional<WebAclRuleStatementByteMatchStatementFieldToMatchUriPath> uriPath() {
        return Optional.ofNullable(this.uriPath);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WebAclRuleStatementByteMatchStatementFieldToMatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchAllQueryArguments allQueryArguments;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchBody body;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchCookies cookies;
        private @Nullable List<WebAclRuleStatementByteMatchStatementFieldToMatchHeaderOrder> headerOrders;
        private @Nullable List<WebAclRuleStatementByteMatchStatementFieldToMatchHeader> headers;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJa3Fingerprint ja3Fingerprint;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJa4Fingerprint ja4Fingerprint;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJsonBody jsonBody;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchMethod method;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchQueryString queryString;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchSingleHeader singleHeader;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchSingleQueryArgument singleQueryArgument;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchUriFragment uriFragment;
        private @Nullable WebAclRuleStatementByteMatchStatementFieldToMatchUriPath uriPath;
        public Builder() {}
        public Builder(WebAclRuleStatementByteMatchStatementFieldToMatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.allQueryArguments = defaults.allQueryArguments;
    	      this.body = defaults.body;
    	      this.cookies = defaults.cookies;
    	      this.headerOrders = defaults.headerOrders;
    	      this.headers = defaults.headers;
    	      this.ja3Fingerprint = defaults.ja3Fingerprint;
    	      this.ja4Fingerprint = defaults.ja4Fingerprint;
    	      this.jsonBody = defaults.jsonBody;
    	      this.method = defaults.method;
    	      this.queryString = defaults.queryString;
    	      this.singleHeader = defaults.singleHeader;
    	      this.singleQueryArgument = defaults.singleQueryArgument;
    	      this.uriFragment = defaults.uriFragment;
    	      this.uriPath = defaults.uriPath;
        }

        @CustomType.Setter
        public Builder allQueryArguments(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchAllQueryArguments allQueryArguments) {

            this.allQueryArguments = allQueryArguments;
            return this;
        }
        @CustomType.Setter
        public Builder body(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchBody body) {

            this.body = body;
            return this;
        }
        @CustomType.Setter
        public Builder cookies(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchCookies cookies) {

            this.cookies = cookies;
            return this;
        }
        @CustomType.Setter
        public Builder headerOrders(@Nullable List<WebAclRuleStatementByteMatchStatementFieldToMatchHeaderOrder> headerOrders) {

            this.headerOrders = headerOrders;
            return this;
        }
        public Builder headerOrders(WebAclRuleStatementByteMatchStatementFieldToMatchHeaderOrder... headerOrders) {
            return headerOrders(List.of(headerOrders));
        }
        @CustomType.Setter
        public Builder headers(@Nullable List<WebAclRuleStatementByteMatchStatementFieldToMatchHeader> headers) {

            this.headers = headers;
            return this;
        }
        public Builder headers(WebAclRuleStatementByteMatchStatementFieldToMatchHeader... headers) {
            return headers(List.of(headers));
        }
        @CustomType.Setter
        public Builder ja3Fingerprint(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJa3Fingerprint ja3Fingerprint) {

            this.ja3Fingerprint = ja3Fingerprint;
            return this;
        }
        @CustomType.Setter
        public Builder ja4Fingerprint(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJa4Fingerprint ja4Fingerprint) {

            this.ja4Fingerprint = ja4Fingerprint;
            return this;
        }
        @CustomType.Setter
        public Builder jsonBody(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchJsonBody jsonBody) {

            this.jsonBody = jsonBody;
            return this;
        }
        @CustomType.Setter
        public Builder method(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchMethod method) {

            this.method = method;
            return this;
        }
        @CustomType.Setter
        public Builder queryString(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchQueryString queryString) {

            this.queryString = queryString;
            return this;
        }
        @CustomType.Setter
        public Builder singleHeader(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchSingleHeader singleHeader) {

            this.singleHeader = singleHeader;
            return this;
        }
        @CustomType.Setter
        public Builder singleQueryArgument(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchSingleQueryArgument singleQueryArgument) {

            this.singleQueryArgument = singleQueryArgument;
            return this;
        }
        @CustomType.Setter
        public Builder uriFragment(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchUriFragment uriFragment) {

            this.uriFragment = uriFragment;
            return this;
        }
        @CustomType.Setter
        public Builder uriPath(@Nullable WebAclRuleStatementByteMatchStatementFieldToMatchUriPath uriPath) {

            this.uriPath = uriPath;
            return this;
        }
        public WebAclRuleStatementByteMatchStatementFieldToMatch build() {
            final var _resultValue = new WebAclRuleStatementByteMatchStatementFieldToMatch();
            _resultValue.allQueryArguments = allQueryArguments;
            _resultValue.body = body;
            _resultValue.cookies = cookies;
            _resultValue.headerOrders = headerOrders;
            _resultValue.headers = headers;
            _resultValue.ja3Fingerprint = ja3Fingerprint;
            _resultValue.ja4Fingerprint = ja4Fingerprint;
            _resultValue.jsonBody = jsonBody;
            _resultValue.method = method;
            _resultValue.queryString = queryString;
            _resultValue.singleHeader = singleHeader;
            _resultValue.singleQueryArgument = singleQueryArgument;
            _resultValue.uriFragment = uriFragment;
            _resultValue.uriPath = uriPath;
            return _resultValue;
        }
    }
}
