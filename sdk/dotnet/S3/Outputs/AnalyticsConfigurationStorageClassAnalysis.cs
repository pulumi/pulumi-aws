// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Outputs
{

    [OutputType]
    public sealed class AnalyticsConfigurationStorageClassAnalysis
    {
        /// <summary>
        /// Data export configuration (documented below).
        /// </summary>
        public readonly Outputs.AnalyticsConfigurationStorageClassAnalysisDataExport DataExport;

        [OutputConstructor]
        private AnalyticsConfigurationStorageClassAnalysis(Outputs.AnalyticsConfigurationStorageClassAnalysisDataExport dataExport)
        {
            DataExport = dataExport;
        }
    }
}
