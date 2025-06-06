// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Amplify
{
    /// <summary>
    /// Provides an Amplify Branch resource.
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
    ///     var example = new Aws.Amplify.App("example", new()
    ///     {
    ///         Name = "app",
    ///     });
    /// 
    ///     var master = new Aws.Amplify.Branch("master", new()
    ///     {
    ///         AppId = example.Id,
    ///         BranchName = "master",
    ///         Framework = "React",
    ///         Stage = "PRODUCTION",
    ///         EnvironmentVariables = 
    ///         {
    ///             { "REACT_APP_API_SERVER", "https://api.example.com" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Basic Authentication
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// using Std = Pulumi.Std;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Amplify.App("example", new()
    ///     {
    ///         Name = "app",
    ///     });
    /// 
    ///     var master = new Aws.Amplify.Branch("master", new()
    ///     {
    ///         AppId = example.Id,
    ///         BranchName = "master",
    ///         EnableBasicAuth = true,
    ///         BasicAuthCredentials = Std.Base64encode.Invoke(new()
    ///         {
    ///             Input = "username:password",
    ///         }).Apply(invoke =&gt; invoke.Result),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Notifications
    /// 
    /// Amplify Console uses EventBridge (formerly known as CloudWatch Events) and SNS for email notifications.  To implement the same functionality, you need to set `enable_notification` in a `aws.amplify.Branch` resource, as well as creating an EventBridge Rule, an SNS topic, and SNS subscriptions.
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
    ///     var example = new Aws.Amplify.App("example", new()
    ///     {
    ///         Name = "app",
    ///     });
    /// 
    ///     var master = new Aws.Amplify.Branch("master", new()
    ///     {
    ///         AppId = example.Id,
    ///         BranchName = "master",
    ///         EnableNotification = true,
    ///     });
    /// 
    ///     // EventBridge Rule for Amplify notifications
    ///     var amplifyAppMasterEventRule = new Aws.CloudWatch.EventRule("amplify_app_master", new()
    ///     {
    ///         Name = master.BranchName.Apply(branchName =&gt; $"amplify-{app.Id}-{branchName}-branch-notification"),
    ///         Description = master.BranchName.Apply(branchName =&gt; $"AWS Amplify build notifications for :  App: {app.Id} Branch: {branchName}"),
    ///         EventPattern = Output.JsonSerialize(Output.Create(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["detail"] = new Dictionary&lt;string, object?&gt;
    ///             {
    ///                 ["appId"] = new[]
    ///                 {
    ///                     example.Id,
    ///                 },
    ///                 ["branchName"] = new[]
    ///                 {
    ///                     master.BranchName,
    ///                 },
    ///                 ["jobStatus"] = new[]
    ///                 {
    ///                     "SUCCEED",
    ///                     "FAILED",
    ///                     "STARTED",
    ///                 },
    ///             },
    ///             ["detail-type"] = new[]
    ///             {
    ///                 "Amplify Deployment Status Change",
    ///             },
    ///             ["source"] = new[]
    ///             {
    ///                 "aws.amplify",
    ///             },
    ///         })),
    ///     });
    /// 
    ///     // SNS Topic for Amplify notifications
    ///     var amplifyAppMasterTopic = new Aws.Sns.Topic("amplify_app_master", new()
    ///     {
    ///         Name = master.BranchName.Apply(branchName =&gt; $"amplify-{app.Id}_{branchName}"),
    ///     });
    /// 
    ///     var amplifyAppMasterEventTarget = new Aws.CloudWatch.EventTarget("amplify_app_master", new()
    ///     {
    ///         Rule = amplifyAppMasterEventRule.Name,
    ///         TargetId = master.BranchName,
    ///         Arn = amplifyAppMasterTopic.Arn,
    ///         InputTransformer = new Aws.CloudWatch.Inputs.EventTargetInputTransformerArgs
    ///         {
    ///             InputPaths = 
    ///             {
    ///                 { "jobId", "$.detail.jobId" },
    ///                 { "appId", "$.detail.appId" },
    ///                 { "region", "$.region" },
    ///                 { "branch", "$.detail.branchName" },
    ///                 { "status", "$.detail.jobStatus" },
    ///             },
    ///             InputTemplate = "\"Build notification from the AWS Amplify Console for app: https://&lt;branch&gt;.&lt;appId&gt;.amplifyapp.com/. Your build status is &lt;status&gt;. Go to https://console.aws.amazon.com/amplify/home?region=&lt;region&gt;#&lt;appId&gt;/&lt;branch&gt;/&lt;jobId&gt; to view details on your build. \"",
    ///         },
    ///     });
    /// 
    ///     var amplifyAppMaster = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Sid = $"Allow_Publish_Events {master.Arn}",
    ///                 Effect = "Allow",
    ///                 Actions = new[]
    ///                 {
    ///                     "SNS:Publish",
    ///                 },
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "events.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     amplifyAppMasterTopic.Arn,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var amplifyAppMasterTopicPolicy = new Aws.Sns.TopicPolicy("amplify_app_master", new()
    ///     {
    ///         Arn = amplifyAppMasterTopic.Arn,
    ///         Policy = amplifyAppMaster.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var @this = new Aws.Sns.TopicSubscription("this", new()
    ///     {
    ///         Topic = amplifyAppMasterTopic.Arn,
    ///         Protocol = "email",
    ///         Endpoint = "user@acme.com",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Amplify branch using `app_id` and `branch_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:amplify/branch:Branch master d2ypk4k47z8u6/master
    /// ```
    /// </summary>
    [AwsResourceType("aws:amplify/branch:Branch")]
    public partial class Branch : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Unique ID for an Amplify app.
        /// </summary>
        [Output("appId")]
        public Output<string> AppId { get; private set; } = null!;

        /// <summary>
        /// ARN for the branch.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// A list of custom resources that are linked to this branch.
        /// </summary>
        [Output("associatedResources")]
        public Output<ImmutableArray<string>> AssociatedResources { get; private set; } = null!;

        /// <summary>
        /// ARN for a backend environment that is part of an Amplify app.
        /// </summary>
        [Output("backendEnvironmentArn")]
        public Output<string?> BackendEnvironmentArn { get; private set; } = null!;

        /// <summary>
        /// Basic authorization credentials for the branch.
        /// </summary>
        [Output("basicAuthCredentials")]
        public Output<string?> BasicAuthCredentials { get; private set; } = null!;

        /// <summary>
        /// Name for the branch.
        /// </summary>
        [Output("branchName")]
        public Output<string> BranchName { get; private set; } = null!;

        /// <summary>
        /// Custom domains for the branch.
        /// </summary>
        [Output("customDomains")]
        public Output<ImmutableArray<string>> CustomDomains { get; private set; } = null!;

        /// <summary>
        /// Description for the branch.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Destination branch if the branch is a pull request branch.
        /// </summary>
        [Output("destinationBranch")]
        public Output<string> DestinationBranch { get; private set; } = null!;

        /// <summary>
        /// Display name for a branch. This is used as the default domain prefix.
        /// </summary>
        [Output("displayName")]
        public Output<string> DisplayName { get; private set; } = null!;

        /// <summary>
        /// Enables auto building for the branch.
        /// </summary>
        [Output("enableAutoBuild")]
        public Output<bool?> EnableAutoBuild { get; private set; } = null!;

        /// <summary>
        /// Enables basic authorization for the branch.
        /// </summary>
        [Output("enableBasicAuth")]
        public Output<bool?> EnableBasicAuth { get; private set; } = null!;

        /// <summary>
        /// Enables notifications for the branch.
        /// </summary>
        [Output("enableNotification")]
        public Output<bool?> EnableNotification { get; private set; } = null!;

        /// <summary>
        /// Enables performance mode for the branch.
        /// </summary>
        [Output("enablePerformanceMode")]
        public Output<bool?> EnablePerformanceMode { get; private set; } = null!;

        /// <summary>
        /// Enables pull request previews for this branch.
        /// </summary>
        [Output("enablePullRequestPreview")]
        public Output<bool?> EnablePullRequestPreview { get; private set; } = null!;

        /// <summary>
        /// Environment variables for the branch.
        /// </summary>
        [Output("environmentVariables")]
        public Output<ImmutableDictionary<string, string>?> EnvironmentVariables { get; private set; } = null!;

        /// <summary>
        /// Framework for the branch.
        /// </summary>
        [Output("framework")]
        public Output<string?> Framework { get; private set; } = null!;

        /// <summary>
        /// Amplify environment name for the pull request.
        /// </summary>
        [Output("pullRequestEnvironmentName")]
        public Output<string?> PullRequestEnvironmentName { get; private set; } = null!;

        /// <summary>
        /// Source branch if the branch is a pull request branch.
        /// </summary>
        [Output("sourceBranch")]
        public Output<string> SourceBranch { get; private set; } = null!;

        /// <summary>
        /// Describes the current stage for the branch. Valid values: `PRODUCTION`, `BETA`, `DEVELOPMENT`, `EXPERIMENTAL`, `PULL_REQUEST`.
        /// </summary>
        [Output("stage")]
        public Output<string?> Stage { get; private set; } = null!;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// Content Time To Live (TTL) for the website in seconds.
        /// </summary>
        [Output("ttl")]
        public Output<string?> Ttl { get; private set; } = null!;


        /// <summary>
        /// Create a Branch resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Branch(string name, BranchArgs args, CustomResourceOptions? options = null)
            : base("aws:amplify/branch:Branch", name, args ?? new BranchArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Branch(string name, Input<string> id, BranchState? state = null, CustomResourceOptions? options = null)
            : base("aws:amplify/branch:Branch", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "basicAuthCredentials",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing Branch resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Branch Get(string name, Input<string> id, BranchState? state = null, CustomResourceOptions? options = null)
        {
            return new Branch(name, id, state, options);
        }
    }

    public sealed class BranchArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Unique ID for an Amplify app.
        /// </summary>
        [Input("appId", required: true)]
        public Input<string> AppId { get; set; } = null!;

        /// <summary>
        /// ARN for a backend environment that is part of an Amplify app.
        /// </summary>
        [Input("backendEnvironmentArn")]
        public Input<string>? BackendEnvironmentArn { get; set; }

        [Input("basicAuthCredentials")]
        private Input<string>? _basicAuthCredentials;

        /// <summary>
        /// Basic authorization credentials for the branch.
        /// </summary>
        public Input<string>? BasicAuthCredentials
        {
            get => _basicAuthCredentials;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _basicAuthCredentials = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// Name for the branch.
        /// </summary>
        [Input("branchName", required: true)]
        public Input<string> BranchName { get; set; } = null!;

        /// <summary>
        /// Description for the branch.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Display name for a branch. This is used as the default domain prefix.
        /// </summary>
        [Input("displayName")]
        public Input<string>? DisplayName { get; set; }

        /// <summary>
        /// Enables auto building for the branch.
        /// </summary>
        [Input("enableAutoBuild")]
        public Input<bool>? EnableAutoBuild { get; set; }

        /// <summary>
        /// Enables basic authorization for the branch.
        /// </summary>
        [Input("enableBasicAuth")]
        public Input<bool>? EnableBasicAuth { get; set; }

        /// <summary>
        /// Enables notifications for the branch.
        /// </summary>
        [Input("enableNotification")]
        public Input<bool>? EnableNotification { get; set; }

        /// <summary>
        /// Enables performance mode for the branch.
        /// </summary>
        [Input("enablePerformanceMode")]
        public Input<bool>? EnablePerformanceMode { get; set; }

        /// <summary>
        /// Enables pull request previews for this branch.
        /// </summary>
        [Input("enablePullRequestPreview")]
        public Input<bool>? EnablePullRequestPreview { get; set; }

        [Input("environmentVariables")]
        private InputMap<string>? _environmentVariables;

        /// <summary>
        /// Environment variables for the branch.
        /// </summary>
        public InputMap<string> EnvironmentVariables
        {
            get => _environmentVariables ?? (_environmentVariables = new InputMap<string>());
            set => _environmentVariables = value;
        }

        /// <summary>
        /// Framework for the branch.
        /// </summary>
        [Input("framework")]
        public Input<string>? Framework { get; set; }

        /// <summary>
        /// Amplify environment name for the pull request.
        /// </summary>
        [Input("pullRequestEnvironmentName")]
        public Input<string>? PullRequestEnvironmentName { get; set; }

        /// <summary>
        /// Describes the current stage for the branch. Valid values: `PRODUCTION`, `BETA`, `DEVELOPMENT`, `EXPERIMENTAL`, `PULL_REQUEST`.
        /// </summary>
        [Input("stage")]
        public Input<string>? Stage { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// Content Time To Live (TTL) for the website in seconds.
        /// </summary>
        [Input("ttl")]
        public Input<string>? Ttl { get; set; }

        public BranchArgs()
        {
        }
        public static new BranchArgs Empty => new BranchArgs();
    }

    public sealed class BranchState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Unique ID for an Amplify app.
        /// </summary>
        [Input("appId")]
        public Input<string>? AppId { get; set; }

        /// <summary>
        /// ARN for the branch.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("associatedResources")]
        private InputList<string>? _associatedResources;

        /// <summary>
        /// A list of custom resources that are linked to this branch.
        /// </summary>
        public InputList<string> AssociatedResources
        {
            get => _associatedResources ?? (_associatedResources = new InputList<string>());
            set => _associatedResources = value;
        }

        /// <summary>
        /// ARN for a backend environment that is part of an Amplify app.
        /// </summary>
        [Input("backendEnvironmentArn")]
        public Input<string>? BackendEnvironmentArn { get; set; }

        [Input("basicAuthCredentials")]
        private Input<string>? _basicAuthCredentials;

        /// <summary>
        /// Basic authorization credentials for the branch.
        /// </summary>
        public Input<string>? BasicAuthCredentials
        {
            get => _basicAuthCredentials;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _basicAuthCredentials = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// Name for the branch.
        /// </summary>
        [Input("branchName")]
        public Input<string>? BranchName { get; set; }

        [Input("customDomains")]
        private InputList<string>? _customDomains;

        /// <summary>
        /// Custom domains for the branch.
        /// </summary>
        public InputList<string> CustomDomains
        {
            get => _customDomains ?? (_customDomains = new InputList<string>());
            set => _customDomains = value;
        }

        /// <summary>
        /// Description for the branch.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Destination branch if the branch is a pull request branch.
        /// </summary>
        [Input("destinationBranch")]
        public Input<string>? DestinationBranch { get; set; }

        /// <summary>
        /// Display name for a branch. This is used as the default domain prefix.
        /// </summary>
        [Input("displayName")]
        public Input<string>? DisplayName { get; set; }

        /// <summary>
        /// Enables auto building for the branch.
        /// </summary>
        [Input("enableAutoBuild")]
        public Input<bool>? EnableAutoBuild { get; set; }

        /// <summary>
        /// Enables basic authorization for the branch.
        /// </summary>
        [Input("enableBasicAuth")]
        public Input<bool>? EnableBasicAuth { get; set; }

        /// <summary>
        /// Enables notifications for the branch.
        /// </summary>
        [Input("enableNotification")]
        public Input<bool>? EnableNotification { get; set; }

        /// <summary>
        /// Enables performance mode for the branch.
        /// </summary>
        [Input("enablePerformanceMode")]
        public Input<bool>? EnablePerformanceMode { get; set; }

        /// <summary>
        /// Enables pull request previews for this branch.
        /// </summary>
        [Input("enablePullRequestPreview")]
        public Input<bool>? EnablePullRequestPreview { get; set; }

        [Input("environmentVariables")]
        private InputMap<string>? _environmentVariables;

        /// <summary>
        /// Environment variables for the branch.
        /// </summary>
        public InputMap<string> EnvironmentVariables
        {
            get => _environmentVariables ?? (_environmentVariables = new InputMap<string>());
            set => _environmentVariables = value;
        }

        /// <summary>
        /// Framework for the branch.
        /// </summary>
        [Input("framework")]
        public Input<string>? Framework { get; set; }

        /// <summary>
        /// Amplify environment name for the pull request.
        /// </summary>
        [Input("pullRequestEnvironmentName")]
        public Input<string>? PullRequestEnvironmentName { get; set; }

        /// <summary>
        /// Source branch if the branch is a pull request branch.
        /// </summary>
        [Input("sourceBranch")]
        public Input<string>? SourceBranch { get; set; }

        /// <summary>
        /// Describes the current stage for the branch. Valid values: `PRODUCTION`, `BETA`, `DEVELOPMENT`, `EXPERIMENTAL`, `PULL_REQUEST`.
        /// </summary>
        [Input("stage")]
        public Input<string>? Stage { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        /// <summary>
        /// Content Time To Live (TTL) for the website in seconds.
        /// </summary>
        [Input("ttl")]
        public Input<string>? Ttl { get; set; }

        public BranchState()
        {
        }
        public static new BranchState Empty => new BranchState();
    }
}
