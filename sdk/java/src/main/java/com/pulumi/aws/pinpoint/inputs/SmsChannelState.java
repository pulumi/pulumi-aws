// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pinpoint.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SmsChannelState extends com.pulumi.resources.ResourceArgs {

    public static final SmsChannelState Empty = new SmsChannelState();

    /**
     * ID of the application.
     * 
     */
    @Import(name="applicationId")
    private @Nullable Output<String> applicationId;

    /**
     * @return ID of the application.
     * 
     */
    public Optional<Output<String>> applicationId() {
        return Optional.ofNullable(this.applicationId);
    }

    /**
     * Whether the channel is enabled or disabled. By default, it is set to `true`.
     * 
     */
    @Import(name="enabled")
    private @Nullable Output<Boolean> enabled;

    /**
     * @return Whether the channel is enabled or disabled. By default, it is set to `true`.
     * 
     */
    public Optional<Output<Boolean>> enabled() {
        return Optional.ofNullable(this.enabled);
    }

    /**
     * Maximum number of promotional messages that can be sent per second.
     * 
     */
    @Import(name="promotionalMessagesPerSecond")
    private @Nullable Output<Integer> promotionalMessagesPerSecond;

    /**
     * @return Maximum number of promotional messages that can be sent per second.
     * 
     */
    public Optional<Output<Integer>> promotionalMessagesPerSecond() {
        return Optional.ofNullable(this.promotionalMessagesPerSecond);
    }

    /**
     * Identifier of the sender for your messages.
     * 
     */
    @Import(name="senderId")
    private @Nullable Output<String> senderId;

    /**
     * @return Identifier of the sender for your messages.
     * 
     */
    public Optional<Output<String>> senderId() {
        return Optional.ofNullable(this.senderId);
    }

    /**
     * Short Code registered with the phone provider.
     * 
     */
    @Import(name="shortCode")
    private @Nullable Output<String> shortCode;

    /**
     * @return Short Code registered with the phone provider.
     * 
     */
    public Optional<Output<String>> shortCode() {
        return Optional.ofNullable(this.shortCode);
    }

    /**
     * Maximum number of transactional messages per second that can be sent.
     * 
     */
    @Import(name="transactionalMessagesPerSecond")
    private @Nullable Output<Integer> transactionalMessagesPerSecond;

    /**
     * @return Maximum number of transactional messages per second that can be sent.
     * 
     */
    public Optional<Output<Integer>> transactionalMessagesPerSecond() {
        return Optional.ofNullable(this.transactionalMessagesPerSecond);
    }

    private SmsChannelState() {}

    private SmsChannelState(SmsChannelState $) {
        this.applicationId = $.applicationId;
        this.enabled = $.enabled;
        this.promotionalMessagesPerSecond = $.promotionalMessagesPerSecond;
        this.senderId = $.senderId;
        this.shortCode = $.shortCode;
        this.transactionalMessagesPerSecond = $.transactionalMessagesPerSecond;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SmsChannelState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SmsChannelState $;

        public Builder() {
            $ = new SmsChannelState();
        }

        public Builder(SmsChannelState defaults) {
            $ = new SmsChannelState(Objects.requireNonNull(defaults));
        }

        /**
         * @param applicationId ID of the application.
         * 
         * @return builder
         * 
         */
        public Builder applicationId(@Nullable Output<String> applicationId) {
            $.applicationId = applicationId;
            return this;
        }

        /**
         * @param applicationId ID of the application.
         * 
         * @return builder
         * 
         */
        public Builder applicationId(String applicationId) {
            return applicationId(Output.of(applicationId));
        }

        /**
         * @param enabled Whether the channel is enabled or disabled. By default, it is set to `true`.
         * 
         * @return builder
         * 
         */
        public Builder enabled(@Nullable Output<Boolean> enabled) {
            $.enabled = enabled;
            return this;
        }

        /**
         * @param enabled Whether the channel is enabled or disabled. By default, it is set to `true`.
         * 
         * @return builder
         * 
         */
        public Builder enabled(Boolean enabled) {
            return enabled(Output.of(enabled));
        }

        /**
         * @param promotionalMessagesPerSecond Maximum number of promotional messages that can be sent per second.
         * 
         * @return builder
         * 
         */
        public Builder promotionalMessagesPerSecond(@Nullable Output<Integer> promotionalMessagesPerSecond) {
            $.promotionalMessagesPerSecond = promotionalMessagesPerSecond;
            return this;
        }

        /**
         * @param promotionalMessagesPerSecond Maximum number of promotional messages that can be sent per second.
         * 
         * @return builder
         * 
         */
        public Builder promotionalMessagesPerSecond(Integer promotionalMessagesPerSecond) {
            return promotionalMessagesPerSecond(Output.of(promotionalMessagesPerSecond));
        }

        /**
         * @param senderId Identifier of the sender for your messages.
         * 
         * @return builder
         * 
         */
        public Builder senderId(@Nullable Output<String> senderId) {
            $.senderId = senderId;
            return this;
        }

        /**
         * @param senderId Identifier of the sender for your messages.
         * 
         * @return builder
         * 
         */
        public Builder senderId(String senderId) {
            return senderId(Output.of(senderId));
        }

        /**
         * @param shortCode Short Code registered with the phone provider.
         * 
         * @return builder
         * 
         */
        public Builder shortCode(@Nullable Output<String> shortCode) {
            $.shortCode = shortCode;
            return this;
        }

        /**
         * @param shortCode Short Code registered with the phone provider.
         * 
         * @return builder
         * 
         */
        public Builder shortCode(String shortCode) {
            return shortCode(Output.of(shortCode));
        }

        /**
         * @param transactionalMessagesPerSecond Maximum number of transactional messages per second that can be sent.
         * 
         * @return builder
         * 
         */
        public Builder transactionalMessagesPerSecond(@Nullable Output<Integer> transactionalMessagesPerSecond) {
            $.transactionalMessagesPerSecond = transactionalMessagesPerSecond;
            return this;
        }

        /**
         * @param transactionalMessagesPerSecond Maximum number of transactional messages per second that can be sent.
         * 
         * @return builder
         * 
         */
        public Builder transactionalMessagesPerSecond(Integer transactionalMessagesPerSecond) {
            return transactionalMessagesPerSecond(Output.of(transactionalMessagesPerSecond));
        }

        public SmsChannelState build() {
            return $;
        }
    }

}
