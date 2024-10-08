// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class JobQueueComputeEnvironmentOrder {
    /**
     * @return The Amazon Resource Name (ARN) of the compute environment.
     * 
     */
    private String computeEnvironment;
    /**
     * @return The order of the compute environment. Compute environments are tried in ascending order. For example, if two compute environments are associated with a job queue, the compute environment with a lower order integer value is tried for job placement first.
     * 
     */
    private Integer order;

    private JobQueueComputeEnvironmentOrder() {}
    /**
     * @return The Amazon Resource Name (ARN) of the compute environment.
     * 
     */
    public String computeEnvironment() {
        return this.computeEnvironment;
    }
    /**
     * @return The order of the compute environment. Compute environments are tried in ascending order. For example, if two compute environments are associated with a job queue, the compute environment with a lower order integer value is tried for job placement first.
     * 
     */
    public Integer order() {
        return this.order;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(JobQueueComputeEnvironmentOrder defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String computeEnvironment;
        private Integer order;
        public Builder() {}
        public Builder(JobQueueComputeEnvironmentOrder defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.computeEnvironment = defaults.computeEnvironment;
    	      this.order = defaults.order;
        }

        @CustomType.Setter
        public Builder computeEnvironment(String computeEnvironment) {
            if (computeEnvironment == null) {
              throw new MissingRequiredPropertyException("JobQueueComputeEnvironmentOrder", "computeEnvironment");
            }
            this.computeEnvironment = computeEnvironment;
            return this;
        }
        @CustomType.Setter
        public Builder order(Integer order) {
            if (order == null) {
              throw new MissingRequiredPropertyException("JobQueueComputeEnvironmentOrder", "order");
            }
            this.order = order;
            return this;
        }
        public JobQueueComputeEnvironmentOrder build() {
            final var _resultValue = new JobQueueComputeEnvironmentOrder();
            _resultValue.computeEnvironment = computeEnvironment;
            _resultValue.order = order;
            return _resultValue;
        }
    }
}
