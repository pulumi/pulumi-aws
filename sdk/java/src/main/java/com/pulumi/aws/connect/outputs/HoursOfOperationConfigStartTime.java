// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.connect.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class HoursOfOperationConfigStartTime {
    /**
     * @return Specifies the hour of opening.
     * 
     */
    private Integer hours;
    /**
     * @return Specifies the minute of opening.
     * 
     */
    private Integer minutes;

    private HoursOfOperationConfigStartTime() {}
    /**
     * @return Specifies the hour of opening.
     * 
     */
    public Integer hours() {
        return this.hours;
    }
    /**
     * @return Specifies the minute of opening.
     * 
     */
    public Integer minutes() {
        return this.minutes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(HoursOfOperationConfigStartTime defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer hours;
        private Integer minutes;
        public Builder() {}
        public Builder(HoursOfOperationConfigStartTime defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.hours = defaults.hours;
    	      this.minutes = defaults.minutes;
        }

        @CustomType.Setter
        public Builder hours(Integer hours) {
            if (hours == null) {
              throw new MissingRequiredPropertyException("HoursOfOperationConfigStartTime", "hours");
            }
            this.hours = hours;
            return this;
        }
        @CustomType.Setter
        public Builder minutes(Integer minutes) {
            if (minutes == null) {
              throw new MissingRequiredPropertyException("HoursOfOperationConfigStartTime", "minutes");
            }
            this.minutes = minutes;
            return this;
        }
        public HoursOfOperationConfigStartTime build() {
            final var _resultValue = new HoursOfOperationConfigStartTime();
            _resultValue.hours = hours;
            _resultValue.minutes = minutes;
            return _resultValue;
        }
    }
}
