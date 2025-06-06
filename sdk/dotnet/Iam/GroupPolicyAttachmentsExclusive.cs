// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iam
{
    /// <summary>
    /// ## Import
    /// 
    /// Using `pulumi import`, import exclusive management of managed IAM policy assignments using the `group_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:iam/groupPolicyAttachmentsExclusive:GroupPolicyAttachmentsExclusive example MyGroup
    /// ```
    /// </summary>
    [AwsResourceType("aws:iam/groupPolicyAttachmentsExclusive:GroupPolicyAttachmentsExclusive")]
    public partial class GroupPolicyAttachmentsExclusive : global::Pulumi.CustomResource
    {
        /// <summary>
        /// IAM group name.
        /// </summary>
        [Output("groupName")]
        public Output<string> GroupName { get; private set; } = null!;

        /// <summary>
        /// A list of managed IAM policy ARNs to be attached to the group. Policies attached to this group but not configured in this argument will be removed.
        /// </summary>
        [Output("policyArns")]
        public Output<ImmutableArray<string>> PolicyArns { get; private set; } = null!;


        /// <summary>
        /// Create a GroupPolicyAttachmentsExclusive resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public GroupPolicyAttachmentsExclusive(string name, GroupPolicyAttachmentsExclusiveArgs args, CustomResourceOptions? options = null)
            : base("aws:iam/groupPolicyAttachmentsExclusive:GroupPolicyAttachmentsExclusive", name, args ?? new GroupPolicyAttachmentsExclusiveArgs(), MakeResourceOptions(options, ""))
        {
        }

        private GroupPolicyAttachmentsExclusive(string name, Input<string> id, GroupPolicyAttachmentsExclusiveState? state = null, CustomResourceOptions? options = null)
            : base("aws:iam/groupPolicyAttachmentsExclusive:GroupPolicyAttachmentsExclusive", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing GroupPolicyAttachmentsExclusive resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static GroupPolicyAttachmentsExclusive Get(string name, Input<string> id, GroupPolicyAttachmentsExclusiveState? state = null, CustomResourceOptions? options = null)
        {
            return new GroupPolicyAttachmentsExclusive(name, id, state, options);
        }
    }

    public sealed class GroupPolicyAttachmentsExclusiveArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// IAM group name.
        /// </summary>
        [Input("groupName", required: true)]
        public Input<string> GroupName { get; set; } = null!;

        [Input("policyArns", required: true)]
        private InputList<string>? _policyArns;

        /// <summary>
        /// A list of managed IAM policy ARNs to be attached to the group. Policies attached to this group but not configured in this argument will be removed.
        /// </summary>
        public InputList<string> PolicyArns
        {
            get => _policyArns ?? (_policyArns = new InputList<string>());
            set => _policyArns = value;
        }

        public GroupPolicyAttachmentsExclusiveArgs()
        {
        }
        public static new GroupPolicyAttachmentsExclusiveArgs Empty => new GroupPolicyAttachmentsExclusiveArgs();
    }

    public sealed class GroupPolicyAttachmentsExclusiveState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// IAM group name.
        /// </summary>
        [Input("groupName")]
        public Input<string>? GroupName { get; set; }

        [Input("policyArns")]
        private InputList<string>? _policyArns;

        /// <summary>
        /// A list of managed IAM policy ARNs to be attached to the group. Policies attached to this group but not configured in this argument will be removed.
        /// </summary>
        public InputList<string> PolicyArns
        {
            get => _policyArns ?? (_policyArns = new InputList<string>());
            set => _policyArns = value;
        }

        public GroupPolicyAttachmentsExclusiveState()
        {
        }
        public static new GroupPolicyAttachmentsExclusiveState Empty => new GroupPolicyAttachmentsExclusiveState();
    }
}
