// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class GetVirtualNodeSpecListenerConnectionPoolTcp {
    private Integer maxConnections;

    private GetVirtualNodeSpecListenerConnectionPoolTcp() {}
    public Integer maxConnections() {
        return this.maxConnections;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualNodeSpecListenerConnectionPoolTcp defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer maxConnections;
        public Builder() {}
        public Builder(GetVirtualNodeSpecListenerConnectionPoolTcp defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.maxConnections = defaults.maxConnections;
        }

        @CustomType.Setter
        public Builder maxConnections(Integer maxConnections) {
            if (maxConnections == null) {
              throw new MissingRequiredPropertyException("GetVirtualNodeSpecListenerConnectionPoolTcp", "maxConnections");
            }
            this.maxConnections = maxConnections;
            return this;
        }
        public GetVirtualNodeSpecListenerConnectionPoolTcp build() {
            final var _resultValue = new GetVirtualNodeSpecListenerConnectionPoolTcp();
            _resultValue.maxConnections = maxConnections;
            return _resultValue;
        }
    }
}
