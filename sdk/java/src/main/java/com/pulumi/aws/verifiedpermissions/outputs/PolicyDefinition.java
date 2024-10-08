// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedpermissions.outputs;

import com.pulumi.aws.verifiedpermissions.outputs.PolicyDefinitionStatic;
import com.pulumi.aws.verifiedpermissions.outputs.PolicyDefinitionTemplateLinked;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class PolicyDefinition {
    /**
     * @return The static policy statement. See Static below.
     * 
     */
    private @Nullable PolicyDefinitionStatic static_;
    /**
     * @return The template linked policy. See Template Linked below.
     * 
     */
    private @Nullable PolicyDefinitionTemplateLinked templateLinked;

    private PolicyDefinition() {}
    /**
     * @return The static policy statement. See Static below.
     * 
     */
    public Optional<PolicyDefinitionStatic> static_() {
        return Optional.ofNullable(this.static_);
    }
    /**
     * @return The template linked policy. See Template Linked below.
     * 
     */
    public Optional<PolicyDefinitionTemplateLinked> templateLinked() {
        return Optional.ofNullable(this.templateLinked);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PolicyDefinition defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable PolicyDefinitionStatic static_;
        private @Nullable PolicyDefinitionTemplateLinked templateLinked;
        public Builder() {}
        public Builder(PolicyDefinition defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.static_ = defaults.static_;
    	      this.templateLinked = defaults.templateLinked;
        }

        @CustomType.Setter("static")
        public Builder static_(@Nullable PolicyDefinitionStatic static_) {

            this.static_ = static_;
            return this;
        }
        @CustomType.Setter
        public Builder templateLinked(@Nullable PolicyDefinitionTemplateLinked templateLinked) {

            this.templateLinked = templateLinked;
            return this;
        }
        public PolicyDefinition build() {
            final var _resultValue = new PolicyDefinition();
            _resultValue.static_ = static_;
            _resultValue.templateLinked = templateLinked;
            return _resultValue;
        }
    }
}
