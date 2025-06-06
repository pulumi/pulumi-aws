// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2
{
    /// <summary>
    /// Provides an association between an Amazon IP Address Manager (IPAM) and a IPAM Resource Discovery. IPAM Resource Discoveries are resources meant for multi-organization customers. If you wish to use a single IPAM across multiple orgs, a resource discovery can be created and shared from a subordinate organization to the management organizations IPAM delegated admin account.
    /// 
    /// Once an association is created between two organizations via IPAM &amp; a IPAM Resource Discovery, IPAM Pools can be shared via Resource Access Manager (RAM) to accounts in the subordinate organization; these RAM shares must be accepted by the end user account. Pools can then also discover and monitor IPAM resources in the subordinate organization.
    /// 
    /// ## Example Usage
    /// 
    /// Basic usage:
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var test = new Aws.Ec2.VpcIpamResourceDiscoveryAssociation("test", new()
    ///     {
    ///         IpamId = testAwsVpcIpam.Id,
    ///         IpamResourceDiscoveryId = testAwsVpcIpamResourceDiscovery.Id,
    ///         Tags = 
    ///         {
    ///             { "Name", "test" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import IPAMs using the IPAM resource discovery association `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2/vpcIpamResourceDiscoveryAssociation:VpcIpamResourceDiscoveryAssociation example ipam-res-disco-assoc-0178368ad2146a492
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2/vpcIpamResourceDiscoveryAssociation:VpcIpamResourceDiscoveryAssociation")]
    public partial class VpcIpamResourceDiscoveryAssociation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of IPAM Resource Discovery Association.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the IPAM.
        /// </summary>
        [Output("ipamArn")]
        public Output<string> IpamArn { get; private set; } = null!;

        /// <summary>
        /// The ID of the IPAM to associate.
        /// </summary>
        [Output("ipamId")]
        public Output<string> IpamId { get; private set; } = null!;

        /// <summary>
        /// The home region of the IPAM.
        /// </summary>
        [Output("ipamRegion")]
        public Output<string> IpamRegion { get; private set; } = null!;

        /// <summary>
        /// The ID of the Resource Discovery to associate.
        /// </summary>
        [Output("ipamResourceDiscoveryId")]
        public Output<string> IpamResourceDiscoveryId { get; private set; } = null!;

        /// <summary>
        /// A boolean to identify if the Resource Discovery is the accounts default resource discovery.
        /// </summary>
        [Output("isDefault")]
        public Output<bool> IsDefault { get; private set; } = null!;

        /// <summary>
        /// The account ID for the account that manages the Resource Discovery
        /// </summary>
        [Output("ownerId")]
        public Output<string> OwnerId { get; private set; } = null!;

        /// <summary>
        /// The lifecycle state of the association when you associate or disassociate a resource discovery.
        /// </summary>
        [Output("state")]
        public Output<string> State { get; private set; } = null!;

        /// <summary>
        /// A map of tags to add to the IPAM resource discovery association resource.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a VpcIpamResourceDiscoveryAssociation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public VpcIpamResourceDiscoveryAssociation(string name, VpcIpamResourceDiscoveryAssociationArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2/vpcIpamResourceDiscoveryAssociation:VpcIpamResourceDiscoveryAssociation", name, args ?? new VpcIpamResourceDiscoveryAssociationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private VpcIpamResourceDiscoveryAssociation(string name, Input<string> id, VpcIpamResourceDiscoveryAssociationState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/vpcIpamResourceDiscoveryAssociation:VpcIpamResourceDiscoveryAssociation", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing VpcIpamResourceDiscoveryAssociation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static VpcIpamResourceDiscoveryAssociation Get(string name, Input<string> id, VpcIpamResourceDiscoveryAssociationState? state = null, CustomResourceOptions? options = null)
        {
            return new VpcIpamResourceDiscoveryAssociation(name, id, state, options);
        }
    }

    public sealed class VpcIpamResourceDiscoveryAssociationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the IPAM to associate.
        /// </summary>
        [Input("ipamId", required: true)]
        public Input<string> IpamId { get; set; } = null!;

        /// <summary>
        /// The ID of the Resource Discovery to associate.
        /// </summary>
        [Input("ipamResourceDiscoveryId", required: true)]
        public Input<string> IpamResourceDiscoveryId { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to add to the IPAM resource discovery association resource.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public VpcIpamResourceDiscoveryAssociationArgs()
        {
        }
        public static new VpcIpamResourceDiscoveryAssociationArgs Empty => new VpcIpamResourceDiscoveryAssociationArgs();
    }

    public sealed class VpcIpamResourceDiscoveryAssociationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of IPAM Resource Discovery Association.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the IPAM.
        /// </summary>
        [Input("ipamArn")]
        public Input<string>? IpamArn { get; set; }

        /// <summary>
        /// The ID of the IPAM to associate.
        /// </summary>
        [Input("ipamId")]
        public Input<string>? IpamId { get; set; }

        /// <summary>
        /// The home region of the IPAM.
        /// </summary>
        [Input("ipamRegion")]
        public Input<string>? IpamRegion { get; set; }

        /// <summary>
        /// The ID of the Resource Discovery to associate.
        /// </summary>
        [Input("ipamResourceDiscoveryId")]
        public Input<string>? IpamResourceDiscoveryId { get; set; }

        /// <summary>
        /// A boolean to identify if the Resource Discovery is the accounts default resource discovery.
        /// </summary>
        [Input("isDefault")]
        public Input<bool>? IsDefault { get; set; }

        /// <summary>
        /// The account ID for the account that manages the Resource Discovery
        /// </summary>
        [Input("ownerId")]
        public Input<string>? OwnerId { get; set; }

        /// <summary>
        /// The lifecycle state of the association when you associate or disassociate a resource discovery.
        /// </summary>
        [Input("state")]
        public Input<string>? State { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to add to the IPAM resource discovery association resource.
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

        public VpcIpamResourceDiscoveryAssociationState()
        {
        }
        public static new VpcIpamResourceDiscoveryAssociationState Empty => new VpcIpamResourceDiscoveryAssociationState();
    }
}
