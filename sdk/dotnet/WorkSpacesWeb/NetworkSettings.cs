// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WorkSpacesWeb
{
    /// <summary>
    /// Resource for managing an AWS WorkSpaces Web Network Settings resource. Once associated with a web portal, network settings define how streaming instances will connect with your specified VPC.
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
    /// using Std = Pulumi.Std;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Ec2.Vpc("example", new()
    ///     {
    ///         CidrBlock = "10.0.0.0/16",
    ///     });
    /// 
    ///     var exampleSubnet = new List&lt;Aws.Ec2.Subnet&gt;();
    ///     for (var rangeIndex = 0; rangeIndex &lt; 2; rangeIndex++)
    ///     {
    ///         var range = new { Value = rangeIndex };
    ///         exampleSubnet.Add(new Aws.Ec2.Subnet($"example-{range.Value}", new()
    ///         {
    ///             VpcId = example.Id,
    ///             CidrBlock = example.CidrBlock.Apply(cidrBlock =&gt; Std.Cidrsubnet.Invoke(new()
    ///             {
    ///                 Input = cidrBlock,
    ///                 Newbits = 8,
    ///                 Netnum = range.Value,
    ///             })).Apply(invoke =&gt; invoke.Result),
    ///             AvailabilityZone = available.Names[range.Value],
    ///         }));
    ///     }
    ///     var example1 = new List&lt;Aws.Ec2.SecurityGroup&gt;();
    ///     for (var rangeIndex = 0; rangeIndex &lt; 2; rangeIndex++)
    ///     {
    ///         var range = new { Value = rangeIndex };
    ///         example1.Add(new Aws.Ec2.SecurityGroup($"example1-{range.Value}", new()
    ///         {
    ///             VpcId = example.Id,
    ///             Name = $"example-sg-{range.Value}$",
    ///         }));
    ///     }
    ///     var exampleNetworkSettings = new Aws.WorkSpacesWeb.NetworkSettings("example", new()
    ///     {
    ///         VpcId = example.Id,
    ///         SubnetIds = new[]
    ///         {
    ///             exampleSubnet[0].Id,
    ///             exampleSubnet[1].Id,
    ///         },
    ///         SecurityGroupIds = new[]
    ///         {
    ///             exampleAwsSecurityGroup[0].Id,
    ///             exampleAwsSecurityGroup[1].Id,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import WorkSpaces Web Network Settings using the `network_settings_arn`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:workspacesweb/networkSettings:NetworkSettings example arn:aws:workspacesweb:us-west-2:123456789012:networksettings/abcdef12345
    /// ```
    /// </summary>
    [AwsResourceType("aws:workspacesweb/networkSettings:NetworkSettings")]
    public partial class NetworkSettings : global::Pulumi.CustomResource
    {
        /// <summary>
        /// List of web portal ARNs associated with the network settings.
        /// </summary>
        [Output("associatedPortalArns")]
        public Output<ImmutableArray<string>> AssociatedPortalArns { get; private set; } = null!;

        /// <summary>
        /// ARN of the network settings resource.
        /// </summary>
        [Output("networkSettingsArn")]
        public Output<string> NetworkSettingsArn { get; private set; } = null!;

        /// <summary>
        /// One or more security groups used to control access from streaming instances to your VPC.
        /// </summary>
        [Output("securityGroupIds")]
        public Output<ImmutableArray<string>> SecurityGroupIds { get; private set; } = null!;

        /// <summary>
        /// The subnets in which network interfaces are created to connect streaming instances to your VPC. At least two subnet ids must be specified.
        /// </summary>
        [Output("subnetIds")]
        public Output<ImmutableArray<string>> SubnetIds { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The VPC that streaming instances will connect to.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("vpcId")]
        public Output<string> VpcId { get; private set; } = null!;


        /// <summary>
        /// Create a NetworkSettings resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public NetworkSettings(string name, NetworkSettingsArgs args, CustomResourceOptions? options = null)
            : base("aws:workspacesweb/networkSettings:NetworkSettings", name, args ?? new NetworkSettingsArgs(), MakeResourceOptions(options, ""))
        {
        }

        private NetworkSettings(string name, Input<string> id, NetworkSettingsState? state = null, CustomResourceOptions? options = null)
            : base("aws:workspacesweb/networkSettings:NetworkSettings", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                Aliases =
                {
                    new global::Pulumi.Alias { Type = "aws:workspaces/webNetworkSettings:WebNetworkSettings" },
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing NetworkSettings resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static NetworkSettings Get(string name, Input<string> id, NetworkSettingsState? state = null, CustomResourceOptions? options = null)
        {
            return new NetworkSettings(name, id, state, options);
        }
    }

    public sealed class NetworkSettingsArgs : global::Pulumi.ResourceArgs
    {
        [Input("securityGroupIds", required: true)]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// One or more security groups used to control access from streaming instances to your VPC.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("subnetIds", required: true)]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// The subnets in which network interfaces are created to connect streaming instances to your VPC. At least two subnet ids must be specified.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The VPC that streaming instances will connect to.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("vpcId", required: true)]
        public Input<string> VpcId { get; set; } = null!;

        public NetworkSettingsArgs()
        {
        }
        public static new NetworkSettingsArgs Empty => new NetworkSettingsArgs();
    }

    public sealed class NetworkSettingsState : global::Pulumi.ResourceArgs
    {
        [Input("associatedPortalArns")]
        private InputList<string>? _associatedPortalArns;

        /// <summary>
        /// List of web portal ARNs associated with the network settings.
        /// </summary>
        public InputList<string> AssociatedPortalArns
        {
            get => _associatedPortalArns ?? (_associatedPortalArns = new InputList<string>());
            set => _associatedPortalArns = value;
        }

        /// <summary>
        /// ARN of the network settings resource.
        /// </summary>
        [Input("networkSettingsArn")]
        public Input<string>? NetworkSettingsArn { get; set; }

        [Input("securityGroupIds")]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// One or more security groups used to control access from streaming instances to your VPC.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("subnetIds")]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// The subnets in which network interfaces are created to connect streaming instances to your VPC. At least two subnet ids must be specified.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        /// <summary>
        /// The VPC that streaming instances will connect to.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public NetworkSettingsState()
        {
        }
        public static new NetworkSettingsState Empty => new NetworkSettingsState();
    }
}
