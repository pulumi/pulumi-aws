// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Outputs
{

    [OutputType]
    public sealed class ApplicationApplicationConfigurationSqlApplicationConfigurationInputInputSchemaRecordFormatMappingParametersCsvMappingParameters
    {
        /// <summary>
        /// The column delimiter. For example, in a CSV format, a comma (`,`) is the typical column delimiter.
        /// </summary>
        public readonly string RecordColumnDelimiter;
        /// <summary>
        /// The row delimiter. For example, in a CSV format, `\n` is the typical row delimiter.
        /// </summary>
        public readonly string RecordRowDelimiter;

        [OutputConstructor]
        private ApplicationApplicationConfigurationSqlApplicationConfigurationInputInputSchemaRecordFormatMappingParametersCsvMappingParameters(
            string recordColumnDelimiter,

            string recordRowDelimiter)
        {
            RecordColumnDelimiter = recordColumnDelimiter;
            RecordRowDelimiter = recordRowDelimiter;
        }
    }
}
