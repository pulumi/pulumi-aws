// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssm;

import com.pulumi.aws.ssm.inputs.QuicksetupConfigurationManagerConfigurationDefinitionArgs;
import com.pulumi.aws.ssm.inputs.QuicksetupConfigurationManagerTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class QuicksetupConfigurationManagerArgs extends com.pulumi.resources.ResourceArgs {

    public static final QuicksetupConfigurationManagerArgs Empty = new QuicksetupConfigurationManagerArgs();

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

    @Import(name="timeouts")
    private @Nullable Output<QuicksetupConfigurationManagerTimeoutsArgs> timeouts;

    public Optional<Output<QuicksetupConfigurationManagerTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private QuicksetupConfigurationManagerArgs() {}

    private QuicksetupConfigurationManagerArgs(QuicksetupConfigurationManagerArgs $) {
        this.configurationDefinition = $.configurationDefinition;
        this.description = $.description;
        this.name = $.name;
        this.tags = $.tags;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(QuicksetupConfigurationManagerArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private QuicksetupConfigurationManagerArgs $;

        public Builder() {
            $ = new QuicksetupConfigurationManagerArgs();
        }

        public Builder(QuicksetupConfigurationManagerArgs defaults) {
            $ = new QuicksetupConfigurationManagerArgs(Objects.requireNonNull(defaults));
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

        public Builder timeouts(@Nullable Output<QuicksetupConfigurationManagerTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(QuicksetupConfigurationManagerTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public QuicksetupConfigurationManagerArgs build() {
            return $;
        }
    }

}
