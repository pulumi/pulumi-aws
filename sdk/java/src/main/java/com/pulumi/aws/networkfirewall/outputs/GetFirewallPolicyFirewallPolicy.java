// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.aws.networkfirewall.outputs.GetFirewallPolicyFirewallPolicyPolicyVariable;
import com.pulumi.aws.networkfirewall.outputs.GetFirewallPolicyFirewallPolicyStatefulEngineOption;
import com.pulumi.aws.networkfirewall.outputs.GetFirewallPolicyFirewallPolicyStatefulRuleGroupReference;
import com.pulumi.aws.networkfirewall.outputs.GetFirewallPolicyFirewallPolicyStatelessCustomAction;
import com.pulumi.aws.networkfirewall.outputs.GetFirewallPolicyFirewallPolicyStatelessRuleGroupReference;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetFirewallPolicyFirewallPolicy {
    private List<GetFirewallPolicyFirewallPolicyPolicyVariable> policyVariables;
    private List<String> statefulDefaultActions;
    private List<GetFirewallPolicyFirewallPolicyStatefulEngineOption> statefulEngineOptions;
    private List<GetFirewallPolicyFirewallPolicyStatefulRuleGroupReference> statefulRuleGroupReferences;
    private List<GetFirewallPolicyFirewallPolicyStatelessCustomAction> statelessCustomActions;
    private List<String> statelessDefaultActions;
    private List<String> statelessFragmentDefaultActions;
    private List<GetFirewallPolicyFirewallPolicyStatelessRuleGroupReference> statelessRuleGroupReferences;
    private String tlsInspectionConfigurationArn;

    private GetFirewallPolicyFirewallPolicy() {}
    public List<GetFirewallPolicyFirewallPolicyPolicyVariable> policyVariables() {
        return this.policyVariables;
    }
    public List<String> statefulDefaultActions() {
        return this.statefulDefaultActions;
    }
    public List<GetFirewallPolicyFirewallPolicyStatefulEngineOption> statefulEngineOptions() {
        return this.statefulEngineOptions;
    }
    public List<GetFirewallPolicyFirewallPolicyStatefulRuleGroupReference> statefulRuleGroupReferences() {
        return this.statefulRuleGroupReferences;
    }
    public List<GetFirewallPolicyFirewallPolicyStatelessCustomAction> statelessCustomActions() {
        return this.statelessCustomActions;
    }
    public List<String> statelessDefaultActions() {
        return this.statelessDefaultActions;
    }
    public List<String> statelessFragmentDefaultActions() {
        return this.statelessFragmentDefaultActions;
    }
    public List<GetFirewallPolicyFirewallPolicyStatelessRuleGroupReference> statelessRuleGroupReferences() {
        return this.statelessRuleGroupReferences;
    }
    public String tlsInspectionConfigurationArn() {
        return this.tlsInspectionConfigurationArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetFirewallPolicyFirewallPolicy defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetFirewallPolicyFirewallPolicyPolicyVariable> policyVariables;
        private List<String> statefulDefaultActions;
        private List<GetFirewallPolicyFirewallPolicyStatefulEngineOption> statefulEngineOptions;
        private List<GetFirewallPolicyFirewallPolicyStatefulRuleGroupReference> statefulRuleGroupReferences;
        private List<GetFirewallPolicyFirewallPolicyStatelessCustomAction> statelessCustomActions;
        private List<String> statelessDefaultActions;
        private List<String> statelessFragmentDefaultActions;
        private List<GetFirewallPolicyFirewallPolicyStatelessRuleGroupReference> statelessRuleGroupReferences;
        private String tlsInspectionConfigurationArn;
        public Builder() {}
        public Builder(GetFirewallPolicyFirewallPolicy defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.policyVariables = defaults.policyVariables;
    	      this.statefulDefaultActions = defaults.statefulDefaultActions;
    	      this.statefulEngineOptions = defaults.statefulEngineOptions;
    	      this.statefulRuleGroupReferences = defaults.statefulRuleGroupReferences;
    	      this.statelessCustomActions = defaults.statelessCustomActions;
    	      this.statelessDefaultActions = defaults.statelessDefaultActions;
    	      this.statelessFragmentDefaultActions = defaults.statelessFragmentDefaultActions;
    	      this.statelessRuleGroupReferences = defaults.statelessRuleGroupReferences;
    	      this.tlsInspectionConfigurationArn = defaults.tlsInspectionConfigurationArn;
        }

        @CustomType.Setter
        public Builder policyVariables(List<GetFirewallPolicyFirewallPolicyPolicyVariable> policyVariables) {
            if (policyVariables == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "policyVariables");
            }
            this.policyVariables = policyVariables;
            return this;
        }
        public Builder policyVariables(GetFirewallPolicyFirewallPolicyPolicyVariable... policyVariables) {
            return policyVariables(List.of(policyVariables));
        }
        @CustomType.Setter
        public Builder statefulDefaultActions(List<String> statefulDefaultActions) {
            if (statefulDefaultActions == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "statefulDefaultActions");
            }
            this.statefulDefaultActions = statefulDefaultActions;
            return this;
        }
        public Builder statefulDefaultActions(String... statefulDefaultActions) {
            return statefulDefaultActions(List.of(statefulDefaultActions));
        }
        @CustomType.Setter
        public Builder statefulEngineOptions(List<GetFirewallPolicyFirewallPolicyStatefulEngineOption> statefulEngineOptions) {
            if (statefulEngineOptions == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "statefulEngineOptions");
            }
            this.statefulEngineOptions = statefulEngineOptions;
            return this;
        }
        public Builder statefulEngineOptions(GetFirewallPolicyFirewallPolicyStatefulEngineOption... statefulEngineOptions) {
            return statefulEngineOptions(List.of(statefulEngineOptions));
        }
        @CustomType.Setter
        public Builder statefulRuleGroupReferences(List<GetFirewallPolicyFirewallPolicyStatefulRuleGroupReference> statefulRuleGroupReferences) {
            if (statefulRuleGroupReferences == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "statefulRuleGroupReferences");
            }
            this.statefulRuleGroupReferences = statefulRuleGroupReferences;
            return this;
        }
        public Builder statefulRuleGroupReferences(GetFirewallPolicyFirewallPolicyStatefulRuleGroupReference... statefulRuleGroupReferences) {
            return statefulRuleGroupReferences(List.of(statefulRuleGroupReferences));
        }
        @CustomType.Setter
        public Builder statelessCustomActions(List<GetFirewallPolicyFirewallPolicyStatelessCustomAction> statelessCustomActions) {
            if (statelessCustomActions == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "statelessCustomActions");
            }
            this.statelessCustomActions = statelessCustomActions;
            return this;
        }
        public Builder statelessCustomActions(GetFirewallPolicyFirewallPolicyStatelessCustomAction... statelessCustomActions) {
            return statelessCustomActions(List.of(statelessCustomActions));
        }
        @CustomType.Setter
        public Builder statelessDefaultActions(List<String> statelessDefaultActions) {
            if (statelessDefaultActions == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "statelessDefaultActions");
            }
            this.statelessDefaultActions = statelessDefaultActions;
            return this;
        }
        public Builder statelessDefaultActions(String... statelessDefaultActions) {
            return statelessDefaultActions(List.of(statelessDefaultActions));
        }
        @CustomType.Setter
        public Builder statelessFragmentDefaultActions(List<String> statelessFragmentDefaultActions) {
            if (statelessFragmentDefaultActions == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "statelessFragmentDefaultActions");
            }
            this.statelessFragmentDefaultActions = statelessFragmentDefaultActions;
            return this;
        }
        public Builder statelessFragmentDefaultActions(String... statelessFragmentDefaultActions) {
            return statelessFragmentDefaultActions(List.of(statelessFragmentDefaultActions));
        }
        @CustomType.Setter
        public Builder statelessRuleGroupReferences(List<GetFirewallPolicyFirewallPolicyStatelessRuleGroupReference> statelessRuleGroupReferences) {
            if (statelessRuleGroupReferences == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "statelessRuleGroupReferences");
            }
            this.statelessRuleGroupReferences = statelessRuleGroupReferences;
            return this;
        }
        public Builder statelessRuleGroupReferences(GetFirewallPolicyFirewallPolicyStatelessRuleGroupReference... statelessRuleGroupReferences) {
            return statelessRuleGroupReferences(List.of(statelessRuleGroupReferences));
        }
        @CustomType.Setter
        public Builder tlsInspectionConfigurationArn(String tlsInspectionConfigurationArn) {
            if (tlsInspectionConfigurationArn == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicy", "tlsInspectionConfigurationArn");
            }
            this.tlsInspectionConfigurationArn = tlsInspectionConfigurationArn;
            return this;
        }
        public GetFirewallPolicyFirewallPolicy build() {
            final var _resultValue = new GetFirewallPolicyFirewallPolicy();
            _resultValue.policyVariables = policyVariables;
            _resultValue.statefulDefaultActions = statefulDefaultActions;
            _resultValue.statefulEngineOptions = statefulEngineOptions;
            _resultValue.statefulRuleGroupReferences = statefulRuleGroupReferences;
            _resultValue.statelessCustomActions = statelessCustomActions;
            _resultValue.statelessDefaultActions = statelessDefaultActions;
            _resultValue.statelessFragmentDefaultActions = statelessFragmentDefaultActions;
            _resultValue.statelessRuleGroupReferences = statelessRuleGroupReferences;
            _resultValue.tlsInspectionConfigurationArn = tlsInspectionConfigurationArn;
            return _resultValue;
        }
    }
}
