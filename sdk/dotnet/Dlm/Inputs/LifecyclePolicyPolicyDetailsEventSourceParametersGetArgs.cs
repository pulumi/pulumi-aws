// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Dlm.Inputs
{

    public sealed class LifecyclePolicyPolicyDetailsEventSourceParametersGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The snapshot description that can trigger the policy. The description pattern is specified using a regular expression. The policy runs only if a snapshot with a description that matches the specified pattern is shared with your account.
        /// </summary>
        [Input("descriptionRegex", required: true)]
        public Input<string> DescriptionRegex { get; set; } = null!;

        /// <summary>
        /// The type of event. Currently, only `shareSnapshot` events are supported.
        /// </summary>
        [Input("eventType", required: true)]
        public Input<string> EventType { get; set; } = null!;

        [Input("snapshotOwners", required: true)]
        private InputList<string>? _snapshotOwners;

        /// <summary>
        /// The IDs of the AWS accounts that can trigger policy by sharing snapshots with your account. The policy only runs if one of the specified AWS accounts shares a snapshot with your account.
        /// </summary>
        public InputList<string> SnapshotOwners
        {
            get => _snapshotOwners ?? (_snapshotOwners = new InputList<string>());
            set => _snapshotOwners = value;
        }

        public LifecyclePolicyPolicyDetailsEventSourceParametersGetArgs()
        {
        }
        public static new LifecyclePolicyPolicyDetailsEventSourceParametersGetArgs Empty => new LifecyclePolicyPolicyDetailsEventSourceParametersGetArgs();
    }
}
