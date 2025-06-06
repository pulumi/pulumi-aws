// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketObjectLockConfigurationV2RuleGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for specifying the default Object Lock retention settings for new objects placed in the specified bucket. See below.
        /// </summary>
        [Input("defaultRetention", required: true)]
        public Input<Inputs.BucketObjectLockConfigurationV2RuleDefaultRetentionGetArgs> DefaultRetention { get; set; } = null!;

        public BucketObjectLockConfigurationV2RuleGetArgs()
        {
        }
        public static new BucketObjectLockConfigurationV2RuleGetArgs Empty => new BucketObjectLockConfigurationV2RuleGetArgs();
    }
}
