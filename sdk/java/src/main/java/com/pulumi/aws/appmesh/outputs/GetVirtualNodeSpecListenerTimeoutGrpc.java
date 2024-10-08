// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecListenerTimeoutGrpcIdle;
import com.pulumi.aws.appmesh.outputs.GetVirtualNodeSpecListenerTimeoutGrpcPerRequest;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetVirtualNodeSpecListenerTimeoutGrpc {
    private List<GetVirtualNodeSpecListenerTimeoutGrpcIdle> idles;
    private List<GetVirtualNodeSpecListenerTimeoutGrpcPerRequest> perRequests;

    private GetVirtualNodeSpecListenerTimeoutGrpc() {}
    public List<GetVirtualNodeSpecListenerTimeoutGrpcIdle> idles() {
        return this.idles;
    }
    public List<GetVirtualNodeSpecListenerTimeoutGrpcPerRequest> perRequests() {
        return this.perRequests;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualNodeSpecListenerTimeoutGrpc defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetVirtualNodeSpecListenerTimeoutGrpcIdle> idles;
        private List<GetVirtualNodeSpecListenerTimeoutGrpcPerRequest> perRequests;
        public Builder() {}
        public Builder(GetVirtualNodeSpecListenerTimeoutGrpc defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.idles = defaults.idles;
    	      this.perRequests = defaults.perRequests;
        }

        @CustomType.Setter
        public Builder idles(List<GetVirtualNodeSpecListenerTimeoutGrpcIdle> idles) {
            if (idles == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecListenerTimeoutGrpc", "idles");
            }
            this.idles = idles;
            return this;
        }
        public Builder idles(GetVirtualNodeSpecListenerTimeoutGrpcIdle... idles) {
            return idles(List.of(idles));
        }
        @CustomType.Setter
        public Builder perRequests(List<GetVirtualNodeSpecListenerTimeoutGrpcPerRequest> perRequests) {
            if (perRequests == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecListenerTimeoutGrpc", "perRequests");
            }
            this.perRequests = perRequests;
            return this;
        }
        public Builder perRequests(GetVirtualNodeSpecListenerTimeoutGrpcPerRequest... perRequests) {
            return perRequests(List.of(perRequests));
        }
        public GetVirtualNodeSpecListenerTimeoutGrpc build() {
            final var _resultValue = new GetVirtualNodeSpecListenerTimeoutGrpc();
            _resultValue.idles = idles;
            _resultValue.perRequests = perRequests;
            return _resultValue;
        }
    }
}
