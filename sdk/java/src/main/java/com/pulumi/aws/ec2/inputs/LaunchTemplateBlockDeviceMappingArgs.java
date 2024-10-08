// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.LaunchTemplateBlockDeviceMappingEbsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class LaunchTemplateBlockDeviceMappingArgs extends com.pulumi.resources.ResourceArgs {

    public static final LaunchTemplateBlockDeviceMappingArgs Empty = new LaunchTemplateBlockDeviceMappingArgs();

    /**
     * The name of the device to mount.
     * 
     */
    @Import(name="deviceName")
    private @Nullable Output<String> deviceName;

    /**
     * @return The name of the device to mount.
     * 
     */
    public Optional<Output<String>> deviceName() {
        return Optional.ofNullable(this.deviceName);
    }

    /**
     * Configure EBS volume properties.
     * 
     */
    @Import(name="ebs")
    private @Nullable Output<LaunchTemplateBlockDeviceMappingEbsArgs> ebs;

    /**
     * @return Configure EBS volume properties.
     * 
     */
    public Optional<Output<LaunchTemplateBlockDeviceMappingEbsArgs>> ebs() {
        return Optional.ofNullable(this.ebs);
    }

    /**
     * Suppresses the specified device included in the AMI&#39;s block device mapping.
     * 
     */
    @Import(name="noDevice")
    private @Nullable Output<String> noDevice;

    /**
     * @return Suppresses the specified device included in the AMI&#39;s block device mapping.
     * 
     */
    public Optional<Output<String>> noDevice() {
        return Optional.ofNullable(this.noDevice);
    }

    /**
     * The [Instance Store Device
     * Name](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/InstanceStorage.html#InstanceStoreDeviceNames)
     * (e.g., `&#34;ephemeral0&#34;`).
     * 
     */
    @Import(name="virtualName")
    private @Nullable Output<String> virtualName;

    /**
     * @return The [Instance Store Device
     * Name](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/InstanceStorage.html#InstanceStoreDeviceNames)
     * (e.g., `&#34;ephemeral0&#34;`).
     * 
     */
    public Optional<Output<String>> virtualName() {
        return Optional.ofNullable(this.virtualName);
    }

    private LaunchTemplateBlockDeviceMappingArgs() {}

    private LaunchTemplateBlockDeviceMappingArgs(LaunchTemplateBlockDeviceMappingArgs $) {
        this.deviceName = $.deviceName;
        this.ebs = $.ebs;
        this.noDevice = $.noDevice;
        this.virtualName = $.virtualName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(LaunchTemplateBlockDeviceMappingArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private LaunchTemplateBlockDeviceMappingArgs $;

        public Builder() {
            $ = new LaunchTemplateBlockDeviceMappingArgs();
        }

        public Builder(LaunchTemplateBlockDeviceMappingArgs defaults) {
            $ = new LaunchTemplateBlockDeviceMappingArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param deviceName The name of the device to mount.
         * 
         * @return builder
         * 
         */
        public Builder deviceName(@Nullable Output<String> deviceName) {
            $.deviceName = deviceName;
            return this;
        }

        /**
         * @param deviceName The name of the device to mount.
         * 
         * @return builder
         * 
         */
        public Builder deviceName(String deviceName) {
            return deviceName(Output.of(deviceName));
        }

        /**
         * @param ebs Configure EBS volume properties.
         * 
         * @return builder
         * 
         */
        public Builder ebs(@Nullable Output<LaunchTemplateBlockDeviceMappingEbsArgs> ebs) {
            $.ebs = ebs;
            return this;
        }

        /**
         * @param ebs Configure EBS volume properties.
         * 
         * @return builder
         * 
         */
        public Builder ebs(LaunchTemplateBlockDeviceMappingEbsArgs ebs) {
            return ebs(Output.of(ebs));
        }

        /**
         * @param noDevice Suppresses the specified device included in the AMI&#39;s block device mapping.
         * 
         * @return builder
         * 
         */
        public Builder noDevice(@Nullable Output<String> noDevice) {
            $.noDevice = noDevice;
            return this;
        }

        /**
         * @param noDevice Suppresses the specified device included in the AMI&#39;s block device mapping.
         * 
         * @return builder
         * 
         */
        public Builder noDevice(String noDevice) {
            return noDevice(Output.of(noDevice));
        }

        /**
         * @param virtualName The [Instance Store Device
         * Name](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/InstanceStorage.html#InstanceStoreDeviceNames)
         * (e.g., `&#34;ephemeral0&#34;`).
         * 
         * @return builder
         * 
         */
        public Builder virtualName(@Nullable Output<String> virtualName) {
            $.virtualName = virtualName;
            return this;
        }

        /**
         * @param virtualName The [Instance Store Device
         * Name](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/InstanceStorage.html#InstanceStoreDeviceNames)
         * (e.g., `&#34;ephemeral0&#34;`).
         * 
         * @return builder
         * 
         */
        public Builder virtualName(String virtualName) {
            return virtualName(Output.of(virtualName));
        }

        public LaunchTemplateBlockDeviceMappingArgs build() {
            return $;
        }
    }

}
