// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedAccess.Inputs
{

    public sealed class InstanceLoggingConfigurationAccessLogsS3Args : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of S3 bucket.
        /// </summary>
        [Input("bucketName")]
        public Input<string>? BucketName { get; set; }

        /// <summary>
        /// The ID of the AWS account that owns the Amazon S3 bucket.
        /// </summary>
        [Input("bucketOwner")]
        public Input<string>? BucketOwner { get; set; }

        /// <summary>
        /// Indicates whether logging is enabled.
        /// </summary>
        [Input("enabled", required: true)]
        public Input<bool> Enabled { get; set; } = null!;

        /// <summary>
        /// The bucket prefix.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        public InstanceLoggingConfigurationAccessLogsS3Args()
        {
        }
        public static new InstanceLoggingConfigurationAccessLogsS3Args Empty => new InstanceLoggingConfigurationAccessLogsS3Args();
    }
}
