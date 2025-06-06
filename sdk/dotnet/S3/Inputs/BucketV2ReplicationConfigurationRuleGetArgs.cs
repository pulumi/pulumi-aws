// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketV2ReplicationConfigurationRuleGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether delete markers are replicated. The only valid value is `Enabled`. To disable, omit this argument. This argument is only valid with V2 replication configurations (i.e., when `filter` is used).
        /// </summary>
        [Input("deleteMarkerReplicationStatus")]
        public Input<string>? DeleteMarkerReplicationStatus { get; set; }

        [Input("destinations", required: true)]
        private InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationGetArgs>? _destinations;

        /// <summary>
        /// Specifies the destination for the rule (documented below).
        /// </summary>
        public InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationGetArgs> Destinations
        {
            get => _destinations ?? (_destinations = new InputList<Inputs.BucketV2ReplicationConfigurationRuleDestinationGetArgs>());
            set => _destinations = value;
        }

        [Input("filters")]
        private InputList<Inputs.BucketV2ReplicationConfigurationRuleFilterGetArgs>? _filters;

        /// <summary>
        /// Filter that identifies subset of objects to which the replication rule applies (documented below).
        /// </summary>
        public InputList<Inputs.BucketV2ReplicationConfigurationRuleFilterGetArgs> Filters
        {
            get => _filters ?? (_filters = new InputList<Inputs.BucketV2ReplicationConfigurationRuleFilterGetArgs>());
            set => _filters = value;
        }

        /// <summary>
        /// Unique identifier for the rule. Must be less than or equal to 255 characters in length.
        /// </summary>
        [Input("id")]
        public Input<string>? Id { get; set; }

        /// <summary>
        /// Object keyname prefix identifying one or more objects to which the rule applies. Must be less than or equal to 1024 characters in length.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        /// <summary>
        /// Priority associated with the rule. Priority should only be set if `filter` is configured. If not provided, defaults to `0`. Priority must be unique between multiple rules.
        /// </summary>
        [Input("priority")]
        public Input<int>? Priority { get; set; }

        [Input("sourceSelectionCriterias")]
        private InputList<Inputs.BucketV2ReplicationConfigurationRuleSourceSelectionCriteriaGetArgs>? _sourceSelectionCriterias;

        /// <summary>
        /// Specifies special object selection criteria (documented below).
        /// </summary>
        public InputList<Inputs.BucketV2ReplicationConfigurationRuleSourceSelectionCriteriaGetArgs> SourceSelectionCriterias
        {
            get => _sourceSelectionCriterias ?? (_sourceSelectionCriterias = new InputList<Inputs.BucketV2ReplicationConfigurationRuleSourceSelectionCriteriaGetArgs>());
            set => _sourceSelectionCriterias = value;
        }

        /// <summary>
        /// Status of the rule. Either `Enabled` or `Disabled`. The rule is ignored if status is not Enabled.
        /// </summary>
        [Input("status", required: true)]
        public Input<string> Status { get; set; } = null!;

        public BucketV2ReplicationConfigurationRuleGetArgs()
        {
        }
        public static new BucketV2ReplicationConfigurationRuleGetArgs Empty => new BucketV2ReplicationConfigurationRuleGetArgs();
    }
}
