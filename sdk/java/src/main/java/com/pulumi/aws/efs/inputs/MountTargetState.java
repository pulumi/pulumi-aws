// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.efs.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class MountTargetState extends com.pulumi.resources.ResourceArgs {

    public static final MountTargetState Empty = new MountTargetState();

    /**
     * The unique and consistent identifier of the Availability Zone (AZ) that the mount target resides in.
     * 
     */
    @Import(name="availabilityZoneId")
    private @Nullable Output<String> availabilityZoneId;

    /**
     * @return The unique and consistent identifier of the Availability Zone (AZ) that the mount target resides in.
     * 
     */
    public Optional<Output<String>> availabilityZoneId() {
        return Optional.ofNullable(this.availabilityZoneId);
    }

    /**
     * The name of the Availability Zone (AZ) that the mount target resides in.
     * 
     */
    @Import(name="availabilityZoneName")
    private @Nullable Output<String> availabilityZoneName;

    /**
     * @return The name of the Availability Zone (AZ) that the mount target resides in.
     * 
     */
    public Optional<Output<String>> availabilityZoneName() {
        return Optional.ofNullable(this.availabilityZoneName);
    }

    /**
     * The DNS name for the EFS file system.
     * 
     */
    @Import(name="dnsName")
    private @Nullable Output<String> dnsName;

    /**
     * @return The DNS name for the EFS file system.
     * 
     */
    public Optional<Output<String>> dnsName() {
        return Optional.ofNullable(this.dnsName);
    }

    /**
     * Amazon Resource Name of the file system.
     * 
     */
    @Import(name="fileSystemArn")
    private @Nullable Output<String> fileSystemArn;

    /**
     * @return Amazon Resource Name of the file system.
     * 
     */
    public Optional<Output<String>> fileSystemArn() {
        return Optional.ofNullable(this.fileSystemArn);
    }

    /**
     * The ID of the file system for which the mount target is intended.
     * 
     */
    @Import(name="fileSystemId")
    private @Nullable Output<String> fileSystemId;

    /**
     * @return The ID of the file system for which the mount target is intended.
     * 
     */
    public Optional<Output<String>> fileSystemId() {
        return Optional.ofNullable(this.fileSystemId);
    }

    /**
     * The address (within the address range of the specified subnet) at
     * which the file system may be mounted via the mount target.
     * 
     */
    @Import(name="ipAddress")
    private @Nullable Output<String> ipAddress;

    /**
     * @return The address (within the address range of the specified subnet) at
     * which the file system may be mounted via the mount target.
     * 
     */
    public Optional<Output<String>> ipAddress() {
        return Optional.ofNullable(this.ipAddress);
    }

    /**
     * The DNS name for the given subnet/AZ per [documented convention](http://docs.aws.amazon.com/efs/latest/ug/mounting-fs-mount-cmd-dns-name.html).
     * 
     */
    @Import(name="mountTargetDnsName")
    private @Nullable Output<String> mountTargetDnsName;

    /**
     * @return The DNS name for the given subnet/AZ per [documented convention](http://docs.aws.amazon.com/efs/latest/ug/mounting-fs-mount-cmd-dns-name.html).
     * 
     */
    public Optional<Output<String>> mountTargetDnsName() {
        return Optional.ofNullable(this.mountTargetDnsName);
    }

    /**
     * The ID of the network interface that Amazon EFS created when it created the mount target.
     * 
     */
    @Import(name="networkInterfaceId")
    private @Nullable Output<String> networkInterfaceId;

    /**
     * @return The ID of the network interface that Amazon EFS created when it created the mount target.
     * 
     */
    public Optional<Output<String>> networkInterfaceId() {
        return Optional.ofNullable(this.networkInterfaceId);
    }

    /**
     * AWS account ID that owns the resource.
     * 
     */
    @Import(name="ownerId")
    private @Nullable Output<String> ownerId;

    /**
     * @return AWS account ID that owns the resource.
     * 
     */
    public Optional<Output<String>> ownerId() {
        return Optional.ofNullable(this.ownerId);
    }

    /**
     * A list of up to 5 VPC security group IDs (that must
     * be for the same VPC as subnet specified) in effect for the mount target.
     * 
     */
    @Import(name="securityGroups")
    private @Nullable Output<List<String>> securityGroups;

    /**
     * @return A list of up to 5 VPC security group IDs (that must
     * be for the same VPC as subnet specified) in effect for the mount target.
     * 
     */
    public Optional<Output<List<String>>> securityGroups() {
        return Optional.ofNullable(this.securityGroups);
    }

    /**
     * The ID of the subnet to add the mount target in.
     * 
     */
    @Import(name="subnetId")
    private @Nullable Output<String> subnetId;

    /**
     * @return The ID of the subnet to add the mount target in.
     * 
     */
    public Optional<Output<String>> subnetId() {
        return Optional.ofNullable(this.subnetId);
    }

    private MountTargetState() {}

    private MountTargetState(MountTargetState $) {
        this.availabilityZoneId = $.availabilityZoneId;
        this.availabilityZoneName = $.availabilityZoneName;
        this.dnsName = $.dnsName;
        this.fileSystemArn = $.fileSystemArn;
        this.fileSystemId = $.fileSystemId;
        this.ipAddress = $.ipAddress;
        this.mountTargetDnsName = $.mountTargetDnsName;
        this.networkInterfaceId = $.networkInterfaceId;
        this.ownerId = $.ownerId;
        this.securityGroups = $.securityGroups;
        this.subnetId = $.subnetId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(MountTargetState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private MountTargetState $;

        public Builder() {
            $ = new MountTargetState();
        }

        public Builder(MountTargetState defaults) {
            $ = new MountTargetState(Objects.requireNonNull(defaults));
        }

        /**
         * @param availabilityZoneId The unique and consistent identifier of the Availability Zone (AZ) that the mount target resides in.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZoneId(@Nullable Output<String> availabilityZoneId) {
            $.availabilityZoneId = availabilityZoneId;
            return this;
        }

        /**
         * @param availabilityZoneId The unique and consistent identifier of the Availability Zone (AZ) that the mount target resides in.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZoneId(String availabilityZoneId) {
            return availabilityZoneId(Output.of(availabilityZoneId));
        }

        /**
         * @param availabilityZoneName The name of the Availability Zone (AZ) that the mount target resides in.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZoneName(@Nullable Output<String> availabilityZoneName) {
            $.availabilityZoneName = availabilityZoneName;
            return this;
        }

        /**
         * @param availabilityZoneName The name of the Availability Zone (AZ) that the mount target resides in.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZoneName(String availabilityZoneName) {
            return availabilityZoneName(Output.of(availabilityZoneName));
        }

        /**
         * @param dnsName The DNS name for the EFS file system.
         * 
         * @return builder
         * 
         */
        public Builder dnsName(@Nullable Output<String> dnsName) {
            $.dnsName = dnsName;
            return this;
        }

        /**
         * @param dnsName The DNS name for the EFS file system.
         * 
         * @return builder
         * 
         */
        public Builder dnsName(String dnsName) {
            return dnsName(Output.of(dnsName));
        }

        /**
         * @param fileSystemArn Amazon Resource Name of the file system.
         * 
         * @return builder
         * 
         */
        public Builder fileSystemArn(@Nullable Output<String> fileSystemArn) {
            $.fileSystemArn = fileSystemArn;
            return this;
        }

        /**
         * @param fileSystemArn Amazon Resource Name of the file system.
         * 
         * @return builder
         * 
         */
        public Builder fileSystemArn(String fileSystemArn) {
            return fileSystemArn(Output.of(fileSystemArn));
        }

        /**
         * @param fileSystemId The ID of the file system for which the mount target is intended.
         * 
         * @return builder
         * 
         */
        public Builder fileSystemId(@Nullable Output<String> fileSystemId) {
            $.fileSystemId = fileSystemId;
            return this;
        }

        /**
         * @param fileSystemId The ID of the file system for which the mount target is intended.
         * 
         * @return builder
         * 
         */
        public Builder fileSystemId(String fileSystemId) {
            return fileSystemId(Output.of(fileSystemId));
        }

        /**
         * @param ipAddress The address (within the address range of the specified subnet) at
         * which the file system may be mounted via the mount target.
         * 
         * @return builder
         * 
         */
        public Builder ipAddress(@Nullable Output<String> ipAddress) {
            $.ipAddress = ipAddress;
            return this;
        }

        /**
         * @param ipAddress The address (within the address range of the specified subnet) at
         * which the file system may be mounted via the mount target.
         * 
         * @return builder
         * 
         */
        public Builder ipAddress(String ipAddress) {
            return ipAddress(Output.of(ipAddress));
        }

        /**
         * @param mountTargetDnsName The DNS name for the given subnet/AZ per [documented convention](http://docs.aws.amazon.com/efs/latest/ug/mounting-fs-mount-cmd-dns-name.html).
         * 
         * @return builder
         * 
         */
        public Builder mountTargetDnsName(@Nullable Output<String> mountTargetDnsName) {
            $.mountTargetDnsName = mountTargetDnsName;
            return this;
        }

        /**
         * @param mountTargetDnsName The DNS name for the given subnet/AZ per [documented convention](http://docs.aws.amazon.com/efs/latest/ug/mounting-fs-mount-cmd-dns-name.html).
         * 
         * @return builder
         * 
         */
        public Builder mountTargetDnsName(String mountTargetDnsName) {
            return mountTargetDnsName(Output.of(mountTargetDnsName));
        }

        /**
         * @param networkInterfaceId The ID of the network interface that Amazon EFS created when it created the mount target.
         * 
         * @return builder
         * 
         */
        public Builder networkInterfaceId(@Nullable Output<String> networkInterfaceId) {
            $.networkInterfaceId = networkInterfaceId;
            return this;
        }

        /**
         * @param networkInterfaceId The ID of the network interface that Amazon EFS created when it created the mount target.
         * 
         * @return builder
         * 
         */
        public Builder networkInterfaceId(String networkInterfaceId) {
            return networkInterfaceId(Output.of(networkInterfaceId));
        }

        /**
         * @param ownerId AWS account ID that owns the resource.
         * 
         * @return builder
         * 
         */
        public Builder ownerId(@Nullable Output<String> ownerId) {
            $.ownerId = ownerId;
            return this;
        }

        /**
         * @param ownerId AWS account ID that owns the resource.
         * 
         * @return builder
         * 
         */
        public Builder ownerId(String ownerId) {
            return ownerId(Output.of(ownerId));
        }

        /**
         * @param securityGroups A list of up to 5 VPC security group IDs (that must
         * be for the same VPC as subnet specified) in effect for the mount target.
         * 
         * @return builder
         * 
         */
        public Builder securityGroups(@Nullable Output<List<String>> securityGroups) {
            $.securityGroups = securityGroups;
            return this;
        }

        /**
         * @param securityGroups A list of up to 5 VPC security group IDs (that must
         * be for the same VPC as subnet specified) in effect for the mount target.
         * 
         * @return builder
         * 
         */
        public Builder securityGroups(List<String> securityGroups) {
            return securityGroups(Output.of(securityGroups));
        }

        /**
         * @param securityGroups A list of up to 5 VPC security group IDs (that must
         * be for the same VPC as subnet specified) in effect for the mount target.
         * 
         * @return builder
         * 
         */
        public Builder securityGroups(String... securityGroups) {
            return securityGroups(List.of(securityGroups));
        }

        /**
         * @param subnetId The ID of the subnet to add the mount target in.
         * 
         * @return builder
         * 
         */
        public Builder subnetId(@Nullable Output<String> subnetId) {
            $.subnetId = subnetId;
            return this;
        }

        /**
         * @param subnetId The ID of the subnet to add the mount target in.
         * 
         * @return builder
         * 
         */
        public Builder subnetId(String subnetId) {
            return subnetId(Output.of(subnetId));
        }

        public MountTargetState build() {
            return $;
        }
    }

}
