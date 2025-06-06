// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53
{
    /// <summary>
    /// Provides a Route 53 Resolver endpoint resource.
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
    ///     var foo = new Aws.Route53.ResolverEndpoint("foo", new()
    ///     {
    ///         Name = "foo",
    ///         Direction = "INBOUND",
    ///         ResolverEndpointType = "IPV4",
    ///         SecurityGroupIds = new[]
    ///         {
    ///             sg1.Id,
    ///             sg2.Id,
    ///         },
    ///         IpAddresses = new[]
    ///         {
    ///             new Aws.Route53.Inputs.ResolverEndpointIpAddressArgs
    ///             {
    ///                 SubnetId = sn1.Id,
    ///             },
    ///             new Aws.Route53.Inputs.ResolverEndpointIpAddressArgs
    ///             {
    ///                 SubnetId = sn2.Id,
    ///                 Ip = "10.0.64.4",
    ///             },
    ///         },
    ///         Protocols = new[]
    ///         {
    ///             "Do53",
    ///             "DoH",
    ///         },
    ///         Tags = 
    ///         {
    ///             { "Environment", "Prod" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import  Route 53 Resolver endpoints using the Route 53 Resolver endpoint ID. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:route53/resolverEndpoint:ResolverEndpoint foo rslvr-in-abcdef01234567890
    /// ```
    /// </summary>
    [AwsResourceType("aws:route53/resolverEndpoint:ResolverEndpoint")]
    public partial class ResolverEndpoint : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the Route 53 Resolver endpoint.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Direction of DNS queries to or from the Route 53 Resolver endpoint.
        /// Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
        /// or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
        /// </summary>
        [Output("direction")]
        public Output<string> Direction { get; private set; } = null!;

        /// <summary>
        /// ID of the VPC that you want to create the resolver endpoint in.
        /// </summary>
        [Output("hostVpcId")]
        public Output<string> HostVpcId { get; private set; } = null!;

        /// <summary>
        /// Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
        /// to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
        /// </summary>
        [Output("ipAddresses")]
        public Output<ImmutableArray<Outputs.ResolverEndpointIpAddress>> IpAddresses { get; private set; } = null!;

        /// <summary>
        /// Friendly name of the Route 53 Resolver endpoint.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Protocols you want to use for the Route 53 Resolver endpoint.
        /// Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
        /// </summary>
        [Output("protocols")]
        public Output<ImmutableArray<string>> Protocols { get; private set; } = null!;

        /// <summary>
        /// Endpoint IP type. This endpoint type is applied to all IP addresses.
        /// Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
        /// </summary>
        [Output("resolverEndpointType")]
        public Output<string> ResolverEndpointType { get; private set; } = null!;

        /// <summary>
        /// ID of one or more security groups that you want to use to control access to this VPC.
        /// </summary>
        [Output("securityGroupIds")]
        public Output<ImmutableArray<string>> SecurityGroupIds { get; private set; } = null!;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a ResolverEndpoint resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ResolverEndpoint(string name, ResolverEndpointArgs args, CustomResourceOptions? options = null)
            : base("aws:route53/resolverEndpoint:ResolverEndpoint", name, args ?? new ResolverEndpointArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ResolverEndpoint(string name, Input<string> id, ResolverEndpointState? state = null, CustomResourceOptions? options = null)
            : base("aws:route53/resolverEndpoint:ResolverEndpoint", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ResolverEndpoint resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ResolverEndpoint Get(string name, Input<string> id, ResolverEndpointState? state = null, CustomResourceOptions? options = null)
        {
            return new ResolverEndpoint(name, id, state, options);
        }
    }

    public sealed class ResolverEndpointArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Direction of DNS queries to or from the Route 53 Resolver endpoint.
        /// Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
        /// or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
        /// </summary>
        [Input("direction", required: true)]
        public Input<string> Direction { get; set; } = null!;

        [Input("ipAddresses", required: true)]
        private InputList<Inputs.ResolverEndpointIpAddressArgs>? _ipAddresses;

        /// <summary>
        /// Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
        /// to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
        /// </summary>
        public InputList<Inputs.ResolverEndpointIpAddressArgs> IpAddresses
        {
            get => _ipAddresses ?? (_ipAddresses = new InputList<Inputs.ResolverEndpointIpAddressArgs>());
            set => _ipAddresses = value;
        }

        /// <summary>
        /// Friendly name of the Route 53 Resolver endpoint.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("protocols")]
        private InputList<string>? _protocols;

        /// <summary>
        /// Protocols you want to use for the Route 53 Resolver endpoint.
        /// Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
        /// </summary>
        public InputList<string> Protocols
        {
            get => _protocols ?? (_protocols = new InputList<string>());
            set => _protocols = value;
        }

        /// <summary>
        /// Endpoint IP type. This endpoint type is applied to all IP addresses.
        /// Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
        /// </summary>
        [Input("resolverEndpointType")]
        public Input<string>? ResolverEndpointType { get; set; }

        [Input("securityGroupIds", required: true)]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// ID of one or more security groups that you want to use to control access to this VPC.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public ResolverEndpointArgs()
        {
        }
        public static new ResolverEndpointArgs Empty => new ResolverEndpointArgs();
    }

    public sealed class ResolverEndpointState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the Route 53 Resolver endpoint.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Direction of DNS queries to or from the Route 53 Resolver endpoint.
        /// Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
        /// or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
        /// </summary>
        [Input("direction")]
        public Input<string>? Direction { get; set; }

        /// <summary>
        /// ID of the VPC that you want to create the resolver endpoint in.
        /// </summary>
        [Input("hostVpcId")]
        public Input<string>? HostVpcId { get; set; }

        [Input("ipAddresses")]
        private InputList<Inputs.ResolverEndpointIpAddressGetArgs>? _ipAddresses;

        /// <summary>
        /// Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
        /// to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
        /// </summary>
        public InputList<Inputs.ResolverEndpointIpAddressGetArgs> IpAddresses
        {
            get => _ipAddresses ?? (_ipAddresses = new InputList<Inputs.ResolverEndpointIpAddressGetArgs>());
            set => _ipAddresses = value;
        }

        /// <summary>
        /// Friendly name of the Route 53 Resolver endpoint.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("protocols")]
        private InputList<string>? _protocols;

        /// <summary>
        /// Protocols you want to use for the Route 53 Resolver endpoint.
        /// Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
        /// </summary>
        public InputList<string> Protocols
        {
            get => _protocols ?? (_protocols = new InputList<string>());
            set => _protocols = value;
        }

        /// <summary>
        /// Endpoint IP type. This endpoint type is applied to all IP addresses.
        /// Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
        /// </summary>
        [Input("resolverEndpointType")]
        public Input<string>? ResolverEndpointType { get; set; }

        [Input("securityGroupIds")]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// ID of one or more security groups that you want to use to control access to this VPC.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public ResolverEndpointState()
        {
        }
        public static new ResolverEndpointState Empty => new ResolverEndpointState();
    }
}
