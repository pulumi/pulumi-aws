// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetRouteSpecHttpRouteTimeoutIdle;
import com.pulumi.aws.appmesh.outputs.GetRouteSpecHttpRouteTimeoutPerRequest;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetRouteSpecHttpRouteTimeout {
    private List<GetRouteSpecHttpRouteTimeoutIdle> idles;
    private List<GetRouteSpecHttpRouteTimeoutPerRequest> perRequests;

    private GetRouteSpecHttpRouteTimeout() {}
    public List<GetRouteSpecHttpRouteTimeoutIdle> idles() {
        return this.idles;
    }
    public List<GetRouteSpecHttpRouteTimeoutPerRequest> perRequests() {
        return this.perRequests;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetRouteSpecHttpRouteTimeout defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetRouteSpecHttpRouteTimeoutIdle> idles;
        private List<GetRouteSpecHttpRouteTimeoutPerRequest> perRequests;
        public Builder() {}
        public Builder(GetRouteSpecHttpRouteTimeout defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.idles = defaults.idles;
    	      this.perRequests = defaults.perRequests;
        }

        @CustomType.Setter
        public Builder idles(List<GetRouteSpecHttpRouteTimeoutIdle> idles) {
            if (idles == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecHttpRouteTimeout", "idles");
            }
            this.idles = idles;
            return this;
        }
        public Builder idles(GetRouteSpecHttpRouteTimeoutIdle... idles) {
            return idles(List.of(idles));
        }
        @CustomType.Setter
        public Builder perRequests(List<GetRouteSpecHttpRouteTimeoutPerRequest> perRequests) {
            if (perRequests == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecHttpRouteTimeout", "perRequests");
            }
            this.perRequests = perRequests;
            return this;
        }
        public Builder perRequests(GetRouteSpecHttpRouteTimeoutPerRequest... perRequests) {
            return perRequests(List.of(perRequests));
        }
        public GetRouteSpecHttpRouteTimeout build() {
            final var _resultValue = new GetRouteSpecHttpRouteTimeout();
            _resultValue.idles = idles;
            _resultValue.perRequests = perRequests;
            return _resultValue;
        }
    }
}
