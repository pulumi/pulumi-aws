// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Number of noncurrent versions Amazon S3 will retain. Must be a non-zero positive integer.
        /// </summary>
        [Input("newerNoncurrentVersions")]
        public Input<int>? NewerNoncurrentVersions { get; set; }

        /// <summary>
        /// Number of days an object is noncurrent before Amazon S3 can perform the associated action. Must be a positive integer.
        /// </summary>
        [Input("noncurrentDays", required: true)]
        public Input<int> NoncurrentDays { get; set; } = null!;

        public BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationGetArgs()
        {
        }
        public static new BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationGetArgs Empty => new BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationGetArgs();
    }
}
