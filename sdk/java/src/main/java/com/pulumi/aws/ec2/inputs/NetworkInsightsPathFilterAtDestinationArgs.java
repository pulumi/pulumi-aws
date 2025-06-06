// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.NetworkInsightsPathFilterAtDestinationDestinationPortRangeArgs;
import com.pulumi.aws.ec2.inputs.NetworkInsightsPathFilterAtDestinationSourcePortRangeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class NetworkInsightsPathFilterAtDestinationArgs extends com.pulumi.resources.ResourceArgs {

    public static final NetworkInsightsPathFilterAtDestinationArgs Empty = new NetworkInsightsPathFilterAtDestinationArgs();

    /**
     * The destination IPv4 address.
     * 
     */
    @Import(name="destinationAddress")
    private @Nullable Output<String> destinationAddress;

    /**
     * @return The destination IPv4 address.
     * 
     */
    public Optional<Output<String>> destinationAddress() {
        return Optional.ofNullable(this.destinationAddress);
    }

    /**
     * The destination port range. See below for details.
     * 
     */
    @Import(name="destinationPortRange")
    private @Nullable Output<NetworkInsightsPathFilterAtDestinationDestinationPortRangeArgs> destinationPortRange;

    /**
     * @return The destination port range. See below for details.
     * 
     */
    public Optional<Output<NetworkInsightsPathFilterAtDestinationDestinationPortRangeArgs>> destinationPortRange() {
        return Optional.ofNullable(this.destinationPortRange);
    }

    /**
     * IP address of the source resource.
     * 
     */
    @Import(name="sourceAddress")
    private @Nullable Output<String> sourceAddress;

    /**
     * @return IP address of the source resource.
     * 
     */
    public Optional<Output<String>> sourceAddress() {
        return Optional.ofNullable(this.sourceAddress);
    }

    /**
     * The source port range. See below for details.
     * 
     */
    @Import(name="sourcePortRange")
    private @Nullable Output<NetworkInsightsPathFilterAtDestinationSourcePortRangeArgs> sourcePortRange;

    /**
     * @return The source port range. See below for details.
     * 
     */
    public Optional<Output<NetworkInsightsPathFilterAtDestinationSourcePortRangeArgs>> sourcePortRange() {
        return Optional.ofNullable(this.sourcePortRange);
    }

    private NetworkInsightsPathFilterAtDestinationArgs() {}

    private NetworkInsightsPathFilterAtDestinationArgs(NetworkInsightsPathFilterAtDestinationArgs $) {
        this.destinationAddress = $.destinationAddress;
        this.destinationPortRange = $.destinationPortRange;
        this.sourceAddress = $.sourceAddress;
        this.sourcePortRange = $.sourcePortRange;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NetworkInsightsPathFilterAtDestinationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NetworkInsightsPathFilterAtDestinationArgs $;

        public Builder() {
            $ = new NetworkInsightsPathFilterAtDestinationArgs();
        }

        public Builder(NetworkInsightsPathFilterAtDestinationArgs defaults) {
            $ = new NetworkInsightsPathFilterAtDestinationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param destinationAddress The destination IPv4 address.
         * 
         * @return builder
         * 
         */
        public Builder destinationAddress(@Nullable Output<String> destinationAddress) {
            $.destinationAddress = destinationAddress;
            return this;
        }

        /**
         * @param destinationAddress The destination IPv4 address.
         * 
         * @return builder
         * 
         */
        public Builder destinationAddress(String destinationAddress) {
            return destinationAddress(Output.of(destinationAddress));
        }

        /**
         * @param destinationPortRange The destination port range. See below for details.
         * 
         * @return builder
         * 
         */
        public Builder destinationPortRange(@Nullable Output<NetworkInsightsPathFilterAtDestinationDestinationPortRangeArgs> destinationPortRange) {
            $.destinationPortRange = destinationPortRange;
            return this;
        }

        /**
         * @param destinationPortRange The destination port range. See below for details.
         * 
         * @return builder
         * 
         */
        public Builder destinationPortRange(NetworkInsightsPathFilterAtDestinationDestinationPortRangeArgs destinationPortRange) {
            return destinationPortRange(Output.of(destinationPortRange));
        }

        /**
         * @param sourceAddress IP address of the source resource.
         * 
         * @return builder
         * 
         */
        public Builder sourceAddress(@Nullable Output<String> sourceAddress) {
            $.sourceAddress = sourceAddress;
            return this;
        }

        /**
         * @param sourceAddress IP address of the source resource.
         * 
         * @return builder
         * 
         */
        public Builder sourceAddress(String sourceAddress) {
            return sourceAddress(Output.of(sourceAddress));
        }

        /**
         * @param sourcePortRange The source port range. See below for details.
         * 
         * @return builder
         * 
         */
        public Builder sourcePortRange(@Nullable Output<NetworkInsightsPathFilterAtDestinationSourcePortRangeArgs> sourcePortRange) {
            $.sourcePortRange = sourcePortRange;
            return this;
        }

        /**
         * @param sourcePortRange The source port range. See below for details.
         * 
         * @return builder
         * 
         */
        public Builder sourcePortRange(NetworkInsightsPathFilterAtDestinationSourcePortRangeArgs sourcePortRange) {
            return sourcePortRange(Output.of(sourcePortRange));
        }

        public NetworkInsightsPathFilterAtDestinationArgs build() {
            return $;
        }
    }

}
