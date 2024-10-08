// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecs.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ServiceVolumeConfigurationManagedEbsVolumeTagSpecification {
    /**
     * @return Determines whether to propagate the tags from the task definition to the Amazon EBS volume.
     * 
     */
    private @Nullable String propagateTags;
    /**
     * @return The type of volume resource. Valid values, `volume`.
     * 
     */
    private String resourceType;
    /**
     * @return The tags applied to this Amazon EBS volume. `AmazonECSCreated` and `AmazonECSManaged` are reserved tags that can&#39;t be used.
     * 
     */
    private @Nullable Map<String,String> tags;

    private ServiceVolumeConfigurationManagedEbsVolumeTagSpecification() {}
    /**
     * @return Determines whether to propagate the tags from the task definition to the Amazon EBS volume.
     * 
     */
    public Optional<String> propagateTags() {
        return Optional.ofNullable(this.propagateTags);
    }
    /**
     * @return The type of volume resource. Valid values, `volume`.
     * 
     */
    public String resourceType() {
        return this.resourceType;
    }
    /**
     * @return The tags applied to this Amazon EBS volume. `AmazonECSCreated` and `AmazonECSManaged` are reserved tags that can&#39;t be used.
     * 
     */
    public Map<String,String> tags() {
        return this.tags == null ? Map.of() : this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ServiceVolumeConfigurationManagedEbsVolumeTagSpecification defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String propagateTags;
        private String resourceType;
        private @Nullable Map<String,String> tags;
        public Builder() {}
        public Builder(ServiceVolumeConfigurationManagedEbsVolumeTagSpecification defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.propagateTags = defaults.propagateTags;
    	      this.resourceType = defaults.resourceType;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder propagateTags(@Nullable String propagateTags) {

            this.propagateTags = propagateTags;
            return this;
        }
        @CustomType.Setter
        public Builder resourceType(String resourceType) {
            if (resourceType == null) {
              throw new MissingRequiredPropertyException("ServiceVolumeConfigurationManagedEbsVolumeTagSpecification", "resourceType");
            }
            this.resourceType = resourceType;
            return this;
        }
        @CustomType.Setter
        public Builder tags(@Nullable Map<String,String> tags) {

            this.tags = tags;
            return this;
        }
        public ServiceVolumeConfigurationManagedEbsVolumeTagSpecification build() {
            final var _resultValue = new ServiceVolumeConfigurationManagedEbsVolumeTagSpecification();
            _resultValue.propagateTags = propagateTags;
            _resultValue.resourceType = resourceType;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
