// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.LaunchTemplateNetworkInterfaceEnaSrdSpecificationEnaSrdUdpSpecification;
import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class LaunchTemplateNetworkInterfaceEnaSrdSpecification {
    /**
     * @return Whether to enable ENA Express. ENA Express uses AWS Scalable Reliable Datagram (SRD) technology to improve the performance of TCP traffic.
     * 
     */
    private @Nullable Boolean enaSrdEnabled;
    /**
     * @return Configuration for ENA Express UDP optimization. See details below.
     * 
     */
    private @Nullable LaunchTemplateNetworkInterfaceEnaSrdSpecificationEnaSrdUdpSpecification enaSrdUdpSpecification;

    private LaunchTemplateNetworkInterfaceEnaSrdSpecification() {}
    /**
     * @return Whether to enable ENA Express. ENA Express uses AWS Scalable Reliable Datagram (SRD) technology to improve the performance of TCP traffic.
     * 
     */
    public Optional<Boolean> enaSrdEnabled() {
        return Optional.ofNullable(this.enaSrdEnabled);
    }
    /**
     * @return Configuration for ENA Express UDP optimization. See details below.
     * 
     */
    public Optional<LaunchTemplateNetworkInterfaceEnaSrdSpecificationEnaSrdUdpSpecification> enaSrdUdpSpecification() {
        return Optional.ofNullable(this.enaSrdUdpSpecification);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(LaunchTemplateNetworkInterfaceEnaSrdSpecification defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean enaSrdEnabled;
        private @Nullable LaunchTemplateNetworkInterfaceEnaSrdSpecificationEnaSrdUdpSpecification enaSrdUdpSpecification;
        public Builder() {}
        public Builder(LaunchTemplateNetworkInterfaceEnaSrdSpecification defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enaSrdEnabled = defaults.enaSrdEnabled;
    	      this.enaSrdUdpSpecification = defaults.enaSrdUdpSpecification;
        }

        @CustomType.Setter
        public Builder enaSrdEnabled(@Nullable Boolean enaSrdEnabled) {

            this.enaSrdEnabled = enaSrdEnabled;
            return this;
        }
        @CustomType.Setter
        public Builder enaSrdUdpSpecification(@Nullable LaunchTemplateNetworkInterfaceEnaSrdSpecificationEnaSrdUdpSpecification enaSrdUdpSpecification) {

            this.enaSrdUdpSpecification = enaSrdUdpSpecification;
            return this;
        }
        public LaunchTemplateNetworkInterfaceEnaSrdSpecification build() {
            final var _resultValue = new LaunchTemplateNetworkInterfaceEnaSrdSpecification();
            _resultValue.enaSrdEnabled = enaSrdEnabled;
            _resultValue.enaSrdUdpSpecification = enaSrdUdpSpecification;
            return _resultValue;
        }
    }
}
