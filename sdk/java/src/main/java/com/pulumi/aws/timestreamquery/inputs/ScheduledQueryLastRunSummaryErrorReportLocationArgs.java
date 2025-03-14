// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.inputs;

import com.pulumi.aws.timestreamquery.inputs.ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ScheduledQueryLastRunSummaryErrorReportLocationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ScheduledQueryLastRunSummaryErrorReportLocationArgs Empty = new ScheduledQueryLastRunSummaryErrorReportLocationArgs();

    /**
     * S3 location where error reports are written.
     * 
     */
    @Import(name="s3ReportLocations")
    private @Nullable Output<List<ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocationArgs>> s3ReportLocations;

    /**
     * @return S3 location where error reports are written.
     * 
     */
    public Optional<Output<List<ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocationArgs>>> s3ReportLocations() {
        return Optional.ofNullable(this.s3ReportLocations);
    }

    private ScheduledQueryLastRunSummaryErrorReportLocationArgs() {}

    private ScheduledQueryLastRunSummaryErrorReportLocationArgs(ScheduledQueryLastRunSummaryErrorReportLocationArgs $) {
        this.s3ReportLocations = $.s3ReportLocations;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ScheduledQueryLastRunSummaryErrorReportLocationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ScheduledQueryLastRunSummaryErrorReportLocationArgs $;

        public Builder() {
            $ = new ScheduledQueryLastRunSummaryErrorReportLocationArgs();
        }

        public Builder(ScheduledQueryLastRunSummaryErrorReportLocationArgs defaults) {
            $ = new ScheduledQueryLastRunSummaryErrorReportLocationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param s3ReportLocations S3 location where error reports are written.
         * 
         * @return builder
         * 
         */
        public Builder s3ReportLocations(@Nullable Output<List<ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocationArgs>> s3ReportLocations) {
            $.s3ReportLocations = s3ReportLocations;
            return this;
        }

        /**
         * @param s3ReportLocations S3 location where error reports are written.
         * 
         * @return builder
         * 
         */
        public Builder s3ReportLocations(List<ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocationArgs> s3ReportLocations) {
            return s3ReportLocations(Output.of(s3ReportLocations));
        }

        /**
         * @param s3ReportLocations S3 location where error reports are written.
         * 
         * @return builder
         * 
         */
        public Builder s3ReportLocations(ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocationArgs... s3ReportLocations) {
            return s3ReportLocations(List.of(s3ReportLocations));
        }

        public ScheduledQueryLastRunSummaryErrorReportLocationArgs build() {
            return $;
        }
    }

}
