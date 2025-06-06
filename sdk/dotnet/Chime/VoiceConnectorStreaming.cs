// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Chime
{
    /// <summary>
    /// Adds a streaming configuration for the specified Amazon Chime Voice Connector. The streaming configuration specifies whether media streaming is enabled for sending to Amazon Kinesis.
    /// It also sets the retention period, in hours, for the Amazon Kinesis data.
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
    ///     var @default = new Aws.Chime.VoiceConnector("default", new()
    ///     {
    ///         Name = "vc-name-test",
    ///         RequireEncryption = true,
    ///     });
    /// 
    ///     var defaultVoiceConnectorStreaming = new Aws.Chime.VoiceConnectorStreaming("default", new()
    ///     {
    ///         Disabled = false,
    ///         VoiceConnectorId = @default.Id,
    ///         DataRetention = 7,
    ///         StreamingNotificationTargets = new[]
    ///         {
    ///             "SQS",
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Example Usage With Media Insights
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var @default = new Aws.Chime.VoiceConnector("default", new()
    ///     {
    ///         Name = "vc-name-test",
    ///         RequireEncryption = true,
    ///     });
    /// 
    ///     var assumeRole = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Effect = "Allow",
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "mediapipelines.chime.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///                 Actions = new[]
    ///                 {
    ///                     "sts:AssumeRole",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleRole = new Aws.Iam.Role("example", new()
    ///     {
    ///         Name = "ExampleResourceAccessRole",
    ///         AssumeRolePolicy = assumeRole.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var exampleStream = new Aws.Kinesis.Stream("example", new()
    ///     {
    ///         Name = "ExampleStream",
    ///         ShardCount = 2,
    ///     });
    /// 
    ///     var example = new Aws.ChimeSDKMediaPipelines.MediaInsightsPipelineConfiguration("example", new()
    ///     {
    ///         Name = "ExampleConfig",
    ///         ResourceAccessRoleArn = exampleRole.Arn,
    ///         Elements = new[]
    ///         {
    ///             new Aws.ChimeSDKMediaPipelines.Inputs.MediaInsightsPipelineConfigurationElementArgs
    ///             {
    ///                 Type = "AmazonTranscribeCallAnalyticsProcessor",
    ///                 AmazonTranscribeCallAnalyticsProcessorConfiguration = new Aws.ChimeSDKMediaPipelines.Inputs.MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs
    ///                 {
    ///                     LanguageCode = "en-US",
    ///                 },
    ///             },
    ///             new Aws.ChimeSDKMediaPipelines.Inputs.MediaInsightsPipelineConfigurationElementArgs
    ///             {
    ///                 Type = "KinesisDataStreamSink",
    ///                 KinesisDataStreamSinkConfiguration = new Aws.ChimeSDKMediaPipelines.Inputs.MediaInsightsPipelineConfigurationElementKinesisDataStreamSinkConfigurationArgs
    ///                 {
    ///                     InsightsTarget = exampleStream.Arn,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var defaultVoiceConnectorStreaming = new Aws.Chime.VoiceConnectorStreaming("default", new()
    ///     {
    ///         Disabled = false,
    ///         VoiceConnectorId = @default.Id,
    ///         DataRetention = 7,
    ///         StreamingNotificationTargets = new[]
    ///         {
    ///             "SQS",
    ///         },
    ///         MediaInsightsConfiguration = new Aws.Chime.Inputs.VoiceConnectorStreamingMediaInsightsConfigurationArgs
    ///         {
    ///             Disabled = false,
    ///             ConfigurationArn = example.Arn,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Chime Voice Connector Streaming using the `voice_connector_id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:chime/voiceConnectorStreaming:VoiceConnectorStreaming default abcdef1ghij2klmno3pqr4
    /// ```
    /// </summary>
    [AwsResourceType("aws:chime/voiceConnectorStreaming:VoiceConnectorStreaming")]
    public partial class VoiceConnectorStreaming : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The retention period, in hours, for the Amazon Kinesis data.
        /// </summary>
        [Output("dataRetention")]
        public Output<int> DataRetention { get; private set; } = null!;

        /// <summary>
        /// When true, media streaming to Amazon Kinesis is turned off. Default: `false`
        /// </summary>
        [Output("disabled")]
        public Output<bool?> Disabled { get; private set; } = null!;

        /// <summary>
        /// The media insights configuration. See `media_insights_configuration`.
        /// </summary>
        [Output("mediaInsightsConfiguration")]
        public Output<Outputs.VoiceConnectorStreamingMediaInsightsConfiguration?> MediaInsightsConfiguration { get; private set; } = null!;

        /// <summary>
        /// The streaming notification targets. Valid Values: `EventBridge | SNS | SQS`
        /// </summary>
        [Output("streamingNotificationTargets")]
        public Output<ImmutableArray<string>> StreamingNotificationTargets { get; private set; } = null!;

        /// <summary>
        /// The Amazon Chime Voice Connector ID.
        /// </summary>
        [Output("voiceConnectorId")]
        public Output<string> VoiceConnectorId { get; private set; } = null!;


        /// <summary>
        /// Create a VoiceConnectorStreaming resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public VoiceConnectorStreaming(string name, VoiceConnectorStreamingArgs args, CustomResourceOptions? options = null)
            : base("aws:chime/voiceConnectorStreaming:VoiceConnectorStreaming", name, args ?? new VoiceConnectorStreamingArgs(), MakeResourceOptions(options, ""))
        {
        }

        private VoiceConnectorStreaming(string name, Input<string> id, VoiceConnectorStreamingState? state = null, CustomResourceOptions? options = null)
            : base("aws:chime/voiceConnectorStreaming:VoiceConnectorStreaming", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing VoiceConnectorStreaming resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static VoiceConnectorStreaming Get(string name, Input<string> id, VoiceConnectorStreamingState? state = null, CustomResourceOptions? options = null)
        {
            return new VoiceConnectorStreaming(name, id, state, options);
        }
    }

    public sealed class VoiceConnectorStreamingArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The retention period, in hours, for the Amazon Kinesis data.
        /// </summary>
        [Input("dataRetention", required: true)]
        public Input<int> DataRetention { get; set; } = null!;

        /// <summary>
        /// When true, media streaming to Amazon Kinesis is turned off. Default: `false`
        /// </summary>
        [Input("disabled")]
        public Input<bool>? Disabled { get; set; }

        /// <summary>
        /// The media insights configuration. See `media_insights_configuration`.
        /// </summary>
        [Input("mediaInsightsConfiguration")]
        public Input<Inputs.VoiceConnectorStreamingMediaInsightsConfigurationArgs>? MediaInsightsConfiguration { get; set; }

        [Input("streamingNotificationTargets")]
        private InputList<string>? _streamingNotificationTargets;

        /// <summary>
        /// The streaming notification targets. Valid Values: `EventBridge | SNS | SQS`
        /// </summary>
        public InputList<string> StreamingNotificationTargets
        {
            get => _streamingNotificationTargets ?? (_streamingNotificationTargets = new InputList<string>());
            set => _streamingNotificationTargets = value;
        }

        /// <summary>
        /// The Amazon Chime Voice Connector ID.
        /// </summary>
        [Input("voiceConnectorId", required: true)]
        public Input<string> VoiceConnectorId { get; set; } = null!;

        public VoiceConnectorStreamingArgs()
        {
        }
        public static new VoiceConnectorStreamingArgs Empty => new VoiceConnectorStreamingArgs();
    }

    public sealed class VoiceConnectorStreamingState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The retention period, in hours, for the Amazon Kinesis data.
        /// </summary>
        [Input("dataRetention")]
        public Input<int>? DataRetention { get; set; }

        /// <summary>
        /// When true, media streaming to Amazon Kinesis is turned off. Default: `false`
        /// </summary>
        [Input("disabled")]
        public Input<bool>? Disabled { get; set; }

        /// <summary>
        /// The media insights configuration. See `media_insights_configuration`.
        /// </summary>
        [Input("mediaInsightsConfiguration")]
        public Input<Inputs.VoiceConnectorStreamingMediaInsightsConfigurationGetArgs>? MediaInsightsConfiguration { get; set; }

        [Input("streamingNotificationTargets")]
        private InputList<string>? _streamingNotificationTargets;

        /// <summary>
        /// The streaming notification targets. Valid Values: `EventBridge | SNS | SQS`
        /// </summary>
        public InputList<string> StreamingNotificationTargets
        {
            get => _streamingNotificationTargets ?? (_streamingNotificationTargets = new InputList<string>());
            set => _streamingNotificationTargets = value;
        }

        /// <summary>
        /// The Amazon Chime Voice Connector ID.
        /// </summary>
        [Input("voiceConnectorId")]
        public Input<string>? VoiceConnectorId { get; set; }

        public VoiceConnectorStreamingState()
        {
        }
        public static new VoiceConnectorStreamingState Empty => new VoiceConnectorStreamingState();
    }
}
