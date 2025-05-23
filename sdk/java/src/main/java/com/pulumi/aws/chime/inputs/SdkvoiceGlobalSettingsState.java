// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.chime.inputs;

import com.pulumi.aws.chime.inputs.SdkvoiceGlobalSettingsVoiceConnectorArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SdkvoiceGlobalSettingsState extends com.pulumi.resources.ResourceArgs {

    public static final SdkvoiceGlobalSettingsState Empty = new SdkvoiceGlobalSettingsState();

    /**
     * The Voice Connector settings. See voice_connector.
     * 
     */
    @Import(name="voiceConnector")
    private @Nullable Output<SdkvoiceGlobalSettingsVoiceConnectorArgs> voiceConnector;

    /**
     * @return The Voice Connector settings. See voice_connector.
     * 
     */
    public Optional<Output<SdkvoiceGlobalSettingsVoiceConnectorArgs>> voiceConnector() {
        return Optional.ofNullable(this.voiceConnector);
    }

    private SdkvoiceGlobalSettingsState() {}

    private SdkvoiceGlobalSettingsState(SdkvoiceGlobalSettingsState $) {
        this.voiceConnector = $.voiceConnector;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SdkvoiceGlobalSettingsState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SdkvoiceGlobalSettingsState $;

        public Builder() {
            $ = new SdkvoiceGlobalSettingsState();
        }

        public Builder(SdkvoiceGlobalSettingsState defaults) {
            $ = new SdkvoiceGlobalSettingsState(Objects.requireNonNull(defaults));
        }

        /**
         * @param voiceConnector The Voice Connector settings. See voice_connector.
         * 
         * @return builder
         * 
         */
        public Builder voiceConnector(@Nullable Output<SdkvoiceGlobalSettingsVoiceConnectorArgs> voiceConnector) {
            $.voiceConnector = voiceConnector;
            return this;
        }

        /**
         * @param voiceConnector The Voice Connector settings. See voice_connector.
         * 
         * @return builder
         * 
         */
        public Builder voiceConnector(SdkvoiceGlobalSettingsVoiceConnectorArgs voiceConnector) {
            return voiceConnector(Output.of(voiceConnector));
        }

        public SdkvoiceGlobalSettingsState build() {
            return $;
        }
    }

}
