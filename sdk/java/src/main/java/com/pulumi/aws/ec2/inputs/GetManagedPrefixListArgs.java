// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.GetManagedPrefixListFilterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetManagedPrefixListArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetManagedPrefixListArgs Empty = new GetManagedPrefixListArgs();

    /**
     * Configuration block(s) for filtering. Detailed below.
     * 
     * The arguments of this data source act as filters for querying the available
     * prefix lists. The given filters must match exactly one prefix list
     * whose data will be exported as attributes.
     * 
     */
    @Import(name="filters")
    private @Nullable Output<List<GetManagedPrefixListFilterArgs>> filters;

    /**
     * @return Configuration block(s) for filtering. Detailed below.
     * 
     * The arguments of this data source act as filters for querying the available
     * prefix lists. The given filters must match exactly one prefix list
     * whose data will be exported as attributes.
     * 
     */
    public Optional<Output<List<GetManagedPrefixListFilterArgs>>> filters() {
        return Optional.ofNullable(this.filters);
    }

    /**
     * ID of the prefix list to select.
     * 
     */
    @Import(name="id")
    private @Nullable Output<String> id;

    /**
     * @return ID of the prefix list to select.
     * 
     */
    public Optional<Output<String>> id() {
        return Optional.ofNullable(this.id);
    }

    /**
     * Name of the prefix list to select.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the prefix list to select.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Map of tags assigned to the resource.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the resource.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetManagedPrefixListArgs() {}

    private GetManagedPrefixListArgs(GetManagedPrefixListArgs $) {
        this.filters = $.filters;
        this.id = $.id;
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetManagedPrefixListArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetManagedPrefixListArgs $;

        public Builder() {
            $ = new GetManagedPrefixListArgs();
        }

        public Builder(GetManagedPrefixListArgs defaults) {
            $ = new GetManagedPrefixListArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters Configuration block(s) for filtering. Detailed below.
         * 
         * The arguments of this data source act as filters for querying the available
         * prefix lists. The given filters must match exactly one prefix list
         * whose data will be exported as attributes.
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable Output<List<GetManagedPrefixListFilterArgs>> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters Configuration block(s) for filtering. Detailed below.
         * 
         * The arguments of this data source act as filters for querying the available
         * prefix lists. The given filters must match exactly one prefix list
         * whose data will be exported as attributes.
         * 
         * @return builder
         * 
         */
        public Builder filters(List<GetManagedPrefixListFilterArgs> filters) {
            return filters(Output.of(filters));
        }

        /**
         * @param filters Configuration block(s) for filtering. Detailed below.
         * 
         * The arguments of this data source act as filters for querying the available
         * prefix lists. The given filters must match exactly one prefix list
         * whose data will be exported as attributes.
         * 
         * @return builder
         * 
         */
        public Builder filters(GetManagedPrefixListFilterArgs... filters) {
            return filters(List.of(filters));
        }

        /**
         * @param id ID of the prefix list to select.
         * 
         * @return builder
         * 
         */
        public Builder id(@Nullable Output<String> id) {
            $.id = id;
            return this;
        }

        /**
         * @param id ID of the prefix list to select.
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            return id(Output.of(id));
        }

        /**
         * @param name Name of the prefix list to select.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the prefix list to select.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags Map of tags assigned to the resource.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags assigned to the resource.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public GetManagedPrefixListArgs build() {
            return $;
        }
    }

}
