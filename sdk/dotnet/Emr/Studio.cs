// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Emr
{
    /// <summary>
    /// Provides an Elastic MapReduce Studio.
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
    ///     var example = new Aws.Emr.Studio("example", new()
    ///     {
    ///         AuthMode = "SSO",
    ///         DefaultS3Location = $"s3://{test.Bucket}/test",
    ///         EngineSecurityGroupId = testAwsSecurityGroup.Id,
    ///         Name = "example",
    ///         ServiceRole = testAwsIamRole.Arn,
    ///         SubnetIds = new[]
    ///         {
    ///             testAwsSubnet.Id,
    ///         },
    ///         UserRole = testAwsIamRole.Arn,
    ///         VpcId = testAwsVpc.Id,
    ///         WorkspaceSecurityGroupId = testAwsSecurityGroup.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import EMR studios using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:emr/studio:Studio studio es-123456ABCDEF
    /// ```
    /// </summary>
    [AwsResourceType("aws:emr/studio:Studio")]
    public partial class Studio : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the studio.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Specifies whether the Studio authenticates users using IAM or Amazon Web Services SSO. Valid values are `SSO` or `IAM`.
        /// </summary>
        [Output("authMode")]
        public Output<string> AuthMode { get; private set; } = null!;

        /// <summary>
        /// The Amazon S3 location to back up Amazon EMR Studio Workspaces and notebook files.
        /// </summary>
        [Output("defaultS3Location")]
        public Output<string> DefaultS3Location { get; private set; } = null!;

        /// <summary>
        /// A detailed description of the Amazon EMR Studio.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// The AWS KMS key identifier (ARN) used to encrypt Amazon EMR Studio workspace and notebook files when backed up to Amazon S3.
        /// </summary>
        [Output("encryptionKeyArn")]
        public Output<string?> EncryptionKeyArn { get; private set; } = null!;

        /// <summary>
        /// The ID of the Amazon EMR Studio Engine security group. The Engine security group allows inbound network traffic from the Workspace security group, and it must be in the same VPC specified by `vpc_id`.
        /// </summary>
        [Output("engineSecurityGroupId")]
        public Output<string> EngineSecurityGroupId { get; private set; } = null!;

        /// <summary>
        /// The authentication endpoint of your identity provider (IdP). Specify this value when you use IAM authentication and want to let federated users log in to a Studio with the Studio URL and credentials from your IdP. Amazon EMR Studio redirects users to this endpoint to enter credentials.
        /// </summary>
        [Output("idpAuthUrl")]
        public Output<string?> IdpAuthUrl { get; private set; } = null!;

        /// <summary>
        /// The name that your identity provider (IdP) uses for its RelayState parameter. For example, RelayState or TargetSource. Specify this value when you use IAM authentication and want to let federated users log in to a Studio using the Studio URL. The RelayState parameter differs by IdP.
        /// </summary>
        [Output("idpRelayStateParameterName")]
        public Output<string?> IdpRelayStateParameterName { get; private set; } = null!;

        /// <summary>
        /// A descriptive name for the Amazon EMR Studio.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The IAM role that the Amazon EMR Studio assumes. The service role provides a way for Amazon EMR Studio to interoperate with other Amazon Web Services services.
        /// </summary>
        [Output("serviceRole")]
        public Output<string> ServiceRole { get; private set; } = null!;

        /// <summary>
        /// A list of subnet IDs to associate with the Amazon EMR Studio. A Studio can have a maximum of 5 subnets. The subnets must belong to the VPC specified by `vpc_id`. Studio users can create a Workspace in any of the specified subnets.
        /// </summary>
        [Output("subnetIds")]
        public Output<ImmutableArray<string>> SubnetIds { get; private set; } = null!;

        /// <summary>
        /// list of tags to apply to the EMR Cluster. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The unique access URL of the Amazon EMR Studio.
        /// </summary>
        [Output("url")]
        public Output<string> Url { get; private set; } = null!;

        /// <summary>
        /// The IAM user role that users and groups assume when logged in to an Amazon EMR Studio. Only specify a User Role when you use Amazon Web Services SSO authentication. The permissions attached to the User Role can be scoped down for each user or group using session policies.
        /// </summary>
        [Output("userRole")]
        public Output<string?> UserRole { get; private set; } = null!;

        /// <summary>
        /// The ID of the Amazon Virtual Private Cloud (Amazon VPC) to associate with the Studio.
        /// </summary>
        [Output("vpcId")]
        public Output<string> VpcId { get; private set; } = null!;

        /// <summary>
        /// The ID of the Amazon EMR Studio Workspace security group. The Workspace security group allows outbound network traffic to resources in the Engine security group, and it must be in the same VPC specified by `vpc_id`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("workspaceSecurityGroupId")]
        public Output<string> WorkspaceSecurityGroupId { get; private set; } = null!;


        /// <summary>
        /// Create a Studio resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Studio(string name, StudioArgs args, CustomResourceOptions? options = null)
            : base("aws:emr/studio:Studio", name, args ?? new StudioArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Studio(string name, Input<string> id, StudioState? state = null, CustomResourceOptions? options = null)
            : base("aws:emr/studio:Studio", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Studio resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Studio Get(string name, Input<string> id, StudioState? state = null, CustomResourceOptions? options = null)
        {
            return new Studio(name, id, state, options);
        }
    }

    public sealed class StudioArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies whether the Studio authenticates users using IAM or Amazon Web Services SSO. Valid values are `SSO` or `IAM`.
        /// </summary>
        [Input("authMode", required: true)]
        public Input<string> AuthMode { get; set; } = null!;

        /// <summary>
        /// The Amazon S3 location to back up Amazon EMR Studio Workspaces and notebook files.
        /// </summary>
        [Input("defaultS3Location", required: true)]
        public Input<string> DefaultS3Location { get; set; } = null!;

        /// <summary>
        /// A detailed description of the Amazon EMR Studio.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The AWS KMS key identifier (ARN) used to encrypt Amazon EMR Studio workspace and notebook files when backed up to Amazon S3.
        /// </summary>
        [Input("encryptionKeyArn")]
        public Input<string>? EncryptionKeyArn { get; set; }

        /// <summary>
        /// The ID of the Amazon EMR Studio Engine security group. The Engine security group allows inbound network traffic from the Workspace security group, and it must be in the same VPC specified by `vpc_id`.
        /// </summary>
        [Input("engineSecurityGroupId", required: true)]
        public Input<string> EngineSecurityGroupId { get; set; } = null!;

        /// <summary>
        /// The authentication endpoint of your identity provider (IdP). Specify this value when you use IAM authentication and want to let federated users log in to a Studio with the Studio URL and credentials from your IdP. Amazon EMR Studio redirects users to this endpoint to enter credentials.
        /// </summary>
        [Input("idpAuthUrl")]
        public Input<string>? IdpAuthUrl { get; set; }

        /// <summary>
        /// The name that your identity provider (IdP) uses for its RelayState parameter. For example, RelayState or TargetSource. Specify this value when you use IAM authentication and want to let federated users log in to a Studio using the Studio URL. The RelayState parameter differs by IdP.
        /// </summary>
        [Input("idpRelayStateParameterName")]
        public Input<string>? IdpRelayStateParameterName { get; set; }

        /// <summary>
        /// A descriptive name for the Amazon EMR Studio.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The IAM role that the Amazon EMR Studio assumes. The service role provides a way for Amazon EMR Studio to interoperate with other Amazon Web Services services.
        /// </summary>
        [Input("serviceRole", required: true)]
        public Input<string> ServiceRole { get; set; } = null!;

        [Input("subnetIds", required: true)]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// A list of subnet IDs to associate with the Amazon EMR Studio. A Studio can have a maximum of 5 subnets. The subnets must belong to the VPC specified by `vpc_id`. Studio users can create a Workspace in any of the specified subnets.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// list of tags to apply to the EMR Cluster. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The IAM user role that users and groups assume when logged in to an Amazon EMR Studio. Only specify a User Role when you use Amazon Web Services SSO authentication. The permissions attached to the User Role can be scoped down for each user or group using session policies.
        /// </summary>
        [Input("userRole")]
        public Input<string>? UserRole { get; set; }

        /// <summary>
        /// The ID of the Amazon Virtual Private Cloud (Amazon VPC) to associate with the Studio.
        /// </summary>
        [Input("vpcId", required: true)]
        public Input<string> VpcId { get; set; } = null!;

        /// <summary>
        /// The ID of the Amazon EMR Studio Workspace security group. The Workspace security group allows outbound network traffic to resources in the Engine security group, and it must be in the same VPC specified by `vpc_id`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("workspaceSecurityGroupId", required: true)]
        public Input<string> WorkspaceSecurityGroupId { get; set; } = null!;

        public StudioArgs()
        {
        }
        public static new StudioArgs Empty => new StudioArgs();
    }

    public sealed class StudioState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the studio.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Specifies whether the Studio authenticates users using IAM or Amazon Web Services SSO. Valid values are `SSO` or `IAM`.
        /// </summary>
        [Input("authMode")]
        public Input<string>? AuthMode { get; set; }

        /// <summary>
        /// The Amazon S3 location to back up Amazon EMR Studio Workspaces and notebook files.
        /// </summary>
        [Input("defaultS3Location")]
        public Input<string>? DefaultS3Location { get; set; }

        /// <summary>
        /// A detailed description of the Amazon EMR Studio.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The AWS KMS key identifier (ARN) used to encrypt Amazon EMR Studio workspace and notebook files when backed up to Amazon S3.
        /// </summary>
        [Input("encryptionKeyArn")]
        public Input<string>? EncryptionKeyArn { get; set; }

        /// <summary>
        /// The ID of the Amazon EMR Studio Engine security group. The Engine security group allows inbound network traffic from the Workspace security group, and it must be in the same VPC specified by `vpc_id`.
        /// </summary>
        [Input("engineSecurityGroupId")]
        public Input<string>? EngineSecurityGroupId { get; set; }

        /// <summary>
        /// The authentication endpoint of your identity provider (IdP). Specify this value when you use IAM authentication and want to let federated users log in to a Studio with the Studio URL and credentials from your IdP. Amazon EMR Studio redirects users to this endpoint to enter credentials.
        /// </summary>
        [Input("idpAuthUrl")]
        public Input<string>? IdpAuthUrl { get; set; }

        /// <summary>
        /// The name that your identity provider (IdP) uses for its RelayState parameter. For example, RelayState or TargetSource. Specify this value when you use IAM authentication and want to let federated users log in to a Studio using the Studio URL. The RelayState parameter differs by IdP.
        /// </summary>
        [Input("idpRelayStateParameterName")]
        public Input<string>? IdpRelayStateParameterName { get; set; }

        /// <summary>
        /// A descriptive name for the Amazon EMR Studio.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The IAM role that the Amazon EMR Studio assumes. The service role provides a way for Amazon EMR Studio to interoperate with other Amazon Web Services services.
        /// </summary>
        [Input("serviceRole")]
        public Input<string>? ServiceRole { get; set; }

        [Input("subnetIds")]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// A list of subnet IDs to associate with the Amazon EMR Studio. A Studio can have a maximum of 5 subnets. The subnets must belong to the VPC specified by `vpc_id`. Studio users can create a Workspace in any of the specified subnets.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// list of tags to apply to the EMR Cluster. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        /// <summary>
        /// The unique access URL of the Amazon EMR Studio.
        /// </summary>
        [Input("url")]
        public Input<string>? Url { get; set; }

        /// <summary>
        /// The IAM user role that users and groups assume when logged in to an Amazon EMR Studio. Only specify a User Role when you use Amazon Web Services SSO authentication. The permissions attached to the User Role can be scoped down for each user or group using session policies.
        /// </summary>
        [Input("userRole")]
        public Input<string>? UserRole { get; set; }

        /// <summary>
        /// The ID of the Amazon Virtual Private Cloud (Amazon VPC) to associate with the Studio.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        /// <summary>
        /// The ID of the Amazon EMR Studio Workspace security group. The Workspace security group allows outbound network traffic to resources in the Engine security group, and it must be in the same VPC specified by `vpc_id`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("workspaceSecurityGroupId")]
        public Input<string>? WorkspaceSecurityGroupId { get; set; }

        public StudioState()
        {
        }
        public static new StudioState Empty => new StudioState();
    }
}
