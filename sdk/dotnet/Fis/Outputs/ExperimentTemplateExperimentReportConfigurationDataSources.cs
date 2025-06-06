// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fis.Outputs
{

    [OutputType]
    public sealed class ExperimentTemplateExperimentReportConfigurationDataSources
    {
        /// <summary>
        /// The data sources for the experiment report. See below.
        /// </summary>
        public readonly ImmutableArray<Outputs.ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboard> CloudwatchDashboards;

        [OutputConstructor]
        private ExperimentTemplateExperimentReportConfigurationDataSources(ImmutableArray<Outputs.ExperimentTemplateExperimentReportConfigurationDataSourcesCloudwatchDashboard> cloudwatchDashboards)
        {
            CloudwatchDashboards = cloudwatchDashboards;
        }
    }
}
