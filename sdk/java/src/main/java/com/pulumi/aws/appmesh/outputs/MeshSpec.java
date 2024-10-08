// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.MeshSpecEgressFilter;
import com.pulumi.aws.appmesh.outputs.MeshSpecServiceDiscovery;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class MeshSpec {
    /**
     * @return Egress filter rules for the service mesh.
     * 
     */
    private @Nullable MeshSpecEgressFilter egressFilter;
    /**
     * @return The service discovery information for the service mesh.
     * 
     */
    private @Nullable MeshSpecServiceDiscovery serviceDiscovery;

    private MeshSpec() {}
    /**
     * @return Egress filter rules for the service mesh.
     * 
     */
    public Optional<MeshSpecEgressFilter> egressFilter() {
        return Optional.ofNullable(this.egressFilter);
    }
    /**
     * @return The service discovery information for the service mesh.
     * 
     */
    public Optional<MeshSpecServiceDiscovery> serviceDiscovery() {
        return Optional.ofNullable(this.serviceDiscovery);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MeshSpec defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable MeshSpecEgressFilter egressFilter;
        private @Nullable MeshSpecServiceDiscovery serviceDiscovery;
        public Builder() {}
        public Builder(MeshSpec defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.egressFilter = defaults.egressFilter;
    	      this.serviceDiscovery = defaults.serviceDiscovery;
        }

        @CustomType.Setter
        public Builder egressFilter(@Nullable MeshSpecEgressFilter egressFilter) {

            this.egressFilter = egressFilter;
            return this;
        }
        @CustomType.Setter
        public Builder serviceDiscovery(@Nullable MeshSpecServiceDiscovery serviceDiscovery) {

            this.serviceDiscovery = serviceDiscovery;
            return this;
        }
        public MeshSpec build() {
            final var _resultValue = new MeshSpec();
            _resultValue.egressFilter = egressFilter;
            _resultValue.serviceDiscovery = serviceDiscovery;
            return _resultValue;
        }
    }
}
