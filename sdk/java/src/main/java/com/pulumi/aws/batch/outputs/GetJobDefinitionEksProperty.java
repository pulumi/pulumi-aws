// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.aws.batch.outputs.GetJobDefinitionEksPropertyPodProperty;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetJobDefinitionEksProperty {
    /**
     * @return The properties for the Kubernetes pod resources of a job.
     * 
     */
    private List<GetJobDefinitionEksPropertyPodProperty> podProperties;

    private GetJobDefinitionEksProperty() {}
    /**
     * @return The properties for the Kubernetes pod resources of a job.
     * 
     */
    public List<GetJobDefinitionEksPropertyPodProperty> podProperties() {
        return this.podProperties;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetJobDefinitionEksProperty defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetJobDefinitionEksPropertyPodProperty> podProperties;
        public Builder() {}
        public Builder(GetJobDefinitionEksProperty defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.podProperties = defaults.podProperties;
        }

        @CustomType.Setter
        public Builder podProperties(List<GetJobDefinitionEksPropertyPodProperty> podProperties) {
            if (podProperties == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionEksProperty", "podProperties");
            }
            this.podProperties = podProperties;
            return this;
        }
        public Builder podProperties(GetJobDefinitionEksPropertyPodProperty... podProperties) {
            return podProperties(List.of(podProperties));
        }
        public GetJobDefinitionEksProperty build() {
            final var _resultValue = new GetJobDefinitionEksProperty();
            _resultValue.podProperties = podProperties;
            return _resultValue;
        }
    }
}
