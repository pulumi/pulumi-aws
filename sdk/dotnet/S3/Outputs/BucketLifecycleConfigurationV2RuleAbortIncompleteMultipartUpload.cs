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
    public sealed class BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUpload
    {
        /// <summary>
        /// Number of days after which Amazon S3 aborts an incomplete multipart upload.
        /// </summary>
        public readonly int? DaysAfterInitiation;

        [OutputConstructor]
        private BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUpload(int? daysAfterInitiation)
        {
            DaysAfterInitiation = daysAfterInitiation;
        }
    }
}
