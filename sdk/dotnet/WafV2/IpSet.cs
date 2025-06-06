// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2
{
    /// <summary>
    /// Provides a WAFv2 IP Set Resource
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
    ///     var example = new Aws.WafV2.IpSet("example", new()
    ///     {
    ///         Name = "example",
    ///         Description = "Example IP set",
    ///         Scope = "REGIONAL",
    ///         IpAddressVersion = "IPV4",
    ///         Addresses = new[]
    ///         {
    ///             "1.2.3.4/32",
    ///             "5.6.7.8/32",
    ///         },
    ///         Tags = 
    ///         {
    ///             { "Tag1", "Value1" },
    ///             { "Tag2", "Value2" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import WAFv2 IP Sets using `ID/name/scope`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:wafv2/ipSet:IpSet example a1b2c3d4-d5f6-7777-8888-9999aaaabbbbcccc/example/REGIONAL
    /// ```
    /// </summary>
    [AwsResourceType("aws:wafv2/ipSet:IpSet")]
    public partial class IpSet : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Contains an array of strings that specifies zero or more IP addresses or blocks of IP addresses. All addresses must be specified using Classless Inter-Domain Routing (CIDR) notation. WAF supports all IPv4 and IPv6 CIDR ranges except for `/0`.
        /// </summary>
        [Output("addresses")]
        public Output<ImmutableArray<string>> Addresses { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the IP set.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// A friendly description of the IP set.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Specify IPV4 or IPV6. Valid values are `IPV4` or `IPV6`.
        /// </summary>
        [Output("ipAddressVersion")]
        public Output<string> IpAddressVersion { get; private set; } = null!;

        [Output("lockToken")]
        public Output<string> LockToken { get; private set; } = null!;

        /// <summary>
        /// A friendly name of the IP set. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Output("namePrefix")]
        public Output<string> NamePrefix { get; private set; } = null!;

        /// <summary>
        /// Specifies whether this is for an AWS CloudFront distribution or for a regional application. Valid values are `CLOUDFRONT` or `REGIONAL`. To work with CloudFront, you must also specify the Region US East (N. Virginia).
        /// </summary>
        [Output("scope")]
        public Output<string> Scope { get; private set; } = null!;

        /// <summary>
        /// An array of key:value pairs to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a IpSet resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public IpSet(string name, IpSetArgs args, CustomResourceOptions? options = null)
            : base("aws:wafv2/ipSet:IpSet", name, args ?? new IpSetArgs(), MakeResourceOptions(options, ""))
        {
        }

        private IpSet(string name, Input<string> id, IpSetState? state = null, CustomResourceOptions? options = null)
            : base("aws:wafv2/ipSet:IpSet", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing IpSet resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static IpSet Get(string name, Input<string> id, IpSetState? state = null, CustomResourceOptions? options = null)
        {
            return new IpSet(name, id, state, options);
        }
    }

    public sealed class IpSetArgs : global::Pulumi.ResourceArgs
    {
        [Input("addresses")]
        private InputList<string>? _addresses;

        /// <summary>
        /// Contains an array of strings that specifies zero or more IP addresses or blocks of IP addresses. All addresses must be specified using Classless Inter-Domain Routing (CIDR) notation. WAF supports all IPv4 and IPv6 CIDR ranges except for `/0`.
        /// </summary>
        public InputList<string> Addresses
        {
            get => _addresses ?? (_addresses = new InputList<string>());
            set => _addresses = value;
        }

        /// <summary>
        /// A friendly description of the IP set.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Specify IPV4 or IPV6. Valid values are `IPV4` or `IPV6`.
        /// </summary>
        [Input("ipAddressVersion", required: true)]
        public Input<string> IpAddressVersion { get; set; } = null!;

        /// <summary>
        /// A friendly name of the IP set. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        /// <summary>
        /// Specifies whether this is for an AWS CloudFront distribution or for a regional application. Valid values are `CLOUDFRONT` or `REGIONAL`. To work with CloudFront, you must also specify the Region US East (N. Virginia).
        /// </summary>
        [Input("scope", required: true)]
        public Input<string> Scope { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// An array of key:value pairs to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public IpSetArgs()
        {
        }
        public static new IpSetArgs Empty => new IpSetArgs();
    }

    public sealed class IpSetState : global::Pulumi.ResourceArgs
    {
        [Input("addresses")]
        private InputList<string>? _addresses;

        /// <summary>
        /// Contains an array of strings that specifies zero or more IP addresses or blocks of IP addresses. All addresses must be specified using Classless Inter-Domain Routing (CIDR) notation. WAF supports all IPv4 and IPv6 CIDR ranges except for `/0`.
        /// </summary>
        public InputList<string> Addresses
        {
            get => _addresses ?? (_addresses = new InputList<string>());
            set => _addresses = value;
        }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the IP set.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// A friendly description of the IP set.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Specify IPV4 or IPV6. Valid values are `IPV4` or `IPV6`.
        /// </summary>
        [Input("ipAddressVersion")]
        public Input<string>? IpAddressVersion { get; set; }

        [Input("lockToken")]
        public Input<string>? LockToken { get; set; }

        /// <summary>
        /// A friendly name of the IP set. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        /// <summary>
        /// Specifies whether this is for an AWS CloudFront distribution or for a regional application. Valid values are `CLOUDFRONT` or `REGIONAL`. To work with CloudFront, you must also specify the Region US East (N. Virginia).
        /// </summary>
        [Input("scope")]
        public Input<string>? Scope { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// An array of key:value pairs to associate with the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public IpSetState()
        {
        }
        public static new IpSetState Empty => new IpSetState();
    }
}
