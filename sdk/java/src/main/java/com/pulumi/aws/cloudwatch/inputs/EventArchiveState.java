// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EventArchiveState extends com.pulumi.resources.ResourceArgs {

    public static final EventArchiveState Empty = new EventArchiveState();

    /**
     * The Amazon Resource Name (ARN) of the event archive.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the event archive.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The description of the new event archive.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return The description of the new event archive.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Instructs the new event archive to only capture events matched by this pattern. By default, it attempts to archive every event received in the `event_source_arn`.
     * 
     */
    @Import(name="eventPattern")
    private @Nullable Output<String> eventPattern;

    /**
     * @return Instructs the new event archive to only capture events matched by this pattern. By default, it attempts to archive every event received in the `event_source_arn`.
     * 
     */
    public Optional<Output<String>> eventPattern() {
        return Optional.ofNullable(this.eventPattern);
    }

    /**
     * Event bus source ARN from where these events should be archived.
     * 
     */
    @Import(name="eventSourceArn")
    private @Nullable Output<String> eventSourceArn;

    /**
     * @return Event bus source ARN from where these events should be archived.
     * 
     */
    public Optional<Output<String>> eventSourceArn() {
        return Optional.ofNullable(this.eventSourceArn);
    }

    /**
     * The name of the new event archive. The archive name cannot exceed 48 characters.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the new event archive. The archive name cannot exceed 48 characters.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * The maximum number of days to retain events in the new event archive. By default, it archives indefinitely.
     * 
     */
    @Import(name="retentionDays")
    private @Nullable Output<Integer> retentionDays;

    /**
     * @return The maximum number of days to retain events in the new event archive. By default, it archives indefinitely.
     * 
     */
    public Optional<Output<Integer>> retentionDays() {
        return Optional.ofNullable(this.retentionDays);
    }

    private EventArchiveState() {}

    private EventArchiveState(EventArchiveState $) {
        this.arn = $.arn;
        this.description = $.description;
        this.eventPattern = $.eventPattern;
        this.eventSourceArn = $.eventSourceArn;
        this.name = $.name;
        this.retentionDays = $.retentionDays;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EventArchiveState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EventArchiveState $;

        public Builder() {
            $ = new EventArchiveState();
        }

        public Builder(EventArchiveState defaults) {
            $ = new EventArchiveState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The Amazon Resource Name (ARN) of the event archive.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The Amazon Resource Name (ARN) of the event archive.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param description The description of the new event archive.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description The description of the new event archive.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param eventPattern Instructs the new event archive to only capture events matched by this pattern. By default, it attempts to archive every event received in the `event_source_arn`.
         * 
         * @return builder
         * 
         */
        public Builder eventPattern(@Nullable Output<String> eventPattern) {
            $.eventPattern = eventPattern;
            return this;
        }

        /**
         * @param eventPattern Instructs the new event archive to only capture events matched by this pattern. By default, it attempts to archive every event received in the `event_source_arn`.
         * 
         * @return builder
         * 
         */
        public Builder eventPattern(String eventPattern) {
            return eventPattern(Output.of(eventPattern));
        }

        /**
         * @param eventSourceArn Event bus source ARN from where these events should be archived.
         * 
         * @return builder
         * 
         */
        public Builder eventSourceArn(@Nullable Output<String> eventSourceArn) {
            $.eventSourceArn = eventSourceArn;
            return this;
        }

        /**
         * @param eventSourceArn Event bus source ARN from where these events should be archived.
         * 
         * @return builder
         * 
         */
        public Builder eventSourceArn(String eventSourceArn) {
            return eventSourceArn(Output.of(eventSourceArn));
        }

        /**
         * @param name The name of the new event archive. The archive name cannot exceed 48 characters.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the new event archive. The archive name cannot exceed 48 characters.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param retentionDays The maximum number of days to retain events in the new event archive. By default, it archives indefinitely.
         * 
         * @return builder
         * 
         */
        public Builder retentionDays(@Nullable Output<Integer> retentionDays) {
            $.retentionDays = retentionDays;
            return this;
        }

        /**
         * @param retentionDays The maximum number of days to retain events in the new event archive. By default, it archives indefinitely.
         * 
         * @return builder
         * 
         */
        public Builder retentionDays(Integer retentionDays) {
            return retentionDays(Output.of(retentionDays));
        }

        public EventArchiveState build() {
            return $;
        }
    }

}
