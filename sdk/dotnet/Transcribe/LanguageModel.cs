// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Transcribe
{
    /// <summary>
    /// Resource for managing an AWS Transcribe LanguageModel.
    /// 
    /// &gt; This resource can take a significant amount of time to provision. See Language Model [FAQ](https://aws.amazon.com/transcribe/faqs/) for more details.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic Usage
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
    ///     var example = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Actions = new[]
    ///                 {
    ///                     "sts:AssumeRole",
    ///                 },
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "transcribe.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleRole = new Aws.Iam.Role("example", new()
    ///     {
    ///         Name = "example",
    ///         AssumeRolePolicy = example.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var testPolicy = new Aws.Iam.RolePolicy("test_policy", new()
    ///     {
    ///         Name = "example",
    ///         Role = exampleRole.Id,
    ///         Policy = JsonSerializer.Serialize(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["Version"] = "2012-10-17",
    ///             ["Statement"] = new[]
    ///             {
    ///                 new Dictionary&lt;string, object?&gt;
    ///                 {
    ///                     ["Action"] = new[]
    ///                     {
    ///                         "s3:GetObject",
    ///                         "s3:ListBucket",
    ///                     },
    ///                     ["Effect"] = "Allow",
    ///                     ["Resource"] = new[]
    ///                     {
    ///                         "*",
    ///                     },
    ///                 },
    ///             },
    ///         }),
    ///     });
    /// 
    ///     var exampleBucketV2 = new Aws.S3.BucketV2("example", new()
    ///     {
    ///         Bucket = "example-transcribe",
    ///         ForceDestroy = true,
    ///     });
    /// 
    ///     var @object = new Aws.S3.BucketObjectv2("object", new()
    ///     {
    ///         Bucket = exampleBucketV2.Id,
    ///         Key = "transcribe/test1.txt",
    ///         Source = new FileAsset("test1.txt"),
    ///     });
    /// 
    ///     var exampleLanguageModel = new Aws.Transcribe.LanguageModel("example", new()
    ///     {
    ///         ModelName = "example",
    ///         BaseModelName = "NarrowBand",
    ///         InputDataConfig = new Aws.Transcribe.Inputs.LanguageModelInputDataConfigArgs
    ///         {
    ///             DataAccessRoleArn = exampleRole.Arn,
    ///             S3Uri = exampleBucketV2.Id.Apply(id =&gt; $"s3://{id}/transcribe/"),
    ///         },
    ///         LanguageCode = "en-US",
    ///         Tags = 
    ///         {
    ///             { "ENVIRONMENT", "development" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Transcribe LanguageModel using the `model_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:transcribe/languageModel:LanguageModel example example-name
    /// ```
    /// </summary>
    [AwsResourceType("aws:transcribe/languageModel:LanguageModel")]
    public partial class LanguageModel : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the LanguageModel.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Name of reference base model.
        /// </summary>
        [Output("baseModelName")]
        public Output<string> BaseModelName { get; private set; } = null!;

        /// <summary>
        /// The input data config for the LanguageModel. See Input Data Config for more details.
        /// </summary>
        [Output("inputDataConfig")]
        public Output<Outputs.LanguageModelInputDataConfig> InputDataConfig { get; private set; } = null!;

        /// <summary>
        /// The language code you selected for your language model. Refer to the [supported languages](https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html) page for accepted codes.
        /// </summary>
        [Output("languageCode")]
        public Output<string> LanguageCode { get; private set; } = null!;

        /// <summary>
        /// The model name.
        /// </summary>
        [Output("modelName")]
        public Output<string> ModelName { get; private set; } = null!;

        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a LanguageModel resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public LanguageModel(string name, LanguageModelArgs args, CustomResourceOptions? options = null)
            : base("aws:transcribe/languageModel:LanguageModel", name, args ?? new LanguageModelArgs(), MakeResourceOptions(options, ""))
        {
        }

        private LanguageModel(string name, Input<string> id, LanguageModelState? state = null, CustomResourceOptions? options = null)
            : base("aws:transcribe/languageModel:LanguageModel", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing LanguageModel resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static LanguageModel Get(string name, Input<string> id, LanguageModelState? state = null, CustomResourceOptions? options = null)
        {
            return new LanguageModel(name, id, state, options);
        }
    }

    public sealed class LanguageModelArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of reference base model.
        /// </summary>
        [Input("baseModelName", required: true)]
        public Input<string> BaseModelName { get; set; } = null!;

        /// <summary>
        /// The input data config for the LanguageModel. See Input Data Config for more details.
        /// </summary>
        [Input("inputDataConfig", required: true)]
        public Input<Inputs.LanguageModelInputDataConfigArgs> InputDataConfig { get; set; } = null!;

        /// <summary>
        /// The language code you selected for your language model. Refer to the [supported languages](https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html) page for accepted codes.
        /// </summary>
        [Input("languageCode", required: true)]
        public Input<string> LanguageCode { get; set; } = null!;

        /// <summary>
        /// The model name.
        /// </summary>
        [Input("modelName", required: true)]
        public Input<string> ModelName { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public LanguageModelArgs()
        {
        }
        public static new LanguageModelArgs Empty => new LanguageModelArgs();
    }

    public sealed class LanguageModelState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the LanguageModel.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Name of reference base model.
        /// </summary>
        [Input("baseModelName")]
        public Input<string>? BaseModelName { get; set; }

        /// <summary>
        /// The input data config for the LanguageModel. See Input Data Config for more details.
        /// </summary>
        [Input("inputDataConfig")]
        public Input<Inputs.LanguageModelInputDataConfigGetArgs>? InputDataConfig { get; set; }

        /// <summary>
        /// The language code you selected for your language model. Refer to the [supported languages](https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html) page for accepted codes.
        /// </summary>
        [Input("languageCode")]
        public Input<string>? LanguageCode { get; set; }

        /// <summary>
        /// The model name.
        /// </summary>
        [Input("modelName")]
        public Input<string>? ModelName { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;
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

        public LanguageModelState()
        {
        }
        public static new LanguageModelState Empty => new LanguageModelState();
    }
}
