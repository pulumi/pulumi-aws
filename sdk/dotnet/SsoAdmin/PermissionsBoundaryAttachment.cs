// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsoAdmin
{
    /// <summary>
    /// Attaches a permissions boundary policy to a Single Sign-On (SSO) Permission Set resource.
    /// 
    /// &gt; **NOTE:** A permission set can have at most one permissions boundary attached; using more than one `aws.ssoadmin.PermissionsBoundaryAttachment` references the same permission set will show a permanent difference.
    /// 
    /// ## Example Usage
    /// 
    /// ### Attaching a customer-managed policy
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using System.Text.Json;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = Aws.SsoAdmin.GetInstances.Invoke();
    /// 
    ///     var examplePermissionSet = new Aws.SsoAdmin.PermissionSet("example", new()
    ///     {
    ///         Name = "Example",
    ///         InstanceArn = example.Apply(getInstancesResult =&gt; getInstancesResult.Arns[0]),
    ///     });
    /// 
    ///     var examplePolicy = new Aws.Iam.Policy("example", new()
    ///     {
    ///         Name = "TestPolicy",
    ///         Description = "My test policy",
    ///         PolicyDocument = JsonSerializer.Serialize(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["Version"] = "2012-10-17",
    ///             ["Statement"] = new[]
    ///             {
    ///                 new Dictionary&lt;string, object?&gt;
    ///                 {
    ///                     ["Action"] = new[]
    ///                     {
    ///                         "ec2:Describe*",
    ///                     },
    ///                     ["Effect"] = "Allow",
    ///                     ["Resource"] = "*",
    ///                 },
    ///             },
    ///         }),
    ///     });
    /// 
    ///     var examplePermissionsBoundaryAttachment = new Aws.SsoAdmin.PermissionsBoundaryAttachment("example", new()
    ///     {
    ///         InstanceArn = examplePermissionSet.InstanceArn,
    ///         PermissionSetArn = examplePermissionSet.Arn,
    ///         PermissionsBoundary = new Aws.SsoAdmin.Inputs.PermissionsBoundaryAttachmentPermissionsBoundaryArgs
    ///         {
    ///             CustomerManagedPolicyReference = new Aws.SsoAdmin.Inputs.PermissionsBoundaryAttachmentPermissionsBoundaryCustomerManagedPolicyReferenceArgs
    ///             {
    ///                 Name = examplePolicy.Name,
    ///                 Path = "/",
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Attaching an AWS-managed policy
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SsoAdmin.PermissionsBoundaryAttachment("example", new()
    ///     {
    ///         InstanceArn = exampleAwsSsoadminPermissionSet.InstanceArn,
    ///         PermissionSetArn = exampleAwsSsoadminPermissionSet.Arn,
    ///         PermissionsBoundary = new Aws.SsoAdmin.Inputs.PermissionsBoundaryAttachmentPermissionsBoundaryArgs
    ///         {
    ///             ManagedPolicyArn = "arn:aws:iam::aws:policy/ReadOnlyAccess",
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import SSO Admin Permissions Boundary Attachments using the `permission_set_arn` and `instance_arn`, separated by a comma (`,`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ssoadmin/permissionsBoundaryAttachment:PermissionsBoundaryAttachment example arn:aws:sso:::permissionSet/ssoins-2938j0x8920sbj72/ps-80383020jr9302rk,arn:aws:sso:::instance/ssoins-2938j0x8920sbj72
    /// ```
    /// </summary>
    [AwsResourceType("aws:ssoadmin/permissionsBoundaryAttachment:PermissionsBoundaryAttachment")]
    public partial class PermissionsBoundaryAttachment : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
        /// </summary>
        [Output("instanceArn")]
        public Output<string> InstanceArn { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the Permission Set.
        /// </summary>
        [Output("permissionSetArn")]
        public Output<string> PermissionSetArn { get; private set; } = null!;

        /// <summary>
        /// The permissions boundary policy. See below.
        /// </summary>
        [Output("permissionsBoundary")]
        public Output<Outputs.PermissionsBoundaryAttachmentPermissionsBoundary> PermissionsBoundary { get; private set; } = null!;


        /// <summary>
        /// Create a PermissionsBoundaryAttachment resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public PermissionsBoundaryAttachment(string name, PermissionsBoundaryAttachmentArgs args, CustomResourceOptions? options = null)
            : base("aws:ssoadmin/permissionsBoundaryAttachment:PermissionsBoundaryAttachment", name, args ?? new PermissionsBoundaryAttachmentArgs(), MakeResourceOptions(options, ""))
        {
        }

        private PermissionsBoundaryAttachment(string name, Input<string> id, PermissionsBoundaryAttachmentState? state = null, CustomResourceOptions? options = null)
            : base("aws:ssoadmin/permissionsBoundaryAttachment:PermissionsBoundaryAttachment", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing PermissionsBoundaryAttachment resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static PermissionsBoundaryAttachment Get(string name, Input<string> id, PermissionsBoundaryAttachmentState? state = null, CustomResourceOptions? options = null)
        {
            return new PermissionsBoundaryAttachment(name, id, state, options);
        }
    }

    public sealed class PermissionsBoundaryAttachmentArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
        /// </summary>
        [Input("instanceArn", required: true)]
        public Input<string> InstanceArn { get; set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the Permission Set.
        /// </summary>
        [Input("permissionSetArn", required: true)]
        public Input<string> PermissionSetArn { get; set; } = null!;

        /// <summary>
        /// The permissions boundary policy. See below.
        /// </summary>
        [Input("permissionsBoundary", required: true)]
        public Input<Inputs.PermissionsBoundaryAttachmentPermissionsBoundaryArgs> PermissionsBoundary { get; set; } = null!;

        public PermissionsBoundaryAttachmentArgs()
        {
        }
        public static new PermissionsBoundaryAttachmentArgs Empty => new PermissionsBoundaryAttachmentArgs();
    }

    public sealed class PermissionsBoundaryAttachmentState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
        /// </summary>
        [Input("instanceArn")]
        public Input<string>? InstanceArn { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the Permission Set.
        /// </summary>
        [Input("permissionSetArn")]
        public Input<string>? PermissionSetArn { get; set; }

        /// <summary>
        /// The permissions boundary policy. See below.
        /// </summary>
        [Input("permissionsBoundary")]
        public Input<Inputs.PermissionsBoundaryAttachmentPermissionsBoundaryGetArgs>? PermissionsBoundary { get; set; }

        public PermissionsBoundaryAttachmentState()
        {
        }
        public static new PermissionsBoundaryAttachmentState Empty => new PermissionsBoundaryAttachmentState();
    }
}
