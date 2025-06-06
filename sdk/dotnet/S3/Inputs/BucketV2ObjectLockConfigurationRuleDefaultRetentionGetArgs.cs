// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketV2ObjectLockConfigurationRuleDefaultRetentionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Number of days that you want to specify for the default retention period.
        /// </summary>
        [Input("days")]
        public Input<int>? Days { get; set; }

        /// <summary>
        /// Default Object Lock retention mode you want to apply to new objects placed in this bucket. Valid values are `GOVERNANCE` and `COMPLIANCE`.
        /// </summary>
        [Input("mode", required: true)]
        public Input<string> Mode { get; set; } = null!;

        /// <summary>
        /// Number of years that you want to specify for the default retention period.
        /// </summary>
        [Input("years")]
        public Input<int>? Years { get; set; }

        public BucketV2ObjectLockConfigurationRuleDefaultRetentionGetArgs()
        {
        }
        public static new BucketV2ObjectLockConfigurationRuleDefaultRetentionGetArgs Empty => new BucketV2ObjectLockConfigurationRuleDefaultRetentionGetArgs();
    }
}
