// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.outputs;

import com.pulumi.aws.imagebuilder.outputs.GetContainerRecipeInstanceConfigurationBlockDeviceMappingEb;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetContainerRecipeInstanceConfigurationBlockDeviceMapping {
    /**
     * @return Name of the device. For example, `/dev/sda` or `/dev/xvdb`.
     * 
     */
    private String deviceName;
    /**
     * @return Single list of object with Elastic Block Storage (EBS) block device mapping settings.
     * 
     */
    private List<GetContainerRecipeInstanceConfigurationBlockDeviceMappingEb> ebs;
    /**
     * @return Whether to remove a mapping from the parent image.
     * 
     */
    private String noDevice;
    /**
     * @return Virtual device name. For example, `ephemeral0`. Instance store volumes are numbered starting from 0.
     * 
     */
    private String virtualName;

    private GetContainerRecipeInstanceConfigurationBlockDeviceMapping() {}
    /**
     * @return Name of the device. For example, `/dev/sda` or `/dev/xvdb`.
     * 
     */
    public String deviceName() {
        return this.deviceName;
    }
    /**
     * @return Single list of object with Elastic Block Storage (EBS) block device mapping settings.
     * 
     */
    public List<GetContainerRecipeInstanceConfigurationBlockDeviceMappingEb> ebs() {
        return this.ebs;
    }
    /**
     * @return Whether to remove a mapping from the parent image.
     * 
     */
    public String noDevice() {
        return this.noDevice;
    }
    /**
     * @return Virtual device name. For example, `ephemeral0`. Instance store volumes are numbered starting from 0.
     * 
     */
    public String virtualName() {
        return this.virtualName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetContainerRecipeInstanceConfigurationBlockDeviceMapping defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String deviceName;
        private List<GetContainerRecipeInstanceConfigurationBlockDeviceMappingEb> ebs;
        private String noDevice;
        private String virtualName;
        public Builder() {}
        public Builder(GetContainerRecipeInstanceConfigurationBlockDeviceMapping defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.deviceName = defaults.deviceName;
    	      this.ebs = defaults.ebs;
    	      this.noDevice = defaults.noDevice;
    	      this.virtualName = defaults.virtualName;
        }

        @CustomType.Setter
        public Builder deviceName(String deviceName) {
            if (deviceName == null) {
              throw new MissingRequiredPropertyException("GetContainerRecipeInstanceConfigurationBlockDeviceMapping", "deviceName");
            }
            this.deviceName = deviceName;
            return this;
        }
        @CustomType.Setter
        public Builder ebs(List<GetContainerRecipeInstanceConfigurationBlockDeviceMappingEb> ebs) {
            if (ebs == null) {
              throw new MissingRequiredPropertyException("GetContainerRecipeInstanceConfigurationBlockDeviceMapping", "ebs");
            }
            this.ebs = ebs;
            return this;
        }
        public Builder ebs(GetContainerRecipeInstanceConfigurationBlockDeviceMappingEb... ebs) {
            return ebs(List.of(ebs));
        }
        @CustomType.Setter
        public Builder noDevice(String noDevice) {
            if (noDevice == null) {
              throw new MissingRequiredPropertyException("GetContainerRecipeInstanceConfigurationBlockDeviceMapping", "noDevice");
            }
            this.noDevice = noDevice;
            return this;
        }
        @CustomType.Setter
        public Builder virtualName(String virtualName) {
            if (virtualName == null) {
              throw new MissingRequiredPropertyException("GetContainerRecipeInstanceConfigurationBlockDeviceMapping", "virtualName");
            }
            this.virtualName = virtualName;
            return this;
        }
        public GetContainerRecipeInstanceConfigurationBlockDeviceMapping build() {
            final var _resultValue = new GetContainerRecipeInstanceConfigurationBlockDeviceMapping();
            _resultValue.deviceName = deviceName;
            _resultValue.ebs = ebs;
            _resultValue.noDevice = noDevice;
            _resultValue.virtualName = virtualName;
            return _resultValue;
        }
    }
}
