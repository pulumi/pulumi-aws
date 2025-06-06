// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Efs
{
    /// <summary>
    /// Provides an Elastic File System (EFS) File System Policy resource.
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
    ///     var fs = new Aws.Efs.FileSystem("fs", new()
    ///     {
    ///         CreationToken = "my-product",
    ///     });
    /// 
    ///     var policy = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Sid = "ExampleStatement01",
    ///                 Effect = "Allow",
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "AWS",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "*",
    ///                         },
    ///                     },
    ///                 },
    ///                 Actions = new[]
    ///                 {
    ///                     "elasticfilesystem:ClientMount",
    ///                     "elasticfilesystem:ClientWrite",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     fs.Arn,
    ///                 },
    ///                 Conditions = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementConditionInputArgs
    ///                     {
    ///                         Test = "Bool",
    ///                         Variable = "aws:SecureTransport",
    ///                         Values = new[]
    ///                         {
    ///                             "true",
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var policyFileSystemPolicy = new Aws.Efs.FileSystemPolicy("policy", new()
    ///     {
    ///         FileSystemId = fs.Id,
    ///         Policy = policy.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import the EFS file system policies using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:efs/fileSystemPolicy:FileSystemPolicy foo fs-6fa144c6
    /// ```
    /// </summary>
    [AwsResourceType("aws:efs/fileSystemPolicy:FileSystemPolicy")]
    public partial class FileSystemPolicy : global::Pulumi.CustomResource
    {
        /// <summary>
        /// A flag to indicate whether to bypass the `aws.efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypass_policy_lockout_safety_check` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
        /// </summary>
        [Output("bypassPolicyLockoutSafetyCheck")]
        public Output<bool?> BypassPolicyLockoutSafetyCheck { get; private set; } = null!;

        /// <summary>
        /// The ID of the EFS file system.
        /// </summary>
        [Output("fileSystemId")]
        public Output<string> FileSystemId { get; private set; } = null!;

        /// <summary>
        /// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("policy")]
        public Output<string> Policy { get; private set; } = null!;


        /// <summary>
        /// Create a FileSystemPolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public FileSystemPolicy(string name, FileSystemPolicyArgs args, CustomResourceOptions? options = null)
            : base("aws:efs/fileSystemPolicy:FileSystemPolicy", name, args ?? new FileSystemPolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private FileSystemPolicy(string name, Input<string> id, FileSystemPolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:efs/fileSystemPolicy:FileSystemPolicy", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing FileSystemPolicy resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static FileSystemPolicy Get(string name, Input<string> id, FileSystemPolicyState? state = null, CustomResourceOptions? options = null)
        {
            return new FileSystemPolicy(name, id, state, options);
        }
    }

    public sealed class FileSystemPolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A flag to indicate whether to bypass the `aws.efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypass_policy_lockout_safety_check` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
        /// </summary>
        [Input("bypassPolicyLockoutSafetyCheck")]
        public Input<bool>? BypassPolicyLockoutSafetyCheck { get; set; }

        /// <summary>
        /// The ID of the EFS file system.
        /// </summary>
        [Input("fileSystemId", required: true)]
        public Input<string> FileSystemId { get; set; } = null!;

        /// <summary>
        /// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("policy", required: true)]
        public Input<string> Policy { get; set; } = null!;

        public FileSystemPolicyArgs()
        {
        }
        public static new FileSystemPolicyArgs Empty => new FileSystemPolicyArgs();
    }

    public sealed class FileSystemPolicyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A flag to indicate whether to bypass the `aws.efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypass_policy_lockout_safety_check` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
        /// </summary>
        [Input("bypassPolicyLockoutSafetyCheck")]
        public Input<bool>? BypassPolicyLockoutSafetyCheck { get; set; }

        /// <summary>
        /// The ID of the EFS file system.
        /// </summary>
        [Input("fileSystemId")]
        public Input<string>? FileSystemId { get; set; }

        /// <summary>
        /// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("policy")]
        public Input<string>? Policy { get; set; }

        public FileSystemPolicyState()
        {
        }
        public static new FileSystemPolicyState Empty => new FileSystemPolicyState();
    }
}
