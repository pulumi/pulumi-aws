// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codedeploy.outputs;

import com.pulumi.aws.codedeploy.outputs.DeploymentConfigZonalConfigMinimumHealthyHostsPerZone;
import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DeploymentConfigZonalConfig {
    /**
     * @return The period of time, in seconds, that CodeDeploy must wait after completing a deployment to the first Availability Zone. CodeDeploy will wait this amount of time before starting a deployment to the second Availability Zone. If you don&#39;t specify a value for `first_zone_monitor_duration_in_seconds`, then CodeDeploy uses the `monitor_duration_in_seconds` value for the first Availability Zone.
     * 
     */
    private @Nullable Integer firstZoneMonitorDurationInSeconds;
    /**
     * @return The number or percentage of instances that must remain available per Availability Zone during a deployment. If you don&#39;t specify a value under `minimum_healthy_hosts_per_zone`, then CodeDeploy uses a default value of 0 percent. This block is more documented below.
     * 
     */
    private @Nullable DeploymentConfigZonalConfigMinimumHealthyHostsPerZone minimumHealthyHostsPerZone;
    /**
     * @return The period of time, in seconds, that CodeDeploy must wait after completing a deployment to an Availability Zone. CodeDeploy will wait this amount of time before starting a deployment to the next Availability Zone. If you don&#39;t specify a `monitor_duration_in_seconds`, CodeDeploy starts deploying to the next Availability Zone immediately.
     * 
     */
    private @Nullable Integer monitorDurationInSeconds;

    private DeploymentConfigZonalConfig() {}
    /**
     * @return The period of time, in seconds, that CodeDeploy must wait after completing a deployment to the first Availability Zone. CodeDeploy will wait this amount of time before starting a deployment to the second Availability Zone. If you don&#39;t specify a value for `first_zone_monitor_duration_in_seconds`, then CodeDeploy uses the `monitor_duration_in_seconds` value for the first Availability Zone.
     * 
     */
    public Optional<Integer> firstZoneMonitorDurationInSeconds() {
        return Optional.ofNullable(this.firstZoneMonitorDurationInSeconds);
    }
    /**
     * @return The number or percentage of instances that must remain available per Availability Zone during a deployment. If you don&#39;t specify a value under `minimum_healthy_hosts_per_zone`, then CodeDeploy uses a default value of 0 percent. This block is more documented below.
     * 
     */
    public Optional<DeploymentConfigZonalConfigMinimumHealthyHostsPerZone> minimumHealthyHostsPerZone() {
        return Optional.ofNullable(this.minimumHealthyHostsPerZone);
    }
    /**
     * @return The period of time, in seconds, that CodeDeploy must wait after completing a deployment to an Availability Zone. CodeDeploy will wait this amount of time before starting a deployment to the next Availability Zone. If you don&#39;t specify a `monitor_duration_in_seconds`, CodeDeploy starts deploying to the next Availability Zone immediately.
     * 
     */
    public Optional<Integer> monitorDurationInSeconds() {
        return Optional.ofNullable(this.monitorDurationInSeconds);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DeploymentConfigZonalConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer firstZoneMonitorDurationInSeconds;
        private @Nullable DeploymentConfigZonalConfigMinimumHealthyHostsPerZone minimumHealthyHostsPerZone;
        private @Nullable Integer monitorDurationInSeconds;
        public Builder() {}
        public Builder(DeploymentConfigZonalConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.firstZoneMonitorDurationInSeconds = defaults.firstZoneMonitorDurationInSeconds;
    	      this.minimumHealthyHostsPerZone = defaults.minimumHealthyHostsPerZone;
    	      this.monitorDurationInSeconds = defaults.monitorDurationInSeconds;
        }

        @CustomType.Setter
        public Builder firstZoneMonitorDurationInSeconds(@Nullable Integer firstZoneMonitorDurationInSeconds) {

            this.firstZoneMonitorDurationInSeconds = firstZoneMonitorDurationInSeconds;
            return this;
        }
        @CustomType.Setter
        public Builder minimumHealthyHostsPerZone(@Nullable DeploymentConfigZonalConfigMinimumHealthyHostsPerZone minimumHealthyHostsPerZone) {

            this.minimumHealthyHostsPerZone = minimumHealthyHostsPerZone;
            return this;
        }
        @CustomType.Setter
        public Builder monitorDurationInSeconds(@Nullable Integer monitorDurationInSeconds) {

            this.monitorDurationInSeconds = monitorDurationInSeconds;
            return this;
        }
        public DeploymentConfigZonalConfig build() {
            final var _resultValue = new DeploymentConfigZonalConfig();
            _resultValue.firstZoneMonitorDurationInSeconds = firstZoneMonitorDurationInSeconds;
            _resultValue.minimumHealthyHostsPerZone = minimumHealthyHostsPerZone;
            _resultValue.monitorDurationInSeconds = monitorDurationInSeconds;
            return _resultValue;
        }
    }
}
