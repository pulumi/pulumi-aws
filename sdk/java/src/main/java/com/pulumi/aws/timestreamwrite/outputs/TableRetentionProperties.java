// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamwrite.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class TableRetentionProperties {
    /**
     * @return The duration for which data must be stored in the magnetic store. Minimum value of 1. Maximum value of 73000.
     * 
     */
    private Integer magneticStoreRetentionPeriodInDays;
    /**
     * @return The duration for which data must be stored in the memory store. Minimum value of 1. Maximum value of 8766.
     * 
     */
    private Integer memoryStoreRetentionPeriodInHours;

    private TableRetentionProperties() {}
    /**
     * @return The duration for which data must be stored in the magnetic store. Minimum value of 1. Maximum value of 73000.
     * 
     */
    public Integer magneticStoreRetentionPeriodInDays() {
        return this.magneticStoreRetentionPeriodInDays;
    }
    /**
     * @return The duration for which data must be stored in the memory store. Minimum value of 1. Maximum value of 8766.
     * 
     */
    public Integer memoryStoreRetentionPeriodInHours() {
        return this.memoryStoreRetentionPeriodInHours;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TableRetentionProperties defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer magneticStoreRetentionPeriodInDays;
        private Integer memoryStoreRetentionPeriodInHours;
        public Builder() {}
        public Builder(TableRetentionProperties defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.magneticStoreRetentionPeriodInDays = defaults.magneticStoreRetentionPeriodInDays;
    	      this.memoryStoreRetentionPeriodInHours = defaults.memoryStoreRetentionPeriodInHours;
        }

        @CustomType.Setter
        public Builder magneticStoreRetentionPeriodInDays(Integer magneticStoreRetentionPeriodInDays) {
            if (magneticStoreRetentionPeriodInDays == null) {
              throw new MissingRequiredPropertyException("TableRetentionProperties", "magneticStoreRetentionPeriodInDays");
            }
            this.magneticStoreRetentionPeriodInDays = magneticStoreRetentionPeriodInDays;
            return this;
        }
        @CustomType.Setter
        public Builder memoryStoreRetentionPeriodInHours(Integer memoryStoreRetentionPeriodInHours) {
            if (memoryStoreRetentionPeriodInHours == null) {
              throw new MissingRequiredPropertyException("TableRetentionProperties", "memoryStoreRetentionPeriodInHours");
            }
            this.memoryStoreRetentionPeriodInHours = memoryStoreRetentionPeriodInHours;
            return this;
        }
        public TableRetentionProperties build() {
            final var _resultValue = new TableRetentionProperties();
            _resultValue.magneticStoreRetentionPeriodInDays = magneticStoreRetentionPeriodInDays;
            _resultValue.memoryStoreRetentionPeriodInHours = memoryStoreRetentionPeriodInHours;
            return _resultValue;
        }
    }
}
