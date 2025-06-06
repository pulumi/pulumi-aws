// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock
{
    /// <summary>
    /// Resource for managing an AWS Bedrock Inference Profile.
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
    ///     var current = Aws.GetCallerIdentity.Invoke();
    /// 
    ///     var example = new Aws.Bedrock.InferenceProfile("example", new()
    ///     {
    ///         Name = "Claude Sonnet for Project 123",
    ///         Description = "Profile with tag for cost allocation tracking",
    ///         ModelSource = new Aws.Bedrock.Inputs.InferenceProfileModelSourceArgs
    ///         {
    ///             CopyFrom = "arn:aws:bedrock:us-west-2::foundation-model/anthropic.claude-3-5-sonnet-20241022-v2:0",
    ///         },
    ///         Tags = 
    ///         {
    ///             { "ProjectID", "123" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Bedrock Inference Profile using the `example_id_arg`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:bedrock/inferenceProfile:InferenceProfile example inference_profile-id-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:bedrock/inferenceProfile:InferenceProfile")]
    public partial class InferenceProfile : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the inference profile.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The time at which the inference profile was created.
        /// </summary>
        [Output("createdAt")]
        public Output<string> CreatedAt { get; private set; } = null!;

        /// <summary>
        /// The description of the inference profile.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// The source of the model this inference profile will track metrics and cost for. See `model_source`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("modelSource")]
        public Output<Outputs.InferenceProfileModelSource?> ModelSource { get; private set; } = null!;

        /// <summary>
        /// A list of information about each model in the inference profile. See `models`.
        /// </summary>
        [Output("models")]
        public Output<ImmutableArray<Outputs.InferenceProfileModel>> Models { get; private set; } = null!;

        /// <summary>
        /// The name of the inference profile.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The status of the inference profile. `ACTIVE` means that the inference profile is available to use.
        /// </summary>
        [Output("status")]
        public Output<string> Status { get; private set; } = null!;

        /// <summary>
        /// Key-value mapping of resource tags for the inference profile.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.InferenceProfileTimeouts?> Timeouts { get; private set; } = null!;

        /// <summary>
        /// The type of the inference profile. `SYSTEM_DEFINED` means that the inference profile is defined by Amazon Bedrock. `APPLICATION` means that the inference profile is defined by the user.
        /// </summary>
        [Output("type")]
        public Output<string> Type { get; private set; } = null!;

        /// <summary>
        /// The time at which the inference profile was last updated.
        /// </summary>
        [Output("updatedAt")]
        public Output<string> UpdatedAt { get; private set; } = null!;


        /// <summary>
        /// Create a InferenceProfile resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public InferenceProfile(string name, InferenceProfileArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:bedrock/inferenceProfile:InferenceProfile", name, args ?? new InferenceProfileArgs(), MakeResourceOptions(options, ""))
        {
        }

        private InferenceProfile(string name, Input<string> id, InferenceProfileState? state = null, CustomResourceOptions? options = null)
            : base("aws:bedrock/inferenceProfile:InferenceProfile", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing InferenceProfile resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static InferenceProfile Get(string name, Input<string> id, InferenceProfileState? state = null, CustomResourceOptions? options = null)
        {
            return new InferenceProfile(name, id, state, options);
        }
    }

    public sealed class InferenceProfileArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The description of the inference profile.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The source of the model this inference profile will track metrics and cost for. See `model_source`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("modelSource")]
        public Input<Inputs.InferenceProfileModelSourceArgs>? ModelSource { get; set; }

        /// <summary>
        /// The name of the inference profile.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags for the inference profile.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("timeouts")]
        public Input<Inputs.InferenceProfileTimeoutsArgs>? Timeouts { get; set; }

        public InferenceProfileArgs()
        {
        }
        public static new InferenceProfileArgs Empty => new InferenceProfileArgs();
    }

    public sealed class InferenceProfileState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the inference profile.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The time at which the inference profile was created.
        /// </summary>
        [Input("createdAt")]
        public Input<string>? CreatedAt { get; set; }

        /// <summary>
        /// The description of the inference profile.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The source of the model this inference profile will track metrics and cost for. See `model_source`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("modelSource")]
        public Input<Inputs.InferenceProfileModelSourceGetArgs>? ModelSource { get; set; }

        [Input("models")]
        private InputList<Inputs.InferenceProfileModelGetArgs>? _models;

        /// <summary>
        /// A list of information about each model in the inference profile. See `models`.
        /// </summary>
        public InputList<Inputs.InferenceProfileModelGetArgs> Models
        {
            get => _models ?? (_models = new InputList<Inputs.InferenceProfileModelGetArgs>());
            set => _models = value;
        }

        /// <summary>
        /// The name of the inference profile.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The status of the inference profile. `ACTIVE` means that the inference profile is available to use.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags for the inference profile.
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

        [Input("timeouts")]
        public Input<Inputs.InferenceProfileTimeoutsGetArgs>? Timeouts { get; set; }

        /// <summary>
        /// The type of the inference profile. `SYSTEM_DEFINED` means that the inference profile is defined by Amazon Bedrock. `APPLICATION` means that the inference profile is defined by the user.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        /// <summary>
        /// The time at which the inference profile was last updated.
        /// </summary>
        [Input("updatedAt")]
        public Input<string>? UpdatedAt { get; set; }

        public InferenceProfileState()
        {
        }
        public static new InferenceProfileState Empty => new InferenceProfileState();
    }
}
