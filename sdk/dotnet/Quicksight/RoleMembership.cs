// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight
{
    /// <summary>
    /// Resource for managing an AWS QuickSight Role Membership.
    /// 
    /// &gt; The role membership APIs are disabled for identities managed by QuickSight. This resource can only be used when the QuickSight account subscription uses the Active Directory or IAM Identity Center authentication method.
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
    ///     var example = new Aws.Quicksight.RoleMembership("example", new()
    ///     {
    ///         MemberName = "example-group",
    ///         Role = "READER",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import QuickSight Role Membership using a comma-delimited string combining the `aws_account_id`, `namespace`, `role`, and `member_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:quicksight/roleMembership:RoleMembership example 012345678901,default,READER,example-group
    /// ```
    /// </summary>
    [AwsResourceType("aws:quicksight/roleMembership:RoleMembership")]
    public partial class RoleMembership : global::Pulumi.CustomResource
    {
        /// <summary>
        /// AWS account ID. Defaults to the account of the caller identity if not configured.
        /// </summary>
        [Output("awsAccountId")]
        public Output<string> AwsAccountId { get; private set; } = null!;

        /// <summary>
        /// Name of the group to be added to the role.
        /// </summary>
        [Output("memberName")]
        public Output<string> MemberName { get; private set; } = null!;

        /// <summary>
        /// Name of the namespace. Defaults to `default`.
        /// </summary>
        [Output("namespace")]
        public Output<string> Namespace { get; private set; } = null!;

        /// <summary>
        /// Role to add the group to. Valid values are `ADMIN`, `AUTHOR`, `READER`, `ADMIN_PRO`, `AUTHOR_PRO`, and `READER_PRO`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("role")]
        public Output<string> Role { get; private set; } = null!;


        /// <summary>
        /// Create a RoleMembership resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public RoleMembership(string name, RoleMembershipArgs args, CustomResourceOptions? options = null)
            : base("aws:quicksight/roleMembership:RoleMembership", name, args ?? new RoleMembershipArgs(), MakeResourceOptions(options, ""))
        {
        }

        private RoleMembership(string name, Input<string> id, RoleMembershipState? state = null, CustomResourceOptions? options = null)
            : base("aws:quicksight/roleMembership:RoleMembership", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing RoleMembership resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static RoleMembership Get(string name, Input<string> id, RoleMembershipState? state = null, CustomResourceOptions? options = null)
        {
            return new RoleMembership(name, id, state, options);
        }
    }

    public sealed class RoleMembershipArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// AWS account ID. Defaults to the account of the caller identity if not configured.
        /// </summary>
        [Input("awsAccountId")]
        public Input<string>? AwsAccountId { get; set; }

        /// <summary>
        /// Name of the group to be added to the role.
        /// </summary>
        [Input("memberName", required: true)]
        public Input<string> MemberName { get; set; } = null!;

        /// <summary>
        /// Name of the namespace. Defaults to `default`.
        /// </summary>
        [Input("namespace")]
        public Input<string>? Namespace { get; set; }

        /// <summary>
        /// Role to add the group to. Valid values are `ADMIN`, `AUTHOR`, `READER`, `ADMIN_PRO`, `AUTHOR_PRO`, and `READER_PRO`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("role", required: true)]
        public Input<string> Role { get; set; } = null!;

        public RoleMembershipArgs()
        {
        }
        public static new RoleMembershipArgs Empty => new RoleMembershipArgs();
    }

    public sealed class RoleMembershipState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// AWS account ID. Defaults to the account of the caller identity if not configured.
        /// </summary>
        [Input("awsAccountId")]
        public Input<string>? AwsAccountId { get; set; }

        /// <summary>
        /// Name of the group to be added to the role.
        /// </summary>
        [Input("memberName")]
        public Input<string>? MemberName { get; set; }

        /// <summary>
        /// Name of the namespace. Defaults to `default`.
        /// </summary>
        [Input("namespace")]
        public Input<string>? Namespace { get; set; }

        /// <summary>
        /// Role to add the group to. Valid values are `ADMIN`, `AUTHOR`, `READER`, `ADMIN_PRO`, `AUTHOR_PRO`, and `READER_PRO`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("role")]
        public Input<string>? Role { get; set; }

        public RoleMembershipState()
        {
        }
        public static new RoleMembershipState Empty => new RoleMembershipState();
    }
}
