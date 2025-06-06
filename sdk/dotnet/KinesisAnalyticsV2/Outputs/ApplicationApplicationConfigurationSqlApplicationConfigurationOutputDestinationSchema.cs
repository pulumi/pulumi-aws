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
    public sealed class ApplicationApplicationConfigurationSqlApplicationConfigurationOutputDestinationSchema
    {
        /// <summary>
        /// Specifies the format of the records on the output stream. Valid values: `CSV`, `JSON`.
        /// </summary>
        public readonly string RecordFormatType;

        [OutputConstructor]
        private ApplicationApplicationConfigurationSqlApplicationConfigurationOutputDestinationSchema(string recordFormatType)
        {
            RecordFormatType = recordFormatType;
        }
    }
}
