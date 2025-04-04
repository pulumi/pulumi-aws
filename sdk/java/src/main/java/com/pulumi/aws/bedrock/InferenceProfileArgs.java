// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock;

import com.pulumi.aws.bedrock.inputs.InferenceProfileModelSourceArgs;
import com.pulumi.aws.bedrock.inputs.InferenceProfileTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class InferenceProfileArgs extends com.pulumi.resources.ResourceArgs {

    public static final InferenceProfileArgs Empty = new InferenceProfileArgs();

    /**
     * The description of the inference profile.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return The description of the inference profile.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * The source of the model this inference profile will track metrics and cost for. See `model_source`.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="modelSource")
    private @Nullable Output<InferenceProfileModelSourceArgs> modelSource;

    /**
     * @return The source of the model this inference profile will track metrics and cost for. See `model_source`.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<InferenceProfileModelSourceArgs>> modelSource() {
        return Optional.ofNullable(this.modelSource);
    }

    /**
     * The name of the inference profile.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the inference profile.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Key-value mapping of resource tags for the inference profile.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value mapping of resource tags for the inference profile.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    @Import(name="timeouts")
    private @Nullable Output<InferenceProfileTimeoutsArgs> timeouts;

    public Optional<Output<InferenceProfileTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private InferenceProfileArgs() {}

    private InferenceProfileArgs(InferenceProfileArgs $) {
        this.description = $.description;
        this.modelSource = $.modelSource;
        this.name = $.name;
        this.tags = $.tags;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(InferenceProfileArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private InferenceProfileArgs $;

        public Builder() {
            $ = new InferenceProfileArgs();
        }

        public Builder(InferenceProfileArgs defaults) {
            $ = new InferenceProfileArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param description The description of the inference profile.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description The description of the inference profile.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param modelSource The source of the model this inference profile will track metrics and cost for. See `model_source`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder modelSource(@Nullable Output<InferenceProfileModelSourceArgs> modelSource) {
            $.modelSource = modelSource;
            return this;
        }

        /**
         * @param modelSource The source of the model this inference profile will track metrics and cost for. See `model_source`.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder modelSource(InferenceProfileModelSourceArgs modelSource) {
            return modelSource(Output.of(modelSource));
        }

        /**
         * @param name The name of the inference profile.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the inference profile.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags Key-value mapping of resource tags for the inference profile.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value mapping of resource tags for the inference profile.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public Builder timeouts(@Nullable Output<InferenceProfileTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(InferenceProfileTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public InferenceProfileArgs build() {
            return $;
        }
    }

}
