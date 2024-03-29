// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.connect.outputs;

import com.pulumi.aws.connect.outputs.HoursOfOperationConfigEndTime;
import com.pulumi.aws.connect.outputs.HoursOfOperationConfigStartTime;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class HoursOfOperationConfig {
    /**
     * @return Specifies the day that the hours of operation applies to.
     * 
     */
    private String day;
    /**
     * @return A end time block specifies the time that your contact center closes. The `end_time` is documented below.
     * 
     */
    private HoursOfOperationConfigEndTime endTime;
    /**
     * @return A start time block specifies the time that your contact center opens. The `start_time` is documented below.
     * 
     */
    private HoursOfOperationConfigStartTime startTime;

    private HoursOfOperationConfig() {}
    /**
     * @return Specifies the day that the hours of operation applies to.
     * 
     */
    public String day() {
        return this.day;
    }
    /**
     * @return A end time block specifies the time that your contact center closes. The `end_time` is documented below.
     * 
     */
    public HoursOfOperationConfigEndTime endTime() {
        return this.endTime;
    }
    /**
     * @return A start time block specifies the time that your contact center opens. The `start_time` is documented below.
     * 
     */
    public HoursOfOperationConfigStartTime startTime() {
        return this.startTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(HoursOfOperationConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String day;
        private HoursOfOperationConfigEndTime endTime;
        private HoursOfOperationConfigStartTime startTime;
        public Builder() {}
        public Builder(HoursOfOperationConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.day = defaults.day;
    	      this.endTime = defaults.endTime;
    	      this.startTime = defaults.startTime;
        }

        @CustomType.Setter
        public Builder day(String day) {
            if (day == null) {
              throw new MissingRequiredPropertyException("HoursOfOperationConfig", "day");
            }
            this.day = day;
            return this;
        }
        @CustomType.Setter
        public Builder endTime(HoursOfOperationConfigEndTime endTime) {
            if (endTime == null) {
              throw new MissingRequiredPropertyException("HoursOfOperationConfig", "endTime");
            }
            this.endTime = endTime;
            return this;
        }
        @CustomType.Setter
        public Builder startTime(HoursOfOperationConfigStartTime startTime) {
            if (startTime == null) {
              throw new MissingRequiredPropertyException("HoursOfOperationConfig", "startTime");
            }
            this.startTime = startTime;
            return this;
        }
        public HoursOfOperationConfig build() {
            final var _resultValue = new HoursOfOperationConfig();
            _resultValue.day = day;
            _resultValue.endTime = endTime;
            _resultValue.startTime = startTime;
            return _resultValue;
        }
    }
}
