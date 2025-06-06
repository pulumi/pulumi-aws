// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fis.Inputs
{

    public sealed class ExperimentTemplateExperimentReportConfigurationOutputsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The data sources for the experiment report. See below.
        /// </summary>
        [Input("s3Configuration")]
        public Input<Inputs.ExperimentTemplateExperimentReportConfigurationOutputsS3ConfigurationArgs>? S3Configuration { get; set; }

        public ExperimentTemplateExperimentReportConfigurationOutputsArgs()
        {
        }
        public static new ExperimentTemplateExperimentReportConfigurationOutputsArgs Empty => new ExperimentTemplateExperimentReportConfigurationOutputsArgs();
    }
}
