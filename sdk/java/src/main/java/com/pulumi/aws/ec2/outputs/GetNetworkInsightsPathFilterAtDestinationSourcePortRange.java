// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class GetNetworkInsightsPathFilterAtDestinationSourcePortRange {
    private Integer fromPort;
    private Integer toPort;

    private GetNetworkInsightsPathFilterAtDestinationSourcePortRange() {}
    public Integer fromPort() {
        return this.fromPort;
    }
    public Integer toPort() {
        return this.toPort;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetNetworkInsightsPathFilterAtDestinationSourcePortRange defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer fromPort;
        private Integer toPort;
        public Builder() {}
        public Builder(GetNetworkInsightsPathFilterAtDestinationSourcePortRange defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.fromPort = defaults.fromPort;
    	      this.toPort = defaults.toPort;
        }

        @CustomType.Setter
        public Builder fromPort(Integer fromPort) {
            if (fromPort == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsPathFilterAtDestinationSourcePortRange", "fromPort");
            }
            this.fromPort = fromPort;
            return this;
        }
        @CustomType.Setter
        public Builder toPort(Integer toPort) {
            if (toPort == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsPathFilterAtDestinationSourcePortRange", "toPort");
            }
            this.toPort = toPort;
            return this;
        }
        public GetNetworkInsightsPathFilterAtDestinationSourcePortRange build() {
            final var _resultValue = new GetNetworkInsightsPathFilterAtDestinationSourcePortRange();
            _resultValue.fromPort = fromPort;
            _resultValue.toPort = toPort;
            return _resultValue;
        }
    }
}
