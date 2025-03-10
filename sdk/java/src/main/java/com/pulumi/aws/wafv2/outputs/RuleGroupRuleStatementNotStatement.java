// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.outputs;

import com.pulumi.aws.wafv2.outputs.RuleGroupRuleStatement;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class RuleGroupRuleStatementNotStatement {
    /**
     * @return The statements to combine.
     * 
     */
    private List<RuleGroupRuleStatement> statements;

    private RuleGroupRuleStatementNotStatement() {}
    /**
     * @return The statements to combine.
     * 
     */
    public List<RuleGroupRuleStatement> statements() {
        return this.statements;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RuleGroupRuleStatementNotStatement defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<RuleGroupRuleStatement> statements;
        public Builder() {}
        public Builder(RuleGroupRuleStatementNotStatement defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.statements = defaults.statements;
        }

        @CustomType.Setter
        public Builder statements(List<RuleGroupRuleStatement> statements) {
            if (statements == null) {
              throw new MissingRequiredPropertyException("RuleGroupRuleStatementNotStatement", "statements");
            }
            this.statements = statements;
            return this;
        }
        public Builder statements(RuleGroupRuleStatement... statements) {
            return statements(List.of(statements));
        }
        public RuleGroupRuleStatementNotStatement build() {
            final var _resultValue = new RuleGroupRuleStatementNotStatement();
            _resultValue.statements = statements;
            return _resultValue;
        }
    }
}
