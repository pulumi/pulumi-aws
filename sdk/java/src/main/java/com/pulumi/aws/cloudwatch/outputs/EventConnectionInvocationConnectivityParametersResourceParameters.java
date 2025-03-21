// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class EventConnectionInvocationConnectivityParametersResourceParameters {
    private @Nullable String resourceAssociationArn;
    /**
     * @return ARN of the Amazon VPC Lattice resource configuration for the resource endpoint.
     * 
     */
    private String resourceConfigurationArn;

    private EventConnectionInvocationConnectivityParametersResourceParameters() {}
    public Optional<String> resourceAssociationArn() {
        return Optional.ofNullable(this.resourceAssociationArn);
    }
    /**
     * @return ARN of the Amazon VPC Lattice resource configuration for the resource endpoint.
     * 
     */
    public String resourceConfigurationArn() {
        return this.resourceConfigurationArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EventConnectionInvocationConnectivityParametersResourceParameters defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String resourceAssociationArn;
        private String resourceConfigurationArn;
        public Builder() {}
        public Builder(EventConnectionInvocationConnectivityParametersResourceParameters defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.resourceAssociationArn = defaults.resourceAssociationArn;
    	      this.resourceConfigurationArn = defaults.resourceConfigurationArn;
        }

        @CustomType.Setter
        public Builder resourceAssociationArn(@Nullable String resourceAssociationArn) {

            this.resourceAssociationArn = resourceAssociationArn;
            return this;
        }
        @CustomType.Setter
        public Builder resourceConfigurationArn(String resourceConfigurationArn) {
            if (resourceConfigurationArn == null) {
              throw new MissingRequiredPropertyException("EventConnectionInvocationConnectivityParametersResourceParameters", "resourceConfigurationArn");
            }
            this.resourceConfigurationArn = resourceConfigurationArn;
            return this;
        }
        public EventConnectionInvocationConnectivityParametersResourceParameters build() {
            final var _resultValue = new EventConnectionInvocationConnectivityParametersResourceParameters();
            _resultValue.resourceAssociationArn = resourceAssociationArn;
            _resultValue.resourceConfigurationArn = resourceConfigurationArn;
            return _resultValue;
        }
    }
}
