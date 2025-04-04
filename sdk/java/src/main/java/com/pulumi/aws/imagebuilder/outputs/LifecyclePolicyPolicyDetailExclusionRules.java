// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.outputs;

import com.pulumi.aws.imagebuilder.outputs.LifecyclePolicyPolicyDetailExclusionRulesAmis;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class LifecyclePolicyPolicyDetailExclusionRules {
    /**
     * @return Lists configuration values that apply to AMIs that Image Builder should exclude from the lifecycle action. Detailed below.
     * 
     */
    private @Nullable LifecyclePolicyPolicyDetailExclusionRulesAmis amis;
    /**
     * @return Contains a list of tags that Image Builder uses to skip lifecycle actions for Image Builder image resources that have them.
     * 
     */
    private @Nullable Map<String,String> tagMap;

    private LifecyclePolicyPolicyDetailExclusionRules() {}
    /**
     * @return Lists configuration values that apply to AMIs that Image Builder should exclude from the lifecycle action. Detailed below.
     * 
     */
    public Optional<LifecyclePolicyPolicyDetailExclusionRulesAmis> amis() {
        return Optional.ofNullable(this.amis);
    }
    /**
     * @return Contains a list of tags that Image Builder uses to skip lifecycle actions for Image Builder image resources that have them.
     * 
     */
    public Map<String,String> tagMap() {
        return this.tagMap == null ? Map.of() : this.tagMap;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(LifecyclePolicyPolicyDetailExclusionRules defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable LifecyclePolicyPolicyDetailExclusionRulesAmis amis;
        private @Nullable Map<String,String> tagMap;
        public Builder() {}
        public Builder(LifecyclePolicyPolicyDetailExclusionRules defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.amis = defaults.amis;
    	      this.tagMap = defaults.tagMap;
        }

        @CustomType.Setter
        public Builder amis(@Nullable LifecyclePolicyPolicyDetailExclusionRulesAmis amis) {

            this.amis = amis;
            return this;
        }
        @CustomType.Setter
        public Builder tagMap(@Nullable Map<String,String> tagMap) {

            this.tagMap = tagMap;
            return this;
        }
        public LifecyclePolicyPolicyDetailExclusionRules build() {
            final var _resultValue = new LifecyclePolicyPolicyDetailExclusionRules();
            _resultValue.amis = amis;
            _resultValue.tagMap = tagMap;
            return _resultValue;
        }
    }
}
