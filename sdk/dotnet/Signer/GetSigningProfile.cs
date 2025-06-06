// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Signer
{
    public static class GetSigningProfile
    {
        /// <summary>
        /// Provides information about a Signer Signing Profile.
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
        ///     var productionSigningProfile = Aws.Signer.GetSigningProfile.Invoke(new()
        ///     {
        ///         Name = "prod_profile_DdW3Mk1foYL88fajut4mTVFGpuwfd4ACO6ANL0D1uIj7lrn8adK",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetSigningProfileResult> InvokeAsync(GetSigningProfileArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetSigningProfileResult>("aws:signer/getSigningProfile:getSigningProfile", args ?? new GetSigningProfileArgs(), options.WithDefaults());

        /// <summary>
        /// Provides information about a Signer Signing Profile.
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
        ///     var productionSigningProfile = Aws.Signer.GetSigningProfile.Invoke(new()
        ///     {
        ///         Name = "prod_profile_DdW3Mk1foYL88fajut4mTVFGpuwfd4ACO6ANL0D1uIj7lrn8adK",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetSigningProfileResult> Invoke(GetSigningProfileInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetSigningProfileResult>("aws:signer/getSigningProfile:getSigningProfile", args ?? new GetSigningProfileInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides information about a Signer Signing Profile.
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
        ///     var productionSigningProfile = Aws.Signer.GetSigningProfile.Invoke(new()
        ///     {
        ///         Name = "prod_profile_DdW3Mk1foYL88fajut4mTVFGpuwfd4ACO6ANL0D1uIj7lrn8adK",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetSigningProfileResult> Invoke(GetSigningProfileInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetSigningProfileResult>("aws:signer/getSigningProfile:getSigningProfile", args ?? new GetSigningProfileInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetSigningProfileArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the target signing profile.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// List of tags associated with the signing profile.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetSigningProfileArgs()
        {
        }
        public static new GetSigningProfileArgs Empty => new GetSigningProfileArgs();
    }

    public sealed class GetSigningProfileInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the target signing profile.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// List of tags associated with the signing profile.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetSigningProfileInvokeArgs()
        {
        }
        public static new GetSigningProfileInvokeArgs Empty => new GetSigningProfileInvokeArgs();
    }


    [OutputType]
    public sealed class GetSigningProfileResult
    {
        /// <summary>
        /// ARN for the signing profile.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string Name;
        /// <summary>
        /// A human-readable name for the signing platform associated with the signing profile.
        /// </summary>
        public readonly string PlatformDisplayName;
        /// <summary>
        /// ID of the platform that is used by the target signing profile.
        /// </summary>
        public readonly string PlatformId;
        /// <summary>
        /// Revocation information for a signing profile.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetSigningProfileRevocationRecordResult> RevocationRecords;
        /// <summary>
        /// The validity period for a signing job.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetSigningProfileSignatureValidityPeriodResult> SignatureValidityPeriods;
        /// <summary>
        /// Status of the target signing profile.
        /// </summary>
        public readonly string Status;
        /// <summary>
        /// List of tags associated with the signing profile.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;
        /// <summary>
        /// Current version of the signing profile.
        /// </summary>
        public readonly string Version;
        /// <summary>
        /// Signing profile ARN, including the profile version.
        /// </summary>
        public readonly string VersionArn;

        [OutputConstructor]
        private GetSigningProfileResult(
            string arn,

            string id,

            string name,

            string platformDisplayName,

            string platformId,

            ImmutableArray<Outputs.GetSigningProfileRevocationRecordResult> revocationRecords,

            ImmutableArray<Outputs.GetSigningProfileSignatureValidityPeriodResult> signatureValidityPeriods,

            string status,

            ImmutableDictionary<string, string> tags,

            string version,

            string versionArn)
        {
            Arn = arn;
            Id = id;
            Name = name;
            PlatformDisplayName = platformDisplayName;
            PlatformId = platformId;
            RevocationRecords = revocationRecords;
            SignatureValidityPeriods = signatureValidityPeriods;
            Status = status;
            Tags = tags;
            Version = version;
            VersionArn = versionArn;
        }
    }
}
