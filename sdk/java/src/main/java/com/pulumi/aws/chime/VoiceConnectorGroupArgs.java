// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.chime;

import com.pulumi.aws.chime.inputs.VoiceConnectorGroupConnectorArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class VoiceConnectorGroupArgs extends com.pulumi.resources.ResourceArgs {

    public static final VoiceConnectorGroupArgs Empty = new VoiceConnectorGroupArgs();

    /**
     * The Amazon Chime Voice Connectors to route inbound calls to.
     * 
     */
    @Import(name="connectors")
    private @Nullable Output<List<VoiceConnectorGroupConnectorArgs>> connectors;

    /**
     * @return The Amazon Chime Voice Connectors to route inbound calls to.
     * 
     */
    public Optional<Output<List<VoiceConnectorGroupConnectorArgs>>> connectors() {
        return Optional.ofNullable(this.connectors);
    }

    /**
     * The name of the Amazon Chime Voice Connector group.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the Amazon Chime Voice Connector group.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    private VoiceConnectorGroupArgs() {}

    private VoiceConnectorGroupArgs(VoiceConnectorGroupArgs $) {
        this.connectors = $.connectors;
        this.name = $.name;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(VoiceConnectorGroupArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private VoiceConnectorGroupArgs $;

        public Builder() {
            $ = new VoiceConnectorGroupArgs();
        }

        public Builder(VoiceConnectorGroupArgs defaults) {
            $ = new VoiceConnectorGroupArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param connectors The Amazon Chime Voice Connectors to route inbound calls to.
         * 
         * @return builder
         * 
         */
        public Builder connectors(@Nullable Output<List<VoiceConnectorGroupConnectorArgs>> connectors) {
            $.connectors = connectors;
            return this;
        }

        /**
         * @param connectors The Amazon Chime Voice Connectors to route inbound calls to.
         * 
         * @return builder
         * 
         */
        public Builder connectors(List<VoiceConnectorGroupConnectorArgs> connectors) {
            return connectors(Output.of(connectors));
        }

        /**
         * @param connectors The Amazon Chime Voice Connectors to route inbound calls to.
         * 
         * @return builder
         * 
         */
        public Builder connectors(VoiceConnectorGroupConnectorArgs... connectors) {
            return connectors(List.of(connectors));
        }

        /**
         * @param name The name of the Amazon Chime Voice Connector group.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the Amazon Chime Voice Connector group.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        public VoiceConnectorGroupArgs build() {
            return $;
        }
    }

}
