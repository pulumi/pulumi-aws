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
    /// Enables the IPAM Service and promotes a delegated administrator.
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
    ///     var delegated = Aws.GetCallerIdentity.Invoke();
    /// 
    ///     var example = new Aws.Ec2.VpcIpamOrganizationAdminAccount("example", new()
    ///     {
    ///         DelegatedAdminAccountId = delegated.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import IPAMs using the delegate account `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2/vpcIpamOrganizationAdminAccount:VpcIpamOrganizationAdminAccount example 12345678901
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2/vpcIpamOrganizationAdminAccount:VpcIpamOrganizationAdminAccount")]
    public partial class VpcIpamOrganizationAdminAccount : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Organizations ARN for the delegate account.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        [Output("delegatedAdminAccountId")]
        public Output<string> DelegatedAdminAccountId { get; private set; } = null!;

        /// <summary>
        /// The Organizations email for the delegate account.
        /// </summary>
        [Output("email")]
        public Output<string> Email { get; private set; } = null!;

        /// <summary>
        /// The Organizations name for the delegate account.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The AWS service principal.
        /// </summary>
        [Output("servicePrincipal")]
        public Output<string> ServicePrincipal { get; private set; } = null!;


        /// <summary>
        /// Create a VpcIpamOrganizationAdminAccount resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public VpcIpamOrganizationAdminAccount(string name, VpcIpamOrganizationAdminAccountArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2/vpcIpamOrganizationAdminAccount:VpcIpamOrganizationAdminAccount", name, args ?? new VpcIpamOrganizationAdminAccountArgs(), MakeResourceOptions(options, ""))
        {
        }

        private VpcIpamOrganizationAdminAccount(string name, Input<string> id, VpcIpamOrganizationAdminAccountState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/vpcIpamOrganizationAdminAccount:VpcIpamOrganizationAdminAccount", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing VpcIpamOrganizationAdminAccount resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static VpcIpamOrganizationAdminAccount Get(string name, Input<string> id, VpcIpamOrganizationAdminAccountState? state = null, CustomResourceOptions? options = null)
        {
            return new VpcIpamOrganizationAdminAccount(name, id, state, options);
        }
    }

    public sealed class VpcIpamOrganizationAdminAccountArgs : global::Pulumi.ResourceArgs
    {
        [Input("delegatedAdminAccountId", required: true)]
        public Input<string> DelegatedAdminAccountId { get; set; } = null!;

        public VpcIpamOrganizationAdminAccountArgs()
        {
        }
        public static new VpcIpamOrganizationAdminAccountArgs Empty => new VpcIpamOrganizationAdminAccountArgs();
    }

    public sealed class VpcIpamOrganizationAdminAccountState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Organizations ARN for the delegate account.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("delegatedAdminAccountId")]
        public Input<string>? DelegatedAdminAccountId { get; set; }

        /// <summary>
        /// The Organizations email for the delegate account.
        /// </summary>
        [Input("email")]
        public Input<string>? Email { get; set; }

        /// <summary>
        /// The Organizations name for the delegate account.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The AWS service principal.
        /// </summary>
        [Input("servicePrincipal")]
        public Input<string>? ServicePrincipal { get; set; }

        public VpcIpamOrganizationAdminAccountState()
        {
        }
        public static new VpcIpamOrganizationAdminAccountState Empty => new VpcIpamOrganizationAdminAccountState();
    }
}
