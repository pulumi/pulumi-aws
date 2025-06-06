// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Inputs
{

    public sealed class AnalyticsApplicationReferenceDataSourcesS3GetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The S3 Bucket ARN.
        /// </summary>
        [Input("bucketArn", required: true)]
        public Input<string> BucketArn { get; set; } = null!;

        /// <summary>
        /// The File Key name containing reference data.
        /// </summary>
        [Input("fileKey", required: true)]
        public Input<string> FileKey { get; set; } = null!;

        /// <summary>
        /// The IAM Role ARN to read the data.
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

        public AnalyticsApplicationReferenceDataSourcesS3GetArgs()
        {
        }
        public static new AnalyticsApplicationReferenceDataSourcesS3GetArgs Empty => new AnalyticsApplicationReferenceDataSourcesS3GetArgs();
    }
}
