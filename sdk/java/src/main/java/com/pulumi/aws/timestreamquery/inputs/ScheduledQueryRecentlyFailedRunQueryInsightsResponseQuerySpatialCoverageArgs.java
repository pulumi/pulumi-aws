// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.inputs;

import com.pulumi.aws.timestreamquery.inputs.ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageMaxisArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs extends com.pulumi.resources.ResourceArgs {

    public static final ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs Empty = new ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs();

    /**
     * Insights into the most sub-optimal performing table on the temporal axis:
     * 
     */
    @Import(name="maxes")
    private @Nullable Output<List<ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageMaxisArgs>> maxes;

    /**
     * @return Insights into the most sub-optimal performing table on the temporal axis:
     * 
     */
    public Optional<Output<List<ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageMaxisArgs>>> maxes() {
        return Optional.ofNullable(this.maxes);
    }

    private ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs() {}

    private ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs(ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs $) {
        this.maxes = $.maxes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs $;

        public Builder() {
            $ = new ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs();
        }

        public Builder(ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs defaults) {
            $ = new ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param maxes Insights into the most sub-optimal performing table on the temporal axis:
         * 
         * @return builder
         * 
         */
        public Builder maxes(@Nullable Output<List<ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageMaxisArgs>> maxes) {
            $.maxes = maxes;
            return this;
        }

        /**
         * @param maxes Insights into the most sub-optimal performing table on the temporal axis:
         * 
         * @return builder
         * 
         */
        public Builder maxes(List<ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageMaxisArgs> maxes) {
            return maxes(Output.of(maxes));
        }

        /**
         * @param maxes Insights into the most sub-optimal performing table on the temporal axis:
         * 
         * @return builder
         * 
         */
        public Builder maxes(ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageMaxisArgs... maxes) {
            return maxes(List.of(maxes));
        }

        public ScheduledQueryRecentlyFailedRunQueryInsightsResponseQuerySpatialCoverageArgs build() {
            return $;
        }
    }

}
