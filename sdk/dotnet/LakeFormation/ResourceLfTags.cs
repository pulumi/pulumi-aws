// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LakeFormation
{
    /// <summary>
    /// Manages an attachment between one or more existing LF-tags and an existing Lake Formation resource.
    /// 
    /// ## Example Usage
    /// 
    /// ### Database Example
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.LakeFormation.LfTag("example", new()
    ///     {
    ///         Key = "right",
    ///         Values = new[]
    ///         {
    ///             "abbey",
    ///             "village",
    ///             "luffield",
    ///             "woodcote",
    ///             "copse",
    ///             "chapel",
    ///             "stowe",
    ///             "club",
    ///         },
    ///     });
    /// 
    ///     var exampleResourceLfTags = new Aws.LakeFormation.ResourceLfTags("example", new()
    ///     {
    ///         Database = new Aws.LakeFormation.Inputs.ResourceLfTagsDatabaseArgs
    ///         {
    ///             Name = exampleAwsGlueCatalogDatabase.Name,
    ///         },
    ///         LfTags = new[]
    ///         {
    ///             new Aws.LakeFormation.Inputs.ResourceLfTagsLfTagArgs
    ///             {
    ///                 Key = example.Key,
    ///                 Value = "stowe",
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Multiple Tags Example
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.LakeFormation.LfTag("example", new()
    ///     {
    ///         Key = "right",
    ///         Values = new[]
    ///         {
    ///             "abbey",
    ///             "village",
    ///             "luffield",
    ///             "woodcote",
    ///             "copse",
    ///             "chapel",
    ///             "stowe",
    ///             "club",
    ///         },
    ///     });
    /// 
    ///     var example2 = new Aws.LakeFormation.LfTag("example2", new()
    ///     {
    ///         Key = "left",
    ///         Values = new[]
    ///         {
    ///             "farm",
    ///             "theloop",
    ///             "aintree",
    ///             "brooklands",
    ///             "maggotts",
    ///             "becketts",
    ///             "vale",
    ///         },
    ///     });
    /// 
    ///     var exampleResourceLfTags = new Aws.LakeFormation.ResourceLfTags("example", new()
    ///     {
    ///         Database = new Aws.LakeFormation.Inputs.ResourceLfTagsDatabaseArgs
    ///         {
    ///             Name = exampleAwsGlueCatalogDatabase.Name,
    ///         },
    ///         LfTags = new[]
    ///         {
    ///             new Aws.LakeFormation.Inputs.ResourceLfTagsLfTagArgs
    ///             {
    ///                 Key = "right",
    ///                 Value = "luffield",
    ///             },
    ///             new Aws.LakeFormation.Inputs.ResourceLfTagsLfTagArgs
    ///             {
    ///                 Key = "left",
    ///                 Value = "aintree",
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:lakeformation/resourceLfTags:ResourceLfTags")]
    public partial class ResourceLfTags : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
        /// </summary>
        [Output("catalogId")]
        public Output<string> CatalogId { get; private set; } = null!;

        /// <summary>
        /// Configuration block for a database resource. See below.
        /// </summary>
        [Output("database")]
        public Output<Outputs.ResourceLfTagsDatabase> Database { get; private set; } = null!;

        /// <summary>
        /// Set of LF-tags to attach to the resource. See below.
        /// 
        /// Exactly one of the following is required:
        /// </summary>
        [Output("lfTags")]
        public Output<ImmutableArray<Outputs.ResourceLfTagsLfTag>> LfTags { get; private set; } = null!;

        /// <summary>
        /// Configuration block for a table resource. See below.
        /// </summary>
        [Output("table")]
        public Output<Outputs.ResourceLfTagsTable> Table { get; private set; } = null!;

        /// <summary>
        /// Configuration block for a table with columns resource. See below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("tableWithColumns")]
        public Output<Outputs.ResourceLfTagsTableWithColumns> TableWithColumns { get; private set; } = null!;


        /// <summary>
        /// Create a ResourceLfTags resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ResourceLfTags(string name, ResourceLfTagsArgs args, CustomResourceOptions? options = null)
            : base("aws:lakeformation/resourceLfTags:ResourceLfTags", name, args ?? new ResourceLfTagsArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ResourceLfTags(string name, Input<string> id, ResourceLfTagsState? state = null, CustomResourceOptions? options = null)
            : base("aws:lakeformation/resourceLfTags:ResourceLfTags", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ResourceLfTags resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ResourceLfTags Get(string name, Input<string> id, ResourceLfTagsState? state = null, CustomResourceOptions? options = null)
        {
            return new ResourceLfTags(name, id, state, options);
        }
    }

    public sealed class ResourceLfTagsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
        /// </summary>
        [Input("catalogId")]
        public Input<string>? CatalogId { get; set; }

        /// <summary>
        /// Configuration block for a database resource. See below.
        /// </summary>
        [Input("database")]
        public Input<Inputs.ResourceLfTagsDatabaseArgs>? Database { get; set; }

        [Input("lfTags", required: true)]
        private InputList<Inputs.ResourceLfTagsLfTagArgs>? _lfTags;

        /// <summary>
        /// Set of LF-tags to attach to the resource. See below.
        /// 
        /// Exactly one of the following is required:
        /// </summary>
        public InputList<Inputs.ResourceLfTagsLfTagArgs> LfTags
        {
            get => _lfTags ?? (_lfTags = new InputList<Inputs.ResourceLfTagsLfTagArgs>());
            set => _lfTags = value;
        }

        /// <summary>
        /// Configuration block for a table resource. See below.
        /// </summary>
        [Input("table")]
        public Input<Inputs.ResourceLfTagsTableArgs>? Table { get; set; }

        /// <summary>
        /// Configuration block for a table with columns resource. See below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("tableWithColumns")]
        public Input<Inputs.ResourceLfTagsTableWithColumnsArgs>? TableWithColumns { get; set; }

        public ResourceLfTagsArgs()
        {
        }
        public static new ResourceLfTagsArgs Empty => new ResourceLfTagsArgs();
    }

    public sealed class ResourceLfTagsState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier for the Data Catalog. By default, the account ID. The Data Catalog is the persistent metadata store. It contains database definitions, table definitions, and other control information to manage your Lake Formation environment.
        /// </summary>
        [Input("catalogId")]
        public Input<string>? CatalogId { get; set; }

        /// <summary>
        /// Configuration block for a database resource. See below.
        /// </summary>
        [Input("database")]
        public Input<Inputs.ResourceLfTagsDatabaseGetArgs>? Database { get; set; }

        [Input("lfTags")]
        private InputList<Inputs.ResourceLfTagsLfTagGetArgs>? _lfTags;

        /// <summary>
        /// Set of LF-tags to attach to the resource. See below.
        /// 
        /// Exactly one of the following is required:
        /// </summary>
        public InputList<Inputs.ResourceLfTagsLfTagGetArgs> LfTags
        {
            get => _lfTags ?? (_lfTags = new InputList<Inputs.ResourceLfTagsLfTagGetArgs>());
            set => _lfTags = value;
        }

        /// <summary>
        /// Configuration block for a table resource. See below.
        /// </summary>
        [Input("table")]
        public Input<Inputs.ResourceLfTagsTableGetArgs>? Table { get; set; }

        /// <summary>
        /// Configuration block for a table with columns resource. See below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("tableWithColumns")]
        public Input<Inputs.ResourceLfTagsTableWithColumnsGetArgs>? TableWithColumns { get; set; }

        public ResourceLfTagsState()
        {
        }
        public static new ResourceLfTagsState Empty => new ResourceLfTagsState();
    }
}
