// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class AnalyticsConfigurationStorageClassAnalysisDataExportGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the destination for the exported analytics data (documented below).
        /// </summary>
        [Input("destination", required: true)]
        public Input<Inputs.AnalyticsConfigurationStorageClassAnalysisDataExportDestinationGetArgs> Destination { get; set; } = null!;

        /// <summary>
        /// Schema version of exported analytics data. Allowed values: `V_1`. Default value: `V_1`.
        /// </summary>
        [Input("outputSchemaVersion")]
        public Input<string>? OutputSchemaVersion { get; set; }

        public AnalyticsConfigurationStorageClassAnalysisDataExportGetArgs()
        {
        }
        public static new AnalyticsConfigurationStorageClassAnalysisDataExportGetArgs Empty => new AnalyticsConfigurationStorageClassAnalysisDataExportGetArgs();
    }
}
