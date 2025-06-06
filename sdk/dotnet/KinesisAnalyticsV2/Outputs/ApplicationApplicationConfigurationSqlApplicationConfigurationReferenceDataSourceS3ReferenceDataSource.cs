// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Outputs
{

    [OutputType]
    public sealed class ApplicationApplicationConfigurationSqlApplicationConfigurationReferenceDataSourceS3ReferenceDataSource
    {
        /// <summary>
        /// The ARN of the S3 bucket.
        /// </summary>
        public readonly string BucketArn;
        /// <summary>
        /// The object key name containing the reference data.
        /// </summary>
        public readonly string FileKey;

        [OutputConstructor]
        private ApplicationApplicationConfigurationSqlApplicationConfigurationReferenceDataSourceS3ReferenceDataSource(
            string bucketArn,

            string fileKey)
        {
            BucketArn = bucketArn;
            FileKey = fileKey;
        }
    }
}
