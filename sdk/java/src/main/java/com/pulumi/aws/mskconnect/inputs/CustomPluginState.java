// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.mskconnect.inputs;

import com.pulumi.aws.mskconnect.inputs.CustomPluginLocationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CustomPluginState extends com.pulumi.resources.ResourceArgs {

    public static final CustomPluginState Empty = new CustomPluginState();

    /**
     * the Amazon Resource Name (ARN) of the custom plugin.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return the Amazon Resource Name (ARN) of the custom plugin.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The type of the plugin file. Allowed values are `ZIP` and `JAR`.
     * 
     */
    @Import(name="contentType")
    private @Nullable Output<String> contentType;

    /**
     * @return The type of the plugin file. Allowed values are `ZIP` and `JAR`.
     * 
     */
    public Optional<Output<String>> contentType() {
        return Optional.ofNullable(this.contentType);
    }

    /**
     * A summary description of the custom plugin.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return A summary description of the custom plugin.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * an ID of the latest successfully created revision of the custom plugin.
     * 
     */
    @Import(name="latestRevision")
    private @Nullable Output<Integer> latestRevision;

    /**
     * @return an ID of the latest successfully created revision of the custom plugin.
     * 
     */
    public Optional<Output<Integer>> latestRevision() {
        return Optional.ofNullable(this.latestRevision);
    }

    /**
     * Information about the location of a custom plugin. See `location` Block for details.
     * 
     */
    @Import(name="location")
    private @Nullable Output<CustomPluginLocationArgs> location;

    /**
     * @return Information about the location of a custom plugin. See `location` Block for details.
     * 
     */
    public Optional<Output<CustomPluginLocationArgs>> location() {
        return Optional.ofNullable(this.location);
    }

    /**
     * The name of the custom plugin..
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the custom plugin..
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * the state of the custom plugin.
     * 
     */
    @Import(name="state")
    private @Nullable Output<String> state;

    /**
     * @return the state of the custom plugin.
     * 
     */
    public Optional<Output<String>> state() {
        return Optional.ofNullable(this.state);
    }

    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    private CustomPluginState() {}

    private CustomPluginState(CustomPluginState $) {
        this.arn = $.arn;
        this.contentType = $.contentType;
        this.description = $.description;
        this.latestRevision = $.latestRevision;
        this.location = $.location;
        this.name = $.name;
        this.state = $.state;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CustomPluginState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CustomPluginState $;

        public Builder() {
            $ = new CustomPluginState();
        }

        public Builder(CustomPluginState defaults) {
            $ = new CustomPluginState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn the Amazon Resource Name (ARN) of the custom plugin.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn the Amazon Resource Name (ARN) of the custom plugin.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param contentType The type of the plugin file. Allowed values are `ZIP` and `JAR`.
         * 
         * @return builder
         * 
         */
        public Builder contentType(@Nullable Output<String> contentType) {
            $.contentType = contentType;
            return this;
        }

        /**
         * @param contentType The type of the plugin file. Allowed values are `ZIP` and `JAR`.
         * 
         * @return builder
         * 
         */
        public Builder contentType(String contentType) {
            return contentType(Output.of(contentType));
        }

        /**
         * @param description A summary description of the custom plugin.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description A summary description of the custom plugin.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param latestRevision an ID of the latest successfully created revision of the custom plugin.
         * 
         * @return builder
         * 
         */
        public Builder latestRevision(@Nullable Output<Integer> latestRevision) {
            $.latestRevision = latestRevision;
            return this;
        }

        /**
         * @param latestRevision an ID of the latest successfully created revision of the custom plugin.
         * 
         * @return builder
         * 
         */
        public Builder latestRevision(Integer latestRevision) {
            return latestRevision(Output.of(latestRevision));
        }

        /**
         * @param location Information about the location of a custom plugin. See `location` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder location(@Nullable Output<CustomPluginLocationArgs> location) {
            $.location = location;
            return this;
        }

        /**
         * @param location Information about the location of a custom plugin. See `location` Block for details.
         * 
         * @return builder
         * 
         */
        public Builder location(CustomPluginLocationArgs location) {
            return location(Output.of(location));
        }

        /**
         * @param name The name of the custom plugin..
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the custom plugin..
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param state the state of the custom plugin.
         * 
         * @return builder
         * 
         */
        public Builder state(@Nullable Output<String> state) {
            $.state = state;
            return this;
        }

        /**
         * @param state the state of the custom plugin.
         * 
         * @return builder
         * 
         */
        public Builder state(String state) {
            return state(Output.of(state));
        }

        /**
         * @param tags A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
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
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
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

        public CustomPluginState build() {
            return $;
        }
    }

}
