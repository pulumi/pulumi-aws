// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Inputs
{

    public sealed class FirehoseDeliveryStreamSplunkConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Buffer incoming data for the specified period of time, in seconds between 0 to 60, before delivering it to the destination.  The default value is 60s.
        /// </summary>
        [Input("bufferingInterval")]
        public Input<int>? BufferingInterval { get; set; }

        /// <summary>
        /// Buffer incoming data to the specified size, in MBs between 1 to 5, before delivering it to the destination.  The default value is 5MB.
        /// </summary>
        [Input("bufferingSize")]
        public Input<int>? BufferingSize { get; set; }

        /// <summary>
        /// The CloudWatch Logging Options for the delivery stream. See `cloudwatch_logging_options` block below for details.
        /// </summary>
        [Input("cloudwatchLoggingOptions")]
        public Input<Inputs.FirehoseDeliveryStreamSplunkConfigurationCloudwatchLoggingOptionsGetArgs>? CloudwatchLoggingOptions { get; set; }

        /// <summary>
        /// The amount of time, in seconds between 180 and 600, that Kinesis Firehose waits to receive an acknowledgment from Splunk after it sends it data.
        /// </summary>
        [Input("hecAcknowledgmentTimeout")]
        public Input<int>? HecAcknowledgmentTimeout { get; set; }

        /// <summary>
        /// The HTTP Event Collector (HEC) endpoint to which Kinesis Firehose sends your data.
        /// </summary>
        [Input("hecEndpoint", required: true)]
        public Input<string> HecEndpoint { get; set; } = null!;

        /// <summary>
        /// The HEC endpoint type. Valid values are `Raw` or `Event`. The default value is `Raw`.
        /// </summary>
        [Input("hecEndpointType")]
        public Input<string>? HecEndpointType { get; set; }

        /// <summary>
        /// The GUID that you obtain from your Splunk cluster when you create a new HEC endpoint. This value is required if `secrets_manager_configuration` is not provided.
        /// </summary>
        [Input("hecToken")]
        public Input<string>? HecToken { get; set; }

        /// <summary>
        /// The data processing configuration.  See `processing_configuration` block below for details.
        /// </summary>
        [Input("processingConfiguration")]
        public Input<Inputs.FirehoseDeliveryStreamSplunkConfigurationProcessingConfigurationGetArgs>? ProcessingConfiguration { get; set; }

        /// <summary>
        /// After an initial failure to deliver to Splunk, the total amount of time, in seconds between 0 to 7200, during which Firehose re-attempts delivery (including the first attempt).  After this time has elapsed, the failed documents are written to Amazon S3.  The default value is 300s.  There will be no retry if the value is 0.
        /// </summary>
        [Input("retryDuration")]
        public Input<int>? RetryDuration { get; set; }

        /// <summary>
        /// Defines how documents should be delivered to Amazon S3.  Valid values are `FailedEventsOnly` and `AllEvents`.  Default value is `FailedEventsOnly`.
        /// `secrets_manager_configuration` - (Optional) The Secrets Manager configuration. See `secrets_manager_configuration` block below for details. This value is required if `hec_token` is not provided.
        /// </summary>
        [Input("s3BackupMode")]
        public Input<string>? S3BackupMode { get; set; }

        /// <summary>
        /// The S3 Configuration. See `s3_configuration` block below for details.
        /// </summary>
        [Input("s3Configuration", required: true)]
        public Input<Inputs.FirehoseDeliveryStreamSplunkConfigurationS3ConfigurationGetArgs> S3Configuration { get; set; } = null!;

        [Input("secretsManagerConfiguration")]
        public Input<Inputs.FirehoseDeliveryStreamSplunkConfigurationSecretsManagerConfigurationGetArgs>? SecretsManagerConfiguration { get; set; }

        public FirehoseDeliveryStreamSplunkConfigurationGetArgs()
        {
        }
        public static new FirehoseDeliveryStreamSplunkConfigurationGetArgs Empty => new FirehoseDeliveryStreamSplunkConfigurationGetArgs();
    }
}
