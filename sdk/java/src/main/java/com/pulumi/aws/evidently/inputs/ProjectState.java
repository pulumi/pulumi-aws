// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.evidently.inputs;

import com.pulumi.aws.evidently.inputs.ProjectDataDeliveryArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ProjectState extends com.pulumi.resources.ResourceArgs {

    public static final ProjectState Empty = new ProjectState();

    /**
     * The number of ongoing experiments currently in the project.
     * 
     */
    @Import(name="activeExperimentCount")
    private @Nullable Output<Integer> activeExperimentCount;

    /**
     * @return The number of ongoing experiments currently in the project.
     * 
     */
    public Optional<Output<Integer>> activeExperimentCount() {
        return Optional.ofNullable(this.activeExperimentCount);
    }

    /**
     * The number of ongoing launches currently in the project.
     * 
     */
    @Import(name="activeLaunchCount")
    private @Nullable Output<Integer> activeLaunchCount;

    /**
     * @return The number of ongoing launches currently in the project.
     * 
     */
    public Optional<Output<Integer>> activeLaunchCount() {
        return Optional.ofNullable(this.activeLaunchCount);
    }

    /**
     * The ARN of the project.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The ARN of the project.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The date and time that the project is created.
     * 
     */
    @Import(name="createdTime")
    private @Nullable Output<String> createdTime;

    /**
     * @return The date and time that the project is created.
     * 
     */
    public Optional<Output<String>> createdTime() {
        return Optional.ofNullable(this.createdTime);
    }

    /**
     * A block that contains information about where Evidently is to store evaluation events for longer term storage, if you choose to do so. If you choose not to store these events, Evidently deletes them after using them to produce metrics and other experiment results that you can view. See below.
     * 
     */
    @Import(name="dataDelivery")
    private @Nullable Output<ProjectDataDeliveryArgs> dataDelivery;

    /**
     * @return A block that contains information about where Evidently is to store evaluation events for longer term storage, if you choose to do so. If you choose not to store these events, Evidently deletes them after using them to produce metrics and other experiment results that you can view. See below.
     * 
     */
    public Optional<Output<ProjectDataDeliveryArgs>> dataDelivery() {
        return Optional.ofNullable(this.dataDelivery);
    }

    /**
     * Specifies the description of the project.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Specifies the description of the project.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * The number of experiments currently in the project. This includes all experiments that have been created and not deleted, whether they are ongoing or not.
     * 
     */
    @Import(name="experimentCount")
    private @Nullable Output<Integer> experimentCount;

    /**
     * @return The number of experiments currently in the project. This includes all experiments that have been created and not deleted, whether they are ongoing or not.
     * 
     */
    public Optional<Output<Integer>> experimentCount() {
        return Optional.ofNullable(this.experimentCount);
    }

    /**
     * The number of features currently in the project.
     * 
     */
    @Import(name="featureCount")
    private @Nullable Output<Integer> featureCount;

    /**
     * @return The number of features currently in the project.
     * 
     */
    public Optional<Output<Integer>> featureCount() {
        return Optional.ofNullable(this.featureCount);
    }

    /**
     * The date and time that the project was most recently updated.
     * 
     */
    @Import(name="lastUpdatedTime")
    private @Nullable Output<String> lastUpdatedTime;

    /**
     * @return The date and time that the project was most recently updated.
     * 
     */
    public Optional<Output<String>> lastUpdatedTime() {
        return Optional.ofNullable(this.lastUpdatedTime);
    }

    /**
     * The number of launches currently in the project. This includes all launches that have been created and not deleted, whether they are ongoing or not.
     * 
     */
    @Import(name="launchCount")
    private @Nullable Output<Integer> launchCount;

    /**
     * @return The number of launches currently in the project. This includes all launches that have been created and not deleted, whether they are ongoing or not.
     * 
     */
    public Optional<Output<Integer>> launchCount() {
        return Optional.ofNullable(this.launchCount);
    }

    /**
     * A name for the project.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return A name for the project.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * The current state of the project. Valid values are `AVAILABLE` and `UPDATING`.
     * 
     */
    @Import(name="status")
    private @Nullable Output<String> status;

    /**
     * @return The current state of the project. Valid values are `AVAILABLE` and `UPDATING`.
     * 
     */
    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    /**
     * Tags to apply to the project. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Tags to apply to the project. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

    private ProjectState() {}

    private ProjectState(ProjectState $) {
        this.activeExperimentCount = $.activeExperimentCount;
        this.activeLaunchCount = $.activeLaunchCount;
        this.arn = $.arn;
        this.createdTime = $.createdTime;
        this.dataDelivery = $.dataDelivery;
        this.description = $.description;
        this.experimentCount = $.experimentCount;
        this.featureCount = $.featureCount;
        this.lastUpdatedTime = $.lastUpdatedTime;
        this.launchCount = $.launchCount;
        this.name = $.name;
        this.status = $.status;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ProjectState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ProjectState $;

        public Builder() {
            $ = new ProjectState();
        }

        public Builder(ProjectState defaults) {
            $ = new ProjectState(Objects.requireNonNull(defaults));
        }

        /**
         * @param activeExperimentCount The number of ongoing experiments currently in the project.
         * 
         * @return builder
         * 
         */
        public Builder activeExperimentCount(@Nullable Output<Integer> activeExperimentCount) {
            $.activeExperimentCount = activeExperimentCount;
            return this;
        }

        /**
         * @param activeExperimentCount The number of ongoing experiments currently in the project.
         * 
         * @return builder
         * 
         */
        public Builder activeExperimentCount(Integer activeExperimentCount) {
            return activeExperimentCount(Output.of(activeExperimentCount));
        }

        /**
         * @param activeLaunchCount The number of ongoing launches currently in the project.
         * 
         * @return builder
         * 
         */
        public Builder activeLaunchCount(@Nullable Output<Integer> activeLaunchCount) {
            $.activeLaunchCount = activeLaunchCount;
            return this;
        }

        /**
         * @param activeLaunchCount The number of ongoing launches currently in the project.
         * 
         * @return builder
         * 
         */
        public Builder activeLaunchCount(Integer activeLaunchCount) {
            return activeLaunchCount(Output.of(activeLaunchCount));
        }

        /**
         * @param arn The ARN of the project.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The ARN of the project.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param createdTime The date and time that the project is created.
         * 
         * @return builder
         * 
         */
        public Builder createdTime(@Nullable Output<String> createdTime) {
            $.createdTime = createdTime;
            return this;
        }

        /**
         * @param createdTime The date and time that the project is created.
         * 
         * @return builder
         * 
         */
        public Builder createdTime(String createdTime) {
            return createdTime(Output.of(createdTime));
        }

        /**
         * @param dataDelivery A block that contains information about where Evidently is to store evaluation events for longer term storage, if you choose to do so. If you choose not to store these events, Evidently deletes them after using them to produce metrics and other experiment results that you can view. See below.
         * 
         * @return builder
         * 
         */
        public Builder dataDelivery(@Nullable Output<ProjectDataDeliveryArgs> dataDelivery) {
            $.dataDelivery = dataDelivery;
            return this;
        }

        /**
         * @param dataDelivery A block that contains information about where Evidently is to store evaluation events for longer term storage, if you choose to do so. If you choose not to store these events, Evidently deletes them after using them to produce metrics and other experiment results that you can view. See below.
         * 
         * @return builder
         * 
         */
        public Builder dataDelivery(ProjectDataDeliveryArgs dataDelivery) {
            return dataDelivery(Output.of(dataDelivery));
        }

        /**
         * @param description Specifies the description of the project.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Specifies the description of the project.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param experimentCount The number of experiments currently in the project. This includes all experiments that have been created and not deleted, whether they are ongoing or not.
         * 
         * @return builder
         * 
         */
        public Builder experimentCount(@Nullable Output<Integer> experimentCount) {
            $.experimentCount = experimentCount;
            return this;
        }

        /**
         * @param experimentCount The number of experiments currently in the project. This includes all experiments that have been created and not deleted, whether they are ongoing or not.
         * 
         * @return builder
         * 
         */
        public Builder experimentCount(Integer experimentCount) {
            return experimentCount(Output.of(experimentCount));
        }

        /**
         * @param featureCount The number of features currently in the project.
         * 
         * @return builder
         * 
         */
        public Builder featureCount(@Nullable Output<Integer> featureCount) {
            $.featureCount = featureCount;
            return this;
        }

        /**
         * @param featureCount The number of features currently in the project.
         * 
         * @return builder
         * 
         */
        public Builder featureCount(Integer featureCount) {
            return featureCount(Output.of(featureCount));
        }

        /**
         * @param lastUpdatedTime The date and time that the project was most recently updated.
         * 
         * @return builder
         * 
         */
        public Builder lastUpdatedTime(@Nullable Output<String> lastUpdatedTime) {
            $.lastUpdatedTime = lastUpdatedTime;
            return this;
        }

        /**
         * @param lastUpdatedTime The date and time that the project was most recently updated.
         * 
         * @return builder
         * 
         */
        public Builder lastUpdatedTime(String lastUpdatedTime) {
            return lastUpdatedTime(Output.of(lastUpdatedTime));
        }

        /**
         * @param launchCount The number of launches currently in the project. This includes all launches that have been created and not deleted, whether they are ongoing or not.
         * 
         * @return builder
         * 
         */
        public Builder launchCount(@Nullable Output<Integer> launchCount) {
            $.launchCount = launchCount;
            return this;
        }

        /**
         * @param launchCount The number of launches currently in the project. This includes all launches that have been created and not deleted, whether they are ongoing or not.
         * 
         * @return builder
         * 
         */
        public Builder launchCount(Integer launchCount) {
            return launchCount(Output.of(launchCount));
        }

        /**
         * @param name A name for the project.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name A name for the project.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param status The current state of the project. Valid values are `AVAILABLE` and `UPDATING`.
         * 
         * @return builder
         * 
         */
        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status The current state of the project. Valid values are `AVAILABLE` and `UPDATING`.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        /**
         * @param tags Tags to apply to the project. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Tags to apply to the project. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public ProjectState build() {
            return $;
        }
    }

}
