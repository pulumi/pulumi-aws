// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkmanager.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DeviceAwsLocationArgs extends com.pulumi.resources.ResourceArgs {

    public static final DeviceAwsLocationArgs Empty = new DeviceAwsLocationArgs();

    /**
     * The Amazon Resource Name (ARN) of the subnet that the device is located in.
     * 
     */
    @Import(name="subnetArn")
    private @Nullable Output<String> subnetArn;

    /**
     * @return The Amazon Resource Name (ARN) of the subnet that the device is located in.
     * 
     */
    public Optional<Output<String>> subnetArn() {
        return Optional.ofNullable(this.subnetArn);
    }

    /**
     * The Zone that the device is located in. Specify the ID of an Availability Zone, Local Zone, Wavelength Zone, or an Outpost.
     * 
     */
    @Import(name="zone")
    private @Nullable Output<String> zone;

    /**
     * @return The Zone that the device is located in. Specify the ID of an Availability Zone, Local Zone, Wavelength Zone, or an Outpost.
     * 
     */
    public Optional<Output<String>> zone() {
        return Optional.ofNullable(this.zone);
    }

    private DeviceAwsLocationArgs() {}

    private DeviceAwsLocationArgs(DeviceAwsLocationArgs $) {
        this.subnetArn = $.subnetArn;
        this.zone = $.zone;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DeviceAwsLocationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DeviceAwsLocationArgs $;

        public Builder() {
            $ = new DeviceAwsLocationArgs();
        }

        public Builder(DeviceAwsLocationArgs defaults) {
            $ = new DeviceAwsLocationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param subnetArn The Amazon Resource Name (ARN) of the subnet that the device is located in.
         * 
         * @return builder
         * 
         */
        public Builder subnetArn(@Nullable Output<String> subnetArn) {
            $.subnetArn = subnetArn;
            return this;
        }

        /**
         * @param subnetArn The Amazon Resource Name (ARN) of the subnet that the device is located in.
         * 
         * @return builder
         * 
         */
        public Builder subnetArn(String subnetArn) {
            return subnetArn(Output.of(subnetArn));
        }

        /**
         * @param zone The Zone that the device is located in. Specify the ID of an Availability Zone, Local Zone, Wavelength Zone, or an Outpost.
         * 
         * @return builder
         * 
         */
        public Builder zone(@Nullable Output<String> zone) {
            $.zone = zone;
            return this;
        }

        /**
         * @param zone The Zone that the device is located in. Specify the ID of an Availability Zone, Local Zone, Wavelength Zone, or an Outpost.
         * 
         * @return builder
         * 
         */
        public Builder zone(String zone) {
            return zone(Output.of(zone));
        }

        public DeviceAwsLocationArgs build() {
            return $;
        }
    }

}
