// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class AnalyticsConfigurationStorageClassAnalysisDataExportDestinationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Analytics data export currently only supports an S3 bucket destination (documented below).
        /// </summary>
        [Input("s3BucketDestination", required: true)]
        public Input<Inputs.AnalyticsConfigurationStorageClassAnalysisDataExportDestinationS3BucketDestinationArgs> S3BucketDestination { get; set; } = null!;

        public AnalyticsConfigurationStorageClassAnalysisDataExportDestinationArgs()
        {
        }
        public static new AnalyticsConfigurationStorageClassAnalysisDataExportDestinationArgs Empty => new AnalyticsConfigurationStorageClassAnalysisDataExportDestinationArgs();
    }
}
