// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.licensemanager.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetReceivedLicenseEntitlement {
    /**
     * @return Indicates whether check-ins are allowed.
     * 
     */
    private Boolean allowCheckIn;
    /**
     * @return Maximum entitlement count. Use if the unit is not None.
     * 
     */
    private Integer maxCount;
    /**
     * @return The key name.
     * 
     */
    private String name;
    /**
     * @return Indicates whether overages are allowed.
     * 
     */
    private Boolean overage;
    /**
     * @return Entitlement unit.
     * 
     */
    private String unit;
    /**
     * @return The value.
     * 
     */
    private String value;

    private GetReceivedLicenseEntitlement() {}
    /**
     * @return Indicates whether check-ins are allowed.
     * 
     */
    public Boolean allowCheckIn() {
        return this.allowCheckIn;
    }
    /**
     * @return Maximum entitlement count. Use if the unit is not None.
     * 
     */
    public Integer maxCount() {
        return this.maxCount;
    }
    /**
     * @return The key name.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Indicates whether overages are allowed.
     * 
     */
    public Boolean overage() {
        return this.overage;
    }
    /**
     * @return Entitlement unit.
     * 
     */
    public String unit() {
        return this.unit;
    }
    /**
     * @return The value.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetReceivedLicenseEntitlement defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean allowCheckIn;
        private Integer maxCount;
        private String name;
        private Boolean overage;
        private String unit;
        private String value;
        public Builder() {}
        public Builder(GetReceivedLicenseEntitlement defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.allowCheckIn = defaults.allowCheckIn;
    	      this.maxCount = defaults.maxCount;
    	      this.name = defaults.name;
    	      this.overage = defaults.overage;
    	      this.unit = defaults.unit;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder allowCheckIn(Boolean allowCheckIn) {
            if (allowCheckIn == null) {
              throw new MissingRequiredPropertyException("GetReceivedLicenseEntitlement", "allowCheckIn");
            }
            this.allowCheckIn = allowCheckIn;
            return this;
        }
        @CustomType.Setter
        public Builder maxCount(Integer maxCount) {
            if (maxCount == null) {
              throw new MissingRequiredPropertyException("GetReceivedLicenseEntitlement", "maxCount");
            }
            this.maxCount = maxCount;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetReceivedLicenseEntitlement", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder overage(Boolean overage) {
            if (overage == null) {
              throw new MissingRequiredPropertyException("GetReceivedLicenseEntitlement", "overage");
            }
            this.overage = overage;
            return this;
        }
        @CustomType.Setter
        public Builder unit(String unit) {
            if (unit == null) {
              throw new MissingRequiredPropertyException("GetReceivedLicenseEntitlement", "unit");
            }
            this.unit = unit;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("GetReceivedLicenseEntitlement", "value");
            }
            this.value = value;
            return this;
        }
        public GetReceivedLicenseEntitlement build() {
            final var _resultValue = new GetReceivedLicenseEntitlement();
            _resultValue.allowCheckIn = allowCheckIn;
            _resultValue.maxCount = maxCount;
            _resultValue.name = name;
            _resultValue.overage = overage;
            _resultValue.unit = unit;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
