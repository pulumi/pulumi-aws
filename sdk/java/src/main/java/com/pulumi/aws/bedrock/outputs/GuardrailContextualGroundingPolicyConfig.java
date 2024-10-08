// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.GuardrailContextualGroundingPolicyConfigFiltersConfig;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GuardrailContextualGroundingPolicyConfig {
    /**
     * @return List of contextual grounding filter configs. See Contextual Grounding Filters Config for more information.
     * 
     */
    private @Nullable List<GuardrailContextualGroundingPolicyConfigFiltersConfig> filtersConfigs;

    private GuardrailContextualGroundingPolicyConfig() {}
    /**
     * @return List of contextual grounding filter configs. See Contextual Grounding Filters Config for more information.
     * 
     */
    public List<GuardrailContextualGroundingPolicyConfigFiltersConfig> filtersConfigs() {
        return this.filtersConfigs == null ? List.of() : this.filtersConfigs;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GuardrailContextualGroundingPolicyConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<GuardrailContextualGroundingPolicyConfigFiltersConfig> filtersConfigs;
        public Builder() {}
        public Builder(GuardrailContextualGroundingPolicyConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.filtersConfigs = defaults.filtersConfigs;
        }

        @CustomType.Setter
        public Builder filtersConfigs(@Nullable List<GuardrailContextualGroundingPolicyConfigFiltersConfig> filtersConfigs) {

            this.filtersConfigs = filtersConfigs;
            return this;
        }
        public Builder filtersConfigs(GuardrailContextualGroundingPolicyConfigFiltersConfig... filtersConfigs) {
            return filtersConfigs(List.of(filtersConfigs));
        }
        public GuardrailContextualGroundingPolicyConfig build() {
            final var _resultValue = new GuardrailContextualGroundingPolicyConfig();
            _resultValue.filtersConfigs = filtersConfigs;
            return _resultValue;
        }
    }
}
