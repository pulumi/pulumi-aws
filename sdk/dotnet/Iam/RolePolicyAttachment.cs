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
    /// Attaches a Managed IAM Policy to an IAM role
    /// 
    /// &gt; **NOTE:** The usage of this resource conflicts with the `aws.iam.PolicyAttachment` resource and will permanently show a difference if both are defined.
    /// 
    /// &gt; **NOTE:** For a given role, this resource is incompatible with using the `aws.iam.Role` resource `managed_policy_arns` argument. When using that argument and this resource, both will attempt to manage the role's managed policy attachments and Pulumi will show a permanent difference.
    /// 
    /// ## Example Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var assumeRole = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Effect = "Allow",
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "ec2.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///                 Actions = new[]
    ///                 {
    ///                     "sts:AssumeRole",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var role = new Aws.Iam.Role("role", new()
    ///     {
    ///         Name = "test-role",
    ///         AssumeRolePolicy = assumeRole.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var policy = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Effect = "Allow",
    ///                 Actions = new[]
    ///                 {
    ///                     "ec2:Describe*",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     "*",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var policyPolicy = new Aws.Iam.Policy("policy", new()
    ///     {
    ///         Name = "test-policy",
    ///         Description = "A test policy",
    ///         PolicyDocument = policy.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var test_attach = new Aws.Iam.RolePolicyAttachment("test-attach", new()
    ///     {
    ///         Role = role.Name,
    ///         PolicyArn = policyPolicy.Arn,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import IAM role policy attachments using the role name and policy arn separated by `/`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:iam/rolePolicyAttachment:RolePolicyAttachment test-attach test-role/arn:aws:iam::xxxxxxxxxxxx:policy/test-policy
    /// ```
    /// </summary>
    [AwsResourceType("aws:iam/rolePolicyAttachment:RolePolicyAttachment")]
    public partial class RolePolicyAttachment : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of the policy you want to apply
        /// </summary>
        [Output("policyArn")]
        public Output<string> PolicyArn { get; private set; } = null!;

        /// <summary>
        /// The name of the IAM role to which the policy should be applied
        /// </summary>
        [Output("role")]
        public Output<string> Role { get; private set; } = null!;


        /// <summary>
        /// Create a RolePolicyAttachment resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public RolePolicyAttachment(string name, RolePolicyAttachmentArgs args, CustomResourceOptions? options = null)
            : base("aws:iam/rolePolicyAttachment:RolePolicyAttachment", name, args ?? new RolePolicyAttachmentArgs(), MakeResourceOptions(options, ""))
        {
        }

        private RolePolicyAttachment(string name, Input<string> id, RolePolicyAttachmentState? state = null, CustomResourceOptions? options = null)
            : base("aws:iam/rolePolicyAttachment:RolePolicyAttachment", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing RolePolicyAttachment resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static RolePolicyAttachment Get(string name, Input<string> id, RolePolicyAttachmentState? state = null, CustomResourceOptions? options = null)
        {
            return new RolePolicyAttachment(name, id, state, options);
        }
    }

    public sealed class RolePolicyAttachmentArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the policy you want to apply
        /// </summary>
        [Input("policyArn", required: true)]
        public Input<string> PolicyArn { get; set; } = null!;

        /// <summary>
        /// The name of the IAM role to which the policy should be applied
        /// </summary>
        [Input("role", required: true)]
        public Input<string> Role { get; set; } = null!;

        public RolePolicyAttachmentArgs()
        {
        }
        public static new RolePolicyAttachmentArgs Empty => new RolePolicyAttachmentArgs();
    }

    public sealed class RolePolicyAttachmentState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the policy you want to apply
        /// </summary>
        [Input("policyArn")]
        public Input<string>? PolicyArn { get; set; }

        /// <summary>
        /// The name of the IAM role to which the policy should be applied
        /// </summary>
        [Input("role")]
        public Input<string>? Role { get; set; }

        public RolePolicyAttachmentState()
        {
        }
        public static new RolePolicyAttachmentState Empty => new RolePolicyAttachmentState();
    }
}
