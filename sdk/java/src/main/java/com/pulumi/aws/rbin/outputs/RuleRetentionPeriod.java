// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rbin.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class RuleRetentionPeriod {
    /**
     * @return The unit of time in which the retention period is measured. Currently, only DAYS is supported.
     * 
     */
    private String retentionPeriodUnit;
    /**
     * @return The period value for which the retention rule is to retain resources. The period is measured using the unit specified for RetentionPeriodUnit.
     * 
     */
    private Integer retentionPeriodValue;

    private RuleRetentionPeriod() {}
    /**
     * @return The unit of time in which the retention period is measured. Currently, only DAYS is supported.
     * 
     */
    public String retentionPeriodUnit() {
        return this.retentionPeriodUnit;
    }
    /**
     * @return The period value for which the retention rule is to retain resources. The period is measured using the unit specified for RetentionPeriodUnit.
     * 
     */
    public Integer retentionPeriodValue() {
        return this.retentionPeriodValue;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RuleRetentionPeriod defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String retentionPeriodUnit;
        private Integer retentionPeriodValue;
        public Builder() {}
        public Builder(RuleRetentionPeriod defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.retentionPeriodUnit = defaults.retentionPeriodUnit;
    	      this.retentionPeriodValue = defaults.retentionPeriodValue;
        }

        @CustomType.Setter
        public Builder retentionPeriodUnit(String retentionPeriodUnit) {
            if (retentionPeriodUnit == null) {
              throw new MissingRequiredPropertyException("RuleRetentionPeriod", "retentionPeriodUnit");
            }
            this.retentionPeriodUnit = retentionPeriodUnit;
            return this;
        }
        @CustomType.Setter
        public Builder retentionPeriodValue(Integer retentionPeriodValue) {
            if (retentionPeriodValue == null) {
              throw new MissingRequiredPropertyException("RuleRetentionPeriod", "retentionPeriodValue");
            }
            this.retentionPeriodValue = retentionPeriodValue;
            return this;
        }
        public RuleRetentionPeriod build() {
            final var _resultValue = new RuleRetentionPeriod();
            _resultValue.retentionPeriodUnit = retentionPeriodUnit;
            _resultValue.retentionPeriodValue = retentionPeriodValue;
            return _resultValue;
        }
    }
}
