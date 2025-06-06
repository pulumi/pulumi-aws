// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.inspector2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Double;
import java.util.Objects;

@CustomType
public final class FilterFilterCriteriaInspectorScore {
    /**
     * @return (Optional) Lower bound of the range, inclusive.
     * 
     */
    private Double lowerInclusive;
    /**
     * @return (Optional) Upper bound of the range, inclusive.
     * 
     */
    private Double upperInclusive;

    private FilterFilterCriteriaInspectorScore() {}
    /**
     * @return (Optional) Lower bound of the range, inclusive.
     * 
     */
    public Double lowerInclusive() {
        return this.lowerInclusive;
    }
    /**
     * @return (Optional) Upper bound of the range, inclusive.
     * 
     */
    public Double upperInclusive() {
        return this.upperInclusive;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FilterFilterCriteriaInspectorScore defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Double lowerInclusive;
        private Double upperInclusive;
        public Builder() {}
        public Builder(FilterFilterCriteriaInspectorScore defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.lowerInclusive = defaults.lowerInclusive;
    	      this.upperInclusive = defaults.upperInclusive;
        }

        @CustomType.Setter
        public Builder lowerInclusive(Double lowerInclusive) {
            if (lowerInclusive == null) {
              throw new MissingRequiredPropertyException("FilterFilterCriteriaInspectorScore", "lowerInclusive");
            }
            this.lowerInclusive = lowerInclusive;
            return this;
        }
        @CustomType.Setter
        public Builder upperInclusive(Double upperInclusive) {
            if (upperInclusive == null) {
              throw new MissingRequiredPropertyException("FilterFilterCriteriaInspectorScore", "upperInclusive");
            }
            this.upperInclusive = upperInclusive;
            return this;
        }
        public FilterFilterCriteriaInspectorScore build() {
            final var _resultValue = new FilterFilterCriteriaInspectorScore();
            _resultValue.lowerInclusive = lowerInclusive;
            _resultValue.upperInclusive = upperInclusive;
            return _resultValue;
        }
    }
}
