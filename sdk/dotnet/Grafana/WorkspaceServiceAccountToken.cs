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
    ///     var example = new Aws.Grafana.WorkspaceServiceAccount("example", new()
    ///     {
    ///         Name = "example-admin",
    ///         GrafanaRole = "ADMIN",
    ///         WorkspaceId = exampleAwsGrafanaWorkspace.Id,
    ///     });
    /// 
    ///     var exampleWorkspaceServiceAccountToken = new Aws.Grafana.WorkspaceServiceAccountToken("example", new()
    ///     {
    ///         Name = "example-key",
    ///         ServiceAccountId = example.ServiceAccountId,
    ///         SecondsToLive = 3600,
    ///         WorkspaceId = exampleAwsGrafanaWorkspace.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:grafana/workspaceServiceAccountToken:WorkspaceServiceAccountToken")]
    public partial class WorkspaceServiceAccountToken : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Specifies when the service account token was created.
        /// </summary>
        [Output("createdAt")]
        public Output<string> CreatedAt { get; private set; } = null!;

        /// <summary>
        /// Specifies when the service account token will expire.
        /// </summary>
        [Output("expiresAt")]
        public Output<string> ExpiresAt { get; private set; } = null!;

        /// <summary>
        /// The key for the service account token. Used when making calls to the Grafana HTTP APIs to authenticate and authorize the requests.
        /// </summary>
        [Output("key")]
        public Output<string> Key { get; private set; } = null!;

        /// <summary>
        /// A name for the token to create. The name must be unique within the workspace.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Sets how long the token will be valid, in seconds. You can set the time up to 30 days in the future.
        /// </summary>
        [Output("secondsToLive")]
        public Output<int> SecondsToLive { get; private set; } = null!;

        /// <summary>
        /// The ID of the service account for which to create a token.
        /// </summary>
        [Output("serviceAccountId")]
        public Output<string> ServiceAccountId { get; private set; } = null!;

        /// <summary>
        /// Identifier of the service account token in the given Grafana workspace.
        /// </summary>
        [Output("serviceAccountTokenId")]
        public Output<string> ServiceAccountTokenId { get; private set; } = null!;

        /// <summary>
        /// The Grafana workspace with which the service account token is associated.
        /// </summary>
        [Output("workspaceId")]
        public Output<string> WorkspaceId { get; private set; } = null!;


        /// <summary>
        /// Create a WorkspaceServiceAccountToken resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public WorkspaceServiceAccountToken(string name, WorkspaceServiceAccountTokenArgs args, CustomResourceOptions? options = null)
            : base("aws:grafana/workspaceServiceAccountToken:WorkspaceServiceAccountToken", name, args ?? new WorkspaceServiceAccountTokenArgs(), MakeResourceOptions(options, ""))
        {
        }

        private WorkspaceServiceAccountToken(string name, Input<string> id, WorkspaceServiceAccountTokenState? state = null, CustomResourceOptions? options = null)
            : base("aws:grafana/workspaceServiceAccountToken:WorkspaceServiceAccountToken", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "key",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing WorkspaceServiceAccountToken resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static WorkspaceServiceAccountToken Get(string name, Input<string> id, WorkspaceServiceAccountTokenState? state = null, CustomResourceOptions? options = null)
        {
            return new WorkspaceServiceAccountToken(name, id, state, options);
        }
    }

    public sealed class WorkspaceServiceAccountTokenArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A name for the token to create. The name must be unique within the workspace.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Sets how long the token will be valid, in seconds. You can set the time up to 30 days in the future.
        /// </summary>
        [Input("secondsToLive", required: true)]
        public Input<int> SecondsToLive { get; set; } = null!;

        /// <summary>
        /// The ID of the service account for which to create a token.
        /// </summary>
        [Input("serviceAccountId", required: true)]
        public Input<string> ServiceAccountId { get; set; } = null!;

        /// <summary>
        /// The Grafana workspace with which the service account token is associated.
        /// </summary>
        [Input("workspaceId", required: true)]
        public Input<string> WorkspaceId { get; set; } = null!;

        public WorkspaceServiceAccountTokenArgs()
        {
        }
        public static new WorkspaceServiceAccountTokenArgs Empty => new WorkspaceServiceAccountTokenArgs();
    }

    public sealed class WorkspaceServiceAccountTokenState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies when the service account token was created.
        /// </summary>
        [Input("createdAt")]
        public Input<string>? CreatedAt { get; set; }

        /// <summary>
        /// Specifies when the service account token will expire.
        /// </summary>
        [Input("expiresAt")]
        public Input<string>? ExpiresAt { get; set; }

        [Input("key")]
        private Input<string>? _key;

        /// <summary>
        /// The key for the service account token. Used when making calls to the Grafana HTTP APIs to authenticate and authorize the requests.
        /// </summary>
        public Input<string>? Key
        {
            get => _key;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _key = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// A name for the token to create. The name must be unique within the workspace.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Sets how long the token will be valid, in seconds. You can set the time up to 30 days in the future.
        /// </summary>
        [Input("secondsToLive")]
        public Input<int>? SecondsToLive { get; set; }

        /// <summary>
        /// The ID of the service account for which to create a token.
        /// </summary>
        [Input("serviceAccountId")]
        public Input<string>? ServiceAccountId { get; set; }

        /// <summary>
        /// Identifier of the service account token in the given Grafana workspace.
        /// </summary>
        [Input("serviceAccountTokenId")]
        public Input<string>? ServiceAccountTokenId { get; set; }

        /// <summary>
        /// The Grafana workspace with which the service account token is associated.
        /// </summary>
        [Input("workspaceId")]
        public Input<string>? WorkspaceId { get; set; }

        public WorkspaceServiceAccountTokenState()
        {
        }
        public static new WorkspaceServiceAccountTokenState Empty => new WorkspaceServiceAccountTokenState();
    }
}
