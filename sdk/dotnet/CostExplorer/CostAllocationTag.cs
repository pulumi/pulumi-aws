// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CostExplorer
{
    /// <summary>
    /// Provides a CE Cost Allocation Tag.
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
    ///     var example = new Aws.CostExplorer.CostAllocationTag("example", new()
    ///     {
    ///         TagKey = "example",
    ///         Status = "Active",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_ce_cost_allocation_tag` using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:costexplorer/costAllocationTag:CostAllocationTag example key
    /// ```
    /// </summary>
    [AwsResourceType("aws:costexplorer/costAllocationTag:CostAllocationTag")]
    public partial class CostAllocationTag : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The status of a cost allocation tag. Valid values are `Active` and `Inactive`.
        /// </summary>
        [Output("status")]
        public Output<string> Status { get; private set; } = null!;

        /// <summary>
        /// The key for the cost allocation tag.
        /// </summary>
        [Output("tagKey")]
        public Output<string> TagKey { get; private set; } = null!;

        /// <summary>
        /// The type of cost allocation tag.
        /// </summary>
        [Output("type")]
        public Output<string> Type { get; private set; } = null!;


        /// <summary>
        /// Create a CostAllocationTag resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public CostAllocationTag(string name, CostAllocationTagArgs args, CustomResourceOptions? options = null)
            : base("aws:costexplorer/costAllocationTag:CostAllocationTag", name, args ?? new CostAllocationTagArgs(), MakeResourceOptions(options, ""))
        {
        }

        private CostAllocationTag(string name, Input<string> id, CostAllocationTagState? state = null, CustomResourceOptions? options = null)
            : base("aws:costexplorer/costAllocationTag:CostAllocationTag", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing CostAllocationTag resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static CostAllocationTag Get(string name, Input<string> id, CostAllocationTagState? state = null, CustomResourceOptions? options = null)
        {
            return new CostAllocationTag(name, id, state, options);
        }
    }

    public sealed class CostAllocationTagArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The status of a cost allocation tag. Valid values are `Active` and `Inactive`.
        /// </summary>
        [Input("status", required: true)]
        public Input<string> Status { get; set; } = null!;

        /// <summary>
        /// The key for the cost allocation tag.
        /// </summary>
        [Input("tagKey", required: true)]
        public Input<string> TagKey { get; set; } = null!;

        public CostAllocationTagArgs()
        {
        }
        public static new CostAllocationTagArgs Empty => new CostAllocationTagArgs();
    }

    public sealed class CostAllocationTagState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The status of a cost allocation tag. Valid values are `Active` and `Inactive`.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        /// <summary>
        /// The key for the cost allocation tag.
        /// </summary>
        [Input("tagKey")]
        public Input<string>? TagKey { get; set; }

        /// <summary>
        /// The type of cost allocation tag.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public CostAllocationTagState()
        {
        }
        public static new CostAllocationTagState Empty => new CostAllocationTagState();
    }
}
