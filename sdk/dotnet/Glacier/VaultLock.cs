// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glacier
{
    /// <summary>
    /// ## Example Usage
    /// 
    /// ### Testing Glacier Vault Lock Policy
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var exampleVault = new Aws.Glacier.Vault("example", new()
    ///     {
    ///         Name = "example",
    ///     });
    /// 
    ///     var example = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Actions = new[]
    ///                 {
    ///                     "glacier:DeleteArchive",
    ///                 },
    ///                 Effect = "Deny",
    ///                 Resources = new[]
    ///                 {
    ///                     exampleVault.Arn,
    ///                 },
    ///                 Conditions = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementConditionInputArgs
    ///                     {
    ///                         Test = "NumericLessThanEquals",
    ///                         Variable = "glacier:ArchiveAgeinDays",
    ///                         Values = new[]
    ///                         {
    ///                             "365",
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleVaultLock = new Aws.Glacier.VaultLock("example", new()
    ///     {
    ///         CompleteLock = false,
    ///         Policy = example.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///         VaultName = exampleVault.Name,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Permanently Applying Glacier Vault Lock Policy
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Glacier.VaultLock("example", new()
    ///     {
    ///         CompleteLock = true,
    ///         Policy = exampleAwsIamPolicyDocument.Json,
    ///         VaultName = exampleAwsGlacierVault.Name,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Glacier Vault Locks using the Glacier Vault name. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:glacier/vaultLock:VaultLock example example-vault
    /// ```
    /// </summary>
    [AwsResourceType("aws:glacier/vaultLock:VaultLock")]
    public partial class VaultLock : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Boolean whether to permanently apply this Glacier Lock Policy. Once completed, this cannot be undone. If set to `false`, the Glacier Lock Policy remains in a testing mode for 24 hours. After that time, the Glacier Lock Policy is automatically removed by Glacier and the this provider resource will show as needing recreation. Changing this from `false` to `true` will show as resource recreation, which is expected. Changing this from `true` to `false` is not possible unless the Glacier Vault is recreated at the same time.
        /// </summary>
        [Output("completeLock")]
        public Output<bool> CompleteLock { get; private set; } = null!;

        /// <summary>
        /// Allow this provider to ignore the error returned when attempting to delete the Glacier Lock Policy. This can be used to delete or recreate the Glacier Vault via this provider, for example, if the Glacier Vault Lock policy permits that action. This should only be used in conjunction with `complete_lock` being set to `true`.
        /// </summary>
        [Output("ignoreDeletionError")]
        public Output<bool?> IgnoreDeletionError { get; private set; } = null!;

        /// <summary>
        /// JSON string containing the IAM policy to apply as the Glacier Vault Lock policy.
        /// </summary>
        [Output("policy")]
        public Output<string> Policy { get; private set; } = null!;

        /// <summary>
        /// The name of the Glacier Vault.
        /// </summary>
        [Output("vaultName")]
        public Output<string> VaultName { get; private set; } = null!;


        /// <summary>
        /// Create a VaultLock resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public VaultLock(string name, VaultLockArgs args, CustomResourceOptions? options = null)
            : base("aws:glacier/vaultLock:VaultLock", name, args ?? new VaultLockArgs(), MakeResourceOptions(options, ""))
        {
        }

        private VaultLock(string name, Input<string> id, VaultLockState? state = null, CustomResourceOptions? options = null)
            : base("aws:glacier/vaultLock:VaultLock", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing VaultLock resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static VaultLock Get(string name, Input<string> id, VaultLockState? state = null, CustomResourceOptions? options = null)
        {
            return new VaultLock(name, id, state, options);
        }
    }

    public sealed class VaultLockArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Boolean whether to permanently apply this Glacier Lock Policy. Once completed, this cannot be undone. If set to `false`, the Glacier Lock Policy remains in a testing mode for 24 hours. After that time, the Glacier Lock Policy is automatically removed by Glacier and the this provider resource will show as needing recreation. Changing this from `false` to `true` will show as resource recreation, which is expected. Changing this from `true` to `false` is not possible unless the Glacier Vault is recreated at the same time.
        /// </summary>
        [Input("completeLock", required: true)]
        public Input<bool> CompleteLock { get; set; } = null!;

        /// <summary>
        /// Allow this provider to ignore the error returned when attempting to delete the Glacier Lock Policy. This can be used to delete or recreate the Glacier Vault via this provider, for example, if the Glacier Vault Lock policy permits that action. This should only be used in conjunction with `complete_lock` being set to `true`.
        /// </summary>
        [Input("ignoreDeletionError")]
        public Input<bool>? IgnoreDeletionError { get; set; }

        /// <summary>
        /// JSON string containing the IAM policy to apply as the Glacier Vault Lock policy.
        /// </summary>
        [Input("policy", required: true)]
        public Input<string> Policy { get; set; } = null!;

        /// <summary>
        /// The name of the Glacier Vault.
        /// </summary>
        [Input("vaultName", required: true)]
        public Input<string> VaultName { get; set; } = null!;

        public VaultLockArgs()
        {
        }
        public static new VaultLockArgs Empty => new VaultLockArgs();
    }

    public sealed class VaultLockState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Boolean whether to permanently apply this Glacier Lock Policy. Once completed, this cannot be undone. If set to `false`, the Glacier Lock Policy remains in a testing mode for 24 hours. After that time, the Glacier Lock Policy is automatically removed by Glacier and the this provider resource will show as needing recreation. Changing this from `false` to `true` will show as resource recreation, which is expected. Changing this from `true` to `false` is not possible unless the Glacier Vault is recreated at the same time.
        /// </summary>
        [Input("completeLock")]
        public Input<bool>? CompleteLock { get; set; }

        /// <summary>
        /// Allow this provider to ignore the error returned when attempting to delete the Glacier Lock Policy. This can be used to delete or recreate the Glacier Vault via this provider, for example, if the Glacier Vault Lock policy permits that action. This should only be used in conjunction with `complete_lock` being set to `true`.
        /// </summary>
        [Input("ignoreDeletionError")]
        public Input<bool>? IgnoreDeletionError { get; set; }

        /// <summary>
        /// JSON string containing the IAM policy to apply as the Glacier Vault Lock policy.
        /// </summary>
        [Input("policy")]
        public Input<string>? Policy { get; set; }

        /// <summary>
        /// The name of the Glacier Vault.
        /// </summary>
        [Input("vaultName")]
        public Input<string>? VaultName { get; set; }

        public VaultLockState()
        {
        }
        public static new VaultLockState Empty => new VaultLockState();
    }
}
