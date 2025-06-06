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
    /// Manages an individual EC2 resource tag. This resource should only be used in cases where EC2 resources are created outside the provider (e.g. AMIs), being shared via Resource Access Manager (RAM), or implicitly created by other means (e.g. Transit Gateway VPN Attachments).
    /// 
    /// &gt; **NOTE:** This tagging resource should not be combined with the providers resource for managing the parent resource. For example, using `aws.ec2.Vpc` and `aws.ec2.Tag` to manage tags of the same VPC will cause a perpetual difference where the `aws.ec2.Vpc` resource will try to remove the tag being added by the `aws.ec2.Tag` resource.
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
    ///     var example = new Aws.Ec2TransitGateway.TransitGateway("example");
    /// 
    ///     var exampleCustomerGateway = new Aws.Ec2.CustomerGateway("example", new()
    ///     {
    ///         BgpAsn = "65000",
    ///         IpAddress = "172.0.0.1",
    ///         Type = "ipsec.1",
    ///     });
    /// 
    ///     var exampleVpnConnection = new Aws.Ec2.VpnConnection("example", new()
    ///     {
    ///         CustomerGatewayId = exampleCustomerGateway.Id,
    ///         TransitGatewayId = example.Id,
    ///         Type = exampleCustomerGateway.Type,
    ///     });
    /// 
    ///     var exampleTag = new Aws.Ec2.Tag("example", new()
    ///     {
    ///         ResourceId = exampleVpnConnection.TransitGatewayAttachmentId,
    ///         Key = "Name",
    ///         Value = "Hello World",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_ec2_tag` using the EC2 resource identifier and key, separated by a comma (`,`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2/tag:Tag example tgw-attach-1234567890abcdef,Name
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2/tag:Tag")]
    public partial class Tag : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The tag name.
        /// </summary>
        [Output("key")]
        public Output<string> Key { get; private set; } = null!;

        /// <summary>
        /// The ID of the EC2 resource to manage the tag for.
        /// </summary>
        [Output("resourceId")]
        public Output<string> ResourceId { get; private set; } = null!;

        /// <summary>
        /// The value of the tag.
        /// </summary>
        [Output("value")]
        public Output<string> Value { get; private set; } = null!;


        /// <summary>
        /// Create a Tag resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Tag(string name, TagArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2/tag:Tag", name, args ?? new TagArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Tag(string name, Input<string> id, TagState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/tag:Tag", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Tag resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Tag Get(string name, Input<string> id, TagState? state = null, CustomResourceOptions? options = null)
        {
            return new Tag(name, id, state, options);
        }
    }

    public sealed class TagArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The tag name.
        /// </summary>
        [Input("key", required: true)]
        public Input<string> Key { get; set; } = null!;

        /// <summary>
        /// The ID of the EC2 resource to manage the tag for.
        /// </summary>
        [Input("resourceId", required: true)]
        public Input<string> ResourceId { get; set; } = null!;

        /// <summary>
        /// The value of the tag.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public TagArgs()
        {
        }
        public static new TagArgs Empty => new TagArgs();
    }

    public sealed class TagState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The tag name.
        /// </summary>
        [Input("key")]
        public Input<string>? Key { get; set; }

        /// <summary>
        /// The ID of the EC2 resource to manage the tag for.
        /// </summary>
        [Input("resourceId")]
        public Input<string>? ResourceId { get; set; }

        /// <summary>
        /// The value of the tag.
        /// </summary>
        [Input("value")]
        public Input<string>? Value { get; set; }

        public TagState()
        {
        }
        public static new TagState Empty => new TagState();
    }
}
