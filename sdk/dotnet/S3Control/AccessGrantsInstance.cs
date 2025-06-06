// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3Control
{
    /// <summary>
    /// Provides a resource to manage an S3 Access Grants instance, which serves as a logical grouping for access grants.
    /// You can have one S3 Access Grants instance per Region in your account.
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
    ///     var example = new Aws.S3Control.AccessGrantsInstance("example");
    /// 
    /// });
    /// ```
    /// 
    /// ### AWS IAM Identity Center
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.S3Control.AccessGrantsInstance("example", new()
    ///     {
    ///         IdentityCenterArn = "arn:aws:sso:::instance/ssoins-890759e9c7bfdc1d",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import S3 Access Grants instances using the `account_id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:s3control/accessGrantsInstance:AccessGrantsInstance example 123456789012
    /// ```
    /// </summary>
    [AwsResourceType("aws:s3control/accessGrantsInstance:AccessGrantsInstance")]
    public partial class AccessGrantsInstance : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the S3 Access Grants instance.
        /// </summary>
        [Output("accessGrantsInstanceArn")]
        public Output<string> AccessGrantsInstanceArn { get; private set; } = null!;

        /// <summary>
        /// Unique ID of the S3 Access Grants instance.
        /// </summary>
        [Output("accessGrantsInstanceId")]
        public Output<string> AccessGrantsInstanceId { get; private set; } = null!;

        [Output("accountId")]
        public Output<string> AccountId { get; private set; } = null!;

        /// <summary>
        /// The ARN of the AWS IAM Identity Center instance application; a subresource of the original Identity Center instance.
        /// </summary>
        [Output("identityCenterApplicationArn")]
        public Output<string> IdentityCenterApplicationArn { get; private set; } = null!;

        /// <summary>
        /// The ARN of the AWS IAM Identity Center instance associated with the S3 Access Grants instance.
        /// </summary>
        [Output("identityCenterArn")]
        public Output<string?> IdentityCenterArn { get; private set; } = null!;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a AccessGrantsInstance resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public AccessGrantsInstance(string name, AccessGrantsInstanceArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:s3control/accessGrantsInstance:AccessGrantsInstance", name, args ?? new AccessGrantsInstanceArgs(), MakeResourceOptions(options, ""))
        {
        }

        private AccessGrantsInstance(string name, Input<string> id, AccessGrantsInstanceState? state = null, CustomResourceOptions? options = null)
            : base("aws:s3control/accessGrantsInstance:AccessGrantsInstance", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing AccessGrantsInstance resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static AccessGrantsInstance Get(string name, Input<string> id, AccessGrantsInstanceState? state = null, CustomResourceOptions? options = null)
        {
            return new AccessGrantsInstance(name, id, state, options);
        }
    }

    public sealed class AccessGrantsInstanceArgs : global::Pulumi.ResourceArgs
    {
        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// The ARN of the AWS IAM Identity Center instance associated with the S3 Access Grants instance.
        /// </summary>
        [Input("identityCenterArn")]
        public Input<string>? IdentityCenterArn { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public AccessGrantsInstanceArgs()
        {
        }
        public static new AccessGrantsInstanceArgs Empty => new AccessGrantsInstanceArgs();
    }

    public sealed class AccessGrantsInstanceState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the S3 Access Grants instance.
        /// </summary>
        [Input("accessGrantsInstanceArn")]
        public Input<string>? AccessGrantsInstanceArn { get; set; }

        /// <summary>
        /// Unique ID of the S3 Access Grants instance.
        /// </summary>
        [Input("accessGrantsInstanceId")]
        public Input<string>? AccessGrantsInstanceId { get; set; }

        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// The ARN of the AWS IAM Identity Center instance application; a subresource of the original Identity Center instance.
        /// </summary>
        [Input("identityCenterApplicationArn")]
        public Input<string>? IdentityCenterApplicationArn { get; set; }

        /// <summary>
        /// The ARN of the AWS IAM Identity Center instance associated with the S3 Access Grants instance.
        /// </summary>
        [Input("identityCenterArn")]
        public Input<string>? IdentityCenterArn { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        public AccessGrantsInstanceState()
        {
        }
        public static new AccessGrantsInstanceState Empty => new AccessGrantsInstanceState();
    }
}
