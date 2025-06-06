// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Organizations
{
    /// <summary>
    /// Provides a resource to attach an AWS Organizations policy to an organization account, root, or unit.
    /// 
    /// ## Example Usage
    /// 
    /// ### Organization Account
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var account = new Aws.Organizations.PolicyAttachment("account", new()
    ///     {
    ///         PolicyId = example.Id,
    ///         TargetId = "123456789012",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Organization Root
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var root = new Aws.Organizations.PolicyAttachment("root", new()
    ///     {
    ///         PolicyId = example.Id,
    ///         TargetId = exampleAwsOrganizationsOrganization.Roots[0].Id,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Organization Unit
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var unit = new Aws.Organizations.PolicyAttachment("unit", new()
    ///     {
    ///         PolicyId = example.Id,
    ///         TargetId = exampleAwsOrganizationsOrganizationalUnit.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_organizations_policy_attachment` using the target ID and policy ID. For example:
    /// 
    /// With an account target:
    /// 
    /// ```sh
    /// $ pulumi import aws:organizations/policyAttachment:PolicyAttachment account 123456789012:p-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:organizations/policyAttachment:PolicyAttachment")]
    public partial class PolicyAttachment : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The unique identifier (ID) of the policy that you want to attach to the target.
        /// </summary>
        [Output("policyId")]
        public Output<string> PolicyId { get; private set; } = null!;

        /// <summary>
        /// If set to `true`, destroy will **not** detach the policy and instead just remove the resource from state. This can be useful in situations where the attachment must be preserved to meet the AWS minimum requirement of 1 attached policy.
        /// </summary>
        [Output("skipDestroy")]
        public Output<bool?> SkipDestroy { get; private set; } = null!;

        /// <summary>
        /// The unique identifier (ID) of the root, organizational unit, or account number that you want to attach the policy to.
        /// </summary>
        [Output("targetId")]
        public Output<string> TargetId { get; private set; } = null!;


        /// <summary>
        /// Create a PolicyAttachment resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public PolicyAttachment(string name, PolicyAttachmentArgs args, CustomResourceOptions? options = null)
            : base("aws:organizations/policyAttachment:PolicyAttachment", name, args ?? new PolicyAttachmentArgs(), MakeResourceOptions(options, ""))
        {
        }

        private PolicyAttachment(string name, Input<string> id, PolicyAttachmentState? state = null, CustomResourceOptions? options = null)
            : base("aws:organizations/policyAttachment:PolicyAttachment", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing PolicyAttachment resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static PolicyAttachment Get(string name, Input<string> id, PolicyAttachmentState? state = null, CustomResourceOptions? options = null)
        {
            return new PolicyAttachment(name, id, state, options);
        }
    }

    public sealed class PolicyAttachmentArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The unique identifier (ID) of the policy that you want to attach to the target.
        /// </summary>
        [Input("policyId", required: true)]
        public Input<string> PolicyId { get; set; } = null!;

        /// <summary>
        /// If set to `true`, destroy will **not** detach the policy and instead just remove the resource from state. This can be useful in situations where the attachment must be preserved to meet the AWS minimum requirement of 1 attached policy.
        /// </summary>
        [Input("skipDestroy")]
        public Input<bool>? SkipDestroy { get; set; }

        /// <summary>
        /// The unique identifier (ID) of the root, organizational unit, or account number that you want to attach the policy to.
        /// </summary>
        [Input("targetId", required: true)]
        public Input<string> TargetId { get; set; } = null!;

        public PolicyAttachmentArgs()
        {
        }
        public static new PolicyAttachmentArgs Empty => new PolicyAttachmentArgs();
    }

    public sealed class PolicyAttachmentState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The unique identifier (ID) of the policy that you want to attach to the target.
        /// </summary>
        [Input("policyId")]
        public Input<string>? PolicyId { get; set; }

        /// <summary>
        /// If set to `true`, destroy will **not** detach the policy and instead just remove the resource from state. This can be useful in situations where the attachment must be preserved to meet the AWS minimum requirement of 1 attached policy.
        /// </summary>
        [Input("skipDestroy")]
        public Input<bool>? SkipDestroy { get; set; }

        /// <summary>
        /// The unique identifier (ID) of the root, organizational unit, or account number that you want to attach the policy to.
        /// </summary>
        [Input("targetId")]
        public Input<string>? TargetId { get; set; }

        public PolicyAttachmentState()
        {
        }
        public static new PolicyAttachmentState Empty => new PolicyAttachmentState();
    }
}
