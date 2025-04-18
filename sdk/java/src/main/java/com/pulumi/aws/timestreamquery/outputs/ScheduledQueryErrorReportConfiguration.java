// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.outputs;

import com.pulumi.aws.timestreamquery.outputs.ScheduledQueryErrorReportConfigurationS3Configuration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.Objects;

@CustomType
public final class ScheduledQueryErrorReportConfiguration {
    /**
     * @return Configuration block for the S3 configuration for the error reports. See below.
     * 
     */
    private ScheduledQueryErrorReportConfigurationS3Configuration s3Configuration;

    private ScheduledQueryErrorReportConfiguration() {}
    /**
     * @return Configuration block for the S3 configuration for the error reports. See below.
     * 
     */
    public ScheduledQueryErrorReportConfigurationS3Configuration s3Configuration() {
        return this.s3Configuration;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ScheduledQueryErrorReportConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private ScheduledQueryErrorReportConfigurationS3Configuration s3Configuration;
        public Builder() {}
        public Builder(ScheduledQueryErrorReportConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.s3Configuration = defaults.s3Configuration;
        }

        @CustomType.Setter
        public Builder s3Configuration(ScheduledQueryErrorReportConfigurationS3Configuration s3Configuration) {
            if (s3Configuration == null) {
              throw new MissingRequiredPropertyException("ScheduledQueryErrorReportConfiguration", "s3Configuration");
            }
            this.s3Configuration = s3Configuration;
            return this;
        }
        public ScheduledQueryErrorReportConfiguration build() {
            final var _resultValue = new ScheduledQueryErrorReportConfiguration();
            _resultValue.s3Configuration = s3Configuration;
            return _resultValue;
        }
    }
}
