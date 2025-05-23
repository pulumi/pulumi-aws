// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fis.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboard {
    /**
     * @return The ARN of the CloudWatch dashboard.
     * 
     */
    private @Nullable String dashboardArn;

    private ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboard() {}
    /**
     * @return The ARN of the CloudWatch dashboard.
     * 
     */
    public Optional<String> dashboardArn() {
        return Optional.ofNullable(this.dashboardArn);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboard defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String dashboardArn;
        public Builder() {}
        public Builder(ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboard defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.dashboardArn = defaults.dashboardArn;
        }

        @CustomType.Setter
        public Builder dashboardArn(@Nullable String dashboardArn) {

            this.dashboardArn = dashboardArn;
            return this;
        }
        public ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboard build() {
            final var _resultValue = new ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboard();
            _resultValue.dashboardArn = dashboardArn;
            return _resultValue;
        }
    }
}
