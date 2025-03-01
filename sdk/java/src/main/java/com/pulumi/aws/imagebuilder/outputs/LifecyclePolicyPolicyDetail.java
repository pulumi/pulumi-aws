// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.outputs;

import com.pulumi.aws.imagebuilder.outputs.LifecyclePolicyPolicyDetailAction;
import com.pulumi.aws.imagebuilder.outputs.LifecyclePolicyPolicyDetailExclusionRules;
import com.pulumi.aws.imagebuilder.outputs.LifecyclePolicyPolicyDetailFilter;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class LifecyclePolicyPolicyDetail {
    /**
     * @return Configuration details for the policy action.
     * 
     */
    private @Nullable LifecyclePolicyPolicyDetailAction action;
    /**
     * @return Additional rules to specify resources that should be exempt from policy actions.
     * 
     */
    private @Nullable LifecyclePolicyPolicyDetailExclusionRules exclusionRules;
    /**
     * @return Specifies the resources that the lifecycle policy applies to.
     * 
     * The following arguments are optional:
     * 
     */
    private @Nullable LifecyclePolicyPolicyDetailFilter filter;

    private LifecyclePolicyPolicyDetail() {}
    /**
     * @return Configuration details for the policy action.
     * 
     */
    public Optional<LifecyclePolicyPolicyDetailAction> action() {
        return Optional.ofNullable(this.action);
    }
    /**
     * @return Additional rules to specify resources that should be exempt from policy actions.
     * 
     */
    public Optional<LifecyclePolicyPolicyDetailExclusionRules> exclusionRules() {
        return Optional.ofNullable(this.exclusionRules);
    }
    /**
     * @return Specifies the resources that the lifecycle policy applies to.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<LifecyclePolicyPolicyDetailFilter> filter() {
        return Optional.ofNullable(this.filter);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(LifecyclePolicyPolicyDetail defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable LifecyclePolicyPolicyDetailAction action;
        private @Nullable LifecyclePolicyPolicyDetailExclusionRules exclusionRules;
        private @Nullable LifecyclePolicyPolicyDetailFilter filter;
        public Builder() {}
        public Builder(LifecyclePolicyPolicyDetail defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.action = defaults.action;
    	      this.exclusionRules = defaults.exclusionRules;
    	      this.filter = defaults.filter;
        }

        @CustomType.Setter
        public Builder action(@Nullable LifecyclePolicyPolicyDetailAction action) {

            this.action = action;
            return this;
        }
        @CustomType.Setter
        public Builder exclusionRules(@Nullable LifecyclePolicyPolicyDetailExclusionRules exclusionRules) {

            this.exclusionRules = exclusionRules;
            return this;
        }
        @CustomType.Setter
        public Builder filter(@Nullable LifecyclePolicyPolicyDetailFilter filter) {

            this.filter = filter;
            return this;
        }
        public LifecyclePolicyPolicyDetail build() {
            final var _resultValue = new LifecyclePolicyPolicyDetail();
            _resultValue.action = action;
            _resultValue.exclusionRules = exclusionRules;
            _resultValue.filter = filter;
            return _resultValue;
        }
    }
}
