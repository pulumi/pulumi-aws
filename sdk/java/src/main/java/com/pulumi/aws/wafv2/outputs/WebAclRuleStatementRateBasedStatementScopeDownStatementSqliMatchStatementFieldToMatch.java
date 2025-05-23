// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.outputs;

import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchAllQueryArguments;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchBody;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchCookies;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeader;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeaderOrder;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa3Fingerprint;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa4Fingerprint;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJsonBody;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchMethod;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchQueryString;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleHeader;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleQueryArgument;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriFragment;
import com.pulumi.aws.wafv2.outputs.WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriPath;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatch {
    /**
     * @return Inspect all query arguments.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchAllQueryArguments allQueryArguments;
    /**
     * @return Inspect the request body, which immediately follows the request headers. See `body` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchBody body;
    /**
     * @return Inspect the cookies in the web request. See `cookies` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchCookies cookies;
    /**
     * @return Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
     * 
     */
    private @Nullable List<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeaderOrder> headerOrders;
    /**
     * @return Inspect the request headers. See `headers` below for details.
     * 
     */
    private @Nullable List<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeader> headers;
    /**
     * @return Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa3Fingerprint ja3Fingerprint;
    /**
     * @return Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa4Fingerprint ja4Fingerprint;
    /**
     * @return Inspect the request body as JSON. See `json_body` for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJsonBody jsonBody;
    /**
     * @return Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchMethod method;
    /**
     * @return Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchQueryString queryString;
    /**
     * @return Inspect a single header. See `single_header` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleHeader singleHeader;
    /**
     * @return Inspect a single query argument. See `single_query_argument` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleQueryArgument singleQueryArgument;
    /**
     * @return Inspect the part of a URL that follows the &#34;#&#34; symbol, providing additional information about the resource. See `uri_fragment` below for details.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriFragment uriFragment;
    /**
     * @return Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
     * 
     */
    private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriPath uriPath;

    private WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatch() {}
    /**
     * @return Inspect all query arguments.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchAllQueryArguments> allQueryArguments() {
        return Optional.ofNullable(this.allQueryArguments);
    }
    /**
     * @return Inspect the request body, which immediately follows the request headers. See `body` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchBody> body() {
        return Optional.ofNullable(this.body);
    }
    /**
     * @return Inspect the cookies in the web request. See `cookies` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchCookies> cookies() {
        return Optional.ofNullable(this.cookies);
    }
    /**
     * @return Inspect a string containing the list of the request&#39;s header names, ordered as they appear in the web request that AWS WAF receives for inspection. See `header_order` below for details.
     * 
     */
    public List<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeaderOrder> headerOrders() {
        return this.headerOrders == null ? List.of() : this.headerOrders;
    }
    /**
     * @return Inspect the request headers. See `headers` below for details.
     * 
     */
    public List<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeader> headers() {
        return this.headers == null ? List.of() : this.headers;
    }
    /**
     * @return Inspect the JA3 fingerprint. See `ja3_fingerprint` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa3Fingerprint> ja3Fingerprint() {
        return Optional.ofNullable(this.ja3Fingerprint);
    }
    /**
     * @return Inspect the JA3 fingerprint. See `ja4_fingerprint` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa4Fingerprint> ja4Fingerprint() {
        return Optional.ofNullable(this.ja4Fingerprint);
    }
    /**
     * @return Inspect the request body as JSON. See `json_body` for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJsonBody> jsonBody() {
        return Optional.ofNullable(this.jsonBody);
    }
    /**
     * @return Inspect the HTTP method. The method indicates the type of operation that the request is asking the origin to perform.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchMethod> method() {
        return Optional.ofNullable(this.method);
    }
    /**
     * @return Inspect the query string. This is the part of a URL that appears after a `?` character, if any.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchQueryString> queryString() {
        return Optional.ofNullable(this.queryString);
    }
    /**
     * @return Inspect a single header. See `single_header` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleHeader> singleHeader() {
        return Optional.ofNullable(this.singleHeader);
    }
    /**
     * @return Inspect a single query argument. See `single_query_argument` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleQueryArgument> singleQueryArgument() {
        return Optional.ofNullable(this.singleQueryArgument);
    }
    /**
     * @return Inspect the part of a URL that follows the &#34;#&#34; symbol, providing additional information about the resource. See `uri_fragment` below for details.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriFragment> uriFragment() {
        return Optional.ofNullable(this.uriFragment);
    }
    /**
     * @return Inspect the request URI path. This is the part of a web request that identifies a resource, for example, `/images/daily-ad.jpg`.
     * 
     */
    public Optional<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriPath> uriPath() {
        return Optional.ofNullable(this.uriPath);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchAllQueryArguments allQueryArguments;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchBody body;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchCookies cookies;
        private @Nullable List<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeaderOrder> headerOrders;
        private @Nullable List<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeader> headers;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa3Fingerprint ja3Fingerprint;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa4Fingerprint ja4Fingerprint;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJsonBody jsonBody;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchMethod method;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchQueryString queryString;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleHeader singleHeader;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleQueryArgument singleQueryArgument;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriFragment uriFragment;
        private @Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriPath uriPath;
        public Builder() {}
        public Builder(WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatch defaults) {
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
        public Builder allQueryArguments(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchAllQueryArguments allQueryArguments) {

            this.allQueryArguments = allQueryArguments;
            return this;
        }
        @CustomType.Setter
        public Builder body(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchBody body) {

            this.body = body;
            return this;
        }
        @CustomType.Setter
        public Builder cookies(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchCookies cookies) {

            this.cookies = cookies;
            return this;
        }
        @CustomType.Setter
        public Builder headerOrders(@Nullable List<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeaderOrder> headerOrders) {

            this.headerOrders = headerOrders;
            return this;
        }
        public Builder headerOrders(WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeaderOrder... headerOrders) {
            return headerOrders(List.of(headerOrders));
        }
        @CustomType.Setter
        public Builder headers(@Nullable List<WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeader> headers) {

            this.headers = headers;
            return this;
        }
        public Builder headers(WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchHeader... headers) {
            return headers(List.of(headers));
        }
        @CustomType.Setter
        public Builder ja3Fingerprint(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa3Fingerprint ja3Fingerprint) {

            this.ja3Fingerprint = ja3Fingerprint;
            return this;
        }
        @CustomType.Setter
        public Builder ja4Fingerprint(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJa4Fingerprint ja4Fingerprint) {

            this.ja4Fingerprint = ja4Fingerprint;
            return this;
        }
        @CustomType.Setter
        public Builder jsonBody(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchJsonBody jsonBody) {

            this.jsonBody = jsonBody;
            return this;
        }
        @CustomType.Setter
        public Builder method(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchMethod method) {

            this.method = method;
            return this;
        }
        @CustomType.Setter
        public Builder queryString(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchQueryString queryString) {

            this.queryString = queryString;
            return this;
        }
        @CustomType.Setter
        public Builder singleHeader(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleHeader singleHeader) {

            this.singleHeader = singleHeader;
            return this;
        }
        @CustomType.Setter
        public Builder singleQueryArgument(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchSingleQueryArgument singleQueryArgument) {

            this.singleQueryArgument = singleQueryArgument;
            return this;
        }
        @CustomType.Setter
        public Builder uriFragment(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriFragment uriFragment) {

            this.uriFragment = uriFragment;
            return this;
        }
        @CustomType.Setter
        public Builder uriPath(@Nullable WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchUriPath uriPath) {

            this.uriPath = uriPath;
            return this;
        }
        public WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatch build() {
            final var _resultValue = new WebAclRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatch();
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
