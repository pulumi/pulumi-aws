// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs Empty = new RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs();

    /**
     * The match status to assign to the web request if the request doesn&#39;t have a JA4 fingerprint. Valid values include: `MATCH` or `NO_MATCH`.
     * 
     */
    @Import(name="fallbackBehavior", required=true)
    private Output<String> fallbackBehavior;

    /**
     * @return The match status to assign to the web request if the request doesn&#39;t have a JA4 fingerprint. Valid values include: `MATCH` or `NO_MATCH`.
     * 
     */
    public Output<String> fallbackBehavior() {
        return this.fallbackBehavior;
    }

    private RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs() {}

    private RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs(RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs $) {
        this.fallbackBehavior = $.fallbackBehavior;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs $;

        public Builder() {
            $ = new RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs();
        }

        public Builder(RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs defaults) {
            $ = new RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param fallbackBehavior The match status to assign to the web request if the request doesn&#39;t have a JA4 fingerprint. Valid values include: `MATCH` or `NO_MATCH`.
         * 
         * @return builder
         * 
         */
        public Builder fallbackBehavior(Output<String> fallbackBehavior) {
            $.fallbackBehavior = fallbackBehavior;
            return this;
        }

        /**
         * @param fallbackBehavior The match status to assign to the web request if the request doesn&#39;t have a JA4 fingerprint. Valid values include: `MATCH` or `NO_MATCH`.
         * 
         * @return builder
         * 
         */
        public Builder fallbackBehavior(String fallbackBehavior) {
            return fallbackBehavior(Output.of(fallbackBehavior));
        }

        public RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs build() {
            if ($.fallbackBehavior == null) {
                throw new MissingRequiredPropertyException("RuleGroupRuleStatementRegexMatchStatementFieldToMatchJa4FingerprintArgs", "fallbackBehavior");
            }
            return $;
        }
    }

}
