// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamWrite
{
    /// <summary>
    /// Provides a Timestream table resource.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.TimestreamWrite.Table("example", new()
    ///     {
    ///         DatabaseName = exampleAwsTimestreamwriteDatabase.DatabaseName,
    ///         TableName = "example",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Full usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.TimestreamWrite.Table("example", new()
    ///     {
    ///         DatabaseName = exampleAwsTimestreamwriteDatabase.DatabaseName,
    ///         TableName = "example",
    ///         RetentionProperties = new Aws.TimestreamWrite.Inputs.TableRetentionPropertiesArgs
    ///         {
    ///             MagneticStoreRetentionPeriodInDays = 30,
    ///             MemoryStoreRetentionPeriodInHours = 8,
    ///         },
    ///         Tags = 
    ///         {
    ///             { "Name", "example-timestream-table" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Customer-defined Partition Key
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.TimestreamWrite.Table("example", new()
    ///     {
    ///         DatabaseName = exampleAwsTimestreamwriteDatabase.DatabaseName,
    ///         TableName = "example",
    ///         Schema = new Aws.TimestreamWrite.Inputs.TableSchemaArgs
    ///         {
    ///             CompositePartitionKey = new Aws.TimestreamWrite.Inputs.TableSchemaCompositePartitionKeyArgs
    ///             {
    ///                 EnforcementInRecord = "REQUIRED",
    ///                 Name = "attr1",
    ///                 Type = "DIMENSION",
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Timestream tables using the `table_name` and `database_name` separate by a colon (`:`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:timestreamwrite/table:Table example ExampleTable:ExampleDatabase
    /// ```
    /// </summary>
    [AwsResourceType("aws:timestreamwrite/table:Table")]
    public partial class Table : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN that uniquely identifies this table.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The name of the Timestream database.
        /// </summary>
        [Output("databaseName")]
        public Output<string> DatabaseName { get; private set; } = null!;

        /// <summary>
        /// Contains properties to set on the table when enabling magnetic store writes. See Magnetic Store Write Properties below for more details.
        /// </summary>
        [Output("magneticStoreWriteProperties")]
        public Output<Outputs.TableMagneticStoreWriteProperties> MagneticStoreWriteProperties { get; private set; } = null!;

        /// <summary>
        /// The retention duration for the memory store and magnetic store. See Retention Properties below for more details. If not provided, `magnetic_store_retention_period_in_days` default to 73000 and `memory_store_retention_period_in_hours` defaults to 6.
        /// </summary>
        [Output("retentionProperties")]
        public Output<Outputs.TableRetentionProperties> RetentionProperties { get; private set; } = null!;

        /// <summary>
        /// The schema of the table. See Schema below for more details.
        /// </summary>
        [Output("schema")]
        public Output<Outputs.TableSchema> Schema { get; private set; } = null!;

        /// <summary>
        /// The name of the Timestream table.
        /// </summary>
        [Output("tableName")]
        public Output<string> TableName { get; private set; } = null!;

        /// <summary>
        /// Map of tags to assign to this resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a Table resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Table(string name, TableArgs args, CustomResourceOptions? options = null)
            : base("aws:timestreamwrite/table:Table", name, args ?? new TableArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Table(string name, Input<string> id, TableState? state = null, CustomResourceOptions? options = null)
            : base("aws:timestreamwrite/table:Table", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Table resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Table Get(string name, Input<string> id, TableState? state = null, CustomResourceOptions? options = null)
        {
            return new Table(name, id, state, options);
        }
    }

    public sealed class TableArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the Timestream database.
        /// </summary>
        [Input("databaseName", required: true)]
        public Input<string> DatabaseName { get; set; } = null!;

        /// <summary>
        /// Contains properties to set on the table when enabling magnetic store writes. See Magnetic Store Write Properties below for more details.
        /// </summary>
        [Input("magneticStoreWriteProperties")]
        public Input<Inputs.TableMagneticStoreWritePropertiesArgs>? MagneticStoreWriteProperties { get; set; }

        /// <summary>
        /// The retention duration for the memory store and magnetic store. See Retention Properties below for more details. If not provided, `magnetic_store_retention_period_in_days` default to 73000 and `memory_store_retention_period_in_hours` defaults to 6.
        /// </summary>
        [Input("retentionProperties")]
        public Input<Inputs.TableRetentionPropertiesArgs>? RetentionProperties { get; set; }

        /// <summary>
        /// The schema of the table. See Schema below for more details.
        /// </summary>
        [Input("schema")]
        public Input<Inputs.TableSchemaArgs>? Schema { get; set; }

        /// <summary>
        /// The name of the Timestream table.
        /// </summary>
        [Input("tableName", required: true)]
        public Input<string> TableName { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to this resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public TableArgs()
        {
        }
        public static new TableArgs Empty => new TableArgs();
    }

    public sealed class TableState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN that uniquely identifies this table.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The name of the Timestream database.
        /// </summary>
        [Input("databaseName")]
        public Input<string>? DatabaseName { get; set; }

        /// <summary>
        /// Contains properties to set on the table when enabling magnetic store writes. See Magnetic Store Write Properties below for more details.
        /// </summary>
        [Input("magneticStoreWriteProperties")]
        public Input<Inputs.TableMagneticStoreWritePropertiesGetArgs>? MagneticStoreWriteProperties { get; set; }

        /// <summary>
        /// The retention duration for the memory store and magnetic store. See Retention Properties below for more details. If not provided, `magnetic_store_retention_period_in_days` default to 73000 and `memory_store_retention_period_in_hours` defaults to 6.
        /// </summary>
        [Input("retentionProperties")]
        public Input<Inputs.TableRetentionPropertiesGetArgs>? RetentionProperties { get; set; }

        /// <summary>
        /// The schema of the table. See Schema below for more details.
        /// </summary>
        [Input("schema")]
        public Input<Inputs.TableSchemaGetArgs>? Schema { get; set; }

        /// <summary>
        /// The name of the Timestream table.
        /// </summary>
        [Input("tableName")]
        public Input<string>? TableName { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to this resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public TableState()
        {
        }
        public static new TableState Empty => new TableState();
    }
}
