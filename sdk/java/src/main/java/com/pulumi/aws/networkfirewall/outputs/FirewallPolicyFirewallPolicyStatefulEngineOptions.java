// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.aws.networkfirewall.outputs.FirewallPolicyFirewallPolicyStatefulEngineOptionsFlowTimeouts;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class FirewallPolicyFirewallPolicyStatefulEngineOptions {
    /**
     * @return Amount of time that can pass without any traffic sent through the firewall before the firewall determines that the connection is idle.
     * 
     */
    private @Nullable FirewallPolicyFirewallPolicyStatefulEngineOptionsFlowTimeouts flowTimeouts;
    /**
     * @return Indicates how to manage the order of stateful rule evaluation for the policy. Default value: `DEFAULT_ACTION_ORDER`. Valid values: `DEFAULT_ACTION_ORDER`, `STRICT_ORDER`.
     * 
     */
    private @Nullable String ruleOrder;
    /**
     * @return Describes how to treat traffic which has broken midstream. Default value: `DROP`. Valid values: `DROP`, `CONTINUE`, `REJECT`.
     * 
     */
    private @Nullable String streamExceptionPolicy;

    private FirewallPolicyFirewallPolicyStatefulEngineOptions() {}
    /**
     * @return Amount of time that can pass without any traffic sent through the firewall before the firewall determines that the connection is idle.
     * 
     */
    public Optional<FirewallPolicyFirewallPolicyStatefulEngineOptionsFlowTimeouts> flowTimeouts() {
        return Optional.ofNullable(this.flowTimeouts);
    }
    /**
     * @return Indicates how to manage the order of stateful rule evaluation for the policy. Default value: `DEFAULT_ACTION_ORDER`. Valid values: `DEFAULT_ACTION_ORDER`, `STRICT_ORDER`.
     * 
     */
    public Optional<String> ruleOrder() {
        return Optional.ofNullable(this.ruleOrder);
    }
    /**
     * @return Describes how to treat traffic which has broken midstream. Default value: `DROP`. Valid values: `DROP`, `CONTINUE`, `REJECT`.
     * 
     */
    public Optional<String> streamExceptionPolicy() {
        return Optional.ofNullable(this.streamExceptionPolicy);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FirewallPolicyFirewallPolicyStatefulEngineOptions defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable FirewallPolicyFirewallPolicyStatefulEngineOptionsFlowTimeouts flowTimeouts;
        private @Nullable String ruleOrder;
        private @Nullable String streamExceptionPolicy;
        public Builder() {}
        public Builder(FirewallPolicyFirewallPolicyStatefulEngineOptions defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.flowTimeouts = defaults.flowTimeouts;
    	      this.ruleOrder = defaults.ruleOrder;
    	      this.streamExceptionPolicy = defaults.streamExceptionPolicy;
        }

        @CustomType.Setter
        public Builder flowTimeouts(@Nullable FirewallPolicyFirewallPolicyStatefulEngineOptionsFlowTimeouts flowTimeouts) {

            this.flowTimeouts = flowTimeouts;
            return this;
        }
        @CustomType.Setter
        public Builder ruleOrder(@Nullable String ruleOrder) {

            this.ruleOrder = ruleOrder;
            return this;
        }
        @CustomType.Setter
        public Builder streamExceptionPolicy(@Nullable String streamExceptionPolicy) {

            this.streamExceptionPolicy = streamExceptionPolicy;
            return this;
        }
        public FirewallPolicyFirewallPolicyStatefulEngineOptions build() {
            final var _resultValue = new FirewallPolicyFirewallPolicyStatefulEngineOptions();
            _resultValue.flowTimeouts = flowTimeouts;
            _resultValue.ruleOrder = ruleOrder;
            _resultValue.streamExceptionPolicy = streamExceptionPolicy;
            return _resultValue;
        }
    }
}
