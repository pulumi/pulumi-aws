// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kms
{
    public static class GetKey
    {
        /// <summary>
        /// Use this data source to get detailed information about
        /// the specified KMS Key with flexible key id input.
        /// This can be useful to reference key alias
        /// without having to hard code the ARN as input.
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
        ///     var byAlias = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "alias/my-key",
        ///     });
        /// 
        ///     var byId = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "1234abcd-12ab-34cd-56ef-1234567890ab",
        ///     });
        /// 
        ///     var byAliasArn = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "arn:aws:kms:us-east-1:111122223333:alias/my-key",
        ///     });
        /// 
        ///     var byKeyArn = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "arn:aws:kms:us-east-1:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetKeyResult> InvokeAsync(GetKeyArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetKeyResult>("aws:kms/getKey:getKey", args ?? new GetKeyArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get detailed information about
        /// the specified KMS Key with flexible key id input.
        /// This can be useful to reference key alias
        /// without having to hard code the ARN as input.
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
        ///     var byAlias = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "alias/my-key",
        ///     });
        /// 
        ///     var byId = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "1234abcd-12ab-34cd-56ef-1234567890ab",
        ///     });
        /// 
        ///     var byAliasArn = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "arn:aws:kms:us-east-1:111122223333:alias/my-key",
        ///     });
        /// 
        ///     var byKeyArn = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "arn:aws:kms:us-east-1:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetKeyResult> Invoke(GetKeyInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetKeyResult>("aws:kms/getKey:getKey", args ?? new GetKeyInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get detailed information about
        /// the specified KMS Key with flexible key id input.
        /// This can be useful to reference key alias
        /// without having to hard code the ARN as input.
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
        ///     var byAlias = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "alias/my-key",
        ///     });
        /// 
        ///     var byId = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "1234abcd-12ab-34cd-56ef-1234567890ab",
        ///     });
        /// 
        ///     var byAliasArn = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "arn:aws:kms:us-east-1:111122223333:alias/my-key",
        ///     });
        /// 
        ///     var byKeyArn = Aws.Kms.GetKey.Invoke(new()
        ///     {
        ///         KeyId = "arn:aws:kms:us-east-1:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetKeyResult> Invoke(GetKeyInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetKeyResult>("aws:kms/getKey:getKey", args ?? new GetKeyInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetKeyArgs : global::Pulumi.InvokeArgs
    {
        [Input("grantTokens")]
        private List<string>? _grantTokens;

        /// <summary>
        /// List of grant tokens
        /// </summary>
        public List<string> GrantTokens
        {
            get => _grantTokens ?? (_grantTokens = new List<string>());
            set => _grantTokens = value;
        }

        /// <summary>
        /// Key identifier which can be one of the following format:
        /// * Key ID. E.g: `1234abcd-12ab-34cd-56ef-1234567890ab`
        /// * Key ARN. E.g.: `arn:aws:kms:us-east-1:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab`
        /// * Alias name. E.g.: `alias/my-key`
        /// * Alias ARN: E.g.: `arn:aws:kms:us-east-1:111122223333:alias/my-key`
        /// </summary>
        [Input("keyId", required: true)]
        public string KeyId { get; set; } = null!;

        public GetKeyArgs()
        {
        }
        public static new GetKeyArgs Empty => new GetKeyArgs();
    }

    public sealed class GetKeyInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("grantTokens")]
        private InputList<string>? _grantTokens;

        /// <summary>
        /// List of grant tokens
        /// </summary>
        public InputList<string> GrantTokens
        {
            get => _grantTokens ?? (_grantTokens = new InputList<string>());
            set => _grantTokens = value;
        }

        /// <summary>
        /// Key identifier which can be one of the following format:
        /// * Key ID. E.g: `1234abcd-12ab-34cd-56ef-1234567890ab`
        /// * Key ARN. E.g.: `arn:aws:kms:us-east-1:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab`
        /// * Alias name. E.g.: `alias/my-key`
        /// * Alias ARN: E.g.: `arn:aws:kms:us-east-1:111122223333:alias/my-key`
        /// </summary>
        [Input("keyId", required: true)]
        public Input<string> KeyId { get; set; } = null!;

        public GetKeyInvokeArgs()
        {
        }
        public static new GetKeyInvokeArgs Empty => new GetKeyInvokeArgs();
    }


    [OutputType]
    public sealed class GetKeyResult
    {
        /// <summary>
        /// The key ARN of a primary or replica key of a multi-Region key.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The twelve-digit account ID of the AWS account that owns the key
        /// </summary>
        public readonly string AwsAccountId;
        /// <summary>
        /// The cluster ID of the AWS CloudHSM cluster that contains the key material for the KMS key.
        /// </summary>
        public readonly string CloudHsmClusterId;
        /// <summary>
        /// The date and time when the key was created
        /// </summary>
        public readonly string CreationDate;
        /// <summary>
        /// A unique identifier for the custom key store that contains the KMS key.
        /// </summary>
        public readonly string CustomKeyStoreId;
        /// <summary>
        /// Specifies whether the key contains a symmetric key or an asymmetric key pair and the encryption algorithms or signing algorithms that the key supports
        /// </summary>
        public readonly string CustomerMasterKeySpec;
        /// <summary>
        /// The date and time after which AWS KMS deletes the key. This value is present only when `key_state` is `PendingDeletion`, otherwise this value is 0
        /// </summary>
        public readonly string DeletionDate;
        /// <summary>
        /// The description of the key.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// Specifies whether the key is enabled. When `key_state` is `Enabled` this value is true, otherwise it is false
        /// </summary>
        public readonly bool Enabled;
        /// <summary>
        /// Specifies whether the Key's key material expires. This value is present only when `origin` is `EXTERNAL`, otherwise this value is empty
        /// </summary>
        public readonly string ExpirationModel;
        public readonly ImmutableArray<string> GrantTokens;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string KeyId;
        /// <summary>
        /// The key's manager
        /// </summary>
        public readonly string KeyManager;
        /// <summary>
        /// Describes the type of key material in the KMS key.
        /// </summary>
        public readonly string KeySpec;
        /// <summary>
        /// The state of the key
        /// </summary>
        public readonly string KeyState;
        /// <summary>
        /// Specifies the intended use of the key
        /// </summary>
        public readonly string KeyUsage;
        /// <summary>
        /// Indicates whether the KMS key is a multi-Region (`true`) or regional (`false`) key.
        /// </summary>
        public readonly bool MultiRegion;
        /// <summary>
        /// Lists the primary and replica keys in same multi-Region key. Present only when the value of `multi_region` is `true`.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetKeyMultiRegionConfigurationResult> MultiRegionConfigurations;
        /// <summary>
        /// When this value is `AWS_KMS`, AWS KMS created the key material. When this value is `EXTERNAL`, the key material was imported from your existing key management infrastructure or the CMK lacks key material
        /// </summary>
        public readonly string Origin;
        /// <summary>
        /// The waiting period before the primary key in a multi-Region key is deleted.
        /// </summary>
        public readonly int PendingDeletionWindowInDays;
        /// <summary>
        /// The time at which the imported key material expires. This value is present only when `origin` is `EXTERNAL` and whose `expiration_model` is `KEY_MATERIAL_EXPIRES`, otherwise this value is 0
        /// </summary>
        public readonly string ValidTo;
        /// <summary>
        /// Information about the external key that is associated with a KMS key in an external key store.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetKeyXksKeyConfigurationResult> XksKeyConfigurations;

        [OutputConstructor]
        private GetKeyResult(
            string arn,

            string awsAccountId,

            string cloudHsmClusterId,

            string creationDate,

            string customKeyStoreId,

            string customerMasterKeySpec,

            string deletionDate,

            string description,

            bool enabled,

            string expirationModel,

            ImmutableArray<string> grantTokens,

            string id,

            string keyId,

            string keyManager,

            string keySpec,

            string keyState,

            string keyUsage,

            bool multiRegion,

            ImmutableArray<Outputs.GetKeyMultiRegionConfigurationResult> multiRegionConfigurations,

            string origin,

            int pendingDeletionWindowInDays,

            string validTo,

            ImmutableArray<Outputs.GetKeyXksKeyConfigurationResult> xksKeyConfigurations)
        {
            Arn = arn;
            AwsAccountId = awsAccountId;
            CloudHsmClusterId = cloudHsmClusterId;
            CreationDate = creationDate;
            CustomKeyStoreId = customKeyStoreId;
            CustomerMasterKeySpec = customerMasterKeySpec;
            DeletionDate = deletionDate;
            Description = description;
            Enabled = enabled;
            ExpirationModel = expirationModel;
            GrantTokens = grantTokens;
            Id = id;
            KeyId = keyId;
            KeyManager = keyManager;
            KeySpec = keySpec;
            KeyState = keyState;
            KeyUsage = keyUsage;
            MultiRegion = multiRegion;
            MultiRegionConfigurations = multiRegionConfigurations;
            Origin = origin;
            PendingDeletionWindowInDays = pendingDeletionWindowInDays;
            ValidTo = validTo;
            XksKeyConfigurations = xksKeyConfigurations;
        }
    }
}
