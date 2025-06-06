// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice
{
    /// <summary>
    /// Resource for managing an AWS VPC Lattice Listener Rule.
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
    ///     var example = new Aws.VpcLattice.ListenerRule("example", new()
    ///     {
    ///         Name = "example",
    ///         ListenerIdentifier = exampleAwsVpclatticeListener.ListenerId,
    ///         ServiceIdentifier = exampleAwsVpclatticeService.Id,
    ///         Priority = 20,
    ///         Match = new Aws.VpcLattice.Inputs.ListenerRuleMatchArgs
    ///         {
    ///             HttpMatch = new Aws.VpcLattice.Inputs.ListenerRuleMatchHttpMatchArgs
    ///             {
    ///                 HeaderMatches = new[]
    ///                 {
    ///                     new Aws.VpcLattice.Inputs.ListenerRuleMatchHttpMatchHeaderMatchArgs
    ///                     {
    ///                         Name = "example-header",
    ///                         CaseSensitive = false,
    ///                         Match = new Aws.VpcLattice.Inputs.ListenerRuleMatchHttpMatchHeaderMatchMatchArgs
    ///                         {
    ///                             Exact = "example-contains",
    ///                         },
    ///                     },
    ///                 },
    ///                 PathMatch = new Aws.VpcLattice.Inputs.ListenerRuleMatchHttpMatchPathMatchArgs
    ///                 {
    ///                     CaseSensitive = true,
    ///                     Match = new Aws.VpcLattice.Inputs.ListenerRuleMatchHttpMatchPathMatchMatchArgs
    ///                     {
    ///                         Prefix = "/example-path",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         Action = new Aws.VpcLattice.Inputs.ListenerRuleActionArgs
    ///         {
    ///             Forward = new Aws.VpcLattice.Inputs.ListenerRuleActionForwardArgs
    ///             {
    ///                 TargetGroups = new[]
    ///                 {
    ///                     new Aws.VpcLattice.Inputs.ListenerRuleActionForwardTargetGroupArgs
    ///                     {
    ///                         TargetGroupIdentifier = exampleAwsVpclatticeTargetGroup.Id,
    ///                         Weight = 1,
    ///                     },
    ///                     new Aws.VpcLattice.Inputs.ListenerRuleActionForwardTargetGroupArgs
    ///                     {
    ///                         TargetGroupIdentifier = example2.Id,
    ///                         Weight = 2,
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
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
    ///     var example = new Aws.VpcLattice.ListenerRule("example", new()
    ///     {
    ///         Name = "example",
    ///         ListenerIdentifier = exampleAwsVpclatticeListener.ListenerId,
    ///         ServiceIdentifier = exampleAwsVpclatticeService.Id,
    ///         Priority = 10,
    ///         Match = new Aws.VpcLattice.Inputs.ListenerRuleMatchArgs
    ///         {
    ///             HttpMatch = new Aws.VpcLattice.Inputs.ListenerRuleMatchHttpMatchArgs
    ///             {
    ///                 PathMatch = new Aws.VpcLattice.Inputs.ListenerRuleMatchHttpMatchPathMatchArgs
    ///                 {
    ///                     CaseSensitive = false,
    ///                     Match = new Aws.VpcLattice.Inputs.ListenerRuleMatchHttpMatchPathMatchMatchArgs
    ///                     {
    ///                         Exact = "/example-path",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         Action = new Aws.VpcLattice.Inputs.ListenerRuleActionArgs
    ///         {
    ///             FixedResponse = new Aws.VpcLattice.Inputs.ListenerRuleActionFixedResponseArgs
    ///             {
    ///                 StatusCode = 404,
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import VPC Lattice Listener Rule using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:vpclattice/listenerRule:ListenerRule example service123/listener456/rule789
    /// ```
    /// </summary>
    [AwsResourceType("aws:vpclattice/listenerRule:ListenerRule")]
    public partial class ListenerRule : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The action for the listener rule.
        /// See `action` Block for details.
        /// </summary>
        [Output("action")]
        public Output<Outputs.ListenerRuleAction> Action { get; private set; } = null!;

        /// <summary>
        /// The ARN for the listener rule.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The ID or Amazon Resource Name (ARN) of the listener.
        /// </summary>
        [Output("listenerIdentifier")]
        public Output<string> ListenerIdentifier { get; private set; } = null!;

        /// <summary>
        /// The rule match.
        /// See `match` Block
        /// </summary>
        [Output("match")]
        public Output<Outputs.ListenerRuleMatch> Match { get; private set; } = null!;

        /// <summary>
        /// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("priority")]
        public Output<int> Priority { get; private set; } = null!;

        /// <summary>
        /// Unique identifier for the listener rule.
        /// </summary>
        [Output("ruleId")]
        public Output<string> RuleId { get; private set; } = null!;

        /// <summary>
        /// The ID or Amazon Resource Identifier (ARN) of the service.
        /// </summary>
        [Output("serviceIdentifier")]
        public Output<string> ServiceIdentifier { get; private set; } = null!;

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
        /// Create a ListenerRule resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ListenerRule(string name, ListenerRuleArgs args, CustomResourceOptions? options = null)
            : base("aws:vpclattice/listenerRule:ListenerRule", name, args ?? new ListenerRuleArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ListenerRule(string name, Input<string> id, ListenerRuleState? state = null, CustomResourceOptions? options = null)
            : base("aws:vpclattice/listenerRule:ListenerRule", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ListenerRule resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ListenerRule Get(string name, Input<string> id, ListenerRuleState? state = null, CustomResourceOptions? options = null)
        {
            return new ListenerRule(name, id, state, options);
        }
    }

    public sealed class ListenerRuleArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The action for the listener rule.
        /// See `action` Block for details.
        /// </summary>
        [Input("action", required: true)]
        public Input<Inputs.ListenerRuleActionArgs> Action { get; set; } = null!;

        /// <summary>
        /// The ID or Amazon Resource Name (ARN) of the listener.
        /// </summary>
        [Input("listenerIdentifier", required: true)]
        public Input<string> ListenerIdentifier { get; set; } = null!;

        /// <summary>
        /// The rule match.
        /// See `match` Block
        /// </summary>
        [Input("match", required: true)]
        public Input<Inputs.ListenerRuleMatchArgs> Match { get; set; } = null!;

        /// <summary>
        /// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("priority", required: true)]
        public Input<int> Priority { get; set; } = null!;

        /// <summary>
        /// The ID or Amazon Resource Identifier (ARN) of the service.
        /// </summary>
        [Input("serviceIdentifier", required: true)]
        public Input<string> ServiceIdentifier { get; set; } = null!;

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

        public ListenerRuleArgs()
        {
        }
        public static new ListenerRuleArgs Empty => new ListenerRuleArgs();
    }

    public sealed class ListenerRuleState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The action for the listener rule.
        /// See `action` Block for details.
        /// </summary>
        [Input("action")]
        public Input<Inputs.ListenerRuleActionGetArgs>? Action { get; set; }

        /// <summary>
        /// The ARN for the listener rule.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The ID or Amazon Resource Name (ARN) of the listener.
        /// </summary>
        [Input("listenerIdentifier")]
        public Input<string>? ListenerIdentifier { get; set; }

        /// <summary>
        /// The rule match.
        /// See `match` Block
        /// </summary>
        [Input("match")]
        public Input<Inputs.ListenerRuleMatchGetArgs>? Match { get; set; }

        /// <summary>
        /// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("priority")]
        public Input<int>? Priority { get; set; }

        /// <summary>
        /// Unique identifier for the listener rule.
        /// </summary>
        [Input("ruleId")]
        public Input<string>? RuleId { get; set; }

        /// <summary>
        /// The ID or Amazon Resource Identifier (ARN) of the service.
        /// </summary>
        [Input("serviceIdentifier")]
        public Input<string>? ServiceIdentifier { get; set; }

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

        public ListenerRuleState()
        {
        }
        public static new ListenerRuleState Empty => new ListenerRuleState();
    }
}
