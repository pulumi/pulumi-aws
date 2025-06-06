// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SesV2
{
    public static class GetEmailIdentity
    {
        /// <summary>
        /// Data source for managing an AWS SESv2 (Simple Email V2) Email Identity.
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
        ///     var example = Aws.SesV2.GetEmailIdentity.Invoke(new()
        ///     {
        ///         EmailIdentity = "example.com",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetEmailIdentityResult> InvokeAsync(GetEmailIdentityArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetEmailIdentityResult>("aws:sesv2/getEmailIdentity:getEmailIdentity", args ?? new GetEmailIdentityArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS SESv2 (Simple Email V2) Email Identity.
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
        ///     var example = Aws.SesV2.GetEmailIdentity.Invoke(new()
        ///     {
        ///         EmailIdentity = "example.com",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetEmailIdentityResult> Invoke(GetEmailIdentityInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetEmailIdentityResult>("aws:sesv2/getEmailIdentity:getEmailIdentity", args ?? new GetEmailIdentityInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS SESv2 (Simple Email V2) Email Identity.
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
        ///     var example = Aws.SesV2.GetEmailIdentity.Invoke(new()
        ///     {
        ///         EmailIdentity = "example.com",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetEmailIdentityResult> Invoke(GetEmailIdentityInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetEmailIdentityResult>("aws:sesv2/getEmailIdentity:getEmailIdentity", args ?? new GetEmailIdentityInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetEmailIdentityArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The name of the email identity.
        /// </summary>
        [Input("emailIdentity", required: true)]
        public string EmailIdentity { get; set; } = null!;

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetEmailIdentityArgs()
        {
        }
        public static new GetEmailIdentityArgs Empty => new GetEmailIdentityArgs();
    }

    public sealed class GetEmailIdentityInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The name of the email identity.
        /// </summary>
        [Input("emailIdentity", required: true)]
        public Input<string> EmailIdentity { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetEmailIdentityInvokeArgs()
        {
        }
        public static new GetEmailIdentityInvokeArgs Empty => new GetEmailIdentityInvokeArgs();
    }


    [OutputType]
    public sealed class GetEmailIdentityResult
    {
        /// <summary>
        /// ARN of the Email Identity.
        /// </summary>
        public readonly string Arn;
        public readonly string ConfigurationSetName;
        /// <summary>
        /// A list of objects that contains at most one element with information about the private key and selector that you want to use to configure DKIM for the identity for Bring Your Own DKIM (BYODKIM) for the identity, or, configures the key length to be used for Easy DKIM.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetEmailIdentityDkimSigningAttributeResult> DkimSigningAttributes;
        public readonly string EmailIdentity;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// The email identity type. Valid values: `EMAIL_ADDRESS`, `DOMAIN`.
        /// </summary>
        public readonly string IdentityType;
        /// <summary>
        /// Key-value mapping of resource tags.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;
        /// <summary>
        /// Specifies whether or not the identity is verified.
        /// </summary>
        public readonly bool VerifiedForSendingStatus;

        [OutputConstructor]
        private GetEmailIdentityResult(
            string arn,

            string configurationSetName,

            ImmutableArray<Outputs.GetEmailIdentityDkimSigningAttributeResult> dkimSigningAttributes,

            string emailIdentity,

            string id,

            string identityType,

            ImmutableDictionary<string, string> tags,

            bool verifiedForSendingStatus)
        {
            Arn = arn;
            ConfigurationSetName = configurationSetName;
            DkimSigningAttributes = dkimSigningAttributes;
            EmailIdentity = emailIdentity;
            Id = id;
            IdentityType = identityType;
            Tags = tags;
            VerifiedForSendingStatus = verifiedForSendingStatus;
        }
    }
}
