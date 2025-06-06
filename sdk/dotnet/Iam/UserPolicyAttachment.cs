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
    /// Attaches a Managed IAM Policy to an IAM user
    /// 
    /// &gt; **NOTE:** The usage of this resource conflicts with the `aws.iam.PolicyAttachment` resource and will permanently show a difference if both are defined.
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
    ///     var user = new Aws.Iam.User("user", new()
    ///     {
    ///         Name = "test-user",
    ///     });
    /// 
    ///     var policy = new Aws.Iam.Policy("policy", new()
    ///     {
    ///         Name = "test-policy",
    ///         Description = "A test policy",
    ///         PolicyDocument = "{ ... policy JSON ... }",
    ///     });
    /// 
    ///     var test_attach = new Aws.Iam.UserPolicyAttachment("test-attach", new()
    ///     {
    ///         User = user.Name,
    ///         PolicyArn = policy.Arn,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import IAM user policy attachments using the user name and policy arn separated by `/`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:iam/userPolicyAttachment:UserPolicyAttachment test-attach test-user/arn:aws:iam::xxxxxxxxxxxx:policy/test-policy
    /// ```
    /// </summary>
    [AwsResourceType("aws:iam/userPolicyAttachment:UserPolicyAttachment")]
    public partial class UserPolicyAttachment : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of the policy you want to apply
        /// </summary>
        [Output("policyArn")]
        public Output<string> PolicyArn { get; private set; } = null!;

        /// <summary>
        /// The user the policy should be applied to
        /// </summary>
        [Output("user")]
        public Output<string> User { get; private set; } = null!;


        /// <summary>
        /// Create a UserPolicyAttachment resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public UserPolicyAttachment(string name, UserPolicyAttachmentArgs args, CustomResourceOptions? options = null)
            : base("aws:iam/userPolicyAttachment:UserPolicyAttachment", name, args ?? new UserPolicyAttachmentArgs(), MakeResourceOptions(options, ""))
        {
        }

        private UserPolicyAttachment(string name, Input<string> id, UserPolicyAttachmentState? state = null, CustomResourceOptions? options = null)
            : base("aws:iam/userPolicyAttachment:UserPolicyAttachment", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing UserPolicyAttachment resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static UserPolicyAttachment Get(string name, Input<string> id, UserPolicyAttachmentState? state = null, CustomResourceOptions? options = null)
        {
            return new UserPolicyAttachment(name, id, state, options);
        }
    }

    public sealed class UserPolicyAttachmentArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the policy you want to apply
        /// </summary>
        [Input("policyArn", required: true)]
        public Input<string> PolicyArn { get; set; } = null!;

        /// <summary>
        /// The user the policy should be applied to
        /// </summary>
        [Input("user", required: true)]
        public Input<string> User { get; set; } = null!;

        public UserPolicyAttachmentArgs()
        {
        }
        public static new UserPolicyAttachmentArgs Empty => new UserPolicyAttachmentArgs();
    }

    public sealed class UserPolicyAttachmentState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the policy you want to apply
        /// </summary>
        [Input("policyArn")]
        public Input<string>? PolicyArn { get; set; }

        /// <summary>
        /// The user the policy should be applied to
        /// </summary>
        [Input("user")]
        public Input<string>? User { get; set; }

        public UserPolicyAttachmentState()
        {
        }
        public static new UserPolicyAttachmentState Empty => new UserPolicyAttachmentState();
    }
}
