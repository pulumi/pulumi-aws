// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.inputs;

import com.pulumi.aws.wafv2.inputs.RuleGroupRuleStatementArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;


public final class RuleGroupRuleStatementAndStatementArgs extends com.pulumi.resources.ResourceArgs {

    public static final RuleGroupRuleStatementAndStatementArgs Empty = new RuleGroupRuleStatementAndStatementArgs();

    /**
     * The statements to combine.
     * 
     */
    @Import(name="statements", required=true)
    private Output<List<RuleGroupRuleStatementArgs>> statements;

    /**
     * @return The statements to combine.
     * 
     */
    public Output<List<RuleGroupRuleStatementArgs>> statements() {
        return this.statements;
    }

    private RuleGroupRuleStatementAndStatementArgs() {}

    private RuleGroupRuleStatementAndStatementArgs(RuleGroupRuleStatementAndStatementArgs $) {
        this.statements = $.statements;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RuleGroupRuleStatementAndStatementArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RuleGroupRuleStatementAndStatementArgs $;

        public Builder() {
            $ = new RuleGroupRuleStatementAndStatementArgs();
        }

        public Builder(RuleGroupRuleStatementAndStatementArgs defaults) {
            $ = new RuleGroupRuleStatementAndStatementArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param statements The statements to combine.
         * 
         * @return builder
         * 
         */
        public Builder statements(Output<List<RuleGroupRuleStatementArgs>> statements) {
            $.statements = statements;
            return this;
        }

        /**
         * @param statements The statements to combine.
         * 
         * @return builder
         * 
         */
        public Builder statements(List<RuleGroupRuleStatementArgs> statements) {
            return statements(Output.of(statements));
        }

        /**
         * @param statements The statements to combine.
         * 
         * @return builder
         * 
         */
        public Builder statements(RuleGroupRuleStatementArgs... statements) {
            return statements(List.of(statements));
        }

        public RuleGroupRuleStatementAndStatementArgs build() {
            if ($.statements == null) {
                throw new MissingRequiredPropertyException("RuleGroupRuleStatementAndStatementArgs", "statements");
            }
            return $;
        }
    }

}
