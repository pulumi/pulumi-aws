// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.util.Objects;

@CustomType
public final class GetJobDefinitionNodePropertyNodeRangePropertyContainerNetworkConfiguration {
    /**
     * @return Indicates whether the job has a public IP address.
     * 
     */
    private Boolean assignPublicIp;

    private GetJobDefinitionNodePropertyNodeRangePropertyContainerNetworkConfiguration() {}
    /**
     * @return Indicates whether the job has a public IP address.
     * 
     */
    public Boolean assignPublicIp() {
        return this.assignPublicIp;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetJobDefinitionNodePropertyNodeRangePropertyContainerNetworkConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean assignPublicIp;
        public Builder() {}
        public Builder(GetJobDefinitionNodePropertyNodeRangePropertyContainerNetworkConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.assignPublicIp = defaults.assignPublicIp;
        }

        @CustomType.Setter
        public Builder assignPublicIp(Boolean assignPublicIp) {
            if (assignPublicIp == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionNodePropertyNodeRangePropertyContainerNetworkConfiguration", "assignPublicIp");
            }
            this.assignPublicIp = assignPublicIp;
            return this;
        }
        public GetJobDefinitionNodePropertyNodeRangePropertyContainerNetworkConfiguration build() {
            final var _resultValue = new GetJobDefinitionNodePropertyNodeRangePropertyContainerNetworkConfiguration();
            _resultValue.assignPublicIp = assignPublicIp;
            return _resultValue;
        }
    }
}
