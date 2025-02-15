// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class JobDefinitionEksPropertiesPodPropertiesMetadata {
    /**
     * @return Key-value pairs used to identify, sort, and organize cube resources.
     * 
     */
    private @Nullable Map<String,String> labels;

    private JobDefinitionEksPropertiesPodPropertiesMetadata() {}
    /**
     * @return Key-value pairs used to identify, sort, and organize cube resources.
     * 
     */
    public Map<String,String> labels() {
        return this.labels == null ? Map.of() : this.labels;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(JobDefinitionEksPropertiesPodPropertiesMetadata defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Map<String,String> labels;
        public Builder() {}
        public Builder(JobDefinitionEksPropertiesPodPropertiesMetadata defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.labels = defaults.labels;
        }

        @CustomType.Setter
        public Builder labels(@Nullable Map<String,String> labels) {

            this.labels = labels;
            return this;
        }
        public JobDefinitionEksPropertiesPodPropertiesMetadata build() {
            final var _resultValue = new JobDefinitionEksPropertiesPodPropertiesMetadata();
            _resultValue.labels = labels;
            return _resultValue;
        }
    }
}
