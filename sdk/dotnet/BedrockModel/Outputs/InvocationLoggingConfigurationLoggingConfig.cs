// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.BedrockModel.Outputs
{

    [OutputType]
    public sealed class InvocationLoggingConfigurationLoggingConfig
    {
        /// <summary>
        /// CloudWatch logging configuration. See `cloudwatch_config` Block for details.
        /// </summary>
        public readonly Outputs.InvocationLoggingConfigurationLoggingConfigCloudwatchConfig? CloudwatchConfig;
        /// <summary>
        /// Set to include embeddings data in the log delivery. Defaults to `true`.
        /// </summary>
        public readonly bool? EmbeddingDataDeliveryEnabled;
        /// <summary>
        /// Set to include image data in the log delivery. Defaults to `true`.
        /// </summary>
        public readonly bool? ImageDataDeliveryEnabled;
        /// <summary>
        /// S3 configuration for storing log data. See `s3_config` Block for details.
        /// </summary>
        public readonly Outputs.InvocationLoggingConfigurationLoggingConfigS3Config? S3Config;
        /// <summary>
        /// Set to include text data in the log delivery. Defaults to `true`.
        /// </summary>
        public readonly bool? TextDataDeliveryEnabled;
        /// <summary>
        /// Set to include text data in the log delivery. Defaults to `true`.
        /// </summary>
        public readonly bool? VideoDataDeliveryEnabled;

        [OutputConstructor]
        private InvocationLoggingConfigurationLoggingConfig(
            Outputs.InvocationLoggingConfigurationLoggingConfigCloudwatchConfig? cloudwatchConfig,

            bool? embeddingDataDeliveryEnabled,

            bool? imageDataDeliveryEnabled,

            Outputs.InvocationLoggingConfigurationLoggingConfigS3Config? s3Config,

            bool? textDataDeliveryEnabled,

            bool? videoDataDeliveryEnabled)
        {
            CloudwatchConfig = cloudwatchConfig;
            EmbeddingDataDeliveryEnabled = embeddingDataDeliveryEnabled;
            ImageDataDeliveryEnabled = imageDataDeliveryEnabled;
            S3Config = s3Config;
            TextDataDeliveryEnabled = textDataDeliveryEnabled;
            VideoDataDeliveryEnabled = videoDataDeliveryEnabled;
        }
    }
}
