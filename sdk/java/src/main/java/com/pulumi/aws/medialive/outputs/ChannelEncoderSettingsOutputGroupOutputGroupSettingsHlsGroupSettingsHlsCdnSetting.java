// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.medialive.outputs;

import com.pulumi.aws.medialive.outputs.ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsAkamaiSettings;
import com.pulumi.aws.medialive.outputs.ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsBasicPutSettings;
import com.pulumi.aws.medialive.outputs.ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsMediaStoreSettings;
import com.pulumi.aws.medialive.outputs.ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsS3Settings;
import com.pulumi.aws.medialive.outputs.ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsWebdavSettings;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSetting {
    private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsAkamaiSettings hlsAkamaiSettings;
    private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsBasicPutSettings hlsBasicPutSettings;
    private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsMediaStoreSettings hlsMediaStoreSettings;
    private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsS3Settings hlsS3Settings;
    private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsWebdavSettings hlsWebdavSettings;

    private ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSetting() {}
    public Optional<ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsAkamaiSettings> hlsAkamaiSettings() {
        return Optional.ofNullable(this.hlsAkamaiSettings);
    }
    public Optional<ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsBasicPutSettings> hlsBasicPutSettings() {
        return Optional.ofNullable(this.hlsBasicPutSettings);
    }
    public Optional<ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsMediaStoreSettings> hlsMediaStoreSettings() {
        return Optional.ofNullable(this.hlsMediaStoreSettings);
    }
    public Optional<ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsS3Settings> hlsS3Settings() {
        return Optional.ofNullable(this.hlsS3Settings);
    }
    public Optional<ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsWebdavSettings> hlsWebdavSettings() {
        return Optional.ofNullable(this.hlsWebdavSettings);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSetting defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsAkamaiSettings hlsAkamaiSettings;
        private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsBasicPutSettings hlsBasicPutSettings;
        private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsMediaStoreSettings hlsMediaStoreSettings;
        private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsS3Settings hlsS3Settings;
        private @Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsWebdavSettings hlsWebdavSettings;
        public Builder() {}
        public Builder(ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSetting defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.hlsAkamaiSettings = defaults.hlsAkamaiSettings;
    	      this.hlsBasicPutSettings = defaults.hlsBasicPutSettings;
    	      this.hlsMediaStoreSettings = defaults.hlsMediaStoreSettings;
    	      this.hlsS3Settings = defaults.hlsS3Settings;
    	      this.hlsWebdavSettings = defaults.hlsWebdavSettings;
        }

        @CustomType.Setter
        public Builder hlsAkamaiSettings(@Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsAkamaiSettings hlsAkamaiSettings) {

            this.hlsAkamaiSettings = hlsAkamaiSettings;
            return this;
        }
        @CustomType.Setter
        public Builder hlsBasicPutSettings(@Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsBasicPutSettings hlsBasicPutSettings) {

            this.hlsBasicPutSettings = hlsBasicPutSettings;
            return this;
        }
        @CustomType.Setter
        public Builder hlsMediaStoreSettings(@Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsMediaStoreSettings hlsMediaStoreSettings) {

            this.hlsMediaStoreSettings = hlsMediaStoreSettings;
            return this;
        }
        @CustomType.Setter
        public Builder hlsS3Settings(@Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsS3Settings hlsS3Settings) {

            this.hlsS3Settings = hlsS3Settings;
            return this;
        }
        @CustomType.Setter
        public Builder hlsWebdavSettings(@Nullable ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSettingHlsWebdavSettings hlsWebdavSettings) {

            this.hlsWebdavSettings = hlsWebdavSettings;
            return this;
        }
        public ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSetting build() {
            final var _resultValue = new ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsHlsCdnSetting();
            _resultValue.hlsAkamaiSettings = hlsAkamaiSettings;
            _resultValue.hlsBasicPutSettings = hlsBasicPutSettings;
            _resultValue.hlsMediaStoreSettings = hlsMediaStoreSettings;
            _resultValue.hlsS3Settings = hlsS3Settings;
            _resultValue.hlsWebdavSettings = hlsWebdavSettings;
            return _resultValue;
        }
    }
}
