// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetRecordsResourceRecordSetGeolocation {
    /**
     * @return The two-letter code for the continent.
     * 
     */
    private String continentCode;
    /**
     * @return The two-letter code for a country.
     * 
     */
    private String countryCode;
    /**
     * @return The two-letter code for a state of the United States.
     * 
     */
    private String subdivisionCode;

    private GetRecordsResourceRecordSetGeolocation() {}
    /**
     * @return The two-letter code for the continent.
     * 
     */
    public String continentCode() {
        return this.continentCode;
    }
    /**
     * @return The two-letter code for a country.
     * 
     */
    public String countryCode() {
        return this.countryCode;
    }
    /**
     * @return The two-letter code for a state of the United States.
     * 
     */
    public String subdivisionCode() {
        return this.subdivisionCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetRecordsResourceRecordSetGeolocation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String continentCode;
        private String countryCode;
        private String subdivisionCode;
        public Builder() {}
        public Builder(GetRecordsResourceRecordSetGeolocation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.continentCode = defaults.continentCode;
    	      this.countryCode = defaults.countryCode;
    	      this.subdivisionCode = defaults.subdivisionCode;
        }

        @CustomType.Setter
        public Builder continentCode(String continentCode) {
            if (continentCode == null) {
              throw new MissingRequiredPropertyException("GetRecordsResourceRecordSetGeolocation", "continentCode");
            }
            this.continentCode = continentCode;
            return this;
        }
        @CustomType.Setter
        public Builder countryCode(String countryCode) {
            if (countryCode == null) {
              throw new MissingRequiredPropertyException("GetRecordsResourceRecordSetGeolocation", "countryCode");
            }
            this.countryCode = countryCode;
            return this;
        }
        @CustomType.Setter
        public Builder subdivisionCode(String subdivisionCode) {
            if (subdivisionCode == null) {
              throw new MissingRequiredPropertyException("GetRecordsResourceRecordSetGeolocation", "subdivisionCode");
            }
            this.subdivisionCode = subdivisionCode;
            return this;
        }
        public GetRecordsResourceRecordSetGeolocation build() {
            final var _resultValue = new GetRecordsResourceRecordSetGeolocation();
            _resultValue.continentCode = continentCode;
            _resultValue.countryCode = countryCode;
            _resultValue.subdivisionCode = subdivisionCode;
            return _resultValue;
        }
    }
}
