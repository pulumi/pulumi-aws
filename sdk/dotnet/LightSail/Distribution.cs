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
    /// Resource for managing an AWS Lightsail Distribution.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic Usage
    /// 
    /// Below is a basic example with a bucket as an origin.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var test = new Aws.LightSail.Bucket("test", new()
    ///     {
    ///         Name = "test-bucket",
    ///         BundleId = "small_1_0",
    ///     });
    /// 
    ///     var testDistribution = new Aws.LightSail.Distribution("test", new()
    ///     {
    ///         Name = "test-distribution",
    ///         BundleId = "small_1_0",
    ///         Origin = new Aws.LightSail.Inputs.DistributionOriginArgs
    ///         {
    ///             Name = test.Name,
    ///             RegionName = test.Region,
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
    /// ### instance origin example
    /// 
    /// Below is an example of an instance as the origin.
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
    ///     var testStaticIp = new Aws.LightSail.StaticIp("test", new()
    ///     {
    ///         Name = "test-static-ip",
    ///     });
    /// 
    ///     var testInstance = new Aws.LightSail.Instance("test", new()
    ///     {
    ///         Name = "test-instance",
    ///         AvailabilityZone = available.Apply(getAvailabilityZonesResult =&gt; getAvailabilityZonesResult.Names[0]),
    ///         BlueprintId = "amazon_linux_2",
    ///         BundleId = "micro_1_0",
    ///     });
    /// 
    ///     var test = new Aws.LightSail.StaticIpAttachment("test", new()
    ///     {
    ///         StaticIpName = testStaticIp.Name,
    ///         InstanceName = testInstance.Name,
    ///     });
    /// 
    ///     var testDistribution = new Aws.LightSail.Distribution("test", new()
    ///     {
    ///         Name = "test-distribution",
    ///         BundleId = "small_1_0",
    ///         Origin = new Aws.LightSail.Inputs.DistributionOriginArgs
    ///         {
    ///             Name = testInstance.Name,
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
    ///             test,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### lb origin example
    /// 
    /// Below is an example with a load balancer as an origin
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
    ///     var test = new Aws.LightSail.Lb("test", new()
    ///     {
    ///         Name = "test-load-balancer",
    ///         HealthCheckPath = "/",
    ///         InstancePort = 80,
    ///         Tags = 
    ///         {
    ///             { "foo", "bar" },
    ///         },
    ///     });
    /// 
    ///     var testInstance = new Aws.LightSail.Instance("test", new()
    ///     {
    ///         Name = "test-instance",
    ///         AvailabilityZone = available.Apply(getAvailabilityZonesResult =&gt; getAvailabilityZonesResult.Names[0]),
    ///         BlueprintId = "amazon_linux_2",
    ///         BundleId = "nano_3_0",
    ///     });
    /// 
    ///     var testLbAttachment = new Aws.LightSail.LbAttachment("test", new()
    ///     {
    ///         LbName = test.Name,
    ///         InstanceName = testInstance.Name,
    ///     });
    /// 
    ///     var testDistribution = new Aws.LightSail.Distribution("test", new()
    ///     {
    ///         Name = "test-distribution",
    ///         BundleId = "small_1_0",
    ///         Origin = new Aws.LightSail.Inputs.DistributionOriginArgs
    ///         {
    ///             Name = test.Name,
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
    ///             testLbAttachment,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Lightsail Distribution using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:lightsail/distribution:Distribution example rft-8012925589
    /// ```
    /// </summary>
    [AwsResourceType("aws:lightsail/distribution:Distribution")]
    public partial class Distribution : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The alternate domain names of the distribution.
        /// </summary>
        [Output("alternativeDomainNames")]
        public Output<ImmutableArray<string>> AlternativeDomainNames { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the distribution.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Bundle ID to use for the distribution.
        /// </summary>
        [Output("bundleId")]
        public Output<string> BundleId { get; private set; } = null!;

        /// <summary>
        /// An object that describes the cache behavior settings of the distribution. Detailed below
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("cacheBehaviorSettings")]
        public Output<Outputs.DistributionCacheBehaviorSettings?> CacheBehaviorSettings { get; private set; } = null!;

        /// <summary>
        /// A set of configuration blocks that describe the per-path cache behavior of the distribution. Detailed below
        /// </summary>
        [Output("cacheBehaviors")]
        public Output<ImmutableArray<Outputs.DistributionCacheBehavior>> CacheBehaviors { get; private set; } = null!;

        /// <summary>
        /// The name of the SSL/TLS certificate attached to the distribution, if any.
        /// </summary>
        [Output("certificateName")]
        public Output<string?> CertificateName { get; private set; } = null!;

        /// <summary>
        /// The timestamp when the distribution was created.
        /// </summary>
        [Output("createdAt")]
        public Output<string> CreatedAt { get; private set; } = null!;

        /// <summary>
        /// Object that describes the default cache behavior of the distribution. Detailed below
        /// </summary>
        [Output("defaultCacheBehavior")]
        public Output<Outputs.DistributionDefaultCacheBehavior> DefaultCacheBehavior { get; private set; } = null!;

        /// <summary>
        /// The domain name of the distribution.
        /// </summary>
        [Output("domainName")]
        public Output<string> DomainName { get; private set; } = null!;

        /// <summary>
        /// The IP address type of the distribution. Default: `dualstack`.
        /// </summary>
        [Output("ipAddressType")]
        public Output<string?> IpAddressType { get; private set; } = null!;

        /// <summary>
        /// Indicates whether the distribution is enabled. Default: `true`.
        /// </summary>
        [Output("isEnabled")]
        public Output<bool?> IsEnabled { get; private set; } = null!;

        /// <summary>
        /// An object that describes the location of the distribution, such as the AWS Region and Availability Zone. Detailed below
        /// </summary>
        [Output("locations")]
        public Output<ImmutableArray<Outputs.DistributionLocation>> Locations { get; private set; } = null!;

        /// <summary>
        /// Name of the distribution.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Object that describes the origin resource of the distribution, such as a Lightsail instance, bucket, or load balancer. Detailed below
        /// </summary>
        [Output("origin")]
        public Output<Outputs.DistributionOrigin> Origin { get; private set; } = null!;

        /// <summary>
        /// The public DNS of the origin.
        /// </summary>
        [Output("originPublicDns")]
        public Output<string> OriginPublicDns { get; private set; } = null!;

        /// <summary>
        /// The Lightsail resource type (e.g., Distribution).
        /// </summary>
        [Output("resourceType")]
        public Output<string> ResourceType { get; private set; } = null!;

        /// <summary>
        /// The status of the distribution.
        /// </summary>
        [Output("status")]
        public Output<string> Status { get; private set; } = null!;

        /// <summary>
        /// The support code. Include this code in your email to support when you have questions about your Lightsail distribution. This code enables our support team to look up your Lightsail information more easily.
        /// </summary>
        [Output("supportCode")]
        public Output<string> SupportCode { get; private set; } = null!;

        /// <summary>
        /// Map of tags for the Lightsail Distribution. To create a key-only tag, use an empty string as the value. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
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
        /// An object that describes the cache behavior settings of the distribution. Detailed below
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("cacheBehaviorSettings")]
        public Input<Inputs.DistributionCacheBehaviorSettingsArgs>? CacheBehaviorSettings { get; set; }

        [Input("cacheBehaviors")]
        private InputList<Inputs.DistributionCacheBehaviorArgs>? _cacheBehaviors;

        /// <summary>
        /// A set of configuration blocks that describe the per-path cache behavior of the distribution. Detailed below
        /// </summary>
        public InputList<Inputs.DistributionCacheBehaviorArgs> CacheBehaviors
        {
            get => _cacheBehaviors ?? (_cacheBehaviors = new InputList<Inputs.DistributionCacheBehaviorArgs>());
            set => _cacheBehaviors = value;
        }

        /// <summary>
        /// The name of the SSL/TLS certificate attached to the distribution, if any.
        /// </summary>
        [Input("certificateName")]
        public Input<string>? CertificateName { get; set; }

        /// <summary>
        /// Object that describes the default cache behavior of the distribution. Detailed below
        /// </summary>
        [Input("defaultCacheBehavior", required: true)]
        public Input<Inputs.DistributionDefaultCacheBehaviorArgs> DefaultCacheBehavior { get; set; } = null!;

        /// <summary>
        /// The IP address type of the distribution. Default: `dualstack`.
        /// </summary>
        [Input("ipAddressType")]
        public Input<string>? IpAddressType { get; set; }

        /// <summary>
        /// Indicates whether the distribution is enabled. Default: `true`.
        /// </summary>
        [Input("isEnabled")]
        public Input<bool>? IsEnabled { get; set; }

        /// <summary>
        /// Name of the distribution.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Object that describes the origin resource of the distribution, such as a Lightsail instance, bucket, or load balancer. Detailed below
        /// </summary>
        [Input("origin", required: true)]
        public Input<Inputs.DistributionOriginArgs> Origin { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags for the Lightsail Distribution. To create a key-only tag, use an empty string as the value. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
        /// The alternate domain names of the distribution.
        /// </summary>
        public InputList<string> AlternativeDomainNames
        {
            get => _alternativeDomainNames ?? (_alternativeDomainNames = new InputList<string>());
            set => _alternativeDomainNames = value;
        }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the distribution.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Bundle ID to use for the distribution.
        /// </summary>
        [Input("bundleId")]
        public Input<string>? BundleId { get; set; }

        /// <summary>
        /// An object that describes the cache behavior settings of the distribution. Detailed below
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("cacheBehaviorSettings")]
        public Input<Inputs.DistributionCacheBehaviorSettingsGetArgs>? CacheBehaviorSettings { get; set; }

        [Input("cacheBehaviors")]
        private InputList<Inputs.DistributionCacheBehaviorGetArgs>? _cacheBehaviors;

        /// <summary>
        /// A set of configuration blocks that describe the per-path cache behavior of the distribution. Detailed below
        /// </summary>
        public InputList<Inputs.DistributionCacheBehaviorGetArgs> CacheBehaviors
        {
            get => _cacheBehaviors ?? (_cacheBehaviors = new InputList<Inputs.DistributionCacheBehaviorGetArgs>());
            set => _cacheBehaviors = value;
        }

        /// <summary>
        /// The name of the SSL/TLS certificate attached to the distribution, if any.
        /// </summary>
        [Input("certificateName")]
        public Input<string>? CertificateName { get; set; }

        /// <summary>
        /// The timestamp when the distribution was created.
        /// </summary>
        [Input("createdAt")]
        public Input<string>? CreatedAt { get; set; }

        /// <summary>
        /// Object that describes the default cache behavior of the distribution. Detailed below
        /// </summary>
        [Input("defaultCacheBehavior")]
        public Input<Inputs.DistributionDefaultCacheBehaviorGetArgs>? DefaultCacheBehavior { get; set; }

        /// <summary>
        /// The domain name of the distribution.
        /// </summary>
        [Input("domainName")]
        public Input<string>? DomainName { get; set; }

        /// <summary>
        /// The IP address type of the distribution. Default: `dualstack`.
        /// </summary>
        [Input("ipAddressType")]
        public Input<string>? IpAddressType { get; set; }

        /// <summary>
        /// Indicates whether the distribution is enabled. Default: `true`.
        /// </summary>
        [Input("isEnabled")]
        public Input<bool>? IsEnabled { get; set; }

        [Input("locations")]
        private InputList<Inputs.DistributionLocationGetArgs>? _locations;

        /// <summary>
        /// An object that describes the location of the distribution, such as the AWS Region and Availability Zone. Detailed below
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
        /// Object that describes the origin resource of the distribution, such as a Lightsail instance, bucket, or load balancer. Detailed below
        /// </summary>
        [Input("origin")]
        public Input<Inputs.DistributionOriginGetArgs>? Origin { get; set; }

        /// <summary>
        /// The public DNS of the origin.
        /// </summary>
        [Input("originPublicDns")]
        public Input<string>? OriginPublicDns { get; set; }

        /// <summary>
        /// The Lightsail resource type (e.g., Distribution).
        /// </summary>
        [Input("resourceType")]
        public Input<string>? ResourceType { get; set; }

        /// <summary>
        /// The status of the distribution.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        /// <summary>
        /// The support code. Include this code in your email to support when you have questions about your Lightsail distribution. This code enables our support team to look up your Lightsail information more easily.
        /// </summary>
        [Input("supportCode")]
        public Input<string>? SupportCode { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags for the Lightsail Distribution. To create a key-only tag, use an empty string as the value. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public DistributionState()
        {
        }
        public static new DistributionState Empty => new DistributionState();
    }
}
