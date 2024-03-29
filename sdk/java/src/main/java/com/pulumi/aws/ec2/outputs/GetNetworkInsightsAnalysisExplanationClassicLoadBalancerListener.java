// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class GetNetworkInsightsAnalysisExplanationClassicLoadBalancerListener {
    private Integer instancePort;
    private Integer loadBalancerPort;

    private GetNetworkInsightsAnalysisExplanationClassicLoadBalancerListener() {}
    public Integer instancePort() {
        return this.instancePort;
    }
    public Integer loadBalancerPort() {
        return this.loadBalancerPort;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetNetworkInsightsAnalysisExplanationClassicLoadBalancerListener defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer instancePort;
        private Integer loadBalancerPort;
        public Builder() {}
        public Builder(GetNetworkInsightsAnalysisExplanationClassicLoadBalancerListener defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.instancePort = defaults.instancePort;
    	      this.loadBalancerPort = defaults.loadBalancerPort;
        }

        @CustomType.Setter
        public Builder instancePort(Integer instancePort) {
            if (instancePort == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisExplanationClassicLoadBalancerListener", "instancePort");
            }
            this.instancePort = instancePort;
            return this;
        }
        @CustomType.Setter
        public Builder loadBalancerPort(Integer loadBalancerPort) {
            if (loadBalancerPort == null) {
              throw new MissingRequiredPropertyException("GetNetworkInsightsAnalysisExplanationClassicLoadBalancerListener", "loadBalancerPort");
            }
            this.loadBalancerPort = loadBalancerPort;
            return this;
        }
        public GetNetworkInsightsAnalysisExplanationClassicLoadBalancerListener build() {
            final var _resultValue = new GetNetworkInsightsAnalysisExplanationClassicLoadBalancerListener();
            _resultValue.instancePort = instancePort;
            _resultValue.loadBalancerPort = loadBalancerPort;
            return _resultValue;
        }
    }
}
