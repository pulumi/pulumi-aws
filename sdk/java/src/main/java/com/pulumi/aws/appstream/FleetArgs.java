// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appstream;

import com.pulumi.aws.appstream.inputs.FleetComputeCapacityArgs;
import com.pulumi.aws.appstream.inputs.FleetDomainJoinInfoArgs;
import com.pulumi.aws.appstream.inputs.FleetVpcConfigArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class FleetArgs extends com.pulumi.resources.ResourceArgs {

    public static final FleetArgs Empty = new FleetArgs();

    /**
     * Configuration block for the desired capacity of the fleet. See below.
     * 
     */
    @Import(name="computeCapacity", required=true)
    private Output<FleetComputeCapacityArgs> computeCapacity;

    /**
     * @return Configuration block for the desired capacity of the fleet. See below.
     * 
     */
    public Output<FleetComputeCapacityArgs> computeCapacity() {
        return this.computeCapacity;
    }

    /**
     * Description to display.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description to display.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Amount of time that a streaming session remains active after users disconnect.
     * 
     */
    @Import(name="disconnectTimeoutInSeconds")
    private @Nullable Output<Integer> disconnectTimeoutInSeconds;

    /**
     * @return Amount of time that a streaming session remains active after users disconnect.
     * 
     */
    public Optional<Output<Integer>> disconnectTimeoutInSeconds() {
        return Optional.ofNullable(this.disconnectTimeoutInSeconds);
    }

    /**
     * Human-readable friendly name for the AppStream fleet.
     * 
     */
    @Import(name="displayName")
    private @Nullable Output<String> displayName;

    /**
     * @return Human-readable friendly name for the AppStream fleet.
     * 
     */
    public Optional<Output<String>> displayName() {
        return Optional.ofNullable(this.displayName);
    }

    /**
     * Configuration block for the name of the directory and organizational unit (OU) to use to join the fleet to a Microsoft Active Directory domain. See below.
     * 
     */
    @Import(name="domainJoinInfo")
    private @Nullable Output<FleetDomainJoinInfoArgs> domainJoinInfo;

    /**
     * @return Configuration block for the name of the directory and organizational unit (OU) to use to join the fleet to a Microsoft Active Directory domain. See below.
     * 
     */
    public Optional<Output<FleetDomainJoinInfoArgs>> domainJoinInfo() {
        return Optional.ofNullable(this.domainJoinInfo);
    }

    /**
     * Enables or disables default internet access for the fleet.
     * 
     */
    @Import(name="enableDefaultInternetAccess")
    private @Nullable Output<Boolean> enableDefaultInternetAccess;

    /**
     * @return Enables or disables default internet access for the fleet.
     * 
     */
    public Optional<Output<Boolean>> enableDefaultInternetAccess() {
        return Optional.ofNullable(this.enableDefaultInternetAccess);
    }

    /**
     * Fleet type. Valid values are: `ON_DEMAND`, `ALWAYS_ON`
     * 
     */
    @Import(name="fleetType")
    private @Nullable Output<String> fleetType;

    /**
     * @return Fleet type. Valid values are: `ON_DEMAND`, `ALWAYS_ON`
     * 
     */
    public Optional<Output<String>> fleetType() {
        return Optional.ofNullable(this.fleetType);
    }

    /**
     * ARN of the IAM role to apply to the fleet.
     * 
     */
    @Import(name="iamRoleArn")
    private @Nullable Output<String> iamRoleArn;

    /**
     * @return ARN of the IAM role to apply to the fleet.
     * 
     */
    public Optional<Output<String>> iamRoleArn() {
        return Optional.ofNullable(this.iamRoleArn);
    }

    /**
     * Amount of time that users can be idle (inactive) before they are disconnected from their streaming session and the `disconnect_timeout_in_seconds` time interval begins. Defaults to `0`. Valid value is between `60` and ` 3600  `seconds.
     * 
     */
    @Import(name="idleDisconnectTimeoutInSeconds")
    private @Nullable Output<Integer> idleDisconnectTimeoutInSeconds;

    /**
     * @return Amount of time that users can be idle (inactive) before they are disconnected from their streaming session and the `disconnect_timeout_in_seconds` time interval begins. Defaults to `0`. Valid value is between `60` and ` 3600  `seconds.
     * 
     */
    public Optional<Output<Integer>> idleDisconnectTimeoutInSeconds() {
        return Optional.ofNullable(this.idleDisconnectTimeoutInSeconds);
    }

    /**
     * ARN of the public, private, or shared image to use.
     * 
     */
    @Import(name="imageArn")
    private @Nullable Output<String> imageArn;

    /**
     * @return ARN of the public, private, or shared image to use.
     * 
     */
    public Optional<Output<String>> imageArn() {
        return Optional.ofNullable(this.imageArn);
    }

    /**
     * Name of the image used to create the fleet.
     * 
     */
    @Import(name="imageName")
    private @Nullable Output<String> imageName;

    /**
     * @return Name of the image used to create the fleet.
     * 
     */
    public Optional<Output<String>> imageName() {
        return Optional.ofNullable(this.imageName);
    }

    /**
     * Instance type to use when launching fleet instances.
     * 
     */
    @Import(name="instanceType", required=true)
    private Output<String> instanceType;

    /**
     * @return Instance type to use when launching fleet instances.
     * 
     */
    public Output<String> instanceType() {
        return this.instanceType;
    }

    /**
     * The maximum number of user sessions on an instance. This only applies to multi-session fleets.
     * 
     */
    @Import(name="maxSessionsPerInstance")
    private @Nullable Output<Integer> maxSessionsPerInstance;

    /**
     * @return The maximum number of user sessions on an instance. This only applies to multi-session fleets.
     * 
     */
    public Optional<Output<Integer>> maxSessionsPerInstance() {
        return Optional.ofNullable(this.maxSessionsPerInstance);
    }

    /**
     * Maximum amount of time that a streaming session can remain active, in seconds.
     * 
     */
    @Import(name="maxUserDurationInSeconds")
    private @Nullable Output<Integer> maxUserDurationInSeconds;

    /**
     * @return Maximum amount of time that a streaming session can remain active, in seconds.
     * 
     */
    public Optional<Output<Integer>> maxUserDurationInSeconds() {
        return Optional.ofNullable(this.maxUserDurationInSeconds);
    }

    /**
     * Unique name for the fleet.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Unique name for the fleet.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * AppStream 2.0 view that is displayed to your users when they stream from the fleet. When `APP` is specified, only the windows of applications opened by users display. When `DESKTOP` is specified, the standard desktop that is provided by the operating system displays. If not specified, defaults to `APP`.
     * 
     */
    @Import(name="streamView")
    private @Nullable Output<String> streamView;

    /**
     * @return AppStream 2.0 view that is displayed to your users when they stream from the fleet. When `APP` is specified, only the windows of applications opened by users display. When `DESKTOP` is specified, the standard desktop that is provided by the operating system displays. If not specified, defaults to `APP`.
     * 
     */
    public Optional<Output<String>> streamView() {
        return Optional.ofNullable(this.streamView);
    }

    /**
     * Map of tags to attach to AppStream instances.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to attach to AppStream instances.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Configuration block for the VPC configuration for the image builder. See below.
     * 
     */
    @Import(name="vpcConfig")
    private @Nullable Output<FleetVpcConfigArgs> vpcConfig;

    /**
     * @return Configuration block for the VPC configuration for the image builder. See below.
     * 
     */
    public Optional<Output<FleetVpcConfigArgs>> vpcConfig() {
        return Optional.ofNullable(this.vpcConfig);
    }

    private FleetArgs() {}

    private FleetArgs(FleetArgs $) {
        this.computeCapacity = $.computeCapacity;
        this.description = $.description;
        this.disconnectTimeoutInSeconds = $.disconnectTimeoutInSeconds;
        this.displayName = $.displayName;
        this.domainJoinInfo = $.domainJoinInfo;
        this.enableDefaultInternetAccess = $.enableDefaultInternetAccess;
        this.fleetType = $.fleetType;
        this.iamRoleArn = $.iamRoleArn;
        this.idleDisconnectTimeoutInSeconds = $.idleDisconnectTimeoutInSeconds;
        this.imageArn = $.imageArn;
        this.imageName = $.imageName;
        this.instanceType = $.instanceType;
        this.maxSessionsPerInstance = $.maxSessionsPerInstance;
        this.maxUserDurationInSeconds = $.maxUserDurationInSeconds;
        this.name = $.name;
        this.streamView = $.streamView;
        this.tags = $.tags;
        this.vpcConfig = $.vpcConfig;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(FleetArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private FleetArgs $;

        public Builder() {
            $ = new FleetArgs();
        }

        public Builder(FleetArgs defaults) {
            $ = new FleetArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param computeCapacity Configuration block for the desired capacity of the fleet. See below.
         * 
         * @return builder
         * 
         */
        public Builder computeCapacity(Output<FleetComputeCapacityArgs> computeCapacity) {
            $.computeCapacity = computeCapacity;
            return this;
        }

        /**
         * @param computeCapacity Configuration block for the desired capacity of the fleet. See below.
         * 
         * @return builder
         * 
         */
        public Builder computeCapacity(FleetComputeCapacityArgs computeCapacity) {
            return computeCapacity(Output.of(computeCapacity));
        }

        /**
         * @param description Description to display.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description to display.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param disconnectTimeoutInSeconds Amount of time that a streaming session remains active after users disconnect.
         * 
         * @return builder
         * 
         */
        public Builder disconnectTimeoutInSeconds(@Nullable Output<Integer> disconnectTimeoutInSeconds) {
            $.disconnectTimeoutInSeconds = disconnectTimeoutInSeconds;
            return this;
        }

        /**
         * @param disconnectTimeoutInSeconds Amount of time that a streaming session remains active after users disconnect.
         * 
         * @return builder
         * 
         */
        public Builder disconnectTimeoutInSeconds(Integer disconnectTimeoutInSeconds) {
            return disconnectTimeoutInSeconds(Output.of(disconnectTimeoutInSeconds));
        }

        /**
         * @param displayName Human-readable friendly name for the AppStream fleet.
         * 
         * @return builder
         * 
         */
        public Builder displayName(@Nullable Output<String> displayName) {
            $.displayName = displayName;
            return this;
        }

        /**
         * @param displayName Human-readable friendly name for the AppStream fleet.
         * 
         * @return builder
         * 
         */
        public Builder displayName(String displayName) {
            return displayName(Output.of(displayName));
        }

        /**
         * @param domainJoinInfo Configuration block for the name of the directory and organizational unit (OU) to use to join the fleet to a Microsoft Active Directory domain. See below.
         * 
         * @return builder
         * 
         */
        public Builder domainJoinInfo(@Nullable Output<FleetDomainJoinInfoArgs> domainJoinInfo) {
            $.domainJoinInfo = domainJoinInfo;
            return this;
        }

        /**
         * @param domainJoinInfo Configuration block for the name of the directory and organizational unit (OU) to use to join the fleet to a Microsoft Active Directory domain. See below.
         * 
         * @return builder
         * 
         */
        public Builder domainJoinInfo(FleetDomainJoinInfoArgs domainJoinInfo) {
            return domainJoinInfo(Output.of(domainJoinInfo));
        }

        /**
         * @param enableDefaultInternetAccess Enables or disables default internet access for the fleet.
         * 
         * @return builder
         * 
         */
        public Builder enableDefaultInternetAccess(@Nullable Output<Boolean> enableDefaultInternetAccess) {
            $.enableDefaultInternetAccess = enableDefaultInternetAccess;
            return this;
        }

        /**
         * @param enableDefaultInternetAccess Enables or disables default internet access for the fleet.
         * 
         * @return builder
         * 
         */
        public Builder enableDefaultInternetAccess(Boolean enableDefaultInternetAccess) {
            return enableDefaultInternetAccess(Output.of(enableDefaultInternetAccess));
        }

        /**
         * @param fleetType Fleet type. Valid values are: `ON_DEMAND`, `ALWAYS_ON`
         * 
         * @return builder
         * 
         */
        public Builder fleetType(@Nullable Output<String> fleetType) {
            $.fleetType = fleetType;
            return this;
        }

        /**
         * @param fleetType Fleet type. Valid values are: `ON_DEMAND`, `ALWAYS_ON`
         * 
         * @return builder
         * 
         */
        public Builder fleetType(String fleetType) {
            return fleetType(Output.of(fleetType));
        }

        /**
         * @param iamRoleArn ARN of the IAM role to apply to the fleet.
         * 
         * @return builder
         * 
         */
        public Builder iamRoleArn(@Nullable Output<String> iamRoleArn) {
            $.iamRoleArn = iamRoleArn;
            return this;
        }

        /**
         * @param iamRoleArn ARN of the IAM role to apply to the fleet.
         * 
         * @return builder
         * 
         */
        public Builder iamRoleArn(String iamRoleArn) {
            return iamRoleArn(Output.of(iamRoleArn));
        }

        /**
         * @param idleDisconnectTimeoutInSeconds Amount of time that users can be idle (inactive) before they are disconnected from their streaming session and the `disconnect_timeout_in_seconds` time interval begins. Defaults to `0`. Valid value is between `60` and ` 3600  `seconds.
         * 
         * @return builder
         * 
         */
        public Builder idleDisconnectTimeoutInSeconds(@Nullable Output<Integer> idleDisconnectTimeoutInSeconds) {
            $.idleDisconnectTimeoutInSeconds = idleDisconnectTimeoutInSeconds;
            return this;
        }

        /**
         * @param idleDisconnectTimeoutInSeconds Amount of time that users can be idle (inactive) before they are disconnected from their streaming session and the `disconnect_timeout_in_seconds` time interval begins. Defaults to `0`. Valid value is between `60` and ` 3600  `seconds.
         * 
         * @return builder
         * 
         */
        public Builder idleDisconnectTimeoutInSeconds(Integer idleDisconnectTimeoutInSeconds) {
            return idleDisconnectTimeoutInSeconds(Output.of(idleDisconnectTimeoutInSeconds));
        }

        /**
         * @param imageArn ARN of the public, private, or shared image to use.
         * 
         * @return builder
         * 
         */
        public Builder imageArn(@Nullable Output<String> imageArn) {
            $.imageArn = imageArn;
            return this;
        }

        /**
         * @param imageArn ARN of the public, private, or shared image to use.
         * 
         * @return builder
         * 
         */
        public Builder imageArn(String imageArn) {
            return imageArn(Output.of(imageArn));
        }

        /**
         * @param imageName Name of the image used to create the fleet.
         * 
         * @return builder
         * 
         */
        public Builder imageName(@Nullable Output<String> imageName) {
            $.imageName = imageName;
            return this;
        }

        /**
         * @param imageName Name of the image used to create the fleet.
         * 
         * @return builder
         * 
         */
        public Builder imageName(String imageName) {
            return imageName(Output.of(imageName));
        }

        /**
         * @param instanceType Instance type to use when launching fleet instances.
         * 
         * @return builder
         * 
         */
        public Builder instanceType(Output<String> instanceType) {
            $.instanceType = instanceType;
            return this;
        }

        /**
         * @param instanceType Instance type to use when launching fleet instances.
         * 
         * @return builder
         * 
         */
        public Builder instanceType(String instanceType) {
            return instanceType(Output.of(instanceType));
        }

        /**
         * @param maxSessionsPerInstance The maximum number of user sessions on an instance. This only applies to multi-session fleets.
         * 
         * @return builder
         * 
         */
        public Builder maxSessionsPerInstance(@Nullable Output<Integer> maxSessionsPerInstance) {
            $.maxSessionsPerInstance = maxSessionsPerInstance;
            return this;
        }

        /**
         * @param maxSessionsPerInstance The maximum number of user sessions on an instance. This only applies to multi-session fleets.
         * 
         * @return builder
         * 
         */
        public Builder maxSessionsPerInstance(Integer maxSessionsPerInstance) {
            return maxSessionsPerInstance(Output.of(maxSessionsPerInstance));
        }

        /**
         * @param maxUserDurationInSeconds Maximum amount of time that a streaming session can remain active, in seconds.
         * 
         * @return builder
         * 
         */
        public Builder maxUserDurationInSeconds(@Nullable Output<Integer> maxUserDurationInSeconds) {
            $.maxUserDurationInSeconds = maxUserDurationInSeconds;
            return this;
        }

        /**
         * @param maxUserDurationInSeconds Maximum amount of time that a streaming session can remain active, in seconds.
         * 
         * @return builder
         * 
         */
        public Builder maxUserDurationInSeconds(Integer maxUserDurationInSeconds) {
            return maxUserDurationInSeconds(Output.of(maxUserDurationInSeconds));
        }

        /**
         * @param name Unique name for the fleet.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Unique name for the fleet.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param streamView AppStream 2.0 view that is displayed to your users when they stream from the fleet. When `APP` is specified, only the windows of applications opened by users display. When `DESKTOP` is specified, the standard desktop that is provided by the operating system displays. If not specified, defaults to `APP`.
         * 
         * @return builder
         * 
         */
        public Builder streamView(@Nullable Output<String> streamView) {
            $.streamView = streamView;
            return this;
        }

        /**
         * @param streamView AppStream 2.0 view that is displayed to your users when they stream from the fleet. When `APP` is specified, only the windows of applications opened by users display. When `DESKTOP` is specified, the standard desktop that is provided by the operating system displays. If not specified, defaults to `APP`.
         * 
         * @return builder
         * 
         */
        public Builder streamView(String streamView) {
            return streamView(Output.of(streamView));
        }

        /**
         * @param tags Map of tags to attach to AppStream instances.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to attach to AppStream instances.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param vpcConfig Configuration block for the VPC configuration for the image builder. See below.
         * 
         * @return builder
         * 
         */
        public Builder vpcConfig(@Nullable Output<FleetVpcConfigArgs> vpcConfig) {
            $.vpcConfig = vpcConfig;
            return this;
        }

        /**
         * @param vpcConfig Configuration block for the VPC configuration for the image builder. See below.
         * 
         * @return builder
         * 
         */
        public Builder vpcConfig(FleetVpcConfigArgs vpcConfig) {
            return vpcConfig(Output.of(vpcConfig));
        }

        public FleetArgs build() {
            if ($.computeCapacity == null) {
                throw new MissingRequiredPropertyException("FleetArgs", "computeCapacity");
            }
            if ($.instanceType == null) {
                throw new MissingRequiredPropertyException("FleetArgs", "instanceType");
            }
            return $;
        }
    }

}
