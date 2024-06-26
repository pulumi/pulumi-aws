// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.outputs;

import com.pulumi.aws.sagemaker.outputs.SpaceSpaceSettingsCodeEditorAppSettingsDefaultResourceSpec;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.Objects;

@CustomType
public final class SpaceSpaceSettingsCodeEditorAppSettings {
    /**
     * @return The default instance type and the Amazon Resource Name (ARN) of the SageMaker image created on the instance. see Default Resource Spec below.
     * 
     */
    private SpaceSpaceSettingsCodeEditorAppSettingsDefaultResourceSpec defaultResourceSpec;

    private SpaceSpaceSettingsCodeEditorAppSettings() {}
    /**
     * @return The default instance type and the Amazon Resource Name (ARN) of the SageMaker image created on the instance. see Default Resource Spec below.
     * 
     */
    public SpaceSpaceSettingsCodeEditorAppSettingsDefaultResourceSpec defaultResourceSpec() {
        return this.defaultResourceSpec;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SpaceSpaceSettingsCodeEditorAppSettings defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private SpaceSpaceSettingsCodeEditorAppSettingsDefaultResourceSpec defaultResourceSpec;
        public Builder() {}
        public Builder(SpaceSpaceSettingsCodeEditorAppSettings defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.defaultResourceSpec = defaults.defaultResourceSpec;
        }

        @CustomType.Setter
        public Builder defaultResourceSpec(SpaceSpaceSettingsCodeEditorAppSettingsDefaultResourceSpec defaultResourceSpec) {
            if (defaultResourceSpec == null) {
              throw new MissingRequiredPropertyException("SpaceSpaceSettingsCodeEditorAppSettings", "defaultResourceSpec");
            }
            this.defaultResourceSpec = defaultResourceSpec;
            return this;
        }
        public SpaceSpaceSettingsCodeEditorAppSettings build() {
            final var _resultValue = new SpaceSpaceSettingsCodeEditorAppSettings();
            _resultValue.defaultResourceSpec = defaultResourceSpec;
            return _resultValue;
        }
    }
}
