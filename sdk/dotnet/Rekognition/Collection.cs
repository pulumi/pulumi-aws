// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Rekognition
{
    /// <summary>
    /// Resource for managing an AWS Rekognition Collection.
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
    ///     var example = new Aws.Rekognition.Collection("example", new()
    ///     {
    ///         CollectionId = "my-collection",
    ///         Tags = 
    ///         {
    ///             { "example", "1" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Rekognition Collection using the `example_id_arg`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:rekognition/collection:Collection example collection-id-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:rekognition/collection:Collection")]
    public partial class Collection : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the Collection.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The name of the collection
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("collectionId")]
        public Output<string> CollectionId { get; private set; } = null!;

        /// <summary>
        /// The Face Model Version that the collection was initialized with
        /// </summary>
        [Output("faceModelVersion")]
        public Output<string> FaceModelVersion { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.CollectionTimeouts?> Timeouts { get; private set; } = null!;


        /// <summary>
        /// Create a Collection resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Collection(string name, CollectionArgs args, CustomResourceOptions? options = null)
            : base("aws:rekognition/collection:Collection", name, args ?? new CollectionArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Collection(string name, Input<string> id, CollectionState? state = null, CustomResourceOptions? options = null)
            : base("aws:rekognition/collection:Collection", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Collection resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Collection Get(string name, Input<string> id, CollectionState? state = null, CustomResourceOptions? options = null)
        {
            return new Collection(name, id, state, options);
        }
    }

    public sealed class CollectionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the collection
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("collectionId", required: true)]
        public Input<string> CollectionId { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("timeouts")]
        public Input<Inputs.CollectionTimeoutsArgs>? Timeouts { get; set; }

        public CollectionArgs()
        {
        }
        public static new CollectionArgs Empty => new CollectionArgs();
    }

    public sealed class CollectionState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the Collection.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The name of the collection
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("collectionId")]
        public Input<string>? CollectionId { get; set; }

        /// <summary>
        /// The Face Model Version that the collection was initialized with
        /// </summary>
        [Input("faceModelVersion")]
        public Input<string>? FaceModelVersion { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        [Input("timeouts")]
        public Input<Inputs.CollectionTimeoutsGetArgs>? Timeouts { get; set; }

        public CollectionState()
        {
        }
        public static new CollectionState Empty => new CollectionState();
    }
}
