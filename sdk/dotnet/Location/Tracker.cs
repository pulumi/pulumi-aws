// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Location
{
    /// <summary>
    /// Provides a Location Service Tracker.
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
    ///     var example = new Aws.Location.Tracker("example", new()
    ///     {
    ///         TrackerName = "example",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_location_tracker` resources using the tracker name. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:location/tracker:Tracker example example
    /// ```
    /// </summary>
    [AwsResourceType("aws:location/tracker:Tracker")]
    public partial class Tracker : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The timestamp for when the tracker resource was created in ISO 8601 format.
        /// </summary>
        [Output("createTime")]
        public Output<string> CreateTime { get; private set; } = null!;

        /// <summary>
        /// The optional description for the tracker resource.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// A key identifier for an AWS KMS customer managed key assigned to the Amazon Location resource.
        /// </summary>
        [Output("kmsKeyId")]
        public Output<string?> KmsKeyId { get; private set; } = null!;

        /// <summary>
        /// The position filtering method of the tracker resource. Valid values: `TimeBased`, `DistanceBased`, `AccuracyBased`. Default: `TimeBased`.
        /// </summary>
        [Output("positionFiltering")]
        public Output<string?> PositionFiltering { get; private set; } = null!;

        /// <summary>
        /// Key-value tags for the tracker. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) for the tracker resource. Used when you need to specify a resource across all AWS.
        /// </summary>
        [Output("trackerArn")]
        public Output<string> TrackerArn { get; private set; } = null!;

        /// <summary>
        /// The name of the tracker resource.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("trackerName")]
        public Output<string> TrackerName { get; private set; } = null!;

        /// <summary>
        /// The timestamp for when the tracker resource was last updated in ISO 8601 format.
        /// </summary>
        [Output("updateTime")]
        public Output<string> UpdateTime { get; private set; } = null!;


        /// <summary>
        /// Create a Tracker resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Tracker(string name, TrackerArgs args, CustomResourceOptions? options = null)
            : base("aws:location/tracker:Tracker", name, args ?? new TrackerArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Tracker(string name, Input<string> id, TrackerState? state = null, CustomResourceOptions? options = null)
            : base("aws:location/tracker:Tracker", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Tracker resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Tracker Get(string name, Input<string> id, TrackerState? state = null, CustomResourceOptions? options = null)
        {
            return new Tracker(name, id, state, options);
        }
    }

    public sealed class TrackerArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The optional description for the tracker resource.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// A key identifier for an AWS KMS customer managed key assigned to the Amazon Location resource.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// The position filtering method of the tracker resource. Valid values: `TimeBased`, `DistanceBased`, `AccuracyBased`. Default: `TimeBased`.
        /// </summary>
        [Input("positionFiltering")]
        public Input<string>? PositionFiltering { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value tags for the tracker. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The name of the tracker resource.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("trackerName", required: true)]
        public Input<string> TrackerName { get; set; } = null!;

        public TrackerArgs()
        {
        }
        public static new TrackerArgs Empty => new TrackerArgs();
    }

    public sealed class TrackerState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The timestamp for when the tracker resource was created in ISO 8601 format.
        /// </summary>
        [Input("createTime")]
        public Input<string>? CreateTime { get; set; }

        /// <summary>
        /// The optional description for the tracker resource.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// A key identifier for an AWS KMS customer managed key assigned to the Amazon Location resource.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// The position filtering method of the tracker resource. Valid values: `TimeBased`, `DistanceBased`, `AccuracyBased`. Default: `TimeBased`.
        /// </summary>
        [Input("positionFiltering")]
        public Input<string>? PositionFiltering { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value tags for the tracker. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
        /// The Amazon Resource Name (ARN) for the tracker resource. Used when you need to specify a resource across all AWS.
        /// </summary>
        [Input("trackerArn")]
        public Input<string>? TrackerArn { get; set; }

        /// <summary>
        /// The name of the tracker resource.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("trackerName")]
        public Input<string>? TrackerName { get; set; }

        /// <summary>
        /// The timestamp for when the tracker resource was last updated in ISO 8601 format.
        /// </summary>
        [Input("updateTime")]
        public Input<string>? UpdateTime { get; set; }

        public TrackerState()
        {
        }
        public static new TrackerState Empty => new TrackerState();
    }
}
