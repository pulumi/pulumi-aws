// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecs.outputs;

import com.pulumi.aws.ecs.outputs.ServiceVolumeConfigurationManagedEbsVolumeTagSpecification;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ServiceVolumeConfigurationManagedEbsVolume {
    /**
     * @return Whether the volume should be encrypted. Default value is `true`.
     * 
     */
    private @Nullable Boolean encrypted;
    /**
     * @return Linux filesystem type for the volume. For volumes created from a snapshot, same filesystem type must be specified that the volume was using when the snapshot was created. Valid values are `ext3`, `ext4`, `xfs`. Default value is `xfs`.
     * 
     */
    private @Nullable String fileSystemType;
    /**
     * @return Number of I/O operations per second (IOPS).
     * 
     */
    private @Nullable Integer iops;
    /**
     * @return Amazon Resource Name (ARN) identifier of the Amazon Web Services Key Management Service key to use for Amazon EBS encryption.
     * 
     */
    private @Nullable String kmsKeyId;
    /**
     * @return Amazon ECS infrastructure IAM role that is used to manage your Amazon Web Services infrastructure. Recommended using the Amazon ECS-managed `AmazonECSInfrastructureRolePolicyForVolumes` IAM policy with this role.
     * 
     */
    private String roleArn;
    /**
     * @return Size of the volume in GiB. You must specify either a `size_in_gb` or a `snapshot_id`. You can optionally specify a volume size greater than or equal to the snapshot size.
     * 
     */
    private @Nullable Integer sizeInGb;
    /**
     * @return Snapshot that Amazon ECS uses to create the volume. You must specify either a `size_in_gb` or a `snapshot_id`.
     * 
     */
    private @Nullable String snapshotId;
    /**
     * @return The tags to apply to the volume. See below.
     * 
     */
    private @Nullable List<ServiceVolumeConfigurationManagedEbsVolumeTagSpecification> tagSpecifications;
    /**
     * @return Throughput to provision for a volume, in MiB/s, with a maximum of 1,000 MiB/s.
     * 
     */
    private @Nullable Integer throughput;
    /**
     * @return Volume Initialization Rate in MiB/s. You must also specify a `snapshot_id`.
     * 
     */
    private @Nullable Integer volumeInitializationRate;
    /**
     * @return Volume type.
     * 
     */
    private @Nullable String volumeType;

    private ServiceVolumeConfigurationManagedEbsVolume() {}
    /**
     * @return Whether the volume should be encrypted. Default value is `true`.
     * 
     */
    public Optional<Boolean> encrypted() {
        return Optional.ofNullable(this.encrypted);
    }
    /**
     * @return Linux filesystem type for the volume. For volumes created from a snapshot, same filesystem type must be specified that the volume was using when the snapshot was created. Valid values are `ext3`, `ext4`, `xfs`. Default value is `xfs`.
     * 
     */
    public Optional<String> fileSystemType() {
        return Optional.ofNullable(this.fileSystemType);
    }
    /**
     * @return Number of I/O operations per second (IOPS).
     * 
     */
    public Optional<Integer> iops() {
        return Optional.ofNullable(this.iops);
    }
    /**
     * @return Amazon Resource Name (ARN) identifier of the Amazon Web Services Key Management Service key to use for Amazon EBS encryption.
     * 
     */
    public Optional<String> kmsKeyId() {
        return Optional.ofNullable(this.kmsKeyId);
    }
    /**
     * @return Amazon ECS infrastructure IAM role that is used to manage your Amazon Web Services infrastructure. Recommended using the Amazon ECS-managed `AmazonECSInfrastructureRolePolicyForVolumes` IAM policy with this role.
     * 
     */
    public String roleArn() {
        return this.roleArn;
    }
    /**
     * @return Size of the volume in GiB. You must specify either a `size_in_gb` or a `snapshot_id`. You can optionally specify a volume size greater than or equal to the snapshot size.
     * 
     */
    public Optional<Integer> sizeInGb() {
        return Optional.ofNullable(this.sizeInGb);
    }
    /**
     * @return Snapshot that Amazon ECS uses to create the volume. You must specify either a `size_in_gb` or a `snapshot_id`.
     * 
     */
    public Optional<String> snapshotId() {
        return Optional.ofNullable(this.snapshotId);
    }
    /**
     * @return The tags to apply to the volume. See below.
     * 
     */
    public List<ServiceVolumeConfigurationManagedEbsVolumeTagSpecification> tagSpecifications() {
        return this.tagSpecifications == null ? List.of() : this.tagSpecifications;
    }
    /**
     * @return Throughput to provision for a volume, in MiB/s, with a maximum of 1,000 MiB/s.
     * 
     */
    public Optional<Integer> throughput() {
        return Optional.ofNullable(this.throughput);
    }
    /**
     * @return Volume Initialization Rate in MiB/s. You must also specify a `snapshot_id`.
     * 
     */
    public Optional<Integer> volumeInitializationRate() {
        return Optional.ofNullable(this.volumeInitializationRate);
    }
    /**
     * @return Volume type.
     * 
     */
    public Optional<String> volumeType() {
        return Optional.ofNullable(this.volumeType);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ServiceVolumeConfigurationManagedEbsVolume defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean encrypted;
        private @Nullable String fileSystemType;
        private @Nullable Integer iops;
        private @Nullable String kmsKeyId;
        private String roleArn;
        private @Nullable Integer sizeInGb;
        private @Nullable String snapshotId;
        private @Nullable List<ServiceVolumeConfigurationManagedEbsVolumeTagSpecification> tagSpecifications;
        private @Nullable Integer throughput;
        private @Nullable Integer volumeInitializationRate;
        private @Nullable String volumeType;
        public Builder() {}
        public Builder(ServiceVolumeConfigurationManagedEbsVolume defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.encrypted = defaults.encrypted;
    	      this.fileSystemType = defaults.fileSystemType;
    	      this.iops = defaults.iops;
    	      this.kmsKeyId = defaults.kmsKeyId;
    	      this.roleArn = defaults.roleArn;
    	      this.sizeInGb = defaults.sizeInGb;
    	      this.snapshotId = defaults.snapshotId;
    	      this.tagSpecifications = defaults.tagSpecifications;
    	      this.throughput = defaults.throughput;
    	      this.volumeInitializationRate = defaults.volumeInitializationRate;
    	      this.volumeType = defaults.volumeType;
        }

        @CustomType.Setter
        public Builder encrypted(@Nullable Boolean encrypted) {

            this.encrypted = encrypted;
            return this;
        }
        @CustomType.Setter
        public Builder fileSystemType(@Nullable String fileSystemType) {

            this.fileSystemType = fileSystemType;
            return this;
        }
        @CustomType.Setter
        public Builder iops(@Nullable Integer iops) {

            this.iops = iops;
            return this;
        }
        @CustomType.Setter
        public Builder kmsKeyId(@Nullable String kmsKeyId) {

            this.kmsKeyId = kmsKeyId;
            return this;
        }
        @CustomType.Setter
        public Builder roleArn(String roleArn) {
            if (roleArn == null) {
              throw new MissingRequiredPropertyException("ServiceVolumeConfigurationManagedEbsVolume", "roleArn");
            }
            this.roleArn = roleArn;
            return this;
        }
        @CustomType.Setter
        public Builder sizeInGb(@Nullable Integer sizeInGb) {

            this.sizeInGb = sizeInGb;
            return this;
        }
        @CustomType.Setter
        public Builder snapshotId(@Nullable String snapshotId) {

            this.snapshotId = snapshotId;
            return this;
        }
        @CustomType.Setter
        public Builder tagSpecifications(@Nullable List<ServiceVolumeConfigurationManagedEbsVolumeTagSpecification> tagSpecifications) {

            this.tagSpecifications = tagSpecifications;
            return this;
        }
        public Builder tagSpecifications(ServiceVolumeConfigurationManagedEbsVolumeTagSpecification... tagSpecifications) {
            return tagSpecifications(List.of(tagSpecifications));
        }
        @CustomType.Setter
        public Builder throughput(@Nullable Integer throughput) {

            this.throughput = throughput;
            return this;
        }
        @CustomType.Setter
        public Builder volumeInitializationRate(@Nullable Integer volumeInitializationRate) {

            this.volumeInitializationRate = volumeInitializationRate;
            return this;
        }
        @CustomType.Setter
        public Builder volumeType(@Nullable String volumeType) {

            this.volumeType = volumeType;
            return this;
        }
        public ServiceVolumeConfigurationManagedEbsVolume build() {
            final var _resultValue = new ServiceVolumeConfigurationManagedEbsVolume();
            _resultValue.encrypted = encrypted;
            _resultValue.fileSystemType = fileSystemType;
            _resultValue.iops = iops;
            _resultValue.kmsKeyId = kmsKeyId;
            _resultValue.roleArn = roleArn;
            _resultValue.sizeInGb = sizeInGb;
            _resultValue.snapshotId = snapshotId;
            _resultValue.tagSpecifications = tagSpecifications;
            _resultValue.throughput = throughput;
            _resultValue.volumeInitializationRate = volumeInitializationRate;
            _resultValue.volumeType = volumeType;
            return _resultValue;
        }
    }
}
