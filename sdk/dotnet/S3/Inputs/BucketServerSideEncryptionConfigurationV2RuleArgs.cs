// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketServerSideEncryptionConfigurationV2RuleArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Single object for setting server-side encryption by default. See below.
        /// </summary>
        [Input("applyServerSideEncryptionByDefault")]
        public Input<Inputs.BucketServerSideEncryptionConfigurationV2RuleApplyServerSideEncryptionByDefaultArgs>? ApplyServerSideEncryptionByDefault { get; set; }

        /// <summary>
        /// Whether or not to use [Amazon S3 Bucket Keys](https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html) for SSE-KMS.
        /// </summary>
        [Input("bucketKeyEnabled")]
        public Input<bool>? BucketKeyEnabled { get; set; }

        public BucketServerSideEncryptionConfigurationV2RuleArgs()
        {
        }
        public static new BucketServerSideEncryptionConfigurationV2RuleArgs Empty => new BucketServerSideEncryptionConfigurationV2RuleArgs();
    }
}
