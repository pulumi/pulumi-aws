// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetInstanceTypeMediaAccelerator {
    private Integer count;
    private String manufacturer;
    /**
     * @return Size of the instance memory, in MiB.
     * 
     */
    private Integer memorySize;
    private String name;

    private GetInstanceTypeMediaAccelerator() {}
    public Integer count() {
        return this.count;
    }
    public String manufacturer() {
        return this.manufacturer;
    }
    /**
     * @return Size of the instance memory, in MiB.
     * 
     */
    public Integer memorySize() {
        return this.memorySize;
    }
    public String name() {
        return this.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetInstanceTypeMediaAccelerator defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer count;
        private String manufacturer;
        private Integer memorySize;
        private String name;
        public Builder() {}
        public Builder(GetInstanceTypeMediaAccelerator defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.count = defaults.count;
    	      this.manufacturer = defaults.manufacturer;
    	      this.memorySize = defaults.memorySize;
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder count(Integer count) {
            if (count == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeMediaAccelerator", "count");
            }
            this.count = count;
            return this;
        }
        @CustomType.Setter
        public Builder manufacturer(String manufacturer) {
            if (manufacturer == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeMediaAccelerator", "manufacturer");
            }
            this.manufacturer = manufacturer;
            return this;
        }
        @CustomType.Setter
        public Builder memorySize(Integer memorySize) {
            if (memorySize == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeMediaAccelerator", "memorySize");
            }
            this.memorySize = memorySize;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeMediaAccelerator", "name");
            }
            this.name = name;
            return this;
        }
        public GetInstanceTypeMediaAccelerator build() {
            final var _resultValue = new GetInstanceTypeMediaAccelerator();
            _resultValue.count = count;
            _resultValue.manufacturer = manufacturer;
            _resultValue.memorySize = memorySize;
            _resultValue.name = name;
            return _resultValue;
        }
    }
}
