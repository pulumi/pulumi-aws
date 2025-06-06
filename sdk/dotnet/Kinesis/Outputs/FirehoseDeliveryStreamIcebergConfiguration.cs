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
    public sealed class FirehoseDeliveryStreamIcebergConfiguration
    {
        /// <summary>
        /// Buffer incoming data for the specified period of time, in seconds between 0 and 900, before delivering it to the destination. The default value is 300.
        /// </summary>
        public readonly int? BufferingInterval;
        /// <summary>
        /// Buffer incoming data to the specified size, in MBs between 1 and 128, before delivering it to the destination. The default value is 5.
        /// </summary>
        public readonly int? BufferingSize;
        /// <summary>
        /// Glue catalog ARN identifier of the destination Apache Iceberg Tables. You must specify the ARN in the format `arn:aws:glue:region:account-id:catalog`
        /// </summary>
        public readonly string CatalogArn;
        /// <summary>
        /// The CloudWatch Logging Options for the delivery stream. See `cloudwatch_logging_options` block below for details.
        /// </summary>
        public readonly Outputs.FirehoseDeliveryStreamIcebergConfigurationCloudwatchLoggingOptions? CloudwatchLoggingOptions;
        /// <summary>
        /// Destination table configurations which Firehose uses to deliver data to Apache Iceberg Tables. Firehose will write data with insert if table specific configuration is not provided. See `destination_table_configuration` block below for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.FirehoseDeliveryStreamIcebergConfigurationDestinationTableConfiguration> DestinationTableConfigurations;
        /// <summary>
        /// The data processing configuration.  See `processing_configuration` block below for details.
        /// </summary>
        public readonly Outputs.FirehoseDeliveryStreamIcebergConfigurationProcessingConfiguration? ProcessingConfiguration;
        /// <summary>
        /// The period of time, in seconds between 0 to 7200, during which Firehose retries to deliver data to the specified destination.
        /// </summary>
        public readonly int? RetryDuration;
        /// <summary>
        /// The ARN of the IAM role to be assumed by Firehose for calling Apache Iceberg Tables.
        /// </summary>
        public readonly string RoleArn;
        public readonly string? S3BackupMode;
        /// <summary>
        /// The S3 Configuration. See `s3_configuration` block below for details.
        /// </summary>
        public readonly Outputs.FirehoseDeliveryStreamIcebergConfigurationS3Configuration S3Configuration;

        [OutputConstructor]
        private FirehoseDeliveryStreamIcebergConfiguration(
            int? bufferingInterval,

            int? bufferingSize,

            string catalogArn,

            Outputs.FirehoseDeliveryStreamIcebergConfigurationCloudwatchLoggingOptions? cloudwatchLoggingOptions,

            ImmutableArray<Outputs.FirehoseDeliveryStreamIcebergConfigurationDestinationTableConfiguration> destinationTableConfigurations,

            Outputs.FirehoseDeliveryStreamIcebergConfigurationProcessingConfiguration? processingConfiguration,

            int? retryDuration,

            string roleArn,

            string? s3BackupMode,

            Outputs.FirehoseDeliveryStreamIcebergConfigurationS3Configuration s3Configuration)
        {
            BufferingInterval = bufferingInterval;
            BufferingSize = bufferingSize;
            CatalogArn = catalogArn;
            CloudwatchLoggingOptions = cloudwatchLoggingOptions;
            DestinationTableConfigurations = destinationTableConfigurations;
            ProcessingConfiguration = processingConfiguration;
            RetryDuration = retryDuration;
            RoleArn = roleArn;
            S3BackupMode = s3BackupMode;
            S3Configuration = s3Configuration;
        }
    }
}
