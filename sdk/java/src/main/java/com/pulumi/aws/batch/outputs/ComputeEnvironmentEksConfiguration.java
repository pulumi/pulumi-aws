// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ComputeEnvironmentEksConfiguration {
    /**
     * @return The Amazon Resource Name (ARN) of the Amazon EKS cluster.
     * 
     */
    private String eksClusterArn;
    /**
     * @return The namespace of the Amazon EKS cluster. AWS Batch manages pods in this namespace.
     * 
     */
    private String kubernetesNamespace;

    private ComputeEnvironmentEksConfiguration() {}
    /**
     * @return The Amazon Resource Name (ARN) of the Amazon EKS cluster.
     * 
     */
    public String eksClusterArn() {
        return this.eksClusterArn;
    }
    /**
     * @return The namespace of the Amazon EKS cluster. AWS Batch manages pods in this namespace.
     * 
     */
    public String kubernetesNamespace() {
        return this.kubernetesNamespace;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ComputeEnvironmentEksConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String eksClusterArn;
        private String kubernetesNamespace;
        public Builder() {}
        public Builder(ComputeEnvironmentEksConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.eksClusterArn = defaults.eksClusterArn;
    	      this.kubernetesNamespace = defaults.kubernetesNamespace;
        }

        @CustomType.Setter
        public Builder eksClusterArn(String eksClusterArn) {
            if (eksClusterArn == null) {
              throw new MissingRequiredPropertyException("ComputeEnvironmentEksConfiguration", "eksClusterArn");
            }
            this.eksClusterArn = eksClusterArn;
            return this;
        }
        @CustomType.Setter
        public Builder kubernetesNamespace(String kubernetesNamespace) {
            if (kubernetesNamespace == null) {
              throw new MissingRequiredPropertyException("ComputeEnvironmentEksConfiguration", "kubernetesNamespace");
            }
            this.kubernetesNamespace = kubernetesNamespace;
            return this;
        }
        public ComputeEnvironmentEksConfiguration build() {
            final var _resultValue = new ComputeEnvironmentEksConfiguration();
            _resultValue.eksClusterArn = eksClusterArn;
            _resultValue.kubernetesNamespace = kubernetesNamespace;
            return _resultValue;
        }
    }
}
