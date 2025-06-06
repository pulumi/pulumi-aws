// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkManager
{
    /// <summary>
    /// Creates a link for a site.
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
    ///     var example = new Aws.NetworkManager.Link("example", new()
    ///     {
    ///         GlobalNetworkId = exampleAwsNetworkmanagerGlobalNetwork.Id,
    ///         SiteId = exampleAwsNetworkmanagerSite.Id,
    ///         Bandwidth = new Aws.NetworkManager.Inputs.LinkBandwidthArgs
    ///         {
    ///             UploadSpeed = 10,
    ///             DownloadSpeed = 50,
    ///         },
    ///         ProviderName = "MegaCorp",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_networkmanager_link` using the link ARN. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:networkmanager/link:Link example arn:aws:networkmanager::123456789012:link/global-network-0d47f6t230mz46dy4/link-444555aaabbb11223
    /// ```
    /// </summary>
    [AwsResourceType("aws:networkmanager/link:Link")]
    public partial class Link : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Link Amazon Resource Name (ARN).
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The upload speed and download speed in Mbps. Documented below.
        /// </summary>
        [Output("bandwidth")]
        public Output<Outputs.LinkBandwidth> Bandwidth { get; private set; } = null!;

        /// <summary>
        /// A description of the link.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// The ID of the global network.
        /// </summary>
        [Output("globalNetworkId")]
        public Output<string> GlobalNetworkId { get; private set; } = null!;

        /// <summary>
        /// The provider of the link.
        /// </summary>
        [Output("providerName")]
        public Output<string?> ProviderName { get; private set; } = null!;

        /// <summary>
        /// The ID of the site.
        /// </summary>
        [Output("siteId")]
        public Output<string> SiteId { get; private set; } = null!;

        /// <summary>
        /// Key-value tags for the link. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The type of the link.
        /// </summary>
        [Output("type")]
        public Output<string?> Type { get; private set; } = null!;


        /// <summary>
        /// Create a Link resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Link(string name, LinkArgs args, CustomResourceOptions? options = null)
            : base("aws:networkmanager/link:Link", name, args ?? new LinkArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Link(string name, Input<string> id, LinkState? state = null, CustomResourceOptions? options = null)
            : base("aws:networkmanager/link:Link", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Link resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Link Get(string name, Input<string> id, LinkState? state = null, CustomResourceOptions? options = null)
        {
            return new Link(name, id, state, options);
        }
    }

    public sealed class LinkArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The upload speed and download speed in Mbps. Documented below.
        /// </summary>
        [Input("bandwidth", required: true)]
        public Input<Inputs.LinkBandwidthArgs> Bandwidth { get; set; } = null!;

        /// <summary>
        /// A description of the link.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The ID of the global network.
        /// </summary>
        [Input("globalNetworkId", required: true)]
        public Input<string> GlobalNetworkId { get; set; } = null!;

        /// <summary>
        /// The provider of the link.
        /// </summary>
        [Input("providerName")]
        public Input<string>? ProviderName { get; set; }

        /// <summary>
        /// The ID of the site.
        /// </summary>
        [Input("siteId", required: true)]
        public Input<string> SiteId { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value tags for the link. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The type of the link.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public LinkArgs()
        {
        }
        public static new LinkArgs Empty => new LinkArgs();
    }

    public sealed class LinkState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Link Amazon Resource Name (ARN).
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The upload speed and download speed in Mbps. Documented below.
        /// </summary>
        [Input("bandwidth")]
        public Input<Inputs.LinkBandwidthGetArgs>? Bandwidth { get; set; }

        /// <summary>
        /// A description of the link.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The ID of the global network.
        /// </summary>
        [Input("globalNetworkId")]
        public Input<string>? GlobalNetworkId { get; set; }

        /// <summary>
        /// The provider of the link.
        /// </summary>
        [Input("providerName")]
        public Input<string>? ProviderName { get; set; }

        /// <summary>
        /// The ID of the site.
        /// </summary>
        [Input("siteId")]
        public Input<string>? SiteId { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value tags for the link. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        /// <summary>
        /// The type of the link.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public LinkState()
        {
        }
        public static new LinkState Empty => new LinkState();
    }
}
