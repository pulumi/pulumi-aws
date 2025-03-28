// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.VirtualNodeSpecBackendVirtualService;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.Objects;

@CustomType
public final class VirtualNodeSpecBackend {
    /**
     * @return Virtual service to use as a backend for a virtual node.
     * 
     */
    private VirtualNodeSpecBackendVirtualService virtualService;

    private VirtualNodeSpecBackend() {}
    /**
     * @return Virtual service to use as a backend for a virtual node.
     * 
     */
    public VirtualNodeSpecBackendVirtualService virtualService() {
        return this.virtualService;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(VirtualNodeSpecBackend defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private VirtualNodeSpecBackendVirtualService virtualService;
        public Builder() {}
        public Builder(VirtualNodeSpecBackend defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.virtualService = defaults.virtualService;
        }

        @CustomType.Setter
        public Builder virtualService(VirtualNodeSpecBackendVirtualService virtualService) {
            if (virtualService == null) {
              throw new MissingRequiredPropertyException("VirtualNodeSpecBackend", "virtualService");
            }
            this.virtualService = virtualService;
            return this;
        }
        public VirtualNodeSpecBackend build() {
            final var _resultValue = new VirtualNodeSpecBackend();
            _resultValue.virtualService = virtualService;
            return _resultValue;
        }
    }
}
