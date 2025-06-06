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
    public sealed class BucketReplicationConfigRuleFilterAnd
    {
        /// <summary>
        /// Object key name prefix that identifies subset of objects to which the rule applies. Must be less than or equal to 1024 characters in length.
        /// </summary>
        public readonly string? Prefix;
        /// <summary>
        /// Map of tags (key and value pairs) that identifies a subset of objects to which the rule applies. The rule applies only to objects having all the tags in its tagset.
        /// </summary>
        public readonly ImmutableDictionary<string, string>? Tags;

        [OutputConstructor]
        private BucketReplicationConfigRuleFilterAnd(
            string? prefix,

            ImmutableDictionary<string, string>? tags)
        {
            Prefix = prefix;
            Tags = tags;
        }
    }
}
