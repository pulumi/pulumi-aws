// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.FleetOnDemandOptionsCapacityReservationOptions;
import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class FleetOnDemandOptions {
    /**
     * @return The order of the launch template overrides to use in fulfilling On-Demand capacity. Valid values: `lowestPrice`, `prioritized`. Default: `lowestPrice`.
     * 
     */
    private @Nullable String allocationStrategy;
    /**
     * @return The strategy for using unused Capacity Reservations for fulfilling On-Demand capacity. Supported only for fleets of type `instant`.
     * 
     */
    private @Nullable FleetOnDemandOptionsCapacityReservationOptions capacityReservationOptions;
    /**
     * @return The maximum amount per hour for On-Demand Instances that you&#39;re willing to pay.
     * 
     */
    private @Nullable String maxTotalPrice;
    /**
     * @return The minimum target capacity for On-Demand Instances in the fleet. If the minimum target capacity is not reached, the fleet launches no instances. Supported only for fleets of type `instant`.
     * If you specify `min_target_capacity`, at least one of the following must be specified: `single_availability_zone` or `single_instance_type`.
     * 
     */
    private @Nullable Integer minTargetCapacity;
    /**
     * @return Indicates that the fleet launches all On-Demand Instances into a single Availability Zone. Supported only for fleets of type `instant`.
     * 
     */
    private @Nullable Boolean singleAvailabilityZone;
    /**
     * @return Indicates that the fleet uses a single instance type to launch all On-Demand Instances in the fleet. Supported only for fleets of type `instant`.
     * 
     */
    private @Nullable Boolean singleInstanceType;

    private FleetOnDemandOptions() {}
    /**
     * @return The order of the launch template overrides to use in fulfilling On-Demand capacity. Valid values: `lowestPrice`, `prioritized`. Default: `lowestPrice`.
     * 
     */
    public Optional<String> allocationStrategy() {
        return Optional.ofNullable(this.allocationStrategy);
    }
    /**
     * @return The strategy for using unused Capacity Reservations for fulfilling On-Demand capacity. Supported only for fleets of type `instant`.
     * 
     */
    public Optional<FleetOnDemandOptionsCapacityReservationOptions> capacityReservationOptions() {
        return Optional.ofNullable(this.capacityReservationOptions);
    }
    /**
     * @return The maximum amount per hour for On-Demand Instances that you&#39;re willing to pay.
     * 
     */
    public Optional<String> maxTotalPrice() {
        return Optional.ofNullable(this.maxTotalPrice);
    }
    /**
     * @return The minimum target capacity for On-Demand Instances in the fleet. If the minimum target capacity is not reached, the fleet launches no instances. Supported only for fleets of type `instant`.
     * If you specify `min_target_capacity`, at least one of the following must be specified: `single_availability_zone` or `single_instance_type`.
     * 
     */
    public Optional<Integer> minTargetCapacity() {
        return Optional.ofNullable(this.minTargetCapacity);
    }
    /**
     * @return Indicates that the fleet launches all On-Demand Instances into a single Availability Zone. Supported only for fleets of type `instant`.
     * 
     */
    public Optional<Boolean> singleAvailabilityZone() {
        return Optional.ofNullable(this.singleAvailabilityZone);
    }
    /**
     * @return Indicates that the fleet uses a single instance type to launch all On-Demand Instances in the fleet. Supported only for fleets of type `instant`.
     * 
     */
    public Optional<Boolean> singleInstanceType() {
        return Optional.ofNullable(this.singleInstanceType);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FleetOnDemandOptions defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String allocationStrategy;
        private @Nullable FleetOnDemandOptionsCapacityReservationOptions capacityReservationOptions;
        private @Nullable String maxTotalPrice;
        private @Nullable Integer minTargetCapacity;
        private @Nullable Boolean singleAvailabilityZone;
        private @Nullable Boolean singleInstanceType;
        public Builder() {}
        public Builder(FleetOnDemandOptions defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.allocationStrategy = defaults.allocationStrategy;
    	      this.capacityReservationOptions = defaults.capacityReservationOptions;
    	      this.maxTotalPrice = defaults.maxTotalPrice;
    	      this.minTargetCapacity = defaults.minTargetCapacity;
    	      this.singleAvailabilityZone = defaults.singleAvailabilityZone;
    	      this.singleInstanceType = defaults.singleInstanceType;
        }

        @CustomType.Setter
        public Builder allocationStrategy(@Nullable String allocationStrategy) {

            this.allocationStrategy = allocationStrategy;
            return this;
        }
        @CustomType.Setter
        public Builder capacityReservationOptions(@Nullable FleetOnDemandOptionsCapacityReservationOptions capacityReservationOptions) {

            this.capacityReservationOptions = capacityReservationOptions;
            return this;
        }
        @CustomType.Setter
        public Builder maxTotalPrice(@Nullable String maxTotalPrice) {

            this.maxTotalPrice = maxTotalPrice;
            return this;
        }
        @CustomType.Setter
        public Builder minTargetCapacity(@Nullable Integer minTargetCapacity) {

            this.minTargetCapacity = minTargetCapacity;
            return this;
        }
        @CustomType.Setter
        public Builder singleAvailabilityZone(@Nullable Boolean singleAvailabilityZone) {

            this.singleAvailabilityZone = singleAvailabilityZone;
            return this;
        }
        @CustomType.Setter
        public Builder singleInstanceType(@Nullable Boolean singleInstanceType) {

            this.singleInstanceType = singleInstanceType;
            return this;
        }
        public FleetOnDemandOptions build() {
            final var _resultValue = new FleetOnDemandOptions();
            _resultValue.allocationStrategy = allocationStrategy;
            _resultValue.capacityReservationOptions = capacityReservationOptions;
            _resultValue.maxTotalPrice = maxTotalPrice;
            _resultValue.minTargetCapacity = minTargetCapacity;
            _resultValue.singleAvailabilityZone = singleAvailabilityZone;
            _resultValue.singleInstanceType = singleInstanceType;
            return _resultValue;
        }
    }
}
