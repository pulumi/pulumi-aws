// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codedeploy;

import com.pulumi.aws.codedeploy.inputs.DeploymentConfigMinimumHealthyHostsArgs;
import com.pulumi.aws.codedeploy.inputs.DeploymentConfigTrafficRoutingConfigArgs;
import com.pulumi.aws.codedeploy.inputs.DeploymentConfigZonalConfigArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DeploymentConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final DeploymentConfigArgs Empty = new DeploymentConfigArgs();

    /**
     * The compute platform can be `Server`, `Lambda`, or `ECS`. Default is `Server`.
     * 
     */
    @Import(name="computePlatform")
    private @Nullable Output<String> computePlatform;

    /**
     * @return The compute platform can be `Server`, `Lambda`, or `ECS`. Default is `Server`.
     * 
     */
    public Optional<Output<String>> computePlatform() {
        return Optional.ofNullable(this.computePlatform);
    }

    /**
     * The name of the deployment config.
     * 
     */
    @Import(name="deploymentConfigName")
    private @Nullable Output<String> deploymentConfigName;

    /**
     * @return The name of the deployment config.
     * 
     */
    public Optional<Output<String>> deploymentConfigName() {
        return Optional.ofNullable(this.deploymentConfigName);
    }

    /**
     * A minimum_healthy_hosts block. Required for `Server` compute platform. Minimum Healthy Hosts are documented below.
     * 
     */
    @Import(name="minimumHealthyHosts")
    private @Nullable Output<DeploymentConfigMinimumHealthyHostsArgs> minimumHealthyHosts;

    /**
     * @return A minimum_healthy_hosts block. Required for `Server` compute platform. Minimum Healthy Hosts are documented below.
     * 
     */
    public Optional<Output<DeploymentConfigMinimumHealthyHostsArgs>> minimumHealthyHosts() {
        return Optional.ofNullable(this.minimumHealthyHosts);
    }

    /**
     * A traffic_routing_config block. Traffic Routing Config is documented below.
     * 
     */
    @Import(name="trafficRoutingConfig")
    private @Nullable Output<DeploymentConfigTrafficRoutingConfigArgs> trafficRoutingConfig;

    /**
     * @return A traffic_routing_config block. Traffic Routing Config is documented below.
     * 
     */
    public Optional<Output<DeploymentConfigTrafficRoutingConfigArgs>> trafficRoutingConfig() {
        return Optional.ofNullable(this.trafficRoutingConfig);
    }

    /**
     * A zonal_config block. Zonal Config is documented below.
     * 
     */
    @Import(name="zonalConfig")
    private @Nullable Output<DeploymentConfigZonalConfigArgs> zonalConfig;

    /**
     * @return A zonal_config block. Zonal Config is documented below.
     * 
     */
    public Optional<Output<DeploymentConfigZonalConfigArgs>> zonalConfig() {
        return Optional.ofNullable(this.zonalConfig);
    }

    private DeploymentConfigArgs() {}

    private DeploymentConfigArgs(DeploymentConfigArgs $) {
        this.computePlatform = $.computePlatform;
        this.deploymentConfigName = $.deploymentConfigName;
        this.minimumHealthyHosts = $.minimumHealthyHosts;
        this.trafficRoutingConfig = $.trafficRoutingConfig;
        this.zonalConfig = $.zonalConfig;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DeploymentConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DeploymentConfigArgs $;

        public Builder() {
            $ = new DeploymentConfigArgs();
        }

        public Builder(DeploymentConfigArgs defaults) {
            $ = new DeploymentConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param computePlatform The compute platform can be `Server`, `Lambda`, or `ECS`. Default is `Server`.
         * 
         * @return builder
         * 
         */
        public Builder computePlatform(@Nullable Output<String> computePlatform) {
            $.computePlatform = computePlatform;
            return this;
        }

        /**
         * @param computePlatform The compute platform can be `Server`, `Lambda`, or `ECS`. Default is `Server`.
         * 
         * @return builder
         * 
         */
        public Builder computePlatform(String computePlatform) {
            return computePlatform(Output.of(computePlatform));
        }

        /**
         * @param deploymentConfigName The name of the deployment config.
         * 
         * @return builder
         * 
         */
        public Builder deploymentConfigName(@Nullable Output<String> deploymentConfigName) {
            $.deploymentConfigName = deploymentConfigName;
            return this;
        }

        /**
         * @param deploymentConfigName The name of the deployment config.
         * 
         * @return builder
         * 
         */
        public Builder deploymentConfigName(String deploymentConfigName) {
            return deploymentConfigName(Output.of(deploymentConfigName));
        }

        /**
         * @param minimumHealthyHosts A minimum_healthy_hosts block. Required for `Server` compute platform. Minimum Healthy Hosts are documented below.
         * 
         * @return builder
         * 
         */
        public Builder minimumHealthyHosts(@Nullable Output<DeploymentConfigMinimumHealthyHostsArgs> minimumHealthyHosts) {
            $.minimumHealthyHosts = minimumHealthyHosts;
            return this;
        }

        /**
         * @param minimumHealthyHosts A minimum_healthy_hosts block. Required for `Server` compute platform. Minimum Healthy Hosts are documented below.
         * 
         * @return builder
         * 
         */
        public Builder minimumHealthyHosts(DeploymentConfigMinimumHealthyHostsArgs minimumHealthyHosts) {
            return minimumHealthyHosts(Output.of(minimumHealthyHosts));
        }

        /**
         * @param trafficRoutingConfig A traffic_routing_config block. Traffic Routing Config is documented below.
         * 
         * @return builder
         * 
         */
        public Builder trafficRoutingConfig(@Nullable Output<DeploymentConfigTrafficRoutingConfigArgs> trafficRoutingConfig) {
            $.trafficRoutingConfig = trafficRoutingConfig;
            return this;
        }

        /**
         * @param trafficRoutingConfig A traffic_routing_config block. Traffic Routing Config is documented below.
         * 
         * @return builder
         * 
         */
        public Builder trafficRoutingConfig(DeploymentConfigTrafficRoutingConfigArgs trafficRoutingConfig) {
            return trafficRoutingConfig(Output.of(trafficRoutingConfig));
        }

        /**
         * @param zonalConfig A zonal_config block. Zonal Config is documented below.
         * 
         * @return builder
         * 
         */
        public Builder zonalConfig(@Nullable Output<DeploymentConfigZonalConfigArgs> zonalConfig) {
            $.zonalConfig = zonalConfig;
            return this;
        }

        /**
         * @param zonalConfig A zonal_config block. Zonal Config is documented below.
         * 
         * @return builder
         * 
         */
        public Builder zonalConfig(DeploymentConfigZonalConfigArgs zonalConfig) {
            return zonalConfig(Output.of(zonalConfig));
        }

        public DeploymentConfigArgs build() {
            return $;
        }
    }

}
