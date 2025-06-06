// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.inspector2.inputs;

import com.pulumi.aws.inspector2.inputs.FilterFilterCriteriaArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class FilterState extends com.pulumi.resources.ResourceArgs {

    public static final FilterState Empty = new FilterState();

    /**
     * Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
     * 
     */
    @Import(name="action")
    private @Nullable Output<String> action;

    /**
     * @return Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
     * 
     */
    public Optional<Output<String>> action() {
        return Optional.ofNullable(this.action);
    }

    /**
     * ARN of the Filter.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the Filter.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Description
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Details on the filter criteria. Documented below.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="filterCriterias")
    private @Nullable Output<List<FilterFilterCriteriaArgs>> filterCriterias;

    /**
     * @return Details on the filter criteria. Documented below.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<List<FilterFilterCriteriaArgs>>> filterCriterias() {
        return Optional.ofNullable(this.filterCriterias);
    }

    /**
     * Name of the filter.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the filter.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Reason for creating the filter
     * 
     */
    @Import(name="reason")
    private @Nullable Output<String> reason;

    /**
     * @return Reason for creating the filter
     * 
     */
    public Optional<Output<String>> reason() {
        return Optional.ofNullable(this.reason);
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

    private FilterState() {}

    private FilterState(FilterState $) {
        this.action = $.action;
        this.arn = $.arn;
        this.description = $.description;
        this.filterCriterias = $.filterCriterias;
        this.name = $.name;
        this.reason = $.reason;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(FilterState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private FilterState $;

        public Builder() {
            $ = new FilterState();
        }

        public Builder(FilterState defaults) {
            $ = new FilterState(Objects.requireNonNull(defaults));
        }

        /**
         * @param action Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
         * 
         * @return builder
         * 
         */
        public Builder action(@Nullable Output<String> action) {
            $.action = action;
            return this;
        }

        /**
         * @param action Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
         * 
         * @return builder
         * 
         */
        public Builder action(String action) {
            return action(Output.of(action));
        }

        /**
         * @param arn ARN of the Filter.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the Filter.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param description Description
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param filterCriterias Details on the filter criteria. Documented below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder filterCriterias(@Nullable Output<List<FilterFilterCriteriaArgs>> filterCriterias) {
            $.filterCriterias = filterCriterias;
            return this;
        }

        /**
         * @param filterCriterias Details on the filter criteria. Documented below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder filterCriterias(List<FilterFilterCriteriaArgs> filterCriterias) {
            return filterCriterias(Output.of(filterCriterias));
        }

        /**
         * @param filterCriterias Details on the filter criteria. Documented below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder filterCriterias(FilterFilterCriteriaArgs... filterCriterias) {
            return filterCriterias(List.of(filterCriterias));
        }

        /**
         * @param name Name of the filter.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the filter.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param reason Reason for creating the filter
         * 
         * @return builder
         * 
         */
        public Builder reason(@Nullable Output<String> reason) {
            $.reason = reason;
            return this;
        }

        /**
         * @param reason Reason for creating the filter
         * 
         * @return builder
         * 
         */
        public Builder reason(String reason) {
            return reason(Output.of(reason));
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

        public FilterState build() {
            return $;
        }
    }

}
