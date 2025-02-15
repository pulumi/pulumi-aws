// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.chime.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class VoiceConnectorState extends com.pulumi.resources.ResourceArgs {

    public static final VoiceConnectorState Empty = new VoiceConnectorState();

    /**
     * ARN (Amazon Resource Name) of the Amazon Chime Voice Connector.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN (Amazon Resource Name) of the Amazon Chime Voice Connector.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The AWS Region in which the Amazon Chime Voice Connector is created. Default value: `us-east-1`
     * 
     */
    @Import(name="awsRegion")
    private @Nullable Output<String> awsRegion;

    /**
     * @return The AWS Region in which the Amazon Chime Voice Connector is created. Default value: `us-east-1`
     * 
     */
    public Optional<Output<String>> awsRegion() {
        return Optional.ofNullable(this.awsRegion);
    }

    /**
     * The name of the Amazon Chime Voice Connector.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the Amazon Chime Voice Connector.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * The outbound host name for the Amazon Chime Voice Connector.
     * 
     */
    @Import(name="outboundHostName")
    private @Nullable Output<String> outboundHostName;

    /**
     * @return The outbound host name for the Amazon Chime Voice Connector.
     * 
     */
    public Optional<Output<String>> outboundHostName() {
        return Optional.ofNullable(this.outboundHostName);
    }

    /**
     * When enabled, requires encryption for the Amazon Chime Voice Connector.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="requireEncryption")
    private @Nullable Output<Boolean> requireEncryption;

    /**
     * @return When enabled, requires encryption for the Amazon Chime Voice Connector.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<Boolean>> requireEncryption() {
        return Optional.ofNullable(this.requireEncryption);
    }

    /**
     * Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    private VoiceConnectorState() {}

    private VoiceConnectorState(VoiceConnectorState $) {
        this.arn = $.arn;
        this.awsRegion = $.awsRegion;
        this.name = $.name;
        this.outboundHostName = $.outboundHostName;
        this.requireEncryption = $.requireEncryption;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(VoiceConnectorState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private VoiceConnectorState $;

        public Builder() {
            $ = new VoiceConnectorState();
        }

        public Builder(VoiceConnectorState defaults) {
            $ = new VoiceConnectorState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN (Amazon Resource Name) of the Amazon Chime Voice Connector.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN (Amazon Resource Name) of the Amazon Chime Voice Connector.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param awsRegion The AWS Region in which the Amazon Chime Voice Connector is created. Default value: `us-east-1`
         * 
         * @return builder
         * 
         */
        public Builder awsRegion(@Nullable Output<String> awsRegion) {
            $.awsRegion = awsRegion;
            return this;
        }

        /**
         * @param awsRegion The AWS Region in which the Amazon Chime Voice Connector is created. Default value: `us-east-1`
         * 
         * @return builder
         * 
         */
        public Builder awsRegion(String awsRegion) {
            return awsRegion(Output.of(awsRegion));
        }

        /**
         * @param name The name of the Amazon Chime Voice Connector.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the Amazon Chime Voice Connector.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param outboundHostName The outbound host name for the Amazon Chime Voice Connector.
         * 
         * @return builder
         * 
         */
        public Builder outboundHostName(@Nullable Output<String> outboundHostName) {
            $.outboundHostName = outboundHostName;
            return this;
        }

        /**
         * @param outboundHostName The outbound host name for the Amazon Chime Voice Connector.
         * 
         * @return builder
         * 
         */
        public Builder outboundHostName(String outboundHostName) {
            return outboundHostName(Output.of(outboundHostName));
        }

        /**
         * @param requireEncryption When enabled, requires encryption for the Amazon Chime Voice Connector.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder requireEncryption(@Nullable Output<Boolean> requireEncryption) {
            $.requireEncryption = requireEncryption;
            return this;
        }

        /**
         * @param requireEncryption When enabled, requires encryption for the Amazon Chime Voice Connector.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder requireEncryption(Boolean requireEncryption) {
            return requireEncryption(Output.of(requireEncryption));
        }

        /**
         * @param tags Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public VoiceConnectorState build() {
            return $;
        }
    }

}
