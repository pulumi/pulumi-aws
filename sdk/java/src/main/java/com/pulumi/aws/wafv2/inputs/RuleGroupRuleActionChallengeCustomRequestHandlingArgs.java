// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.RuleGroupRuleActionChallengeCustomRequestHandlingInsertHeaderArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;


public final class RuleGroupRuleActionChallengeCustomRequestHandlingArgs extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupRuleActionChallengeCustomRequestHandlingArgs Empty = new RuleGroupRuleActionChallengeCustomRequestHandlingArgs();

    /**
     * The `insert_header` blocks used to define HTTP headers added to the request. See Custom HTTP Header below for details.
     * 
     */
    @Import(name="insertHeaders", required=true)
    private Output<List<RuleGroupRuleActionChallengeCustomRequestHandlingInsertHeaderArgs>> insertHeaders;

    /**
     * @return The `insert_header` blocks used to define HTTP headers added to the request. See Custom HTTP Header below for details.
     * 
     */
    public Output<List<RuleGroupRuleActionChallengeCustomRequestHandlingInsertHeaderArgs>> insertHeaders() {
        return this.insertHeaders;
    }

    private RuleGroupRuleActionChallengeCustomRequestHandlingArgs() {}

    private RuleGroupRuleActionChallengeCustomRequestHandlingArgs(RuleGroupRuleActionChallengeCustomRequestHandlingArgs $) {
        this.insertHeaders = $.insertHeaders;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupRuleActionChallengeCustomRequestHandlingArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupRuleActionChallengeCustomRequestHandlingArgs $;

        public Builder() {
            $ = new RuleGroupRuleActionChallengeCustomRequestHandlingArgs();
        }

        public Builder(RuleGroupRuleActionChallengeCustomRequestHandlingArgs defaults) {
            $ = new RuleGroupRuleActionChallengeCustomRequestHandlingArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param insertHeaders The `insert_header` blocks used to define HTTP headers added to the request. See Custom HTTP Header below for details.
         * 
         * @return builder
         * 
         */
        public Builder insertHeaders(Output<List<RuleGroupRuleActionChallengeCustomRequestHandlingInsertHeaderArgs>> insertHeaders) {
            $.insertHeaders = insertHeaders;
            return this;
        }

        /**
         * @param insertHeaders The `insert_header` blocks used to define HTTP headers added to the request. See Custom HTTP Header below for details.
         * 
         * @return builder
         * 
         */
        public Builder insertHeaders(List<RuleGroupRuleActionChallengeCustomRequestHandlingInsertHeaderArgs> insertHeaders) {
            return insertHeaders(Output.of(insertHeaders));
        }

        /**
         * @param insertHeaders The `insert_header` blocks used to define HTTP headers added to the request. See Custom HTTP Header below for details.
         * 
         * @return builder
         * 
         */
        public Builder insertHeaders(RuleGroupRuleActionChallengeCustomRequestHandlingInsertHeaderArgs... insertHeaders) {
            return insertHeaders(List.of(insertHeaders));
        }

        public RuleGroupRuleActionChallengeCustomRequestHandlingArgs build() {
            $.insertHeaders = Objects.requireNonNull($.insertHeaders, "expected parameter 'insertHeaders' to be non-null");
            return $;
        }
    }

}