// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs Empty = new RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs();

    /**
     * What AWS WAF should do if it fails to completely parse the JSON body. Valid values are `MATCH` (default) and `NO_MATCH`.
     * 
     */
    @Import(name="fallbackBehavior")
    private @Nullable Output<String> fallbackBehavior;

    /**
     * @return What AWS WAF should do if it fails to completely parse the JSON body. Valid values are `MATCH` (default) and `NO_MATCH`.
     * 
     */
    public Optional<Output<String>> fallbackBehavior() {
        return Optional.ofNullable(this.fallbackBehavior);
    }

    private RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs() {}

    private RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs(RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs $) {
        this.fallbackBehavior = $.fallbackBehavior;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs $;

        public Builder() {
            $ = new RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs();
        }

        public Builder(RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs defaults) {
            $ = new RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param fallbackBehavior What AWS WAF should do if it fails to completely parse the JSON body. Valid values are `MATCH` (default) and `NO_MATCH`.
         * 
         * @return builder
         * 
         */
        public Builder fallbackBehavior(@Nullable Output<String> fallbackBehavior) {
            $.fallbackBehavior = fallbackBehavior;
            return this;
        }

        /**
         * @param fallbackBehavior What AWS WAF should do if it fails to completely parse the JSON body. Valid values are `MATCH` (default) and `NO_MATCH`.
         * 
         * @return builder
         * 
         */
        public Builder fallbackBehavior(String fallbackBehavior) {
            return fallbackBehavior(Output.of(fallbackBehavior));
        }

        public RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementFieldToMatchUriFragmentArgs build() {
            return $;
        }
    }

}
