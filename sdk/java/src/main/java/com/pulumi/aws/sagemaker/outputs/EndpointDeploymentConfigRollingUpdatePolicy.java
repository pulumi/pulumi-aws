// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.outputs;

import com.pulumi.aws.sagemaker.outputs.EndpointDeploymentConfigRollingUpdatePolicyMaximumBatchSize;
import com.pulumi.aws.sagemaker.outputs.EndpointDeploymentConfigRollingUpdatePolicyRollbackMaximumBatchSize;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class EndpointDeploymentConfigRollingUpdatePolicy {
    /**
     * @return Batch size for each rolling step to provision capacity and turn on traffic on the new endpoint fleet, and terminate capacity on the old endpoint fleet. Value must be between 5% to 50% of the variant&#39;s total instance count. See Maximum Batch Size.
     * 
     */
    private EndpointDeploymentConfigRollingUpdatePolicyMaximumBatchSize maximumBatchSize;
    /**
     * @return The time limit for the total deployment. Exceeding this limit causes a timeout. Valid values are between `600` and `14400`.
     * 
     */
    private @Nullable Integer maximumExecutionTimeoutInSeconds;
    /**
     * @return Batch size for rollback to the old endpoint fleet. Each rolling step to provision capacity and turn on traffic on the old endpoint fleet, and terminate capacity on the new endpoint fleet. If this field is absent, the default value will be set to 100% of total capacity which means to bring up the whole capacity of the old fleet at once during rollback. See Rollback Maximum Batch Size.
     * 
     */
    private @Nullable EndpointDeploymentConfigRollingUpdatePolicyRollbackMaximumBatchSize rollbackMaximumBatchSize;
    /**
     * @return The length of the baking period, during which SageMaker AI monitors alarms for each batch on the new fleet. Valid values are between `0` and `3600`.
     * 
     */
    private Integer waitIntervalInSeconds;

    private EndpointDeploymentConfigRollingUpdatePolicy() {}
    /**
     * @return Batch size for each rolling step to provision capacity and turn on traffic on the new endpoint fleet, and terminate capacity on the old endpoint fleet. Value must be between 5% to 50% of the variant&#39;s total instance count. See Maximum Batch Size.
     * 
     */
    public EndpointDeploymentConfigRollingUpdatePolicyMaximumBatchSize maximumBatchSize() {
        return this.maximumBatchSize;
    }
    /**
     * @return The time limit for the total deployment. Exceeding this limit causes a timeout. Valid values are between `600` and `14400`.
     * 
     */
    public Optional<Integer> maximumExecutionTimeoutInSeconds() {
        return Optional.ofNullable(this.maximumExecutionTimeoutInSeconds);
    }
    /**
     * @return Batch size for rollback to the old endpoint fleet. Each rolling step to provision capacity and turn on traffic on the old endpoint fleet, and terminate capacity on the new endpoint fleet. If this field is absent, the default value will be set to 100% of total capacity which means to bring up the whole capacity of the old fleet at once during rollback. See Rollback Maximum Batch Size.
     * 
     */
    public Optional<EndpointDeploymentConfigRollingUpdatePolicyRollbackMaximumBatchSize> rollbackMaximumBatchSize() {
        return Optional.ofNullable(this.rollbackMaximumBatchSize);
    }
    /**
     * @return The length of the baking period, during which SageMaker AI monitors alarms for each batch on the new fleet. Valid values are between `0` and `3600`.
     * 
     */
    public Integer waitIntervalInSeconds() {
        return this.waitIntervalInSeconds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EndpointDeploymentConfigRollingUpdatePolicy defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private EndpointDeploymentConfigRollingUpdatePolicyMaximumBatchSize maximumBatchSize;
        private @Nullable Integer maximumExecutionTimeoutInSeconds;
        private @Nullable EndpointDeploymentConfigRollingUpdatePolicyRollbackMaximumBatchSize rollbackMaximumBatchSize;
        private Integer waitIntervalInSeconds;
        public Builder() {}
        public Builder(EndpointDeploymentConfigRollingUpdatePolicy defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.maximumBatchSize = defaults.maximumBatchSize;
    	      this.maximumExecutionTimeoutInSeconds = defaults.maximumExecutionTimeoutInSeconds;
    	      this.rollbackMaximumBatchSize = defaults.rollbackMaximumBatchSize;
    	      this.waitIntervalInSeconds = defaults.waitIntervalInSeconds;
        }

        @CustomType.Setter
        public Builder maximumBatchSize(EndpointDeploymentConfigRollingUpdatePolicyMaximumBatchSize maximumBatchSize) {
            if (maximumBatchSize == null) {
              throw new MissingRequiredPropertyException("EndpointDeploymentConfigRollingUpdatePolicy", "maximumBatchSize");
            }
            this.maximumBatchSize = maximumBatchSize;
            return this;
        }
        @CustomType.Setter
        public Builder maximumExecutionTimeoutInSeconds(@Nullable Integer maximumExecutionTimeoutInSeconds) {

            this.maximumExecutionTimeoutInSeconds = maximumExecutionTimeoutInSeconds;
            return this;
        }
        @CustomType.Setter
        public Builder rollbackMaximumBatchSize(@Nullable EndpointDeploymentConfigRollingUpdatePolicyRollbackMaximumBatchSize rollbackMaximumBatchSize) {

            this.rollbackMaximumBatchSize = rollbackMaximumBatchSize;
            return this;
        }
        @CustomType.Setter
        public Builder waitIntervalInSeconds(Integer waitIntervalInSeconds) {
            if (waitIntervalInSeconds == null) {
              throw new MissingRequiredPropertyException("EndpointDeploymentConfigRollingUpdatePolicy", "waitIntervalInSeconds");
            }
            this.waitIntervalInSeconds = waitIntervalInSeconds;
            return this;
        }
        public EndpointDeploymentConfigRollingUpdatePolicy build() {
            final var _resultValue = new EndpointDeploymentConfigRollingUpdatePolicy();
            _resultValue.maximumBatchSize = maximumBatchSize;
            _resultValue.maximumExecutionTimeoutInSeconds = maximumExecutionTimeoutInSeconds;
            _resultValue.rollbackMaximumBatchSize = rollbackMaximumBatchSize;
            _resultValue.waitIntervalInSeconds = waitIntervalInSeconds;
            return _resultValue;
        }
    }
}
