// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.inspector2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class FilterFilterCriteriaResourceTag {
    /**
     * @return (Required) The comparison operator. Valid values: `EQUALS`.
     * 
     */
    private String comparison;
    /**
     * @return (Required) The key to filter on.
     * 
     */
    private String key;
    /**
     * @return (Required) The value to filter on.
     * 
     */
    private String value;

    private FilterFilterCriteriaResourceTag() {}
    /**
     * @return (Required) The comparison operator. Valid values: `EQUALS`.
     * 
     */
    public String comparison() {
        return this.comparison;
    }
    /**
     * @return (Required) The key to filter on.
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return (Required) The value to filter on.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FilterFilterCriteriaResourceTag defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String comparison;
        private String key;
        private String value;
        public Builder() {}
        public Builder(FilterFilterCriteriaResourceTag defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.comparison = defaults.comparison;
    	      this.key = defaults.key;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder comparison(String comparison) {
            if (comparison == null) {
              throw new MissingRequiredPropertyException("FilterFilterCriteriaResourceTag", "comparison");
            }
            this.comparison = comparison;
            return this;
        }
        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("FilterFilterCriteriaResourceTag", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("FilterFilterCriteriaResourceTag", "value");
            }
            this.value = value;
            return this;
        }
        public FilterFilterCriteriaResourceTag build() {
            final var _resultValue = new FilterFilterCriteriaResourceTag();
            _resultValue.comparison = comparison;
            _resultValue.key = key;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
