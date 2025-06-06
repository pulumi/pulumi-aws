// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SesV2
{
    /// <summary>
    /// Resource for managing an AWS SESv2 (Simple Email V2) Contact List.
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
    ///     var example = new Aws.SesV2.ContactList("example", new()
    ///     {
    ///         ContactListName = "example",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Extended Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SesV2.ContactList("example", new()
    ///     {
    ///         ContactListName = "example",
    ///         Description = "description",
    ///         Topics = new[]
    ///         {
    ///             new Aws.SesV2.Inputs.ContactListTopicArgs
    ///             {
    ///                 DefaultSubscriptionStatus = "OPT_IN",
    ///                 Description = "topic description",
    ///                 DisplayName = "Example Topic",
    ///                 TopicName = "example-topic",
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import SESv2 (Simple Email V2) Contact List using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:sesv2/contactList:ContactList example example
    /// ```
    /// </summary>
    [AwsResourceType("aws:sesv2/contactList:ContactList")]
    public partial class ContactList : global::Pulumi.CustomResource
    {
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Name of the contact list.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("contactListName")]
        public Output<string> ContactListName { get; private set; } = null!;

        /// <summary>
        /// Timestamp noting when the contact list was created in ISO 8601 format.
        /// </summary>
        [Output("createdTimestamp")]
        public Output<string> CreatedTimestamp { get; private set; } = null!;

        /// <summary>
        /// Description of what the contact list is about.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Timestamp noting the last time the contact list was updated in ISO 8601 format.
        /// </summary>
        [Output("lastUpdatedTimestamp")]
        public Output<string> LastUpdatedTimestamp { get; private set; } = null!;

        /// <summary>
        /// Key-value map of resource tags for the contact list. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// Configuration block(s) with topic for the contact list. Detailed below.
        /// </summary>
        [Output("topics")]
        public Output<ImmutableArray<Outputs.ContactListTopic>> Topics { get; private set; } = null!;


        /// <summary>
        /// Create a ContactList resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ContactList(string name, ContactListArgs args, CustomResourceOptions? options = null)
            : base("aws:sesv2/contactList:ContactList", name, args ?? new ContactListArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ContactList(string name, Input<string> id, ContactListState? state = null, CustomResourceOptions? options = null)
            : base("aws:sesv2/contactList:ContactList", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ContactList resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ContactList Get(string name, Input<string> id, ContactListState? state = null, CustomResourceOptions? options = null)
        {
            return new ContactList(name, id, state, options);
        }
    }

    public sealed class ContactListArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the contact list.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("contactListName", required: true)]
        public Input<string> ContactListName { get; set; } = null!;

        /// <summary>
        /// Description of what the contact list is about.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags for the contact list. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("topics")]
        private InputList<Inputs.ContactListTopicArgs>? _topics;

        /// <summary>
        /// Configuration block(s) with topic for the contact list. Detailed below.
        /// </summary>
        public InputList<Inputs.ContactListTopicArgs> Topics
        {
            get => _topics ?? (_topics = new InputList<Inputs.ContactListTopicArgs>());
            set => _topics = value;
        }

        public ContactListArgs()
        {
        }
        public static new ContactListArgs Empty => new ContactListArgs();
    }

    public sealed class ContactListState : global::Pulumi.ResourceArgs
    {
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Name of the contact list.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("contactListName")]
        public Input<string>? ContactListName { get; set; }

        /// <summary>
        /// Timestamp noting when the contact list was created in ISO 8601 format.
        /// </summary>
        [Input("createdTimestamp")]
        public Input<string>? CreatedTimestamp { get; set; }

        /// <summary>
        /// Description of what the contact list is about.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Timestamp noting the last time the contact list was updated in ISO 8601 format.
        /// </summary>
        [Input("lastUpdatedTimestamp")]
        public Input<string>? LastUpdatedTimestamp { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags for the contact list. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        [Input("topics")]
        private InputList<Inputs.ContactListTopicGetArgs>? _topics;

        /// <summary>
        /// Configuration block(s) with topic for the contact list. Detailed below.
        /// </summary>
        public InputList<Inputs.ContactListTopicGetArgs> Topics
        {
            get => _topics ?? (_topics = new InputList<Inputs.ContactListTopicGetArgs>());
            set => _topics = value;
        }

        public ContactListState()
        {
        }
        public static new ContactListState Empty => new ContactListState();
    }
}
