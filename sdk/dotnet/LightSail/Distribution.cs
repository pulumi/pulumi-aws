// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LightSail
{
    /// <summary>
    /// Manages a Lightsail content delivery network (CDN) distribution. Use this resource to cache content at edge locations and reduce latency for users accessing your content.
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
    ///     var example = new Aws.LightSail.Bucket("example", new()
    ///     {
    ///         Name = "example-bucket",
    ///         BundleId = "small_1_0",
    ///     });
    /// 
    ///     var exampleDistribution = new Aws.LightSail.Distribution("example", new()
    ///     {
    ///         Name = "example-distribution",
    ///         BundleId = "small_1_0",
    ///         Origin = new Aws.LightSail.Inputs.DistributionOriginArgs
    ///         {
    ///             Name = example.Name,
    ///             RegionName = example.Region,
    ///         },
    ///         DefaultCacheBehavior = new Aws.LightSail.Inputs.DistributionDefaultCacheBehaviorArgs
    ///         {
    ///             Behavior = "cache",
    ///         },
    ///         CacheBehaviorSettings = new Aws.LightSail.Inputs.DistributionCacheBehaviorSettingsArgs
    ///         {
    ///             AllowedHttpMethods = "GET,HEAD,OPTIONS,PUT,PATCH,POST,DELETE",
    ///             CachedHttpMethods = "GET,HEAD",
    ///             DefaultTtl = 86400,
    ///             MaximumTtl = 31536000,
    ///             MinimumTtl = 0,
    ///             ForwardedCookies = new Aws.LightSail.Inputs.DistributionCacheBehaviorSettingsForwardedCookiesArgs
    ///             {
    ///                 Option = "none",
    ///             },
    ///             ForwardedHeaders = new Aws.LightSail.Inputs.DistributionCacheBehaviorSettingsForwardedHeadersArgs
    ///             {
    ///                 Option = "default",
    ///             },
    ///             ForwardedQueryStrings = new Aws.LightSail.Inputs.DistributionCacheBehaviorSettingsForwardedQueryStringsArgs
    ///             {
    ///                 Option = false,
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Instance Origin
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var available = Aws.GetAvailabilityZones.Invoke(new()
    ///     {
    ///         State = "available",
    ///         Filters = new[]
    ///         {
    ///             new Aws.Inputs.GetAvailabilityZonesFilterInputArgs
    ///             {
    ///                 Name = "opt-in-status",
    ///                 Values = new[]
    ///                 {
    ///                     "opt-in-not-required",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleStaticIp = new Aws.LightSail.StaticIp("example", new()
    ///     {
    ///         Name = "example-static-ip",
    ///     });
    /// 
    ///     var exampleInstance = new Aws.LightSail.Instance("example", new()
    ///     {
    ///         Name = "example-instance",
    ///         AvailabilityZone = available.Apply(getAvailabilityZonesResult =&gt; getAvailabilityZonesResult.Names[0]),
    ///         BlueprintId = "amazon_linux_2",
    ///         BundleId = "micro_1_0",
    ///     });
    /// 
    ///     var example = new Aws.LightSail.StaticIpAttachment("example", new()
    ///     {
    ///         StaticIpName = exampleStaticIp.Name,
    ///         InstanceName = exampleInstance.Name,
    ///     });
    /// 
    ///     var exampleDistribution = new Aws.LightSail.Distribution("example", new()
    ///     {
    ///         Name = "example-distribution",
    ///         BundleId = "small_1_0",
    ///         Origin = new Aws.LightSail.Inputs.DistributionOriginArgs
    ///         {
    ///             Name = exampleInstance.Name,
    ///             RegionName = available.Apply(getAvailabilityZonesResult =&gt; getAvailabilityZonesResult.Id),
    ///         },
    ///         DefaultCacheBehavior = new Aws.LightSail.Inputs.DistributionDefaultCacheBehaviorArgs
    ///         {
    ///             Behavior = "cache",
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
    /// ### Load Balancer Origin
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var available = Aws.GetAvailabilityZones.Invoke(new()
    ///     {
    ///         State = "available",
    ///         Filters = new[]
    ///         {
    ///             new Aws.Inputs.GetAvailabilityZonesFilterInputArgs
    ///             {
    ///                 Name = "opt-in-status",
    ///                 Values = new[]
    ///                 {
    ///                     "opt-in-not-required",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var example = new Aws.LightSail.Lb("example", new()
    ///     {
    ///         Name = "example-load-balancer",
    ///         HealthCheckPath = "/",
    ///         InstancePort = 80,
    ///         Tags = 
    ///         {
    ///             { "foo", "bar" },
    ///         },
    ///     });
    /// 
    ///     var exampleInstance = new Aws.LightSail.Instance("example", new()
    ///     {
    ///         Name = "example-instance",
    ///         AvailabilityZone = available.Apply(getAvailabilityZonesResult =&gt; getAvailabilityZonesResult.Names[0]),
    ///         BlueprintId = "amazon_linux_2",
    ///         BundleId = "nano_3_0",
    ///     });
    /// 
    ///     var exampleLbAttachment = new Aws.LightSail.LbAttachment("example", new()
    ///     {
    ///         LbName = example.Name,
    ///         InstanceName = exampleInstance.Name,
    ///     });
    /// 
    ///     var exampleDistribution = new Aws.LightSail.Distribution("example", new()
    ///     {
    ///         Name = "example-distribution",
    ///         BundleId = "small_1_0",
    ///         Origin = new Aws.LightSail.Inputs.DistributionOriginArgs
    ///         {
    ///             Name = example.Name,
    ///             RegionName = available.Apply(getAvailabilityZonesResult =&gt; getAvailabilityZonesResult.Id),
    ///         },
    ///         DefaultCacheBehavior = new Aws.LightSail.Inputs.DistributionDefaultCacheBehaviorArgs
    ///         {
    ///             Behavior = "cache",
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             exampleLbAttachment,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Lightsail Distribution using the `name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:lightsail/distribution:Distribution example example-distribution
    /// ```
    /// </summary>
    [AwsResourceType("aws:lightsail/distribution:Distribution")]
    public partial class Distribution : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Alternate domain names of the distribution.
        /// </summary>
        [Output("alternativeDomainNames")]
        public Output<ImmutableArray<string>> AlternativeDomainNames { get; private set; } = null!;

        /// <summary>
        /// ARN of the distribution.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Bundle ID to use for the distribution.
        /// </summary>
        [Output("bundleId")]
        public Output<string> BundleId { get; private set; } = null!;

        /// <summary>
        /// Cache behavior settings of the distribution. See below.
        /// </summary>
        [Output("cacheBehaviorSettings")]
        public Output<Outputs.DistributionCacheBehaviorSettings?> CacheBehaviorSettings { get; private set; } = null!;

        /// <summary>
        /// Per-path cache behavior of the distribution. See below.
        /// </summary>
        [Output("cacheBehaviors")]
        public Output<ImmutableArray<Outputs.DistributionCacheBehavior>> CacheBehaviors { get; private set; } = null!;

        /// <summary>
        /// Name of the SSL/TLS certificate attached to the distribution.
        /// </summary>
        [Output("certificateName")]
        public Output<string?> CertificateName { get; private set; } = null!;

        /// <summary>
        /// Timestamp when the distribution was created.
        /// </summary>
        [Output("createdAt")]
        public Output<string> CreatedAt { get; private set; } = null!;

        /// <summary>
        /// Default cache behavior of the distribution. See below.
        /// </summary>
        [Output("defaultCacheBehavior")]
        public Output<Outputs.DistributionDefaultCacheBehavior> DefaultCacheBehavior { get; private set; } = null!;

        /// <summary>
        /// Domain name of the distribution.
        /// </summary>
        [Output("domainName")]
        public Output<string> DomainName { get; private set; } = null!;

        /// <summary>
        /// IP address type of the distribution. Valid values: `dualstack`, `ipv4`. Default: `dualstack`.
        /// </summary>
        [Output("ipAddressType")]
        public Output<string?> IpAddressType { get; private set; } = null!;

        /// <summary>
        /// Whether the distribution is enabled. Default: `true`.
        /// </summary>
        [Output("isEnabled")]
        public Output<bool?> IsEnabled { get; private set; } = null!;

        /// <summary>
        /// Location of the distribution, such as the AWS Region and Availability Zone. See below.
        /// </summary>
        [Output("locations")]
        public Output<ImmutableArray<Outputs.DistributionLocation>> Locations { get; private set; } = null!;

        /// <summary>
        /// Name of the distribution.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Origin resource of the distribution, such as a Lightsail instance, bucket, or load balancer. See below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("origin")]
        public Output<Outputs.DistributionOrigin> Origin { get; private set; } = null!;

        /// <summary>
        /// Public DNS of the origin.
        /// * `origin[0].resource_type` - Resource type of the origin resource (e.g., Instance).
        /// </summary>
        [Output("originPublicDns")]
        public Output<string> OriginPublicDns { get; private set; } = null!;

        /// <summary>
        /// Lightsail resource type (e.g., Distribution).
        /// </summary>
        [Output("resourceType")]
        public Output<string> ResourceType { get; private set; } = null!;

        /// <summary>
        /// Status of the distribution.
        /// </summary>
        [Output("status")]
        public Output<string> Status { get; private set; } = null!;

        /// <summary>
        /// Support code. Include this code in your email to support when you have questions about your Lightsail distribution. This code enables our support team to look up your Lightsail information more easily.
        /// </summary>
        [Output("supportCode")]
        public Output<string> SupportCode { get; private set; } = null!;

        /// <summary>
        /// Map of tags for the Lightsail Distribution. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a Distribution resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Distribution(string name, DistributionArgs args, CustomResourceOptions? options = null)
            : base("aws:lightsail/distribution:Distribution", name, args ?? new DistributionArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Distribution(string name, Input<string> id, DistributionState? state = null, CustomResourceOptions? options = null)
            : base("aws:lightsail/distribution:Distribution", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Distribution resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Distribution Get(string name, Input<string> id, DistributionState? state = null, CustomResourceOptions? options = null)
        {
            return new Distribution(name, id, state, options);
        }
    }

    public sealed class DistributionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Bundle ID to use for the distribution.
        /// </summary>
        [Input("bundleId", required: true)]
        public Input<string> BundleId { get; set; } = null!;

        /// <summary>
        /// Cache behavior settings of the distribution. See below.
        /// </summary>
        [Input("cacheBehaviorSettings")]
        public Input<Inputs.DistributionCacheBehaviorSettingsArgs>? CacheBehaviorSettings { get; set; }

        [Input("cacheBehaviors")]
        private InputList<Inputs.DistributionCacheBehaviorArgs>? _cacheBehaviors;

        /// <summary>
        /// Per-path cache behavior of the distribution. See below.
        /// </summary>
        public InputList<Inputs.DistributionCacheBehaviorArgs> CacheBehaviors
        {
            get => _cacheBehaviors ?? (_cacheBehaviors = new InputList<Inputs.DistributionCacheBehaviorArgs>());
            set => _cacheBehaviors = value;
        }

        /// <summary>
        /// Name of the SSL/TLS certificate attached to the distribution.
        /// </summary>
        [Input("certificateName")]
        public Input<string>? CertificateName { get; set; }

        /// <summary>
        /// Default cache behavior of the distribution. See below.
        /// </summary>
        [Input("defaultCacheBehavior", required: true)]
        public Input<Inputs.DistributionDefaultCacheBehaviorArgs> DefaultCacheBehavior { get; set; } = null!;

        /// <summary>
        /// IP address type of the distribution. Valid values: `dualstack`, `ipv4`. Default: `dualstack`.
        /// </summary>
        [Input("ipAddressType")]
        public Input<string>? IpAddressType { get; set; }

        /// <summary>
        /// Whether the distribution is enabled. Default: `true`.
        /// </summary>
        [Input("isEnabled")]
        public Input<bool>? IsEnabled { get; set; }

        /// <summary>
        /// Name of the distribution.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Origin resource of the distribution, such as a Lightsail instance, bucket, or load balancer. See below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("origin", required: true)]
        public Input<Inputs.DistributionOriginArgs> Origin { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags for the Lightsail Distribution. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public DistributionArgs()
        {
        }
        public static new DistributionArgs Empty => new DistributionArgs();
    }

    public sealed class DistributionState : global::Pulumi.ResourceArgs
    {
        [Input("alternativeDomainNames")]
        private InputList<string>? _alternativeDomainNames;

        /// <summary>
        /// Alternate domain names of the distribution.
        /// </summary>
        public InputList<string> AlternativeDomainNames
        {
            get => _alternativeDomainNames ?? (_alternativeDomainNames = new InputList<string>());
            set => _alternativeDomainNames = value;
        }

        /// <summary>
        /// ARN of the distribution.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Bundle ID to use for the distribution.
        /// </summary>
        [Input("bundleId")]
        public Input<string>? BundleId { get; set; }

        /// <summary>
        /// Cache behavior settings of the distribution. See below.
        /// </summary>
        [Input("cacheBehaviorSettings")]
        public Input<Inputs.DistributionCacheBehaviorSettingsGetArgs>? CacheBehaviorSettings { get; set; }

        [Input("cacheBehaviors")]
        private InputList<Inputs.DistributionCacheBehaviorGetArgs>? _cacheBehaviors;

        /// <summary>
        /// Per-path cache behavior of the distribution. See below.
        /// </summary>
        public InputList<Inputs.DistributionCacheBehaviorGetArgs> CacheBehaviors
        {
            get => _cacheBehaviors ?? (_cacheBehaviors = new InputList<Inputs.DistributionCacheBehaviorGetArgs>());
            set => _cacheBehaviors = value;
        }

        /// <summary>
        /// Name of the SSL/TLS certificate attached to the distribution.
        /// </summary>
        [Input("certificateName")]
        public Input<string>? CertificateName { get; set; }

        /// <summary>
        /// Timestamp when the distribution was created.
        /// </summary>
        [Input("createdAt")]
        public Input<string>? CreatedAt { get; set; }

        /// <summary>
        /// Default cache behavior of the distribution. See below.
        /// </summary>
        [Input("defaultCacheBehavior")]
        public Input<Inputs.DistributionDefaultCacheBehaviorGetArgs>? DefaultCacheBehavior { get; set; }

        /// <summary>
        /// Domain name of the distribution.
        /// </summary>
        [Input("domainName")]
        public Input<string>? DomainName { get; set; }

        /// <summary>
        /// IP address type of the distribution. Valid values: `dualstack`, `ipv4`. Default: `dualstack`.
        /// </summary>
        [Input("ipAddressType")]
        public Input<string>? IpAddressType { get; set; }

        /// <summary>
        /// Whether the distribution is enabled. Default: `true`.
        /// </summary>
        [Input("isEnabled")]
        public Input<bool>? IsEnabled { get; set; }

        [Input("locations")]
        private InputList<Inputs.DistributionLocationGetArgs>? _locations;

        /// <summary>
        /// Location of the distribution, such as the AWS Region and Availability Zone. See below.
        /// </summary>
        public InputList<Inputs.DistributionLocationGetArgs> Locations
        {
            get => _locations ?? (_locations = new InputList<Inputs.DistributionLocationGetArgs>());
            set => _locations = value;
        }

        /// <summary>
        /// Name of the distribution.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Origin resource of the distribution, such as a Lightsail instance, bucket, or load balancer. See below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("origin")]
        public Input<Inputs.DistributionOriginGetArgs>? Origin { get; set; }

        /// <summary>
        /// Public DNS of the origin.
        /// * `origin[0].resource_type` - Resource type of the origin resource (e.g., Instance).
        /// </summary>
        [Input("originPublicDns")]
        public Input<string>? OriginPublicDns { get; set; }

        /// <summary>
        /// Lightsail resource type (e.g., Distribution).
        /// </summary>
        [Input("resourceType")]
        public Input<string>? ResourceType { get; set; }

        /// <summary>
        /// Status of the distribution.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        /// <summary>
        /// Support code. Include this code in your email to support when you have questions about your Lightsail distribution. This code enables our support team to look up your Lightsail information more easily.
        /// </summary>
        [Input("supportCode")]
        public Input<string>? SupportCode { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags for the Lightsail Distribution. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public DistributionState()
        {
        }
        public static new DistributionState Empty => new DistributionState();
    }
}
