// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder;

import com.pulumi.aws.imagebuilder.inputs.DistributionConfigurationDistributionArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DistributionConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final DistributionConfigurationArgs Empty = new DistributionConfigurationArgs();

    /**
     * Description of the distribution configuration.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description of the distribution configuration.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * One or more configuration blocks with distribution settings. Detailed below.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="distributions", required=true)
    private Output<List<DistributionConfigurationDistributionArgs>> distributions;

    /**
     * @return One or more configuration blocks with distribution settings. Detailed below.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<List<DistributionConfigurationDistributionArgs>> distributions() {
        return this.distributions;
    }

    /**
     * Name of the distribution configuration.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the distribution configuration.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Key-value map of resource tags for the distribution configuration. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags for the distribution configuration. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private DistributionConfigurationArgs() {}

    private DistributionConfigurationArgs(DistributionConfigurationArgs $) {
        this.description = $.description;
        this.distributions = $.distributions;
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DistributionConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DistributionConfigurationArgs $;

        public Builder() {
            $ = new DistributionConfigurationArgs();
        }

        public Builder(DistributionConfigurationArgs defaults) {
            $ = new DistributionConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param description Description of the distribution configuration.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description of the distribution configuration.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param distributions One or more configuration blocks with distribution settings. Detailed below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder distributions(Output<List<DistributionConfigurationDistributionArgs>> distributions) {
            $.distributions = distributions;
            return this;
        }

        /**
         * @param distributions One or more configuration blocks with distribution settings. Detailed below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder distributions(List<DistributionConfigurationDistributionArgs> distributions) {
            return distributions(Output.of(distributions));
        }

        /**
         * @param distributions One or more configuration blocks with distribution settings. Detailed below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder distributions(DistributionConfigurationDistributionArgs... distributions) {
            return distributions(List.of(distributions));
        }

        /**
         * @param name Name of the distribution configuration.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the distribution configuration.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags Key-value map of resource tags for the distribution configuration. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value map of resource tags for the distribution configuration. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public DistributionConfigurationArgs build() {
            if ($.distributions == null) {
                throw new MissingRequiredPropertyException("DistributionConfigurationArgs", "distributions");
            }
            return $;
        }
    }

}
