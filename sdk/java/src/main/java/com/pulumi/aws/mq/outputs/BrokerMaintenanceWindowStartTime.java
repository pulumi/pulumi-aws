// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.mq.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class BrokerMaintenanceWindowStartTime {
    /**
     * @return Day of the week, e.g., `MONDAY`, `TUESDAY`, or `WEDNESDAY`.
     * 
     */
    private String dayOfWeek;
    /**
     * @return Time, in 24-hour format, e.g., `02:00`.
     * 
     */
    private String timeOfDay;
    /**
     * @return Time zone in either the Country/City format or the UTC offset format, e.g., `CET`.
     * 
     */
    private String timeZone;

    private BrokerMaintenanceWindowStartTime() {}
    /**
     * @return Day of the week, e.g., `MONDAY`, `TUESDAY`, or `WEDNESDAY`.
     * 
     */
    public String dayOfWeek() {
        return this.dayOfWeek;
    }
    /**
     * @return Time, in 24-hour format, e.g., `02:00`.
     * 
     */
    public String timeOfDay() {
        return this.timeOfDay;
    }
    /**
     * @return Time zone in either the Country/City format or the UTC offset format, e.g., `CET`.
     * 
     */
    public String timeZone() {
        return this.timeZone;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(BrokerMaintenanceWindowStartTime defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String dayOfWeek;
        private String timeOfDay;
        private String timeZone;
        public Builder() {}
        public Builder(BrokerMaintenanceWindowStartTime defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.dayOfWeek = defaults.dayOfWeek;
    	      this.timeOfDay = defaults.timeOfDay;
    	      this.timeZone = defaults.timeZone;
        }

        @CustomType.Setter
        public Builder dayOfWeek(String dayOfWeek) {
            if (dayOfWeek == null) {
              throw new MissingRequiredPropertyException("BrokerMaintenanceWindowStartTime", "dayOfWeek");
            }
            this.dayOfWeek = dayOfWeek;
            return this;
        }
        @CustomType.Setter
        public Builder timeOfDay(String timeOfDay) {
            if (timeOfDay == null) {
              throw new MissingRequiredPropertyException("BrokerMaintenanceWindowStartTime", "timeOfDay");
            }
            this.timeOfDay = timeOfDay;
            return this;
        }
        @CustomType.Setter
        public Builder timeZone(String timeZone) {
            if (timeZone == null) {
              throw new MissingRequiredPropertyException("BrokerMaintenanceWindowStartTime", "timeZone");
            }
            this.timeZone = timeZone;
            return this;
        }
        public BrokerMaintenanceWindowStartTime build() {
            final var _resultValue = new BrokerMaintenanceWindowStartTime();
            _resultValue.dayOfWeek = dayOfWeek;
            _resultValue.timeOfDay = timeOfDay;
            _resultValue.timeZone = timeZone;
            return _resultValue;
        }
    }
}
