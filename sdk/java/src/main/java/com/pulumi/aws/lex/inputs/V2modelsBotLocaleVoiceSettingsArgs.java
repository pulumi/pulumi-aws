// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsBotLocaleVoiceSettingsArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsBotLocaleVoiceSettingsArgs Empty = new V2modelsBotLocaleVoiceSettingsArgs();

    /**
     * Indicates the type of Amazon Polly voice that Amazon Lex should use for voice interaction with the user. Valid values are `standard` and `neural`. If not specified, the default is `standard`.
     * 
     */
    @Import(name="engine")
    private @Nullable Output<String> engine;

    /**
     * @return Indicates the type of Amazon Polly voice that Amazon Lex should use for voice interaction with the user. Valid values are `standard` and `neural`. If not specified, the default is `standard`.
     * 
     */
    public Optional<Output<String>> engine() {
        return Optional.ofNullable(this.engine);
    }

    /**
     * Identifier of the Amazon Polly voice to use.
     * 
     */
    @Import(name="voiceId", required=true)
    private Output<String> voiceId;

    /**
     * @return Identifier of the Amazon Polly voice to use.
     * 
     */
    public Output<String> voiceId() {
        return this.voiceId;
    }

    private V2modelsBotLocaleVoiceSettingsArgs() {}

    private V2modelsBotLocaleVoiceSettingsArgs(V2modelsBotLocaleVoiceSettingsArgs $) {
        this.engine = $.engine;
        this.voiceId = $.voiceId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsBotLocaleVoiceSettingsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsBotLocaleVoiceSettingsArgs $;

        public Builder() {
            $ = new V2modelsBotLocaleVoiceSettingsArgs();
        }

        public Builder(V2modelsBotLocaleVoiceSettingsArgs defaults) {
            $ = new V2modelsBotLocaleVoiceSettingsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param engine Indicates the type of Amazon Polly voice that Amazon Lex should use for voice interaction with the user. Valid values are `standard` and `neural`. If not specified, the default is `standard`.
         * 
         * @return builder
         * 
         */
        public Builder engine(@Nullable Output<String> engine) {
            $.engine = engine;
            return this;
        }

        /**
         * @param engine Indicates the type of Amazon Polly voice that Amazon Lex should use for voice interaction with the user. Valid values are `standard` and `neural`. If not specified, the default is `standard`.
         * 
         * @return builder
         * 
         */
        public Builder engine(String engine) {
            return engine(Output.of(engine));
        }

        /**
         * @param voiceId Identifier of the Amazon Polly voice to use.
         * 
         * @return builder
         * 
         */
        public Builder voiceId(Output<String> voiceId) {
            $.voiceId = voiceId;
            return this;
        }

        /**
         * @param voiceId Identifier of the Amazon Polly voice to use.
         * 
         * @return builder
         * 
         */
        public Builder voiceId(String voiceId) {
            return voiceId(Output.of(voiceId));
        }

        public V2modelsBotLocaleVoiceSettingsArgs build() {
            if ($.voiceId == null) {
                throw new MissingRequiredPropertyException("V2modelsBotLocaleVoiceSettingsArgs", "voiceId");
            }
            return $;
        }
    }

}
