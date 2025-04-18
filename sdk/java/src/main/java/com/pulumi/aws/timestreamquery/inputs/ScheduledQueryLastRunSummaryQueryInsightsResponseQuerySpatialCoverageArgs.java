// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.inputs;

import com.pulumi.aws.timestreamquery.inputs.ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageMaxisArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs extends com.pulumi.resources.ResourceArgs {

    public static final ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs Empty = new ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs();

    /**
     * Insights into the most sub-optimal performing table on the temporal axis:
     * 
     */
    @Import(name="maxes")
    private @Nullable Output<List<ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageMaxisArgs>> maxes;

    /**
     * @return Insights into the most sub-optimal performing table on the temporal axis:
     * 
     */
    public Optional<Output<List<ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageMaxisArgs>>> maxes() {
        return Optional.ofNullable(this.maxes);
    }

    private ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs() {}

    private ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs(ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs $) {
        this.maxes = $.maxes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs $;

        public Builder() {
            $ = new ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs();
        }

        public Builder(ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs defaults) {
            $ = new ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param maxes Insights into the most sub-optimal performing table on the temporal axis:
         * 
         * @return builder
         * 
         */
        public Builder maxes(@Nullable Output<List<ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageMaxisArgs>> maxes) {
            $.maxes = maxes;
            return this;
        }

        /**
         * @param maxes Insights into the most sub-optimal performing table on the temporal axis:
         * 
         * @return builder
         * 
         */
        public Builder maxes(List<ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageMaxisArgs> maxes) {
            return maxes(Output.of(maxes));
        }

        /**
         * @param maxes Insights into the most sub-optimal performing table on the temporal axis:
         * 
         * @return builder
         * 
         */
        public Builder maxes(ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageMaxisArgs... maxes) {
            return maxes(List.of(maxes));
        }

        public ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageArgs build() {
            return $;
        }
    }

}
