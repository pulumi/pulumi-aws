// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ServerlessRepository
{
    /// <summary>
    /// Deploys an Application CloudFormation Stack from the Serverless Application Repository.
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
    ///     var current = Aws.GetPartition.Invoke();
    /// 
    ///     var currentGetRegion = Aws.GetRegion.Invoke();
    /// 
    ///     var postgres_rotator = new Aws.ServerlessRepository.CloudFormationStack("postgres-rotator", new()
    ///     {
    ///         Name = "postgres-rotator",
    ///         ApplicationId = "arn:aws:serverlessrepo:us-east-1:297356227824:applications/SecretsManagerRDSPostgreSQLRotationSingleUser",
    ///         Capabilities = new[]
    ///         {
    ///             "CAPABILITY_IAM",
    ///             "CAPABILITY_RESOURCE_POLICY",
    ///         },
    ///         Parameters = 
    ///         {
    ///             { "functionName", "func-postgres-rotator" },
    ///             { "endpoint", Output.Tuple(currentGetRegion, current).Apply(values =&gt;
    ///             {
    ///                 var currentGetRegion = values.Item1;
    ///                 var current = values.Item2;
    ///                 return $"secretsmanager.{currentGetRegion.Apply(getRegionResult =&gt; getRegionResult.Name)}.{current.Apply(getPartitionResult =&gt; getPartitionResult.DnsSuffix)}";
    ///             }) },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Serverless Application Repository Stack using the CloudFormation Stack name (with or without the `serverlessrepo-` prefix) or the CloudFormation Stack ID. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:serverlessrepository/cloudFormationStack:CloudFormationStack example serverlessrepo-postgres-rotator
    /// ```
    /// </summary>
    [AwsResourceType("aws:serverlessrepository/cloudFormationStack:CloudFormationStack")]
    public partial class CloudFormationStack : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of the application from the Serverless Application Repository.
        /// </summary>
        [Output("applicationId")]
        public Output<string> ApplicationId { get; private set; } = null!;

        /// <summary>
        /// A list of capabilities. Valid values are `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_RESOURCE_POLICY`, or `CAPABILITY_AUTO_EXPAND`
        /// </summary>
        [Output("capabilities")]
        public Output<ImmutableArray<string>> Capabilities { get; private set; } = null!;

        /// <summary>
        /// The name of the stack to create. The resource deployed in AWS will be prefixed with `serverlessrepo-`
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// A map of outputs from the stack.
        /// </summary>
        [Output("outputs")]
        public Output<ImmutableDictionary<string, string>> Outputs { get; private set; } = null!;

        /// <summary>
        /// A map of Parameter structures that specify input parameters for the stack.
        /// </summary>
        [Output("parameters")]
        public Output<ImmutableDictionary<string, string>> Parameters { get; private set; } = null!;

        /// <summary>
        /// The version of the application to deploy. If not supplied, deploys the latest version.
        /// </summary>
        [Output("semanticVersion")]
        public Output<string> SemanticVersion { get; private set; } = null!;

        /// <summary>
        /// A list of tags to associate with this stack. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a CloudFormationStack resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public CloudFormationStack(string name, CloudFormationStackArgs args, CustomResourceOptions? options = null)
            : base("aws:serverlessrepository/cloudFormationStack:CloudFormationStack", name, args ?? new CloudFormationStackArgs(), MakeResourceOptions(options, ""))
        {
        }

        private CloudFormationStack(string name, Input<string> id, CloudFormationStackState? state = null, CustomResourceOptions? options = null)
            : base("aws:serverlessrepository/cloudFormationStack:CloudFormationStack", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing CloudFormationStack resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static CloudFormationStack Get(string name, Input<string> id, CloudFormationStackState? state = null, CustomResourceOptions? options = null)
        {
            return new CloudFormationStack(name, id, state, options);
        }
    }

    public sealed class CloudFormationStackArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the application from the Serverless Application Repository.
        /// </summary>
        [Input("applicationId", required: true)]
        public Input<string> ApplicationId { get; set; } = null!;

        [Input("capabilities", required: true)]
        private InputList<string>? _capabilities;

        /// <summary>
        /// A list of capabilities. Valid values are `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_RESOURCE_POLICY`, or `CAPABILITY_AUTO_EXPAND`
        /// </summary>
        public InputList<string> Capabilities
        {
            get => _capabilities ?? (_capabilities = new InputList<string>());
            set => _capabilities = value;
        }

        /// <summary>
        /// The name of the stack to create. The resource deployed in AWS will be prefixed with `serverlessrepo-`
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("parameters")]
        private InputMap<string>? _parameters;

        /// <summary>
        /// A map of Parameter structures that specify input parameters for the stack.
        /// </summary>
        public InputMap<string> Parameters
        {
            get => _parameters ?? (_parameters = new InputMap<string>());
            set => _parameters = value;
        }

        /// <summary>
        /// The version of the application to deploy. If not supplied, deploys the latest version.
        /// </summary>
        [Input("semanticVersion")]
        public Input<string>? SemanticVersion { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A list of tags to associate with this stack. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public CloudFormationStackArgs()
        {
        }
        public static new CloudFormationStackArgs Empty => new CloudFormationStackArgs();
    }

    public sealed class CloudFormationStackState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the application from the Serverless Application Repository.
        /// </summary>
        [Input("applicationId")]
        public Input<string>? ApplicationId { get; set; }

        [Input("capabilities")]
        private InputList<string>? _capabilities;

        /// <summary>
        /// A list of capabilities. Valid values are `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, `CAPABILITY_RESOURCE_POLICY`, or `CAPABILITY_AUTO_EXPAND`
        /// </summary>
        public InputList<string> Capabilities
        {
            get => _capabilities ?? (_capabilities = new InputList<string>());
            set => _capabilities = value;
        }

        /// <summary>
        /// The name of the stack to create. The resource deployed in AWS will be prefixed with `serverlessrepo-`
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("outputs")]
        private InputMap<string>? _outputs;

        /// <summary>
        /// A map of outputs from the stack.
        /// </summary>
        public InputMap<string> Outputs
        {
            get => _outputs ?? (_outputs = new InputMap<string>());
            set => _outputs = value;
        }

        [Input("parameters")]
        private InputMap<string>? _parameters;

        /// <summary>
        /// A map of Parameter structures that specify input parameters for the stack.
        /// </summary>
        public InputMap<string> Parameters
        {
            get => _parameters ?? (_parameters = new InputMap<string>());
            set => _parameters = value;
        }

        /// <summary>
        /// The version of the application to deploy. If not supplied, deploys the latest version.
        /// </summary>
        [Input("semanticVersion")]
        public Input<string>? SemanticVersion { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A list of tags to associate with this stack. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public CloudFormationStackState()
        {
        }
        public static new CloudFormationStackState Empty => new CloudFormationStackState();
    }
}
