// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetLaunchTemplateCapacityReservationSpecificationCapacityReservationTarget {
    private String capacityReservationId;
    private String capacityReservationResourceGroupArn;

    private GetLaunchTemplateCapacityReservationSpecificationCapacityReservationTarget() {}
    public String capacityReservationId() {
        return this.capacityReservationId;
    }
    public String capacityReservationResourceGroupArn() {
        return this.capacityReservationResourceGroupArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetLaunchTemplateCapacityReservationSpecificationCapacityReservationTarget defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String capacityReservationId;
        private String capacityReservationResourceGroupArn;
        public Builder() {}
        public Builder(GetLaunchTemplateCapacityReservationSpecificationCapacityReservationTarget defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.capacityReservationId = defaults.capacityReservationId;
    	      this.capacityReservationResourceGroupArn = defaults.capacityReservationResourceGroupArn;
        }

        @CustomType.Setter
        public Builder capacityReservationId(String capacityReservationId) {
            if (capacityReservationId == null) {
              throw new MissingRequiredPropertyException("GetLaunchTemplateCapacityReservationSpecificationCapacityReservationTarget", "capacityReservationId");
            }
            this.capacityReservationId = capacityReservationId;
            return this;
        }
        @CustomType.Setter
        public Builder capacityReservationResourceGroupArn(String capacityReservationResourceGroupArn) {
            if (capacityReservationResourceGroupArn == null) {
              throw new MissingRequiredPropertyException("GetLaunchTemplateCapacityReservationSpecificationCapacityReservationTarget", "capacityReservationResourceGroupArn");
            }
            this.capacityReservationResourceGroupArn = capacityReservationResourceGroupArn;
            return this;
        }
        public GetLaunchTemplateCapacityReservationSpecificationCapacityReservationTarget build() {
            final var _resultValue = new GetLaunchTemplateCapacityReservationSpecificationCapacityReservationTarget();
            _resultValue.capacityReservationId = capacityReservationId;
            _resultValue.capacityReservationResourceGroupArn = capacityReservationResourceGroupArn;
            return _resultValue;
        }
    }
}
