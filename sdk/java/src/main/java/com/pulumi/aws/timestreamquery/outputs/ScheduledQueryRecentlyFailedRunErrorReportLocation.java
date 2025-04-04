// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.outputs;

import com.pulumi.aws.timestreamquery.outputs.ScheduledQueryRecentlyFailedRunErrorReportLocationS3ReportLocation;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class ScheduledQueryRecentlyFailedRunErrorReportLocation {
    /**
     * @return S3 location where error reports are written.
     * 
     */
    private @Nullable List<ScheduledQueryRecentlyFailedRunErrorReportLocationS3ReportLocation> s3ReportLocations;

    private ScheduledQueryRecentlyFailedRunErrorReportLocation() {}
    /**
     * @return S3 location where error reports are written.
     * 
     */
    public List<ScheduledQueryRecentlyFailedRunErrorReportLocationS3ReportLocation> s3ReportLocations() {
        return this.s3ReportLocations == null ? List.of() : this.s3ReportLocations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ScheduledQueryRecentlyFailedRunErrorReportLocation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<ScheduledQueryRecentlyFailedRunErrorReportLocationS3ReportLocation> s3ReportLocations;
        public Builder() {}
        public Builder(ScheduledQueryRecentlyFailedRunErrorReportLocation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.s3ReportLocations = defaults.s3ReportLocations;
        }

        @CustomType.Setter
        public Builder s3ReportLocations(@Nullable List<ScheduledQueryRecentlyFailedRunErrorReportLocationS3ReportLocation> s3ReportLocations) {

            this.s3ReportLocations = s3ReportLocations;
            return this;
        }
        public Builder s3ReportLocations(ScheduledQueryRecentlyFailedRunErrorReportLocationS3ReportLocation... s3ReportLocations) {
            return s3ReportLocations(List.of(s3ReportLocations));
        }
        public ScheduledQueryRecentlyFailedRunErrorReportLocation build() {
            final var _resultValue = new ScheduledQueryRecentlyFailedRunErrorReportLocation();
            _resultValue.s3ReportLocations = s3ReportLocations;
            return _resultValue;
        }
    }
}
