// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class FleetLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCount {
    /**
     * @return The maximum number of network interfaces. To specify no maximum limit, omit this parameter.
     * 
     */
    private @Nullable Integer max;
    /**
     * @return The minimum number of network interfaces. To specify no minimum limit, omit this parameter.
     * 
     */
    private @Nullable Integer min;

    private FleetLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCount() {}
    /**
     * @return The maximum number of network interfaces. To specify no maximum limit, omit this parameter.
     * 
     */
    public Optional<Integer> max() {
        return Optional.ofNullable(this.max);
    }
    /**
     * @return The minimum number of network interfaces. To specify no minimum limit, omit this parameter.
     * 
     */
    public Optional<Integer> min() {
        return Optional.ofNullable(this.min);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FleetLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCount defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer max;
        private @Nullable Integer min;
        public Builder() {}
        public Builder(FleetLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCount defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.max = defaults.max;
    	      this.min = defaults.min;
        }

        @CustomType.Setter
        public Builder max(@Nullable Integer max) {

            this.max = max;
            return this;
        }
        @CustomType.Setter
        public Builder min(@Nullable Integer min) {

            this.min = min;
            return this;
        }
        public FleetLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCount build() {
            final var _resultValue = new FleetLaunchTemplateConfigOverrideInstanceRequirementsNetworkInterfaceCount();
            _resultValue.max = max;
            _resultValue.min = min;
            return _resultValue;
        }
    }
}
