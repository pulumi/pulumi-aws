// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ram.inputs;

import com.pulumi.aws.ram.inputs.GetResourceShareFilter;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetResourceSharePlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetResourceSharePlainArgs Empty = new GetResourceSharePlainArgs();

    /**
     * Filter used to scope the list e.g., by tags. See [related docs] (https://docs.aws.amazon.com/ram/latest/APIReference/API_TagFilter.html).
     * 
     */
    @Import(name="filters")
    private @Nullable List<GetResourceShareFilter> filters;

    /**
     * @return Filter used to scope the list e.g., by tags. See [related docs] (https://docs.aws.amazon.com/ram/latest/APIReference/API_TagFilter.html).
     * 
     */
    public Optional<List<GetResourceShareFilter>> filters() {
        return Optional.ofNullable(this.filters);
    }

    /**
     * Name of the resource share to retrieve.
     * 
     */
    @Import(name="name")
    private @Nullable String name;

    /**
     * @return Name of the resource share to retrieve.
     * 
     */
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Owner of the resource share. Valid values are `SELF` or `OTHER-ACCOUNTS`.
     * 
     */
    @Import(name="resourceOwner", required=true)
    private String resourceOwner;

    /**
     * @return Owner of the resource share. Valid values are `SELF` or `OTHER-ACCOUNTS`.
     * 
     */
    public String resourceOwner() {
        return this.resourceOwner;
    }

    /**
     * Specifies that you want to retrieve details of only those resource shares that have this status. Valid values are `PENDING`, `ACTIVE`, `FAILED`, `DELETING`, and `DELETED`.
     * 
     */
    @Import(name="resourceShareStatus")
    private @Nullable String resourceShareStatus;

    /**
     * @return Specifies that you want to retrieve details of only those resource shares that have this status. Valid values are `PENDING`, `ACTIVE`, `FAILED`, `DELETING`, and `DELETED`.
     * 
     */
    public Optional<String> resourceShareStatus() {
        return Optional.ofNullable(this.resourceShareStatus);
    }

    /**
     * Tags attached to the resource share.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Tags attached to the resource share.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetResourceSharePlainArgs() {}

    private GetResourceSharePlainArgs(GetResourceSharePlainArgs $) {
        this.filters = $.filters;
        this.name = $.name;
        this.resourceOwner = $.resourceOwner;
        this.resourceShareStatus = $.resourceShareStatus;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetResourceSharePlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetResourceSharePlainArgs $;

        public Builder() {
            $ = new GetResourceSharePlainArgs();
        }

        public Builder(GetResourceSharePlainArgs defaults) {
            $ = new GetResourceSharePlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters Filter used to scope the list e.g., by tags. See [related docs] (https://docs.aws.amazon.com/ram/latest/APIReference/API_TagFilter.html).
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable List<GetResourceShareFilter> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters Filter used to scope the list e.g., by tags. See [related docs] (https://docs.aws.amazon.com/ram/latest/APIReference/API_TagFilter.html).
         * 
         * @return builder
         * 
         */
        public Builder filters(GetResourceShareFilter... filters) {
            return filters(List.of(filters));
        }

        /**
         * @param name Name of the resource share to retrieve.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable String name) {
            $.name = name;
            return this;
        }

        /**
         * @param resourceOwner Owner of the resource share. Valid values are `SELF` or `OTHER-ACCOUNTS`.
         * 
         * @return builder
         * 
         */
        public Builder resourceOwner(String resourceOwner) {
            $.resourceOwner = resourceOwner;
            return this;
        }

        /**
         * @param resourceShareStatus Specifies that you want to retrieve details of only those resource shares that have this status. Valid values are `PENDING`, `ACTIVE`, `FAILED`, `DELETING`, and `DELETED`.
         * 
         * @return builder
         * 
         */
        public Builder resourceShareStatus(@Nullable String resourceShareStatus) {
            $.resourceShareStatus = resourceShareStatus;
            return this;
        }

        /**
         * @param tags Tags attached to the resource share.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetResourceSharePlainArgs build() {
            if ($.resourceOwner == null) {
                throw new MissingRequiredPropertyException("GetResourceSharePlainArgs", "resourceOwner");
            }
            return $;
        }
    }

}
