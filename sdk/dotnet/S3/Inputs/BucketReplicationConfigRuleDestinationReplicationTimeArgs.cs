// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketReplicationConfigRuleDestinationReplicationTimeArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Status of the Replication Time Control. Either `"Enabled"` or `"Disabled"`.
        /// </summary>
        [Input("status", required: true)]
        public Input<string> Status { get; set; } = null!;

        /// <summary>
        /// Configuration block specifying the time by which replication should be complete for all objects and operations on objects. See below.
        /// </summary>
        [Input("time", required: true)]
        public Input<Inputs.BucketReplicationConfigRuleDestinationReplicationTimeTimeArgs> Time { get; set; } = null!;

        public BucketReplicationConfigRuleDestinationReplicationTimeArgs()
        {
        }
        public static new BucketReplicationConfigRuleDestinationReplicationTimeArgs Empty => new BucketReplicationConfigRuleDestinationReplicationTimeArgs();
    }
}
