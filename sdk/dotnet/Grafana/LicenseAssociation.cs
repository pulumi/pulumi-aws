// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Grafana
{
    /// <summary>
    /// Provides an Amazon Managed Grafana workspace license association resource.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic configuration
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using System.Text.Json;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var assume = new Aws.Iam.Role("assume", new()
    ///     {
    ///         Name = "grafana-assume",
    ///         AssumeRolePolicy = JsonSerializer.Serialize(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["Version"] = "2012-10-17",
    ///             ["Statement"] = new[]
    ///             {
    ///                 new Dictionary&lt;string, object?&gt;
    ///                 {
    ///                     ["Action"] = "sts:AssumeRole",
    ///                     ["Effect"] = "Allow",
    ///                     ["Sid"] = "",
    ///                     ["Principal"] = new Dictionary&lt;string, object?&gt;
    ///                     {
    ///                         ["Service"] = "grafana.amazonaws.com",
    ///                     },
    ///                 },
    ///             },
    ///         }),
    ///     });
    /// 
    ///     var exampleWorkspace = new Aws.Grafana.Workspace("example", new()
    ///     {
    ///         AccountAccessType = "CURRENT_ACCOUNT",
    ///         AuthenticationProviders = new[]
    ///         {
    ///             "SAML",
    ///         },
    ///         PermissionType = "SERVICE_MANAGED",
    ///         RoleArn = assume.Arn,
    ///     });
    /// 
    ///     var example = new Aws.Grafana.LicenseAssociation("example", new()
    ///     {
    ///         LicenseType = "ENTERPRISE_FREE_TRIAL",
    ///         WorkspaceId = exampleWorkspace.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Grafana workspace license association using the workspace's `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:grafana/licenseAssociation:LicenseAssociation example g-2054c75a02
    /// ```
    /// </summary>
    [AwsResourceType("aws:grafana/licenseAssociation:LicenseAssociation")]
    public partial class LicenseAssociation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// If `license_type` is set to `ENTERPRISE_FREE_TRIAL`, this is the expiration date of the free trial.
        /// </summary>
        [Output("freeTrialExpiration")]
        public Output<string> FreeTrialExpiration { get; private set; } = null!;

        /// <summary>
        /// A token from Grafana Labs that ties your AWS account with a Grafana Labs account.
        /// </summary>
        [Output("grafanaToken")]
        public Output<string?> GrafanaToken { get; private set; } = null!;

        /// <summary>
        /// If `license_type` is set to `ENTERPRISE`, this is the expiration date of the enterprise license.
        /// </summary>
        [Output("licenseExpiration")]
        public Output<string> LicenseExpiration { get; private set; } = null!;

        /// <summary>
        /// The type of license for the workspace license association. Valid values are `ENTERPRISE` and `ENTERPRISE_FREE_TRIAL`.
        /// </summary>
        [Output("licenseType")]
        public Output<string> LicenseType { get; private set; } = null!;

        /// <summary>
        /// The workspace id.
        /// </summary>
        [Output("workspaceId")]
        public Output<string> WorkspaceId { get; private set; } = null!;


        /// <summary>
        /// Create a LicenseAssociation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public LicenseAssociation(string name, LicenseAssociationArgs args, CustomResourceOptions? options = null)
            : base("aws:grafana/licenseAssociation:LicenseAssociation", name, args ?? new LicenseAssociationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private LicenseAssociation(string name, Input<string> id, LicenseAssociationState? state = null, CustomResourceOptions? options = null)
            : base("aws:grafana/licenseAssociation:LicenseAssociation", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing LicenseAssociation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static LicenseAssociation Get(string name, Input<string> id, LicenseAssociationState? state = null, CustomResourceOptions? options = null)
        {
            return new LicenseAssociation(name, id, state, options);
        }
    }

    public sealed class LicenseAssociationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A token from Grafana Labs that ties your AWS account with a Grafana Labs account.
        /// </summary>
        [Input("grafanaToken")]
        public Input<string>? GrafanaToken { get; set; }

        /// <summary>
        /// The type of license for the workspace license association. Valid values are `ENTERPRISE` and `ENTERPRISE_FREE_TRIAL`.
        /// </summary>
        [Input("licenseType", required: true)]
        public Input<string> LicenseType { get; set; } = null!;

        /// <summary>
        /// The workspace id.
        /// </summary>
        [Input("workspaceId", required: true)]
        public Input<string> WorkspaceId { get; set; } = null!;

        public LicenseAssociationArgs()
        {
        }
        public static new LicenseAssociationArgs Empty => new LicenseAssociationArgs();
    }

    public sealed class LicenseAssociationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// If `license_type` is set to `ENTERPRISE_FREE_TRIAL`, this is the expiration date of the free trial.
        /// </summary>
        [Input("freeTrialExpiration")]
        public Input<string>? FreeTrialExpiration { get; set; }

        /// <summary>
        /// A token from Grafana Labs that ties your AWS account with a Grafana Labs account.
        /// </summary>
        [Input("grafanaToken")]
        public Input<string>? GrafanaToken { get; set; }

        /// <summary>
        /// If `license_type` is set to `ENTERPRISE`, this is the expiration date of the enterprise license.
        /// </summary>
        [Input("licenseExpiration")]
        public Input<string>? LicenseExpiration { get; set; }

        /// <summary>
        /// The type of license for the workspace license association. Valid values are `ENTERPRISE` and `ENTERPRISE_FREE_TRIAL`.
        /// </summary>
        [Input("licenseType")]
        public Input<string>? LicenseType { get; set; }

        /// <summary>
        /// The workspace id.
        /// </summary>
        [Input("workspaceId")]
        public Input<string>? WorkspaceId { get; set; }

        public LicenseAssociationState()
        {
        }
        public static new LicenseAssociationState Empty => new LicenseAssociationState();
    }
}
