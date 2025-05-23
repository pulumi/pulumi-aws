// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetInstanceTypeNeuronDevice {
    private Integer coreCount;
    private Integer coreVersion;
    private Integer count;
    /**
     * @return Size of the instance memory, in MiB.
     * 
     */
    private Integer memorySize;
    private String name;

    private GetInstanceTypeNeuronDevice() {}
    public Integer coreCount() {
        return this.coreCount;
    }
    public Integer coreVersion() {
        return this.coreVersion;
    }
    public Integer count() {
        return this.count;
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

    public static Builder builder(GetInstanceTypeNeuronDevice defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer coreCount;
        private Integer coreVersion;
        private Integer count;
        private Integer memorySize;
        private String name;
        public Builder() {}
        public Builder(GetInstanceTypeNeuronDevice defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.coreCount = defaults.coreCount;
    	      this.coreVersion = defaults.coreVersion;
    	      this.count = defaults.count;
    	      this.memorySize = defaults.memorySize;
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder coreCount(Integer coreCount) {
            if (coreCount == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeNeuronDevice", "coreCount");
            }
            this.coreCount = coreCount;
            return this;
        }
        @CustomType.Setter
        public Builder coreVersion(Integer coreVersion) {
            if (coreVersion == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeNeuronDevice", "coreVersion");
            }
            this.coreVersion = coreVersion;
            return this;
        }
        @CustomType.Setter
        public Builder count(Integer count) {
            if (count == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeNeuronDevice", "count");
            }
            this.count = count;
            return this;
        }
        @CustomType.Setter
        public Builder memorySize(Integer memorySize) {
            if (memorySize == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeNeuronDevice", "memorySize");
            }
            this.memorySize = memorySize;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetInstanceTypeNeuronDevice", "name");
            }
            this.name = name;
            return this;
        }
        public GetInstanceTypeNeuronDevice build() {
            final var _resultValue = new GetInstanceTypeNeuronDevice();
            _resultValue.coreCount = coreCount;
            _resultValue.coreVersion = coreVersion;
            _resultValue.count = count;
            _resultValue.memorySize = memorySize;
            _resultValue.name = name;
            return _resultValue;
        }
    }
}
