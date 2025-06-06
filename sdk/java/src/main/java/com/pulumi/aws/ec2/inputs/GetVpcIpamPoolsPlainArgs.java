// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.GetVpcIpamPoolsFilter;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetVpcIpamPoolsPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetVpcIpamPoolsPlainArgs Empty = new GetVpcIpamPoolsPlainArgs();

    /**
     * Custom filter block as described below.
     * 
     * The arguments of this data source act as filters for querying the available IPAM Pools in the current region.
     * 
     */
    @Import(name="filters")
    private @Nullable List<GetVpcIpamPoolsFilter> filters;

    /**
     * @return Custom filter block as described below.
     * 
     * The arguments of this data source act as filters for querying the available IPAM Pools in the current region.
     * 
     */
    public Optional<List<GetVpcIpamPoolsFilter>> filters() {
        return Optional.ofNullable(this.filters);
    }

    private GetVpcIpamPoolsPlainArgs() {}

    private GetVpcIpamPoolsPlainArgs(GetVpcIpamPoolsPlainArgs $) {
        this.filters = $.filters;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetVpcIpamPoolsPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetVpcIpamPoolsPlainArgs $;

        public Builder() {
            $ = new GetVpcIpamPoolsPlainArgs();
        }

        public Builder(GetVpcIpamPoolsPlainArgs defaults) {
            $ = new GetVpcIpamPoolsPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available IPAM Pools in the current region.
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable List<GetVpcIpamPoolsFilter> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available IPAM Pools in the current region.
         * 
         * @return builder
         * 
         */
        public Builder filters(GetVpcIpamPoolsFilter... filters) {
            return filters(List.of(filters));
        }

        public GetVpcIpamPoolsPlainArgs build() {
            return $;
        }
    }

}
