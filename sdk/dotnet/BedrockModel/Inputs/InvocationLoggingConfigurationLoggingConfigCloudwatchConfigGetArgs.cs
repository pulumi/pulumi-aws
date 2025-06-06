// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.BedrockModel.Inputs
{

    public sealed class InvocationLoggingConfigurationLoggingConfigCloudwatchConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// S3 configuration for delivering a large amount of data. See `large_data_delivery_s3_config` Block for details.
        /// </summary>
        [Input("largeDataDeliveryS3Config")]
        public Input<Inputs.InvocationLoggingConfigurationLoggingConfigCloudwatchConfigLargeDataDeliveryS3ConfigGetArgs>? LargeDataDeliveryS3Config { get; set; }

        /// <summary>
        /// Log group name.
        /// </summary>
        [Input("logGroupName")]
        public Input<string>? LogGroupName { get; set; }

        /// <summary>
        /// The role ARN.
        /// </summary>
        [Input("roleArn")]
        public Input<string>? RoleArn { get; set; }

        public InvocationLoggingConfigurationLoggingConfigCloudwatchConfigGetArgs()
        {
        }
        public static new InvocationLoggingConfigurationLoggingConfigCloudwatchConfigGetArgs Empty => new InvocationLoggingConfigurationLoggingConfigCloudwatchConfigGetArgs();
    }
}
