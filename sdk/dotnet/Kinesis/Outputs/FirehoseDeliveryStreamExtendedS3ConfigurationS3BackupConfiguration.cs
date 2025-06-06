// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Outputs
{

    [OutputType]
    public sealed class FirehoseDeliveryStreamExtendedS3ConfigurationS3BackupConfiguration
    {
        /// <summary>
        /// The ARN of the S3 bucket
        /// </summary>
        public readonly string BucketArn;
        public readonly int? BufferingInterval;
        public readonly int? BufferingSize;
        public readonly Outputs.FirehoseDeliveryStreamExtendedS3ConfigurationS3BackupConfigurationCloudwatchLoggingOptions? CloudwatchLoggingOptions;
        /// <summary>
        /// The compression format. If no value is specified, the default is `UNCOMPRESSED`. Other supported values are `GZIP`, `ZIP`, `Snappy`, &amp; `HADOOP_SNAPPY`.
        /// </summary>
        public readonly string? CompressionFormat;
        /// <summary>
        /// Prefix added to failed records before writing them to S3. Not currently supported for `redshift` destination. This prefix appears immediately following the bucket name. For information about how to specify this prefix, see [Custom Prefixes for Amazon S3 Objects](https://docs.aws.amazon.com/firehose/latest/dev/s3-prefixes.html).
        /// </summary>
        public readonly string? ErrorOutputPrefix;
        /// <summary>
        /// Specifies the KMS key ARN the stream will use to encrypt data. If not set, no encryption will
        /// be used.
        /// </summary>
        public readonly string? KmsKeyArn;
        /// <summary>
        /// The "YYYY/MM/DD/HH" time format prefix is automatically used for delivered S3 files. You can specify an extra prefix to be added in front of the time format prefix. Note that if the prefix ends with a slash, it appears as a folder in the S3 bucket
        /// </summary>
        public readonly string? Prefix;
        public readonly string RoleArn;

        [OutputConstructor]
        private FirehoseDeliveryStreamExtendedS3ConfigurationS3BackupConfiguration(
            string bucketArn,

            int? bufferingInterval,

            int? bufferingSize,

            Outputs.FirehoseDeliveryStreamExtendedS3ConfigurationS3BackupConfigurationCloudwatchLoggingOptions? cloudwatchLoggingOptions,

            string? compressionFormat,

            string? errorOutputPrefix,

            string? kmsKeyArn,

            string? prefix,

            string roleArn)
        {
            BucketArn = bucketArn;
            BufferingInterval = bufferingInterval;
            BufferingSize = bufferingSize;
            CloudwatchLoggingOptions = cloudwatchLoggingOptions;
            CompressionFormat = compressionFormat;
            ErrorOutputPrefix = errorOutputPrefix;
            KmsKeyArn = kmsKeyArn;
            Prefix = prefix;
            RoleArn = roleArn;
        }
    }
}
