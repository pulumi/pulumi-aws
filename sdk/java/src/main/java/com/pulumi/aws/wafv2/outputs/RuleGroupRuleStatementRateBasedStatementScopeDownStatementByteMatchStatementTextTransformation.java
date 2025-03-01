// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafv2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementTextTransformation {
    /**
     * @return The relative processing order for multiple transformations that are defined for a rule statement. AWS WAF processes all transformations, from lowest priority to highest, before inspecting the transformed content.
     * 
     */
    private Integer priority;
    /**
     * @return The transformation to apply, please refer to the Text Transformation [documentation](https://docs.aws.amazon.com/waf/latest/APIReference/API_TextTransformation.html) for more details.
     * 
     */
    private String type;

    private RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementTextTransformation() {}
    /**
     * @return The relative processing order for multiple transformations that are defined for a rule statement. AWS WAF processes all transformations, from lowest priority to highest, before inspecting the transformed content.
     * 
     */
    public Integer priority() {
        return this.priority;
    }
    /**
     * @return The transformation to apply, please refer to the Text Transformation [documentation](https://docs.aws.amazon.com/waf/latest/APIReference/API_TextTransformation.html) for more details.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementTextTransformation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer priority;
        private String type;
        public Builder() {}
        public Builder(RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementTextTransformation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.priority = defaults.priority;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder priority(Integer priority) {
            if (priority == null) {
              throw new MissingRequiredPropertyException("RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementTextTransformation", "priority");
            }
            this.priority = priority;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementTextTransformation", "type");
            }
            this.type = type;
            return this;
        }
        public RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementTextTransformation build() {
            final var _resultValue = new RuleGroupRuleStatementRateBasedStatementScopeDownStatementByteMatchStatementTextTransformation();
            _resultValue.priority = priority;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
