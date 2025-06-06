// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub
{
    /// <summary>
    /// Manages a Security Hub finding aggregator. Security Hub needs to be enabled in a region in order for the aggregator to pull through findings.
    /// 
    /// ## Example Usage
    /// 
    /// ### All Regions Usage
    /// 
    /// The following example will enable the aggregator for every region.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleFindingAggregator = new Aws.SecurityHub.FindingAggregator("example", new()
    ///     {
    ///         LinkingMode = "ALL_REGIONS",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### All Regions Except Specified Regions Usage
    /// 
    /// The following example will enable the aggregator for every region except those specified in `specified_regions`.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleFindingAggregator = new Aws.SecurityHub.FindingAggregator("example", new()
    ///     {
    ///         LinkingMode = "ALL_REGIONS_EXCEPT_SPECIFIED",
    ///         SpecifiedRegions = new[]
    ///         {
    ///             "eu-west-1",
    ///             "eu-west-2",
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Specified Regions Usage
    /// 
    /// The following example will enable the aggregator for every region specified in `specified_regions`.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleFindingAggregator = new Aws.SecurityHub.FindingAggregator("example", new()
    ///     {
    ///         LinkingMode = "SPECIFIED_REGIONS",
    ///         SpecifiedRegions = new[]
    ///         {
    ///             "eu-west-1",
    ///             "eu-west-2",
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### No Regions Usage
    /// 
    /// The following example will enable the aggregator but not link any AWS Regions to the home Region.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleFindingAggregator = new Aws.SecurityHub.FindingAggregator("example", new()
    ///     {
    ///         LinkingMode = "NO_REGIONS",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import an existing Security Hub finding aggregator using the `arn`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:securityhub/findingAggregator:FindingAggregator example arn:aws:securityhub:eu-west-1:123456789098:finding-aggregator/abcd1234-abcd-1234-1234-abcdef123456
    /// ```
    /// </summary>
    [AwsResourceType("aws:securityhub/findingAggregator:FindingAggregator")]
    public partial class FindingAggregator : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Indicates whether to aggregate findings from all of the available Regions or from a specified list. The options are `ALL_REGIONS`, `ALL_REGIONS_EXCEPT_SPECIFIED`, `SPECIFIED_REGIONS` or `NO_REGIONS`. When `ALL_REGIONS` or `ALL_REGIONS_EXCEPT_SPECIFIED` are used, Security Hub will automatically aggregate findings from new Regions as Security Hub supports them and you opt into them.
        /// </summary>
        [Output("linkingMode")]
        public Output<string> LinkingMode { get; private set; } = null!;

        /// <summary>
        /// List of regions to include or exclude (required if `linking_mode` is set to `ALL_REGIONS_EXCEPT_SPECIFIED` or `SPECIFIED_REGIONS`)
        /// </summary>
        [Output("specifiedRegions")]
        public Output<ImmutableArray<string>> SpecifiedRegions { get; private set; } = null!;


        /// <summary>
        /// Create a FindingAggregator resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public FindingAggregator(string name, FindingAggregatorArgs args, CustomResourceOptions? options = null)
            : base("aws:securityhub/findingAggregator:FindingAggregator", name, args ?? new FindingAggregatorArgs(), MakeResourceOptions(options, ""))
        {
        }

        private FindingAggregator(string name, Input<string> id, FindingAggregatorState? state = null, CustomResourceOptions? options = null)
            : base("aws:securityhub/findingAggregator:FindingAggregator", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing FindingAggregator resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static FindingAggregator Get(string name, Input<string> id, FindingAggregatorState? state = null, CustomResourceOptions? options = null)
        {
            return new FindingAggregator(name, id, state, options);
        }
    }

    public sealed class FindingAggregatorArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates whether to aggregate findings from all of the available Regions or from a specified list. The options are `ALL_REGIONS`, `ALL_REGIONS_EXCEPT_SPECIFIED`, `SPECIFIED_REGIONS` or `NO_REGIONS`. When `ALL_REGIONS` or `ALL_REGIONS_EXCEPT_SPECIFIED` are used, Security Hub will automatically aggregate findings from new Regions as Security Hub supports them and you opt into them.
        /// </summary>
        [Input("linkingMode", required: true)]
        public Input<string> LinkingMode { get; set; } = null!;

        [Input("specifiedRegions")]
        private InputList<string>? _specifiedRegions;

        /// <summary>
        /// List of regions to include or exclude (required if `linking_mode` is set to `ALL_REGIONS_EXCEPT_SPECIFIED` or `SPECIFIED_REGIONS`)
        /// </summary>
        public InputList<string> SpecifiedRegions
        {
            get => _specifiedRegions ?? (_specifiedRegions = new InputList<string>());
            set => _specifiedRegions = value;
        }

        public FindingAggregatorArgs()
        {
        }
        public static new FindingAggregatorArgs Empty => new FindingAggregatorArgs();
    }

    public sealed class FindingAggregatorState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates whether to aggregate findings from all of the available Regions or from a specified list. The options are `ALL_REGIONS`, `ALL_REGIONS_EXCEPT_SPECIFIED`, `SPECIFIED_REGIONS` or `NO_REGIONS`. When `ALL_REGIONS` or `ALL_REGIONS_EXCEPT_SPECIFIED` are used, Security Hub will automatically aggregate findings from new Regions as Security Hub supports them and you opt into them.
        /// </summary>
        [Input("linkingMode")]
        public Input<string>? LinkingMode { get; set; }

        [Input("specifiedRegions")]
        private InputList<string>? _specifiedRegions;

        /// <summary>
        /// List of regions to include or exclude (required if `linking_mode` is set to `ALL_REGIONS_EXCEPT_SPECIFIED` or `SPECIFIED_REGIONS`)
        /// </summary>
        public InputList<string> SpecifiedRegions
        {
            get => _specifiedRegions ?? (_specifiedRegions = new InputList<string>());
            set => _specifiedRegions = value;
        }

        public FindingAggregatorState()
        {
        }
        public static new FindingAggregatorState Empty => new FindingAggregatorState();
    }
}
