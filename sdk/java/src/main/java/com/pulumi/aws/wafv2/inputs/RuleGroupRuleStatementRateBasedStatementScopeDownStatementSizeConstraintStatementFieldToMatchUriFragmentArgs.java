// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs Empty = new RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs();

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

    private RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs() {}

    private RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs(RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs $) {
        this.fallbackBehavior = $.fallbackBehavior;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs $;

        public Builder() {
            $ = new RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs();
        }

        public Builder(RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs defaults) {
            $ = new RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs(Objects.requireNonNull(defaults));
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

        public RuleGroupRuleStatementRateBasedStatementScopeDownStatementSizeConstraintStatementFieldToMatchUriFragmentArgs build() {
            return $;
        }
    }

}
