// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Inspector
{
    /// <summary>
    /// Provides an Inspector Classic Assessment Template
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
    ///     var example = new Aws.Inspector.AssessmentTemplate("example", new()
    ///     {
    ///         Name = "example",
    ///         TargetArn = exampleAwsInspectorAssessmentTarget.Arn,
    ///         Duration = 3600,
    ///         RulesPackageArns = new[]
    ///         {
    ///             "arn:aws:inspector:us-west-2:758058086616:rulespackage/0-9hgA516p",
    ///             "arn:aws:inspector:us-west-2:758058086616:rulespackage/0-H5hpSawc",
    ///             "arn:aws:inspector:us-west-2:758058086616:rulespackage/0-JJOtZiqQ",
    ///             "arn:aws:inspector:us-west-2:758058086616:rulespackage/0-vg5GGHSD",
    ///         },
    ///         EventSubscriptions = new[]
    ///         {
    ///             new Aws.Inspector.Inputs.AssessmentTemplateEventSubscriptionArgs
    ///             {
    ///                 Event = "ASSESSMENT_RUN_COMPLETED",
    ///                 TopicArn = exampleAwsSnsTopic.Arn,
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_inspector_assessment_template` using the template assessment ARN. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:inspector/assessmentTemplate:AssessmentTemplate example arn:aws:inspector:us-west-2:123456789012:target/0-9IaAzhGR/template/0-WEcjR8CH
    /// ```
    /// </summary>
    [AwsResourceType("aws:inspector/assessmentTemplate:AssessmentTemplate")]
    public partial class AssessmentTemplate : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The template assessment ARN.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The duration of the inspector run.
        /// </summary>
        [Output("duration")]
        public Output<int> Duration { get; private set; } = null!;

        /// <summary>
        /// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
        /// </summary>
        [Output("eventSubscriptions")]
        public Output<ImmutableArray<Outputs.AssessmentTemplateEventSubscription>> EventSubscriptions { get; private set; } = null!;

        /// <summary>
        /// The name of the assessment template.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The rules to be used during the run.
        /// </summary>
        [Output("rulesPackageArns")]
        public Output<ImmutableArray<string>> RulesPackageArns { get; private set; } = null!;

        /// <summary>
        /// Key-value map of tags for the Inspector assessment template. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The assessment target ARN to attach the template to.
        /// </summary>
        [Output("targetArn")]
        public Output<string> TargetArn { get; private set; } = null!;


        /// <summary>
        /// Create a AssessmentTemplate resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public AssessmentTemplate(string name, AssessmentTemplateArgs args, CustomResourceOptions? options = null)
            : base("aws:inspector/assessmentTemplate:AssessmentTemplate", name, args ?? new AssessmentTemplateArgs(), MakeResourceOptions(options, ""))
        {
        }

        private AssessmentTemplate(string name, Input<string> id, AssessmentTemplateState? state = null, CustomResourceOptions? options = null)
            : base("aws:inspector/assessmentTemplate:AssessmentTemplate", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing AssessmentTemplate resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static AssessmentTemplate Get(string name, Input<string> id, AssessmentTemplateState? state = null, CustomResourceOptions? options = null)
        {
            return new AssessmentTemplate(name, id, state, options);
        }
    }

    public sealed class AssessmentTemplateArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The duration of the inspector run.
        /// </summary>
        [Input("duration", required: true)]
        public Input<int> Duration { get; set; } = null!;

        [Input("eventSubscriptions")]
        private InputList<Inputs.AssessmentTemplateEventSubscriptionArgs>? _eventSubscriptions;

        /// <summary>
        /// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
        /// </summary>
        public InputList<Inputs.AssessmentTemplateEventSubscriptionArgs> EventSubscriptions
        {
            get => _eventSubscriptions ?? (_eventSubscriptions = new InputList<Inputs.AssessmentTemplateEventSubscriptionArgs>());
            set => _eventSubscriptions = value;
        }

        /// <summary>
        /// The name of the assessment template.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("rulesPackageArns", required: true)]
        private InputList<string>? _rulesPackageArns;

        /// <summary>
        /// The rules to be used during the run.
        /// </summary>
        public InputList<string> RulesPackageArns
        {
            get => _rulesPackageArns ?? (_rulesPackageArns = new InputList<string>());
            set => _rulesPackageArns = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of tags for the Inspector assessment template. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The assessment target ARN to attach the template to.
        /// </summary>
        [Input("targetArn", required: true)]
        public Input<string> TargetArn { get; set; } = null!;

        public AssessmentTemplateArgs()
        {
        }
        public static new AssessmentTemplateArgs Empty => new AssessmentTemplateArgs();
    }

    public sealed class AssessmentTemplateState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The template assessment ARN.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The duration of the inspector run.
        /// </summary>
        [Input("duration")]
        public Input<int>? Duration { get; set; }

        [Input("eventSubscriptions")]
        private InputList<Inputs.AssessmentTemplateEventSubscriptionGetArgs>? _eventSubscriptions;

        /// <summary>
        /// A block that enables sending notifications about a specified assessment template event to a designated SNS topic. See Event Subscriptions for details.
        /// </summary>
        public InputList<Inputs.AssessmentTemplateEventSubscriptionGetArgs> EventSubscriptions
        {
            get => _eventSubscriptions ?? (_eventSubscriptions = new InputList<Inputs.AssessmentTemplateEventSubscriptionGetArgs>());
            set => _eventSubscriptions = value;
        }

        /// <summary>
        /// The name of the assessment template.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("rulesPackageArns")]
        private InputList<string>? _rulesPackageArns;

        /// <summary>
        /// The rules to be used during the run.
        /// </summary>
        public InputList<string> RulesPackageArns
        {
            get => _rulesPackageArns ?? (_rulesPackageArns = new InputList<string>());
            set => _rulesPackageArns = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of tags for the Inspector assessment template. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        /// <summary>
        /// The assessment target ARN to attach the template to.
        /// </summary>
        [Input("targetArn")]
        public Input<string>? TargetArn { get; set; }

        public AssessmentTemplateState()
        {
        }
        public static new AssessmentTemplateState Empty => new AssessmentTemplateState();
    }
}
