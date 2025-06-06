// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudTrail
{
    /// <summary>
    /// Provides a CloudTrail Event Data Store.
    /// 
    /// More information about event data stores can be found in the [Event Data Store User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/query-event-data-store.html).
    /// 
    /// &gt; **Tip:** For an organization event data store you must create this resource in the management account.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic
    /// 
    /// The most simple event data store configuration requires us to only set the `name` attribute. The event data store will automatically capture all management events. To capture management events from all the regions, `multi_region_enabled` must be `true`.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.CloudTrail.EventDataStore("example", new()
    ///     {
    ///         Name = "example-event-data-store",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Data Event Logging
    /// 
    /// CloudTrail can log [Data Events](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/logging-data-events-with-cloudtrail.html) for certain services such as S3 bucket objects and Lambda function invocations. Additional information about data event configuration can be found in the following links:
    /// 
    /// - [CloudTrail API AdvancedFieldSelector documentation](https://docs.aws.amazon.com/awscloudtrail/latest/APIReference/API_AdvancedFieldSelector.html)
    /// 
    /// ### Log all DynamoDB PutEvent actions for a specific DynamoDB table
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var table = Aws.DynamoDB.GetTable.Invoke(new()
    ///     {
    ///         Name = "not-important-dynamodb-table",
    ///     });
    /// 
    ///     var example = new Aws.CloudTrail.EventDataStore("example", new()
    ///     {
    ///         AdvancedEventSelectors = new[]
    ///         {
    ///             new Aws.CloudTrail.Inputs.EventDataStoreAdvancedEventSelectorArgs
    ///             {
    ///                 Name = "Log all DynamoDB PutEvent actions for a specific DynamoDB table",
    ///                 FieldSelectors = new[]
    ///                 {
    ///                     new Aws.CloudTrail.Inputs.EventDataStoreAdvancedEventSelectorFieldSelectorArgs
    ///                     {
    ///                         Field = "eventCategory",
    ///                         Equals = new[]
    ///                         {
    ///                             "Data",
    ///                         },
    ///                     },
    ///                     new Aws.CloudTrail.Inputs.EventDataStoreAdvancedEventSelectorFieldSelectorArgs
    ///                     {
    ///                         Field = "resources.type",
    ///                         Equals = new[]
    ///                         {
    ///                             "AWS::DynamoDB::Table",
    ///                         },
    ///                     },
    ///                     new Aws.CloudTrail.Inputs.EventDataStoreAdvancedEventSelectorFieldSelectorArgs
    ///                     {
    ///                         Field = "eventName",
    ///                         Equals = new[]
    ///                         {
    ///                             "PutItem",
    ///                         },
    ///                     },
    ///                     new Aws.CloudTrail.Inputs.EventDataStoreAdvancedEventSelectorFieldSelectorArgs
    ///                     {
    ///                         Field = "resources.ARN",
    ///                         Equals = new[]
    ///                         {
    ///                             table.Apply(getTableResult =&gt; getTableResult.Arn),
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import event data stores using their `arn`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:cloudtrail/eventDataStore:EventDataStore example arn:aws:cloudtrail:us-east-1:123456789123:eventdatastore/22333815-4414-412c-b155-dd254033gfhf
    /// ```
    /// </summary>
    [AwsResourceType("aws:cloudtrail/eventDataStore:EventDataStore")]
    public partial class EventDataStore : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The advanced event selectors to use to select the events for the data store. For more information about how to use advanced event selectors, see [Log events by using advanced event selectors](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/logging-data-events-with-cloudtrail.html#creating-data-event-selectors-advanced) in the CloudTrail User Guide.
        /// </summary>
        [Output("advancedEventSelectors")]
        public Output<ImmutableArray<Outputs.EventDataStoreAdvancedEventSelector>> AdvancedEventSelectors { get; private set; } = null!;

        /// <summary>
        /// ARN of the event data store.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The billing mode for the event data store. The valid values are `EXTENDABLE_RETENTION_PRICING` and `FIXED_RETENTION_PRICING`. Defaults to `EXTENDABLE_RETENTION_PRICING`.
        /// </summary>
        [Output("billingMode")]
        public Output<string?> BillingMode { get; private set; } = null!;

        /// <summary>
        /// Specifies the AWS KMS key ID to use to encrypt the events delivered by CloudTrail. The value can be an alias name prefixed by alias/, a fully specified ARN to an alias, a fully specified ARN to a key, or a globally unique identifier.
        /// </summary>
        [Output("kmsKeyId")]
        public Output<string?> KmsKeyId { get; private set; } = null!;

        /// <summary>
        /// Specifies whether the event data store includes events from all regions, or only from the region in which the event data store is created. Default: `true`.
        /// </summary>
        [Output("multiRegionEnabled")]
        public Output<bool?> MultiRegionEnabled { get; private set; } = null!;

        /// <summary>
        /// The name of the event data store.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Specifies whether an event data store collects events logged for an organization in AWS Organizations. Default: `false`.
        /// </summary>
        [Output("organizationEnabled")]
        public Output<bool?> OrganizationEnabled { get; private set; } = null!;

        /// <summary>
        /// The retention period of the event data store, in days. You can set a retention period of up to 2555 days, the equivalent of seven years. Default: `2555`.
        /// </summary>
        [Output("retentionPeriod")]
        public Output<int?> RetentionPeriod { get; private set; } = null!;

        /// <summary>
        /// Specifies whether to stop ingesting new events into the event data store. If set to `true`, ingestion is suspended while maintaining the ability to query existing events. If set to `false`, ingestion is active.
        /// </summary>
        [Output("suspend")]
        public Output<string?> Suspend { get; private set; } = null!;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// Specifies whether termination protection is enabled for the event data store. If termination protection is enabled, you cannot delete the event data store until termination protection is disabled. Default: `true`.
        /// </summary>
        [Output("terminationProtectionEnabled")]
        public Output<bool?> TerminationProtectionEnabled { get; private set; } = null!;


        /// <summary>
        /// Create a EventDataStore resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public EventDataStore(string name, EventDataStoreArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:cloudtrail/eventDataStore:EventDataStore", name, args ?? new EventDataStoreArgs(), MakeResourceOptions(options, ""))
        {
        }

        private EventDataStore(string name, Input<string> id, EventDataStoreState? state = null, CustomResourceOptions? options = null)
            : base("aws:cloudtrail/eventDataStore:EventDataStore", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing EventDataStore resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static EventDataStore Get(string name, Input<string> id, EventDataStoreState? state = null, CustomResourceOptions? options = null)
        {
            return new EventDataStore(name, id, state, options);
        }
    }

    public sealed class EventDataStoreArgs : global::Pulumi.ResourceArgs
    {
        [Input("advancedEventSelectors")]
        private InputList<Inputs.EventDataStoreAdvancedEventSelectorArgs>? _advancedEventSelectors;

        /// <summary>
        /// The advanced event selectors to use to select the events for the data store. For more information about how to use advanced event selectors, see [Log events by using advanced event selectors](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/logging-data-events-with-cloudtrail.html#creating-data-event-selectors-advanced) in the CloudTrail User Guide.
        /// </summary>
        public InputList<Inputs.EventDataStoreAdvancedEventSelectorArgs> AdvancedEventSelectors
        {
            get => _advancedEventSelectors ?? (_advancedEventSelectors = new InputList<Inputs.EventDataStoreAdvancedEventSelectorArgs>());
            set => _advancedEventSelectors = value;
        }

        /// <summary>
        /// The billing mode for the event data store. The valid values are `EXTENDABLE_RETENTION_PRICING` and `FIXED_RETENTION_PRICING`. Defaults to `EXTENDABLE_RETENTION_PRICING`.
        /// </summary>
        [Input("billingMode")]
        public Input<string>? BillingMode { get; set; }

        /// <summary>
        /// Specifies the AWS KMS key ID to use to encrypt the events delivered by CloudTrail. The value can be an alias name prefixed by alias/, a fully specified ARN to an alias, a fully specified ARN to a key, or a globally unique identifier.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// Specifies whether the event data store includes events from all regions, or only from the region in which the event data store is created. Default: `true`.
        /// </summary>
        [Input("multiRegionEnabled")]
        public Input<bool>? MultiRegionEnabled { get; set; }

        /// <summary>
        /// The name of the event data store.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Specifies whether an event data store collects events logged for an organization in AWS Organizations. Default: `false`.
        /// </summary>
        [Input("organizationEnabled")]
        public Input<bool>? OrganizationEnabled { get; set; }

        /// <summary>
        /// The retention period of the event data store, in days. You can set a retention period of up to 2555 days, the equivalent of seven years. Default: `2555`.
        /// </summary>
        [Input("retentionPeriod")]
        public Input<int>? RetentionPeriod { get; set; }

        /// <summary>
        /// Specifies whether to stop ingesting new events into the event data store. If set to `true`, ingestion is suspended while maintaining the ability to query existing events. If set to `false`, ingestion is active.
        /// </summary>
        [Input("suspend")]
        public Input<string>? Suspend { get; set; }

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
        /// Specifies whether termination protection is enabled for the event data store. If termination protection is enabled, you cannot delete the event data store until termination protection is disabled. Default: `true`.
        /// </summary>
        [Input("terminationProtectionEnabled")]
        public Input<bool>? TerminationProtectionEnabled { get; set; }

        public EventDataStoreArgs()
        {
        }
        public static new EventDataStoreArgs Empty => new EventDataStoreArgs();
    }

    public sealed class EventDataStoreState : global::Pulumi.ResourceArgs
    {
        [Input("advancedEventSelectors")]
        private InputList<Inputs.EventDataStoreAdvancedEventSelectorGetArgs>? _advancedEventSelectors;

        /// <summary>
        /// The advanced event selectors to use to select the events for the data store. For more information about how to use advanced event selectors, see [Log events by using advanced event selectors](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/logging-data-events-with-cloudtrail.html#creating-data-event-selectors-advanced) in the CloudTrail User Guide.
        /// </summary>
        public InputList<Inputs.EventDataStoreAdvancedEventSelectorGetArgs> AdvancedEventSelectors
        {
            get => _advancedEventSelectors ?? (_advancedEventSelectors = new InputList<Inputs.EventDataStoreAdvancedEventSelectorGetArgs>());
            set => _advancedEventSelectors = value;
        }

        /// <summary>
        /// ARN of the event data store.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The billing mode for the event data store. The valid values are `EXTENDABLE_RETENTION_PRICING` and `FIXED_RETENTION_PRICING`. Defaults to `EXTENDABLE_RETENTION_PRICING`.
        /// </summary>
        [Input("billingMode")]
        public Input<string>? BillingMode { get; set; }

        /// <summary>
        /// Specifies the AWS KMS key ID to use to encrypt the events delivered by CloudTrail. The value can be an alias name prefixed by alias/, a fully specified ARN to an alias, a fully specified ARN to a key, or a globally unique identifier.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        /// <summary>
        /// Specifies whether the event data store includes events from all regions, or only from the region in which the event data store is created. Default: `true`.
        /// </summary>
        [Input("multiRegionEnabled")]
        public Input<bool>? MultiRegionEnabled { get; set; }

        /// <summary>
        /// The name of the event data store.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Specifies whether an event data store collects events logged for an organization in AWS Organizations. Default: `false`.
        /// </summary>
        [Input("organizationEnabled")]
        public Input<bool>? OrganizationEnabled { get; set; }

        /// <summary>
        /// The retention period of the event data store, in days. You can set a retention period of up to 2555 days, the equivalent of seven years. Default: `2555`.
        /// </summary>
        [Input("retentionPeriod")]
        public Input<int>? RetentionPeriod { get; set; }

        /// <summary>
        /// Specifies whether to stop ingesting new events into the event data store. If set to `true`, ingestion is suspended while maintaining the ability to query existing events. If set to `false`, ingestion is active.
        /// </summary>
        [Input("suspend")]
        public Input<string>? Suspend { get; set; }

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
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        /// <summary>
        /// Specifies whether termination protection is enabled for the event data store. If termination protection is enabled, you cannot delete the event data store until termination protection is disabled. Default: `true`.
        /// </summary>
        [Input("terminationProtectionEnabled")]
        public Input<bool>? TerminationProtectionEnabled { get; set; }

        public EventDataStoreState()
        {
        }
        public static new EventDataStoreState Empty => new EventDataStoreState();
    }
}
