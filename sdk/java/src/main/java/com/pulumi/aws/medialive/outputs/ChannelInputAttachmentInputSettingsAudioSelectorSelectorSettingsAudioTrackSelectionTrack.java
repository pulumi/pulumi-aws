// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.medialive.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioTrackSelectionTrack {
    /**
     * @return 1-based integer value that maps to a specific audio track.
     * 
     */
    private Integer track;

    private ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioTrackSelectionTrack() {}
    /**
     * @return 1-based integer value that maps to a specific audio track.
     * 
     */
    public Integer track() {
        return this.track;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioTrackSelectionTrack defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer track;
        public Builder() {}
        public Builder(ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioTrackSelectionTrack defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.track = defaults.track;
        }

        @CustomType.Setter
        public Builder track(Integer track) {
            if (track == null) {
              throw new MissingRequiredPropertyException("ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioTrackSelectionTrack", "track");
            }
            this.track = track;
            return this;
        }
        public ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioTrackSelectionTrack build() {
            final var _resultValue = new ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioTrackSelectionTrack();
            _resultValue.track = track;
            return _resultValue;
        }
    }
}
