// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsIntentConfirmationSettingElicitationCodeHook {
    /**
     * @return Whether a Lambda function should be invoked for the dialog.
     * 
     */
    private @Nullable Boolean enableCodeHookInvocation;
    /**
     * @return Label that indicates the dialog step from which the dialog code hook is happening.
     * 
     */
    private @Nullable String invocationLabel;

    private V2modelsIntentConfirmationSettingElicitationCodeHook() {}
    /**
     * @return Whether a Lambda function should be invoked for the dialog.
     * 
     */
    public Optional<Boolean> enableCodeHookInvocation() {
        return Optional.ofNullable(this.enableCodeHookInvocation);
    }
    /**
     * @return Label that indicates the dialog step from which the dialog code hook is happening.
     * 
     */
    public Optional<String> invocationLabel() {
        return Optional.ofNullable(this.invocationLabel);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsIntentConfirmationSettingElicitationCodeHook defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean enableCodeHookInvocation;
        private @Nullable String invocationLabel;
        public Builder() {}
        public Builder(V2modelsIntentConfirmationSettingElicitationCodeHook defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enableCodeHookInvocation = defaults.enableCodeHookInvocation;
    	      this.invocationLabel = defaults.invocationLabel;
        }

        @CustomType.Setter
        public Builder enableCodeHookInvocation(@Nullable Boolean enableCodeHookInvocation) {

            this.enableCodeHookInvocation = enableCodeHookInvocation;
            return this;
        }
        @CustomType.Setter
        public Builder invocationLabel(@Nullable String invocationLabel) {

            this.invocationLabel = invocationLabel;
            return this;
        }
        public V2modelsIntentConfirmationSettingElicitationCodeHook build() {
            final var _resultValue = new V2modelsIntentConfirmationSettingElicitationCodeHook();
            _resultValue.enableCodeHookInvocation = enableCodeHookInvocation;
            _resultValue.invocationLabel = invocationLabel;
            return _resultValue;
        }
    }
}
