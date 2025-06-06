// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Outputs
{

    [OutputType]
    public sealed class FirehoseDeliveryStreamExtendedS3ConfigurationDataFormatConversionConfigurationInputFormatConfigurationDeserializer
    {
        /// <summary>
        /// Specifies the native Hive / HCatalog JsonSerDe. More details below. See `hive_json_ser_de` block below for details.
        /// </summary>
        public readonly Outputs.FirehoseDeliveryStreamExtendedS3ConfigurationDataFormatConversionConfigurationInputFormatConfigurationDeserializerHiveJsonSerDe? HiveJsonSerDe;
        /// <summary>
        /// Specifies the OpenX SerDe. See `open_x_json_ser_de` block below for details.
        /// </summary>
        public readonly Outputs.FirehoseDeliveryStreamExtendedS3ConfigurationDataFormatConversionConfigurationInputFormatConfigurationDeserializerOpenXJsonSerDe? OpenXJsonSerDe;

        [OutputConstructor]
        private FirehoseDeliveryStreamExtendedS3ConfigurationDataFormatConversionConfigurationInputFormatConfigurationDeserializer(
            Outputs.FirehoseDeliveryStreamExtendedS3ConfigurationDataFormatConversionConfigurationInputFormatConfigurationDeserializerHiveJsonSerDe? hiveJsonSerDe,

            Outputs.FirehoseDeliveryStreamExtendedS3ConfigurationDataFormatConversionConfigurationInputFormatConfigurationDeserializerOpenXJsonSerDe? openXJsonSerDe)
        {
            HiveJsonSerDe = hiveJsonSerDe;
            OpenXJsonSerDe = openXJsonSerDe;
        }
    }
}
