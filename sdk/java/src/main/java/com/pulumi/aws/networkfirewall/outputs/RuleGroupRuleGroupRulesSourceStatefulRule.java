// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.aws.networkfirewall.outputs.RuleGroupRuleGroupRulesSourceStatefulRuleHeader;
import com.pulumi.aws.networkfirewall.outputs.RuleGroupRuleGroupRulesSourceStatefulRuleRuleOption;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class RuleGroupRuleGroupRulesSourceStatefulRule {
    /**
     * @return Action to take with packets in a traffic flow when the flow matches the stateful rule criteria. For all actions, AWS Network Firewall performs the specified action and discontinues stateful inspection of the traffic flow. Valid values: `ALERT`, `DROP`, `PASS`, or `REJECT`.
     * 
     */
    private String action;
    /**
     * @return A configuration block containing the stateful 5-tuple inspection criteria for the rule, used to inspect traffic flows. See Header below for details.
     * 
     */
    private RuleGroupRuleGroupRulesSourceStatefulRuleHeader header;
    /**
     * @return Set of configuration blocks containing additional settings for a stateful rule. See Rule Option below for details.
     * 
     */
    private List<RuleGroupRuleGroupRulesSourceStatefulRuleRuleOption> ruleOptions;

    private RuleGroupRuleGroupRulesSourceStatefulRule() {}
    /**
     * @return Action to take with packets in a traffic flow when the flow matches the stateful rule criteria. For all actions, AWS Network Firewall performs the specified action and discontinues stateful inspection of the traffic flow. Valid values: `ALERT`, `DROP`, `PASS`, or `REJECT`.
     * 
     */
    public String action() {
        return this.action;
    }
    /**
     * @return A configuration block containing the stateful 5-tuple inspection criteria for the rule, used to inspect traffic flows. See Header below for details.
     * 
     */
    public RuleGroupRuleGroupRulesSourceStatefulRuleHeader header() {
        return this.header;
    }
    /**
     * @return Set of configuration blocks containing additional settings for a stateful rule. See Rule Option below for details.
     * 
     */
    public List<RuleGroupRuleGroupRulesSourceStatefulRuleRuleOption> ruleOptions() {
        return this.ruleOptions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RuleGroupRuleGroupRulesSourceStatefulRule defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String action;
        private RuleGroupRuleGroupRulesSourceStatefulRuleHeader header;
        private List<RuleGroupRuleGroupRulesSourceStatefulRuleRuleOption> ruleOptions;
        public Builder() {}
        public Builder(RuleGroupRuleGroupRulesSourceStatefulRule defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.action = defaults.action;
    	      this.header = defaults.header;
    	      this.ruleOptions = defaults.ruleOptions;
        }

        @CustomType.Setter
        public Builder action(String action) {
            if (action == null) {
              throw new MissingRequiredPropertyException("RuleGroupRuleGroupRulesSourceStatefulRule", "action");
            }
            this.action = action;
            return this;
        }
        @CustomType.Setter
        public Builder header(RuleGroupRuleGroupRulesSourceStatefulRuleHeader header) {
            if (header == null) {
              throw new MissingRequiredPropertyException("RuleGroupRuleGroupRulesSourceStatefulRule", "header");
            }
            this.header = header;
            return this;
        }
        @CustomType.Setter
        public Builder ruleOptions(List<RuleGroupRuleGroupRulesSourceStatefulRuleRuleOption> ruleOptions) {
            if (ruleOptions == null) {
              throw new MissingRequiredPropertyException("RuleGroupRuleGroupRulesSourceStatefulRule", "ruleOptions");
            }
            this.ruleOptions = ruleOptions;
            return this;
        }
        public Builder ruleOptions(RuleGroupRuleGroupRulesSourceStatefulRuleRuleOption... ruleOptions) {
            return ruleOptions(List.of(ruleOptions));
        }
        public RuleGroupRuleGroupRulesSourceStatefulRule build() {
            final var _resultValue = new RuleGroupRuleGroupRulesSourceStatefulRule();
            _resultValue.action = action;
            _resultValue.header = header;
            _resultValue.ruleOptions = ruleOptions;
            return _resultValue;
        }
    }
}
