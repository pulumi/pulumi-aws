// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.FinSpace
{
    /// <summary>
    /// Resource for managing an AWS FinSpace Kx Dataview.
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
    ///     var example = new Aws.FinSpace.KxDataview("example", new()
    ///     {
    ///         Name = "my-tf-kx-dataview",
    ///         EnvironmentId = exampleAwsFinspaceKxEnvironment.Id,
    ///         DatabaseName = exampleAwsFinspaceKxDatabase.Name,
    ///         AvailabilityZoneId = "use1-az2",
    ///         Description = "Terraform managed Kx Dataview",
    ///         AzMode = "SINGLE",
    ///         AutoUpdate = true,
    ///         SegmentConfigurations = new[]
    ///         {
    ///             new Aws.FinSpace.Inputs.KxDataviewSegmentConfigurationArgs
    ///             {
    ///                 VolumeName = exampleAwsFinspaceKxVolume.Name,
    ///                 DbPaths = new[]
    ///                 {
    ///                     "/*",
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
    /// Using `pulumi import`, import an AWS FinSpace Kx Cluster using the `id` (environment ID and cluster name, comma-delimited). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:finspace/kxDataview:KxDataview example n3ceo7wqxoxcti5tujqwzs,my-tf-kx-database,my-tf-kx-dataview
    /// ```
    /// </summary>
    [AwsResourceType("aws:finspace/kxDataview:KxDataview")]
    public partial class KxDataview : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Amazon Resource Name (ARN) identifier of the KX dataview.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The option to specify whether you want to apply all the future additions and corrections automatically to the dataview, when you ingest new changesets. The default value is false.
        /// </summary>
        [Output("autoUpdate")]
        public Output<bool> AutoUpdate { get; private set; } = null!;

        /// <summary>
        /// The identifier of the availability zones. If attaching a volume, the volume must be in the same availability zone as the dataview that you are attaching to.
        /// </summary>
        [Output("availabilityZoneId")]
        public Output<string?> AvailabilityZoneId { get; private set; } = null!;

        /// <summary>
        /// The number of availability zones you want to assign per cluster. This can be one of the following:
        /// * `SINGLE` - Assigns one availability zone per cluster.
        /// * `MULTI` - Assigns all the availability zones per cluster.
        /// </summary>
        [Output("azMode")]
        public Output<string> AzMode { get; private set; } = null!;

        /// <summary>
        /// A unique identifier of the changeset of the database that you want to use to ingest data.
        /// </summary>
        [Output("changesetId")]
        public Output<string?> ChangesetId { get; private set; } = null!;

        /// <summary>
        /// Timestamp at which the dataview was created in FinSpace. Value determined as epoch time in milliseconds. For example, the value for Monday, November 1, 2021 12:00:00 PM UTC is specified as 1635768000000.
        /// </summary>
        [Output("createdTimestamp")]
        public Output<string> CreatedTimestamp { get; private set; } = null!;

        /// <summary>
        /// The name of the database where you want to create a dataview.
        /// </summary>
        [Output("databaseName")]
        public Output<string> DatabaseName { get; private set; } = null!;

        /// <summary>
        /// A description for the dataview.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Unique identifier for the KX environment.
        /// </summary>
        [Output("environmentId")]
        public Output<string> EnvironmentId { get; private set; } = null!;

        /// <summary>
        /// The last time that the dataview was updated in FinSpace. The value is determined as epoch time in milliseconds. For example, the value for Monday, November 1, 2021 12:00:00 PM UTC is specified as 1635768000000.
        /// </summary>
        [Output("lastModifiedTimestamp")]
        public Output<string> LastModifiedTimestamp { get; private set; } = null!;

        /// <summary>
        /// A unique identifier for the dataview.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The option to specify whether you want to make the dataview writable to perform database maintenance. The following are some considerations related to writable dataviews.
        /// * You cannot create partial writable dataviews. When you create writeable dataviews you must provide the entire database path. You cannot perform updates on a writeable dataview. Hence, `auto_update` must be set as `false` if `read_write` is `true` for a dataview.
        /// * You must also use a unique volume for creating a writeable dataview. So, if you choose a volume that is already in use by another dataview, the dataview creation fails.
        /// * Once you create a dataview as writeable, you cannot change it to read-only. So, you cannot update the `read_write` parameter later.
        /// </summary>
        [Output("readWrite")]
        public Output<bool?> ReadWrite { get; private set; } = null!;

        /// <summary>
        /// The configuration that contains the database path of the data that you want to place on each selected volume. Each segment must have a unique database path for each volume. If you do not explicitly specify any database path for a volume, they are accessible from the cluster through the default S3/object store segment. See segment_configurations below.
        /// </summary>
        [Output("segmentConfigurations")]
        public Output<ImmutableArray<Outputs.KxDataviewSegmentConfiguration>> SegmentConfigurations { get; private set; } = null!;

        [Output("status")]
        public Output<string> Status { get; private set; } = null!;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a KxDataview resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public KxDataview(string name, KxDataviewArgs args, CustomResourceOptions? options = null)
            : base("aws:finspace/kxDataview:KxDataview", name, args ?? new KxDataviewArgs(), MakeResourceOptions(options, ""))
        {
        }

        private KxDataview(string name, Input<string> id, KxDataviewState? state = null, CustomResourceOptions? options = null)
            : base("aws:finspace/kxDataview:KxDataview", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing KxDataview resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static KxDataview Get(string name, Input<string> id, KxDataviewState? state = null, CustomResourceOptions? options = null)
        {
            return new KxDataview(name, id, state, options);
        }
    }

    public sealed class KxDataviewArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The option to specify whether you want to apply all the future additions and corrections automatically to the dataview, when you ingest new changesets. The default value is false.
        /// </summary>
        [Input("autoUpdate", required: true)]
        public Input<bool> AutoUpdate { get; set; } = null!;

        /// <summary>
        /// The identifier of the availability zones. If attaching a volume, the volume must be in the same availability zone as the dataview that you are attaching to.
        /// </summary>
        [Input("availabilityZoneId")]
        public Input<string>? AvailabilityZoneId { get; set; }

        /// <summary>
        /// The number of availability zones you want to assign per cluster. This can be one of the following:
        /// * `SINGLE` - Assigns one availability zone per cluster.
        /// * `MULTI` - Assigns all the availability zones per cluster.
        /// </summary>
        [Input("azMode", required: true)]
        public Input<string> AzMode { get; set; } = null!;

        /// <summary>
        /// A unique identifier of the changeset of the database that you want to use to ingest data.
        /// </summary>
        [Input("changesetId")]
        public Input<string>? ChangesetId { get; set; }

        /// <summary>
        /// The name of the database where you want to create a dataview.
        /// </summary>
        [Input("databaseName", required: true)]
        public Input<string> DatabaseName { get; set; } = null!;

        /// <summary>
        /// A description for the dataview.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Unique identifier for the KX environment.
        /// </summary>
        [Input("environmentId", required: true)]
        public Input<string> EnvironmentId { get; set; } = null!;

        /// <summary>
        /// A unique identifier for the dataview.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The option to specify whether you want to make the dataview writable to perform database maintenance. The following are some considerations related to writable dataviews.
        /// * You cannot create partial writable dataviews. When you create writeable dataviews you must provide the entire database path. You cannot perform updates on a writeable dataview. Hence, `auto_update` must be set as `false` if `read_write` is `true` for a dataview.
        /// * You must also use a unique volume for creating a writeable dataview. So, if you choose a volume that is already in use by another dataview, the dataview creation fails.
        /// * Once you create a dataview as writeable, you cannot change it to read-only. So, you cannot update the `read_write` parameter later.
        /// </summary>
        [Input("readWrite")]
        public Input<bool>? ReadWrite { get; set; }

        [Input("segmentConfigurations")]
        private InputList<Inputs.KxDataviewSegmentConfigurationArgs>? _segmentConfigurations;

        /// <summary>
        /// The configuration that contains the database path of the data that you want to place on each selected volume. Each segment must have a unique database path for each volume. If you do not explicitly specify any database path for a volume, they are accessible from the cluster through the default S3/object store segment. See segment_configurations below.
        /// </summary>
        public InputList<Inputs.KxDataviewSegmentConfigurationArgs> SegmentConfigurations
        {
            get => _segmentConfigurations ?? (_segmentConfigurations = new InputList<Inputs.KxDataviewSegmentConfigurationArgs>());
            set => _segmentConfigurations = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public KxDataviewArgs()
        {
        }
        public static new KxDataviewArgs Empty => new KxDataviewArgs();
    }

    public sealed class KxDataviewState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) identifier of the KX dataview.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The option to specify whether you want to apply all the future additions and corrections automatically to the dataview, when you ingest new changesets. The default value is false.
        /// </summary>
        [Input("autoUpdate")]
        public Input<bool>? AutoUpdate { get; set; }

        /// <summary>
        /// The identifier of the availability zones. If attaching a volume, the volume must be in the same availability zone as the dataview that you are attaching to.
        /// </summary>
        [Input("availabilityZoneId")]
        public Input<string>? AvailabilityZoneId { get; set; }

        /// <summary>
        /// The number of availability zones you want to assign per cluster. This can be one of the following:
        /// * `SINGLE` - Assigns one availability zone per cluster.
        /// * `MULTI` - Assigns all the availability zones per cluster.
        /// </summary>
        [Input("azMode")]
        public Input<string>? AzMode { get; set; }

        /// <summary>
        /// A unique identifier of the changeset of the database that you want to use to ingest data.
        /// </summary>
        [Input("changesetId")]
        public Input<string>? ChangesetId { get; set; }

        /// <summary>
        /// Timestamp at which the dataview was created in FinSpace. Value determined as epoch time in milliseconds. For example, the value for Monday, November 1, 2021 12:00:00 PM UTC is specified as 1635768000000.
        /// </summary>
        [Input("createdTimestamp")]
        public Input<string>? CreatedTimestamp { get; set; }

        /// <summary>
        /// The name of the database where you want to create a dataview.
        /// </summary>
        [Input("databaseName")]
        public Input<string>? DatabaseName { get; set; }

        /// <summary>
        /// A description for the dataview.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Unique identifier for the KX environment.
        /// </summary>
        [Input("environmentId")]
        public Input<string>? EnvironmentId { get; set; }

        /// <summary>
        /// The last time that the dataview was updated in FinSpace. The value is determined as epoch time in milliseconds. For example, the value for Monday, November 1, 2021 12:00:00 PM UTC is specified as 1635768000000.
        /// </summary>
        [Input("lastModifiedTimestamp")]
        public Input<string>? LastModifiedTimestamp { get; set; }

        /// <summary>
        /// A unique identifier for the dataview.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The option to specify whether you want to make the dataview writable to perform database maintenance. The following are some considerations related to writable dataviews.
        /// * You cannot create partial writable dataviews. When you create writeable dataviews you must provide the entire database path. You cannot perform updates on a writeable dataview. Hence, `auto_update` must be set as `false` if `read_write` is `true` for a dataview.
        /// * You must also use a unique volume for creating a writeable dataview. So, if you choose a volume that is already in use by another dataview, the dataview creation fails.
        /// * Once you create a dataview as writeable, you cannot change it to read-only. So, you cannot update the `read_write` parameter later.
        /// </summary>
        [Input("readWrite")]
        public Input<bool>? ReadWrite { get; set; }

        [Input("segmentConfigurations")]
        private InputList<Inputs.KxDataviewSegmentConfigurationGetArgs>? _segmentConfigurations;

        /// <summary>
        /// The configuration that contains the database path of the data that you want to place on each selected volume. Each segment must have a unique database path for each volume. If you do not explicitly specify any database path for a volume, they are accessible from the cluster through the default S3/object store segment. See segment_configurations below.
        /// </summary>
        public InputList<Inputs.KxDataviewSegmentConfigurationGetArgs> SegmentConfigurations
        {
            get => _segmentConfigurations ?? (_segmentConfigurations = new InputList<Inputs.KxDataviewSegmentConfigurationGetArgs>());
            set => _segmentConfigurations = value;
        }

        [Input("status")]
        public Input<string>? Status { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public KxDataviewState()
        {
        }
        public static new KxDataviewState Empty => new KxDataviewState();
    }
}
