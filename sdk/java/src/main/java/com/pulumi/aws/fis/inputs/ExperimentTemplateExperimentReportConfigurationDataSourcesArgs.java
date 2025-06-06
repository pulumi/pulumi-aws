// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fis.inputs;

import com.pulumi.aws.fis.inputs.ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ExperimentTemplateExperimentReportConfigurationDataSourcesArgs extends com.pulumi.resources.ResourceArgs {

    public static final ExperimentTemplateExperimentReportConfigurationDataSourcesArgs Empty = new ExperimentTemplateExperimentReportConfigurationDataSourcesArgs();

    /**
     * The data sources for the experiment report. See below.
     * 
     */
    @Import(name="cloudwatchDashboards")
    private @Nullable Output<List<ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardArgs>> cloudwatchDashboards;

    /**
     * @return The data sources for the experiment report. See below.
     * 
     */
    public Optional<Output<List<ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardArgs>>> cloudwatchDashboards() {
        return Optional.ofNullable(this.cloudwatchDashboards);
    }

    private ExperimentTemplateExperimentReportConfigurationDataSourcesArgs() {}

    private ExperimentTemplateExperimentReportConfigurationDataSourcesArgs(ExperimentTemplateExperimentReportConfigurationDataSourcesArgs $) {
        this.cloudwatchDashboards = $.cloudwatchDashboards;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ExperimentTemplateExperimentReportConfigurationDataSourcesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ExperimentTemplateExperimentReportConfigurationDataSourcesArgs $;

        public Builder() {
            $ = new ExperimentTemplateExperimentReportConfigurationDataSourcesArgs();
        }

        public Builder(ExperimentTemplateExperimentReportConfigurationDataSourcesArgs defaults) {
            $ = new ExperimentTemplateExperimentReportConfigurationDataSourcesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cloudwatchDashboards The data sources for the experiment report. See below.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchDashboards(@Nullable Output<List<ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardArgs>> cloudwatchDashboards) {
            $.cloudwatchDashboards = cloudwatchDashboards;
            return this;
        }

        /**
         * @param cloudwatchDashboards The data sources for the experiment report. See below.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchDashboards(List<ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardArgs> cloudwatchDashboards) {
            return cloudwatchDashboards(Output.of(cloudwatchDashboards));
        }

        /**
         * @param cloudwatchDashboards The data sources for the experiment report. See below.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchDashboards(ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardArgs... cloudwatchDashboards) {
            return cloudwatchDashboards(List.of(cloudwatchDashboards));
        }

        public ExperimentTemplateExperimentReportConfigurationDataSourcesArgs build() {
            return $;
        }
    }

}
