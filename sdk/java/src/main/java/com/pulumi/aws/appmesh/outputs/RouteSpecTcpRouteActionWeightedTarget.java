// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class RouteSpecTcpRouteActionWeightedTarget {
    /**
     * @return The targeted port of the weighted object.
     * 
     */
    private @Nullable Integer port;
    /**
     * @return Virtual node to associate with the weighted target. Must be between 1 and 255 characters in length.
     * 
     */
    private String virtualNode;
    /**
     * @return Relative weight of the weighted target. An integer between 0 and 100.
     * 
     */
    private Integer weight;

    private RouteSpecTcpRouteActionWeightedTarget() {}
    /**
     * @return The targeted port of the weighted object.
     * 
     */
    public Optional<Integer> port() {
        return Optional.ofNullable(this.port);
    }
    /**
     * @return Virtual node to associate with the weighted target. Must be between 1 and 255 characters in length.
     * 
     */
    public String virtualNode() {
        return this.virtualNode;
    }
    /**
     * @return Relative weight of the weighted target. An integer between 0 and 100.
     * 
     */
    public Integer weight() {
        return this.weight;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RouteSpecTcpRouteActionWeightedTarget defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer port;
        private String virtualNode;
        private Integer weight;
        public Builder() {}
        public Builder(RouteSpecTcpRouteActionWeightedTarget defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.port = defaults.port;
    	      this.virtualNode = defaults.virtualNode;
    	      this.weight = defaults.weight;
        }

        @CustomType.Setter
        public Builder port(@Nullable Integer port) {

            this.port = port;
            return this;
        }
        @CustomType.Setter
        public Builder virtualNode(String virtualNode) {
            if (virtualNode == null) {
              throw new MissingRequiredPropertyException("RouteSpecTcpRouteActionWeightedTarget", "virtualNode");
            }
            this.virtualNode = virtualNode;
            return this;
        }
        @CustomType.Setter
        public Builder weight(Integer weight) {
            if (weight == null) {
              throw new MissingRequiredPropertyException("RouteSpecTcpRouteActionWeightedTarget", "weight");
            }
            this.weight = weight;
            return this;
        }
        public RouteSpecTcpRouteActionWeightedTarget build() {
            final var _resultValue = new RouteSpecTcpRouteActionWeightedTarget();
            _resultValue.port = port;
            _resultValue.virtualNode = virtualNode;
            _resultValue.weight = weight;
            return _resultValue;
        }
    }
}
