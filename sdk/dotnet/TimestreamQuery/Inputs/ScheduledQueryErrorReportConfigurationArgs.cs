// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamQuery.Inputs
{

    public sealed class ScheduledQueryErrorReportConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for the S3 configuration for the error reports. See below.
        /// </summary>
        [Input("s3Configuration", required: true)]
        public Input<Inputs.ScheduledQueryErrorReportConfigurationS3ConfigurationArgs> S3Configuration { get; set; } = null!;

        public ScheduledQueryErrorReportConfigurationArgs()
        {
        }
        public static new ScheduledQueryErrorReportConfigurationArgs Empty => new ScheduledQueryErrorReportConfigurationArgs();
    }
}
