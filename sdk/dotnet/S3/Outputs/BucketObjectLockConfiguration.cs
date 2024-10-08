// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Outputs
{

    [OutputType]
    public sealed class BucketObjectLockConfiguration
    {
        /// <summary>
        /// Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
        /// </summary>
        public readonly string ObjectLockEnabled;
        /// <summary>
        /// Object Lock rule in place for this bucket (documented below).
        /// </summary>
        public readonly Outputs.BucketObjectLockConfigurationRule? Rule;

        [OutputConstructor]
        private BucketObjectLockConfiguration(
            string objectLockEnabled,

            Outputs.BucketObjectLockConfigurationRule? rule)
        {
            ObjectLockEnabled = objectLockEnabled;
            Rule = rule;
        }
    }
}
