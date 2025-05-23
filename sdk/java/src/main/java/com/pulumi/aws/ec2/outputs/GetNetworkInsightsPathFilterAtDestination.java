// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.GetNetworkInsightsPathFilterAtDestinationDestinationPortRange;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsPathFilterAtDestinationSourcePortRange;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetNetworkInsightsPathFilterAtDestination {
    private String destinationAddress;
    private List<GetNetworkInsightsPathFilterAtDestinationDestinationPortRange> destinationPortRanges;
    private String sourceAddress;
    private List<GetNetworkInsightsPathFilterAtDestinationSourcePortRange> sourcePortRanges;

    private GetNetworkInsightsPathFilterAtDestination() {}
    public String destinationAddress() {
        return this.destinationAddress;
    }
    public List<GetNetworkInsightsPathFilterAtDestinationDestinationPortRange> destinationPortRanges() {
        return this.destinationPortRanges;
    }
    public String sourceAddress() {
        return this.sourceAddress;
    }
    public List<GetNetworkInsightsPathFilterAtDestinationSourcePortRange> sourcePortRanges() {
        return this.sourcePortRanges;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetNetworkInsightsPathFilterAtDestination defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String destinationAddress;
        private List<GetNetworkInsightsPathFilterAtDestinationDestinationPortRange> destinationPortRanges;
        private String sourceAddress;
        private List<GetNetworkInsightsPathFilterAtDestinationSourcePortRange> sourcePortRanges;
        public Builder() {}
        public Builder(GetNetworkInsightsPathFilterAtDestination defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.destinationAddress = defaults.destinationAddress;
    	      this.destinationPortRanges = defaults.destinationPortRanges;
    	      this.sourceAddress = defaults.sourceAddress;
    	      this.sourcePortRanges = defaults.sourcePortRanges;
        }

        @CustomType.Setter
        public Builder destinationAddress(String destinationAddress) {
            if (destinationAddress == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsPathFilterAtDestination", "destinationAddress");
            }
            this.destinationAddress = destinationAddress;
            return this;
        }
        @CustomType.Setter
        public Builder destinationPortRanges(List<GetNetworkInsightsPathFilterAtDestinationDestinationPortRange> destinationPortRanges) {
            if (destinationPortRanges == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsPathFilterAtDestination", "destinationPortRanges");
            }
            this.destinationPortRanges = destinationPortRanges;
            return this;
        }
        public Builder destinationPortRanges(GetNetworkInsightsPathFilterAtDestinationDestinationPortRange... destinationPortRanges) {
            return destinationPortRanges(List.of(destinationPortRanges));
        }
        @CustomType.Setter
        public Builder sourceAddress(String sourceAddress) {
            if (sourceAddress == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsPathFilterAtDestination", "sourceAddress");
            }
            this.sourceAddress = sourceAddress;
            return this;
        }
        @CustomType.Setter
        public Builder sourcePortRanges(List<GetNetworkInsightsPathFilterAtDestinationSourcePortRange> sourcePortRanges) {
            if (sourcePortRanges == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsPathFilterAtDestination", "sourcePortRanges");
            }
            this.sourcePortRanges = sourcePortRanges;
            return this;
        }
        public Builder sourcePortRanges(GetNetworkInsightsPathFilterAtDestinationSourcePortRange... sourcePortRanges) {
            return sourcePortRanges(List.of(sourcePortRanges));
        }
        public GetNetworkInsightsPathFilterAtDestination build() {
            final var _resultValue = new GetNetworkInsightsPathFilterAtDestination();
            _resultValue.destinationAddress = destinationAddress;
            _resultValue.destinationPortRanges = destinationPortRanges;
            _resultValue.sourceAddress = sourceAddress;
            _resultValue.sourcePortRanges = sourcePortRanges;
            return _resultValue;
        }
    }
}
