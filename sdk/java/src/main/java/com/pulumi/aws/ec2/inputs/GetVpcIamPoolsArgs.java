// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.GetVpcIamPoolsFilterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetVpcIamPoolsArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetVpcIamPoolsArgs Empty = new GetVpcIamPoolsArgs();

    /**
     * Custom filter block as described below.
     * 
     * The arguments of this data source act as filters for querying the available IPAM Pools in the current region.
     * 
     */
    @Import(name="filters")
    private @Nullable Output<List<GetVpcIamPoolsFilterArgs>> filters;

    /**
     * @return Custom filter block as described below.
     * 
     * The arguments of this data source act as filters for querying the available IPAM Pools in the current region.
     * 
     */
    public Optional<Output<List<GetVpcIamPoolsFilterArgs>>> filters() {
        return Optional.ofNullable(this.filters);
    }

    private GetVpcIamPoolsArgs() {}

    private GetVpcIamPoolsArgs(GetVpcIamPoolsArgs $) {
        this.filters = $.filters;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetVpcIamPoolsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetVpcIamPoolsArgs $;

        public Builder() {
            $ = new GetVpcIamPoolsArgs();
        }

        public Builder(GetVpcIamPoolsArgs defaults) {
            $ = new GetVpcIamPoolsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available IPAM Pools in the current region.
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable Output<List<GetVpcIamPoolsFilterArgs>> filters) {
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
        public Builder filters(List<GetVpcIamPoolsFilterArgs> filters) {
            return filters(Output.of(filters));
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available IPAM Pools in the current region.
         * 
         * @return builder
         * 
         */
        public Builder filters(GetVpcIamPoolsFilterArgs... filters) {
            return filters(List.of(filters));
        }

        public GetVpcIamPoolsArgs build() {
            return $;
        }
    }

}
