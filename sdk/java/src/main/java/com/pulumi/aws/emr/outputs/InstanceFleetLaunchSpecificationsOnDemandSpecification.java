// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.emr.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class InstanceFleetLaunchSpecificationsOnDemandSpecification {
    /**
     * @return Specifies one of the following strategies to launch Spot Instance fleets: `price-capacity-optimized`, `capacity-optimized`, `lowest-price`, or `diversified`. For more information on the provisioning strategies, see [Allocation strategies for Spot Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-fleet-allocation-strategy.html).
     * 
     */
    private String allocationStrategy;

    private InstanceFleetLaunchSpecificationsOnDemandSpecification() {}
    /**
     * @return Specifies one of the following strategies to launch Spot Instance fleets: `price-capacity-optimized`, `capacity-optimized`, `lowest-price`, or `diversified`. For more information on the provisioning strategies, see [Allocation strategies for Spot Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-fleet-allocation-strategy.html).
     * 
     */
    public String allocationStrategy() {
        return this.allocationStrategy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(InstanceFleetLaunchSpecificationsOnDemandSpecification defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String allocationStrategy;
        public Builder() {}
        public Builder(InstanceFleetLaunchSpecificationsOnDemandSpecification defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.allocationStrategy = defaults.allocationStrategy;
        }

        @CustomType.Setter
        public Builder allocationStrategy(String allocationStrategy) {
            if (allocationStrategy == null) {
              throw new MissingRequiredPropertyException("InstanceFleetLaunchSpecificationsOnDemandSpecification", "allocationStrategy");
            }
            this.allocationStrategy = allocationStrategy;
            return this;
        }
        public InstanceFleetLaunchSpecificationsOnDemandSpecification build() {
            final var _resultValue = new InstanceFleetLaunchSpecificationsOnDemandSpecification();
            _resultValue.allocationStrategy = allocationStrategy;
            return _resultValue;
        }
    }
}
