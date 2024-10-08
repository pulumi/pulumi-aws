// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class NodeGroupScalingConfig {
    /**
     * @return Desired number of worker nodes.
     * 
     */
    private Integer desiredSize;
    /**
     * @return Maximum number of worker nodes.
     * 
     */
    private Integer maxSize;
    /**
     * @return Minimum number of worker nodes.
     * 
     */
    private Integer minSize;

    private NodeGroupScalingConfig() {}
    /**
     * @return Desired number of worker nodes.
     * 
     */
    public Integer desiredSize() {
        return this.desiredSize;
    }
    /**
     * @return Maximum number of worker nodes.
     * 
     */
    public Integer maxSize() {
        return this.maxSize;
    }
    /**
     * @return Minimum number of worker nodes.
     * 
     */
    public Integer minSize() {
        return this.minSize;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(NodeGroupScalingConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer desiredSize;
        private Integer maxSize;
        private Integer minSize;
        public Builder() {}
        public Builder(NodeGroupScalingConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.desiredSize = defaults.desiredSize;
    	      this.maxSize = defaults.maxSize;
    	      this.minSize = defaults.minSize;
        }

        @CustomType.Setter
        public Builder desiredSize(Integer desiredSize) {
            if (desiredSize == null) {
              throw new MissingRequiredPropertyException("NodeGroupScalingConfig", "desiredSize");
            }
            this.desiredSize = desiredSize;
            return this;
        }
        @CustomType.Setter
        public Builder maxSize(Integer maxSize) {
            if (maxSize == null) {
              throw new MissingRequiredPropertyException("NodeGroupScalingConfig", "maxSize");
            }
            this.maxSize = maxSize;
            return this;
        }
        @CustomType.Setter
        public Builder minSize(Integer minSize) {
            if (minSize == null) {
              throw new MissingRequiredPropertyException("NodeGroupScalingConfig", "minSize");
            }
            this.minSize = minSize;
            return this;
        }
        public NodeGroupScalingConfig build() {
            final var _resultValue = new NodeGroupScalingConfig();
            _resultValue.desiredSize = desiredSize;
            _resultValue.maxSize = maxSize;
            _resultValue.minSize = minSize;
            return _resultValue;
        }
    }
}
