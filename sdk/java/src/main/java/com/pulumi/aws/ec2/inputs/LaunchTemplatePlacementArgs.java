// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class LaunchTemplatePlacementArgs extends com.pulumi.resources.ResourceArgs {

    public static final LaunchTemplatePlacementArgs Empty = new LaunchTemplatePlacementArgs();

    /**
     * The affinity setting for an instance on a Dedicated Host.
     * 
     */
    @Import(name="affinity")
    private @Nullable Output<String> affinity;

    /**
     * @return The affinity setting for an instance on a Dedicated Host.
     * 
     */
    public Optional<Output<String>> affinity() {
        return Optional.ofNullable(this.affinity);
    }

    /**
     * The Availability Zone for the instance.
     * 
     */
    @Import(name="availabilityZone")
    private @Nullable Output<String> availabilityZone;

    /**
     * @return The Availability Zone for the instance.
     * 
     */
    public Optional<Output<String>> availabilityZone() {
        return Optional.ofNullable(this.availabilityZone);
    }

    /**
     * The name of the placement group for the instance.
     * 
     */
    @Import(name="groupName")
    private @Nullable Output<String> groupName;

    /**
     * @return The name of the placement group for the instance.
     * 
     */
    public Optional<Output<String>> groupName() {
        return Optional.ofNullable(this.groupName);
    }

    /**
     * The ID of the Dedicated Host for the instance.
     * 
     */
    @Import(name="hostId")
    private @Nullable Output<String> hostId;

    /**
     * @return The ID of the Dedicated Host for the instance.
     * 
     */
    public Optional<Output<String>> hostId() {
        return Optional.ofNullable(this.hostId);
    }

    /**
     * The ARN of the Host Resource Group in which to launch instances.
     * 
     */
    @Import(name="hostResourceGroupArn")
    private @Nullable Output<String> hostResourceGroupArn;

    /**
     * @return The ARN of the Host Resource Group in which to launch instances.
     * 
     */
    public Optional<Output<String>> hostResourceGroupArn() {
        return Optional.ofNullable(this.hostResourceGroupArn);
    }

    /**
     * The number of the partition the instance should launch in. Valid only if the placement group strategy is set to partition.
     * 
     */
    @Import(name="partitionNumber")
    private @Nullable Output<Integer> partitionNumber;

    /**
     * @return The number of the partition the instance should launch in. Valid only if the placement group strategy is set to partition.
     * 
     */
    public Optional<Output<Integer>> partitionNumber() {
        return Optional.ofNullable(this.partitionNumber);
    }

    /**
     * Reserved for future use.
     * 
     */
    @Import(name="spreadDomain")
    private @Nullable Output<String> spreadDomain;

    /**
     * @return Reserved for future use.
     * 
     */
    public Optional<Output<String>> spreadDomain() {
        return Optional.ofNullable(this.spreadDomain);
    }

    /**
     * The tenancy of the instance (if the instance is running in a VPC). Can be `default`, `dedicated`, or `host`.
     * 
     */
    @Import(name="tenancy")
    private @Nullable Output<String> tenancy;

    /**
     * @return The tenancy of the instance (if the instance is running in a VPC). Can be `default`, `dedicated`, or `host`.
     * 
     */
    public Optional<Output<String>> tenancy() {
        return Optional.ofNullable(this.tenancy);
    }

    private LaunchTemplatePlacementArgs() {}

    private LaunchTemplatePlacementArgs(LaunchTemplatePlacementArgs $) {
        this.affinity = $.affinity;
        this.availabilityZone = $.availabilityZone;
        this.groupName = $.groupName;
        this.hostId = $.hostId;
        this.hostResourceGroupArn = $.hostResourceGroupArn;
        this.partitionNumber = $.partitionNumber;
        this.spreadDomain = $.spreadDomain;
        this.tenancy = $.tenancy;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(LaunchTemplatePlacementArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private LaunchTemplatePlacementArgs $;

        public Builder() {
            $ = new LaunchTemplatePlacementArgs();
        }

        public Builder(LaunchTemplatePlacementArgs defaults) {
            $ = new LaunchTemplatePlacementArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param affinity The affinity setting for an instance on a Dedicated Host.
         * 
         * @return builder
         * 
         */
        public Builder affinity(@Nullable Output<String> affinity) {
            $.affinity = affinity;
            return this;
        }

        /**
         * @param affinity The affinity setting for an instance on a Dedicated Host.
         * 
         * @return builder
         * 
         */
        public Builder affinity(String affinity) {
            return affinity(Output.of(affinity));
        }

        /**
         * @param availabilityZone The Availability Zone for the instance.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZone(@Nullable Output<String> availabilityZone) {
            $.availabilityZone = availabilityZone;
            return this;
        }

        /**
         * @param availabilityZone The Availability Zone for the instance.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZone(String availabilityZone) {
            return availabilityZone(Output.of(availabilityZone));
        }

        /**
         * @param groupName The name of the placement group for the instance.
         * 
         * @return builder
         * 
         */
        public Builder groupName(@Nullable Output<String> groupName) {
            $.groupName = groupName;
            return this;
        }

        /**
         * @param groupName The name of the placement group for the instance.
         * 
         * @return builder
         * 
         */
        public Builder groupName(String groupName) {
            return groupName(Output.of(groupName));
        }

        /**
         * @param hostId The ID of the Dedicated Host for the instance.
         * 
         * @return builder
         * 
         */
        public Builder hostId(@Nullable Output<String> hostId) {
            $.hostId = hostId;
            return this;
        }

        /**
         * @param hostId The ID of the Dedicated Host for the instance.
         * 
         * @return builder
         * 
         */
        public Builder hostId(String hostId) {
            return hostId(Output.of(hostId));
        }

        /**
         * @param hostResourceGroupArn The ARN of the Host Resource Group in which to launch instances.
         * 
         * @return builder
         * 
         */
        public Builder hostResourceGroupArn(@Nullable Output<String> hostResourceGroupArn) {
            $.hostResourceGroupArn = hostResourceGroupArn;
            return this;
        }

        /**
         * @param hostResourceGroupArn The ARN of the Host Resource Group in which to launch instances.
         * 
         * @return builder
         * 
         */
        public Builder hostResourceGroupArn(String hostResourceGroupArn) {
            return hostResourceGroupArn(Output.of(hostResourceGroupArn));
        }

        /**
         * @param partitionNumber The number of the partition the instance should launch in. Valid only if the placement group strategy is set to partition.
         * 
         * @return builder
         * 
         */
        public Builder partitionNumber(@Nullable Output<Integer> partitionNumber) {
            $.partitionNumber = partitionNumber;
            return this;
        }

        /**
         * @param partitionNumber The number of the partition the instance should launch in. Valid only if the placement group strategy is set to partition.
         * 
         * @return builder
         * 
         */
        public Builder partitionNumber(Integer partitionNumber) {
            return partitionNumber(Output.of(partitionNumber));
        }

        /**
         * @param spreadDomain Reserved for future use.
         * 
         * @return builder
         * 
         */
        public Builder spreadDomain(@Nullable Output<String> spreadDomain) {
            $.spreadDomain = spreadDomain;
            return this;
        }

        /**
         * @param spreadDomain Reserved for future use.
         * 
         * @return builder
         * 
         */
        public Builder spreadDomain(String spreadDomain) {
            return spreadDomain(Output.of(spreadDomain));
        }

        /**
         * @param tenancy The tenancy of the instance (if the instance is running in a VPC). Can be `default`, `dedicated`, or `host`.
         * 
         * @return builder
         * 
         */
        public Builder tenancy(@Nullable Output<String> tenancy) {
            $.tenancy = tenancy;
            return this;
        }

        /**
         * @param tenancy The tenancy of the instance (if the instance is running in a VPC). Can be `default`, `dedicated`, or `host`.
         * 
         * @return builder
         * 
         */
        public Builder tenancy(String tenancy) {
            return tenancy(Output.of(tenancy));
        }

        public LaunchTemplatePlacementArgs build() {
            return $;
        }
    }

}
