// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketV2LifecycleRuleNoncurrentVersionTransitionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the number of days noncurrent object versions transition.
        /// </summary>
        [Input("days")]
        public Input<int>? Days { get; set; }

        /// <summary>
        /// Specifies the Amazon S3 [storage class](https://docs.aws.amazon.com/AmazonS3/latest/API/API_Transition.html#AmazonS3-Type-Transition-StorageClass) to which you want the object to transition.
        /// </summary>
        [Input("storageClass", required: true)]
        public Input<string> StorageClass { get; set; } = null!;

        public BucketV2LifecycleRuleNoncurrentVersionTransitionGetArgs()
        {
        }
        public static new BucketV2LifecycleRuleNoncurrentVersionTransitionGetArgs Empty => new BucketV2LifecycleRuleNoncurrentVersionTransitionGetArgs();
    }
}
