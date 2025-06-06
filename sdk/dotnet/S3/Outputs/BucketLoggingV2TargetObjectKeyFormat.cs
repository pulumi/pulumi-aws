// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Outputs
{

    [OutputType]
    public sealed class BucketLoggingV2TargetObjectKeyFormat
    {
        /// <summary>
        /// Partitioned S3 key for log objects. See below.
        /// </summary>
        public readonly Outputs.BucketLoggingV2TargetObjectKeyFormatPartitionedPrefix? PartitionedPrefix;
        /// <summary>
        /// Use the simple format for S3 keys for log objects. To use, set `simple_prefix {}`.
        /// </summary>
        public readonly Outputs.BucketLoggingV2TargetObjectKeyFormatSimplePrefix? SimplePrefix;

        [OutputConstructor]
        private BucketLoggingV2TargetObjectKeyFormat(
            Outputs.BucketLoggingV2TargetObjectKeyFormatPartitionedPrefix? partitionedPrefix,

            Outputs.BucketLoggingV2TargetObjectKeyFormatSimplePrefix? simplePrefix)
        {
            PartitionedPrefix = partitionedPrefix;
            SimplePrefix = simplePrefix;
        }
    }
}
