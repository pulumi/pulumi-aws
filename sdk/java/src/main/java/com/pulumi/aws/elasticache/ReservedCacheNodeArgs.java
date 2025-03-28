// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.elasticache;

import com.pulumi.aws.elasticache.inputs.ReservedCacheNodeTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ReservedCacheNodeArgs extends com.pulumi.resources.ResourceArgs {

    public static final ReservedCacheNodeArgs Empty = new ReservedCacheNodeArgs();

    /**
     * Number of cache node instances to reserve.
     * Default value is `1`.
     * 
     */
    @Import(name="cacheNodeCount")
    private @Nullable Output<Integer> cacheNodeCount;

    /**
     * @return Number of cache node instances to reserve.
     * Default value is `1`.
     * 
     */
    public Optional<Output<Integer>> cacheNodeCount() {
        return Optional.ofNullable(this.cacheNodeCount);
    }

    /**
     * ID of the reserved cache node offering to purchase.
     * To determine an `reserved_cache_nodes_offering_id`, see the `aws.elasticache.getReservedCacheNodeOffering` data source.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="reservedCacheNodesOfferingId", required=true)
    private Output<String> reservedCacheNodesOfferingId;

    /**
     * @return ID of the reserved cache node offering to purchase.
     * To determine an `reserved_cache_nodes_offering_id`, see the `aws.elasticache.getReservedCacheNodeOffering` data source.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> reservedCacheNodesOfferingId() {
        return this.reservedCacheNodesOfferingId;
    }

    /**
     * Map of tags to assign to the reservation. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the reservation. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    @Import(name="timeouts")
    private @Nullable Output<ReservedCacheNodeTimeoutsArgs> timeouts;

    public Optional<Output<ReservedCacheNodeTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private ReservedCacheNodeArgs() {}

    private ReservedCacheNodeArgs(ReservedCacheNodeArgs $) {
        this.cacheNodeCount = $.cacheNodeCount;
        this.reservedCacheNodesOfferingId = $.reservedCacheNodesOfferingId;
        this.tags = $.tags;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ReservedCacheNodeArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ReservedCacheNodeArgs $;

        public Builder() {
            $ = new ReservedCacheNodeArgs();
        }

        public Builder(ReservedCacheNodeArgs defaults) {
            $ = new ReservedCacheNodeArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cacheNodeCount Number of cache node instances to reserve.
         * Default value is `1`.
         * 
         * @return builder
         * 
         */
        public Builder cacheNodeCount(@Nullable Output<Integer> cacheNodeCount) {
            $.cacheNodeCount = cacheNodeCount;
            return this;
        }

        /**
         * @param cacheNodeCount Number of cache node instances to reserve.
         * Default value is `1`.
         * 
         * @return builder
         * 
         */
        public Builder cacheNodeCount(Integer cacheNodeCount) {
            return cacheNodeCount(Output.of(cacheNodeCount));
        }

        /**
         * @param reservedCacheNodesOfferingId ID of the reserved cache node offering to purchase.
         * To determine an `reserved_cache_nodes_offering_id`, see the `aws.elasticache.getReservedCacheNodeOffering` data source.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder reservedCacheNodesOfferingId(Output<String> reservedCacheNodesOfferingId) {
            $.reservedCacheNodesOfferingId = reservedCacheNodesOfferingId;
            return this;
        }

        /**
         * @param reservedCacheNodesOfferingId ID of the reserved cache node offering to purchase.
         * To determine an `reserved_cache_nodes_offering_id`, see the `aws.elasticache.getReservedCacheNodeOffering` data source.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder reservedCacheNodesOfferingId(String reservedCacheNodesOfferingId) {
            return reservedCacheNodesOfferingId(Output.of(reservedCacheNodesOfferingId));
        }

        /**
         * @param tags Map of tags to assign to the reservation. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the reservation. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public Builder timeouts(@Nullable Output<ReservedCacheNodeTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(ReservedCacheNodeTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public ReservedCacheNodeArgs build() {
            if ($.reservedCacheNodesOfferingId == null) {
                throw new MissingRequiredPropertyException("ReservedCacheNodeArgs", "reservedCacheNodesOfferingId");
            }
            return $;
        }
    }

}
