// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot
{
    /// <summary>
    /// Creates and manages an AWS IoT Thing.
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
    ///     var example = new Aws.Iot.Thing("example", new()
    ///     {
    ///         Name = "example",
    ///         Attributes = 
    ///         {
    ///             { "First", "examplevalue" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import IOT Things using the name. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:iot/thing:Thing example example
    /// ```
    /// </summary>
    [AwsResourceType("aws:iot/thing:Thing")]
    public partial class Thing : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of the thing.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Map of attributes of the thing.
        /// </summary>
        [Output("attributes")]
        public Output<ImmutableDictionary<string, string>?> Attributes { get; private set; } = null!;

        /// <summary>
        /// The default client ID.
        /// </summary>
        [Output("defaultClientId")]
        public Output<string> DefaultClientId { get; private set; } = null!;

        /// <summary>
        /// The name of the thing.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The thing type name.
        /// </summary>
        [Output("thingTypeName")]
        public Output<string?> ThingTypeName { get; private set; } = null!;

        /// <summary>
        /// The current version of the thing record in the registry.
        /// </summary>
        [Output("version")]
        public Output<int> Version { get; private set; } = null!;


        /// <summary>
        /// Create a Thing resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Thing(string name, ThingArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:iot/thing:Thing", name, args ?? new ThingArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Thing(string name, Input<string> id, ThingState? state = null, CustomResourceOptions? options = null)
            : base("aws:iot/thing:Thing", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Thing resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Thing Get(string name, Input<string> id, ThingState? state = null, CustomResourceOptions? options = null)
        {
            return new Thing(name, id, state, options);
        }
    }

    public sealed class ThingArgs : global::Pulumi.ResourceArgs
    {
        [Input("attributes")]
        private InputMap<string>? _attributes;

        /// <summary>
        /// Map of attributes of the thing.
        /// </summary>
        public InputMap<string> Attributes
        {
            get => _attributes ?? (_attributes = new InputMap<string>());
            set => _attributes = value;
        }

        /// <summary>
        /// The name of the thing.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The thing type name.
        /// </summary>
        [Input("thingTypeName")]
        public Input<string>? ThingTypeName { get; set; }

        public ThingArgs()
        {
        }
        public static new ThingArgs Empty => new ThingArgs();
    }

    public sealed class ThingState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the thing.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("attributes")]
        private InputMap<string>? _attributes;

        /// <summary>
        /// Map of attributes of the thing.
        /// </summary>
        public InputMap<string> Attributes
        {
            get => _attributes ?? (_attributes = new InputMap<string>());
            set => _attributes = value;
        }

        /// <summary>
        /// The default client ID.
        /// </summary>
        [Input("defaultClientId")]
        public Input<string>? DefaultClientId { get; set; }

        /// <summary>
        /// The name of the thing.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The thing type name.
        /// </summary>
        [Input("thingTypeName")]
        public Input<string>? ThingTypeName { get; set; }

        /// <summary>
        /// The current version of the thing record in the registry.
        /// </summary>
        [Input("version")]
        public Input<int>? Version { get; set; }

        public ThingState()
        {
        }
        public static new ThingState Empty => new ThingState();
    }
}
