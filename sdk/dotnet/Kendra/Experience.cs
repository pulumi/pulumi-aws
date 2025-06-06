// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kendra
{
    /// <summary>
    /// Resource for managing an AWS Kendra Experience.
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
    ///     var example = new Aws.Kendra.Experience("example", new()
    ///     {
    ///         IndexId = exampleAwsKendraIndex.Id,
    ///         Description = "My Kendra Experience",
    ///         Name = "example",
    ///         RoleArn = exampleAwsIamRole.Arn,
    ///         Configuration = new Aws.Kendra.Inputs.ExperienceConfigurationArgs
    ///         {
    ///             ContentSourceConfiguration = new Aws.Kendra.Inputs.ExperienceConfigurationContentSourceConfigurationArgs
    ///             {
    ///                 DirectPutContent = true,
    ///                 FaqIds = new[]
    ///                 {
    ///                     exampleAwsKendraFaq.FaqId,
    ///                 },
    ///             },
    ///             UserIdentityConfiguration = new Aws.Kendra.Inputs.ExperienceConfigurationUserIdentityConfigurationArgs
    ///             {
    ///                 IdentityAttributeName = "12345ec453-1546651e-79c4-4554-91fa-00b43ccfa245",
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Kendra Experience using the unique identifiers of the experience and index separated by a slash (`/`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:kendra/experience:Experience example 1045d08d-66ef-4882-b3ed-dfb7df183e90/b34dfdf7-1f2b-4704-9581-79e00296845f
    /// ```
    /// </summary>
    [AwsResourceType("aws:kendra/experience:Experience")]
    public partial class Experience : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the Experience.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Configuration information for your Amazon Kendra experience. The provider will only perform drift detection of its value when present in a configuration. Detailed below.
        /// 
        /// &gt; **NOTE:** By default of the AWS Kendra API, updates to an existing `aws.kendra.Experience` resource (e.g. updating the `name`) will also update the `configuration.content_source_configuration.direct_put_content` parameter to `false` if not already provided.
        /// </summary>
        [Output("configuration")]
        public Output<Outputs.ExperienceConfiguration> Configuration { get; private set; } = null!;

        /// <summary>
        /// A description for your Amazon Kendra experience.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Shows the endpoint URLs for your Amazon Kendra experiences. The URLs are unique and fully hosted by AWS.
        /// </summary>
        [Output("endpoints")]
        public Output<ImmutableArray<Outputs.ExperienceEndpoint>> Endpoints { get; private set; } = null!;

        /// <summary>
        /// The unique identifier of the experience.
        /// </summary>
        [Output("experienceId")]
        public Output<string> ExperienceId { get; private set; } = null!;

        /// <summary>
        /// The identifier of the index for your Amazon Kendra experience.
        /// </summary>
        [Output("indexId")]
        public Output<string> IndexId { get; private set; } = null!;

        /// <summary>
        /// A name for your Amazon Kendra experience.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of a role with permission to access `Query API`, `QuerySuggestions API`, `SubmitFeedback API`, and `AWS SSO` that stores your user and group information. For more information, see [IAM roles for Amazon Kendra](https://docs.aws.amazon.com/kendra/latest/dg/iam-roles.html).
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("roleArn")]
        public Output<string> RoleArn { get; private set; } = null!;

        /// <summary>
        /// The current processing status of your Amazon Kendra experience.
        /// </summary>
        [Output("status")]
        public Output<string> Status { get; private set; } = null!;


        /// <summary>
        /// Create a Experience resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Experience(string name, ExperienceArgs args, CustomResourceOptions? options = null)
            : base("aws:kendra/experience:Experience", name, args ?? new ExperienceArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Experience(string name, Input<string> id, ExperienceState? state = null, CustomResourceOptions? options = null)
            : base("aws:kendra/experience:Experience", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Experience resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Experience Get(string name, Input<string> id, ExperienceState? state = null, CustomResourceOptions? options = null)
        {
            return new Experience(name, id, state, options);
        }
    }

    public sealed class ExperienceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration information for your Amazon Kendra experience. The provider will only perform drift detection of its value when present in a configuration. Detailed below.
        /// 
        /// &gt; **NOTE:** By default of the AWS Kendra API, updates to an existing `aws.kendra.Experience` resource (e.g. updating the `name`) will also update the `configuration.content_source_configuration.direct_put_content` parameter to `false` if not already provided.
        /// </summary>
        [Input("configuration")]
        public Input<Inputs.ExperienceConfigurationArgs>? Configuration { get; set; }

        /// <summary>
        /// A description for your Amazon Kendra experience.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The identifier of the index for your Amazon Kendra experience.
        /// </summary>
        [Input("indexId", required: true)]
        public Input<string> IndexId { get; set; } = null!;

        /// <summary>
        /// A name for your Amazon Kendra experience.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of a role with permission to access `Query API`, `QuerySuggestions API`, `SubmitFeedback API`, and `AWS SSO` that stores your user and group information. For more information, see [IAM roles for Amazon Kendra](https://docs.aws.amazon.com/kendra/latest/dg/iam-roles.html).
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

        public ExperienceArgs()
        {
        }
        public static new ExperienceArgs Empty => new ExperienceArgs();
    }

    public sealed class ExperienceState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the Experience.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Configuration information for your Amazon Kendra experience. The provider will only perform drift detection of its value when present in a configuration. Detailed below.
        /// 
        /// &gt; **NOTE:** By default of the AWS Kendra API, updates to an existing `aws.kendra.Experience` resource (e.g. updating the `name`) will also update the `configuration.content_source_configuration.direct_put_content` parameter to `false` if not already provided.
        /// </summary>
        [Input("configuration")]
        public Input<Inputs.ExperienceConfigurationGetArgs>? Configuration { get; set; }

        /// <summary>
        /// A description for your Amazon Kendra experience.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("endpoints")]
        private InputList<Inputs.ExperienceEndpointGetArgs>? _endpoints;

        /// <summary>
        /// Shows the endpoint URLs for your Amazon Kendra experiences. The URLs are unique and fully hosted by AWS.
        /// </summary>
        public InputList<Inputs.ExperienceEndpointGetArgs> Endpoints
        {
            get => _endpoints ?? (_endpoints = new InputList<Inputs.ExperienceEndpointGetArgs>());
            set => _endpoints = value;
        }

        /// <summary>
        /// The unique identifier of the experience.
        /// </summary>
        [Input("experienceId")]
        public Input<string>? ExperienceId { get; set; }

        /// <summary>
        /// The identifier of the index for your Amazon Kendra experience.
        /// </summary>
        [Input("indexId")]
        public Input<string>? IndexId { get; set; }

        /// <summary>
        /// A name for your Amazon Kendra experience.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of a role with permission to access `Query API`, `QuerySuggestions API`, `SubmitFeedback API`, and `AWS SSO` that stores your user and group information. For more information, see [IAM roles for Amazon Kendra](https://docs.aws.amazon.com/kendra/latest/dg/iam-roles.html).
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("roleArn")]
        public Input<string>? RoleArn { get; set; }

        /// <summary>
        /// The current processing status of your Amazon Kendra experience.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        public ExperienceState()
        {
        }
        public static new ExperienceState Empty => new ExperienceState();
    }
}
