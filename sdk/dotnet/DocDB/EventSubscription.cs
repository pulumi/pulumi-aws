// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DocDB
{
    /// <summary>
    /// Provides a DocumentDB event subscription resource.
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
    ///     var example = new Aws.DocDB.Cluster("example", new()
    ///     {
    ///         ClusterIdentifier = "example",
    ///         AvailabilityZones = new[]
    ///         {
    ///             available.Names[0],
    ///             available.Names[1],
    ///             available.Names[2],
    ///         },
    ///         MasterUsername = "foo",
    ///         MasterPassword = "mustbeeightcharaters",
    ///         SkipFinalSnapshot = true,
    ///     });
    /// 
    ///     var exampleTopic = new Aws.Sns.Topic("example", new()
    ///     {
    ///         Name = "example-events",
    ///     });
    /// 
    ///     var exampleEventSubscription = new Aws.DocDB.EventSubscription("example", new()
    ///     {
    ///         Name = "example",
    ///         Enabled = true,
    ///         EventCategories = new[]
    ///         {
    ///             "creation",
    ///             "failure",
    ///         },
    ///         SourceType = "db-cluster",
    ///         SourceIds = new[]
    ///         {
    ///             example.Id,
    ///         },
    ///         SnsTopicArn = exampleTopic.Arn,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import DocumentDB Event Subscriptions using the `name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:docdb/eventSubscription:EventSubscription example event-sub
    /// ```
    /// </summary>
    [AwsResourceType("aws:docdb/eventSubscription:EventSubscription")]
    public partial class EventSubscription : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name of the DocumentDB event notification subscription
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The AWS customer account associated with the DocumentDB event notification subscription
        /// </summary>
        [Output("customerAwsId")]
        public Output<string> CustomerAwsId { get; private set; } = null!;

        /// <summary>
        /// A boolean flag to enable/disable the subscription. Defaults to true.
        /// </summary>
        [Output("enabled")]
        public Output<bool?> Enabled { get; private set; } = null!;

        /// <summary>
        /// A list of event categories for a SourceType that you want to subscribe to. See https://docs.aws.amazon.com/documentdb/latest/developerguide/API_Event.html or run `aws docdb describe-event-categories`.
        /// </summary>
        [Output("eventCategories")]
        public Output<ImmutableArray<string>> EventCategories { get; private set; } = null!;

        /// <summary>
        /// The name of the DocumentDB event subscription. By default generated by this provider.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The name of the DocumentDB event subscription. Conflicts with `name`.
        /// </summary>
        [Output("namePrefix")]
        public Output<string> NamePrefix { get; private set; } = null!;

        [Output("snsTopicArn")]
        public Output<string> SnsTopicArn { get; private set; } = null!;

        /// <summary>
        /// A list of identifiers of the event sources for which events will be returned. If not specified, then all sources are included in the response. If specified, a source_type must also be specified.
        /// </summary>
        [Output("sourceIds")]
        public Output<ImmutableArray<string>> SourceIds { get; private set; } = null!;

        /// <summary>
        /// The type of source that will be generating the events. Valid options are `db-instance`, `db-cluster`, `db-parameter-group`, `db-security-group`,` db-cluster-snapshot`. If not set, all sources will be subscribed to.
        /// </summary>
        [Output("sourceType")]
        public Output<string?> SourceType { get; private set; } = null!;

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
        /// Create a EventSubscription resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public EventSubscription(string name, EventSubscriptionArgs args, CustomResourceOptions? options = null)
            : base("aws:docdb/eventSubscription:EventSubscription", name, args ?? new EventSubscriptionArgs(), MakeResourceOptions(options, ""))
        {
        }

        private EventSubscription(string name, Input<string> id, EventSubscriptionState? state = null, CustomResourceOptions? options = null)
            : base("aws:docdb/eventSubscription:EventSubscription", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing EventSubscription resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static EventSubscription Get(string name, Input<string> id, EventSubscriptionState? state = null, CustomResourceOptions? options = null)
        {
            return new EventSubscription(name, id, state, options);
        }
    }

    public sealed class EventSubscriptionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A boolean flag to enable/disable the subscription. Defaults to true.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        [Input("eventCategories")]
        private InputList<string>? _eventCategories;

        /// <summary>
        /// A list of event categories for a SourceType that you want to subscribe to. See https://docs.aws.amazon.com/documentdb/latest/developerguide/API_Event.html or run `aws docdb describe-event-categories`.
        /// </summary>
        public InputList<string> EventCategories
        {
            get => _eventCategories ?? (_eventCategories = new InputList<string>());
            set => _eventCategories = value;
        }

        /// <summary>
        /// The name of the DocumentDB event subscription. By default generated by this provider.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The name of the DocumentDB event subscription. Conflicts with `name`.
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        [Input("snsTopicArn", required: true)]
        public Input<string> SnsTopicArn { get; set; } = null!;

        [Input("sourceIds")]
        private InputList<string>? _sourceIds;

        /// <summary>
        /// A list of identifiers of the event sources for which events will be returned. If not specified, then all sources are included in the response. If specified, a source_type must also be specified.
        /// </summary>
        public InputList<string> SourceIds
        {
            get => _sourceIds ?? (_sourceIds = new InputList<string>());
            set => _sourceIds = value;
        }

        /// <summary>
        /// The type of source that will be generating the events. Valid options are `db-instance`, `db-cluster`, `db-parameter-group`, `db-security-group`,` db-cluster-snapshot`. If not set, all sources will be subscribed to.
        /// </summary>
        [Input("sourceType")]
        public Input<string>? SourceType { get; set; }

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

        public EventSubscriptionArgs()
        {
        }
        public static new EventSubscriptionArgs Empty => new EventSubscriptionArgs();
    }

    public sealed class EventSubscriptionState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name of the DocumentDB event notification subscription
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The AWS customer account associated with the DocumentDB event notification subscription
        /// </summary>
        [Input("customerAwsId")]
        public Input<string>? CustomerAwsId { get; set; }

        /// <summary>
        /// A boolean flag to enable/disable the subscription. Defaults to true.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        [Input("eventCategories")]
        private InputList<string>? _eventCategories;

        /// <summary>
        /// A list of event categories for a SourceType that you want to subscribe to. See https://docs.aws.amazon.com/documentdb/latest/developerguide/API_Event.html or run `aws docdb describe-event-categories`.
        /// </summary>
        public InputList<string> EventCategories
        {
            get => _eventCategories ?? (_eventCategories = new InputList<string>());
            set => _eventCategories = value;
        }

        /// <summary>
        /// The name of the DocumentDB event subscription. By default generated by this provider.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The name of the DocumentDB event subscription. Conflicts with `name`.
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        [Input("snsTopicArn")]
        public Input<string>? SnsTopicArn { get; set; }

        [Input("sourceIds")]
        private InputList<string>? _sourceIds;

        /// <summary>
        /// A list of identifiers of the event sources for which events will be returned. If not specified, then all sources are included in the response. If specified, a source_type must also be specified.
        /// </summary>
        public InputList<string> SourceIds
        {
            get => _sourceIds ?? (_sourceIds = new InputList<string>());
            set => _sourceIds = value;
        }

        /// <summary>
        /// The type of source that will be generating the events. Valid options are `db-instance`, `db-cluster`, `db-parameter-group`, `db-security-group`,` db-cluster-snapshot`. If not set, all sources will be subscribed to.
        /// </summary>
        [Input("sourceType")]
        public Input<string>? SourceType { get; set; }

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

        public EventSubscriptionState()
        {
        }
        public static new EventSubscriptionState Empty => new EventSubscriptionState();
    }
}
