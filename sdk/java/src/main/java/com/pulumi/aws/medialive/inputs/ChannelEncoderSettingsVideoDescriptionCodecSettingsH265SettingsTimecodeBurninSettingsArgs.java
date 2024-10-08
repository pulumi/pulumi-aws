// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.medialive.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs extends com.pulumi.resources.ResourceArgs {

    public static final ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs Empty = new ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs();

    /**
     * Set a prefix on the burned in timecode.
     * 
     */
    @Import(name="prefix")
    private @Nullable Output<String> prefix;

    /**
     * @return Set a prefix on the burned in timecode.
     * 
     */
    public Optional<Output<String>> prefix() {
        return Optional.ofNullable(this.prefix);
    }

    /**
     * Sets the size of the burned in timecode.
     * 
     */
    @Import(name="timecodeBurninFontSize")
    private @Nullable Output<String> timecodeBurninFontSize;

    /**
     * @return Sets the size of the burned in timecode.
     * 
     */
    public Optional<Output<String>> timecodeBurninFontSize() {
        return Optional.ofNullable(this.timecodeBurninFontSize);
    }

    /**
     * Sets the position of the burned in timecode.
     * 
     */
    @Import(name="timecodeBurninPosition")
    private @Nullable Output<String> timecodeBurninPosition;

    /**
     * @return Sets the position of the burned in timecode.
     * 
     */
    public Optional<Output<String>> timecodeBurninPosition() {
        return Optional.ofNullable(this.timecodeBurninPosition);
    }

    private ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs() {}

    private ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs(ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs $) {
        this.prefix = $.prefix;
        this.timecodeBurninFontSize = $.timecodeBurninFontSize;
        this.timecodeBurninPosition = $.timecodeBurninPosition;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs $;

        public Builder() {
            $ = new ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs();
        }

        public Builder(ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs defaults) {
            $ = new ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param prefix Set a prefix on the burned in timecode.
         * 
         * @return builder
         * 
         */
        public Builder prefix(@Nullable Output<String> prefix) {
            $.prefix = prefix;
            return this;
        }

        /**
         * @param prefix Set a prefix on the burned in timecode.
         * 
         * @return builder
         * 
         */
        public Builder prefix(String prefix) {
            return prefix(Output.of(prefix));
        }

        /**
         * @param timecodeBurninFontSize Sets the size of the burned in timecode.
         * 
         * @return builder
         * 
         */
        public Builder timecodeBurninFontSize(@Nullable Output<String> timecodeBurninFontSize) {
            $.timecodeBurninFontSize = timecodeBurninFontSize;
            return this;
        }

        /**
         * @param timecodeBurninFontSize Sets the size of the burned in timecode.
         * 
         * @return builder
         * 
         */
        public Builder timecodeBurninFontSize(String timecodeBurninFontSize) {
            return timecodeBurninFontSize(Output.of(timecodeBurninFontSize));
        }

        /**
         * @param timecodeBurninPosition Sets the position of the burned in timecode.
         * 
         * @return builder
         * 
         */
        public Builder timecodeBurninPosition(@Nullable Output<String> timecodeBurninPosition) {
            $.timecodeBurninPosition = timecodeBurninPosition;
            return this;
        }

        /**
         * @param timecodeBurninPosition Sets the position of the burned in timecode.
         * 
         * @return builder
         * 
         */
        public Builder timecodeBurninPosition(String timecodeBurninPosition) {
            return timecodeBurninPosition(Output.of(timecodeBurninPosition));
        }

        public ChannelEncoderSettingsVideoDescriptionCodecSettingsH265SettingsTimecodeBurninSettingsArgs build() {
            return $;
        }
    }

}
