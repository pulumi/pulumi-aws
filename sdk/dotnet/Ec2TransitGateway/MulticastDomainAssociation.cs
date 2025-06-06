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
    /// Associates the specified subnet and transit gateway attachment with the specified transit gateway multicast domain.
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
    ///     var example = new Aws.Ec2TransitGateway.TransitGateway("example", new()
    ///     {
    ///         MulticastSupport = "enable",
    ///     });
    /// 
    ///     var exampleVpcAttachment = new Aws.Ec2TransitGateway.VpcAttachment("example", new()
    ///     {
    ///         SubnetIds = new[]
    ///         {
    ///             exampleAwsSubnet.Id,
    ///         },
    ///         TransitGatewayId = example.Id,
    ///         VpcId = exampleAwsVpc.Id,
    ///     });
    /// 
    ///     var exampleMulticastDomain = new Aws.Ec2TransitGateway.MulticastDomain("example", new()
    ///     {
    ///         TransitGatewayId = example.Id,
    ///     });
    /// 
    ///     var exampleMulticastDomainAssociation = new Aws.Ec2TransitGateway.MulticastDomainAssociation("example", new()
    ///     {
    ///         SubnetId = exampleAwsSubnet.Id,
    ///         TransitGatewayAttachmentId = exampleVpcAttachment.Id,
    ///         TransitGatewayMulticastDomainId = exampleMulticastDomain.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2transitgateway/multicastDomainAssociation:MulticastDomainAssociation")]
    public partial class MulticastDomainAssociation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ID of the subnet to associate with the transit gateway multicast domain.
        /// </summary>
        [Output("subnetId")]
        public Output<string> SubnetId { get; private set; } = null!;

        /// <summary>
        /// The ID of the transit gateway attachment.
        /// </summary>
        [Output("transitGatewayAttachmentId")]
        public Output<string> TransitGatewayAttachmentId { get; private set; } = null!;

        /// <summary>
        /// The ID of the transit gateway multicast domain.
        /// </summary>
        [Output("transitGatewayMulticastDomainId")]
        public Output<string> TransitGatewayMulticastDomainId { get; private set; } = null!;


        /// <summary>
        /// Create a MulticastDomainAssociation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public MulticastDomainAssociation(string name, MulticastDomainAssociationArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2transitgateway/multicastDomainAssociation:MulticastDomainAssociation", name, args ?? new MulticastDomainAssociationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private MulticastDomainAssociation(string name, Input<string> id, MulticastDomainAssociationState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2transitgateway/multicastDomainAssociation:MulticastDomainAssociation", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing MulticastDomainAssociation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static MulticastDomainAssociation Get(string name, Input<string> id, MulticastDomainAssociationState? state = null, CustomResourceOptions? options = null)
        {
            return new MulticastDomainAssociation(name, id, state, options);
        }
    }

    public sealed class MulticastDomainAssociationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the subnet to associate with the transit gateway multicast domain.
        /// </summary>
        [Input("subnetId", required: true)]
        public Input<string> SubnetId { get; set; } = null!;

        /// <summary>
        /// The ID of the transit gateway attachment.
        /// </summary>
        [Input("transitGatewayAttachmentId", required: true)]
        public Input<string> TransitGatewayAttachmentId { get; set; } = null!;

        /// <summary>
        /// The ID of the transit gateway multicast domain.
        /// </summary>
        [Input("transitGatewayMulticastDomainId", required: true)]
        public Input<string> TransitGatewayMulticastDomainId { get; set; } = null!;

        public MulticastDomainAssociationArgs()
        {
        }
        public static new MulticastDomainAssociationArgs Empty => new MulticastDomainAssociationArgs();
    }

    public sealed class MulticastDomainAssociationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the subnet to associate with the transit gateway multicast domain.
        /// </summary>
        [Input("subnetId")]
        public Input<string>? SubnetId { get; set; }

        /// <summary>
        /// The ID of the transit gateway attachment.
        /// </summary>
        [Input("transitGatewayAttachmentId")]
        public Input<string>? TransitGatewayAttachmentId { get; set; }

        /// <summary>
        /// The ID of the transit gateway multicast domain.
        /// </summary>
        [Input("transitGatewayMulticastDomainId")]
        public Input<string>? TransitGatewayMulticastDomainId { get; set; }

        public MulticastDomainAssociationState()
        {
        }
        public static new MulticastDomainAssociationState Empty => new MulticastDomainAssociationState();
    }
}
