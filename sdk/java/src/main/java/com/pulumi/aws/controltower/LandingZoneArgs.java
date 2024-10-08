// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.controltower;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class LandingZoneArgs extends com.pulumi.resources.ResourceArgs {

    public static final LandingZoneArgs Empty = new LandingZoneArgs();

    /**
     * The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
     * 
     */
    @Import(name="manifestJson", required=true)
    private Output<String> manifestJson;

    /**
     * @return The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
     * 
     */
    public Output<String> manifestJson() {
        return this.manifestJson;
    }

    /**
     * Tags to apply to the landing zone. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Tags to apply to the landing zone. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * The landing zone version.
     * 
     */
    @Import(name="version", required=true)
    private Output<String> version;

    /**
     * @return The landing zone version.
     * 
     */
    public Output<String> version() {
        return this.version;
    }

    private LandingZoneArgs() {}

    private LandingZoneArgs(LandingZoneArgs $) {
        this.manifestJson = $.manifestJson;
        this.tags = $.tags;
        this.version = $.version;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(LandingZoneArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private LandingZoneArgs $;

        public Builder() {
            $ = new LandingZoneArgs();
        }

        public Builder(LandingZoneArgs defaults) {
            $ = new LandingZoneArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param manifestJson The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
         * 
         * @return builder
         * 
         */
        public Builder manifestJson(Output<String> manifestJson) {
            $.manifestJson = manifestJson;
            return this;
        }

        /**
         * @param manifestJson The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
         * 
         * @return builder
         * 
         */
        public Builder manifestJson(String manifestJson) {
            return manifestJson(Output.of(manifestJson));
        }

        /**
         * @param tags Tags to apply to the landing zone. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Tags to apply to the landing zone. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param version The landing zone version.
         * 
         * @return builder
         * 
         */
        public Builder version(Output<String> version) {
            $.version = version;
            return this;
        }

        /**
         * @param version The landing zone version.
         * 
         * @return builder
         * 
         */
        public Builder version(String version) {
            return version(Output.of(version));
        }

        public LandingZoneArgs build() {
            if ($.manifestJson == null) {
                throw new MissingRequiredPropertyException("LandingZoneArgs", "manifestJson");
            }
            if ($.version == null) {
                throw new MissingRequiredPropertyException("LandingZoneArgs", "version");
            }
            return $;
        }
    }

}
