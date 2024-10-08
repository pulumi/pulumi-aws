// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opensearch.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class InboundConnectionAccepterState extends com.pulumi.resources.ResourceArgs {

    public static final InboundConnectionAccepterState Empty = new InboundConnectionAccepterState();

    /**
     * Specifies the ID of the connection to accept.
     * 
     */
    @Import(name="connectionId")
    private @Nullable Output<String> connectionId;

    /**
     * @return Specifies the ID of the connection to accept.
     * 
     */
    public Optional<Output<String>> connectionId() {
        return Optional.ofNullable(this.connectionId);
    }

    /**
     * Status of the connection request.
     * 
     */
    @Import(name="connectionStatus")
    private @Nullable Output<String> connectionStatus;

    /**
     * @return Status of the connection request.
     * 
     */
    public Optional<Output<String>> connectionStatus() {
        return Optional.ofNullable(this.connectionStatus);
    }

    private InboundConnectionAccepterState() {}

    private InboundConnectionAccepterState(InboundConnectionAccepterState $) {
        this.connectionId = $.connectionId;
        this.connectionStatus = $.connectionStatus;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(InboundConnectionAccepterState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private InboundConnectionAccepterState $;

        public Builder() {
            $ = new InboundConnectionAccepterState();
        }

        public Builder(InboundConnectionAccepterState defaults) {
            $ = new InboundConnectionAccepterState(Objects.requireNonNull(defaults));
        }

        /**
         * @param connectionId Specifies the ID of the connection to accept.
         * 
         * @return builder
         * 
         */
        public Builder connectionId(@Nullable Output<String> connectionId) {
            $.connectionId = connectionId;
            return this;
        }

        /**
         * @param connectionId Specifies the ID of the connection to accept.
         * 
         * @return builder
         * 
         */
        public Builder connectionId(String connectionId) {
            return connectionId(Output.of(connectionId));
        }

        /**
         * @param connectionStatus Status of the connection request.
         * 
         * @return builder
         * 
         */
        public Builder connectionStatus(@Nullable Output<String> connectionStatus) {
            $.connectionStatus = connectionStatus;
            return this;
        }

        /**
         * @param connectionStatus Status of the connection request.
         * 
         * @return builder
         * 
         */
        public Builder connectionStatus(String connectionStatus) {
            return connectionStatus(Output.of(connectionStatus));
        }

        public InboundConnectionAccepterState build() {
            return $;
        }
    }

}
