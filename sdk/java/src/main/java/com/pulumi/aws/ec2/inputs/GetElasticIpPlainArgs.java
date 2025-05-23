// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.GetElasticIpFilter;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetElasticIpPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetElasticIpPlainArgs Empty = new GetElasticIpPlainArgs();

    /**
     * One or more name/value pairs to use as filters. There are several valid keys, for a full reference, check out the [EC2 API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAddresses.html).
     * 
     */
    @Import(name="filters")
    private @Nullable List<GetElasticIpFilter> filters;

    /**
     * @return One or more name/value pairs to use as filters. There are several valid keys, for a full reference, check out the [EC2 API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAddresses.html).
     * 
     */
    public Optional<List<GetElasticIpFilter>> filters() {
        return Optional.ofNullable(this.filters);
    }

    /**
     * Allocation ID of the specific VPC EIP to retrieve. If a classic EIP is required, do NOT set `id`, only set `public_ip`
     * 
     */
    @Import(name="id")
    private @Nullable String id;

    /**
     * @return Allocation ID of the specific VPC EIP to retrieve. If a classic EIP is required, do NOT set `id`, only set `public_ip`
     * 
     */
    public Optional<String> id() {
        return Optional.ofNullable(this.id);
    }

    /**
     * Public IP of the specific EIP to retrieve.
     * 
     */
    @Import(name="publicIp")
    private @Nullable String publicIp;

    /**
     * @return Public IP of the specific EIP to retrieve.
     * 
     */
    public Optional<String> publicIp() {
        return Optional.ofNullable(this.publicIp);
    }

    /**
     * Map of tags, each pair of which must exactly match a pair on the desired Elastic IP.
     * 
     * The arguments of this data source act as filters for querying the available
     * Elastic IPs in the current region. The given filters must match exactly one
     * Elastic IP whose data will be exported as attributes.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Map of tags, each pair of which must exactly match a pair on the desired Elastic IP.
     * 
     * The arguments of this data source act as filters for querying the available
     * Elastic IPs in the current region. The given filters must match exactly one
     * Elastic IP whose data will be exported as attributes.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetElasticIpPlainArgs() {}

    private GetElasticIpPlainArgs(GetElasticIpPlainArgs $) {
        this.filters = $.filters;
        this.id = $.id;
        this.publicIp = $.publicIp;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetElasticIpPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetElasticIpPlainArgs $;

        public Builder() {
            $ = new GetElasticIpPlainArgs();
        }

        public Builder(GetElasticIpPlainArgs defaults) {
            $ = new GetElasticIpPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters One or more name/value pairs to use as filters. There are several valid keys, for a full reference, check out the [EC2 API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAddresses.html).
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable List<GetElasticIpFilter> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters One or more name/value pairs to use as filters. There are several valid keys, for a full reference, check out the [EC2 API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAddresses.html).
         * 
         * @return builder
         * 
         */
        public Builder filters(GetElasticIpFilter... filters) {
            return filters(List.of(filters));
        }

        /**
         * @param id Allocation ID of the specific VPC EIP to retrieve. If a classic EIP is required, do NOT set `id`, only set `public_ip`
         * 
         * @return builder
         * 
         */
        public Builder id(@Nullable String id) {
            $.id = id;
            return this;
        }

        /**
         * @param publicIp Public IP of the specific EIP to retrieve.
         * 
         * @return builder
         * 
         */
        public Builder publicIp(@Nullable String publicIp) {
            $.publicIp = publicIp;
            return this;
        }

        /**
         * @param tags Map of tags, each pair of which must exactly match a pair on the desired Elastic IP.
         * 
         * The arguments of this data source act as filters for querying the available
         * Elastic IPs in the current region. The given filters must match exactly one
         * Elastic IP whose data will be exported as attributes.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetElasticIpPlainArgs build() {
            return $;
        }
    }

}
