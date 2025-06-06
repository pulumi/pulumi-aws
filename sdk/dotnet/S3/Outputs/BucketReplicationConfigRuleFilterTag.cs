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
    public sealed class BucketReplicationConfigRuleFilterTag
    {
        /// <summary>
        /// Name of the object key.
        /// </summary>
        public readonly string Key;
        /// <summary>
        /// Value of the tag.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private BucketReplicationConfigRuleFilterTag(
            string key,

            string value)
        {
            Key = key;
            Value = value;
        }
    }
}
