// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Schemas
{
    /// <summary>
    /// Provides an EventBridge Schema Discoverer resource.
    /// 
    /// &gt; **Note:** EventBridge was formerly known as CloudWatch Events. The functionality is identical.
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
    ///     var messenger = new Aws.CloudWatch.EventBus("messenger", new()
    ///     {
    ///         Name = "chat-messages",
    ///     });
    /// 
    ///     var test = new Aws.Schemas.Discoverer("test", new()
    ///     {
    ///         SourceArn = messenger.Arn,
    ///         Description = "Auto discover event schemas",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import EventBridge discoverers using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:schemas/discoverer:Discoverer test 123
    /// ```
    /// </summary>
    [AwsResourceType("aws:schemas/discoverer:Discoverer")]
    public partial class Discoverer : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the discoverer.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The description of the discoverer. Maximum of 256 characters.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// The ARN of the event bus to discover event schemas on.
        /// </summary>
        [Output("sourceArn")]
        public Output<string> SourceArn { get; private set; } = null!;

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
        /// Create a Discoverer resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Discoverer(string name, DiscovererArgs args, CustomResourceOptions? options = null)
            : base("aws:schemas/discoverer:Discoverer", name, args ?? new DiscovererArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Discoverer(string name, Input<string> id, DiscovererState? state = null, CustomResourceOptions? options = null)
            : base("aws:schemas/discoverer:Discoverer", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Discoverer resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Discoverer Get(string name, Input<string> id, DiscovererState? state = null, CustomResourceOptions? options = null)
        {
            return new Discoverer(name, id, state, options);
        }
    }

    public sealed class DiscovererArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The description of the discoverer. Maximum of 256 characters.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The ARN of the event bus to discover event schemas on.
        /// </summary>
        [Input("sourceArn", required: true)]
        public Input<string> SourceArn { get; set; } = null!;

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

        public DiscovererArgs()
        {
        }
        public static new DiscovererArgs Empty => new DiscovererArgs();
    }

    public sealed class DiscovererState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the discoverer.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The description of the discoverer. Maximum of 256 characters.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The ARN of the event bus to discover event schemas on.
        /// </summary>
        [Input("sourceArn")]
        public Input<string>? SourceArn { get; set; }

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

        public DiscovererState()
        {
        }
        public static new DiscovererState Empty => new DiscovererState();
    }
}
