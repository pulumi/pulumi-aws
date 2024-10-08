// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkmanager.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetDeviceAwsLocation {
    /**
     * @return ARN of the subnet that the device is located in.
     * 
     */
    private String subnetArn;
    /**
     * @return Zone that the device is located in.
     * 
     */
    private String zone;

    private GetDeviceAwsLocation() {}
    /**
     * @return ARN of the subnet that the device is located in.
     * 
     */
    public String subnetArn() {
        return this.subnetArn;
    }
    /**
     * @return Zone that the device is located in.
     * 
     */
    public String zone() {
        return this.zone;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDeviceAwsLocation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String subnetArn;
        private String zone;
        public Builder() {}
        public Builder(GetDeviceAwsLocation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.subnetArn = defaults.subnetArn;
    	      this.zone = defaults.zone;
        }

        @CustomType.Setter
        public Builder subnetArn(String subnetArn) {
            if (subnetArn == null) {
              throw new MissingRequiredPropertyException("GetDeviceAwsLocation", "subnetArn");
            }
            this.subnetArn = subnetArn;
            return this;
        }
        @CustomType.Setter
        public Builder zone(String zone) {
            if (zone == null) {
              throw new MissingRequiredPropertyException("GetDeviceAwsLocation", "zone");
            }
            this.zone = zone;
            return this;
        }
        public GetDeviceAwsLocation build() {
            final var _resultValue = new GetDeviceAwsLocation();
            _resultValue.subnetArn = subnetArn;
            _resultValue.zone = zone;
            return _resultValue;
        }
    }
}
