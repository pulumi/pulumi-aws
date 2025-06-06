// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2TransitGateway
{
    /// <summary>
    /// Manages the accepter's side of an EC2 Transit Gateway Peering Attachment.
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
    ///     var example = new Aws.Ec2TransitGateway.PeeringAttachmentAccepter("example", new()
    ///     {
    ///         TransitGatewayAttachmentId = exampleAwsEc2TransitGatewayPeeringAttachment.Id,
    ///         Tags = 
    ///         {
    ///             { "Name", "Example cross-account attachment" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_ec2_transit_gateway_peering_attachment_accepter` using the EC2 Transit Gateway Attachment identifier. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2transitgateway/peeringAttachmentAccepter:PeeringAttachmentAccepter example tgw-attach-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2transitgateway/peeringAttachmentAccepter:PeeringAttachmentAccepter")]
    public partial class PeeringAttachmentAccepter : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Identifier of the AWS account that owns the EC2 TGW peering.
        /// </summary>
        [Output("peerAccountId")]
        public Output<string> PeerAccountId { get; private set; } = null!;

        [Output("peerRegion")]
        public Output<string> PeerRegion { get; private set; } = null!;

        /// <summary>
        /// Identifier of EC2 Transit Gateway to peer with.
        /// </summary>
        [Output("peerTransitGatewayId")]
        public Output<string> PeerTransitGatewayId { get; private set; } = null!;

        /// <summary>
        /// Key-value tags for the EC2 Transit Gateway Peering Attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The ID of the EC2 Transit Gateway Peering Attachment to manage.
        /// </summary>
        [Output("transitGatewayAttachmentId")]
        public Output<string> TransitGatewayAttachmentId { get; private set; } = null!;

        /// <summary>
        /// Identifier of EC2 Transit Gateway.
        /// </summary>
        [Output("transitGatewayId")]
        public Output<string> TransitGatewayId { get; private set; } = null!;


        /// <summary>
        /// Create a PeeringAttachmentAccepter resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public PeeringAttachmentAccepter(string name, PeeringAttachmentAccepterArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2transitgateway/peeringAttachmentAccepter:PeeringAttachmentAccepter", name, args ?? new PeeringAttachmentAccepterArgs(), MakeResourceOptions(options, ""))
        {
        }

        private PeeringAttachmentAccepter(string name, Input<string> id, PeeringAttachmentAccepterState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2transitgateway/peeringAttachmentAccepter:PeeringAttachmentAccepter", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                Aliases =
                {
                    new global::Pulumi.Alias { Type = "aws:ec2/transitGatewayPeeringAttachmentAccepter:TransitGatewayPeeringAttachmentAccepter" },
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing PeeringAttachmentAccepter resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static PeeringAttachmentAccepter Get(string name, Input<string> id, PeeringAttachmentAccepterState? state = null, CustomResourceOptions? options = null)
        {
            return new PeeringAttachmentAccepter(name, id, state, options);
        }
    }

    public sealed class PeeringAttachmentAccepterArgs : global::Pulumi.ResourceArgs
    {
        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value tags for the EC2 Transit Gateway Peering Attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The ID of the EC2 Transit Gateway Peering Attachment to manage.
        /// </summary>
        [Input("transitGatewayAttachmentId", required: true)]
        public Input<string> TransitGatewayAttachmentId { get; set; } = null!;

        public PeeringAttachmentAccepterArgs()
        {
        }
        public static new PeeringAttachmentAccepterArgs Empty => new PeeringAttachmentAccepterArgs();
    }

    public sealed class PeeringAttachmentAccepterState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier of the AWS account that owns the EC2 TGW peering.
        /// </summary>
        [Input("peerAccountId")]
        public Input<string>? PeerAccountId { get; set; }

        [Input("peerRegion")]
        public Input<string>? PeerRegion { get; set; }

        /// <summary>
        /// Identifier of EC2 Transit Gateway to peer with.
        /// </summary>
        [Input("peerTransitGatewayId")]
        public Input<string>? PeerTransitGatewayId { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value tags for the EC2 Transit Gateway Peering Attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
        /// The ID of the EC2 Transit Gateway Peering Attachment to manage.
        /// </summary>
        [Input("transitGatewayAttachmentId")]
        public Input<string>? TransitGatewayAttachmentId { get; set; }

        /// <summary>
        /// Identifier of EC2 Transit Gateway.
        /// </summary>
        [Input("transitGatewayId")]
        public Input<string>? TransitGatewayId { get; set; }

        public PeeringAttachmentAccepterState()
        {
        }
        public static new PeeringAttachmentAccepterState Empty => new PeeringAttachmentAccepterState();
    }
}
