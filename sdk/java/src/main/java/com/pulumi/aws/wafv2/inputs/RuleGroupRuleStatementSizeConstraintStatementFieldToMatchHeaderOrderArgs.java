// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs Empty = new RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs();

    /**
     * Oversize handling tells AWS WAF what to do with a web request when the request component that the rule inspects is over the limits. Valid values include the following: `CONTINUE`, `MATCH`, `NO_MATCH`. See the AWS [documentation](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statement-oversize-handling.html) for more information.
     * 
     */
    @Import(name="oversizeHandling", required=true)
    private Output<String> oversizeHandling;

    /**
     * @return Oversize handling tells AWS WAF what to do with a web request when the request component that the rule inspects is over the limits. Valid values include the following: `CONTINUE`, `MATCH`, `NO_MATCH`. See the AWS [documentation](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statement-oversize-handling.html) for more information.
     * 
     */
    public Output<String> oversizeHandling() {
        return this.oversizeHandling;
    }

    private RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs() {}

    private RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs(RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs $) {
        this.oversizeHandling = $.oversizeHandling;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs $;

        public Builder() {
            $ = new RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs();
        }

        public Builder(RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs defaults) {
            $ = new RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param oversizeHandling Oversize handling tells AWS WAF what to do with a web request when the request component that the rule inspects is over the limits. Valid values include the following: `CONTINUE`, `MATCH`, `NO_MATCH`. See the AWS [documentation](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statement-oversize-handling.html) for more information.
         * 
         * @return builder
         * 
         */
        public Builder oversizeHandling(Output<String> oversizeHandling) {
            $.oversizeHandling = oversizeHandling;
            return this;
        }

        /**
         * @param oversizeHandling Oversize handling tells AWS WAF what to do with a web request when the request component that the rule inspects is over the limits. Valid values include the following: `CONTINUE`, `MATCH`, `NO_MATCH`. See the AWS [documentation](https://docs.aws.amazon.com/waf/latest/developerguide/waf-rule-statement-oversize-handling.html) for more information.
         * 
         * @return builder
         * 
         */
        public Builder oversizeHandling(String oversizeHandling) {
            return oversizeHandling(Output.of(oversizeHandling));
        }

        public RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs build() {
            if ($.oversizeHandling == null) {
                throw new MissingRequiredPropertyException("RuleGroupRuleStatementSizeConstraintStatementFieldToMatchHeaderOrderArgs", "oversizeHandling");
            }
            return $;
        }
    }

}
