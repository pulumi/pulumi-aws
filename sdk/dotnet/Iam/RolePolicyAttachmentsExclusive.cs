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
    /// &gt; **NOTE:**: To reliably detect drift between customer managed policies listed in this resource and actual policies attached to the role in the cloud, you currently need to run Pulumi with `pulumi up --refresh`. See [#4766](https://github.com/pulumi/pulumi-aws/issues/4766) for tracking making this work with regular `pulumi up`
    /// 
    /// Resource for maintaining exclusive management of managed IAM policies assigned to an AWS IAM (Identity &amp; Access Management) role.
    /// 
    /// !&gt; This resource takes exclusive ownership over managed IAM policies attached to a role. This includes removal of managed IAM policies which are not explicitly configured. To prevent persistent drift, ensure any `aws.iam.RolePolicyAttachment` resources managed alongside this resource are included in the `policy_arns` argument.
    /// 
    /// &gt; Destruction of this resource means Pulumi will no longer manage reconciliation of the configured policy attachments. It **will not** detach the configured policies from the role.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Iam.RolePolicyAttachmentsExclusive("example", new()
    ///     {
    ///         RoleName = exampleAwsIamRole.Name,
    ///         PolicyArns = new[]
    ///         {
    ///             exampleAwsIamPolicy.Arn,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Disallow Managed IAM Policies
    /// 
    /// To automatically remove any configured managed IAM policies, set the `policy_arns` argument to an empty list.
    /// 
    /// &gt; This will not **prevent** managed IAM policies from being assigned to a role via Pulumi (or any other interface). This resource enables bringing managed IAM policy assignments into a configured state, however, this reconciliation happens only when `apply` is proactively run.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Iam.RolePolicyAttachmentsExclusive("example", new()
    ///     {
    ///         RoleName = exampleAwsIamRole.Name,
    ///         PolicyArns = new[] {},
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import exclusive management of managed IAM policy assignments using the `role_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:iam/rolePolicyAttachmentsExclusive:RolePolicyAttachmentsExclusive example MyRole
    /// ```
    /// </summary>
    [AwsResourceType("aws:iam/rolePolicyAttachmentsExclusive:RolePolicyAttachmentsExclusive")]
    public partial class RolePolicyAttachmentsExclusive : global::Pulumi.CustomResource
    {
        /// <summary>
        /// A list of managed IAM policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.
        /// </summary>
        [Output("policyArns")]
        public Output<ImmutableArray<string>> PolicyArns { get; private set; } = null!;

        /// <summary>
        /// IAM role name.
        /// </summary>
        [Output("roleName")]
        public Output<string> RoleName { get; private set; } = null!;


        /// <summary>
        /// Create a RolePolicyAttachmentsExclusive resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public RolePolicyAttachmentsExclusive(string name, RolePolicyAttachmentsExclusiveArgs args, CustomResourceOptions? options = null)
            : base("aws:iam/rolePolicyAttachmentsExclusive:RolePolicyAttachmentsExclusive", name, args ?? new RolePolicyAttachmentsExclusiveArgs(), MakeResourceOptions(options, ""))
        {
        }

        private RolePolicyAttachmentsExclusive(string name, Input<string> id, RolePolicyAttachmentsExclusiveState? state = null, CustomResourceOptions? options = null)
            : base("aws:iam/rolePolicyAttachmentsExclusive:RolePolicyAttachmentsExclusive", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing RolePolicyAttachmentsExclusive resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static RolePolicyAttachmentsExclusive Get(string name, Input<string> id, RolePolicyAttachmentsExclusiveState? state = null, CustomResourceOptions? options = null)
        {
            return new RolePolicyAttachmentsExclusive(name, id, state, options);
        }
    }

    public sealed class RolePolicyAttachmentsExclusiveArgs : global::Pulumi.ResourceArgs
    {
        [Input("policyArns", required: true)]
        private InputList<string>? _policyArns;

        /// <summary>
        /// A list of managed IAM policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.
        /// </summary>
        public InputList<string> PolicyArns
        {
            get => _policyArns ?? (_policyArns = new InputList<string>());
            set => _policyArns = value;
        }

        /// <summary>
        /// IAM role name.
        /// </summary>
        [Input("roleName", required: true)]
        public Input<string> RoleName { get; set; } = null!;

        public RolePolicyAttachmentsExclusiveArgs()
        {
        }
        public static new RolePolicyAttachmentsExclusiveArgs Empty => new RolePolicyAttachmentsExclusiveArgs();
    }

    public sealed class RolePolicyAttachmentsExclusiveState : global::Pulumi.ResourceArgs
    {
        [Input("policyArns")]
        private InputList<string>? _policyArns;

        /// <summary>
        /// A list of managed IAM policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.
        /// </summary>
        public InputList<string> PolicyArns
        {
            get => _policyArns ?? (_policyArns = new InputList<string>());
            set => _policyArns = value;
        }

        /// <summary>
        /// IAM role name.
        /// </summary>
        [Input("roleName")]
        public Input<string>? RoleName { get; set; }

        public RolePolicyAttachmentsExclusiveState()
        {
        }
        public static new RolePolicyAttachmentsExclusiveState Empty => new RolePolicyAttachmentsExclusiveState();
    }
}
