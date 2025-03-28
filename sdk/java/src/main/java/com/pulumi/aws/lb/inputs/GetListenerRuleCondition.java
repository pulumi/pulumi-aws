// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lb.inputs;

import com.pulumi.aws.lb.inputs.GetListenerRuleConditionHostHeader;
import com.pulumi.aws.lb.inputs.GetListenerRuleConditionHttpHeader;
import com.pulumi.aws.lb.inputs.GetListenerRuleConditionHttpRequestMethod;
import com.pulumi.aws.lb.inputs.GetListenerRuleConditionPathPattern;
import com.pulumi.aws.lb.inputs.GetListenerRuleConditionQueryString;
import com.pulumi.aws.lb.inputs.GetListenerRuleConditionSourceIp;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetListenerRuleCondition extends com.pulumi.resources.InvokeArgs {

    public static final GetListenerRuleCondition Empty = new GetListenerRuleCondition();

    /**
     * Contains a single attribute `values`, which contains a set of host names.
     * 
     */
    @Import(name="hostHeader")
    private @Nullable GetListenerRuleConditionHostHeader hostHeader;

    /**
     * @return Contains a single attribute `values`, which contains a set of host names.
     * 
     */
    public Optional<GetListenerRuleConditionHostHeader> hostHeader() {
        return Optional.ofNullable(this.hostHeader);
    }

    /**
     * HTTP header and values to match.
     * Detailed below.
     * 
     */
    @Import(name="httpHeader")
    private @Nullable GetListenerRuleConditionHttpHeader httpHeader;

    /**
     * @return HTTP header and values to match.
     * Detailed below.
     * 
     */
    public Optional<GetListenerRuleConditionHttpHeader> httpHeader() {
        return Optional.ofNullable(this.httpHeader);
    }

    /**
     * Contains a single attribute `values`, which contains a set of HTTP request methods.
     * 
     */
    @Import(name="httpRequestMethod")
    private @Nullable GetListenerRuleConditionHttpRequestMethod httpRequestMethod;

    /**
     * @return Contains a single attribute `values`, which contains a set of HTTP request methods.
     * 
     */
    public Optional<GetListenerRuleConditionHttpRequestMethod> httpRequestMethod() {
        return Optional.ofNullable(this.httpRequestMethod);
    }

    /**
     * Contains a single attribute `values`, which contains a set of path patterns to compare against the request URL.
     * 
     */
    @Import(name="pathPattern")
    private @Nullable GetListenerRuleConditionPathPattern pathPattern;

    /**
     * @return Contains a single attribute `values`, which contains a set of path patterns to compare against the request URL.
     * 
     */
    public Optional<GetListenerRuleConditionPathPattern> pathPattern() {
        return Optional.ofNullable(this.pathPattern);
    }

    /**
     * Query string parameters to match.
     * Detailed below.
     * 
     */
    @Import(name="queryString")
    private @Nullable GetListenerRuleConditionQueryString queryString;

    /**
     * @return Query string parameters to match.
     * Detailed below.
     * 
     */
    public Optional<GetListenerRuleConditionQueryString> queryString() {
        return Optional.ofNullable(this.queryString);
    }

    /**
     * Contains a single attribute `values`, which contains a set of source IPs in CIDR notation.
     * 
     */
    @Import(name="sourceIp")
    private @Nullable GetListenerRuleConditionSourceIp sourceIp;

    /**
     * @return Contains a single attribute `values`, which contains a set of source IPs in CIDR notation.
     * 
     */
    public Optional<GetListenerRuleConditionSourceIp> sourceIp() {
        return Optional.ofNullable(this.sourceIp);
    }

    private GetListenerRuleCondition() {}

    private GetListenerRuleCondition(GetListenerRuleCondition $) {
        this.hostHeader = $.hostHeader;
        this.httpHeader = $.httpHeader;
        this.httpRequestMethod = $.httpRequestMethod;
        this.pathPattern = $.pathPattern;
        this.queryString = $.queryString;
        this.sourceIp = $.sourceIp;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetListenerRuleCondition defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetListenerRuleCondition $;

        public Builder() {
            $ = new GetListenerRuleCondition();
        }

        public Builder(GetListenerRuleCondition defaults) {
            $ = new GetListenerRuleCondition(Objects.requireNonNull(defaults));
        }

        /**
         * @param hostHeader Contains a single attribute `values`, which contains a set of host names.
         * 
         * @return builder
         * 
         */
        public Builder hostHeader(@Nullable GetListenerRuleConditionHostHeader hostHeader) {
            $.hostHeader = hostHeader;
            return this;
        }

        /**
         * @param httpHeader HTTP header and values to match.
         * Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder httpHeader(@Nullable GetListenerRuleConditionHttpHeader httpHeader) {
            $.httpHeader = httpHeader;
            return this;
        }

        /**
         * @param httpRequestMethod Contains a single attribute `values`, which contains a set of HTTP request methods.
         * 
         * @return builder
         * 
         */
        public Builder httpRequestMethod(@Nullable GetListenerRuleConditionHttpRequestMethod httpRequestMethod) {
            $.httpRequestMethod = httpRequestMethod;
            return this;
        }

        /**
         * @param pathPattern Contains a single attribute `values`, which contains a set of path patterns to compare against the request URL.
         * 
         * @return builder
         * 
         */
        public Builder pathPattern(@Nullable GetListenerRuleConditionPathPattern pathPattern) {
            $.pathPattern = pathPattern;
            return this;
        }

        /**
         * @param queryString Query string parameters to match.
         * Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder queryString(@Nullable GetListenerRuleConditionQueryString queryString) {
            $.queryString = queryString;
            return this;
        }

        /**
         * @param sourceIp Contains a single attribute `values`, which contains a set of source IPs in CIDR notation.
         * 
         * @return builder
         * 
         */
        public Builder sourceIp(@Nullable GetListenerRuleConditionSourceIp sourceIp) {
            $.sourceIp = sourceIp;
            return this;
        }

        public GetListenerRuleCondition build() {
            return $;
        }
    }

}
