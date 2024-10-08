// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetMeshSpecEgressFilter;
import com.pulumi.aws.appmesh.outputs.GetMeshSpecServiceDiscovery;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetMeshSpec {
    private List<GetMeshSpecEgressFilter> egressFilters;
    private List<GetMeshSpecServiceDiscovery> serviceDiscoveries;

    private GetMeshSpec() {}
    public List<GetMeshSpecEgressFilter> egressFilters() {
        return this.egressFilters;
    }
    public List<GetMeshSpecServiceDiscovery> serviceDiscoveries() {
        return this.serviceDiscoveries;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetMeshSpec defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetMeshSpecEgressFilter> egressFilters;
        private List<GetMeshSpecServiceDiscovery> serviceDiscoveries;
        public Builder() {}
        public Builder(GetMeshSpec defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.egressFilters = defaults.egressFilters;
    	      this.serviceDiscoveries = defaults.serviceDiscoveries;
        }

        @CustomType.Setter
        public Builder egressFilters(List<GetMeshSpecEgressFilter> egressFilters) {
            if (egressFilters == null) {
              throw new MissingRequiredPropertyException("GetMeshSpec", "egressFilters");
            }
            this.egressFilters = egressFilters;
            return this;
        }
        public Builder egressFilters(GetMeshSpecEgressFilter... egressFilters) {
            return egressFilters(List.of(egressFilters));
        }
        @CustomType.Setter
        public Builder serviceDiscoveries(List<GetMeshSpecServiceDiscovery> serviceDiscoveries) {
            if (serviceDiscoveries == null) {
              throw new MissingRequiredPropertyException("GetMeshSpec", "serviceDiscoveries");
            }
            this.serviceDiscoveries = serviceDiscoveries;
            return this;
        }
        public Builder serviceDiscoveries(GetMeshSpecServiceDiscovery... serviceDiscoveries) {
            return serviceDiscoveries(List.of(serviceDiscoveries));
        }
        public GetMeshSpec build() {
            final var _resultValue = new GetMeshSpec();
            _resultValue.egressFilters = egressFilters;
            _resultValue.serviceDiscoveries = serviceDiscoveries;
            return _resultValue;
        }
    }
}
