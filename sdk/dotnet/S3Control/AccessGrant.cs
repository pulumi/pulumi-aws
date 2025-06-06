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
    /// Provides a resource to manage an S3 Access Grant.
    /// Each access grant has its own ID and gives an IAM user or role or a directory user, or group (the grantee) access to a registered location. You determine the level of access, such as `READ` or `READWRITE`.
    /// Before you can create a grant, you must have an S3 Access Grants instance in the same Region as the S3 data.
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
    ///     var example = new Aws.S3Control.AccessGrantsInstance("example");
    /// 
    ///     var exampleAccessGrantsLocation = new Aws.S3Control.AccessGrantsLocation("example", new()
    ///     {
    ///         IamRoleArn = exampleAwsIamRole.Arn,
    ///         LocationScope = $"s3://{exampleAwsS3Bucket.Bucket}/prefixA*",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    ///     var exampleAccessGrant = new Aws.S3Control.AccessGrant("example", new()
    ///     {
    ///         AccessGrantsLocationId = exampleAccessGrantsLocation.AccessGrantsLocationId,
    ///         Permission = "READ",
    ///         AccessGrantsLocationConfiguration = new Aws.S3Control.Inputs.AccessGrantAccessGrantsLocationConfigurationArgs
    ///         {
    ///             S3SubPrefix = "prefixB*",
    ///         },
    ///         Grantee = new Aws.S3Control.Inputs.AccessGrantGranteeArgs
    ///         {
    ///             GranteeType = "IAM",
    ///             GranteeIdentifier = exampleAwsIamUser.Arn,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import S3 Access Grants using the `account_id` and `access_grant_id`, separated by a comma (`,`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:s3control/accessGrant:AccessGrant example 123456789012,04549c5e-2f3c-4a07-824d-2cafe720aa22
    /// ```
    /// </summary>
    [AwsResourceType("aws:s3control/accessGrant:AccessGrant")]
    public partial class AccessGrant : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the S3 Access Grant.
        /// </summary>
        [Output("accessGrantArn")]
        public Output<string> AccessGrantArn { get; private set; } = null!;

        /// <summary>
        /// Unique ID of the S3 Access Grant.
        /// </summary>
        [Output("accessGrantId")]
        public Output<string> AccessGrantId { get; private set; } = null!;

        /// <summary>
        /// See Location Configuration below for more details.
        /// </summary>
        [Output("accessGrantsLocationConfiguration")]
        public Output<Outputs.AccessGrantAccessGrantsLocationConfiguration?> AccessGrantsLocationConfiguration { get; private set; } = null!;

        /// <summary>
        /// The ID of the S3 Access Grants location to with the access grant is giving access.
        /// </summary>
        [Output("accessGrantsLocationId")]
        public Output<string> AccessGrantsLocationId { get; private set; } = null!;

        [Output("accountId")]
        public Output<string> AccountId { get; private set; } = null!;

        /// <summary>
        /// The access grant's scope.
        /// </summary>
        [Output("grantScope")]
        public Output<string> GrantScope { get; private set; } = null!;

        /// <summary>
        /// See Grantee below for more details.
        /// </summary>
        [Output("grantee")]
        public Output<Outputs.AccessGrantGrantee?> Grantee { get; private set; } = null!;

        /// <summary>
        /// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
        /// </summary>
        [Output("permission")]
        public Output<string> Permission { get; private set; } = null!;

        /// <summary>
        /// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
        /// </summary>
        [Output("s3PrefixType")]
        public Output<string?> S3PrefixType { get; private set; } = null!;

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
        /// Create a AccessGrant resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public AccessGrant(string name, AccessGrantArgs args, CustomResourceOptions? options = null)
            : base("aws:s3control/accessGrant:AccessGrant", name, args ?? new AccessGrantArgs(), MakeResourceOptions(options, ""))
        {
        }

        private AccessGrant(string name, Input<string> id, AccessGrantState? state = null, CustomResourceOptions? options = null)
            : base("aws:s3control/accessGrant:AccessGrant", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing AccessGrant resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static AccessGrant Get(string name, Input<string> id, AccessGrantState? state = null, CustomResourceOptions? options = null)
        {
            return new AccessGrant(name, id, state, options);
        }
    }

    public sealed class AccessGrantArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// See Location Configuration below for more details.
        /// </summary>
        [Input("accessGrantsLocationConfiguration")]
        public Input<Inputs.AccessGrantAccessGrantsLocationConfigurationArgs>? AccessGrantsLocationConfiguration { get; set; }

        /// <summary>
        /// The ID of the S3 Access Grants location to with the access grant is giving access.
        /// </summary>
        [Input("accessGrantsLocationId", required: true)]
        public Input<string> AccessGrantsLocationId { get; set; } = null!;

        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// See Grantee below for more details.
        /// </summary>
        [Input("grantee")]
        public Input<Inputs.AccessGrantGranteeArgs>? Grantee { get; set; }

        /// <summary>
        /// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
        /// </summary>
        [Input("permission", required: true)]
        public Input<string> Permission { get; set; } = null!;

        /// <summary>
        /// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
        /// </summary>
        [Input("s3PrefixType")]
        public Input<string>? S3PrefixType { get; set; }

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

        public AccessGrantArgs()
        {
        }
        public static new AccessGrantArgs Empty => new AccessGrantArgs();
    }

    public sealed class AccessGrantState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the S3 Access Grant.
        /// </summary>
        [Input("accessGrantArn")]
        public Input<string>? AccessGrantArn { get; set; }

        /// <summary>
        /// Unique ID of the S3 Access Grant.
        /// </summary>
        [Input("accessGrantId")]
        public Input<string>? AccessGrantId { get; set; }

        /// <summary>
        /// See Location Configuration below for more details.
        /// </summary>
        [Input("accessGrantsLocationConfiguration")]
        public Input<Inputs.AccessGrantAccessGrantsLocationConfigurationGetArgs>? AccessGrantsLocationConfiguration { get; set; }

        /// <summary>
        /// The ID of the S3 Access Grants location to with the access grant is giving access.
        /// </summary>
        [Input("accessGrantsLocationId")]
        public Input<string>? AccessGrantsLocationId { get; set; }

        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// The access grant's scope.
        /// </summary>
        [Input("grantScope")]
        public Input<string>? GrantScope { get; set; }

        /// <summary>
        /// See Grantee below for more details.
        /// </summary>
        [Input("grantee")]
        public Input<Inputs.AccessGrantGranteeGetArgs>? Grantee { get; set; }

        /// <summary>
        /// The access grant's level of access. Valid values: `READ`, `WRITE`, `READWRITE`.
        /// </summary>
        [Input("permission")]
        public Input<string>? Permission { get; set; }

        /// <summary>
        /// If you are creating an access grant that grants access to only one object, set this to `Object`. Valid values: `Object`.
        /// </summary>
        [Input("s3PrefixType")]
        public Input<string>? S3PrefixType { get; set; }

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

        public AccessGrantState()
        {
        }
        public static new AccessGrantState Empty => new AccessGrantState();
    }
}
