// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.medialive.inputs;

import com.pulumi.aws.medialive.inputs.ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsNielsenWatermarksSettingsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs extends com.pulumi.resources.ResourceArgs {

    public static final ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs Empty = new ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs();

    @Import(name="nielsenWatermarksSettings")
    private @Nullable Output<ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsNielsenWatermarksSettingsArgs> nielsenWatermarksSettings;

    public Optional<Output<ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsNielsenWatermarksSettingsArgs>> nielsenWatermarksSettings() {
        return Optional.ofNullable(this.nielsenWatermarksSettings);
    }

    private ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs() {}

    private ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs(ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs $) {
        this.nielsenWatermarksSettings = $.nielsenWatermarksSettings;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs $;

        public Builder() {
            $ = new ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs();
        }

        public Builder(ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs defaults) {
            $ = new ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs(Objects.requireNonNull(defaults));
        }

        public Builder nielsenWatermarksSettings(@Nullable Output<ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsNielsenWatermarksSettingsArgs> nielsenWatermarksSettings) {
            $.nielsenWatermarksSettings = nielsenWatermarksSettings;
            return this;
        }

        public Builder nielsenWatermarksSettings(ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsNielsenWatermarksSettingsArgs nielsenWatermarksSettings) {
            return nielsenWatermarksSettings(Output.of(nielsenWatermarksSettings));
        }

        public ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsArgs build() {
            return $;
        }
    }

}
