// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.GetManagedPrefixListFilter;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetManagedPrefixListPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetManagedPrefixListPlainArgs Empty = new GetManagedPrefixListPlainArgs();

    /**
     * Configuration block(s) for filtering. Detailed below.
     * 
     * The arguments of this data source act as filters for querying the available
     * prefix lists. The given filters must match exactly one prefix list
     * whose data will be exported as attributes.
     * 
     */
    @Import(name="filters")
    private @Nullable List<GetManagedPrefixListFilter> filters;

    /**
     * @return Configuration block(s) for filtering. Detailed below.
     * 
     * The arguments of this data source act as filters for querying the available
     * prefix lists. The given filters must match exactly one prefix list
     * whose data will be exported as attributes.
     * 
     */
    public Optional<List<GetManagedPrefixListFilter>> filters() {
        return Optional.ofNullable(this.filters);
    }

    /**
     * ID of the prefix list to select.
     * 
     */
    @Import(name="id")
    private @Nullable String id;

    /**
     * @return ID of the prefix list to select.
     * 
     */
    public Optional<String> id() {
        return Optional.ofNullable(this.id);
    }

    /**
     * Name of the prefix list to select.
     * 
     */
    @Import(name="name")
    private @Nullable String name;

    /**
     * @return Name of the prefix list to select.
     * 
     */
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Map of tags assigned to the resource.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Map of tags assigned to the resource.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetManagedPrefixListPlainArgs() {}

    private GetManagedPrefixListPlainArgs(GetManagedPrefixListPlainArgs $) {
        this.filters = $.filters;
        this.id = $.id;
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetManagedPrefixListPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetManagedPrefixListPlainArgs $;

        public Builder() {
            $ = new GetManagedPrefixListPlainArgs();
        }

        public Builder(GetManagedPrefixListPlainArgs defaults) {
            $ = new GetManagedPrefixListPlainArgs(Objects.requireNonNull(defaults));
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
        public Builder filters(@Nullable List<GetManagedPrefixListFilter> filters) {
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
        public Builder filters(GetManagedPrefixListFilter... filters) {
            return filters(List.of(filters));
        }

        /**
         * @param id ID of the prefix list to select.
         * 
         * @return builder
         * 
         */
        public Builder id(@Nullable String id) {
            $.id = id;
            return this;
        }

        /**
         * @param name Name of the prefix list to select.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable String name) {
            $.name = name;
            return this;
        }

        /**
         * @param tags Map of tags assigned to the resource.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetManagedPrefixListPlainArgs build() {
            return $;
        }
    }

}
