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
    public sealed class FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationProcessor
    {
        /// <summary>
        /// Specifies the processor parameters as multiple blocks. See `parameters` block below for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationProcessorParameter> Parameters;
        /// <summary>
        /// The type of processor. Valid Values: `RecordDeAggregation`, `Lambda`, `MetadataExtraction`, `AppendDelimiterToRecord`, `Decompression`, `CloudWatchLogProcessing`. Validation is done against [AWS SDK constants](https://pkg.go.dev/github.com/aws/aws-sdk-go-v2/service/firehose/types#ProcessorType); so values not explicitly listed may also work.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationProcessor(
            ImmutableArray<Outputs.FirehoseDeliveryStreamIcebergConfigurationProcessingConfigurationProcessorParameter> parameters,

            string type)
        {
            Parameters = parameters;
            Type = type;
        }
    }
}
