// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iam
{
    /// <summary>
    /// Provides an IAM OpenID Connect provider.
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
    ///     var @default = new Aws.Iam.OpenIdConnectProvider("default", new()
    ///     {
    ///         Url = "https://accounts.google.com",
    ///         ClientIdLists = new[]
    ///         {
    ///             "266362248691-342342xasdasdasda-apps.googleusercontent.com",
    ///         },
    ///         ThumbprintLists = new[]
    ///         {
    ///             "cf23df2207d99a74fbe169e3eba035e633b65d94",
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Without A Thumbprint
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var @default = new Aws.Iam.OpenIdConnectProvider("default", new()
    ///     {
    ///         Url = "https://accounts.google.com",
    ///         ClientIdLists = new[]
    ///         {
    ///             "266362248691-342342xasdasdasda-apps.googleusercontent.com",
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import IAM OpenID Connect Providers using the `arn`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:iam/openIdConnectProvider:OpenIdConnectProvider default arn:aws:iam::123456789012:oidc-provider/accounts.google.com
    /// ```
    /// </summary>
    [AwsResourceType("aws:iam/openIdConnectProvider:OpenIdConnectProvider")]
    public partial class OpenIdConnectProvider : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN assigned by AWS for this provider.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// List of client IDs (audiences) that identify the application registered with the OpenID Connect provider. This is the value sent as the `client_id` parameter in OAuth requests.
        /// </summary>
        [Output("clientIdLists")]
        public Output<ImmutableArray<string>> ClientIdLists { get; private set; } = null!;

        /// <summary>
        /// Map of resource tags for the IAM OIDC provider. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        [Output("thumbprintLists")]
        public Output<ImmutableArray<string>> ThumbprintLists { get; private set; } = null!;

        /// <summary>
        /// URL of the identity provider, corresponding to the `iss` claim.
        /// </summary>
        [Output("url")]
        public Output<string> Url { get; private set; } = null!;


        /// <summary>
        /// Create a OpenIdConnectProvider resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public OpenIdConnectProvider(string name, OpenIdConnectProviderArgs args, CustomResourceOptions? options = null)
            : base("aws:iam/openIdConnectProvider:OpenIdConnectProvider", name, args ?? new OpenIdConnectProviderArgs(), MakeResourceOptions(options, ""))
        {
        }

        private OpenIdConnectProvider(string name, Input<string> id, OpenIdConnectProviderState? state = null, CustomResourceOptions? options = null)
            : base("aws:iam/openIdConnectProvider:OpenIdConnectProvider", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing OpenIdConnectProvider resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static OpenIdConnectProvider Get(string name, Input<string> id, OpenIdConnectProviderState? state = null, CustomResourceOptions? options = null)
        {
            return new OpenIdConnectProvider(name, id, state, options);
        }
    }

    public sealed class OpenIdConnectProviderArgs : global::Pulumi.ResourceArgs
    {
        [Input("clientIdLists", required: true)]
        private InputList<string>? _clientIdLists;

        /// <summary>
        /// List of client IDs (audiences) that identify the application registered with the OpenID Connect provider. This is the value sent as the `client_id` parameter in OAuth requests.
        /// </summary>
        public InputList<string> ClientIdLists
        {
            get => _clientIdLists ?? (_clientIdLists = new InputList<string>());
            set => _clientIdLists = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of resource tags for the IAM OIDC provider. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("thumbprintLists")]
        private InputList<string>? _thumbprintLists;
        public InputList<string> ThumbprintLists
        {
            get => _thumbprintLists ?? (_thumbprintLists = new InputList<string>());
            set => _thumbprintLists = value;
        }

        /// <summary>
        /// URL of the identity provider, corresponding to the `iss` claim.
        /// </summary>
        [Input("url", required: true)]
        public Input<string> Url { get; set; } = null!;

        public OpenIdConnectProviderArgs()
        {
        }
        public static new OpenIdConnectProviderArgs Empty => new OpenIdConnectProviderArgs();
    }

    public sealed class OpenIdConnectProviderState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN assigned by AWS for this provider.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("clientIdLists")]
        private InputList<string>? _clientIdLists;

        /// <summary>
        /// List of client IDs (audiences) that identify the application registered with the OpenID Connect provider. This is the value sent as the `client_id` parameter in OAuth requests.
        /// </summary>
        public InputList<string> ClientIdLists
        {
            get => _clientIdLists ?? (_clientIdLists = new InputList<string>());
            set => _clientIdLists = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of resource tags for the IAM OIDC provider. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        [Input("thumbprintLists")]
        private InputList<string>? _thumbprintLists;
        public InputList<string> ThumbprintLists
        {
            get => _thumbprintLists ?? (_thumbprintLists = new InputList<string>());
            set => _thumbprintLists = value;
        }

        /// <summary>
        /// URL of the identity provider, corresponding to the `iss` claim.
        /// </summary>
        [Input("url")]
        public Input<string>? Url { get; set; }

        public OpenIdConnectProviderState()
        {
        }
        public static new OpenIdConnectProviderState Empty => new OpenIdConnectProviderState();
    }
}
