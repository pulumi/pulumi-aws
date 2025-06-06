// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Connect.Inputs
{

    public sealed class InstanceStorageConfigStorageConfigKinesisVideoStreamConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The encryption configuration. Documented below.
        /// </summary>
        [Input("encryptionConfig", required: true)]
        public Input<Inputs.InstanceStorageConfigStorageConfigKinesisVideoStreamConfigEncryptionConfigArgs> EncryptionConfig { get; set; } = null!;

        /// <summary>
        /// The prefix of the video stream. Minimum length of `1`. Maximum length of `128`. When read from the state, the value returned is `&lt;prefix&gt;-connect-&lt;connect_instance_alias&gt;-contact-` since the API appends additional details to the `prefix`.
        /// </summary>
        [Input("prefix", required: true)]
        public Input<string> Prefix { get; set; } = null!;

        /// <summary>
        /// The number of hours data is retained in the stream. Kinesis Video Streams retains the data in a data store that is associated with the stream. Minimum value of `0`. Maximum value of `87600`. A value of `0`, indicates that the stream does not persist data.
        /// </summary>
        [Input("retentionPeriodHours", required: true)]
        public Input<int> RetentionPeriodHours { get; set; } = null!;

        public InstanceStorageConfigStorageConfigKinesisVideoStreamConfigArgs()
        {
        }
        public static new InstanceStorageConfigStorageConfigKinesisVideoStreamConfigArgs Empty => new InstanceStorageConfigStorageConfigKinesisVideoStreamConfigArgs();
    }
}
