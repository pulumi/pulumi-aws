// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspaces.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetWorkspaceWorkspaceProperty {
    /**
     * @return Compute type. For more information, see [Amazon WorkSpaces Bundles](http://aws.amazon.com/workspaces/details/#Amazon_WorkSpaces_Bundles). Valid values are `VALUE`, `STANDARD`, `PERFORMANCE`, `POWER`, `GRAPHICS`, `POWERPRO` and `GRAPHICSPRO`.
     * 
     */
    private String computeTypeName;
    /**
     * @return Size of the root volume.
     * 
     */
    private Integer rootVolumeSizeGib;
    /**
     * @return Running mode. For more information, see [Manage the WorkSpace Running Mode](https://docs.aws.amazon.com/workspaces/latest/adminguide/running-mode.html). Valid values are `AUTO_STOP` and `ALWAYS_ON`.
     * 
     */
    private String runningMode;
    /**
     * @return Time after a user logs off when WorkSpaces are automatically stopped. Configured in 60-minute intervals.
     * 
     */
    private Integer runningModeAutoStopTimeoutInMinutes;
    /**
     * @return Size of the user storage.
     * 
     */
    private Integer userVolumeSizeGib;

    private GetWorkspaceWorkspaceProperty() {}
    /**
     * @return Compute type. For more information, see [Amazon WorkSpaces Bundles](http://aws.amazon.com/workspaces/details/#Amazon_WorkSpaces_Bundles). Valid values are `VALUE`, `STANDARD`, `PERFORMANCE`, `POWER`, `GRAPHICS`, `POWERPRO` and `GRAPHICSPRO`.
     * 
     */
    public String computeTypeName() {
        return this.computeTypeName;
    }
    /**
     * @return Size of the root volume.
     * 
     */
    public Integer rootVolumeSizeGib() {
        return this.rootVolumeSizeGib;
    }
    /**
     * @return Running mode. For more information, see [Manage the WorkSpace Running Mode](https://docs.aws.amazon.com/workspaces/latest/adminguide/running-mode.html). Valid values are `AUTO_STOP` and `ALWAYS_ON`.
     * 
     */
    public String runningMode() {
        return this.runningMode;
    }
    /**
     * @return Time after a user logs off when WorkSpaces are automatically stopped. Configured in 60-minute intervals.
     * 
     */
    public Integer runningModeAutoStopTimeoutInMinutes() {
        return this.runningModeAutoStopTimeoutInMinutes;
    }
    /**
     * @return Size of the user storage.
     * 
     */
    public Integer userVolumeSizeGib() {
        return this.userVolumeSizeGib;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetWorkspaceWorkspaceProperty defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String computeTypeName;
        private Integer rootVolumeSizeGib;
        private String runningMode;
        private Integer runningModeAutoStopTimeoutInMinutes;
        private Integer userVolumeSizeGib;
        public Builder() {}
        public Builder(GetWorkspaceWorkspaceProperty defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.computeTypeName = defaults.computeTypeName;
    	      this.rootVolumeSizeGib = defaults.rootVolumeSizeGib;
    	      this.runningMode = defaults.runningMode;
    	      this.runningModeAutoStopTimeoutInMinutes = defaults.runningModeAutoStopTimeoutInMinutes;
    	      this.userVolumeSizeGib = defaults.userVolumeSizeGib;
        }

        @CustomType.Setter
        public Builder computeTypeName(String computeTypeName) {
            if (computeTypeName == null) {
              throw new MissingRequiredPropertyException("GetWorkspaceWorkspaceProperty", "computeTypeName");
            }
            this.computeTypeName = computeTypeName;
            return this;
        }
        @CustomType.Setter
        public Builder rootVolumeSizeGib(Integer rootVolumeSizeGib) {
            if (rootVolumeSizeGib == null) {
              throw new MissingRequiredPropertyException("GetWorkspaceWorkspaceProperty", "rootVolumeSizeGib");
            }
            this.rootVolumeSizeGib = rootVolumeSizeGib;
            return this;
        }
        @CustomType.Setter
        public Builder runningMode(String runningMode) {
            if (runningMode == null) {
              throw new MissingRequiredPropertyException("GetWorkspaceWorkspaceProperty", "runningMode");
            }
            this.runningMode = runningMode;
            return this;
        }
        @CustomType.Setter
        public Builder runningModeAutoStopTimeoutInMinutes(Integer runningModeAutoStopTimeoutInMinutes) {
            if (runningModeAutoStopTimeoutInMinutes == null) {
              throw new MissingRequiredPropertyException("GetWorkspaceWorkspaceProperty", "runningModeAutoStopTimeoutInMinutes");
            }
            this.runningModeAutoStopTimeoutInMinutes = runningModeAutoStopTimeoutInMinutes;
            return this;
        }
        @CustomType.Setter
        public Builder userVolumeSizeGib(Integer userVolumeSizeGib) {
            if (userVolumeSizeGib == null) {
              throw new MissingRequiredPropertyException("GetWorkspaceWorkspaceProperty", "userVolumeSizeGib");
            }
            this.userVolumeSizeGib = userVolumeSizeGib;
            return this;
        }
        public GetWorkspaceWorkspaceProperty build() {
            final var _resultValue = new GetWorkspaceWorkspaceProperty();
            _resultValue.computeTypeName = computeTypeName;
            _resultValue.rootVolumeSizeGib = rootVolumeSizeGib;
            _resultValue.runningMode = runningMode;
            _resultValue.runningModeAutoStopTimeoutInMinutes = runningModeAutoStopTimeoutInMinutes;
            _resultValue.userVolumeSizeGib = userVolumeSizeGib;
            return _resultValue;
        }
    }
}
