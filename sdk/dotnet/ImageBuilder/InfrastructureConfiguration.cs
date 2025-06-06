// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder
{
    /// <summary>
    /// Manages an Image Builder Infrastructure Configuration.
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
    ///     var example = new Aws.ImageBuilder.InfrastructureConfiguration("example", new()
    ///     {
    ///         Description = "example description",
    ///         InstanceProfileName = exampleAwsIamInstanceProfile.Name,
    ///         InstanceTypes = new[]
    ///         {
    ///             "t2.nano",
    ///             "t3.micro",
    ///         },
    ///         KeyPair = exampleAwsKeyPair.KeyName,
    ///         Name = "example",
    ///         SecurityGroupIds = new[]
    ///         {
    ///             exampleAwsSecurityGroup.Id,
    ///         },
    ///         SnsTopicArn = exampleAwsSnsTopic.Arn,
    ///         SubnetId = main.Id,
    ///         TerminateInstanceOnFailure = true,
    ///         Logging = new Aws.ImageBuilder.Inputs.InfrastructureConfigurationLoggingArgs
    ///         {
    ///             S3Logs = new Aws.ImageBuilder.Inputs.InfrastructureConfigurationLoggingS3LogsArgs
    ///             {
    ///                 S3BucketName = exampleAwsS3Bucket.Bucket,
    ///                 S3KeyPrefix = "logs",
    ///             },
    ///         },
    ///         Tags = 
    ///         {
    ///             { "foo", "bar" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_imagebuilder_infrastructure_configuration` using the Amazon Resource Name (ARN). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:imagebuilder/infrastructureConfiguration:InfrastructureConfiguration example arn:aws:imagebuilder:us-east-1:123456789012:infrastructure-configuration/example
    /// ```
    /// </summary>
    [AwsResourceType("aws:imagebuilder/infrastructureConfiguration:InfrastructureConfiguration")]
    public partial class InfrastructureConfiguration : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the configuration.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Date when the configuration was created.
        /// </summary>
        [Output("dateCreated")]
        public Output<string> DateCreated { get; private set; } = null!;

        /// <summary>
        /// Date when the configuration was updated.
        /// </summary>
        [Output("dateUpdated")]
        public Output<string> DateUpdated { get; private set; } = null!;

        /// <summary>
        /// Description for the configuration.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Configuration block with instance metadata options for the HTTP requests that pipeline builds use to launch EC2 build and test instances. Detailed below.
        /// </summary>
        [Output("instanceMetadataOptions")]
        public Output<Outputs.InfrastructureConfigurationInstanceMetadataOptions?> InstanceMetadataOptions { get; private set; } = null!;

        /// <summary>
        /// Name of IAM Instance Profile.
        /// </summary>
        [Output("instanceProfileName")]
        public Output<string> InstanceProfileName { get; private set; } = null!;

        /// <summary>
        /// Set of EC2 Instance Types.
        /// </summary>
        [Output("instanceTypes")]
        public Output<ImmutableArray<string>> InstanceTypes { get; private set; } = null!;

        /// <summary>
        /// Name of EC2 Key Pair.
        /// </summary>
        [Output("keyPair")]
        public Output<string?> KeyPair { get; private set; } = null!;

        /// <summary>
        /// Configuration block with logging settings. Detailed below.
        /// </summary>
        [Output("logging")]
        public Output<Outputs.InfrastructureConfigurationLogging?> Logging { get; private set; } = null!;

        /// <summary>
        /// Name for the configuration.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Configuration block with placement settings that define where the instances that are launched from your image will run. Detailed below.
        /// </summary>
        [Output("placement")]
        public Output<Outputs.InfrastructureConfigurationPlacement?> Placement { get; private set; } = null!;

        /// <summary>
        /// Key-value map of resource tags to assign to infrastructure created by the configuration.
        /// </summary>
        [Output("resourceTags")]
        public Output<ImmutableDictionary<string, string>?> ResourceTags { get; private set; } = null!;

        /// <summary>
        /// Set of EC2 Security Group identifiers.
        /// </summary>
        [Output("securityGroupIds")]
        public Output<ImmutableArray<string>> SecurityGroupIds { get; private set; } = null!;

        /// <summary>
        /// Amazon Resource Name (ARN) of SNS Topic.
        /// </summary>
        [Output("snsTopicArn")]
        public Output<string?> SnsTopicArn { get; private set; } = null!;

        /// <summary>
        /// EC2 Subnet identifier. Also requires `security_group_ids` argument.
        /// </summary>
        [Output("subnetId")]
        public Output<string?> SubnetId { get; private set; } = null!;

        /// <summary>
        /// Key-value map of resource tags to assign to the configuration. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// Enable if the instance should be terminated when the pipeline fails. Defaults to `false`.
        /// </summary>
        [Output("terminateInstanceOnFailure")]
        public Output<bool?> TerminateInstanceOnFailure { get; private set; } = null!;


        /// <summary>
        /// Create a InfrastructureConfiguration resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public InfrastructureConfiguration(string name, InfrastructureConfigurationArgs args, CustomResourceOptions? options = null)
            : base("aws:imagebuilder/infrastructureConfiguration:InfrastructureConfiguration", name, args ?? new InfrastructureConfigurationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private InfrastructureConfiguration(string name, Input<string> id, InfrastructureConfigurationState? state = null, CustomResourceOptions? options = null)
            : base("aws:imagebuilder/infrastructureConfiguration:InfrastructureConfiguration", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing InfrastructureConfiguration resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static InfrastructureConfiguration Get(string name, Input<string> id, InfrastructureConfigurationState? state = null, CustomResourceOptions? options = null)
        {
            return new InfrastructureConfiguration(name, id, state, options);
        }
    }

    public sealed class InfrastructureConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Description for the configuration.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Configuration block with instance metadata options for the HTTP requests that pipeline builds use to launch EC2 build and test instances. Detailed below.
        /// </summary>
        [Input("instanceMetadataOptions")]
        public Input<Inputs.InfrastructureConfigurationInstanceMetadataOptionsArgs>? InstanceMetadataOptions { get; set; }

        /// <summary>
        /// Name of IAM Instance Profile.
        /// </summary>
        [Input("instanceProfileName", required: true)]
        public Input<string> InstanceProfileName { get; set; } = null!;

        [Input("instanceTypes")]
        private InputList<string>? _instanceTypes;

        /// <summary>
        /// Set of EC2 Instance Types.
        /// </summary>
        public InputList<string> InstanceTypes
        {
            get => _instanceTypes ?? (_instanceTypes = new InputList<string>());
            set => _instanceTypes = value;
        }

        /// <summary>
        /// Name of EC2 Key Pair.
        /// </summary>
        [Input("keyPair")]
        public Input<string>? KeyPair { get; set; }

        /// <summary>
        /// Configuration block with logging settings. Detailed below.
        /// </summary>
        [Input("logging")]
        public Input<Inputs.InfrastructureConfigurationLoggingArgs>? Logging { get; set; }

        /// <summary>
        /// Name for the configuration.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Configuration block with placement settings that define where the instances that are launched from your image will run. Detailed below.
        /// </summary>
        [Input("placement")]
        public Input<Inputs.InfrastructureConfigurationPlacementArgs>? Placement { get; set; }

        [Input("resourceTags")]
        private InputMap<string>? _resourceTags;

        /// <summary>
        /// Key-value map of resource tags to assign to infrastructure created by the configuration.
        /// </summary>
        public InputMap<string> ResourceTags
        {
            get => _resourceTags ?? (_resourceTags = new InputMap<string>());
            set => _resourceTags = value;
        }

        [Input("securityGroupIds")]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// Set of EC2 Security Group identifiers.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        /// <summary>
        /// Amazon Resource Name (ARN) of SNS Topic.
        /// </summary>
        [Input("snsTopicArn")]
        public Input<string>? SnsTopicArn { get; set; }

        /// <summary>
        /// EC2 Subnet identifier. Also requires `security_group_ids` argument.
        /// </summary>
        [Input("subnetId")]
        public Input<string>? SubnetId { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags to assign to the configuration. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// Enable if the instance should be terminated when the pipeline fails. Defaults to `false`.
        /// </summary>
        [Input("terminateInstanceOnFailure")]
        public Input<bool>? TerminateInstanceOnFailure { get; set; }

        public InfrastructureConfigurationArgs()
        {
        }
        public static new InfrastructureConfigurationArgs Empty => new InfrastructureConfigurationArgs();
    }

    public sealed class InfrastructureConfigurationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the configuration.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Date when the configuration was created.
        /// </summary>
        [Input("dateCreated")]
        public Input<string>? DateCreated { get; set; }

        /// <summary>
        /// Date when the configuration was updated.
        /// </summary>
        [Input("dateUpdated")]
        public Input<string>? DateUpdated { get; set; }

        /// <summary>
        /// Description for the configuration.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Configuration block with instance metadata options for the HTTP requests that pipeline builds use to launch EC2 build and test instances. Detailed below.
        /// </summary>
        [Input("instanceMetadataOptions")]
        public Input<Inputs.InfrastructureConfigurationInstanceMetadataOptionsGetArgs>? InstanceMetadataOptions { get; set; }

        /// <summary>
        /// Name of IAM Instance Profile.
        /// </summary>
        [Input("instanceProfileName")]
        public Input<string>? InstanceProfileName { get; set; }

        [Input("instanceTypes")]
        private InputList<string>? _instanceTypes;

        /// <summary>
        /// Set of EC2 Instance Types.
        /// </summary>
        public InputList<string> InstanceTypes
        {
            get => _instanceTypes ?? (_instanceTypes = new InputList<string>());
            set => _instanceTypes = value;
        }

        /// <summary>
        /// Name of EC2 Key Pair.
        /// </summary>
        [Input("keyPair")]
        public Input<string>? KeyPair { get; set; }

        /// <summary>
        /// Configuration block with logging settings. Detailed below.
        /// </summary>
        [Input("logging")]
        public Input<Inputs.InfrastructureConfigurationLoggingGetArgs>? Logging { get; set; }

        /// <summary>
        /// Name for the configuration.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Configuration block with placement settings that define where the instances that are launched from your image will run. Detailed below.
        /// </summary>
        [Input("placement")]
        public Input<Inputs.InfrastructureConfigurationPlacementGetArgs>? Placement { get; set; }

        [Input("resourceTags")]
        private InputMap<string>? _resourceTags;

        /// <summary>
        /// Key-value map of resource tags to assign to infrastructure created by the configuration.
        /// </summary>
        public InputMap<string> ResourceTags
        {
            get => _resourceTags ?? (_resourceTags = new InputMap<string>());
            set => _resourceTags = value;
        }

        [Input("securityGroupIds")]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// Set of EC2 Security Group identifiers.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        /// <summary>
        /// Amazon Resource Name (ARN) of SNS Topic.
        /// </summary>
        [Input("snsTopicArn")]
        public Input<string>? SnsTopicArn { get; set; }

        /// <summary>
        /// EC2 Subnet identifier. Also requires `security_group_ids` argument.
        /// </summary>
        [Input("subnetId")]
        public Input<string>? SubnetId { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags to assign to the configuration. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        /// <summary>
        /// Enable if the instance should be terminated when the pipeline fails. Defaults to `false`.
        /// </summary>
        [Input("terminateInstanceOnFailure")]
        public Input<bool>? TerminateInstanceOnFailure { get; set; }

        public InfrastructureConfigurationState()
        {
        }
        public static new InfrastructureConfigurationState Empty => new InfrastructureConfigurationState();
    }
}
