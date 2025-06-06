// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeBuild
{
    /// <summary>
    /// Manages a CodeBuild webhook, which is an endpoint accepted by the CodeBuild service to trigger builds from source code repositories. Depending on the source type of the CodeBuild project, the CodeBuild service may also automatically create and delete the actual repository webhook as well.
    /// 
    /// ## Example Usage
    /// 
    /// ### Bitbucket and GitHub
    /// 
    /// When working with [Bitbucket](https://bitbucket.org) and [GitHub](https://github.com) source CodeBuild webhooks, the CodeBuild service will automatically create (on `aws.codebuild.Webhook` resource creation) and delete (on `aws.codebuild.Webhook` resource deletion) the Bitbucket/GitHub repository webhook using its granted OAuth permissions. This behavior cannot be controlled by this provider.
    /// 
    /// &gt; **Note:** The AWS account that this provider uses to create this resource *must* have authorized CodeBuild to access Bitbucket/GitHub's OAuth API in each applicable region. This is a manual step that must be done *before* creating webhooks with this resource. If OAuth is not configured, AWS will return an error similar to `ResourceNotFoundException: Could not find access token for server type github`. More information can be found in the CodeBuild User Guide for [Bitbucket](https://docs.aws.amazon.com/codebuild/latest/userguide/sample-bitbucket-pull-request.html) and [GitHub](https://docs.aws.amazon.com/codebuild/latest/userguide/sample-github-pull-request.html).
    /// 
    /// &gt; **Note:** Further managing the automatically created Bitbucket/GitHub webhook with the `bitbucket_hook`/`github_repository_webhook` resource is only possible with importing that resource after creation of the `aws.codebuild.Webhook` resource. The CodeBuild API does not ever provide the `secret` attribute for the `aws.codebuild.Webhook` resource in this scenario.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.CodeBuild.Webhook("example", new()
    ///     {
    ///         ProjectName = exampleAwsCodebuildProject.Name,
    ///         BuildType = "BUILD",
    ///         FilterGroups = new[]
    ///         {
    ///             new Aws.CodeBuild.Inputs.WebhookFilterGroupArgs
    ///             {
    ///                 Filters = new[]
    ///                 {
    ///                     new Aws.CodeBuild.Inputs.WebhookFilterGroupFilterArgs
    ///                     {
    ///                         Type = "EVENT",
    ///                         Pattern = "PUSH",
    ///                     },
    ///                     new Aws.CodeBuild.Inputs.WebhookFilterGroupFilterArgs
    ///                     {
    ///                         Type = "BASE_REF",
    ///                         Pattern = "master",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import CodeBuild Webhooks using the CodeBuild Project name. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:codebuild/webhook:Webhook example MyProjectName
    /// ```
    /// </summary>
    [AwsResourceType("aws:codebuild/webhook:Webhook")]
    public partial class Webhook : global::Pulumi.CustomResource
    {
        /// <summary>
        /// A regular expression used to determine which branches get built. Default is all branches are built. We recommend using `filter_group` over `branch_filter`.
        /// </summary>
        [Output("branchFilter")]
        public Output<string?> BranchFilter { get; private set; } = null!;

        /// <summary>
        /// The type of build this webhook will trigger. Valid values for this parameter are: `BUILD`, `BUILD_BATCH`.
        /// </summary>
        [Output("buildType")]
        public Output<string?> BuildType { get; private set; } = null!;

        /// <summary>
        /// Information about the webhook's trigger. Filter group blocks are documented below.
        /// </summary>
        [Output("filterGroups")]
        public Output<ImmutableArray<Outputs.WebhookFilterGroup>> FilterGroups { get; private set; } = null!;

        /// <summary>
        /// If true, CodeBuild doesn't create a webhook in GitHub and instead returns `payload_url` and `secret` values for the webhook. The `payload_url` and `secret` values in the output can be used to manually create a webhook within GitHub.
        /// </summary>
        [Output("manualCreation")]
        public Output<bool?> ManualCreation { get; private set; } = null!;

        /// <summary>
        /// The CodeBuild endpoint where webhook events are sent.
        /// </summary>
        [Output("payloadUrl")]
        public Output<string> PayloadUrl { get; private set; } = null!;

        /// <summary>
        /// The name of the build project.
        /// </summary>
        [Output("projectName")]
        public Output<string> ProjectName { get; private set; } = null!;

        /// <summary>
        /// Scope configuration for global or organization webhooks. Scope configuration blocks are documented below.
        /// </summary>
        [Output("scopeConfiguration")]
        public Output<Outputs.WebhookScopeConfiguration?> ScopeConfiguration { get; private set; } = null!;

        /// <summary>
        /// The secret token of the associated repository. Not returned by the CodeBuild API for all source types.
        /// </summary>
        [Output("secret")]
        public Output<string> Secret { get; private set; } = null!;

        /// <summary>
        /// The URL to the webhook.
        /// </summary>
        [Output("url")]
        public Output<string> Url { get; private set; } = null!;


        /// <summary>
        /// Create a Webhook resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Webhook(string name, WebhookArgs args, CustomResourceOptions? options = null)
            : base("aws:codebuild/webhook:Webhook", name, args ?? new WebhookArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Webhook(string name, Input<string> id, WebhookState? state = null, CustomResourceOptions? options = null)
            : base("aws:codebuild/webhook:Webhook", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "secret",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing Webhook resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Webhook Get(string name, Input<string> id, WebhookState? state = null, CustomResourceOptions? options = null)
        {
            return new Webhook(name, id, state, options);
        }
    }

    public sealed class WebhookArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A regular expression used to determine which branches get built. Default is all branches are built. We recommend using `filter_group` over `branch_filter`.
        /// </summary>
        [Input("branchFilter")]
        public Input<string>? BranchFilter { get; set; }

        /// <summary>
        /// The type of build this webhook will trigger. Valid values for this parameter are: `BUILD`, `BUILD_BATCH`.
        /// </summary>
        [Input("buildType")]
        public Input<string>? BuildType { get; set; }

        [Input("filterGroups")]
        private InputList<Inputs.WebhookFilterGroupArgs>? _filterGroups;

        /// <summary>
        /// Information about the webhook's trigger. Filter group blocks are documented below.
        /// </summary>
        public InputList<Inputs.WebhookFilterGroupArgs> FilterGroups
        {
            get => _filterGroups ?? (_filterGroups = new InputList<Inputs.WebhookFilterGroupArgs>());
            set => _filterGroups = value;
        }

        /// <summary>
        /// If true, CodeBuild doesn't create a webhook in GitHub and instead returns `payload_url` and `secret` values for the webhook. The `payload_url` and `secret` values in the output can be used to manually create a webhook within GitHub.
        /// </summary>
        [Input("manualCreation")]
        public Input<bool>? ManualCreation { get; set; }

        /// <summary>
        /// The name of the build project.
        /// </summary>
        [Input("projectName", required: true)]
        public Input<string> ProjectName { get; set; } = null!;

        /// <summary>
        /// Scope configuration for global or organization webhooks. Scope configuration blocks are documented below.
        /// </summary>
        [Input("scopeConfiguration")]
        public Input<Inputs.WebhookScopeConfigurationArgs>? ScopeConfiguration { get; set; }

        public WebhookArgs()
        {
        }
        public static new WebhookArgs Empty => new WebhookArgs();
    }

    public sealed class WebhookState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A regular expression used to determine which branches get built. Default is all branches are built. We recommend using `filter_group` over `branch_filter`.
        /// </summary>
        [Input("branchFilter")]
        public Input<string>? BranchFilter { get; set; }

        /// <summary>
        /// The type of build this webhook will trigger. Valid values for this parameter are: `BUILD`, `BUILD_BATCH`.
        /// </summary>
        [Input("buildType")]
        public Input<string>? BuildType { get; set; }

        [Input("filterGroups")]
        private InputList<Inputs.WebhookFilterGroupGetArgs>? _filterGroups;

        /// <summary>
        /// Information about the webhook's trigger. Filter group blocks are documented below.
        /// </summary>
        public InputList<Inputs.WebhookFilterGroupGetArgs> FilterGroups
        {
            get => _filterGroups ?? (_filterGroups = new InputList<Inputs.WebhookFilterGroupGetArgs>());
            set => _filterGroups = value;
        }

        /// <summary>
        /// If true, CodeBuild doesn't create a webhook in GitHub and instead returns `payload_url` and `secret` values for the webhook. The `payload_url` and `secret` values in the output can be used to manually create a webhook within GitHub.
        /// </summary>
        [Input("manualCreation")]
        public Input<bool>? ManualCreation { get; set; }

        /// <summary>
        /// The CodeBuild endpoint where webhook events are sent.
        /// </summary>
        [Input("payloadUrl")]
        public Input<string>? PayloadUrl { get; set; }

        /// <summary>
        /// The name of the build project.
        /// </summary>
        [Input("projectName")]
        public Input<string>? ProjectName { get; set; }

        /// <summary>
        /// Scope configuration for global or organization webhooks. Scope configuration blocks are documented below.
        /// </summary>
        [Input("scopeConfiguration")]
        public Input<Inputs.WebhookScopeConfigurationGetArgs>? ScopeConfiguration { get; set; }

        [Input("secret")]
        private Input<string>? _secret;

        /// <summary>
        /// The secret token of the associated repository. Not returned by the CodeBuild API for all source types.
        /// </summary>
        public Input<string>? Secret
        {
            get => _secret;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _secret = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// The URL to the webhook.
        /// </summary>
        [Input("url")]
        public Input<string>? Url { get; set; }

        public WebhookState()
        {
        }
        public static new WebhookState Empty => new WebhookState();
    }
}
