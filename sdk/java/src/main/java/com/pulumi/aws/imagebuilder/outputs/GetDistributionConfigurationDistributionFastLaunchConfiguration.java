// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.outputs;

import com.pulumi.aws.imagebuilder.outputs.GetDistributionConfigurationDistributionFastLaunchConfigurationLaunchTemplate;
import com.pulumi.aws.imagebuilder.outputs.GetDistributionConfigurationDistributionFastLaunchConfigurationSnapshotConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetDistributionConfigurationDistributionFastLaunchConfiguration {
    /**
     * @return The account ID that this configuration applies to.
     * 
     */
    private String accountId;
    /**
     * @return A Boolean that represents the current state of faster launching for the Windows AMI.
     * 
     */
    private Boolean enabled;
    /**
     * @return Nested list of launch templates that the fast-launch enabled Windows AMI uses when it launches Windows instances to create pre-provisioned snapshots.
     * 
     */
    private List<GetDistributionConfigurationDistributionFastLaunchConfigurationLaunchTemplate> launchTemplates;
    /**
     * @return The maximum number of parallel instances that are launched for creating resources.
     * 
     */
    private Integer maxParallelLaunches;
    /**
     * @return Nested list of configurations for managing the number of snapshots that are created from pre-provisioned instances for the Windows AMI when faster launching is enabled.
     * 
     */
    private List<GetDistributionConfigurationDistributionFastLaunchConfigurationSnapshotConfiguration> snapshotConfigurations;

    private GetDistributionConfigurationDistributionFastLaunchConfiguration() {}
    /**
     * @return The account ID that this configuration applies to.
     * 
     */
    public String accountId() {
        return this.accountId;
    }
    /**
     * @return A Boolean that represents the current state of faster launching for the Windows AMI.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }
    /**
     * @return Nested list of launch templates that the fast-launch enabled Windows AMI uses when it launches Windows instances to create pre-provisioned snapshots.
     * 
     */
    public List<GetDistributionConfigurationDistributionFastLaunchConfigurationLaunchTemplate> launchTemplates() {
        return this.launchTemplates;
    }
    /**
     * @return The maximum number of parallel instances that are launched for creating resources.
     * 
     */
    public Integer maxParallelLaunches() {
        return this.maxParallelLaunches;
    }
    /**
     * @return Nested list of configurations for managing the number of snapshots that are created from pre-provisioned instances for the Windows AMI when faster launching is enabled.
     * 
     */
    public List<GetDistributionConfigurationDistributionFastLaunchConfigurationSnapshotConfiguration> snapshotConfigurations() {
        return this.snapshotConfigurations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDistributionConfigurationDistributionFastLaunchConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String accountId;
        private Boolean enabled;
        private List<GetDistributionConfigurationDistributionFastLaunchConfigurationLaunchTemplate> launchTemplates;
        private Integer maxParallelLaunches;
        private List<GetDistributionConfigurationDistributionFastLaunchConfigurationSnapshotConfiguration> snapshotConfigurations;
        public Builder() {}
        public Builder(GetDistributionConfigurationDistributionFastLaunchConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.accountId = defaults.accountId;
    	      this.enabled = defaults.enabled;
    	      this.launchTemplates = defaults.launchTemplates;
    	      this.maxParallelLaunches = defaults.maxParallelLaunches;
    	      this.snapshotConfigurations = defaults.snapshotConfigurations;
        }

        @CustomType.Setter
        public Builder accountId(String accountId) {
            if (accountId == null) {
              throw new MissingRequiredPropertyException("GetDistributionConfigurationDistributionFastLaunchConfiguration", "accountId");
            }
            this.accountId = accountId;
            return this;
        }
        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("GetDistributionConfigurationDistributionFastLaunchConfiguration", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder launchTemplates(List<GetDistributionConfigurationDistributionFastLaunchConfigurationLaunchTemplate> launchTemplates) {
            if (launchTemplates == null) {
              throw new MissingRequiredPropertyException("GetDistributionConfigurationDistributionFastLaunchConfiguration", "launchTemplates");
            }
            this.launchTemplates = launchTemplates;
            return this;
        }
        public Builder launchTemplates(GetDistributionConfigurationDistributionFastLaunchConfigurationLaunchTemplate... launchTemplates) {
            return launchTemplates(List.of(launchTemplates));
        }
        @CustomType.Setter
        public Builder maxParallelLaunches(Integer maxParallelLaunches) {
            if (maxParallelLaunches == null) {
              throw new MissingRequiredPropertyException("GetDistributionConfigurationDistributionFastLaunchConfiguration", "maxParallelLaunches");
            }
            this.maxParallelLaunches = maxParallelLaunches;
            return this;
        }
        @CustomType.Setter
        public Builder snapshotConfigurations(List<GetDistributionConfigurationDistributionFastLaunchConfigurationSnapshotConfiguration> snapshotConfigurations) {
            if (snapshotConfigurations == null) {
              throw new MissingRequiredPropertyException("GetDistributionConfigurationDistributionFastLaunchConfiguration", "snapshotConfigurations");
            }
            this.snapshotConfigurations = snapshotConfigurations;
            return this;
        }
        public Builder snapshotConfigurations(GetDistributionConfigurationDistributionFastLaunchConfigurationSnapshotConfiguration... snapshotConfigurations) {
            return snapshotConfigurations(List.of(snapshotConfigurations));
        }
        public GetDistributionConfigurationDistributionFastLaunchConfiguration build() {
            final var _resultValue = new GetDistributionConfigurationDistributionFastLaunchConfiguration();
            _resultValue.accountId = accountId;
            _resultValue.enabled = enabled;
            _resultValue.launchTemplates = launchTemplates;
            _resultValue.maxParallelLaunches = maxParallelLaunches;
            _resultValue.snapshotConfigurations = snapshotConfigurations;
            return _resultValue;
        }
    }
}
