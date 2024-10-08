// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class VirtualServiceSpecProviderVirtualRouter {
    /**
     * @return Name of the virtual router that is acting as a service provider. Must be between 1 and 255 characters in length.
     * 
     */
    private String virtualRouterName;

    private VirtualServiceSpecProviderVirtualRouter() {}
    /**
     * @return Name of the virtual router that is acting as a service provider. Must be between 1 and 255 characters in length.
     * 
     */
    public String virtualRouterName() {
        return this.virtualRouterName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(VirtualServiceSpecProviderVirtualRouter defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String virtualRouterName;
        public Builder() {}
        public Builder(VirtualServiceSpecProviderVirtualRouter defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.virtualRouterName = defaults.virtualRouterName;
        }

        @CustomType.Setter
        public Builder virtualRouterName(String virtualRouterName) {
            if (virtualRouterName == null) {
              throw new MissingRequiredPropertyException("VirtualServiceSpecProviderVirtualRouter", "virtualRouterName");
            }
            this.virtualRouterName = virtualRouterName;
            return this;
        }
        public VirtualServiceSpecProviderVirtualRouter build() {
            final var _resultValue = new VirtualServiceSpecProviderVirtualRouter();
            _resultValue.virtualRouterName = virtualRouterName;
            return _resultValue;
        }
    }
}
