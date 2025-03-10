// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class MetricStreamExcludeFilter {
    /**
     * @return An array that defines the metrics you want to exclude for this metric namespace
     * 
     */
    private @Nullable List<String> metricNames;
    /**
     * @return Name of the metric namespace in the filter.
     * 
     */
    private String namespace;

    private MetricStreamExcludeFilter() {}
    /**
     * @return An array that defines the metrics you want to exclude for this metric namespace
     * 
     */
    public List<String> metricNames() {
        return this.metricNames == null ? List.of() : this.metricNames;
    }
    /**
     * @return Name of the metric namespace in the filter.
     * 
     */
    public String namespace() {
        return this.namespace;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MetricStreamExcludeFilter defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<String> metricNames;
        private String namespace;
        public Builder() {}
        public Builder(MetricStreamExcludeFilter defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.metricNames = defaults.metricNames;
    	      this.namespace = defaults.namespace;
        }

        @CustomType.Setter
        public Builder metricNames(@Nullable List<String> metricNames) {

            this.metricNames = metricNames;
            return this;
        }
        public Builder metricNames(String... metricNames) {
            return metricNames(List.of(metricNames));
        }
        @CustomType.Setter
        public Builder namespace(String namespace) {
            if (namespace == null) {
              throw new MissingRequiredPropertyException("MetricStreamExcludeFilter", "namespace");
            }
            this.namespace = namespace;
            return this;
        }
        public MetricStreamExcludeFilter build() {
            final var _resultValue = new MetricStreamExcludeFilter();
            _resultValue.metricNames = metricNames;
            _resultValue.namespace = namespace;
            return _resultValue;
        }
    }
}
