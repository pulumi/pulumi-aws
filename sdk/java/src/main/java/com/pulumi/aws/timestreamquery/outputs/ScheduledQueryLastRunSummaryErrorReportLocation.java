// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.outputs;

import com.pulumi.aws.timestreamquery.outputs.ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocation;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class ScheduledQueryLastRunSummaryErrorReportLocation {
    /**
     * @return S3 location where error reports are written.
     * 
     */
    private @Nullable List<ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocation> s3ReportLocations;

    private ScheduledQueryLastRunSummaryErrorReportLocation() {}
    /**
     * @return S3 location where error reports are written.
     * 
     */
    public List<ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocation> s3ReportLocations() {
        return this.s3ReportLocations == null ? List.of() : this.s3ReportLocations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ScheduledQueryLastRunSummaryErrorReportLocation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocation> s3ReportLocations;
        public Builder() {}
        public Builder(ScheduledQueryLastRunSummaryErrorReportLocation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.s3ReportLocations = defaults.s3ReportLocations;
        }

        @CustomType.Setter
        public Builder s3ReportLocations(@Nullable List<ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocation> s3ReportLocations) {

            this.s3ReportLocations = s3ReportLocations;
            return this;
        }
        public Builder s3ReportLocations(ScheduledQueryLastRunSummaryErrorReportLocationS3ReportLocation... s3ReportLocations) {
            return s3ReportLocations(List.of(s3ReportLocations));
        }
        public ScheduledQueryLastRunSummaryErrorReportLocation build() {
            final var _resultValue = new ScheduledQueryLastRunSummaryErrorReportLocation();
            _resultValue.s3ReportLocations = s3ReportLocations;
            return _resultValue;
        }
    }
}
