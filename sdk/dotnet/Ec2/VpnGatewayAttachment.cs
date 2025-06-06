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
    /// Provides a Virtual Private Gateway attachment resource, allowing for an existing
    /// hardware VPN gateway to be attached and/or detached from a VPC.
    /// 
    /// &gt; **Note:** The `aws.ec2.VpnGateway`
    /// resource can also automatically attach the Virtual Private Gateway it creates
    /// to an existing VPC by setting the `vpc_id` attribute accordingly.
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
    ///     var network = new Aws.Ec2.Vpc("network", new()
    ///     {
    ///         CidrBlock = "10.0.0.0/16",
    ///     });
    /// 
    ///     var vpn = new Aws.Ec2.VpnGateway("vpn", new()
    ///     {
    ///         Tags = 
    ///         {
    ///             { "Name", "example-vpn-gateway" },
    ///         },
    ///     });
    /// 
    ///     var vpnAttachment = new Aws.Ec2.VpnGatewayAttachment("vpn_attachment", new()
    ///     {
    ///         VpcId = network.Id,
    ///         VpnGatewayId = vpn.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// See [Virtual Private Cloud](http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Introduction.html)
    /// and [Virtual Private Gateway](http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html) user
    /// guides for more information.
    /// 
    /// ## Import
    /// 
    /// You cannot import this resource.
    /// </summary>
    [AwsResourceType("aws:ec2/vpnGatewayAttachment:VpnGatewayAttachment")]
    public partial class VpnGatewayAttachment : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ID of the VPC.
        /// </summary>
        [Output("vpcId")]
        public Output<string> VpcId { get; private set; } = null!;

        /// <summary>
        /// The ID of the Virtual Private Gateway.
        /// </summary>
        [Output("vpnGatewayId")]
        public Output<string> VpnGatewayId { get; private set; } = null!;


        /// <summary>
        /// Create a VpnGatewayAttachment resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public VpnGatewayAttachment(string name, VpnGatewayAttachmentArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2/vpnGatewayAttachment:VpnGatewayAttachment", name, args ?? new VpnGatewayAttachmentArgs(), MakeResourceOptions(options, ""))
        {
        }

        private VpnGatewayAttachment(string name, Input<string> id, VpnGatewayAttachmentState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/vpnGatewayAttachment:VpnGatewayAttachment", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing VpnGatewayAttachment resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static VpnGatewayAttachment Get(string name, Input<string> id, VpnGatewayAttachmentState? state = null, CustomResourceOptions? options = null)
        {
            return new VpnGatewayAttachment(name, id, state, options);
        }
    }

    public sealed class VpnGatewayAttachmentArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the VPC.
        /// </summary>
        [Input("vpcId", required: true)]
        public Input<string> VpcId { get; set; } = null!;

        /// <summary>
        /// The ID of the Virtual Private Gateway.
        /// </summary>
        [Input("vpnGatewayId", required: true)]
        public Input<string> VpnGatewayId { get; set; } = null!;

        public VpnGatewayAttachmentArgs()
        {
        }
        public static new VpnGatewayAttachmentArgs Empty => new VpnGatewayAttachmentArgs();
    }

    public sealed class VpnGatewayAttachmentState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the VPC.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        /// <summary>
        /// The ID of the Virtual Private Gateway.
        /// </summary>
        [Input("vpnGatewayId")]
        public Input<string>? VpnGatewayId { get; set; }

        public VpnGatewayAttachmentState()
        {
        }
        public static new VpnGatewayAttachmentState Empty => new VpnGatewayAttachmentState();
    }
}
