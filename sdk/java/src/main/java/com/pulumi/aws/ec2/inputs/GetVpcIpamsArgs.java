// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.GetVpcIpamsFilterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetVpcIpamsArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetVpcIpamsArgs Empty = new GetVpcIpamsArgs();

    /**
     * Custom filter block as described below.
     * 
     * The arguments of this data source act as filters for querying the available IPAMs.
     * 
     */
    @Import(name="filters")
    private @Nullable Output<List<GetVpcIpamsFilterArgs>> filters;

    /**
     * @return Custom filter block as described below.
     * 
     * The arguments of this data source act as filters for querying the available IPAMs.
     * 
     */
    public Optional<Output<List<GetVpcIpamsFilterArgs>>> filters() {
        return Optional.ofNullable(this.filters);
    }

    /**
     * IDs of the IPAM resources to query for.
     * 
     */
    @Import(name="ipamIds")
    private @Nullable Output<List<String>> ipamIds;

    /**
     * @return IDs of the IPAM resources to query for.
     * 
     */
    public Optional<Output<List<String>>> ipamIds() {
        return Optional.ofNullable(this.ipamIds);
    }

    private GetVpcIpamsArgs() {}

    private GetVpcIpamsArgs(GetVpcIpamsArgs $) {
        this.filters = $.filters;
        this.ipamIds = $.ipamIds;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetVpcIpamsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetVpcIpamsArgs $;

        public Builder() {
            $ = new GetVpcIpamsArgs();
        }

        public Builder(GetVpcIpamsArgs defaults) {
            $ = new GetVpcIpamsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available IPAMs.
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable Output<List<GetVpcIpamsFilterArgs>> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available IPAMs.
         * 
         * @return builder
         * 
         */
        public Builder filters(List<GetVpcIpamsFilterArgs> filters) {
            return filters(Output.of(filters));
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available IPAMs.
         * 
         * @return builder
         * 
         */
        public Builder filters(GetVpcIpamsFilterArgs... filters) {
            return filters(List.of(filters));
        }

        /**
         * @param ipamIds IDs of the IPAM resources to query for.
         * 
         * @return builder
         * 
         */
        public Builder ipamIds(@Nullable Output<List<String>> ipamIds) {
            $.ipamIds = ipamIds;
            return this;
        }

        /**
         * @param ipamIds IDs of the IPAM resources to query for.
         * 
         * @return builder
         * 
         */
        public Builder ipamIds(List<String> ipamIds) {
            return ipamIds(Output.of(ipamIds));
        }

        /**
         * @param ipamIds IDs of the IPAM resources to query for.
         * 
         * @return builder
         * 
         */
        public Builder ipamIds(String... ipamIds) {
            return ipamIds(List.of(ipamIds));
        }

        public GetVpcIpamsArgs build() {
            return $;
        }
    }

}
