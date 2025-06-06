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
    /// Provides a customer managed policy attachment for a Single Sign-On (SSO) Permission Set resource
    /// 
    /// &gt; **NOTE:** Creating this resource will automatically [Provision the Permission Set](https://docs.aws.amazon.com/singlesignon/latest/APIReference/API_ProvisionPermissionSet.html) to apply the corresponding updates to all assigned accounts.
    /// 
    /// ## Example Usage
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
    ///     var exampleCustomerManagedPolicyAttachment = new Aws.SsoAdmin.CustomerManagedPolicyAttachment("example", new()
    ///     {
    ///         InstanceArn = examplePermissionSet.InstanceArn,
    ///         PermissionSetArn = examplePermissionSet.Arn,
    ///         CustomerManagedPolicyReference = new Aws.SsoAdmin.Inputs.CustomerManagedPolicyAttachmentCustomerManagedPolicyReferenceArgs
    ///         {
    ///             Name = examplePolicy.Name,
    ///             Path = "/",
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import SSO Managed Policy Attachments using the `name`, `path`, `permission_set_arn`, and `instance_arn` separated by a comma (`,`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ssoadmin/customerManagedPolicyAttachment:CustomerManagedPolicyAttachment example TestPolicy,/,arn:aws:sso:::permissionSet/ssoins-2938j0x8920sbj72/ps-80383020jr9302rk,arn:aws:sso:::instance/ssoins-2938j0x8920sbj72
    /// ```
    /// </summary>
    [AwsResourceType("aws:ssoadmin/customerManagedPolicyAttachment:CustomerManagedPolicyAttachment")]
    public partial class CustomerManagedPolicyAttachment : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Specifies the name and path of a customer managed policy. See below.
        /// </summary>
        [Output("customerManagedPolicyReference")]
        public Output<Outputs.CustomerManagedPolicyAttachmentCustomerManagedPolicyReference> CustomerManagedPolicyReference { get; private set; } = null!;

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
        /// Create a CustomerManagedPolicyAttachment resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public CustomerManagedPolicyAttachment(string name, CustomerManagedPolicyAttachmentArgs args, CustomResourceOptions? options = null)
            : base("aws:ssoadmin/customerManagedPolicyAttachment:CustomerManagedPolicyAttachment", name, args ?? new CustomerManagedPolicyAttachmentArgs(), MakeResourceOptions(options, ""))
        {
        }

        private CustomerManagedPolicyAttachment(string name, Input<string> id, CustomerManagedPolicyAttachmentState? state = null, CustomResourceOptions? options = null)
            : base("aws:ssoadmin/customerManagedPolicyAttachment:CustomerManagedPolicyAttachment", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing CustomerManagedPolicyAttachment resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static CustomerManagedPolicyAttachment Get(string name, Input<string> id, CustomerManagedPolicyAttachmentState? state = null, CustomResourceOptions? options = null)
        {
            return new CustomerManagedPolicyAttachment(name, id, state, options);
        }
    }

    public sealed class CustomerManagedPolicyAttachmentArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the name and path of a customer managed policy. See below.
        /// </summary>
        [Input("customerManagedPolicyReference", required: true)]
        public Input<Inputs.CustomerManagedPolicyAttachmentCustomerManagedPolicyReferenceArgs> CustomerManagedPolicyReference { get; set; } = null!;

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

        public CustomerManagedPolicyAttachmentArgs()
        {
        }
        public static new CustomerManagedPolicyAttachmentArgs Empty => new CustomerManagedPolicyAttachmentArgs();
    }

    public sealed class CustomerManagedPolicyAttachmentState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the name and path of a customer managed policy. See below.
        /// </summary>
        [Input("customerManagedPolicyReference")]
        public Input<Inputs.CustomerManagedPolicyAttachmentCustomerManagedPolicyReferenceGetArgs>? CustomerManagedPolicyReference { get; set; }

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

        public CustomerManagedPolicyAttachmentState()
        {
        }
        public static new CustomerManagedPolicyAttachmentState Empty => new CustomerManagedPolicyAttachmentState();
    }
}
