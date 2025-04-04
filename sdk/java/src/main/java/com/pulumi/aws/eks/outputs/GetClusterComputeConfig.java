// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.eks.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetClusterComputeConfig {
    /**
     * @return Whether zonal shift is enabled.
     * 
     */
    private Boolean enabled;
    /**
     * @return List of node pools for the EKS Auto Mode compute capability.
     * 
     */
    private List<String> nodePools;
    /**
     * @return The ARN of the IAM Role EKS will assign to EC2 Managed Instances in your EKS Auto Mode cluster.
     * 
     */
    private String nodeRoleArn;

    private GetClusterComputeConfig() {}
    /**
     * @return Whether zonal shift is enabled.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }
    /**
     * @return List of node pools for the EKS Auto Mode compute capability.
     * 
     */
    public List<String> nodePools() {
        return this.nodePools;
    }
    /**
     * @return The ARN of the IAM Role EKS will assign to EC2 Managed Instances in your EKS Auto Mode cluster.
     * 
     */
    public String nodeRoleArn() {
        return this.nodeRoleArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetClusterComputeConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean enabled;
        private List<String> nodePools;
        private String nodeRoleArn;
        public Builder() {}
        public Builder(GetClusterComputeConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
    	      this.nodePools = defaults.nodePools;
    	      this.nodeRoleArn = defaults.nodeRoleArn;
        }

        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("GetClusterComputeConfig", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder nodePools(List<String> nodePools) {
            if (nodePools == null) {
              throw new MissingRequiredPropertyException("GetClusterComputeConfig", "nodePools");
            }
            this.nodePools = nodePools;
            return this;
        }
        public Builder nodePools(String... nodePools) {
            return nodePools(List.of(nodePools));
        }
        @CustomType.Setter
        public Builder nodeRoleArn(String nodeRoleArn) {
            if (nodeRoleArn == null) {
              throw new MissingRequiredPropertyException("GetClusterComputeConfig", "nodeRoleArn");
            }
            this.nodeRoleArn = nodeRoleArn;
            return this;
        }
        public GetClusterComputeConfig build() {
            final var _resultValue = new GetClusterComputeConfig();
            _resultValue.enabled = enabled;
            _resultValue.nodePools = nodePools;
            _resultValue.nodeRoleArn = nodeRoleArn;
            return _resultValue;
        }
    }
}
