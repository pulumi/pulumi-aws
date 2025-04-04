// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseResponseHeaderArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs extends com.pulumi.resources.ResourceArgs {

    public static final WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs Empty = new WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs();

    /**
     * References the response body that you want AWS WAF to return to the web request client. This must reference a `key` defined in a `custom_response_body` block of this resource.
     * 
     */
    @Import(name="customResponseBodyKey")
    private @Nullable Output<String> customResponseBodyKey;

    /**
     * @return References the response body that you want AWS WAF to return to the web request client. This must reference a `key` defined in a `custom_response_body` block of this resource.
     * 
     */
    public Optional<Output<String>> customResponseBodyKey() {
        return Optional.ofNullable(this.customResponseBodyKey);
    }

    /**
     * The HTTP status code to return to the client.
     * 
     */
    @Import(name="responseCode", required=true)
    private Output<Integer> responseCode;

    /**
     * @return The HTTP status code to return to the client.
     * 
     */
    public Output<Integer> responseCode() {
        return this.responseCode;
    }

    /**
     * The `response_header` blocks used to define the HTTP response headers added to the response. See `response_header` below for details.
     * 
     */
    @Import(name="responseHeaders")
    private @Nullable Output<List<WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseResponseHeaderArgs>> responseHeaders;

    /**
     * @return The `response_header` blocks used to define the HTTP response headers added to the response. See `response_header` below for details.
     * 
     */
    public Optional<Output<List<WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseResponseHeaderArgs>>> responseHeaders() {
        return Optional.ofNullable(this.responseHeaders);
    }

    private WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs() {}

    private WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs(WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs $) {
        this.customResponseBodyKey = $.customResponseBodyKey;
        this.responseCode = $.responseCode;
        this.responseHeaders = $.responseHeaders;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs $;

        public Builder() {
            $ = new WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs();
        }

        public Builder(WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs defaults) {
            $ = new WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param customResponseBodyKey References the response body that you want AWS WAF to return to the web request client. This must reference a `key` defined in a `custom_response_body` block of this resource.
         * 
         * @return builder
         * 
         */
        public Builder customResponseBodyKey(@Nullable Output<String> customResponseBodyKey) {
            $.customResponseBodyKey = customResponseBodyKey;
            return this;
        }

        /**
         * @param customResponseBodyKey References the response body that you want AWS WAF to return to the web request client. This must reference a `key` defined in a `custom_response_body` block of this resource.
         * 
         * @return builder
         * 
         */
        public Builder customResponseBodyKey(String customResponseBodyKey) {
            return customResponseBodyKey(Output.of(customResponseBodyKey));
        }

        /**
         * @param responseCode The HTTP status code to return to the client.
         * 
         * @return builder
         * 
         */
        public Builder responseCode(Output<Integer> responseCode) {
            $.responseCode = responseCode;
            return this;
        }

        /**
         * @param responseCode The HTTP status code to return to the client.
         * 
         * @return builder
         * 
         */
        public Builder responseCode(Integer responseCode) {
            return responseCode(Output.of(responseCode));
        }

        /**
         * @param responseHeaders The `response_header` blocks used to define the HTTP response headers added to the response. See `response_header` below for details.
         * 
         * @return builder
         * 
         */
        public Builder responseHeaders(@Nullable Output<List<WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseResponseHeaderArgs>> responseHeaders) {
            $.responseHeaders = responseHeaders;
            return this;
        }

        /**
         * @param responseHeaders The `response_header` blocks used to define the HTTP response headers added to the response. See `response_header` below for details.
         * 
         * @return builder
         * 
         */
        public Builder responseHeaders(List<WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseResponseHeaderArgs> responseHeaders) {
            return responseHeaders(Output.of(responseHeaders));
        }

        /**
         * @param responseHeaders The `response_header` blocks used to define the HTTP response headers added to the response. See `response_header` below for details.
         * 
         * @return builder
         * 
         */
        public Builder responseHeaders(WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseResponseHeaderArgs... responseHeaders) {
            return responseHeaders(List.of(responseHeaders));
        }

        public WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs build() {
            if ($.responseCode == null) {
                throw new MissingRequiredPropertyException("WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlockCustomResponseArgs", "responseCode");
            }
            return $;
        }
    }

}
