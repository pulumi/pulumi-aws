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
    public sealed class BucketObjectLockConfigurationRule
    {
        /// <summary>
        /// The default retention period that you want to apply to new objects placed in this bucket.
        /// </summary>
        public readonly Outputs.BucketObjectLockConfigurationRuleDefaultRetention DefaultRetention;

        [OutputConstructor]
        private BucketObjectLockConfigurationRule(Outputs.BucketObjectLockConfigurationRuleDefaultRetention defaultRetention)
        {
            DefaultRetention = defaultRetention;
        }
    }
}
