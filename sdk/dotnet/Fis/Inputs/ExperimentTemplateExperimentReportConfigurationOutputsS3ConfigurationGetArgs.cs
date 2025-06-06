// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fis.Inputs
{

    public sealed class ExperimentTemplateExperimentReportConfigurationOutputsS3ConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the destination bucket.
        /// </summary>
        [Input("bucketName", required: true)]
        public Input<string> BucketName { get; set; } = null!;

        /// <summary>
        /// The bucket prefix.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        public ExperimentTemplateExperimentReportConfigurationOutputsS3ConfigurationGetArgs()
        {
        }
        public static new ExperimentTemplateExperimentReportConfigurationOutputsS3ConfigurationGetArgs Empty => new ExperimentTemplateExperimentReportConfigurationOutputsS3ConfigurationGetArgs();
    }
}
