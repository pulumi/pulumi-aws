// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub
{
    /// <summary>
    /// Manages a Security Hub administrator account for an organization. The AWS account utilizing this resource must be an Organizations primary account. More information about Organizations support in Security Hub can be found in the [Security Hub User Guide](https://docs.aws.amazon.com/securityhub/latest/userguide/designate-orgs-admin-account.html).
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
    ///     var example = new Aws.Organizations.Organization("example", new()
    ///     {
    ///         AwsServiceAccessPrincipals = new[]
    ///         {
    ///             "securityhub.amazonaws.com",
    ///         },
    ///         FeatureSet = "ALL",
    ///     });
    /// 
    ///     var exampleAccount = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleOrganizationAdminAccount = new Aws.SecurityHub.OrganizationAdminAccount("example", new()
    ///     {
    ///         AdminAccountId = "123456789012",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    ///     // Auto enable security hub in organization member accounts
    ///     var exampleOrganizationConfiguration = new Aws.SecurityHub.OrganizationConfiguration("example", new()
    ///     {
    ///         AutoEnable = true,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Security Hub Organization Admin Accounts using the AWS account ID. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:securityhub/organizationAdminAccount:OrganizationAdminAccount example 123456789012
    /// ```
    /// </summary>
    [AwsResourceType("aws:securityhub/organizationAdminAccount:OrganizationAdminAccount")]
    public partial class OrganizationAdminAccount : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The AWS account identifier of the account to designate as the Security Hub administrator account.
        /// </summary>
        [Output("adminAccountId")]
        public Output<string> AdminAccountId { get; private set; } = null!;


        /// <summary>
        /// Create a OrganizationAdminAccount resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public OrganizationAdminAccount(string name, OrganizationAdminAccountArgs args, CustomResourceOptions? options = null)
            : base("aws:securityhub/organizationAdminAccount:OrganizationAdminAccount", name, args ?? new OrganizationAdminAccountArgs(), MakeResourceOptions(options, ""))
        {
        }

        private OrganizationAdminAccount(string name, Input<string> id, OrganizationAdminAccountState? state = null, CustomResourceOptions? options = null)
            : base("aws:securityhub/organizationAdminAccount:OrganizationAdminAccount", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing OrganizationAdminAccount resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static OrganizationAdminAccount Get(string name, Input<string> id, OrganizationAdminAccountState? state = null, CustomResourceOptions? options = null)
        {
            return new OrganizationAdminAccount(name, id, state, options);
        }
    }

    public sealed class OrganizationAdminAccountArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The AWS account identifier of the account to designate as the Security Hub administrator account.
        /// </summary>
        [Input("adminAccountId", required: true)]
        public Input<string> AdminAccountId { get; set; } = null!;

        public OrganizationAdminAccountArgs()
        {
        }
        public static new OrganizationAdminAccountArgs Empty => new OrganizationAdminAccountArgs();
    }

    public sealed class OrganizationAdminAccountState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The AWS account identifier of the account to designate as the Security Hub administrator account.
        /// </summary>
        [Input("adminAccountId")]
        public Input<string>? AdminAccountId { get; set; }

        public OrganizationAdminAccountState()
        {
        }
        public static new OrganizationAdminAccountState Empty => new OrganizationAdminAccountState();
    }
}
