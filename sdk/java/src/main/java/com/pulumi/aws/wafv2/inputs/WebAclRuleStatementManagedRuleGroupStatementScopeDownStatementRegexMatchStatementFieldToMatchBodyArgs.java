// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs extends com.pulumi.resources.ResourceArgs {

    public static final WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs Empty = new WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs();

    /**
     * What WAF should do if the body is larger than WAF can inspect. WAF does not support inspecting the entire contents of the body of a web request when the body exceeds 8 KB (8192 bytes). Only the first 8 KB of the request body are forwarded to WAF by the underlying host service. Valid values: `CONTINUE`, `MATCH`, `NO_MATCH`.
     * 
     */
    @Import(name="oversizeHandling")
    private @Nullable Output<String> oversizeHandling;

    /**
     * @return What WAF should do if the body is larger than WAF can inspect. WAF does not support inspecting the entire contents of the body of a web request when the body exceeds 8 KB (8192 bytes). Only the first 8 KB of the request body are forwarded to WAF by the underlying host service. Valid values: `CONTINUE`, `MATCH`, `NO_MATCH`.
     * 
     */
    public Optional<Output<String>> oversizeHandling() {
        return Optional.ofNullable(this.oversizeHandling);
    }

    private WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs() {}

    private WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs(WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs $) {
        this.oversizeHandling = $.oversizeHandling;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs $;

        public Builder() {
            $ = new WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs();
        }

        public Builder(WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs defaults) {
            $ = new WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param oversizeHandling What WAF should do if the body is larger than WAF can inspect. WAF does not support inspecting the entire contents of the body of a web request when the body exceeds 8 KB (8192 bytes). Only the first 8 KB of the request body are forwarded to WAF by the underlying host service. Valid values: `CONTINUE`, `MATCH`, `NO_MATCH`.
         * 
         * @return builder
         * 
         */
        public Builder oversizeHandling(@Nullable Output<String> oversizeHandling) {
            $.oversizeHandling = oversizeHandling;
            return this;
        }

        /**
         * @param oversizeHandling What WAF should do if the body is larger than WAF can inspect. WAF does not support inspecting the entire contents of the body of a web request when the body exceeds 8 KB (8192 bytes). Only the first 8 KB of the request body are forwarded to WAF by the underlying host service. Valid values: `CONTINUE`, `MATCH`, `NO_MATCH`.
         * 
         * @return builder
         * 
         */
        public Builder oversizeHandling(String oversizeHandling) {
            return oversizeHandling(Output.of(oversizeHandling));
        }

        public WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementRegexMatchStatementFieldToMatchBodyArgs build() {
            return $;
        }
    }

}
