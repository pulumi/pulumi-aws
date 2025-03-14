// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.elasticache.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetServerlessCacheReaderEndpoint {
    /**
     * @return The DNS hostname of the cache node.
     * 
     */
    private String address;
    /**
     * @return The port number that the cache engine is listening on. Set as integer.
     * 
     */
    private Integer port;

    private GetServerlessCacheReaderEndpoint() {}
    /**
     * @return The DNS hostname of the cache node.
     * 
     */
    public String address() {
        return this.address;
    }
    /**
     * @return The port number that the cache engine is listening on. Set as integer.
     * 
     */
    public Integer port() {
        return this.port;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetServerlessCacheReaderEndpoint defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String address;
        private Integer port;
        public Builder() {}
        public Builder(GetServerlessCacheReaderEndpoint defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.address = defaults.address;
    	      this.port = defaults.port;
        }

        @CustomType.Setter
        public Builder address(String address) {
            if (address == null) {
              throw new MissingRequiredPropertyException("GetServerlessCacheReaderEndpoint", "address");
            }
            this.address = address;
            return this;
        }
        @CustomType.Setter
        public Builder port(Integer port) {
            if (port == null) {
              throw new MissingRequiredPropertyException("GetServerlessCacheReaderEndpoint", "port");
            }
            this.port = port;
            return this;
        }
        public GetServerlessCacheReaderEndpoint build() {
            final var _resultValue = new GetServerlessCacheReaderEndpoint();
            _resultValue.address = address;
            _resultValue.port = port;
            return _resultValue;
        }
    }
}
