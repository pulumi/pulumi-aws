// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetFirewallPolicyFirewallPolicyStatefulEngineOption {
    private String ruleOrder;
    private String streamExceptionPolicy;

    private GetFirewallPolicyFirewallPolicyStatefulEngineOption() {}
    public String ruleOrder() {
        return this.ruleOrder;
    }
    public String streamExceptionPolicy() {
        return this.streamExceptionPolicy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetFirewallPolicyFirewallPolicyStatefulEngineOption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String ruleOrder;
        private String streamExceptionPolicy;
        public Builder() {}
        public Builder(GetFirewallPolicyFirewallPolicyStatefulEngineOption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.ruleOrder = defaults.ruleOrder;
    	      this.streamExceptionPolicy = defaults.streamExceptionPolicy;
        }

        @CustomType.Setter
        public Builder ruleOrder(String ruleOrder) {
            if (ruleOrder == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicyStatefulEngineOption", "ruleOrder");
            }
            this.ruleOrder = ruleOrder;
            return this;
        }
        @CustomType.Setter
        public Builder streamExceptionPolicy(String streamExceptionPolicy) {
            if (streamExceptionPolicy == null) {
              throw new MissingRequiredPropertyException("GetFirewallPolicyFirewallPolicyStatefulEngineOption", "streamExceptionPolicy");
            }
            this.streamExceptionPolicy = streamExceptionPolicy;
            return this;
        }
        public GetFirewallPolicyFirewallPolicyStatefulEngineOption build() {
            final var _resultValue = new GetFirewallPolicyFirewallPolicyStatefulEngineOption();
            _resultValue.ruleOrder = ruleOrder;
            _resultValue.streamExceptionPolicy = streamExceptionPolicy;
            return _resultValue;
        }
    }
}
