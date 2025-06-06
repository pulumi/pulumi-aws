// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker
{
    /// <summary>
    /// Provides a SageMaker AI MLFlow Tracking Server resource.
    /// 
    /// ## Example Usage
    /// 
    /// ### Cognito Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Sagemaker.MlflowTrackingServer("example", new()
    ///     {
    ///         TrackingServerName = "example",
    ///         RoleArn = exampleAwsIamRole.Arn,
    ///         ArtifactStoreUri = $"s3://{exampleAwsS3Bucket.Bucket}/path",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import SageMaker AI MLFlow Tracking Servers using the `workteam_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:sagemaker/mlflowTrackingServer:MlflowTrackingServer example example
    /// ```
    /// </summary>
    [AwsResourceType("aws:sagemaker/mlflowTrackingServer:MlflowTrackingServer")]
    public partial class MlflowTrackingServer : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) assigned by AWS to this MLFlow Tracking Server.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
        /// </summary>
        [Output("artifactStoreUri")]
        public Output<string> ArtifactStoreUri { get; private set; } = null!;

        /// <summary>
        /// A list of Member Definitions that contains objects that identify the workers that make up the work team.
        /// </summary>
        [Output("automaticModelRegistration")]
        public Output<bool?> AutomaticModelRegistration { get; private set; } = null!;

        /// <summary>
        /// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
        /// </summary>
        [Output("mlflowVersion")]
        public Output<string> MlflowVersion { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
        /// </summary>
        [Output("roleArn")]
        public Output<string> RoleArn { get; private set; } = null!;

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
        /// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
        /// </summary>
        [Output("trackingServerName")]
        public Output<string> TrackingServerName { get; private set; } = null!;

        /// <summary>
        /// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
        /// </summary>
        [Output("trackingServerSize")]
        public Output<string?> TrackingServerSize { get; private set; } = null!;

        /// <summary>
        /// The URL to connect to the MLflow user interface for the described tracking server.
        /// </summary>
        [Output("trackingServerUrl")]
        public Output<string> TrackingServerUrl { get; private set; } = null!;

        /// <summary>
        /// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
        /// </summary>
        [Output("weeklyMaintenanceWindowStart")]
        public Output<string> WeeklyMaintenanceWindowStart { get; private set; } = null!;


        /// <summary>
        /// Create a MlflowTrackingServer resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public MlflowTrackingServer(string name, MlflowTrackingServerArgs args, CustomResourceOptions? options = null)
            : base("aws:sagemaker/mlflowTrackingServer:MlflowTrackingServer", name, args ?? new MlflowTrackingServerArgs(), MakeResourceOptions(options, ""))
        {
        }

        private MlflowTrackingServer(string name, Input<string> id, MlflowTrackingServerState? state = null, CustomResourceOptions? options = null)
            : base("aws:sagemaker/mlflowTrackingServer:MlflowTrackingServer", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing MlflowTrackingServer resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static MlflowTrackingServer Get(string name, Input<string> id, MlflowTrackingServerState? state = null, CustomResourceOptions? options = null)
        {
            return new MlflowTrackingServer(name, id, state, options);
        }
    }

    public sealed class MlflowTrackingServerArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
        /// </summary>
        [Input("artifactStoreUri", required: true)]
        public Input<string> ArtifactStoreUri { get; set; } = null!;

        /// <summary>
        /// A list of Member Definitions that contains objects that identify the workers that make up the work team.
        /// </summary>
        [Input("automaticModelRegistration")]
        public Input<bool>? AutomaticModelRegistration { get; set; }

        /// <summary>
        /// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
        /// </summary>
        [Input("mlflowVersion")]
        public Input<string>? MlflowVersion { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

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

        /// <summary>
        /// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
        /// </summary>
        [Input("trackingServerName", required: true)]
        public Input<string> TrackingServerName { get; set; } = null!;

        /// <summary>
        /// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
        /// </summary>
        [Input("trackingServerSize")]
        public Input<string>? TrackingServerSize { get; set; }

        /// <summary>
        /// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
        /// </summary>
        [Input("weeklyMaintenanceWindowStart")]
        public Input<string>? WeeklyMaintenanceWindowStart { get; set; }

        public MlflowTrackingServerArgs()
        {
        }
        public static new MlflowTrackingServerArgs Empty => new MlflowTrackingServerArgs();
    }

    public sealed class MlflowTrackingServerState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) assigned by AWS to this MLFlow Tracking Server.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
        /// </summary>
        [Input("artifactStoreUri")]
        public Input<string>? ArtifactStoreUri { get; set; }

        /// <summary>
        /// A list of Member Definitions that contains objects that identify the workers that make up the work team.
        /// </summary>
        [Input("automaticModelRegistration")]
        public Input<bool>? AutomaticModelRegistration { get; set; }

        /// <summary>
        /// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
        /// </summary>
        [Input("mlflowVersion")]
        public Input<string>? MlflowVersion { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
        /// </summary>
        [Input("roleArn")]
        public Input<string>? RoleArn { get; set; }

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

        /// <summary>
        /// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
        /// </summary>
        [Input("trackingServerName")]
        public Input<string>? TrackingServerName { get; set; }

        /// <summary>
        /// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
        /// </summary>
        [Input("trackingServerSize")]
        public Input<string>? TrackingServerSize { get; set; }

        /// <summary>
        /// The URL to connect to the MLflow user interface for the described tracking server.
        /// </summary>
        [Input("trackingServerUrl")]
        public Input<string>? TrackingServerUrl { get; set; }

        /// <summary>
        /// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
        /// </summary>
        [Input("weeklyMaintenanceWindowStart")]
        public Input<string>? WeeklyMaintenanceWindowStart { get; set; }

        public MlflowTrackingServerState()
        {
        }
        public static new MlflowTrackingServerState Empty => new MlflowTrackingServerState();
    }
}
