// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Synthetics
{
    /// <summary>
    /// Provides a Synthetics Group Association resource.
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
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Synthetics.GroupAssociation("example", new()
    ///     {
    ///         GroupName = exampleAwsSyntheticsGroup.Name,
    ///         CanaryArn = exampleAwsSyntheticsCanary.Arn,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import CloudWatch Synthetics Group Association using the `canary_arn,group_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:synthetics/groupAssociation:GroupAssociation example arn:aws:synthetics:us-west-2:123456789012:canary:tf-acc-test-abcd1234,examplename
    /// ```
    /// </summary>
    [AwsResourceType("aws:synthetics/groupAssociation:GroupAssociation")]
    public partial class GroupAssociation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the canary.
        /// </summary>
        [Output("canaryArn")]
        public Output<string> CanaryArn { get; private set; } = null!;

        [Output("groupArn")]
        public Output<string> GroupArn { get; private set; } = null!;

        /// <summary>
        /// ID of the Group.
        /// </summary>
        [Output("groupId")]
        public Output<string> GroupId { get; private set; } = null!;

        /// <summary>
        /// Name of the group that the canary will be associated with.
        /// </summary>
        [Output("groupName")]
        public Output<string> GroupName { get; private set; } = null!;


        /// <summary>
        /// Create a GroupAssociation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public GroupAssociation(string name, GroupAssociationArgs args, CustomResourceOptions? options = null)
            : base("aws:synthetics/groupAssociation:GroupAssociation", name, args ?? new GroupAssociationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private GroupAssociation(string name, Input<string> id, GroupAssociationState? state = null, CustomResourceOptions? options = null)
            : base("aws:synthetics/groupAssociation:GroupAssociation", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing GroupAssociation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static GroupAssociation Get(string name, Input<string> id, GroupAssociationState? state = null, CustomResourceOptions? options = null)
        {
            return new GroupAssociation(name, id, state, options);
        }
    }

    public sealed class GroupAssociationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the canary.
        /// </summary>
        [Input("canaryArn", required: true)]
        public Input<string> CanaryArn { get; set; } = null!;

        /// <summary>
        /// Name of the group that the canary will be associated with.
        /// </summary>
        [Input("groupName", required: true)]
        public Input<string> GroupName { get; set; } = null!;

        public GroupAssociationArgs()
        {
        }
        public static new GroupAssociationArgs Empty => new GroupAssociationArgs();
    }

    public sealed class GroupAssociationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the canary.
        /// </summary>
        [Input("canaryArn")]
        public Input<string>? CanaryArn { get; set; }

        [Input("groupArn")]
        public Input<string>? GroupArn { get; set; }

        /// <summary>
        /// ID of the Group.
        /// </summary>
        [Input("groupId")]
        public Input<string>? GroupId { get; set; }

        /// <summary>
        /// Name of the group that the canary will be associated with.
        /// </summary>
        [Input("groupName")]
        public Input<string>? GroupName { get; set; }

        public GroupAssociationState()
        {
        }
        public static new GroupAssociationState Empty => new GroupAssociationState();
    }
}
