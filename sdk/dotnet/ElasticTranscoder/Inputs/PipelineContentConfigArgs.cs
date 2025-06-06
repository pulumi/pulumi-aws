// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElasticTranscoder.Inputs
{

    public sealed class PipelineContentConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon S3 bucket in which you want Elastic Transcoder to save transcoded files and playlists.
        /// </summary>
        [Input("bucket")]
        public Input<string>? Bucket { get; set; }

        /// <summary>
        /// The Amazon S3 storage class, `Standard` or `ReducedRedundancy`, that you want Elastic Transcoder to assign to the files and playlists that it stores in your Amazon S3 bucket.
        /// </summary>
        [Input("storageClass")]
        public Input<string>? StorageClass { get; set; }

        public PipelineContentConfigArgs()
        {
        }
        public static new PipelineContentConfigArgs Empty => new PipelineContentConfigArgs();
    }
}
