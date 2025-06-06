// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Inputs
{

    public sealed class AnalyticsApplicationInputsSchemaRecordFormatMappingParametersGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Mapping information when the record format uses delimiters.
        /// See CSV Mapping Parameters below for more details.
        /// </summary>
        [Input("csv")]
        public Input<Inputs.AnalyticsApplicationInputsSchemaRecordFormatMappingParametersCsvGetArgs>? Csv { get; set; }

        /// <summary>
        /// Mapping information when JSON is the record format on the streaming source.
        /// See JSON Mapping Parameters below for more details.
        /// </summary>
        [Input("json")]
        public Input<Inputs.AnalyticsApplicationInputsSchemaRecordFormatMappingParametersJsonGetArgs>? Json { get; set; }

        public AnalyticsApplicationInputsSchemaRecordFormatMappingParametersGetArgs()
        {
        }
        public static new AnalyticsApplicationInputsSchemaRecordFormatMappingParametersGetArgs Empty => new AnalyticsApplicationInputsSchemaRecordFormatMappingParametersGetArgs();
    }
}
