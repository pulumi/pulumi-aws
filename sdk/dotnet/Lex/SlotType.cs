// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex
{
    /// <summary>
    /// Provides an Amazon Lex Slot Type resource. For more information see
    /// [Amazon Lex: How It Works](https://docs.aws.amazon.com/lex/latest/dg/how-it-works.html)
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
    ///     var flowerTypes = new Aws.Lex.SlotType("flower_types", new()
    ///     {
    ///         CreateVersion = true,
    ///         Description = "Types of flowers to order",
    ///         EnumerationValues = new[]
    ///         {
    ///             new Aws.Lex.Inputs.SlotTypeEnumerationValueArgs
    ///             {
    ///                 Synonyms = new[]
    ///                 {
    ///                     "Lirium",
    ///                     "Martagon",
    ///                 },
    ///                 Value = "lilies",
    ///             },
    ///             new Aws.Lex.Inputs.SlotTypeEnumerationValueArgs
    ///             {
    ///                 Synonyms = new[]
    ///                 {
    ///                     "Eduardoregelia",
    ///                     "Podonix",
    ///                 },
    ///                 Value = "tulips",
    ///             },
    ///         },
    ///         Name = "FlowerTypes",
    ///         ValueSelectionStrategy = "ORIGINAL_VALUE",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import slot types using their name. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:lex/slotType:SlotType flower_types FlowerTypes
    /// ```
    /// </summary>
    [AwsResourceType("aws:lex/slotType:SlotType")]
    public partial class SlotType : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Checksum identifying the version of the slot type that was created. The checksum is
        /// not included as an argument because the resource will add it automatically when updating the slot type.
        /// </summary>
        [Output("checksum")]
        public Output<string> Checksum { get; private set; } = null!;

        /// <summary>
        /// Determines if a new slot type version is created when the initial resource is created and on each
        /// update. Defaults to `false`.
        /// </summary>
        [Output("createVersion")]
        public Output<bool?> CreateVersion { get; private set; } = null!;

        /// <summary>
        /// The date when the slot type version was created.
        /// </summary>
        [Output("createdDate")]
        public Output<string> CreatedDate { get; private set; } = null!;

        /// <summary>
        /// A description of the slot type. Must be less than or equal to 200 characters in length.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// A list of EnumerationValue objects that defines the values that
        /// the slot type can take. Each value can have a list of synonyms, which are additional values that help
        /// train the machine learning model about the values that it resolves for a slot. Attributes are
        /// documented under enumeration_value.
        /// </summary>
        [Output("enumerationValues")]
        public Output<ImmutableArray<Outputs.SlotTypeEnumerationValue>> EnumerationValues { get; private set; } = null!;

        /// <summary>
        /// The date when the `$LATEST` version of this slot type was updated.
        /// </summary>
        [Output("lastUpdatedDate")]
        public Output<string> LastUpdatedDate { get; private set; } = null!;

        /// <summary>
        /// The name of the slot type. The name is not case sensitive. Must be less than or equal to 100 characters in length.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Determines the slot resolution strategy that Amazon Lex
        /// uses to return slot type values. `ORIGINAL_VALUE` returns the value entered by the user if the user
        /// value is similar to the slot value. `TOP_RESOLUTION` returns the first value in the resolution list
        /// if there is a resolution list for the slot, otherwise null is returned. Defaults to `ORIGINAL_VALUE`.
        /// </summary>
        [Output("valueSelectionStrategy")]
        public Output<string?> ValueSelectionStrategy { get; private set; } = null!;

        /// <summary>
        /// The version of the slot type.
        /// </summary>
        [Output("version")]
        public Output<string> Version { get; private set; } = null!;


        /// <summary>
        /// Create a SlotType resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public SlotType(string name, SlotTypeArgs args, CustomResourceOptions? options = null)
            : base("aws:lex/slotType:SlotType", name, args ?? new SlotTypeArgs(), MakeResourceOptions(options, ""))
        {
        }

        private SlotType(string name, Input<string> id, SlotTypeState? state = null, CustomResourceOptions? options = null)
            : base("aws:lex/slotType:SlotType", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing SlotType resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static SlotType Get(string name, Input<string> id, SlotTypeState? state = null, CustomResourceOptions? options = null)
        {
            return new SlotType(name, id, state, options);
        }
    }

    public sealed class SlotTypeArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Determines if a new slot type version is created when the initial resource is created and on each
        /// update. Defaults to `false`.
        /// </summary>
        [Input("createVersion")]
        public Input<bool>? CreateVersion { get; set; }

        /// <summary>
        /// A description of the slot type. Must be less than or equal to 200 characters in length.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("enumerationValues", required: true)]
        private InputList<Inputs.SlotTypeEnumerationValueArgs>? _enumerationValues;

        /// <summary>
        /// A list of EnumerationValue objects that defines the values that
        /// the slot type can take. Each value can have a list of synonyms, which are additional values that help
        /// train the machine learning model about the values that it resolves for a slot. Attributes are
        /// documented under enumeration_value.
        /// </summary>
        public InputList<Inputs.SlotTypeEnumerationValueArgs> EnumerationValues
        {
            get => _enumerationValues ?? (_enumerationValues = new InputList<Inputs.SlotTypeEnumerationValueArgs>());
            set => _enumerationValues = value;
        }

        /// <summary>
        /// The name of the slot type. The name is not case sensitive. Must be less than or equal to 100 characters in length.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Determines the slot resolution strategy that Amazon Lex
        /// uses to return slot type values. `ORIGINAL_VALUE` returns the value entered by the user if the user
        /// value is similar to the slot value. `TOP_RESOLUTION` returns the first value in the resolution list
        /// if there is a resolution list for the slot, otherwise null is returned. Defaults to `ORIGINAL_VALUE`.
        /// </summary>
        [Input("valueSelectionStrategy")]
        public Input<string>? ValueSelectionStrategy { get; set; }

        public SlotTypeArgs()
        {
        }
        public static new SlotTypeArgs Empty => new SlotTypeArgs();
    }

    public sealed class SlotTypeState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Checksum identifying the version of the slot type that was created. The checksum is
        /// not included as an argument because the resource will add it automatically when updating the slot type.
        /// </summary>
        [Input("checksum")]
        public Input<string>? Checksum { get; set; }

        /// <summary>
        /// Determines if a new slot type version is created when the initial resource is created and on each
        /// update. Defaults to `false`.
        /// </summary>
        [Input("createVersion")]
        public Input<bool>? CreateVersion { get; set; }

        /// <summary>
        /// The date when the slot type version was created.
        /// </summary>
        [Input("createdDate")]
        public Input<string>? CreatedDate { get; set; }

        /// <summary>
        /// A description of the slot type. Must be less than or equal to 200 characters in length.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("enumerationValues")]
        private InputList<Inputs.SlotTypeEnumerationValueGetArgs>? _enumerationValues;

        /// <summary>
        /// A list of EnumerationValue objects that defines the values that
        /// the slot type can take. Each value can have a list of synonyms, which are additional values that help
        /// train the machine learning model about the values that it resolves for a slot. Attributes are
        /// documented under enumeration_value.
        /// </summary>
        public InputList<Inputs.SlotTypeEnumerationValueGetArgs> EnumerationValues
        {
            get => _enumerationValues ?? (_enumerationValues = new InputList<Inputs.SlotTypeEnumerationValueGetArgs>());
            set => _enumerationValues = value;
        }

        /// <summary>
        /// The date when the `$LATEST` version of this slot type was updated.
        /// </summary>
        [Input("lastUpdatedDate")]
        public Input<string>? LastUpdatedDate { get; set; }

        /// <summary>
        /// The name of the slot type. The name is not case sensitive. Must be less than or equal to 100 characters in length.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Determines the slot resolution strategy that Amazon Lex
        /// uses to return slot type values. `ORIGINAL_VALUE` returns the value entered by the user if the user
        /// value is similar to the slot value. `TOP_RESOLUTION` returns the first value in the resolution list
        /// if there is a resolution list for the slot, otherwise null is returned. Defaults to `ORIGINAL_VALUE`.
        /// </summary>
        [Input("valueSelectionStrategy")]
        public Input<string>? ValueSelectionStrategy { get; set; }

        /// <summary>
        /// The version of the slot type.
        /// </summary>
        [Input("version")]
        public Input<string>? Version { get; set; }

        public SlotTypeState()
        {
        }
        public static new SlotTypeState Empty => new SlotTypeState();
    }
}
