// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fsx;

import com.pulumi.aws.fsx.inputs.OntapFileSystemDiskIopsConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class OntapFileSystemArgs extends com.pulumi.resources.ResourceArgs {

    public static final OntapFileSystemArgs Empty = new OntapFileSystemArgs();

    /**
     * The number of days to retain automatic backups. Setting this to 0 disables automatic backups. You can retain automatic backups for a maximum of 90 days.
     * 
     */
    @Import(name="automaticBackupRetentionDays")
    private @Nullable Output<Integer> automaticBackupRetentionDays;

    /**
     * @return The number of days to retain automatic backups. Setting this to 0 disables automatic backups. You can retain automatic backups for a maximum of 90 days.
     * 
     */
    public Optional<Output<Integer>> automaticBackupRetentionDays() {
        return Optional.ofNullable(this.automaticBackupRetentionDays);
    }

    /**
     * A recurring daily time, in the format HH:MM. HH is the zero-padded hour of the day (0-23), and MM is the zero-padded minute of the hour. For example, 05:00 specifies 5 AM daily. Requires `automatic_backup_retention_days` to be set.
     * 
     */
    @Import(name="dailyAutomaticBackupStartTime")
    private @Nullable Output<String> dailyAutomaticBackupStartTime;

    /**
     * @return A recurring daily time, in the format HH:MM. HH is the zero-padded hour of the day (0-23), and MM is the zero-padded minute of the hour. For example, 05:00 specifies 5 AM daily. Requires `automatic_backup_retention_days` to be set.
     * 
     */
    public Optional<Output<String>> dailyAutomaticBackupStartTime() {
        return Optional.ofNullable(this.dailyAutomaticBackupStartTime);
    }

    /**
     * The filesystem deployment type. Supports `MULTI_AZ_1`, `MULTI_AZ_2`, `SINGLE_AZ_1`, and `SINGLE_AZ_2`.
     * 
     */
    @Import(name="deploymentType", required=true)
    private Output<String> deploymentType;

    /**
     * @return The filesystem deployment type. Supports `MULTI_AZ_1`, `MULTI_AZ_2`, `SINGLE_AZ_1`, and `SINGLE_AZ_2`.
     * 
     */
    public Output<String> deploymentType() {
        return this.deploymentType;
    }

    /**
     * The SSD IOPS configuration for the Amazon FSx for NetApp ONTAP file system. See Disk Iops Configuration below.
     * 
     */
    @Import(name="diskIopsConfiguration")
    private @Nullable Output<OntapFileSystemDiskIopsConfigurationArgs> diskIopsConfiguration;

    /**
     * @return The SSD IOPS configuration for the Amazon FSx for NetApp ONTAP file system. See Disk Iops Configuration below.
     * 
     */
    public Optional<Output<OntapFileSystemDiskIopsConfigurationArgs>> diskIopsConfiguration() {
        return Optional.ofNullable(this.diskIopsConfiguration);
    }

    /**
     * Specifies the IP address range in which the endpoints to access your file system will be created. By default, Amazon FSx selects an unused IP address range for you from the 198.19.* range.
     * 
     */
    @Import(name="endpointIpAddressRange")
    private @Nullable Output<String> endpointIpAddressRange;

    /**
     * @return Specifies the IP address range in which the endpoints to access your file system will be created. By default, Amazon FSx selects an unused IP address range for you from the 198.19.* range.
     * 
     */
    public Optional<Output<String>> endpointIpAddressRange() {
        return Optional.ofNullable(this.endpointIpAddressRange);
    }

    /**
     * The ONTAP administrative password for the fsxadmin user that you can use to administer your file system using the ONTAP CLI and REST API.
     * 
     */
    @Import(name="fsxAdminPassword")
    private @Nullable Output<String> fsxAdminPassword;

    /**
     * @return The ONTAP administrative password for the fsxadmin user that you can use to administer your file system using the ONTAP CLI and REST API.
     * 
     */
    public Optional<Output<String>> fsxAdminPassword() {
        return Optional.ofNullable(this.fsxAdminPassword);
    }

    /**
     * The number of ha_pairs to deploy for the file system. Valid value is 1 for `SINGLE_AZ_1` or `MULTI_AZ_1` and `MULTI_AZ_2`. Valid values are 1 through 12 for `SINGLE_AZ_2`.
     * 
     */
    @Import(name="haPairs")
    private @Nullable Output<Integer> haPairs;

    /**
     * @return The number of ha_pairs to deploy for the file system. Valid value is 1 for `SINGLE_AZ_1` or `MULTI_AZ_1` and `MULTI_AZ_2`. Valid values are 1 through 12 for `SINGLE_AZ_2`.
     * 
     */
    public Optional<Output<Integer>> haPairs() {
        return Optional.ofNullable(this.haPairs);
    }

    /**
     * ARN for the KMS Key to encrypt the file system at rest, Defaults to an AWS managed KMS Key.
     * 
     */
    @Import(name="kmsKeyId")
    private @Nullable Output<String> kmsKeyId;

    /**
     * @return ARN for the KMS Key to encrypt the file system at rest, Defaults to an AWS managed KMS Key.
     * 
     */
    public Optional<Output<String>> kmsKeyId() {
        return Optional.ofNullable(this.kmsKeyId);
    }

    /**
     * The ID for a subnet. A subnet is a range of IP addresses in your virtual private cloud (VPC).
     * 
     */
    @Import(name="preferredSubnetId", required=true)
    private Output<String> preferredSubnetId;

    /**
     * @return The ID for a subnet. A subnet is a range of IP addresses in your virtual private cloud (VPC).
     * 
     */
    public Output<String> preferredSubnetId() {
        return this.preferredSubnetId;
    }

    /**
     * Specifies the VPC route tables in which your file system&#39;s endpoints will be created. You should specify all VPC route tables associated with the subnets in which your clients are located. By default, Amazon FSx selects your VPC&#39;s default route table.
     * 
     */
    @Import(name="routeTableIds")
    private @Nullable Output<List<String>> routeTableIds;

    /**
     * @return Specifies the VPC route tables in which your file system&#39;s endpoints will be created. You should specify all VPC route tables associated with the subnets in which your clients are located. By default, Amazon FSx selects your VPC&#39;s default route table.
     * 
     */
    public Optional<Output<List<String>>> routeTableIds() {
        return Optional.ofNullable(this.routeTableIds);
    }

    /**
     * A list of IDs for the security groups that apply to the specified network interfaces created for file system access. These security groups will apply to all network interfaces.
     * 
     */
    @Import(name="securityGroupIds")
    private @Nullable Output<List<String>> securityGroupIds;

    /**
     * @return A list of IDs for the security groups that apply to the specified network interfaces created for file system access. These security groups will apply to all network interfaces.
     * 
     */
    public Optional<Output<List<String>>> securityGroupIds() {
        return Optional.ofNullable(this.securityGroupIds);
    }

    /**
     * The storage capacity (GiB) of the file system. Valid values between `1024` and `196608` for file systems with deployment_type `SINGLE_AZ_1` and `MULTI_AZ_1`. Valid values are between `1024` and `524288` for `MULTI_AZ_2`. Valid values between `1024` (`1024` per ha pair) and `1048576` for file systems with deployment_type `SINGLE_AZ_2`. For `SINGLE_AZ_2`, the `1048576` (1PB) maximum is only supported when using 2 or more ha_pairs, the maximum is `524288` (512TB) when using 1 ha_pair.
     * 
     */
    @Import(name="storageCapacity", required=true)
    private Output<Integer> storageCapacity;

    /**
     * @return The storage capacity (GiB) of the file system. Valid values between `1024` and `196608` for file systems with deployment_type `SINGLE_AZ_1` and `MULTI_AZ_1`. Valid values are between `1024` and `524288` for `MULTI_AZ_2`. Valid values between `1024` (`1024` per ha pair) and `1048576` for file systems with deployment_type `SINGLE_AZ_2`. For `SINGLE_AZ_2`, the `1048576` (1PB) maximum is only supported when using 2 or more ha_pairs, the maximum is `524288` (512TB) when using 1 ha_pair.
     * 
     */
    public Output<Integer> storageCapacity() {
        return this.storageCapacity;
    }

    /**
     * The filesystem storage type. defaults to `SSD`.
     * 
     */
    @Import(name="storageType")
    private @Nullable Output<String> storageType;

    /**
     * @return The filesystem storage type. defaults to `SSD`.
     * 
     */
    public Optional<Output<String>> storageType() {
        return Optional.ofNullable(this.storageType);
    }

    /**
     * A list of IDs for the subnets that the file system will be accessible from. Up to 2 subnets can be provided.
     * 
     */
    @Import(name="subnetIds", required=true)
    private Output<List<String>> subnetIds;

    /**
     * @return A list of IDs for the subnets that the file system will be accessible from. Up to 2 subnets can be provided.
     * 
     */
    public Output<List<String>> subnetIds() {
        return this.subnetIds;
    }

    /**
     * A map of tags to assign to the file system. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the file system. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Sets the throughput capacity (in MBps) for the file system that you&#39;re creating. Valid values are `128`, `256`, `512`, `1024`, `2048`, and `4096`. This parameter is only supported when not using the ha_pairs parameter. Either throughput_capacity or throughput_capacity_per_ha_pair must be specified.
     * 
     */
    @Import(name="throughputCapacity")
    private @Nullable Output<Integer> throughputCapacity;

    /**
     * @return Sets the throughput capacity (in MBps) for the file system that you&#39;re creating. Valid values are `128`, `256`, `512`, `1024`, `2048`, and `4096`. This parameter is only supported when not using the ha_pairs parameter. Either throughput_capacity or throughput_capacity_per_ha_pair must be specified.
     * 
     */
    public Optional<Output<Integer>> throughputCapacity() {
        return Optional.ofNullable(this.throughputCapacity);
    }

    /**
     * Sets the per-HA-pair throughput capacity (in MBps) for the file system that you&#39;re creating, as opposed to `throughput_capacity` which specifies the total throughput capacity for the file system. Valid value for `MULTI_AZ_1` and `SINGLE_AZ_1` are `128`, `256`, `512`, `1024`, `2048`, and `4096`. Valid values for deployment type `MULTI_AZ_2` and `SINGLE_AZ_2` are `384`,`768`,`1536`,`3072`,`6144` where `ha_pairs` is `1`. Valid values for deployment type `SINGLE_AZ_2` are `1536`, `3072`, and `6144` where `ha_pairs` is greater than 1. This parameter is only supported when specifying the ha_pairs parameter. Either throughput_capacity or throughput_capacity_per_ha_pair must be specified.
     * 
     */
    @Import(name="throughputCapacityPerHaPair")
    private @Nullable Output<Integer> throughputCapacityPerHaPair;

    /**
     * @return Sets the per-HA-pair throughput capacity (in MBps) for the file system that you&#39;re creating, as opposed to `throughput_capacity` which specifies the total throughput capacity for the file system. Valid value for `MULTI_AZ_1` and `SINGLE_AZ_1` are `128`, `256`, `512`, `1024`, `2048`, and `4096`. Valid values for deployment type `MULTI_AZ_2` and `SINGLE_AZ_2` are `384`,`768`,`1536`,`3072`,`6144` where `ha_pairs` is `1`. Valid values for deployment type `SINGLE_AZ_2` are `1536`, `3072`, and `6144` where `ha_pairs` is greater than 1. This parameter is only supported when specifying the ha_pairs parameter. Either throughput_capacity or throughput_capacity_per_ha_pair must be specified.
     * 
     */
    public Optional<Output<Integer>> throughputCapacityPerHaPair() {
        return Optional.ofNullable(this.throughputCapacityPerHaPair);
    }

    /**
     * The preferred start time (in `d:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
     * 
     */
    @Import(name="weeklyMaintenanceStartTime")
    private @Nullable Output<String> weeklyMaintenanceStartTime;

    /**
     * @return The preferred start time (in `d:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
     * 
     */
    public Optional<Output<String>> weeklyMaintenanceStartTime() {
        return Optional.ofNullable(this.weeklyMaintenanceStartTime);
    }

    private OntapFileSystemArgs() {}

    private OntapFileSystemArgs(OntapFileSystemArgs $) {
        this.automaticBackupRetentionDays = $.automaticBackupRetentionDays;
        this.dailyAutomaticBackupStartTime = $.dailyAutomaticBackupStartTime;
        this.deploymentType = $.deploymentType;
        this.diskIopsConfiguration = $.diskIopsConfiguration;
        this.endpointIpAddressRange = $.endpointIpAddressRange;
        this.fsxAdminPassword = $.fsxAdminPassword;
        this.haPairs = $.haPairs;
        this.kmsKeyId = $.kmsKeyId;
        this.preferredSubnetId = $.preferredSubnetId;
        this.routeTableIds = $.routeTableIds;
        this.securityGroupIds = $.securityGroupIds;
        this.storageCapacity = $.storageCapacity;
        this.storageType = $.storageType;
        this.subnetIds = $.subnetIds;
        this.tags = $.tags;
        this.throughputCapacity = $.throughputCapacity;
        this.throughputCapacityPerHaPair = $.throughputCapacityPerHaPair;
        this.weeklyMaintenanceStartTime = $.weeklyMaintenanceStartTime;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(OntapFileSystemArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private OntapFileSystemArgs $;

        public Builder() {
            $ = new OntapFileSystemArgs();
        }

        public Builder(OntapFileSystemArgs defaults) {
            $ = new OntapFileSystemArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param automaticBackupRetentionDays The number of days to retain automatic backups. Setting this to 0 disables automatic backups. You can retain automatic backups for a maximum of 90 days.
         * 
         * @return builder
         * 
         */
        public Builder automaticBackupRetentionDays(@Nullable Output<Integer> automaticBackupRetentionDays) {
            $.automaticBackupRetentionDays = automaticBackupRetentionDays;
            return this;
        }

        /**
         * @param automaticBackupRetentionDays The number of days to retain automatic backups. Setting this to 0 disables automatic backups. You can retain automatic backups for a maximum of 90 days.
         * 
         * @return builder
         * 
         */
        public Builder automaticBackupRetentionDays(Integer automaticBackupRetentionDays) {
            return automaticBackupRetentionDays(Output.of(automaticBackupRetentionDays));
        }

        /**
         * @param dailyAutomaticBackupStartTime A recurring daily time, in the format HH:MM. HH is the zero-padded hour of the day (0-23), and MM is the zero-padded minute of the hour. For example, 05:00 specifies 5 AM daily. Requires `automatic_backup_retention_days` to be set.
         * 
         * @return builder
         * 
         */
        public Builder dailyAutomaticBackupStartTime(@Nullable Output<String> dailyAutomaticBackupStartTime) {
            $.dailyAutomaticBackupStartTime = dailyAutomaticBackupStartTime;
            return this;
        }

        /**
         * @param dailyAutomaticBackupStartTime A recurring daily time, in the format HH:MM. HH is the zero-padded hour of the day (0-23), and MM is the zero-padded minute of the hour. For example, 05:00 specifies 5 AM daily. Requires `automatic_backup_retention_days` to be set.
         * 
         * @return builder
         * 
         */
        public Builder dailyAutomaticBackupStartTime(String dailyAutomaticBackupStartTime) {
            return dailyAutomaticBackupStartTime(Output.of(dailyAutomaticBackupStartTime));
        }

        /**
         * @param deploymentType The filesystem deployment type. Supports `MULTI_AZ_1`, `MULTI_AZ_2`, `SINGLE_AZ_1`, and `SINGLE_AZ_2`.
         * 
         * @return builder
         * 
         */
        public Builder deploymentType(Output<String> deploymentType) {
            $.deploymentType = deploymentType;
            return this;
        }

        /**
         * @param deploymentType The filesystem deployment type. Supports `MULTI_AZ_1`, `MULTI_AZ_2`, `SINGLE_AZ_1`, and `SINGLE_AZ_2`.
         * 
         * @return builder
         * 
         */
        public Builder deploymentType(String deploymentType) {
            return deploymentType(Output.of(deploymentType));
        }

        /**
         * @param diskIopsConfiguration The SSD IOPS configuration for the Amazon FSx for NetApp ONTAP file system. See Disk Iops Configuration below.
         * 
         * @return builder
         * 
         */
        public Builder diskIopsConfiguration(@Nullable Output<OntapFileSystemDiskIopsConfigurationArgs> diskIopsConfiguration) {
            $.diskIopsConfiguration = diskIopsConfiguration;
            return this;
        }

        /**
         * @param diskIopsConfiguration The SSD IOPS configuration for the Amazon FSx for NetApp ONTAP file system. See Disk Iops Configuration below.
         * 
         * @return builder
         * 
         */
        public Builder diskIopsConfiguration(OntapFileSystemDiskIopsConfigurationArgs diskIopsConfiguration) {
            return diskIopsConfiguration(Output.of(diskIopsConfiguration));
        }

        /**
         * @param endpointIpAddressRange Specifies the IP address range in which the endpoints to access your file system will be created. By default, Amazon FSx selects an unused IP address range for you from the 198.19.* range.
         * 
         * @return builder
         * 
         */
        public Builder endpointIpAddressRange(@Nullable Output<String> endpointIpAddressRange) {
            $.endpointIpAddressRange = endpointIpAddressRange;
            return this;
        }

        /**
         * @param endpointIpAddressRange Specifies the IP address range in which the endpoints to access your file system will be created. By default, Amazon FSx selects an unused IP address range for you from the 198.19.* range.
         * 
         * @return builder
         * 
         */
        public Builder endpointIpAddressRange(String endpointIpAddressRange) {
            return endpointIpAddressRange(Output.of(endpointIpAddressRange));
        }

        /**
         * @param fsxAdminPassword The ONTAP administrative password for the fsxadmin user that you can use to administer your file system using the ONTAP CLI and REST API.
         * 
         * @return builder
         * 
         */
        public Builder fsxAdminPassword(@Nullable Output<String> fsxAdminPassword) {
            $.fsxAdminPassword = fsxAdminPassword;
            return this;
        }

        /**
         * @param fsxAdminPassword The ONTAP administrative password for the fsxadmin user that you can use to administer your file system using the ONTAP CLI and REST API.
         * 
         * @return builder
         * 
         */
        public Builder fsxAdminPassword(String fsxAdminPassword) {
            return fsxAdminPassword(Output.of(fsxAdminPassword));
        }

        /**
         * @param haPairs The number of ha_pairs to deploy for the file system. Valid value is 1 for `SINGLE_AZ_1` or `MULTI_AZ_1` and `MULTI_AZ_2`. Valid values are 1 through 12 for `SINGLE_AZ_2`.
         * 
         * @return builder
         * 
         */
        public Builder haPairs(@Nullable Output<Integer> haPairs) {
            $.haPairs = haPairs;
            return this;
        }

        /**
         * @param haPairs The number of ha_pairs to deploy for the file system. Valid value is 1 for `SINGLE_AZ_1` or `MULTI_AZ_1` and `MULTI_AZ_2`. Valid values are 1 through 12 for `SINGLE_AZ_2`.
         * 
         * @return builder
         * 
         */
        public Builder haPairs(Integer haPairs) {
            return haPairs(Output.of(haPairs));
        }

        /**
         * @param kmsKeyId ARN for the KMS Key to encrypt the file system at rest, Defaults to an AWS managed KMS Key.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(@Nullable Output<String> kmsKeyId) {
            $.kmsKeyId = kmsKeyId;
            return this;
        }

        /**
         * @param kmsKeyId ARN for the KMS Key to encrypt the file system at rest, Defaults to an AWS managed KMS Key.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(String kmsKeyId) {
            return kmsKeyId(Output.of(kmsKeyId));
        }

        /**
         * @param preferredSubnetId The ID for a subnet. A subnet is a range of IP addresses in your virtual private cloud (VPC).
         * 
         * @return builder
         * 
         */
        public Builder preferredSubnetId(Output<String> preferredSubnetId) {
            $.preferredSubnetId = preferredSubnetId;
            return this;
        }

        /**
         * @param preferredSubnetId The ID for a subnet. A subnet is a range of IP addresses in your virtual private cloud (VPC).
         * 
         * @return builder
         * 
         */
        public Builder preferredSubnetId(String preferredSubnetId) {
            return preferredSubnetId(Output.of(preferredSubnetId));
        }

        /**
         * @param routeTableIds Specifies the VPC route tables in which your file system&#39;s endpoints will be created. You should specify all VPC route tables associated with the subnets in which your clients are located. By default, Amazon FSx selects your VPC&#39;s default route table.
         * 
         * @return builder
         * 
         */
        public Builder routeTableIds(@Nullable Output<List<String>> routeTableIds) {
            $.routeTableIds = routeTableIds;
            return this;
        }

        /**
         * @param routeTableIds Specifies the VPC route tables in which your file system&#39;s endpoints will be created. You should specify all VPC route tables associated with the subnets in which your clients are located. By default, Amazon FSx selects your VPC&#39;s default route table.
         * 
         * @return builder
         * 
         */
        public Builder routeTableIds(List<String> routeTableIds) {
            return routeTableIds(Output.of(routeTableIds));
        }

        /**
         * @param routeTableIds Specifies the VPC route tables in which your file system&#39;s endpoints will be created. You should specify all VPC route tables associated with the subnets in which your clients are located. By default, Amazon FSx selects your VPC&#39;s default route table.
         * 
         * @return builder
         * 
         */
        public Builder routeTableIds(String... routeTableIds) {
            return routeTableIds(List.of(routeTableIds));
        }

        /**
         * @param securityGroupIds A list of IDs for the security groups that apply to the specified network interfaces created for file system access. These security groups will apply to all network interfaces.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(@Nullable Output<List<String>> securityGroupIds) {
            $.securityGroupIds = securityGroupIds;
            return this;
        }

        /**
         * @param securityGroupIds A list of IDs for the security groups that apply to the specified network interfaces created for file system access. These security groups will apply to all network interfaces.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(List<String> securityGroupIds) {
            return securityGroupIds(Output.of(securityGroupIds));
        }

        /**
         * @param securityGroupIds A list of IDs for the security groups that apply to the specified network interfaces created for file system access. These security groups will apply to all network interfaces.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(String... securityGroupIds) {
            return securityGroupIds(List.of(securityGroupIds));
        }

        /**
         * @param storageCapacity The storage capacity (GiB) of the file system. Valid values between `1024` and `196608` for file systems with deployment_type `SINGLE_AZ_1` and `MULTI_AZ_1`. Valid values are between `1024` and `524288` for `MULTI_AZ_2`. Valid values between `1024` (`1024` per ha pair) and `1048576` for file systems with deployment_type `SINGLE_AZ_2`. For `SINGLE_AZ_2`, the `1048576` (1PB) maximum is only supported when using 2 or more ha_pairs, the maximum is `524288` (512TB) when using 1 ha_pair.
         * 
         * @return builder
         * 
         */
        public Builder storageCapacity(Output<Integer> storageCapacity) {
            $.storageCapacity = storageCapacity;
            return this;
        }

        /**
         * @param storageCapacity The storage capacity (GiB) of the file system. Valid values between `1024` and `196608` for file systems with deployment_type `SINGLE_AZ_1` and `MULTI_AZ_1`. Valid values are between `1024` and `524288` for `MULTI_AZ_2`. Valid values between `1024` (`1024` per ha pair) and `1048576` for file systems with deployment_type `SINGLE_AZ_2`. For `SINGLE_AZ_2`, the `1048576` (1PB) maximum is only supported when using 2 or more ha_pairs, the maximum is `524288` (512TB) when using 1 ha_pair.
         * 
         * @return builder
         * 
         */
        public Builder storageCapacity(Integer storageCapacity) {
            return storageCapacity(Output.of(storageCapacity));
        }

        /**
         * @param storageType The filesystem storage type. defaults to `SSD`.
         * 
         * @return builder
         * 
         */
        public Builder storageType(@Nullable Output<String> storageType) {
            $.storageType = storageType;
            return this;
        }

        /**
         * @param storageType The filesystem storage type. defaults to `SSD`.
         * 
         * @return builder
         * 
         */
        public Builder storageType(String storageType) {
            return storageType(Output.of(storageType));
        }

        /**
         * @param subnetIds A list of IDs for the subnets that the file system will be accessible from. Up to 2 subnets can be provided.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(Output<List<String>> subnetIds) {
            $.subnetIds = subnetIds;
            return this;
        }

        /**
         * @param subnetIds A list of IDs for the subnets that the file system will be accessible from. Up to 2 subnets can be provided.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(List<String> subnetIds) {
            return subnetIds(Output.of(subnetIds));
        }

        /**
         * @param subnetIds A list of IDs for the subnets that the file system will be accessible from. Up to 2 subnets can be provided.
         * 
         * @return builder
         * 
         */
        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }

        /**
         * @param tags A map of tags to assign to the file system. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the file system. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param throughputCapacity Sets the throughput capacity (in MBps) for the file system that you&#39;re creating. Valid values are `128`, `256`, `512`, `1024`, `2048`, and `4096`. This parameter is only supported when not using the ha_pairs parameter. Either throughput_capacity or throughput_capacity_per_ha_pair must be specified.
         * 
         * @return builder
         * 
         */
        public Builder throughputCapacity(@Nullable Output<Integer> throughputCapacity) {
            $.throughputCapacity = throughputCapacity;
            return this;
        }

        /**
         * @param throughputCapacity Sets the throughput capacity (in MBps) for the file system that you&#39;re creating. Valid values are `128`, `256`, `512`, `1024`, `2048`, and `4096`. This parameter is only supported when not using the ha_pairs parameter. Either throughput_capacity or throughput_capacity_per_ha_pair must be specified.
         * 
         * @return builder
         * 
         */
        public Builder throughputCapacity(Integer throughputCapacity) {
            return throughputCapacity(Output.of(throughputCapacity));
        }

        /**
         * @param throughputCapacityPerHaPair Sets the per-HA-pair throughput capacity (in MBps) for the file system that you&#39;re creating, as opposed to `throughput_capacity` which specifies the total throughput capacity for the file system. Valid value for `MULTI_AZ_1` and `SINGLE_AZ_1` are `128`, `256`, `512`, `1024`, `2048`, and `4096`. Valid values for deployment type `MULTI_AZ_2` and `SINGLE_AZ_2` are `384`,`768`,`1536`,`3072`,`6144` where `ha_pairs` is `1`. Valid values for deployment type `SINGLE_AZ_2` are `1536`, `3072`, and `6144` where `ha_pairs` is greater than 1. This parameter is only supported when specifying the ha_pairs parameter. Either throughput_capacity or throughput_capacity_per_ha_pair must be specified.
         * 
         * @return builder
         * 
         */
        public Builder throughputCapacityPerHaPair(@Nullable Output<Integer> throughputCapacityPerHaPair) {
            $.throughputCapacityPerHaPair = throughputCapacityPerHaPair;
            return this;
        }

        /**
         * @param throughputCapacityPerHaPair Sets the per-HA-pair throughput capacity (in MBps) for the file system that you&#39;re creating, as opposed to `throughput_capacity` which specifies the total throughput capacity for the file system. Valid value for `MULTI_AZ_1` and `SINGLE_AZ_1` are `128`, `256`, `512`, `1024`, `2048`, and `4096`. Valid values for deployment type `MULTI_AZ_2` and `SINGLE_AZ_2` are `384`,`768`,`1536`,`3072`,`6144` where `ha_pairs` is `1`. Valid values for deployment type `SINGLE_AZ_2` are `1536`, `3072`, and `6144` where `ha_pairs` is greater than 1. This parameter is only supported when specifying the ha_pairs parameter. Either throughput_capacity or throughput_capacity_per_ha_pair must be specified.
         * 
         * @return builder
         * 
         */
        public Builder throughputCapacityPerHaPair(Integer throughputCapacityPerHaPair) {
            return throughputCapacityPerHaPair(Output.of(throughputCapacityPerHaPair));
        }

        /**
         * @param weeklyMaintenanceStartTime The preferred start time (in `d:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
         * 
         * @return builder
         * 
         */
        public Builder weeklyMaintenanceStartTime(@Nullable Output<String> weeklyMaintenanceStartTime) {
            $.weeklyMaintenanceStartTime = weeklyMaintenanceStartTime;
            return this;
        }

        /**
         * @param weeklyMaintenanceStartTime The preferred start time (in `d:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
         * 
         * @return builder
         * 
         */
        public Builder weeklyMaintenanceStartTime(String weeklyMaintenanceStartTime) {
            return weeklyMaintenanceStartTime(Output.of(weeklyMaintenanceStartTime));
        }

        public OntapFileSystemArgs build() {
            if ($.deploymentType == null) {
                throw new MissingRequiredPropertyException("OntapFileSystemArgs", "deploymentType");
            }
            if ($.preferredSubnetId == null) {
                throw new MissingRequiredPropertyException("OntapFileSystemArgs", "preferredSubnetId");
            }
            if ($.storageCapacity == null) {
                throw new MissingRequiredPropertyException("OntapFileSystemArgs", "storageCapacity");
            }
            if ($.subnetIds == null) {
                throw new MissingRequiredPropertyException("OntapFileSystemArgs", "subnetIds");
            }
            return $;
        }
    }

}
