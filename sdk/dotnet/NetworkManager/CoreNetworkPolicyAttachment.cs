// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkManager
{
    /// <summary>
    /// Provides a Core Network Policy Attachment resource. This puts a Core Network Policy to an existing Core Network and executes the change set, which deploys changes globally based on the policy submitted (Sets the policy to `LIVE`).
    /// 
    /// &gt; **NOTE:** Deleting this resource will not delete the current policy defined in this resource. Deleting this resource will also not revert the current `LIVE` policy to the previous version.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.NetworkManager.CoreNetwork("example", new()
    ///     {
    ///         GlobalNetworkId = exampleAwsNetworkmanagerGlobalNetwork.Id,
    ///     });
    /// 
    ///     var exampleCoreNetworkPolicyAttachment = new Aws.NetworkManager.CoreNetworkPolicyAttachment("example", new()
    ///     {
    ///         CoreNetworkId = example.Id,
    ///         PolicyDocument = exampleAwsNetworkmanagerCoreNetworkPolicyDocument.Json,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### With VPC Attachment (Single Region)
    /// 
    /// The example below illustrates the scenario where your policy document has static routes pointing to VPC attachments and you want to attach your VPCs to the core network before applying the desired policy document. Set the `create_base_policy` argument of the `aws.networkmanager.CoreNetwork` resource to `true` if your core network does not currently have any `LIVE` policies (e.g. this is the first `pulumi up` with the core network resource), since a `LIVE` policy is required before VPCs can be attached to the core network. Otherwise, if your core network already has a `LIVE` policy, you may exclude the `create_base_policy` argument. There are 2 options to implement this:
    /// 
    /// - Option 1: Use the `base_policy_document` argument in the `aws.networkmanager.CoreNetwork` resource that allows the most customizations to a base policy. Use this to customize the `edge_locations` `asn`. In the example below, `us-west-2` and ASN `65500` are used in the base policy.
    /// - Option 2: Use the `create_base_policy` argument only. This creates a base policy in the region specified in the `provider` block.
    /// 
    /// ### Option 1 - using base_policy_document
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var exampleGlobalNetwork = new Aws.NetworkManager.GlobalNetwork("example");
    /// 
    ///     var @base = Aws.NetworkManager.GetCoreNetworkPolicyDocument.Invoke(new()
    ///     {
    ///         CoreNetworkConfigurations = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationInputArgs
    ///             {
    ///                 AsnRanges = new[]
    ///                 {
    ///                     "65022-65534",
    ///                 },
    ///                 EdgeLocations = new[]
    ///                 {
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-west-2",
    ///                         Asn = "65500",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         Segments = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentInputArgs
    ///             {
    ///                 Name = "segment",
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleCoreNetwork = new Aws.NetworkManager.CoreNetwork("example", new()
    ///     {
    ///         GlobalNetworkId = exampleGlobalNetwork.Id,
    ///         BasePolicyDocument = @base.Apply(@base =&gt; @base.Apply(getCoreNetworkPolicyDocumentResult =&gt; getCoreNetworkPolicyDocumentResult.Json)),
    ///         CreateBasePolicy = true,
    ///     });
    /// 
    ///     var exampleVpcAttachment = new Aws.NetworkManager.VpcAttachment("example", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         SubnetArns = exampleAwsSubnet.Select(__item =&gt; __item.Arn).ToList(),
    ///         VpcArn = exampleAwsVpc.Arn,
    ///     });
    /// 
    ///     var example = Aws.NetworkManager.GetCoreNetworkPolicyDocument.Invoke(new()
    ///     {
    ///         CoreNetworkConfigurations = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationInputArgs
    ///             {
    ///                 AsnRanges = new[]
    ///                 {
    ///                     "65022-65534",
    ///                 },
    ///                 EdgeLocations = new[]
    ///                 {
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-west-2",
    ///                         Asn = "65500",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         Segments = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentInputArgs
    ///             {
    ///                 Name = "segment",
    ///             },
    ///         },
    ///         SegmentActions = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentActionInputArgs
    ///             {
    ///                 Action = "create-route",
    ///                 Segment = "segment",
    ///                 DestinationCidrBlocks = new[]
    ///                 {
    ///                     "0.0.0.0/0",
    ///                 },
    ///                 Destinations = new[]
    ///                 {
    ///                     exampleVpcAttachment.Id,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleCoreNetworkPolicyAttachment = new Aws.NetworkManager.CoreNetworkPolicyAttachment("example", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         PolicyDocument = example.Apply(getCoreNetworkPolicyDocumentResult =&gt; getCoreNetworkPolicyDocumentResult.Json),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Option 2 - create_base_policy only
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var exampleGlobalNetwork = new Aws.NetworkManager.GlobalNetwork("example");
    /// 
    ///     var exampleCoreNetwork = new Aws.NetworkManager.CoreNetwork("example", new()
    ///     {
    ///         GlobalNetworkId = exampleGlobalNetwork.Id,
    ///         CreateBasePolicy = true,
    ///     });
    /// 
    ///     var exampleVpcAttachment = new Aws.NetworkManager.VpcAttachment("example", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         SubnetArns = exampleAwsSubnet.Select(__item =&gt; __item.Arn).ToList(),
    ///         VpcArn = exampleAwsVpc.Arn,
    ///     });
    /// 
    ///     var example = Aws.NetworkManager.GetCoreNetworkPolicyDocument.Invoke(new()
    ///     {
    ///         CoreNetworkConfigurations = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationInputArgs
    ///             {
    ///                 AsnRanges = new[]
    ///                 {
    ///                     "65022-65534",
    ///                 },
    ///                 EdgeLocations = new[]
    ///                 {
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-west-2",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         Segments = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentInputArgs
    ///             {
    ///                 Name = "segment",
    ///             },
    ///         },
    ///         SegmentActions = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentActionInputArgs
    ///             {
    ///                 Action = "create-route",
    ///                 Segment = "segment",
    ///                 DestinationCidrBlocks = new[]
    ///                 {
    ///                     "0.0.0.0/0",
    ///                 },
    ///                 Destinations = new[]
    ///                 {
    ///                     exampleVpcAttachment.Id,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleCoreNetworkPolicyAttachment = new Aws.NetworkManager.CoreNetworkPolicyAttachment("example", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         PolicyDocument = example.Apply(getCoreNetworkPolicyDocumentResult =&gt; getCoreNetworkPolicyDocumentResult.Json),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### With VPC Attachment (Multi-Region)
    /// 
    /// The example below illustrates the scenario where your policy document has static routes pointing to VPC attachments and you want to attach your VPCs to the core network before applying the desired policy document. Set the `create_base_policy` argument of the `aws.networkmanager.CoreNetwork` resource to `true` if your core network does not currently have any `LIVE` policies (e.g. this is the first `pulumi up` with the core network resource), since a `LIVE` policy is required before VPCs can be attached to the core network. Otherwise, if your core network already has a `LIVE` policy, you may exclude the `create_base_policy` argument. For multi-region in a core network that does not yet have a `LIVE` policy, there are 2 options:
    /// 
    /// - Option 1: Use the `base_policy_document` argument that allows the most customizations to a base policy. Use this to customize the `edge_locations` `asn`. In the example below, `us-west-2`, `us-east-1` and specific ASNs are used in the base policy.
    /// - Option 2: Pass a list of regions to the `aws.networkmanager.CoreNetwork` resource `base_policy_regions` argument. In the example below, `us-west-2` and `us-east-1` are specified in the base policy.
    /// 
    /// ### Option 1 - using base_policy_document
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var exampleGlobalNetwork = new Aws.NetworkManager.GlobalNetwork("example");
    /// 
    ///     var @base = Aws.NetworkManager.GetCoreNetworkPolicyDocument.Invoke(new()
    ///     {
    ///         CoreNetworkConfigurations = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationInputArgs
    ///             {
    ///                 AsnRanges = new[]
    ///                 {
    ///                     "65022-65534",
    ///                 },
    ///                 EdgeLocations = new[]
    ///                 {
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-west-2",
    ///                         Asn = "65500",
    ///                     },
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-east-1",
    ///                         Asn = "65501",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         Segments = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentInputArgs
    ///             {
    ///                 Name = "segment",
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleCoreNetwork = new Aws.NetworkManager.CoreNetwork("example", new()
    ///     {
    ///         GlobalNetworkId = exampleGlobalNetwork.Id,
    ///         BasePolicyDocument = @base.Apply(@base =&gt; @base.Apply(getCoreNetworkPolicyDocumentResult =&gt; getCoreNetworkPolicyDocumentResult.Json)),
    ///         CreateBasePolicy = true,
    ///     });
    /// 
    ///     var exampleUsWest2 = new Aws.NetworkManager.VpcAttachment("example_us_west_2", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         SubnetArns = exampleUsWest2AwsSubnet.Select(__item =&gt; __item.Arn).ToList(),
    ///         VpcArn = exampleUsWest2AwsVpc.Arn,
    ///     });
    /// 
    ///     var exampleUsEast1 = new Aws.NetworkManager.VpcAttachment("example_us_east_1", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         SubnetArns = exampleUsEast1AwsSubnet.Select(__item =&gt; __item.Arn).ToList(),
    ///         VpcArn = exampleUsEast1AwsVpc.Arn,
    ///     });
    /// 
    ///     var example = Aws.NetworkManager.GetCoreNetworkPolicyDocument.Invoke(new()
    ///     {
    ///         CoreNetworkConfigurations = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationInputArgs
    ///             {
    ///                 AsnRanges = new[]
    ///                 {
    ///                     "65022-65534",
    ///                 },
    ///                 EdgeLocations = new[]
    ///                 {
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-west-2",
    ///                         Asn = "65500",
    ///                     },
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-east-1",
    ///                         Asn = "65501",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         Segments = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentInputArgs
    ///             {
    ///                 Name = "segment",
    ///             },
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentInputArgs
    ///             {
    ///                 Name = "segment2",
    ///             },
    ///         },
    ///         SegmentActions = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentActionInputArgs
    ///             {
    ///                 Action = "create-route",
    ///                 Segment = "segment",
    ///                 DestinationCidrBlocks = new[]
    ///                 {
    ///                     "10.0.0.0/16",
    ///                 },
    ///                 Destinations = new[]
    ///                 {
    ///                     exampleUsWest2.Id,
    ///                 },
    ///             },
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentActionInputArgs
    ///             {
    ///                 Action = "create-route",
    ///                 Segment = "segment",
    ///                 DestinationCidrBlocks = new[]
    ///                 {
    ///                     "10.1.0.0/16",
    ///                 },
    ///                 Destinations = new[]
    ///                 {
    ///                     exampleUsEast1.Id,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleCoreNetworkPolicyAttachment = new Aws.NetworkManager.CoreNetworkPolicyAttachment("example", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         PolicyDocument = example.Apply(getCoreNetworkPolicyDocumentResult =&gt; getCoreNetworkPolicyDocumentResult.Json),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Option 2 - using base_policy_regions
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var exampleGlobalNetwork = new Aws.NetworkManager.GlobalNetwork("example");
    /// 
    ///     var exampleCoreNetwork = new Aws.NetworkManager.CoreNetwork("example", new()
    ///     {
    ///         GlobalNetworkId = exampleGlobalNetwork.Id,
    ///         BasePolicyRegions = new[]
    ///         {
    ///             "us-west-2",
    ///             "us-east-1",
    ///         },
    ///         CreateBasePolicy = true,
    ///     });
    /// 
    ///     var exampleUsWest2 = new Aws.NetworkManager.VpcAttachment("example_us_west_2", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         SubnetArns = exampleUsWest2AwsSubnet.Select(__item =&gt; __item.Arn).ToList(),
    ///         VpcArn = exampleUsWest2AwsVpc.Arn,
    ///     });
    /// 
    ///     var exampleUsEast1 = new Aws.NetworkManager.VpcAttachment("example_us_east_1", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         SubnetArns = exampleUsEast1AwsSubnet.Select(__item =&gt; __item.Arn).ToList(),
    ///         VpcArn = exampleUsEast1AwsVpc.Arn,
    ///     });
    /// 
    ///     var example = Aws.NetworkManager.GetCoreNetworkPolicyDocument.Invoke(new()
    ///     {
    ///         CoreNetworkConfigurations = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationInputArgs
    ///             {
    ///                 AsnRanges = new[]
    ///                 {
    ///                     "65022-65534",
    ///                 },
    ///                 EdgeLocations = new[]
    ///                 {
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-west-2",
    ///                     },
    ///                     new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentCoreNetworkConfigurationEdgeLocationInputArgs
    ///                     {
    ///                         Location = "us-east-1",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         Segments = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentInputArgs
    ///             {
    ///                 Name = "segment",
    ///             },
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentInputArgs
    ///             {
    ///                 Name = "segment2",
    ///             },
    ///         },
    ///         SegmentActions = new[]
    ///         {
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentActionInputArgs
    ///             {
    ///                 Action = "create-route",
    ///                 Segment = "segment",
    ///                 DestinationCidrBlocks = new[]
    ///                 {
    ///                     "10.0.0.0/16",
    ///                 },
    ///                 Destinations = new[]
    ///                 {
    ///                     exampleUsWest2.Id,
    ///                 },
    ///             },
    ///             new Aws.NetworkManager.Inputs.GetCoreNetworkPolicyDocumentSegmentActionInputArgs
    ///             {
    ///                 Action = "create-route",
    ///                 Segment = "segment",
    ///                 DestinationCidrBlocks = new[]
    ///                 {
    ///                     "10.1.0.0/16",
    ///                 },
    ///                 Destinations = new[]
    ///                 {
    ///                     exampleUsEast1.Id,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleCoreNetworkPolicyAttachment = new Aws.NetworkManager.CoreNetworkPolicyAttachment("example", new()
    ///     {
    ///         CoreNetworkId = exampleCoreNetwork.Id,
    ///         PolicyDocument = example.Apply(getCoreNetworkPolicyDocumentResult =&gt; getCoreNetworkPolicyDocumentResult.Json),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_networkmanager_core_network_policy_attachment` using the core network ID. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:networkmanager/coreNetworkPolicyAttachment:CoreNetworkPolicyAttachment example core-network-0d47f6t230mz46dy4
    /// ```
    /// </summary>
    [AwsResourceType("aws:networkmanager/coreNetworkPolicyAttachment:CoreNetworkPolicyAttachment")]
    public partial class CoreNetworkPolicyAttachment : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ID of the core network that a policy will be attached to and made `LIVE`.
        /// </summary>
        [Output("coreNetworkId")]
        public Output<string> CoreNetworkId { get; private set; } = null!;

        /// <summary>
        /// Policy document for creating a core network. Note that updating this argument will result in the new policy document version being set as the `LATEST` and `LIVE` policy document. Refer to the [Core network policies documentation](https://docs.aws.amazon.com/network-manager/latest/cloudwan/cloudwan-policy-change-sets.html) for more information.
        /// </summary>
        [Output("policyDocument")]
        public Output<string> PolicyDocument { get; private set; } = null!;

        /// <summary>
        /// Current state of a core network.
        /// </summary>
        [Output("state")]
        public Output<string> State { get; private set; } = null!;


        /// <summary>
        /// Create a CoreNetworkPolicyAttachment resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public CoreNetworkPolicyAttachment(string name, CoreNetworkPolicyAttachmentArgs args, CustomResourceOptions? options = null)
            : base("aws:networkmanager/coreNetworkPolicyAttachment:CoreNetworkPolicyAttachment", name, args ?? new CoreNetworkPolicyAttachmentArgs(), MakeResourceOptions(options, ""))
        {
        }

        private CoreNetworkPolicyAttachment(string name, Input<string> id, CoreNetworkPolicyAttachmentState? state = null, CustomResourceOptions? options = null)
            : base("aws:networkmanager/coreNetworkPolicyAttachment:CoreNetworkPolicyAttachment", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing CoreNetworkPolicyAttachment resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static CoreNetworkPolicyAttachment Get(string name, Input<string> id, CoreNetworkPolicyAttachmentState? state = null, CustomResourceOptions? options = null)
        {
            return new CoreNetworkPolicyAttachment(name, id, state, options);
        }
    }

    public sealed class CoreNetworkPolicyAttachmentArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the core network that a policy will be attached to and made `LIVE`.
        /// </summary>
        [Input("coreNetworkId", required: true)]
        public Input<string> CoreNetworkId { get; set; } = null!;

        /// <summary>
        /// Policy document for creating a core network. Note that updating this argument will result in the new policy document version being set as the `LATEST` and `LIVE` policy document. Refer to the [Core network policies documentation](https://docs.aws.amazon.com/network-manager/latest/cloudwan/cloudwan-policy-change-sets.html) for more information.
        /// </summary>
        [Input("policyDocument", required: true)]
        public Input<string> PolicyDocument { get; set; } = null!;

        public CoreNetworkPolicyAttachmentArgs()
        {
        }
        public static new CoreNetworkPolicyAttachmentArgs Empty => new CoreNetworkPolicyAttachmentArgs();
    }

    public sealed class CoreNetworkPolicyAttachmentState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the core network that a policy will be attached to and made `LIVE`.
        /// </summary>
        [Input("coreNetworkId")]
        public Input<string>? CoreNetworkId { get; set; }

        /// <summary>
        /// Policy document for creating a core network. Note that updating this argument will result in the new policy document version being set as the `LATEST` and `LIVE` policy document. Refer to the [Core network policies documentation](https://docs.aws.amazon.com/network-manager/latest/cloudwan/cloudwan-policy-change-sets.html) for more information.
        /// </summary>
        [Input("policyDocument")]
        public Input<string>? PolicyDocument { get; set; }

        /// <summary>
        /// Current state of a core network.
        /// </summary>
        [Input("state")]
        public Input<string>? State { get; set; }

        public CoreNetworkPolicyAttachmentState()
        {
        }
        public static new CoreNetworkPolicyAttachmentState Empty => new CoreNetworkPolicyAttachmentState();
    }
}
