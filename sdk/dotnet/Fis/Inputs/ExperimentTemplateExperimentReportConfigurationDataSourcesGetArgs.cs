// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fis.Inputs
{

    public sealed class ExperimentTemplateExperimentReportConfigurationDataSourcesGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("cloudwatchDashboards")]
        private InputList<Inputs.ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardGetArgs>? _cloudwatchDashboards;

        /// <summary>
        /// The data sources for the experiment report. See below.
        /// </summary>
        public InputList<Inputs.ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardGetArgs> CloudwatchDashboards
        {
            get => _cloudwatchDashboards ?? (_cloudwatchDashboards = new InputList<Inputs.ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboardGetArgs>());
            set => _cloudwatchDashboards = value;
        }

        public ExperimentTemplateExperimentReportConfigurationDataSourcesGetArgs()
        {
        }
        public static new ExperimentTemplateExperimentReportConfigurationDataSourcesGetArgs Empty => new ExperimentTemplateExperimentReportConfigurationDataSourcesGetArgs();
    }
}
