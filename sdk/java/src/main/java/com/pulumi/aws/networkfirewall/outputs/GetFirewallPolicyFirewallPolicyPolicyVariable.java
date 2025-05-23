// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.aws.networkfirewall.outputs.GetFirewallPolicyFirewallPolicyPolicyVariableRuleVariable;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetFirewallPolicyFirewallPolicyPolicyVariable {
    private List<GetFirewallPolicyFirewallPolicyPolicyVariableRuleVariable> ruleVariables;

    private GetFirewallPolicyFirewallPolicyPolicyVariable() {}
    public List<GetFirewallPolicyFirewallPolicyPolicyVariableRuleVariable> ruleVariables() {
        return this.ruleVariables;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetFirewallPolicyFirewallPolicyPolicyVariable defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetFirewallPolicyFirewallPolicyPolicyVariableRuleVariable> ruleVariables;
        public Builder() {}
        public Builder(GetFirewallPolicyFirewallPolicyPolicyVariable defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.ruleVariables = defaults.ruleVariables;
        }

        @CustomType.Setter
        public Builder ruleVariables(List<GetFirewallPolicyFirewallPolicyPolicyVariableRuleVariable> ruleVariables) {
            if (ruleVariables == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicyPolicyVariable", "ruleVariables");
            }
            this.ruleVariables = ruleVariables;
            return this;
        }
        public Builder ruleVariables(GetFirewallPolicyFirewallPolicyPolicyVariableRuleVariable... ruleVariables) {
            return ruleVariables(List.of(ruleVariables));
        }
        public GetFirewallPolicyFirewallPolicyPolicyVariable build() {
            final var _resultValue = new GetFirewallPolicyFirewallPolicyPolicyVariable();
            _resultValue.ruleVariables = ruleVariables;
            return _resultValue;
        }
    }
}
