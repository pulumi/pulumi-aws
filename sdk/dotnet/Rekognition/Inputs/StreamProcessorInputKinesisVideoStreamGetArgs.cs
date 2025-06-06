// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Rekognition.Inputs
{

    public sealed class StreamProcessorInputKinesisVideoStreamGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the Kinesis video stream stream that streams the source video.
        /// </summary>
        [Input("arn", required: true)]
        public Input<string> Arn { get; set; } = null!;

        public StreamProcessorInputKinesisVideoStreamGetArgs()
        {
        }
        public static new StreamProcessorInputKinesisVideoStreamGetArgs Empty => new StreamProcessorInputKinesisVideoStreamGetArgs();
    }
}
