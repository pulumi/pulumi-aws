// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRange;
import com.pulumi.aws.ec2.outputs.GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRange;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetNetworkInsightsAnalysisForwardPathComponentInboundHeader {
    private List<String> destinationAddresses;
    private List<GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRange> destinationPortRanges;
    private String protocol;
    private List<String> sourceAddresses;
    private List<GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRange> sourcePortRanges;

    private GetNetworkInsightsAnalysisForwardPathComponentInboundHeader() {}
    public List<String> destinationAddresses() {
        return this.destinationAddresses;
    }
    public List<GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRange> destinationPortRanges() {
        return this.destinationPortRanges;
    }
    public String protocol() {
        return this.protocol;
    }
    public List<String> sourceAddresses() {
        return this.sourceAddresses;
    }
    public List<GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRange> sourcePortRanges() {
        return this.sourcePortRanges;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetNetworkInsightsAnalysisForwardPathComponentInboundHeader defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> destinationAddresses;
        private List<GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRange> destinationPortRanges;
        private String protocol;
        private List<String> sourceAddresses;
        private List<GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRange> sourcePortRanges;
        public Builder() {}
        public Builder(GetNetworkInsightsAnalysisForwardPathComponentInboundHeader defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.destinationAddresses = defaults.destinationAddresses;
    	      this.destinationPortRanges = defaults.destinationPortRanges;
    	      this.protocol = defaults.protocol;
    	      this.sourceAddresses = defaults.sourceAddresses;
    	      this.sourcePortRanges = defaults.sourcePortRanges;
        }

        @CustomType.Setter
        public Builder destinationAddresses(List<String> destinationAddresses) {
            if (destinationAddresses == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisForwardPathComponentInboundHeader", "destinationAddresses");
            }
            this.destinationAddresses = destinationAddresses;
            return this;
        }
        public Builder destinationAddresses(String... destinationAddresses) {
            return destinationAddresses(List.of(destinationAddresses));
        }
        @CustomType.Setter
        public Builder destinationPortRanges(List<GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRange> destinationPortRanges) {
            if (destinationPortRanges == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisForwardPathComponentInboundHeader", "destinationPortRanges");
            }
            this.destinationPortRanges = destinationPortRanges;
            return this;
        }
        public Builder destinationPortRanges(GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRange... destinationPortRanges) {
            return destinationPortRanges(List.of(destinationPortRanges));
        }
        @CustomType.Setter
        public Builder protocol(String protocol) {
            if (protocol == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisForwardPathComponentInboundHeader", "protocol");
            }
            this.protocol = protocol;
            return this;
        }
        @CustomType.Setter
        public Builder sourceAddresses(List<String> sourceAddresses) {
            if (sourceAddresses == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisForwardPathComponentInboundHeader", "sourceAddresses");
            }
            this.sourceAddresses = sourceAddresses;
            return this;
        }
        public Builder sourceAddresses(String... sourceAddresses) {
            return sourceAddresses(List.of(sourceAddresses));
        }
        @CustomType.Setter
        public Builder sourcePortRanges(List<GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRange> sourcePortRanges) {
            if (sourcePortRanges == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisForwardPathComponentInboundHeader", "sourcePortRanges");
            }
            this.sourcePortRanges = sourcePortRanges;
            return this;
        }
        public Builder sourcePortRanges(GetNetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRange... sourcePortRanges) {
            return sourcePortRanges(List.of(sourcePortRanges));
        }
        public GetNetworkInsightsAnalysisForwardPathComponentInboundHeader build() {
            final var _resultValue = new GetNetworkInsightsAnalysisForwardPathComponentInboundHeader();
            _resultValue.destinationAddresses = destinationAddresses;
            _resultValue.destinationPortRanges = destinationPortRanges;
            _resultValue.protocol = protocol;
            _resultValue.sourceAddresses = sourceAddresses;
            _resultValue.sourcePortRanges = sourcePortRanges;
            return _resultValue;
        }
    }
}
