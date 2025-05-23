// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.medialive.outputs;

import com.pulumi.aws.medialive.outputs.ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAncillarySourceSettings;
import com.pulumi.aws.medialive.outputs.ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAribSourceSettings;
import com.pulumi.aws.medialive.outputs.ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsDvbSubSourceSettings;
import com.pulumi.aws.medialive.outputs.ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsEmbeddedSourceSettings;
import com.pulumi.aws.medialive.outputs.ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte20SourceSettings;
import com.pulumi.aws.medialive.outputs.ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte27SourceSettings;
import com.pulumi.aws.medialive.outputs.ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsTeletextSourceSettings;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettings {
    /**
     * @return Ancillary Source Settings. See Ancillary Source Settings for more details.
     * 
     */
    private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAncillarySourceSettings ancillarySourceSettings;
    /**
     * @return ARIB Source Settings.
     * 
     */
    private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAribSourceSettings aribSourceSettings;
    /**
     * @return DVB Sub Source Settings. See DVB Sub Source Settings for more details.
     * 
     */
    private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsDvbSubSourceSettings dvbSubSourceSettings;
    /**
     * @return Embedded Source Settings. See Embedded Source Settings for more details.
     * 
     */
    private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsEmbeddedSourceSettings embeddedSourceSettings;
    /**
     * @return SCTE20 Source Settings. See SCTE 20 Source Settings for more details.
     * 
     */
    private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte20SourceSettings scte20SourceSettings;
    /**
     * @return SCTE27 Source Settings. See SCTE 27 Source Settings for more details.
     * 
     */
    private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte27SourceSettings scte27SourceSettings;
    /**
     * @return Teletext Source Settings. See Teletext Source Settings for more details.
     * 
     */
    private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsTeletextSourceSettings teletextSourceSettings;

    private ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettings() {}
    /**
     * @return Ancillary Source Settings. See Ancillary Source Settings for more details.
     * 
     */
    public Optional<ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAncillarySourceSettings> ancillarySourceSettings() {
        return Optional.ofNullable(this.ancillarySourceSettings);
    }
    /**
     * @return ARIB Source Settings.
     * 
     */
    public Optional<ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAribSourceSettings> aribSourceSettings() {
        return Optional.ofNullable(this.aribSourceSettings);
    }
    /**
     * @return DVB Sub Source Settings. See DVB Sub Source Settings for more details.
     * 
     */
    public Optional<ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsDvbSubSourceSettings> dvbSubSourceSettings() {
        return Optional.ofNullable(this.dvbSubSourceSettings);
    }
    /**
     * @return Embedded Source Settings. See Embedded Source Settings for more details.
     * 
     */
    public Optional<ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsEmbeddedSourceSettings> embeddedSourceSettings() {
        return Optional.ofNullable(this.embeddedSourceSettings);
    }
    /**
     * @return SCTE20 Source Settings. See SCTE 20 Source Settings for more details.
     * 
     */
    public Optional<ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte20SourceSettings> scte20SourceSettings() {
        return Optional.ofNullable(this.scte20SourceSettings);
    }
    /**
     * @return SCTE27 Source Settings. See SCTE 27 Source Settings for more details.
     * 
     */
    public Optional<ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte27SourceSettings> scte27SourceSettings() {
        return Optional.ofNullable(this.scte27SourceSettings);
    }
    /**
     * @return Teletext Source Settings. See Teletext Source Settings for more details.
     * 
     */
    public Optional<ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsTeletextSourceSettings> teletextSourceSettings() {
        return Optional.ofNullable(this.teletextSourceSettings);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettings defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAncillarySourceSettings ancillarySourceSettings;
        private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAribSourceSettings aribSourceSettings;
        private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsDvbSubSourceSettings dvbSubSourceSettings;
        private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsEmbeddedSourceSettings embeddedSourceSettings;
        private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte20SourceSettings scte20SourceSettings;
        private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte27SourceSettings scte27SourceSettings;
        private @Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsTeletextSourceSettings teletextSourceSettings;
        public Builder() {}
        public Builder(ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettings defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.ancillarySourceSettings = defaults.ancillarySourceSettings;
    	      this.aribSourceSettings = defaults.aribSourceSettings;
    	      this.dvbSubSourceSettings = defaults.dvbSubSourceSettings;
    	      this.embeddedSourceSettings = defaults.embeddedSourceSettings;
    	      this.scte20SourceSettings = defaults.scte20SourceSettings;
    	      this.scte27SourceSettings = defaults.scte27SourceSettings;
    	      this.teletextSourceSettings = defaults.teletextSourceSettings;
        }

        @CustomType.Setter
        public Builder ancillarySourceSettings(@Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAncillarySourceSettings ancillarySourceSettings) {

            this.ancillarySourceSettings = ancillarySourceSettings;
            return this;
        }
        @CustomType.Setter
        public Builder aribSourceSettings(@Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsAribSourceSettings aribSourceSettings) {

            this.aribSourceSettings = aribSourceSettings;
            return this;
        }
        @CustomType.Setter
        public Builder dvbSubSourceSettings(@Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsDvbSubSourceSettings dvbSubSourceSettings) {

            this.dvbSubSourceSettings = dvbSubSourceSettings;
            return this;
        }
        @CustomType.Setter
        public Builder embeddedSourceSettings(@Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsEmbeddedSourceSettings embeddedSourceSettings) {

            this.embeddedSourceSettings = embeddedSourceSettings;
            return this;
        }
        @CustomType.Setter
        public Builder scte20SourceSettings(@Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte20SourceSettings scte20SourceSettings) {

            this.scte20SourceSettings = scte20SourceSettings;
            return this;
        }
        @CustomType.Setter
        public Builder scte27SourceSettings(@Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsScte27SourceSettings scte27SourceSettings) {

            this.scte27SourceSettings = scte27SourceSettings;
            return this;
        }
        @CustomType.Setter
        public Builder teletextSourceSettings(@Nullable ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsTeletextSourceSettings teletextSourceSettings) {

            this.teletextSourceSettings = teletextSourceSettings;
            return this;
        }
        public ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettings build() {
            final var _resultValue = new ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettings();
            _resultValue.ancillarySourceSettings = ancillarySourceSettings;
            _resultValue.aribSourceSettings = aribSourceSettings;
            _resultValue.dvbSubSourceSettings = dvbSubSourceSettings;
            _resultValue.embeddedSourceSettings = embeddedSourceSettings;
            _resultValue.scte20SourceSettings = scte20SourceSettings;
            _resultValue.scte27SourceSettings = scte27SourceSettings;
            _resultValue.teletextSourceSettings = teletextSourceSettings;
            return _resultValue;
        }
    }
}
