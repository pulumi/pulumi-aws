// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fms
{
    /// <summary>
    /// Resource for managing an AWS FMS (Firewall Manager) Resource Set.
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
    ///     var example = new Aws.Fms.ResourceSet("example", new()
    ///     {
    ///         ResourceSets = new[]
    ///         {
    ///             new Aws.Fms.Inputs.ResourceSetResourceSetArgs
    ///             {
    ///                 Name = "testing",
    ///                 ResourceTypeLists = new[]
    ///                 {
    ///                     "AWS::NetworkFirewall::Firewall",
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
    /// Using `pulumi import`, import FMS (Firewall Manager) Resource Set using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:fms/resourceSet:ResourceSet example resource_set-id-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:fms/resourceSet:ResourceSet")]
    public partial class ResourceSet : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the Resource Set.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Details about the resource set to be created or updated. See `resource_set` Attribute Reference below.
        /// </summary>
        [Output("resourceSets")]
        public Output<ImmutableArray<Outputs.ResourceSetResourceSet>> ResourceSets { get; private set; } = null!;

        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.ResourceSetTimeouts?> Timeouts { get; private set; } = null!;


        /// <summary>
        /// Create a ResourceSet resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ResourceSet(string name, ResourceSetArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:fms/resourceSet:ResourceSet", name, args ?? new ResourceSetArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ResourceSet(string name, Input<string> id, ResourceSetState? state = null, CustomResourceOptions? options = null)
            : base("aws:fms/resourceSet:ResourceSet", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ResourceSet resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ResourceSet Get(string name, Input<string> id, ResourceSetState? state = null, CustomResourceOptions? options = null)
        {
            return new ResourceSet(name, id, state, options);
        }
    }

    public sealed class ResourceSetArgs : global::Pulumi.ResourceArgs
    {
        [Input("resourceSets")]
        private InputList<Inputs.ResourceSetResourceSetArgs>? _resourceSets;

        /// <summary>
        /// Details about the resource set to be created or updated. See `resource_set` Attribute Reference below.
        /// </summary>
        public InputList<Inputs.ResourceSetResourceSetArgs> ResourceSets
        {
            get => _resourceSets ?? (_resourceSets = new InputList<Inputs.ResourceSetResourceSetArgs>());
            set => _resourceSets = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("timeouts")]
        public Input<Inputs.ResourceSetTimeoutsArgs>? Timeouts { get; set; }

        public ResourceSetArgs()
        {
        }
        public static new ResourceSetArgs Empty => new ResourceSetArgs();
    }

    public sealed class ResourceSetState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the Resource Set.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("resourceSets")]
        private InputList<Inputs.ResourceSetResourceSetGetArgs>? _resourceSets;

        /// <summary>
        /// Details about the resource set to be created or updated. See `resource_set` Attribute Reference below.
        /// </summary>
        public InputList<Inputs.ResourceSetResourceSetGetArgs> ResourceSets
        {
            get => _resourceSets ?? (_resourceSets = new InputList<Inputs.ResourceSetResourceSetGetArgs>());
            set => _resourceSets = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;
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

        [Input("timeouts")]
        public Input<Inputs.ResourceSetTimeoutsGetArgs>? Timeouts { get; set; }

        public ResourceSetState()
        {
        }
        public static new ResourceSetState Empty => new ResourceSetState();
    }
}
