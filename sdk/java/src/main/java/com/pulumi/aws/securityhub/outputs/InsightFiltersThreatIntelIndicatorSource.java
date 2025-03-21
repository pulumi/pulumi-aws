// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securityhub.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class InsightFiltersThreatIntelIndicatorSource {
    private String comparison;
    private String value;

    private InsightFiltersThreatIntelIndicatorSource() {}
    public String comparison() {
        return this.comparison;
    }
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(InsightFiltersThreatIntelIndicatorSource defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String comparison;
        private String value;
        public Builder() {}
        public Builder(InsightFiltersThreatIntelIndicatorSource defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.comparison = defaults.comparison;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder comparison(String comparison) {
            if (comparison == null) {
              throw new MissingRequiredPropertyException("InsightFiltersThreatIntelIndicatorSource", "comparison");
            }
            this.comparison = comparison;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("InsightFiltersThreatIntelIndicatorSource", "value");
            }
            this.value = value;
            return this;
        }
        public InsightFiltersThreatIntelIndicatorSource build() {
            final var _resultValue = new InsightFiltersThreatIntelIndicatorSource();
            _resultValue.comparison = comparison;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
