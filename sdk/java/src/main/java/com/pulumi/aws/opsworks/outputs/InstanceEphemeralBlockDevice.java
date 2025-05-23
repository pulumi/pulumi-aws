// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opsworks.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class InstanceEphemeralBlockDevice {
    private String deviceName;
    private String virtualName;

    private InstanceEphemeralBlockDevice() {}
    public String deviceName() {
        return this.deviceName;
    }
    public String virtualName() {
        return this.virtualName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(InstanceEphemeralBlockDevice defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String deviceName;
        private String virtualName;
        public Builder() {}
        public Builder(InstanceEphemeralBlockDevice defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.deviceName = defaults.deviceName;
    	      this.virtualName = defaults.virtualName;
        }

        @CustomType.Setter
        public Builder deviceName(String deviceName) {
            if (deviceName == null) {
              throw new MissingRequiredPropertyException("InstanceEphemeralBlockDevice", "deviceName");
            }
            this.deviceName = deviceName;
            return this;
        }
        @CustomType.Setter
        public Builder virtualName(String virtualName) {
            if (virtualName == null) {
              throw new MissingRequiredPropertyException("InstanceEphemeralBlockDevice", "virtualName");
            }
            this.virtualName = virtualName;
            return this;
        }
        public InstanceEphemeralBlockDevice build() {
            final var _resultValue = new InstanceEphemeralBlockDevice();
            _resultValue.deviceName = deviceName;
            _resultValue.virtualName = virtualName;
            return _resultValue;
        }
    }
}
