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
    /// Manages an EC2 Transit Gateway Policy Table association.
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
    ///     var example = new Aws.Ec2TransitGateway.PolicyTableAssociation("example", new()
    ///     {
    ///         TransitGatewayAttachmentId = exampleAwsNetworkmanagerTransitGatewayPeering.TransitGatewayPeeringAttachmentId,
    ///         TransitGatewayPolicyTableId = exampleAwsEc2TransitGatewayPolicyTable.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_ec2_transit_gateway_policy_table_association` using the EC2 Transit Gateway Policy Table identifier, an underscore, and the EC2 Transit Gateway Attachment identifier. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2transitgateway/policyTableAssociation:PolicyTableAssociation example tgw-rtb-12345678_tgw-attach-87654321
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2transitgateway/policyTableAssociation:PolicyTableAssociation")]
    public partial class PolicyTableAssociation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Identifier of the resource
        /// </summary>
        [Output("resourceId")]
        public Output<string> ResourceId { get; private set; } = null!;

        /// <summary>
        /// Type of the resource
        /// </summary>
        [Output("resourceType")]
        public Output<string> ResourceType { get; private set; } = null!;

        /// <summary>
        /// Identifier of EC2 Transit Gateway Attachment.
        /// </summary>
        [Output("transitGatewayAttachmentId")]
        public Output<string> TransitGatewayAttachmentId { get; private set; } = null!;

        /// <summary>
        /// Identifier of EC2 Transit Gateway Policy Table.
        /// </summary>
        [Output("transitGatewayPolicyTableId")]
        public Output<string> TransitGatewayPolicyTableId { get; private set; } = null!;


        /// <summary>
        /// Create a PolicyTableAssociation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public PolicyTableAssociation(string name, PolicyTableAssociationArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2transitgateway/policyTableAssociation:PolicyTableAssociation", name, args ?? new PolicyTableAssociationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private PolicyTableAssociation(string name, Input<string> id, PolicyTableAssociationState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2transitgateway/policyTableAssociation:PolicyTableAssociation", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing PolicyTableAssociation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static PolicyTableAssociation Get(string name, Input<string> id, PolicyTableAssociationState? state = null, CustomResourceOptions? options = null)
        {
            return new PolicyTableAssociation(name, id, state, options);
        }
    }

    public sealed class PolicyTableAssociationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier of EC2 Transit Gateway Attachment.
        /// </summary>
        [Input("transitGatewayAttachmentId", required: true)]
        public Input<string> TransitGatewayAttachmentId { get; set; } = null!;

        /// <summary>
        /// Identifier of EC2 Transit Gateway Policy Table.
        /// </summary>
        [Input("transitGatewayPolicyTableId", required: true)]
        public Input<string> TransitGatewayPolicyTableId { get; set; } = null!;

        public PolicyTableAssociationArgs()
        {
        }
        public static new PolicyTableAssociationArgs Empty => new PolicyTableAssociationArgs();
    }

    public sealed class PolicyTableAssociationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier of the resource
        /// </summary>
        [Input("resourceId")]
        public Input<string>? ResourceId { get; set; }

        /// <summary>
        /// Type of the resource
        /// </summary>
        [Input("resourceType")]
        public Input<string>? ResourceType { get; set; }

        /// <summary>
        /// Identifier of EC2 Transit Gateway Attachment.
        /// </summary>
        [Input("transitGatewayAttachmentId")]
        public Input<string>? TransitGatewayAttachmentId { get; set; }

        /// <summary>
        /// Identifier of EC2 Transit Gateway Policy Table.
        /// </summary>
        [Input("transitGatewayPolicyTableId")]
        public Input<string>? TransitGatewayPolicyTableId { get; set; }

        public PolicyTableAssociationState()
        {
        }
        public static new PolicyTableAssociationState Empty => new PolicyTableAssociationState();
    }
}
