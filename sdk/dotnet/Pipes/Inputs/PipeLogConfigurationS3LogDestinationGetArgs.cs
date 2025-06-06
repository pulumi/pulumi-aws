// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Inputs
{

    public sealed class PipeLogConfigurationS3LogDestinationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the Amazon S3 bucket to which EventBridge delivers the log records for the pipe.
        /// </summary>
        [Input("bucketName", required: true)]
        public Input<string> BucketName { get; set; } = null!;

        /// <summary>
        /// Amazon Web Services account that owns the Amazon S3 bucket to which EventBridge delivers the log records for the pipe.
        /// </summary>
        [Input("bucketOwner", required: true)]
        public Input<string> BucketOwner { get; set; } = null!;

        /// <summary>
        /// EventBridge format for the log records. Valid values `json`, `plain` and `w3c`.
        /// </summary>
        [Input("outputFormat")]
        public Input<string>? OutputFormat { get; set; }

        /// <summary>
        /// Prefix text with which to begin Amazon S3 log object names.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        public PipeLogConfigurationS3LogDestinationGetArgs()
        {
        }
        public static new PipeLogConfigurationS3LogDestinationGetArgs Empty => new PipeLogConfigurationS3LogDestinationGetArgs();
    }
}
