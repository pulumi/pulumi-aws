// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pinpoint
{
    /// <summary>
    /// Provides a Pinpoint ADM (Amazon Device Messaging) Channel resource.
    /// 
    /// &gt; **Note:** All arguments including the Client ID and Client Secret will be stored in the raw state as plain-text.
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
    ///     var app = new Aws.Pinpoint.App("app");
    /// 
    ///     var channel = new Aws.Pinpoint.AdmChannel("channel", new()
    ///     {
    ///         ApplicationId = app.ApplicationId,
    ///         ClientId = "",
    ///         ClientSecret = "",
    ///         Enabled = true,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Pinpoint ADM Channel using the `application-id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:pinpoint/admChannel:AdmChannel channel application-id
    /// ```
    /// </summary>
    [AwsResourceType("aws:pinpoint/admChannel:AdmChannel")]
    public partial class AdmChannel : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The application ID.
        /// </summary>
        [Output("applicationId")]
        public Output<string> ApplicationId { get; private set; } = null!;

        /// <summary>
        /// Client ID (part of OAuth Credentials) obtained via Amazon Developer Account.
        /// </summary>
        [Output("clientId")]
        public Output<string> ClientId { get; private set; } = null!;

        /// <summary>
        /// Client Secret (part of OAuth Credentials) obtained via Amazon Developer Account.
        /// </summary>
        [Output("clientSecret")]
        public Output<string> ClientSecret { get; private set; } = null!;

        /// <summary>
        /// Specifies whether to enable the channel. Defaults to `true`.
        /// </summary>
        [Output("enabled")]
        public Output<bool?> Enabled { get; private set; } = null!;


        /// <summary>
        /// Create a AdmChannel resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public AdmChannel(string name, AdmChannelArgs args, CustomResourceOptions? options = null)
            : base("aws:pinpoint/admChannel:AdmChannel", name, args ?? new AdmChannelArgs(), MakeResourceOptions(options, ""))
        {
        }

        private AdmChannel(string name, Input<string> id, AdmChannelState? state = null, CustomResourceOptions? options = null)
            : base("aws:pinpoint/admChannel:AdmChannel", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "clientId",
                    "clientSecret",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing AdmChannel resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static AdmChannel Get(string name, Input<string> id, AdmChannelState? state = null, CustomResourceOptions? options = null)
        {
            return new AdmChannel(name, id, state, options);
        }
    }

    public sealed class AdmChannelArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The application ID.
        /// </summary>
        [Input("applicationId", required: true)]
        public Input<string> ApplicationId { get; set; } = null!;

        [Input("clientId", required: true)]
        private Input<string>? _clientId;

        /// <summary>
        /// Client ID (part of OAuth Credentials) obtained via Amazon Developer Account.
        /// </summary>
        public Input<string>? ClientId
        {
            get => _clientId;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _clientId = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        [Input("clientSecret", required: true)]
        private Input<string>? _clientSecret;

        /// <summary>
        /// Client Secret (part of OAuth Credentials) obtained via Amazon Developer Account.
        /// </summary>
        public Input<string>? ClientSecret
        {
            get => _clientSecret;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _clientSecret = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// Specifies whether to enable the channel. Defaults to `true`.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        public AdmChannelArgs()
        {
        }
        public static new AdmChannelArgs Empty => new AdmChannelArgs();
    }

    public sealed class AdmChannelState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The application ID.
        /// </summary>
        [Input("applicationId")]
        public Input<string>? ApplicationId { get; set; }

        [Input("clientId")]
        private Input<string>? _clientId;

        /// <summary>
        /// Client ID (part of OAuth Credentials) obtained via Amazon Developer Account.
        /// </summary>
        public Input<string>? ClientId
        {
            get => _clientId;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _clientId = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        [Input("clientSecret")]
        private Input<string>? _clientSecret;

        /// <summary>
        /// Client Secret (part of OAuth Credentials) obtained via Amazon Developer Account.
        /// </summary>
        public Input<string>? ClientSecret
        {
            get => _clientSecret;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _clientSecret = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// Specifies whether to enable the channel. Defaults to `true`.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        public AdmChannelState()
        {
        }
        public static new AdmChannelState Empty => new AdmChannelState();
    }
}
