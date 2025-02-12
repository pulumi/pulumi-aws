// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssm.inputs;

import com.pulumi.aws.ssm.inputs.QuicksetupConfigurationManagerConfigurationDefinitionArgs;
import com.pulumi.aws.ssm.inputs.QuicksetupConfigurationManagerStatusSummaryArgs;
import com.pulumi.aws.ssm.inputs.QuicksetupConfigurationManagerTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class QuicksetupConfigurationManagerState extends com.pulumi.resources.ResourceArgs {

    public static final QuicksetupConfigurationManagerState Empty = new QuicksetupConfigurationManagerState();

    /**
     * Definition of the Quick Setup configuration that the configuration manager deploys. See `configuration_definition` below.
     * 
     */
    @Import(name="configurationDefinition")
    private @Nullable Output<QuicksetupConfigurationManagerConfigurationDefinitionArgs> configurationDefinition;

    /**
     * @return Definition of the Quick Setup configuration that the configuration manager deploys. See `configuration_definition` below.
     * 
     */
    public Optional<Output<QuicksetupConfigurationManagerConfigurationDefinitionArgs>> configurationDefinition() {
        return Optional.ofNullable(this.configurationDefinition);
    }

    /**
     * Description of the configuration manager.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description of the configuration manager.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * ARN of the Configuration Manager.
     * 
     */
    @Import(name="managerArn")
    private @Nullable Output<String> managerArn;

    /**
     * @return ARN of the Configuration Manager.
     * 
     */
    public Optional<Output<String>> managerArn() {
        return Optional.ofNullable(this.managerArn);
    }

    /**
     * Configuration manager name.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Configuration manager name.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * A summary of the state of the configuration manager. This includes deployment statuses, association statuses, drift statuses, health checks, and more. See `status_summaries` below.
     * 
     */
    @Import(name="statusSummaries")
    private @Nullable Output<List<QuicksetupConfigurationManagerStatusSummaryArgs>> statusSummaries;

    /**
     * @return A summary of the state of the configuration manager. This includes deployment statuses, association statuses, drift statuses, health checks, and more. See `status_summaries` below.
     * 
     */
    public Optional<Output<List<QuicksetupConfigurationManagerStatusSummaryArgs>>> statusSummaries() {
        return Optional.ofNullable(this.statusSummaries);
    }

    /**
     * Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

    @Import(name="timeouts")
    private @Nullable Output<QuicksetupConfigurationManagerTimeoutsArgs> timeouts;

    public Optional<Output<QuicksetupConfigurationManagerTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private QuicksetupConfigurationManagerState() {}

    private QuicksetupConfigurationManagerState(QuicksetupConfigurationManagerState $) {
        this.configurationDefinition = $.configurationDefinition;
        this.description = $.description;
        this.managerArn = $.managerArn;
        this.name = $.name;
        this.statusSummaries = $.statusSummaries;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(QuicksetupConfigurationManagerState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private QuicksetupConfigurationManagerState $;

        public Builder() {
            $ = new QuicksetupConfigurationManagerState();
        }

        public Builder(QuicksetupConfigurationManagerState defaults) {
            $ = new QuicksetupConfigurationManagerState(Objects.requireNonNull(defaults));
        }

        /**
         * @param configurationDefinition Definition of the Quick Setup configuration that the configuration manager deploys. See `configuration_definition` below.
         * 
         * @return builder
         * 
         */
        public Builder configurationDefinition(@Nullable Output<QuicksetupConfigurationManagerConfigurationDefinitionArgs> configurationDefinition) {
            $.configurationDefinition = configurationDefinition;
            return this;
        }

        /**
         * @param configurationDefinition Definition of the Quick Setup configuration that the configuration manager deploys. See `configuration_definition` below.
         * 
         * @return builder
         * 
         */
        public Builder configurationDefinition(QuicksetupConfigurationManagerConfigurationDefinitionArgs configurationDefinition) {
            return configurationDefinition(Output.of(configurationDefinition));
        }

        /**
         * @param description Description of the configuration manager.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description of the configuration manager.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param managerArn ARN of the Configuration Manager.
         * 
         * @return builder
         * 
         */
        public Builder managerArn(@Nullable Output<String> managerArn) {
            $.managerArn = managerArn;
            return this;
        }

        /**
         * @param managerArn ARN of the Configuration Manager.
         * 
         * @return builder
         * 
         */
        public Builder managerArn(String managerArn) {
            return managerArn(Output.of(managerArn));
        }

        /**
         * @param name Configuration manager name.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Configuration manager name.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param statusSummaries A summary of the state of the configuration manager. This includes deployment statuses, association statuses, drift statuses, health checks, and more. See `status_summaries` below.
         * 
         * @return builder
         * 
         */
        public Builder statusSummaries(@Nullable Output<List<QuicksetupConfigurationManagerStatusSummaryArgs>> statusSummaries) {
            $.statusSummaries = statusSummaries;
            return this;
        }

        /**
         * @param statusSummaries A summary of the state of the configuration manager. This includes deployment statuses, association statuses, drift statuses, health checks, and more. See `status_summaries` below.
         * 
         * @return builder
         * 
         */
        public Builder statusSummaries(List<QuicksetupConfigurationManagerStatusSummaryArgs> statusSummaries) {
            return statusSummaries(Output.of(statusSummaries));
        }

        /**
         * @param statusSummaries A summary of the state of the configuration manager. This includes deployment statuses, association statuses, drift statuses, health checks, and more. See `status_summaries` below.
         * 
         * @return builder
         * 
         */
        public Builder statusSummaries(QuicksetupConfigurationManagerStatusSummaryArgs... statusSummaries) {
            return statusSummaries(List.of(statusSummaries));
        }

        /**
         * @param tags Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public Builder timeouts(@Nullable Output<QuicksetupConfigurationManagerTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(QuicksetupConfigurationManagerTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public QuicksetupConfigurationManagerState build() {
            return $;
        }
    }

}
