// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Inputs
{

    public sealed class FirehoseDeliveryStreamKinesisSourceConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The kinesis stream used as the source of the firehose delivery stream.
        /// </summary>
        [Input("kinesisStreamArn", required: true)]
        public Input<string> KinesisStreamArn { get; set; } = null!;

        /// <summary>
        /// The ARN of the role that provides access to the source Kinesis stream.
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

        public FirehoseDeliveryStreamKinesisSourceConfigurationGetArgs()
        {
        }
        public static new FirehoseDeliveryStreamKinesisSourceConfigurationGetArgs Empty => new FirehoseDeliveryStreamKinesisSourceConfigurationGetArgs();
    }
}
