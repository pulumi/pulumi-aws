// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedPermissions
{
    /// <summary>
    /// Resource for managing an AWS Verified Permissions Identity Source.
    /// 
    /// ## Example Usage
    /// 
    /// ### Cognito User Pool Configuration Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.VerifiedPermissions.PolicyStore("example", new()
    ///     {
    ///         ValidationSettings = new Aws.VerifiedPermissions.Inputs.PolicyStoreValidationSettingsArgs
    ///         {
    ///             Mode = "STRICT",
    ///         },
    ///     });
    /// 
    ///     var exampleUserPool = new Aws.Cognito.UserPool("example", new()
    ///     {
    ///         Name = "example",
    ///     });
    /// 
    ///     var exampleUserPoolClient = new Aws.Cognito.UserPoolClient("example", new()
    ///     {
    ///         Name = "example",
    ///         UserPoolId = exampleUserPool.Id,
    ///         ExplicitAuthFlows = new[]
    ///         {
    ///             "ADMIN_NO_SRP_AUTH",
    ///         },
    ///     });
    /// 
    ///     var exampleIdentitySource = new Aws.VerifiedPermissions.IdentitySource("example", new()
    ///     {
    ///         PolicyStoreId = example.Id,
    ///         Configuration = new Aws.VerifiedPermissions.Inputs.IdentitySourceConfigurationArgs
    ///         {
    ///             CognitoUserPoolConfiguration = new Aws.VerifiedPermissions.Inputs.IdentitySourceConfigurationCognitoUserPoolConfigurationArgs
    ///             {
    ///                 UserPoolArn = exampleUserPool.Arn,
    ///                 ClientIds = new[]
    ///                 {
    ///                     exampleUserPoolClient.Id,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### OpenID Connect Configuration Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.VerifiedPermissions.PolicyStore("example", new()
    ///     {
    ///         ValidationSettings = new Aws.VerifiedPermissions.Inputs.PolicyStoreValidationSettingsArgs
    ///         {
    ///             Mode = "STRICT",
    ///         },
    ///     });
    /// 
    ///     var exampleIdentitySource = new Aws.VerifiedPermissions.IdentitySource("example", new()
    ///     {
    ///         PolicyStoreId = example.Id,
    ///         Configuration = new Aws.VerifiedPermissions.Inputs.IdentitySourceConfigurationArgs
    ///         {
    ///             OpenIdConnectConfiguration = new Aws.VerifiedPermissions.Inputs.IdentitySourceConfigurationOpenIdConnectConfigurationArgs
    ///             {
    ///                 Issuer = "https://auth.example.com",
    ///                 TokenSelection = new Aws.VerifiedPermissions.Inputs.IdentitySourceConfigurationOpenIdConnectConfigurationTokenSelectionArgs
    ///                 {
    ///                     AccessTokenOnly = new Aws.VerifiedPermissions.Inputs.IdentitySourceConfigurationOpenIdConnectConfigurationTokenSelectionAccessTokenOnlyArgs
    ///                     {
    ///                         Audiences = new[]
    ///                         {
    ///                             "https://myapp.example.com",
    ///                         },
    ///                         PrincipalIdClaim = "sub",
    ///                     },
    ///                 },
    ///                 EntityIdPrefix = "MyOIDCProvider",
    ///                 GroupConfiguration = new Aws.VerifiedPermissions.Inputs.IdentitySourceConfigurationOpenIdConnectConfigurationGroupConfigurationArgs
    ///                 {
    ///                     GroupClaim = "groups",
    ///                     GroupEntityType = "MyCorp::UserGroup",
    ///                 },
    ///             },
    ///         },
    ///         PrincipalEntityType = "MyCorp::User",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Verified Permissions Identity Source using the `policy_store_id:identity_source_id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:verifiedpermissions/identitySource:IdentitySource example policy-store-id-12345678:identity-source-id-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:verifiedpermissions/identitySource:IdentitySource")]
    public partial class IdentitySource : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Specifies the details required to communicate with the identity provider (IdP) associated with this identity source. See Configuration below.
        /// </summary>
        [Output("configuration")]
        public Output<Outputs.IdentitySourceConfiguration?> Configuration { get; private set; } = null!;

        /// <summary>
        /// Specifies the ID of the policy store in which you want to store this identity source.
        /// </summary>
        [Output("policyStoreId")]
        public Output<string> PolicyStoreId { get; private set; } = null!;

        /// <summary>
        /// Specifies the namespace and data type of the principals generated for identities authenticated by the new identity source.
        /// </summary>
        [Output("principalEntityType")]
        public Output<string> PrincipalEntityType { get; private set; } = null!;


        /// <summary>
        /// Create a IdentitySource resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public IdentitySource(string name, IdentitySourceArgs args, CustomResourceOptions? options = null)
            : base("aws:verifiedpermissions/identitySource:IdentitySource", name, args ?? new IdentitySourceArgs(), MakeResourceOptions(options, ""))
        {
        }

        private IdentitySource(string name, Input<string> id, IdentitySourceState? state = null, CustomResourceOptions? options = null)
            : base("aws:verifiedpermissions/identitySource:IdentitySource", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing IdentitySource resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static IdentitySource Get(string name, Input<string> id, IdentitySourceState? state = null, CustomResourceOptions? options = null)
        {
            return new IdentitySource(name, id, state, options);
        }
    }

    public sealed class IdentitySourceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the details required to communicate with the identity provider (IdP) associated with this identity source. See Configuration below.
        /// </summary>
        [Input("configuration")]
        public Input<Inputs.IdentitySourceConfigurationArgs>? Configuration { get; set; }

        /// <summary>
        /// Specifies the ID of the policy store in which you want to store this identity source.
        /// </summary>
        [Input("policyStoreId", required: true)]
        public Input<string> PolicyStoreId { get; set; } = null!;

        /// <summary>
        /// Specifies the namespace and data type of the principals generated for identities authenticated by the new identity source.
        /// </summary>
        [Input("principalEntityType")]
        public Input<string>? PrincipalEntityType { get; set; }

        public IdentitySourceArgs()
        {
        }
        public static new IdentitySourceArgs Empty => new IdentitySourceArgs();
    }

    public sealed class IdentitySourceState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the details required to communicate with the identity provider (IdP) associated with this identity source. See Configuration below.
        /// </summary>
        [Input("configuration")]
        public Input<Inputs.IdentitySourceConfigurationGetArgs>? Configuration { get; set; }

        /// <summary>
        /// Specifies the ID of the policy store in which you want to store this identity source.
        /// </summary>
        [Input("policyStoreId")]
        public Input<string>? PolicyStoreId { get; set; }

        /// <summary>
        /// Specifies the namespace and data type of the principals generated for identities authenticated by the new identity source.
        /// </summary>
        [Input("principalEntityType")]
        public Input<string>? PrincipalEntityType { get; set; }

        public IdentitySourceState()
        {
        }
        public static new IdentitySourceState Empty => new IdentitySourceState();
    }
}
