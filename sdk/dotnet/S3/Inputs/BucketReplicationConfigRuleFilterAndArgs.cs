// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketReplicationConfigRuleFilterAndArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Object key name prefix that identifies subset of objects to which the rule applies. Must be less than or equal to 1024 characters in length.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags (key and value pairs) that identifies a subset of objects to which the rule applies. The rule applies only to objects having all the tags in its tagset.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public BucketReplicationConfigRuleFilterAndArgs()
        {
        }
        public static new BucketReplicationConfigRuleFilterAndArgs Empty => new BucketReplicationConfigRuleFilterAndArgs();
    }
}
