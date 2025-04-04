// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.outputs;

import com.pulumi.aws.sagemaker.outputs.UserProfileUserSettingsTensorBoardAppSettingsDefaultResourceSpec;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class UserProfileUserSettingsTensorBoardAppSettings {
    /**
     * @return The default instance type and the Amazon Resource Name (ARN) of the SageMaker AI image created on the instance. see Default Resource Spec below.
     * 
     */
    private @Nullable UserProfileUserSettingsTensorBoardAppSettingsDefaultResourceSpec defaultResourceSpec;

    private UserProfileUserSettingsTensorBoardAppSettings() {}
    /**
     * @return The default instance type and the Amazon Resource Name (ARN) of the SageMaker AI image created on the instance. see Default Resource Spec below.
     * 
     */
    public Optional<UserProfileUserSettingsTensorBoardAppSettingsDefaultResourceSpec> defaultResourceSpec() {
        return Optional.ofNullable(this.defaultResourceSpec);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(UserProfileUserSettingsTensorBoardAppSettings defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable UserProfileUserSettingsTensorBoardAppSettingsDefaultResourceSpec defaultResourceSpec;
        public Builder() {}
        public Builder(UserProfileUserSettingsTensorBoardAppSettings defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.defaultResourceSpec = defaults.defaultResourceSpec;
        }

        @CustomType.Setter
        public Builder defaultResourceSpec(@Nullable UserProfileUserSettingsTensorBoardAppSettingsDefaultResourceSpec defaultResourceSpec) {

            this.defaultResourceSpec = defaultResourceSpec;
            return this;
        }
        public UserProfileUserSettingsTensorBoardAppSettings build() {
            final var _resultValue = new UserProfileUserSettingsTensorBoardAppSettings();
            _resultValue.defaultResourceSpec = defaultResourceSpec;
            return _resultValue;
        }
    }
}
