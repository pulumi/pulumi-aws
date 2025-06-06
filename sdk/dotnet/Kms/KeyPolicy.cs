// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kms
{
    /// <summary>
    /// Attaches a policy to a KMS Key.
    /// 
    /// ## Example Usage
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
    ///     var example = new Aws.Kms.Key("example", new()
    ///     {
    ///         Description = "example",
    ///     });
    /// 
    ///     var exampleKeyPolicy = new Aws.Kms.KeyPolicy("example", new()
    ///     {
    ///         KeyId = example.Id,
    ///         Policy = JsonSerializer.Serialize(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["Id"] = "example",
    ///             ["Statement"] = new[]
    ///             {
    ///                 new Dictionary&lt;string, object?&gt;
    ///                 {
    ///                     ["Action"] = "kms:*",
    ///                     ["Effect"] = "Allow",
    ///                     ["Principal"] = new Dictionary&lt;string, object?&gt;
    ///                     {
    ///                         ["AWS"] = "*",
    ///                     },
    ///                     ["Resource"] = "*",
    ///                     ["Sid"] = "Enable IAM User Permissions",
    ///                 },
    ///             },
    ///             ["Version"] = "2012-10-17",
    ///         }),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import KMS Key Policies using the `key_id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:kms/keyPolicy:KeyPolicy a 1234abcd-12ab-34cd-56ef-1234567890ab
    /// ```
    /// </summary>
    [AwsResourceType("aws:kms/keyPolicy:KeyPolicy")]
    public partial class KeyPolicy : global::Pulumi.CustomResource
    {
        /// <summary>
        /// A flag to indicate whether to bypass the key policy lockout safety check.
        /// Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this value to true indiscriminately. If this value is set, and the resource is destroyed, a warning will be shown, and the resource will be removed from state.
        /// For more information, refer to the scenario in the [Default Key Policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default-allow-root-enable-iam) section in the _AWS Key Management Service Developer Guide_.
        /// </summary>
        [Output("bypassPolicyLockoutSafetyCheck")]
        public Output<bool?> BypassPolicyLockoutSafetyCheck { get; private set; } = null!;

        /// <summary>
        /// The ID of the KMS Key to attach the policy.
        /// </summary>
        [Output("keyId")]
        public Output<string> KeyId { get; private set; } = null!;

        /// <summary>
        /// A valid policy JSON document. Although this is a key policy, not an IAM policy, an `aws.iam.getPolicyDocument`, in the form that designates a principal, can be used. For more information about building policy documents, see the AWS IAM Policy Document Guide.
        /// 
        /// &gt; **NOTE:** Note: All KMS keys must have a key policy. If a key policy is not specified, or this resource is destroyed, AWS gives the KMS key a [default key policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default) that gives all principals in the owning account unlimited access to all KMS operations for the key. This default key policy effectively delegates all access control to IAM policies and KMS grants.
        /// </summary>
        [Output("policy")]
        public Output<string> Policy { get; private set; } = null!;


        /// <summary>
        /// Create a KeyPolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public KeyPolicy(string name, KeyPolicyArgs args, CustomResourceOptions? options = null)
            : base("aws:kms/keyPolicy:KeyPolicy", name, args ?? new KeyPolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private KeyPolicy(string name, Input<string> id, KeyPolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:kms/keyPolicy:KeyPolicy", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing KeyPolicy resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static KeyPolicy Get(string name, Input<string> id, KeyPolicyState? state = null, CustomResourceOptions? options = null)
        {
            return new KeyPolicy(name, id, state, options);
        }
    }

    public sealed class KeyPolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A flag to indicate whether to bypass the key policy lockout safety check.
        /// Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this value to true indiscriminately. If this value is set, and the resource is destroyed, a warning will be shown, and the resource will be removed from state.
        /// For more information, refer to the scenario in the [Default Key Policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default-allow-root-enable-iam) section in the _AWS Key Management Service Developer Guide_.
        /// </summary>
        [Input("bypassPolicyLockoutSafetyCheck")]
        public Input<bool>? BypassPolicyLockoutSafetyCheck { get; set; }

        /// <summary>
        /// The ID of the KMS Key to attach the policy.
        /// </summary>
        [Input("keyId", required: true)]
        public Input<string> KeyId { get; set; } = null!;

        /// <summary>
        /// A valid policy JSON document. Although this is a key policy, not an IAM policy, an `aws.iam.getPolicyDocument`, in the form that designates a principal, can be used. For more information about building policy documents, see the AWS IAM Policy Document Guide.
        /// 
        /// &gt; **NOTE:** Note: All KMS keys must have a key policy. If a key policy is not specified, or this resource is destroyed, AWS gives the KMS key a [default key policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default) that gives all principals in the owning account unlimited access to all KMS operations for the key. This default key policy effectively delegates all access control to IAM policies and KMS grants.
        /// </summary>
        [Input("policy", required: true)]
        public Input<string> Policy { get; set; } = null!;

        public KeyPolicyArgs()
        {
        }
        public static new KeyPolicyArgs Empty => new KeyPolicyArgs();
    }

    public sealed class KeyPolicyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A flag to indicate whether to bypass the key policy lockout safety check.
        /// Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this value to true indiscriminately. If this value is set, and the resource is destroyed, a warning will be shown, and the resource will be removed from state.
        /// For more information, refer to the scenario in the [Default Key Policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default-allow-root-enable-iam) section in the _AWS Key Management Service Developer Guide_.
        /// </summary>
        [Input("bypassPolicyLockoutSafetyCheck")]
        public Input<bool>? BypassPolicyLockoutSafetyCheck { get; set; }

        /// <summary>
        /// The ID of the KMS Key to attach the policy.
        /// </summary>
        [Input("keyId")]
        public Input<string>? KeyId { get; set; }

        /// <summary>
        /// A valid policy JSON document. Although this is a key policy, not an IAM policy, an `aws.iam.getPolicyDocument`, in the form that designates a principal, can be used. For more information about building policy documents, see the AWS IAM Policy Document Guide.
        /// 
        /// &gt; **NOTE:** Note: All KMS keys must have a key policy. If a key policy is not specified, or this resource is destroyed, AWS gives the KMS key a [default key policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default) that gives all principals in the owning account unlimited access to all KMS operations for the key. This default key policy effectively delegates all access control to IAM policies and KMS grants.
        /// </summary>
        [Input("policy")]
        public Input<string>? Policy { get; set; }

        public KeyPolicyState()
        {
        }
        public static new KeyPolicyState Empty => new KeyPolicyState();
    }
}
