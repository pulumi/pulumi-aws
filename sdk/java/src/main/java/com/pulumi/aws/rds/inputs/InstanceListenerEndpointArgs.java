// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class InstanceListenerEndpointArgs extends com.pulumi.resources.ResourceArgs {

    public static final InstanceListenerEndpointArgs Empty = new InstanceListenerEndpointArgs();

    /**
     * Specifies the DNS address of the DB instance.
     * 
     */
    @Import(name="address")
    private @Nullable Output<String> address;

    /**
     * @return Specifies the DNS address of the DB instance.
     * 
     */
    public Optional<Output<String>> address() {
        return Optional.ofNullable(this.address);
    }

    /**
     * Specifies the ID that Amazon Route 53 assigns when you create a hosted zone.
     * 
     */
    @Import(name="hostedZoneId")
    private @Nullable Output<String> hostedZoneId;

    /**
     * @return Specifies the ID that Amazon Route 53 assigns when you create a hosted zone.
     * 
     */
    public Optional<Output<String>> hostedZoneId() {
        return Optional.ofNullable(this.hostedZoneId);
    }

    /**
     * The port on which the DB accepts connections.
     * 
     */
    @Import(name="port")
    private @Nullable Output<Integer> port;

    /**
     * @return The port on which the DB accepts connections.
     * 
     */
    public Optional<Output<Integer>> port() {
        return Optional.ofNullable(this.port);
    }

    private InstanceListenerEndpointArgs() {}

    private InstanceListenerEndpointArgs(InstanceListenerEndpointArgs $) {
        this.address = $.address;
        this.hostedZoneId = $.hostedZoneId;
        this.port = $.port;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(InstanceListenerEndpointArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private InstanceListenerEndpointArgs $;

        public Builder() {
            $ = new InstanceListenerEndpointArgs();
        }

        public Builder(InstanceListenerEndpointArgs defaults) {
            $ = new InstanceListenerEndpointArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param address Specifies the DNS address of the DB instance.
         * 
         * @return builder
         * 
         */
        public Builder address(@Nullable Output<String> address) {
            $.address = address;
            return this;
        }

        /**
         * @param address Specifies the DNS address of the DB instance.
         * 
         * @return builder
         * 
         */
        public Builder address(String address) {
            return address(Output.of(address));
        }

        /**
         * @param hostedZoneId Specifies the ID that Amazon Route 53 assigns when you create a hosted zone.
         * 
         * @return builder
         * 
         */
        public Builder hostedZoneId(@Nullable Output<String> hostedZoneId) {
            $.hostedZoneId = hostedZoneId;
            return this;
        }

        /**
         * @param hostedZoneId Specifies the ID that Amazon Route 53 assigns when you create a hosted zone.
         * 
         * @return builder
         * 
         */
        public Builder hostedZoneId(String hostedZoneId) {
            return hostedZoneId(Output.of(hostedZoneId));
        }

        /**
         * @param port The port on which the DB accepts connections.
         * 
         * @return builder
         * 
         */
        public Builder port(@Nullable Output<Integer> port) {
            $.port = port;
            return this;
        }

        /**
         * @param port The port on which the DB accepts connections.
         * 
         * @return builder
         * 
         */
        public Builder port(Integer port) {
            return port(Output.of(port));
        }

        public InstanceListenerEndpointArgs build() {
            return $;
        }
    }

}
