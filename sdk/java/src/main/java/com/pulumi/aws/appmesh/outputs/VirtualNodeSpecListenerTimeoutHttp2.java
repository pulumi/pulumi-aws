// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.VirtualNodeSpecListenerTimeoutHttp2Idle;
import com.pulumi.aws.appmesh.outputs.VirtualNodeSpecListenerTimeoutHttp2PerRequest;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class VirtualNodeSpecListenerTimeoutHttp2 {
    /**
     * @return Idle timeout. An idle timeout bounds the amount of time that a connection may be idle.
     * 
     */
    private @Nullable VirtualNodeSpecListenerTimeoutHttp2Idle idle;
    /**
     * @return Per request timeout.
     * 
     */
    private @Nullable VirtualNodeSpecListenerTimeoutHttp2PerRequest perRequest;

    private VirtualNodeSpecListenerTimeoutHttp2() {}
    /**
     * @return Idle timeout. An idle timeout bounds the amount of time that a connection may be idle.
     * 
     */
    public Optional<VirtualNodeSpecListenerTimeoutHttp2Idle> idle() {
        return Optional.ofNullable(this.idle);
    }
    /**
     * @return Per request timeout.
     * 
     */
    public Optional<VirtualNodeSpecListenerTimeoutHttp2PerRequest> perRequest() {
        return Optional.ofNullable(this.perRequest);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(VirtualNodeSpecListenerTimeoutHttp2 defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable VirtualNodeSpecListenerTimeoutHttp2Idle idle;
        private @Nullable VirtualNodeSpecListenerTimeoutHttp2PerRequest perRequest;
        public Builder() {}
        public Builder(VirtualNodeSpecListenerTimeoutHttp2 defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.idle = defaults.idle;
    	      this.perRequest = defaults.perRequest;
        }

        @CustomType.Setter
        public Builder idle(@Nullable VirtualNodeSpecListenerTimeoutHttp2Idle idle) {

            this.idle = idle;
            return this;
        }
        @CustomType.Setter
        public Builder perRequest(@Nullable VirtualNodeSpecListenerTimeoutHttp2PerRequest perRequest) {

            this.perRequest = perRequest;
            return this;
        }
        public VirtualNodeSpecListenerTimeoutHttp2 build() {
            final var _resultValue = new VirtualNodeSpecListenerTimeoutHttp2();
            _resultValue.idle = idle;
            _resultValue.perRequest = perRequest;
            return _resultValue;
        }
    }
}
