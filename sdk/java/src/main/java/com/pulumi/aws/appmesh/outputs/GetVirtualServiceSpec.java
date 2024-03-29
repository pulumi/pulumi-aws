// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetVirtualServiceSpecProvider;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetVirtualServiceSpec {
    private List<GetVirtualServiceSpecProvider> providers;

    private GetVirtualServiceSpec() {}
    public List<GetVirtualServiceSpecProvider> providers() {
        return this.providers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualServiceSpec defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetVirtualServiceSpecProvider> providers;
        public Builder() {}
        public Builder(GetVirtualServiceSpec defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.providers = defaults.providers;
        }

        @CustomType.Setter
        public Builder providers(List<GetVirtualServiceSpecProvider> providers) {
            if (providers == null) {
              throw new MissingRequiredPropertyException("GetVirtualServiceSpec", "providers");
            }
            this.providers = providers;
            return this;
        }
        public Builder providers(GetVirtualServiceSpecProvider... providers) {
            return providers(List.of(providers));
        }
        public GetVirtualServiceSpec build() {
            final var _resultValue = new GetVirtualServiceSpec();
            _resultValue.providers = providers;
            return _resultValue;
        }
    }
}
