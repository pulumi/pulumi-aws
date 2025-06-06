// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketReplicationConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the IAM role for Amazon S3 to assume when replicating the objects.
        /// </summary>
        [Input("role", required: true)]
        public Input<string> Role { get; set; } = null!;

        [Input("rules", required: true)]
        private InputList<Inputs.BucketReplicationConfigurationRuleArgs>? _rules;

        /// <summary>
        /// Specifies the rules managing the replication (documented below).
        /// </summary>
        public InputList<Inputs.BucketReplicationConfigurationRuleArgs> Rules
        {
            get => _rules ?? (_rules = new InputList<Inputs.BucketReplicationConfigurationRuleArgs>());
            set => _rules = value;
        }

        public BucketReplicationConfigurationArgs()
        {
        }
        public static new BucketReplicationConfigurationArgs Empty => new BucketReplicationConfigurationArgs();
    }
}
