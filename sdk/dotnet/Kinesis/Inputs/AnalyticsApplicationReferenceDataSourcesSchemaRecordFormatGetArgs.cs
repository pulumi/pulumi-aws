// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Inputs
{

    public sealed class AnalyticsApplicationReferenceDataSourcesSchemaRecordFormatGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Mapping Information for the record format.
        /// See Mapping Parameters below for more details.
        /// </summary>
        [Input("mappingParameters")]
        public Input<Inputs.AnalyticsApplicationReferenceDataSourcesSchemaRecordFormatMappingParametersGetArgs>? MappingParameters { get; set; }

        /// <summary>
        /// The type of Record Format. Can be `CSV` or `JSON`.
        /// </summary>
        [Input("recordFormatType")]
        public Input<string>? RecordFormatType { get; set; }

        public AnalyticsApplicationReferenceDataSourcesSchemaRecordFormatGetArgs()
        {
        }
        public static new AnalyticsApplicationReferenceDataSourcesSchemaRecordFormatGetArgs Empty => new AnalyticsApplicationReferenceDataSourcesSchemaRecordFormatGetArgs();
    }
}
