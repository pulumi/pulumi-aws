// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecListenerTimeoutHttpIdle;
import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecListenerTimeoutHttpPerRequest;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetVirtualNodeSpecListenerTimeoutHttp {
    private List<GetVirtualNodeSpecListenerTimeoutHttpIdle> idles;
    private List<GetVirtualNodeSpecListenerTimeoutHttpPerRequest> perRequests;

    private GetVirtualNodeSpecListenerTimeoutHttp() {}
    public List<GetVirtualNodeSpecListenerTimeoutHttpIdle> idles() {
        return this.idles;
    }
    public List<GetVirtualNodeSpecListenerTimeoutHttpPerRequest> perRequests() {
        return this.perRequests;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualNodeSpecListenerTimeoutHttp defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetVirtualNodeSpecListenerTimeoutHttpIdle> idles;
        private List<GetVirtualNodeSpecListenerTimeoutHttpPerRequest> perRequests;
        public Builder() {}
        public Builder(GetVirtualNodeSpecListenerTimeoutHttp defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.idles = defaults.idles;
    	      this.perRequests = defaults.perRequests;
        }

        @CustomType.Setter
        public Builder idles(List<GetVirtualNodeSpecListenerTimeoutHttpIdle> idles) {
            if (idles == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecListenerTimeoutHttp", "idles");
            }
            this.idles = idles;
            return this;
        }
        public Builder idles(GetVirtualNodeSpecListenerTimeoutHttpIdle... idles) {
            return idles(List.of(idles));
        }
        @CustomType.Setter
        public Builder perRequests(List<GetVirtualNodeSpecListenerTimeoutHttpPerRequest> perRequests) {
            if (perRequests == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecListenerTimeoutHttp", "perRequests");
            }
            this.perRequests = perRequests;
            return this;
        }
        public Builder perRequests(GetVirtualNodeSpecListenerTimeoutHttpPerRequest... perRequests) {
            return perRequests(List.of(perRequests));
        }
        public GetVirtualNodeSpecListenerTimeoutHttp build() {
            final var _resultValue = new GetVirtualNodeSpecListenerTimeoutHttp();
            _resultValue.idles = idles;
            _resultValue.perRequests = perRequests;
            return _resultValue;
        }
    }
}
