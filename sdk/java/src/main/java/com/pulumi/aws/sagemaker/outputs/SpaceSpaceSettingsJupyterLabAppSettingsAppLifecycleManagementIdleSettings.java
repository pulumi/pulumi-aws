// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class SpaceSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementIdleSettings {
    /**
     * @return The time that SageMaker AI waits after the application becomes idle before shutting it down. Valid values are between `60` and `525600`.
     * 
     */
    private @Nullable Integer idleTimeoutInMinutes;

    private SpaceSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementIdleSettings() {}
    /**
     * @return The time that SageMaker AI waits after the application becomes idle before shutting it down. Valid values are between `60` and `525600`.
     * 
     */
    public Optional<Integer> idleTimeoutInMinutes() {
        return Optional.ofNullable(this.idleTimeoutInMinutes);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SpaceSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementIdleSettings defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer idleTimeoutInMinutes;
        public Builder() {}
        public Builder(SpaceSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementIdleSettings defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.idleTimeoutInMinutes = defaults.idleTimeoutInMinutes;
        }

        @CustomType.Setter
        public Builder idleTimeoutInMinutes(@Nullable Integer idleTimeoutInMinutes) {

            this.idleTimeoutInMinutes = idleTimeoutInMinutes;
            return this;
        }
        public SpaceSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementIdleSettings build() {
            final var _resultValue = new SpaceSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementIdleSettings();
            _resultValue.idleTimeoutInMinutes = idleTimeoutInMinutes;
            return _resultValue;
        }
    }
}
