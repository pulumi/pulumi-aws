// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Rds
{
    /// <summary>
    /// Provides an RDS DB proxy endpoint resource. For additional information, see the [RDS User Guide](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/rds-proxy-endpoints.html).
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
    ///     var example = new Aws.Rds.ProxyEndpoint("example", new()
    ///     {
    ///         DbProxyName = test.Name,
    ///         DbProxyEndpointName = "example",
    ///         VpcSubnetIds = testAwsSubnet.Select(__item =&gt; __item.Id).ToList(),
    ///         TargetRole = "READ_ONLY",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import DB proxy endpoints using the `DB-PROXY-NAME/DB-PROXY-ENDPOINT-NAME`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:rds/proxyEndpoint:ProxyEndpoint example example/example
    /// ```
    /// </summary>
    [AwsResourceType("aws:rds/proxyEndpoint:ProxyEndpoint")]
    public partial class ProxyEndpoint : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) for the proxy endpoint.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The identifier for the proxy endpoint. An identifier must begin with a letter and must contain only ASCII letters, digits, and hyphens; it can't end with a hyphen or contain two consecutive hyphens.
        /// </summary>
        [Output("dbProxyEndpointName")]
        public Output<string> DbProxyEndpointName { get; private set; } = null!;

        /// <summary>
        /// The name of the DB proxy associated with the DB proxy endpoint that you create.
        /// </summary>
        [Output("dbProxyName")]
        public Output<string> DbProxyName { get; private set; } = null!;

        /// <summary>
        /// The endpoint that you can use to connect to the proxy. You include the endpoint value in the connection string for a database client application.
        /// </summary>
        [Output("endpoint")]
        public Output<string> Endpoint { get; private set; } = null!;

        /// <summary>
        /// Indicates whether this endpoint is the default endpoint for the associated DB proxy.
        /// </summary>
        [Output("isDefault")]
        public Output<bool> IsDefault { get; private set; } = null!;

        /// <summary>
        /// A mapping of tags to assign to the resource.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// Indicates whether the DB proxy endpoint can be used for read/write or read-only operations. The default is `READ_WRITE`. Valid values are `READ_WRITE` and `READ_ONLY`.
        /// </summary>
        [Output("targetRole")]
        public Output<string?> TargetRole { get; private set; } = null!;

        /// <summary>
        /// The VPC ID of the DB proxy endpoint.
        /// </summary>
        [Output("vpcId")]
        public Output<string> VpcId { get; private set; } = null!;

        /// <summary>
        /// One or more VPC security group IDs to associate with the new proxy.
        /// </summary>
        [Output("vpcSecurityGroupIds")]
        public Output<ImmutableArray<string>> VpcSecurityGroupIds { get; private set; } = null!;

        /// <summary>
        /// One or more VPC subnet IDs to associate with the new proxy.
        /// </summary>
        [Output("vpcSubnetIds")]
        public Output<ImmutableArray<string>> VpcSubnetIds { get; private set; } = null!;


        /// <summary>
        /// Create a ProxyEndpoint resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ProxyEndpoint(string name, ProxyEndpointArgs args, CustomResourceOptions? options = null)
            : base("aws:rds/proxyEndpoint:ProxyEndpoint", name, args ?? new ProxyEndpointArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ProxyEndpoint(string name, Input<string> id, ProxyEndpointState? state = null, CustomResourceOptions? options = null)
            : base("aws:rds/proxyEndpoint:ProxyEndpoint", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ProxyEndpoint resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ProxyEndpoint Get(string name, Input<string> id, ProxyEndpointState? state = null, CustomResourceOptions? options = null)
        {
            return new ProxyEndpoint(name, id, state, options);
        }
    }

    public sealed class ProxyEndpointArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The identifier for the proxy endpoint. An identifier must begin with a letter and must contain only ASCII letters, digits, and hyphens; it can't end with a hyphen or contain two consecutive hyphens.
        /// </summary>
        [Input("dbProxyEndpointName", required: true)]
        public Input<string> DbProxyEndpointName { get; set; } = null!;

        /// <summary>
        /// The name of the DB proxy associated with the DB proxy endpoint that you create.
        /// </summary>
        [Input("dbProxyName", required: true)]
        public Input<string> DbProxyName { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A mapping of tags to assign to the resource.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// Indicates whether the DB proxy endpoint can be used for read/write or read-only operations. The default is `READ_WRITE`. Valid values are `READ_WRITE` and `READ_ONLY`.
        /// </summary>
        [Input("targetRole")]
        public Input<string>? TargetRole { get; set; }

        [Input("vpcSecurityGroupIds")]
        private InputList<string>? _vpcSecurityGroupIds;

        /// <summary>
        /// One or more VPC security group IDs to associate with the new proxy.
        /// </summary>
        public InputList<string> VpcSecurityGroupIds
        {
            get => _vpcSecurityGroupIds ?? (_vpcSecurityGroupIds = new InputList<string>());
            set => _vpcSecurityGroupIds = value;
        }

        [Input("vpcSubnetIds", required: true)]
        private InputList<string>? _vpcSubnetIds;

        /// <summary>
        /// One or more VPC subnet IDs to associate with the new proxy.
        /// </summary>
        public InputList<string> VpcSubnetIds
        {
            get => _vpcSubnetIds ?? (_vpcSubnetIds = new InputList<string>());
            set => _vpcSubnetIds = value;
        }

        public ProxyEndpointArgs()
        {
        }
        public static new ProxyEndpointArgs Empty => new ProxyEndpointArgs();
    }

    public sealed class ProxyEndpointState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) for the proxy endpoint.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The identifier for the proxy endpoint. An identifier must begin with a letter and must contain only ASCII letters, digits, and hyphens; it can't end with a hyphen or contain two consecutive hyphens.
        /// </summary>
        [Input("dbProxyEndpointName")]
        public Input<string>? DbProxyEndpointName { get; set; }

        /// <summary>
        /// The name of the DB proxy associated with the DB proxy endpoint that you create.
        /// </summary>
        [Input("dbProxyName")]
        public Input<string>? DbProxyName { get; set; }

        /// <summary>
        /// The endpoint that you can use to connect to the proxy. You include the endpoint value in the connection string for a database client application.
        /// </summary>
        [Input("endpoint")]
        public Input<string>? Endpoint { get; set; }

        /// <summary>
        /// Indicates whether this endpoint is the default endpoint for the associated DB proxy.
        /// </summary>
        [Input("isDefault")]
        public Input<bool>? IsDefault { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A mapping of tags to assign to the resource.
        /// </summary>
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

        /// <summary>
        /// Indicates whether the DB proxy endpoint can be used for read/write or read-only operations. The default is `READ_WRITE`. Valid values are `READ_WRITE` and `READ_ONLY`.
        /// </summary>
        [Input("targetRole")]
        public Input<string>? TargetRole { get; set; }

        /// <summary>
        /// The VPC ID of the DB proxy endpoint.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        [Input("vpcSecurityGroupIds")]
        private InputList<string>? _vpcSecurityGroupIds;

        /// <summary>
        /// One or more VPC security group IDs to associate with the new proxy.
        /// </summary>
        public InputList<string> VpcSecurityGroupIds
        {
            get => _vpcSecurityGroupIds ?? (_vpcSecurityGroupIds = new InputList<string>());
            set => _vpcSecurityGroupIds = value;
        }

        [Input("vpcSubnetIds")]
        private InputList<string>? _vpcSubnetIds;

        /// <summary>
        /// One or more VPC subnet IDs to associate with the new proxy.
        /// </summary>
        public InputList<string> VpcSubnetIds
        {
            get => _vpcSubnetIds ?? (_vpcSubnetIds = new InputList<string>());
            set => _vpcSubnetIds = value;
        }

        public ProxyEndpointState()
        {
        }
        public static new ProxyEndpointState Empty => new ProxyEndpointState();
    }
}
