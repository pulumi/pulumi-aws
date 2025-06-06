// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Amp
{
    /// <summary>
    /// Manages an Amazon Managed Service for Prometheus (AMP) Workspace.
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
    ///     var example = new Aws.Amp.Workspace("example", new()
    ///     {
    ///         Alias = "example",
    ///         Tags = 
    ///         {
    ///             { "Environment", "production" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### CloudWatch Logging
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.CloudWatch.LogGroup("example", new()
    ///     {
    ///         Name = "example",
    ///     });
    /// 
    ///     var exampleWorkspace = new Aws.Amp.Workspace("example", new()
    ///     {
    ///         LoggingConfiguration = new Aws.Amp.Inputs.WorkspaceLoggingConfigurationArgs
    ///         {
    ///             LogGroupArn = example.Arn.Apply(arn =&gt; $"{arn}:*"),
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### AWS KMS Customer Managed Keys (CMK)
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var exampleKey = new Aws.Kms.Key("example", new()
    ///     {
    ///         Description = "example",
    ///         DeletionWindowInDays = 7,
    ///     });
    /// 
    ///     var example = new Aws.Amp.Workspace("example", new()
    ///     {
    ///         Alias = "example",
    ///         KmsKeyArn = exampleKey.Arn,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import AMP Workspaces using the identifier. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:amp/workspace:Workspace demo ws-C6DCB907-F2D7-4D96-957B-66691F865D8B
    /// ```
    /// </summary>
    [AwsResourceType("aws:amp/workspace:Workspace")]
    public partial class Workspace : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The alias of the prometheus workspace. See more [in AWS Docs](https://docs.aws.amazon.com/prometheus/latest/userguide/AMP-onboard-create-workspace.html).
        /// </summary>
        [Output("alias")]
        public Output<string?> Alias { get; private set; } = null!;

        /// <summary>
        /// Amazon Resource Name (ARN) of the workspace.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The ARN for the KMS encryption key. If this argument is not provided, then the AWS owned encryption key will be used to encrypt the data in the workspace. See more [in AWS Docs](https://docs.aws.amazon.com/prometheus/latest/userguide/encryption-at-rest-Amazon-Service-Prometheus.html)
        /// </summary>
        [Output("kmsKeyArn")]
        public Output<string?> KmsKeyArn { get; private set; } = null!;

        /// <summary>
        /// Logging configuration for the workspace. See Logging Configuration below for details.
        /// </summary>
        [Output("loggingConfiguration")]
        public Output<Outputs.WorkspaceLoggingConfiguration?> LoggingConfiguration { get; private set; } = null!;

        /// <summary>
        /// Prometheus endpoint available for this workspace.
        /// </summary>
        [Output("prometheusEndpoint")]
        public Output<string> PrometheusEndpoint { get; private set; } = null!;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a Workspace resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Workspace(string name, WorkspaceArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:amp/workspace:Workspace", name, args ?? new WorkspaceArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Workspace(string name, Input<string> id, WorkspaceState? state = null, CustomResourceOptions? options = null)
            : base("aws:amp/workspace:Workspace", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Workspace resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Workspace Get(string name, Input<string> id, WorkspaceState? state = null, CustomResourceOptions? options = null)
        {
            return new Workspace(name, id, state, options);
        }
    }

    public sealed class WorkspaceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The alias of the prometheus workspace. See more [in AWS Docs](https://docs.aws.amazon.com/prometheus/latest/userguide/AMP-onboard-create-workspace.html).
        /// </summary>
        [Input("alias")]
        public Input<string>? Alias { get; set; }

        /// <summary>
        /// The ARN for the KMS encryption key. If this argument is not provided, then the AWS owned encryption key will be used to encrypt the data in the workspace. See more [in AWS Docs](https://docs.aws.amazon.com/prometheus/latest/userguide/encryption-at-rest-Amazon-Service-Prometheus.html)
        /// </summary>
        [Input("kmsKeyArn")]
        public Input<string>? KmsKeyArn { get; set; }

        /// <summary>
        /// Logging configuration for the workspace. See Logging Configuration below for details.
        /// </summary>
        [Input("loggingConfiguration")]
        public Input<Inputs.WorkspaceLoggingConfigurationArgs>? LoggingConfiguration { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public WorkspaceArgs()
        {
        }
        public static new WorkspaceArgs Empty => new WorkspaceArgs();
    }

    public sealed class WorkspaceState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The alias of the prometheus workspace. See more [in AWS Docs](https://docs.aws.amazon.com/prometheus/latest/userguide/AMP-onboard-create-workspace.html).
        /// </summary>
        [Input("alias")]
        public Input<string>? Alias { get; set; }

        /// <summary>
        /// Amazon Resource Name (ARN) of the workspace.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The ARN for the KMS encryption key. If this argument is not provided, then the AWS owned encryption key will be used to encrypt the data in the workspace. See more [in AWS Docs](https://docs.aws.amazon.com/prometheus/latest/userguide/encryption-at-rest-Amazon-Service-Prometheus.html)
        /// </summary>
        [Input("kmsKeyArn")]
        public Input<string>? KmsKeyArn { get; set; }

        /// <summary>
        /// Logging configuration for the workspace. See Logging Configuration below for details.
        /// </summary>
        [Input("loggingConfiguration")]
        public Input<Inputs.WorkspaceLoggingConfigurationGetArgs>? LoggingConfiguration { get; set; }

        /// <summary>
        /// Prometheus endpoint available for this workspace.
        /// </summary>
        [Input("prometheusEndpoint")]
        public Input<string>? PrometheusEndpoint { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public WorkspaceState()
        {
        }
        public static new WorkspaceState Empty => new WorkspaceState();
    }
}
