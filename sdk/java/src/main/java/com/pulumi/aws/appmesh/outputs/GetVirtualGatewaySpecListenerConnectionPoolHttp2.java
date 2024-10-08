// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class GetVirtualGatewaySpecListenerConnectionPoolHttp2 {
    private Integer maxRequests;

    private GetVirtualGatewaySpecListenerConnectionPoolHttp2() {}
    public Integer maxRequests() {
        return this.maxRequests;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetVirtualGatewaySpecListenerConnectionPoolHttp2 defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer maxRequests;
        public Builder() {}
        public Builder(GetVirtualGatewaySpecListenerConnectionPoolHttp2 defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.maxRequests = defaults.maxRequests;
        }

        @CustomType.Setter
        public Builder maxRequests(Integer maxRequests) {
            if (maxRequests == null) {
              throw new MissingRequiredPropertyException("GetVirtualGatewaySpecListenerConnectionPoolHttp2", "maxRequests");
            }
            this.maxRequests = maxRequests;
            return this;
        }
        public GetVirtualGatewaySpecListenerConnectionPoolHttp2 build() {
            final var _resultValue = new GetVirtualGatewaySpecListenerConnectionPoolHttp2();
            _resultValue.maxRequests = maxRequests;
            return _resultValue;
        }
    }
}
